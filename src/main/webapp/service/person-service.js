const FIND_ALL_BOOKS  = "http://localhost:8080/findAllPersons"
const FIND_BOOK_BY_ID = "http://localhost:8080/findPersonById"
const CREATE_BOOK_URL = "http://localhost:8080/addPerson"
const DELETE_BOOK_URL = "http://localhost:8080/deletePerson"
const UPDATE_BOOK     = "http://localhost:8080/updatePerson"

const findAllPersons = () =>
    fetch(`${FIND_ALL_BOOKS}`)
    .then(response => response.json())

const findPersonById = (personId) =>
    fetch(`${FIND_BOOK_BY_ID}/${personId}`)
    .then(response => response.json())

const createPerson = (person) =>
    fetch(`${CREATE_BOOK_URL}`)
    .then(response => response.json())

const deletePerson = (personId) =>
    fetch(`${DELETE_BOOK_URL}/${personId}`)

const updatePersonName = (person) =>
    fetch(`${UPDATE_BOOK}/${person.personId}/name/${person.title}`)
    .then(response => response.json())



