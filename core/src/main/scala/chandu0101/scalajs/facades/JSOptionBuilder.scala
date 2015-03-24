package chandu0101.scalajs.facades

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
 * //https://github.com/jducoeur/Querki/blob/a13a69c995dd7e4f0f4dc4df370e5ab66e540daf/querki/scalajs/src/main/scala/org/querki/jsext/JSOptionBuilder.scala
 * @param copy
 * @tparam T
 * @tparam B
 */
abstract class JSOptionBuilder[T <: js.Object, B <: JSOptionBuilder[T, _]](copy:OptMap => B) {
  /**
   * This is a dictionary of option values. It is usually *very* heterogeneous,
   * mixing everything from Ints to Functions. So it needs to be js.Any.
   */
  def dict:OptMap

  def jsOpt(name:String, opt:Any):B = {
    copy(dict + (name -> opt))
  }

  def result = {
    dict.toJSDictionary.asInstanceOf[T]
  }

  override def toString = {
    s"""{\n${dict.keys.map{ key => s"  $key = ${dict(key).toString}"}.mkString("\n")}\n}"""
  }
}