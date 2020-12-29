class OrderDrink extends React.Component {
  state = {
    drinks: [],
    persons: [],
    person: {}
  }

  personId;

  findAllDrinks = () =>
      findAllDrinks()
      .then((drinks) => this.setState({drinks}))

  findPersonById = (id) =>{
    findPersonById(id)
    .then(person => this.setState({person}))}

  findAllPersons = () =>
      findAllPersons()
      .then((persons) => this.setState({persons}))

  createDrink = () =>
      createDrink()
      .then(() => this.findAllDrinks())

  deleteDrink = (drinkId) =>
      deleteDrink(drinkId)
      .then(() => this.findAllDrinks())

  componentDidMount = () => {
    this.findAllDrinks();
    this.findAllPersons()
  }

  handleChange = event => {
    this.setState({person: event.target.value});
  }


  render() {
    return (



        <div className="container-fluid">
            <label htmlFor="user">Choose a tab: </label>
            <select value={this.state.person.name} onChange={this.handleChange}>{
              this.state.persons.map(person =>
              <option key={person.personId}>{person.name}</option>)}
            </select>
          <a className="btn btn-danger float-right"
             href="../../index.html">
            Home
          </a>
          <h1>Available Drinks</h1>
          <table className="table">
            <thead>
            <tr>
              <th>Drink ID</th>
              <th>Name</th>
              <th>Price per Drink</th>
              <th>Size</th>
              <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            {
              this.state.drinks.map(drink =>
                  <tr key={drink.drinkId}>
                    <td>{drink.drinkId}</td>
                    <td>{drink.name}</td>
                    <td>{drink.price}</td>
                    <td>{drink.size}</td>
                    <td>
                      <button
                          id="delete" className="btn btn-danger float-right"
                          onClick={() => this.addDrinkToPerson(drink.drinkId)}>
                        Order
                      </button>

                    </td>
                  </tr>
              )

            }
            </tbody>
          </table>
        </div>

    )
  }
}

ReactDOM.render(
    <OrderDrink/>,
    document.getElementById('root')
)

