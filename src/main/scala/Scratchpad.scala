import tx.core.TxSession
import tx.scalikejdbc.TxImpl

object Scratchpad extends App {

  val tx = new TxImpl
}

class BankService(bankRepository: BankRepository) {

  val tx = new TxImpl

  def makeTransaction(value: BigInt): Unit = {
    tx.local { implicit session =>
      bankRepository.saveDedit(value)
      bankRepository.saveCredit(-value)
    }
  }
}

class BankRepository {

  def saveDedit(value: BigInt)(implicit session: TxSession): Unit = ()

  def saveCredit(value: BigInt)(implicit session: TxSession): Unit = ()
}
