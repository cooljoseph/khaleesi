/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from "react";
import { Nav } from "reactstrap";
import SidebarItem from "./sidebarItem";

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
              <SidebarItem link="/" iconName="dashboard" menuName="Dashboard" exact={true}/>
              <SidebarItem link="/schedule" iconName="calendar" menuName="Schedule" exact={false}/>
              <SidebarItem link="/worker" iconName="cogs" menuName="Worker" exact={false}/>
              <SidebarItem link="/log" iconName="calendar" menuName="Log" exact={false}/>
              <SidebarItem link="/member" iconName="user" menuName="Member" exact={false}/>
            </Nav>
          </nav>
        </div>
      </aside>
    );
  }
}