package tx.vanilla

import java.sql.Connection

import tx.core.Tx
import tx.core.TxSession

class TxImpl extends Tx {

  override def local[B](block: TxSession => B): B = ???

  override def readOnly[B](block: TxSession => B): B = {
    withConnection(autocommit = false) { connection =>
      connection.setReadOnly(true)

      block(connection)
    }
  }

  override def getConnection(autocommit: Boolean): Connection = ???
}
