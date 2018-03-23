/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import {Navbar, NavbarBrand, NavbarToggler, Nav, NavItem, NavLink} from 'reactstrap';
import {Link} from 'react-router-dom';

export class App extends React.Component<{}>{
  render(){
    return (
      <div className="container-fluid">
        <header>
          <Navbar fixed={"top"} dark={true} expand={"lg"} toggleable={true} className="pink" >
            <NavbarBrand href="#"><strong>Khaleesi</strong></NavbarBrand>
            <NavbarToggler data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </NavbarToggler>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
              <Nav className="mr-auto" navbar={true}>
                {/* 얘네가 이걸 고쳐 줄 생각이 없네 NavLink 대체 */}
                <NavItem><Link to={"/"} className = "nav-link">Home</Link></NavItem>
                <NavItem><Link to={"/schedule"} className = "nav-link">Schedule</Link></NavItem>
                <NavItem><Link to={"/worker"} className="nav-link">Worker</Link></NavItem>
                <NavItem><Link to={"/member"} className="nav-link">Member</Link></NavItem>
                <NavItem><Link to={"/log"} className="nav-link">Log</Link></NavItem>
              </Nav>
            </div>
          </Navbar>
        </header>
      </div>
    );
  }
}