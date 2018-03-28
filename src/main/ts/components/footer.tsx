/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from "react";
import {Layout, Icon} from 'antd';

interface FooterProps{
  align: String
}

export const Footer: React.StatelessComponent<FooterProps> = (props) => {
  return (
    <Layout.Footer style={{textAlign: props.align}}>
      <p>Ant Design ©2016 Created by Ant UED</p>
      <p>Developed by <a href="https://github.com/cooljoseph" target="_blank">joseph yoon <Icon type="github"/></a></p>
    </Layout.Footer>
  );
};

Footer.defaultProps = {
  align: 'center'
};
