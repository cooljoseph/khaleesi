/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import Dashboard from './components/dashboard';
import Schedule from './components/schedule';
import Worker from './components/worker';
import Member from './components/member';
import Log from './components/log';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {App} from "./app";

export const AppRouter: React.StatelessComponent<{}> = () => {
  return(
    <BrowserRouter>
      <div>
        <App/>
        <Switch>
          <Route exact={true} path="/" component={Dashboard} />
          <Route exact={true} path="/schedule" component={Schedule} />
          <Route exact={true} path="/worker" component={Worker} />
          <Route exact={true} path="/member" component={Member} />
          <Route exact={true} path="/log" component={Log} />
        </Switch>
      </div>
    </BrowserRouter>
  );
};