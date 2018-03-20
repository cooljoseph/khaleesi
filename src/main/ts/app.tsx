/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import {Button} from 'reactstrap';

export default class App extends React.Component<{}>{
  render(){
    return (
      <div>
        <Button color="danger">Click</Button>
      </div>
    );
  }
}