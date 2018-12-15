package tx.core

import java.sql.Connection

final case class TxSession(connection: Connection)
