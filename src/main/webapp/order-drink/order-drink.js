class OrderDrink extends React.Component {
  state = {
    drinks: [],
    person: {},

  }

  findPersonById = (id) =>{
    findPersonById(id)
    .then(person => this.setState({person}))}


  findAllDrinks = () =>
      findAllDrinks()
      .then((drinks) => this.setState({drinks}))


  addDrinkToPerson = (did) =>
      addDrinkToPerson(this.state.person.personId, did)

  componentDidMount = () => {
    this.findAllDrinks();
    const id = window.location.search.split("=")[1]
    this.findPersonById(id)
    console.log(this.state.person.personId)
  }



  render() {
    return (

        <div className="container-fluid">
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
                          id="order" className="btn btn-success float-right"
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

