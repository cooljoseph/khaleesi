
/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';
import {Provider} from "react-redux";
import {ConnectedRouter} from "react-router-redux";
import {AppRouter} from "./router";
import {store, history} from "./store";

export const App: React.SFC = () => {
  return (
    <Provider store={store}>
      <ConnectedRouter history={history}>
        <AppRouter />
      </ConnectedRouter>
    </Provider>
  );
};