class PersonList extends React.Component {
  state = {
    persons: []
  }

  findAllPersons = () =>
      findAllPersons()
      .then((persons) => this.setState({persons}))

  createPerson = () =>
      createPerson()
      .then(() => this.findAllPersons())

  deletePerson = (personId) =>
      deletePerson(personId)
      .then(() => this.findAllPersons())

  componentDidMount = () =>
      this.findAllPersons()

  render() {
    return (

        <div className="container-fluid">
          <button
              className="btn btn-success float-right"
              onClick={() => this.createPerson()}>
            Open New Tab
          </button>
          <a className="btn btn-danger float-right"
             href="../../index.html">
            Home
          </a>
          <h1>Open Tabs</h1>
          <table className="table">
            <thead>
            <tr>
              <th>Person ID</th>
              <th>Name</th>
              <th>Total $ Owed</th>
              <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            {
              this.state.persons.map(person =>
                  <tr key={person.personId}>
                    <td>{person.personId}</td>
                    <td>{person.name}</td>
                    <td>{person.total}</td>
                    <td>
                      <button
                          id="delete" className="btn btn-danger float-right"
                          onClick={() => this.deletePerson(person.personId)}>
                        Delete
                      </button>

                      <a id="edit" className="btn btn-primary float-right"
                         href={`../../person-editor/person-editor.html?personId=${person.personId}`}>
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
    <PersonList/>,
    document.getElementById('root')
)

