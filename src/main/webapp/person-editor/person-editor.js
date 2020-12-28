class PersonEditor extends React.Component {

  state = {
    person: {},
    strUsr: {}
  }

  findPersonById = (id) =>{
    findPersonById(id)
      .then(person => this.setState({person}))}


  componentDidMount = () => {
    const id = window.location.search.split("=")[1]
    this.findPersonById(id)
  }

  savePersonName = () =>
    updatePersonName(this.state.person)

  savePersonAuthor = () =>
      updatePersonAuthor(this.state.person)

  render() {
    return(
        <div className="container">
          <h1>Person Editor {this.state.person.title}</h1>
          <input className="form-control" readOnly={true} value={this.state.person.personId}/>
          <div>
            <label>Name</label>
            <input
                onChange={(event) => this.setState({
                  person: {
                    ...this.state.person,
                    name: event.target.value
                  }
                })}
                className="form-control"
                value={this.state.person.name}/>
            <button onClick={this.savePersonName}>
              Save
            </button>
          </div>
          <a href="../person-list/person-list.html">
            Done
          </a>
        </div>
    )
  }
}

ReactDOM.render(
  <PersonEditor/>, document.getElementById("root"))
