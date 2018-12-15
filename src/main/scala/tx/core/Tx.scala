package tx.core

trait Tx {

  def local[B](block: TxSession => B): B

  def readOnly[B](block: TxSession => B): B
}
