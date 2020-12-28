class BookEditor extends React.Component {

  state = {
    book: {},
    strUsr: {}
  }

  findBookById = (id) =>{
    findBookById(id)
      .then(book => this.setState({book}))}


  componentDidMount = () => {
    const id = window.location.search.split("=")[1]
    this.findBookById(id)
  }

  saveBookTitle = () =>
    updateBookTitle(this.state.book)

  saveBookAuthor = () =>
      updateBookAuthor(this.state.book)

  render() {
    return(
        <div className="container">
          <h1>Book Editor {this.state.book.title}</h1>
          <input className="form-control" readOnly={true} value={this.state.book.bookId}/>
          <div>
            <label>Title</label>
            <input
                onChange={(event) => this.setState({
                  book: {
                    ...this.state.book,
                    title: event.target.value
                  }
                })}
                className="form-control"
                value={this.state.book.title}/>
            <button onClick={this.saveBookTitle}>
              Save
            </button>
          </div>
          <div>
            <label>Author</label>
            <input
                onChange={(event) => this.setState({
                  book: {
                    ...this.state.book,
                    author: event.target.value
                  }
                })}
                className="form-control"
                value={this.state.book.author}/>
            <button onClick={this.saveBookAuthor}>
              Save
            </button>
          </div>
          <a href="../book-list/book-list.html">
            Done
          </a>
        </div>
    )
  }
}

ReactDOM.render(
  <BookEditor/>, document.getElementById("root"))
