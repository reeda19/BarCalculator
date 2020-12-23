class Index extends React.Component {
  userStr;

  constructor(props) {
    super(props);
    this.state = {value: localStorage.getItem("user")};
    localStorage.setItem("user", this.state.value);
  }

  handleChange = event => {
    this.setState({value: event.target.value});
    localStorage.setItem("user", event.target.value);
    this.userStr = this.state.value;
  };

  render() {
    return (<div className="container">
      <h1>Bar Calculator</h1>
      <ul className="list-group">
        <li className="list-group-item">
          <a href="person-list/person-list.html">People</a>
        </li>
        <li className="list-group-item">
          <a href="drink-list/drink-list.html">Drinks</a>
        </li>
      </ul>
    </div>);
  }

}

ReactDOM.render(
    <Index/>,
    document.getElementById('root')
)


