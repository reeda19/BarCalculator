
const ADD_DRINK_URL = "http://localhost:8080/addDrink"
const REMOVE_DRINK_URL = "http://localhost:8080/removeDrink"
const FIND_ALL_URL = "http://localhost:8080/findAllMappings"


const findAllMappings = () =>
    fetch(`${FIND_ALL_URL}`)
    .then(response => response.json())


const addDrinkToPerson = (pid,did) =>
    fetch(`${ADD_DRINK_URL}/${did}/ToPerson/${pid}`)
    .then(response => response.json())


const removeDrinkFromPerson = (pid,did) =>
    fetch(`${REMOVE_DRINK_URL}/${did}/FromPerson/${pid}`)



