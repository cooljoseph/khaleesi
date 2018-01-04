import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
    render(){
        return (
            <h2>Hello React</h2>
        );
    }
}

const rootElement = document.getElementById("wrap");
ReactDOM.render(<App/>, rootElement);