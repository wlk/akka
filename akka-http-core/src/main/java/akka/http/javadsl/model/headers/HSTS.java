/**
 * Copyright (C) 2009-2016 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.http.javadsl.model.headers;

/**
 *  Model for the `Strict-Transport-Security` header.
 *  Specification: https://tools.ietf.org/html/rfc6797
 */
public abstract class HSTS extends akka.http.scaladsl.model.HttpHeader {
    public abstract Iterable<HSTSDirective> getDirectives();

    public static HSTS create(HSTSDirective... directives) {
        return new akka.http.scaladsl.model.headers.Strict$minusTransport$minusSecurity(akka.http.impl.util.Util.<HSTSDirective, akka.http.scaladsl.model.headers.HSTSDirective>convertArray(directives));
    }
}
