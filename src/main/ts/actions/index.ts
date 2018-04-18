/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import { RouterAction, LocationChangeAction } from 'react-router-redux';

export type ReactRouterAction = RouterAction | LocationChangeAction;

type RootAction = ReactRouterAction;

export default RootAction;