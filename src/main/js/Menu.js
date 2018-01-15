import React, {Component} from 'react';

class Menu extends Component{
    render(){
        return (
            <aside className="main-sidebar">
                <div className="sidebar" id="scrollspy">
                    <ul className="nav sidebar-menu">
                        <li className="header">TABLE OF CONTENTS</li>
                        <li className="active"><a href="#"><i className="fa fa-circle-o"></i> Introduction</a></li>
                        <li className="treeview" id="scrollspy-components">
                            <a href="javascript:void(0)"><i className="fa fa-circle-o"></i> Components</a>
                            <ul className="nav treeview-menu">
                                <li><a href="#">Main Header</a></li>
                                <li><a href="#">Sidebar</a></li>
                                <li><a href="#">Control Sidebar</a></li>
                                <li><a href="#">Info Box</a></li>
                                <li><a href="#">Boxes</a></li>
                                <li><a href="#">Direct Chat</a></li>
                            </ul>
                        </li>
                        <li><a href="#license"><i className="fa fa-circle-o"></i> License</a></li>
                    </ul>
                </div>
            </aside>

        );
    }
}

export default Menu;