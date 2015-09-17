package scala.xml.parsing

import scala.xml.XML
import scala.xml.PrettyPrinter

import org.junit.Test
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.assertEquals

class ConstructingParserTest {

  @Test
  def SI6341issue65: Unit = {
    val input = """<elem one="test" two="test2" three="test3"/>"""
    val cpa = ConstructingParser.fromSource(io.Source.fromString(input), preserveWS = true)
    val cpadoc = cpa.document()
    val ppr = new PrettyPrinter(80,5)
    val out = ppr.format(cpadoc.docElem)
    assertEquals(input, out)
  }

}
