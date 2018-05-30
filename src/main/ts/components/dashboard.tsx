import * as React from 'react';
import { Row, Col } from "reactstrap";
import Card from './card';

export class Dashboard extends React.Component<{}>{
  render(){
    return (
      <div>
        <div className="content-header">
          <div className="container-fluid">
            <Row className="mb-2">
              <Col sm="6">
                <h1 className="text-dark">Dashboard</h1>
              </Col>
            </Row>
          </div>
        </div>
        <div className="content">
          <div className="container-fluid">
            <Row>
              <Col lg="6">
                <Card title="DashBoard">
                  <a>Hello</a>
                </Card>
              </Col>
            </Row>
          </div>
        </div>
      </div>
    );
  };
}