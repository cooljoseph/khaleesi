import { routerReducer} from "react-router-redux";
import { createStore } from 'redux';

export const store = createStore(() => {
  return routerReducer;
});