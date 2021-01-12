class DrinkEditor extends React.Component {

  state = {
    drink: {},
    strUsr: {}
  }

  findDrinkById = (id) =>{
    findDrinkById(id)
      .then(drink => this.setState({drink}))}


  componentDidMount = () => {
    const id = window.location.search.split("=")[1]
    this.findDrinkById(id)
  }

  saveDrinkSize = () =>
    updateDrinkSize(this.state.drink)

  saveDrinkPrice = () =>
      updateDrinkPrice(this.state.drink)

  saveDrinkBeer = () =>
      updateDrinkBeer(this.state.drink)

  saveDrinkName = () =>
      updateDrinkName(this.state.drink)

  handleChange = event => {
    this.setState({drink: event.target.value}).then(this.saveDrinkBeer());

  }

  render() {
    return(
        <div className="container">
          <h1>Drink Editor {this.state.drink.title}</h1>
          <input className="form-control" readOnly={true} value={this.state.drink.drinkId}/>
          <div>
            <label>Name</label>
            <input
                onChange={(event) => this.setState({
                  drink: {
                    ...this.state.drink,
                    name: event.target.value
                  }
                })}
                className="form-control"
                value={this.state.drink.name}/>
            <button onClick={this.saveDrinkName}>
              Save
            </button>
          </div>
          <div>
            <label>Price</label>
            <input
                onChange={(event) => this.setState({
                  drink: {
                    ...this.state.drink,
                    price: event.target.value
                  }
                })}
                className="form-control"
                value={this.state.drink.price}/>
            <button onClick={this.saveDrinkPrice}>
              Save
            </button>
          </div>
          <div>
            <label>Type of drink: </label>
            <select value = {this.state.drink.beer} onChange={this.handleChange}>{
              <option value="false">Liquor</option>}
              <option value="true">Beer</option>}
            </select>
          </div>

          <div>
            {/*make this change based on selection*/}
            <label>Size (ml if liquor, amount of cans if beer)</label>
            <input
                onChange={(event) => this.setState({
                  drink: {
                    ...this.state.drink,
                    size: event.target.value
                  }
                })}
                className="form-control"
                value={this.state.drink.size}/>
            <button onClick={this.saveDrinkSize}>
              Save
            </button>
          </div>
          <a href="../drink-list/drink-list.html">
            Done
          </a>
        </div>
    )
  }
}

ReactDOM.render(
  <DrinkEditor/>, document.getElementById("root"))
