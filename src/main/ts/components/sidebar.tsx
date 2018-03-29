/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from "react";
import {Layout, Menu, Icon} from 'antd';
import {Link} from "react-router-dom";

export default class Sidebar extends React.Component<{}>{
  render(){
    return (
      <Layout.Sider trigger={null} collapsible>
        <div className="logo"><span className="logo-kh"><b>Khaleesi</b>Batch</span></div>
        <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
          <Menu.Item key="1">
            <Link to="/" className="nav-text"><Icon type="pie-chart" /> Dashboard</Link>
          </Menu.Item>
          <Menu.Item key="2">
            <Link to="/schedule" className="nav-text"><Icon type="calendar" /> Schedule</Link>
          </Menu.Item>
          <Menu.Item key="3">
            <Link to="/member" className="nav-text"><Icon type="user" /> Member</Link>
          </Menu.Item>
          <Menu.Item key="4">
            <Link to="/log" className="nav-text"><Icon type="line-chart" /> Log</Link>
          </Menu.Item>
        </Menu>
      </Layout.Sider>
    );
  }
}