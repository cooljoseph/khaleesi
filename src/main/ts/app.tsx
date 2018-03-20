/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import * as rs from 'reactstrap';

export default class App extends React.Component<{}>{
  render(){
    return (
      <div className="container-fluid">
        <header>
          <rs.Navbar fixed={"top"} dark={true} expand={"lg"} toggleable={true} className="pink" >
            <rs.NavbarBrand href="#"><strong>Khaleesi</strong></rs.NavbarBrand>
            <rs.NavbarToggler data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </rs.NavbarToggler>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
              <rs.Nav className="mr-auto" navbar={true}>
                <rs.NavItem active={true}><rs.NavLink href="#">Home</rs.NavLink></rs.NavItem>
                <rs.NavItem><rs.NavLink href="#">Schedule</rs.NavLink></rs.NavItem>
                <rs.NavItem><rs.NavLink href="#">Worker</rs.NavLink></rs.NavItem>
                <rs.NavItem><rs.NavLink href="#">Member</rs.NavLink></rs.NavItem>
                <rs.NavItem><rs.NavLink href="#">Log</rs.NavLink></rs.NavItem>
              </rs.Nav>
            </div>
          </rs.Navbar>
        </header>
      </div>
    );
  }
}