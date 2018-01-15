import React, {Component} from 'react';

class Header extends Component{

    render(){
        return (
            <header className="main-header">
                <a href="/" className="logo">
                    <span className="logo-mini"><b>K</b>h</span>
                    <span className="logo-lg"><b>Khaleesi</b></span>
                </a>
                <nav className="navbar navbar-static-top" role="navigation">
                    <a href="#" className="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span className="sr-only">Toggle navigation</span>
                    </a>
                    <div className="navbar-custom-menu">
                        <ul className="nav navbar-nav">
                            <li><a href="#" data-toggle="control-sidebar"><i className="fa fa-cogs"></i></a></li>
                        </ul>
                    </div>
                </nav>
            </header>
        );
    }
}


export default Header;
