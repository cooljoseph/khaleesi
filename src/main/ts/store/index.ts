/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */


import { routerReducer} from "react-router-redux";
import { createStore } from 'redux';

export const store = createStore(() => {
  return routerReducer;
});