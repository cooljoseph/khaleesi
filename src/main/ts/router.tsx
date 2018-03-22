/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import {App} from './app';
import {Schedule} from './components/schedule';
import {Worker} from './components/worker';
import {Member} from './components/member';
import {Log} from './components/log';
import {BrowserRouter, Route} from "react-router-dom";

export const AppRouter: React.StatelessComponent<{}> = () => {
  return(
    <BrowserRouter>
      <div>
        <Route path="/" component={App} />
        <Route path="/schedule" component={Schedule} />
        <Route path="/worker" component={Worker} />
        <Route path="/member" component={Member} />
        <Route path="/Log" component={Log} />
      </div>
    </BrowserRouter>
  );
};