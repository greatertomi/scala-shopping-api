package org.john.shopping
package graphql

import sangria.schema.Context

trait CtxImplicits {
  implicit def ctx(implicit context: Context[Ctx, _]): Ctx = context.ctx;
}

object CtxImplicits extends CtxImplicits {
}
