import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import Header from './Header.js';
import Menu from './Menu.js';

class App extends Component {
  render(){
    return (
      <div className="wrapper">
        <Header />
        <div className="content-wrapper">
        </div>
        <Menu />
      </div>
    );
  }
}

ReactDOM.render(<App/>, document.getElementById("main"));