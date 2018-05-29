/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from "react";
import { Nav, NavItem } from "reactstrap";
import {NavLink} from "react-router-dom";
import * as FontAwesome from "react-fontawesome";

export class Sidebar extends React.Component<{}>{
  render(){
    return (
      <aside className="main-sidebar sidebar-dark-primary elevation-4">
        <a href="/" className="brand-link">
          <span className="brand-text font-weight-light">Khaleesi Batch</span>
        </a>
        <div className="sidebar">
          <nav className="mt-2">
            <Nav className="nav-pills nav-sidebar flex-column">
              <NavItem>
                <NavLink exact to="/" className="nav-link" >
                  <FontAwesome name="dashboard" className="nav-icon"/>
                  <p>Dashboard</p>
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink to="/schedule" className="nav-link" >
                  <FontAwesome name="calendar" className="nav-icon"/>
                  <p>Schedule</p>
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink to="/worker" className="nav-link" >
                  <FontAwesome name="cogs" className="nav-icon"/>
                  <p>Worker</p>
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink to="/log" className="nav-link" >
                  <FontAwesome name="calendar" className="nav-icon"/>
                  <p>Log</p>
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink to="/member" className="nav-link" >
                  <FontAwesome name="user" className="nav-icon"/>
                  <p>Member</p>
                </NavLink>
              </NavItem>
            </Nav>
          </nav>
        </div>
      </aside>
    );
  }
}