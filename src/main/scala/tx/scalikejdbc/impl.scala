package tx.scalikejdbc

import scalikejdbc.{DB, DBSession}
import tx.core.{Tx, TxSession}

class TxImpl extends Tx[DBSession] {

  override def local[A](block: TxSessionType => A): A = {
    DB.localTx { implicit session =>
      block(TxSessionImpl(session))
    }
  }
}

case class TxSessionImpl(underlying: DBSession) extends TxSession[DBSession]
