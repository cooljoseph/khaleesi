/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import {Navbar, NavbarBrand, NavbarToggler, Nav, NavItem, NavLink} from 'reactstrap';

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
                <NavItem active={true}><NavLink href="/">Home</NavLink></NavItem>
                <NavItem><NavLink href="/schedule" >Schedule</NavLink></NavItem>
                <NavItem><NavLink href="/worker">Worker</NavLink></NavItem>
                <NavItem><NavLink href="/member">Member</NavLink></NavItem>
                <NavItem><NavLink href="/log">Log</NavLink></NavItem>
              </Nav>
            </div>
          </Navbar>
        </header>
      </div>
    );
  }
}