import { RouterAction, LocationChangeAction } from 'react-router-redux';

export type ReactRouterAction = RouterAction | LocationChangeAction;

type RootAction = ReactRouterAction;

export default RootAction;