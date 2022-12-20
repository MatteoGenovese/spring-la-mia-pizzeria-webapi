<template>
  <div class="home">

    Pizza List:

    <br>
    <br>

    <div v-for="pizza in pizzaList"  :key="pizza.id" >

      <ul>

        <li v-if="selectedElementId == pizza.id">


          <form @submit="updateElementAPI">
            <label for="name">Name</label>
            <input type="text" name="name" v-model="pizza.name">
            <br> 

            <input type="submit" value="UPDATE">
            <button @click="updateElement(EDIT_ID_DEFAULT)">CANCEL</button>
          </form>


            <button @click="updateElement(pizza.id, pizza.name)">update</button>
        </li>

        <li v-else>
          {{ pizza.name }}
          <button @click="changeSelectedID(pizza.id)">edit</button>
        </li>


      </ul>






      
    </div>


    
  </div>
</template>

<script>
// @ is an alias to /src

import axios from 'axios';


export default {
  name: "HomeView",
  components: {
  },
  methods: {
    searchPizzaList(needle) {
      axios.get(`${this.apiURL}pizza/all`)
        .then((result) => {
          console.log(result.data)
          this.pizzaList = result.data;
          
        })
        .catch((error) => {
          console.warn(error);
        })
    },
    changeSelectedID(needle) {
      this.selectedElementId=needle;
    },
    updateElement(needle, pizzaName){
      this.selectedElementId=-1;
    },
    updateElementAPI(needle) {

      console.log(needle);

    },

  },
  data: function () {
    return {

      apiURL: 'http://localhost:8080/api/',
      selectedElementId : -1,
      EDIT_ID_DEFAULT :-1,
      pizzaList: [],
    }
  },
  mounted(){
    this.searchPizzaList();
  }
  
};
</script>
