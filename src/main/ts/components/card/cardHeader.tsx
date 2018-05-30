import * as React from 'react';

interface CardHeaderProps{
  title: string
}

export const CardHeader:React.SFC<CardHeaderProps> = (props) => {
  return (
    <div className="card-header no-border">
      <h3 className="card-title">{props.title}</h3>
    </div>
  );
};