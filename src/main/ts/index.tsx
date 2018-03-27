/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import * as ReactDOM from 'react-dom';
import {AppRouter} from './router';

import './assets/app.css';

const ROOT = document.querySelector('#main');

ReactDOM.render(<AppRouter />, ROOT);