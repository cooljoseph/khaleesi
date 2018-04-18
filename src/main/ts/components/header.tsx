/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from "react";
import {Layout, Icon} from "antd";

export class Header extends React.Component<{}>{
  render(){
    return (
      <Layout>
        <Layout.Header style={{ background: '#fff', padding: 0 }}>
          <Icon type="menu-fold" className="trigger"/>
        </Layout.Header>
      </Layout>
    );
  }
}