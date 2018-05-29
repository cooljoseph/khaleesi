/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

import * as React from "react";
import * as FontAwesome from "react-fontawesome";

export const Footer: React.SFC = () => {
  return (
    <footer className="main-footer">
      <strong>powered by Khaleesi</strong>
      <a href="https://github.com/cooljoseph/khaleesi" target="_blank">
        <FontAwesome name="github" size="2x" />
      </a>
    </footer>
  );
};