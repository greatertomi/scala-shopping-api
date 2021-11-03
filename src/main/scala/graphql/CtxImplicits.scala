package org.john.shopping
package graphql

import akka.stream.Materializer
import sangria.schema.Context

import scala.concurrent.ExecutionContext

trait CtxImplicits {
  implicit def ctx(implicit context: Context[Ctx, _]): Ctx = context.ctx;
  implicit def materializer(implicit ctx: Ctx): Materializer = ctx.materializer
  implicit def executionContext(implicit ctx: Ctx): ExecutionContext = ctx.executionContext

  def anonUserCtx(implicit ctx: Ctx): AnonymousUserCtx = ctx.asInstanceOf[AnonymousUserCtx]
  def userCtx(implicit ctx: Ctx): UserCtx
}

object CtxImplicits extends CtxImplicits {
  override def userCtx(implicit ctx: Ctx): UserCtx = ctx match {
    case userCtx: UserCtx => userCtx
    case anonUserCtx: AnonymousUserCtx => anonUserCtx.asInstanceOf[UserCtx]
  }
}
