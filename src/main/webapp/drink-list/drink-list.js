class DrinkList extends React.Component {
  state = {
    drinks: []
  }

  findAllDrinks = () =>
      findAllDrinks()
      .then((drinks) => this.setState({drinks}))

  createDrink = () =>
      createDrink()
      .then(() => this.findAllDrinks())

  deleteDrink = (drinkId) =>
      deleteDrink(drinkId)
      .then(() => this.findAllDrinks())

  componentDidMount = () =>
      this.findAllDrinks()

  render() {
    return (

        <div className="container-fluid">
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
              <th>Price</th>
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
                          onClick={() => this.deleteDrink(drink.drinkId)}>
                        Delete
                      </button>

                      <a id="edit" className="btn btn-primary float-right"
                         href={`../../drink-editor/drink-editor.html?drinkId=${drink.drinkId}`}>
                        Edit
                      </a>


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
    <DrinkList/>,
    document.getElementById('root')
)

