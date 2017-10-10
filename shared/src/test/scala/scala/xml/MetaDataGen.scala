/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2018, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala.xml

import org.scalacheck.Arbitrary
import org.scalacheck.Gen

trait MetaDataGen extends AttributeGen
    with ArbitraryMetaData {

  val genMetaData: Gen[MetaData] = for {
    metaData <- Gen.oneOf(Gen.const(Null), genAttribute)
  } yield {
    metaData
  }

  implicit val arbMetaData = Arbitrary {
    genMetaData
  }
}
