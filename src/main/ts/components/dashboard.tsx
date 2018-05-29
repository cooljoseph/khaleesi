import * as React from 'react';
import { Row, Col } from "reactstrap";

export class Dashboard extends React.Component<{}>{
  render(){
    return (
      <div className="content">
        <div className="container-fluid">
          <Row>
            <Col sm="3">
              <h3>Dashboard</h3>
            </Col>
          </Row>
        </div>
      </div>
    );
  };
}