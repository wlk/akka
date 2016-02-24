/**
 * Copyright (C) 2009-2016 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.http.scaladsl.model.headers

import scala.annotation.{ varargs, tailrec }
import scala.collection.immutable
import akka.http.impl.util._
import akka.http.javadsl.{ model ⇒ jm }

sealed trait HSTSDirective extends Renderable with jm.headers.HSTSDirective {
  def value: String
}

object HSTSDirective {
  sealed trait RequestDirective extends HSTSDirective
  sealed trait ResponseDirective extends HSTSDirective
}

object HSTSDirectives {
  import HSTSDirective._

  final case class `max-age`(deltaSeconds: Long) extends RequestDirective with ResponseDirective with ValueRenderable {
    def render[R <: Rendering](r: R): r.type = r ~~ productPrefix ~~ '=' ~~ deltaSeconds
  }

  case object `includeSubDomains` extends SingletonValueRenderable with RequestDirective with ResponseDirective
}
