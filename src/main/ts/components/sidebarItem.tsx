import { NavItem } from "reactstrap";
import { NavLink } from "react-router-dom";
import * as FontAwesome from "react-fontawesome";
import * as React from "react";

interface ISidebarItemProps{
  link: string;
  iconName: string;
  menuName: string;
  exact: boolean;
}

const SidebarItem: React.SFC<ISidebarItemProps> = (props) => {
  return (
    <NavItem>
      <NavLink exact={props.exact} to={props.link} className="nav-link" >
        <FontAwesome name={props.iconName} className="nav-icon"/>
        <p>{props.menuName}</p>
      </NavLink>
    </NavItem>
  );
};

// 이렇게 안하면 debugger 에서 이름이 안나와 버림
export default SidebarItem;