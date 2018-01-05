import React from 'react';
import ReactDOM from 'react-dom';
import Header from './header.js';
import Menu from './menu.js';

class App extends React.Component {
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