package tx.scalikejdbc

import java.sql.Connection

import scalikejdbc.DB
import tx.core.Tx
import tx.core.TxSession

class TxImpl extends Tx {

  override def local[A](block: TxSession => A): A = {
    DB.localTx { implicit session =>
      block(TxSession(session.connection))
    }
  }

  override def readOnly[B](block: TxSession => B): B = ???

  override def getConnection(autocommit: Boolean): Connection = ???
}
