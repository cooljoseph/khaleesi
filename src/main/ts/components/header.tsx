/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from "react";
import { Nav, Navbar, NavItem } from "reactstrap";
import * as FontAwesome from "react-fontawesome";
import {NavLink} from "react-router-dom";
import * as $ from 'jquery';

export class Header extends React.Component<{}>{
  toggleSidebar():void {
    $("body").toggleClass("sidebar-collapse");
  }

  render(){
    return (
      <Navbar className="main-header border-bottom bg-white" light expand>
        <Nav className="navbar-nav">
          <NavItem>
            <a onClick={this.toggleSidebar} className="nav-link"><FontAwesome name="bars" /></a>
          </NavItem>
        </Nav>
        <Nav className="navbar-nav ml-auto">
          <Nav className="navbar-nav">
            <NavItem>
              <NavLink to="/" className="nav-link">
                <FontAwesome name="comments-o" />
                <span className="badge badge-danger navbar-badge">3</span>
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink to="/" className="nav-link">
                <FontAwesome name="bell-o" />
                <span className="badge badge-warning navbar-badge">15</span>
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink to="/" className="nav-link">
                <FontAwesome name="th-large" />
              </NavLink>
            </NavItem>
          </Nav>
        </Nav>
      </Navbar>
    );
  }
}