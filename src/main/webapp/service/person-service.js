const FIND_ALL_PERSONS  = "http://localhost:8080/findAllPersons"
const FIND_PERSON_BY_ID = "http://localhost:8080/findPersonById"
const CREATE_PERSON_URL = "http://localhost:8080/addPerson"
const DELETE_PERSON_URL = "http://localhost:8080/deletePerson"
const UPDATE_PERSON     = "http://localhost:8080/updatePerson"

const findAllPersons = () =>
    fetch(`${FIND_ALL_PERSONS}`)
    .then(response => response.json())

const findPersonById = (personId) =>
    fetch(`${FIND_PERSON_BY_ID}/${personId}`)
    .then(response => response.json())

const createPerson = (person) =>
    fetch(`${CREATE_PERSON_URL}`)
    .then(response => response.json())

const deletePerson = (personId) =>
    fetch(`${DELETE_PERSON_URL}/${personId}`)

const updatePersonName = (person) =>
    fetch(`${UPDATE_PERSON}/${person.personId}/name/${person.name}`)
    .then(response => response.json())



