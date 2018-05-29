/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {Dashboard, Schedule, Worker, Member, Log, Footer, Header, Sidebar} from './components';

export const AppRouter: React.StatelessComponent<{}> = () => {
  return(
    <BrowserRouter>
      <div className="wrapper">
        <Header />
        <Sidebar />
        <div className="content-wrapper">
          <Switch>
            <Route exact={true} path="/" component={Dashboard} />
            <Route exact={true} path="/schedule" component={Schedule} />
            <Route exact={true} path="/worker" component={Worker} />
            <Route exact={true} path="/member" component={Member} />
            <Route exact={true} path="/log" component={Log} />
          </Switch>
        </div>
        <Footer/>
      </div>
    </BrowserRouter>
  );
};