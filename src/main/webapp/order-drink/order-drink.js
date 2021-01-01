class OrderDrink extends React.Component {
  state = {
    drinks: [],
    persons: [],
    personId: {}
  }

  findAllDrinks = () =>
      findAllDrinks()
      .then((drinks) => this.setState({drinks}))

  findAllPersons = () =>
      findAllPersons()
      .then((persons) => this.setState({persons}))

  addDrinkToPerson = (did) =>
      addDrinkToPerson(this.state.personId, did)

  componentDidMount = () => {
    this.findAllDrinks();
    this.findAllPersons()
    this.setState({personId: 0})
  }

  handleChange = event => {
    this.setState({personId: event.target.value});
    console.log(this.state.personId)
  }


  render() {
    return (

        <div className="container-fluid">
            <label htmlFor="user">Choose a tab: </label>
            <select onChange={this.handleChange}>{
              this.state.persons.map(person =>
              <option key={person.personId} value={person.personId}>{person.name}</option>)}
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

