/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from 'react';

interface CardBodyProps{}

export const CardBody:React.SFC = (props) => {
  return (
    <div className="card-body">
      {props.children}
    </div>
  );
};