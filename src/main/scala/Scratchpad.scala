import scalikejdbc.DBSession
import tx.core.Tx
import tx.scalikejdbc.TxImpl

object Scratchpad extends App {

  val tx: Tx[DBSession] = new TxImpl

  tx.local { implicit session =>
    ???
  }
}
