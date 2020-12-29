class OrderDrink extends React.Component {
  state = {
    drinks: [],
    persons: []
  }

  personId;

  findAllDrinks = () =>
      findAllDrinks()
      .then((drinks) => this.setState({drinks}))

  createDrink = () =>
      createDrink()
      .then(() => this.findAllDrinks())

  deleteDrink = (drinkId) =>
      deleteDrink(drinkId)
      .then(() => this.findAllDrinks())

  componentDidMount = () => {
    this.findAllDrinks().then(
    this.findAllPersons())
  }

  handleChange = event => {
    personId
  }


  render() {
    return (



        <div className="container-fluid">
            <label htmlFor="user">Choose a tab:</label>
            <select value={this.personId} onChange={this.handleChange}>{
              this.state.persons.map(person =>
              <option>person.name</option>)}
            </select>
          <button
              className="btn btn-success float-right"
              onClick={() => this.createDrink()}>
            Add New Drink
          </button>
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

