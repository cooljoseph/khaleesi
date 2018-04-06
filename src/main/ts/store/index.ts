/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */


import {routerMiddleware} from "react-router-redux";
import { createStore } from 'redux';
import createHistory from 'history/createBrowserHistory';

export const history = createHistory();
const middleware = [routerMiddleware(history)];

export const store = createStore(() => {return 1+1});