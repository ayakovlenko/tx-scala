package tx.core

import java.sql.Connection

import scala.language.implicitConversions

trait Tx {

  def local[A](block: TxSession => A): A

  def readOnly[A](block: TxSession => A): A

  // ---

  def getConnection(autocommit: Boolean): Connection

  def withConnection[A](autocommit: Boolean)(block: Connection => A): A = {
    val connection = getConnection(autocommit)

    ???
  }

  def withConnection[A](block: Connection => A): A =
    withConnection(autocommit = true)(block)

  implicit def connection2TxSession(connection: Connection): TxSession =
    TxSession(connection)
}
