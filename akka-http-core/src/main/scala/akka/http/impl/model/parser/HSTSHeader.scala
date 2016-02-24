/**
 * Copyright (C) 2009-2016 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.http.impl.model.parser

import akka.http.scaladsl.model.headers._
import akka.parboiled2.Parser
import HSTSDirectives._

private[parser] trait HSTSHeader { this: Parser with CommonRules with CommonActions with StringBuilding ⇒

  def `strict-transport-security` = rule {
    oneOrMore(`hsts-directive`).separatedBy(ws(";")) ~ EOI
  }

  def `hsts-directive` = rule(
    "max-age=" ~ `delta-seconds` ~> (`max-age`(_))
      | "includeSubDomains" ~ push(`includeSubDomains`))

}