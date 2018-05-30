/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {Dashboard, Schedule, Worker, Member, Log, Footer, Header, Sidebar, NotFound} from './components';

const AppRouter: React.SFC = () => {
  return(
    <BrowserRouter>
      <div className="wrapper">
        <Header />
        <Sidebar />
        <div className="content-wrapper">
          <Switch>
            <Route exact={true} path="/" component={Dashboard} />
            <Route path="/schedule" component={Schedule} />
            <Route path="/worker" component={Worker} />
            <Route path="/member" component={Member} />
            <Route path="/log" component={Log} />
            <Route exact={true} path="*" component={NotFound} />
          </Switch>
        </div>
        <Footer/>
      </div>
    </BrowserRouter>
  );
};

export default AppRouter;