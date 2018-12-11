package tx.core

trait Tx[A] {

  type TxSessionType = TxSession[A]

  def local[B](block: TxSessionType => B): B
}
