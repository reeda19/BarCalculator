const FIND_ALL_DRINKS  = "http://localhost:8080/findAllDrinks"
const FIND_DRINK_BY_ID = "http://localhost:8080/findDrinkById"
const CREATE_DRINK_URL = "http://localhost:8080/addDrink"
const DELETE_DRINK_URL = "http://localhost:8080/removeDrink"
const UPDATE_DRINK     = "http://localhost:8080/updateDrink"

const findAllDrinks = () =>
    fetch(`${FIND_ALL_DRINKS}`)
    .then(response => response.json())

const findDrinkById = (drinkId) =>
    fetch(`${FIND_DRINK_BY_ID}/${drinkId}`)
    .then(response => response.json())

const createDrink = (drink) =>
    fetch(`${CREATE_DRINK_URL}`)
    .then(response => response.json())

const deleteDrink = (drinkId) =>
    fetch(`${DELETE_DRINK_URL}/${drinkId}`)

const updateDrinkName = (drink) =>
    fetch(`${UPDATE_DRINK}/${drink.drinkId}/name/${drink.name}`)
    .then(response => response.json())



