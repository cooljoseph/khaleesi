/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import * as ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Button} from 'reactstrap';

const ROOT = document.querySelector('#main');

ReactDOM.render(<Button color="danger">Hello</Button>, ROOT);