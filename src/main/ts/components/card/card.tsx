import * as React from 'react';
import { CardHeader } from './cardHeader';
import { CardBody } from './cardBody';

interface CardProps{
  title: string
}

export const Card:React.SFC<CardProps> = (props) => {
  return (
    <div className="card">
      <CardHeader title={props.title}/>
      <CardBody>{props.children}</CardBody>
    </div>
  );
};

