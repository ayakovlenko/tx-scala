package tx.vanilla

import tx.core.Tx
import tx.core.TxSession

class TxImpl extends Tx {

  override def local[B](block: TxSession => B): B = ???

  override def readOnly[B](block: TxSession => B): B = ???
}
