package chandu0101.scalajs.facades.pouchdb

import chandu0101.scalajs.facades.pouchdb.PouchDBJS.CALLBACK
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.JSName

/**
 * Created by chandrasekharkode .
 */


trait PouchDBAjaxOptions extends js.Object {
  var cache: js.UndefOr[Boolean] = js.native
  var headers: js.UndefOr[String] = js.native
}

object PouchDBAjaxOptions {
  def apply(headers: js.UndefOr[String] = js.undefined,
            cache: js.UndefOr[Boolean] = false) =
    json("cache" -> cache,
      "headers" -> headers).asInstanceOf[PouchDBAjaxOptions]

}

trait PouchDBOptions extends js.Object {
  var name: js.UndefOr[String] = js.native
  var auto_compaction: js.UndefOr[Boolean] = js.native
  var adapter: js.UndefOr[String] = js.native
  var ajax: js.UndefOr[PouchDBAjaxOptions] = js.native
}

object PouchDBOptions {
  def apply(adapter: js.UndefOr[String] = js.undefined,
            auto_compaction: js.UndefOr[Boolean] = false,
            ajax: js.UndefOr[PouchDBAjaxOptions] = js.undefined,
            name: js.UndefOr[String] = js.undefined) =
    json("name" -> name,
      "auto_compaction" -> auto_compaction,
      "adapter" -> adapter,
      "ajax" -> ajax).asInstanceOf[PouchDBOptions]
}

trait AllDocsOptions extends js.Object {

  var include_docs: js.UndefOr[Boolean] = js.native
  var conflicts: js.UndefOr[Boolean] = js.native
  var attachments: js.UndefOr[Boolean] = js.native
  var startkey: js.UndefOr[String] = js.native
  var endkey: js.UndefOr[String] = js.native
  var inclusive_end: js.UndefOr[Boolean] = js.native
  var limit: js.UndefOr[Int] = js.native
  var skip: js.UndefOr[Int] = js.native
  var descending: js.UndefOr[Boolean] = js.native
  var key: js.UndefOr[String] = js.native
  var keys: js.UndefOr[js.Array[String]] = js.native

}


object AllDocsOptions {

  def apply(attachments: js.UndefOr[Boolean] = false,
            descending: js.UndefOr[Boolean] = false,
            startkey: js.UndefOr[String] = js.undefined,
            keys: js.UndefOr[js.Array[String]] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            endkey: js.UndefOr[String] = js.undefined,
            conflicts: js.UndefOr[Boolean] = false,
            inclusive_end: js.UndefOr[Boolean] = true,
            limit: js.UndefOr[Int] = js.undefined,
            skip: js.UndefOr[Int] = js.undefined,
            include_docs: js.UndefOr[Boolean] = false) =
    json("attachments" -> attachments, "endkey" -> endkey, "key" -> key, "conflicts" -> conflicts, "include_docs" -> include_docs, "keys" -> keys, "skip" -> skip, "startkey" -> startkey, "limit" -> limit, "descending" -> descending, "inclusive_end" -> inclusive_end).asInstanceOf[AllDocsOptions]

}

trait EventEmitter extends js.Object {
  def on(event: String, listener: js.Function1[js.Dynamic, Any]): this.type = js.native

}

trait ChangesEventEmitter extends EventEmitter {

  def cancel(): Unit = js.native
}

object ChangesEventEmitter {

  implicit class ChangesEventEmitterEvents(val self: ChangesEventEmitter) extends AnyVal {
    def onChange(listener: js.Function1[js.Dynamic, Any]): self.type = self.on("change", listener)

    def onComplete(listener: js.Function1[js.Dynamic, Any]): self.type = self.on("complete", listener)

    def onError(listener: js.Function1[js.Dynamic, Any]): self.type = self.on("error", listener)

    def onCreate(listener: js.Function1[js.Dynamic, Any]): self.type = self.on("create", listener)

    def onUpdate(listener: js.Function1[js.Dynamic, Any]): self.type = self.on("update", listener)

    def onDelete(listener: js.Function1[js.Dynamic, Any]): self.type = self.on("delete", listener)

    def onDenied(listener: js.Function1[js.Dynamic, Any]): self.type = self.on("denied", listener)

    def onPaused(listener: js.Function1[js.Dynamic, Any]): self.type = self.on("paused", listener)

    def onActive(listener: js.Function1[js.Dynamic, Any]): self.type = self.on("active", listener)
  }

}

trait ChangesOptions extends js.Object {

  var include_docs: UndefOr[Boolean] = js.native
  var conflicts: UndefOr[Boolean] = js.native
  var attachments: UndefOr[Boolean] = js.native
  var descending: UndefOr[Boolean] = js.native
  var filter: UndefOr[Boolean] = js.native
  var doc_ids: UndefOr[js.Array[String]] = js.native
  var since: UndefOr[String] = js.native
  var live: UndefOr[Boolean] = js.native
  var limit: UndefOr[Int] = js.native
  var style: UndefOr[String] = js.native
  var view: UndefOr[js.Function] = js.native
  var returnDocs: UndefOr[Boolean] = js.native
  var batch_size: UndefOr[Int] = js.native

}

object ChangesOptions {

  def apply(doc_ids: UndefOr[js.Array[String]] = js.undefined,
            live: UndefOr[Boolean] = false,
            attachments: UndefOr[Boolean] = false,
            descending: UndefOr[Boolean] = false,
            returnDocs: UndefOr[Boolean] = false,
            style: UndefOr[String] = js.undefined,
            batch_size: UndefOr[Int] = js.undefined,
            conflicts: UndefOr[Boolean] = false,
            filter: UndefOr[Boolean] = false,
            limit: UndefOr[Int] = js.undefined,
            view: UndefOr[js.Function] = js.undefined,
            since: UndefOr[String] = js.undefined,
            include_docs: UndefOr[Boolean] = false) =
    json("attachments" -> attachments, "view" -> view, "since" -> since, "filter" -> filter, "conflicts" -> conflicts, "include_docs" -> include_docs, "limit" -> limit, "style" -> style, "batch_size" -> batch_size, "descending" -> descending, "doc_ids" -> doc_ids, "returnDocs" -> returnDocs, "live" -> live).asInstanceOf[ChangesOptions]

}

trait ReplicateOptions extends js.Object {

  var live: UndefOr[Boolean] = js.native
  var retry: UndefOr[Boolean] = js.native
  var filter: UndefOr[Boolean] = js.native
  var query_params: UndefOr[String] = js.native
  var doc_ids: UndefOr[js.Array[String]] = js.native
  var since: UndefOr[String] = js.native
  var create_target: UndefOr[Boolean] = js.native
  var batch_size: UndefOr[Int] = js.native
  var batches_limit: UndefOr[Int] = js.native

}

object ReplicateOptions {

  def apply(live: UndefOr[Boolean] = false,
            doc_ids: UndefOr[js.Array[String]] = js.undefined,
            batches_limit: UndefOr[Int] = js.undefined,
            batch_size: UndefOr[Int] = js.undefined,
            query_params: UndefOr[String] = js.undefined,
            create_target: UndefOr[Boolean] = false,
            retry: UndefOr[Boolean] = false,
            filter: UndefOr[Boolean] = false,
            since: UndefOr[String] = js.undefined) =
    json("create_target" -> create_target, "since" -> since, "filter" -> filter, "query_params" -> query_params, "batches_limit" -> batches_limit, "batch_size" -> batch_size, "retry" -> retry, "doc_ids" -> doc_ids, "live" -> live).asInstanceOf[ReplicateOptions]
}

trait Replicate extends js.Object {
  def to(remoteDB: String, options: ReplicateOptions): ChangesEventEmitter = js.native

  def from(remoteDB: String, options: ReplicateOptions): ChangesEventEmitter = js.native
}


trait QueryOptions extends js.Object {
  var reduce: UndefOr[Boolean] = js.native
  var include_docs: UndefOr[Boolean] = js.native
  var conflicts: UndefOr[Boolean] = js.native
  var attachments: UndefOr[Boolean] = js.native
  var startkey: UndefOr[String] = js.native
  var endkey: UndefOr[String] = js.native
  var inclusive_end: UndefOr[Boolean] = js.native
  var limit:  UndefOr[Int]  = js.native
  var skip: UndefOr[Int] = js.native
  var descending: UndefOr[Boolean] = js.native
  var key: UndefOr[String] = js.native
  var keys: UndefOr[js.Array[String]] = js.native
  var group: UndefOr[Boolean] = js.native
  var group_level: UndefOr[Int] = js.native
  var stale: UndefOr[String] = js.native
}

object QueryOptions {

  def apply( skip: UndefOr[Int] = js.undefined,
             attachments: UndefOr[Boolean] = false,
             descending: UndefOr[Boolean] = false,
             key: UndefOr[String] = js.undefined,
             endkey: UndefOr[String] = js.undefined,
             startkey: UndefOr[String] = js.undefined,
             include_docs: UndefOr[Boolean] = false,
             inclusive_end: UndefOr[Boolean] = false,
             reduce: UndefOr[Boolean] = false,
             stale: UndefOr[String] = js.undefined,
             group_level: UndefOr[Int] = js.undefined,
             conflicts: UndefOr[Boolean] = false,
             limit:  UndefOr[Int]  = js.undefined,
             group: UndefOr[Boolean] = false,
             keys: UndefOr[js.Array[String]] = js.undefined) =
    json("attachments" -> attachments,"reduce" -> reduce,"include_docs" -> include_docs,"skip" -> skip,"startkey" -> startkey,"limit" -> limit,"descending" -> descending,"group_level" -> group_level,"endkey" -> endkey,"key" -> key,"conflicts" -> conflicts,"group" -> group,"keys" -> keys,"stale" -> stale,"inclusive_end" -> inclusive_end).asInstanceOf[QueryOptions]


}

trait PouchDBDebug extends js.Object {
  def enable(to: String = "*"): Unit = js.native

  def disable(): Unit = js.native

}

trait GetOptions extends js.Object {

  var rev: UndefOr[String] = js.native

  var revs: UndefOr[Boolean] = js.native

  var revs_info: UndefOr[Boolean] = js.native

  var open_revs: UndefOr[js.Dynamic] = js.native

  var conflicts: UndefOr[Boolean] = js.native

  var attachments: UndefOr[Boolean] = js.native

  var ajax: js.UndefOr[PouchDBAjaxOptions] = js.native


}

object GetOptions {
  def apply(revs_info: UndefOr[Boolean] = false,
            conflicts: UndefOr[Boolean] = false,
            revs: UndefOr[Boolean] = false,
            attachments: UndefOr[Boolean] = false,
            open_revs: UndefOr[js.Dynamic] = js.undefined,
            rev: UndefOr[String] = js.undefined,
            ajax: js.UndefOr[PouchDBAjaxOptions] = js.undefined) =
    json("attachments" -> attachments, "conflicts" -> conflicts, "revs" -> revs, "open_revs" -> open_revs, "rev" -> rev, "revs_info" -> revs_info, "ajax" -> ajax).asInstanceOf[GetOptions]

}

case class PouchDBException(err: js.Dynamic) extends Exception


@JSName("PouchDB")
class PouchDBJS extends js.Object {

  var _db_name  : String = js.native

  def this(name: js.UndefOr[String] = js.undefined, options: js.UndefOr[PouchDBOptions] = js.undefined) = this()

  def destroy(callback: CALLBACK = ???): Unit = js.native

  @JSName("destory")
  def destroyWithOptions(options: js.UndefOr[js.Dynamic] = js.undefined, callback: CALLBACK = ???): Unit = js.native

  def put(doc: js.Dynamic, docId: js.UndefOr[String] = js.undefined, docRev: js.UndefOr[String] = js.undefined, options: js.UndefOr[js.Object] = js.undefined, callback: CALLBACK = ???): Unit = js.native

  def post(doc: js.Dynamic, options: js.UndefOr[js.Dynamic] = js.undefined, callback: CALLBACK = ???): Unit = js.native

  @JSName("get")
  def getWithCallback(docId: String, options: js.UndefOr[GetOptions] = GetOptions(), callback: CALLBACK = ???): Unit = js.native

  //  def get(docId: String, options: js.UndefOr[GetOptions] = GetOptions()): Promise[js.Dynamic] = js.native

  def remove(doc: js.Object, options: UndefOr[js.Dynamic] = js.undefined, callback: CALLBACK = ???): Unit = js.native

  @JSName("remove")
  def removeWithId(docId: String, docRev: String, options: UndefOr[js.Dynamic] = js.undefined, callback: CALLBACK = ???): Unit = js.native

  def bulkDocs(docs: js.Any, options: UndefOr[js.Dynamic] = js.undefined, callback: CALLBACK = ???): Unit = js.native

  def allDocs(options: AllDocsOptions = ???, callback: CALLBACK = ???): Unit = js.native

  def changes(options: ChangesOptions = ???): ChangesEventEmitter = js.native

  val replicate: Replicate = js.native

  def sync(remoteDB: String, options: ReplicateOptions = ???): ChangesEventEmitter = js.native

  def putAttachment(docId: String, attachmentId: String, rev: String, attachment: dom.Blob, `type`: String, callback: CALLBACK = ???): Unit = js.native

  def getAttachment(docId: String, attachmentId: String, options: UndefOr[js.Dynamic] = js.undefined, callback: CALLBACK = ???): Unit = js.native

  def removeAttachment(docId: String, attachmentId: String, rev: String, callback: CALLBACK = ???): Unit = js.native

  def query(fun: js.Function, options: QueryOptions = ???, callback: CALLBACK = ???): Unit = js.native

  def viewCleanup(options: UndefOr[js.Dynamic] = js.undefined, callback: CALLBACK = ???): Unit = js.native

  def info(callback: CALLBACK): Unit = js.native

  def compact(options: UndefOr[js.Dynamic] = js.undefined, callback: CALLBACK = ???): Unit = js.native

  def revsDiff(diff: js.Array[String], callback: CALLBACK = ???): Unit = js.native

}


@JSName("PouchDB")
object PouchDBJS extends EventEmitter {
  type CALLBACK = js.Function2[js.UndefOr[js.Dynamic], js.UndefOr[js.Dynamic], _]

  def replicate(source: String, target: String, options: ReplicateOptions = ???): ChangesEventEmitter = js.native

  def sync(src: String, target: String, options: ReplicateOptions = ???): ChangesEventEmitter = js.native

  def defaults(options: js.Dynamic): PouchDBJS = js.native

  def plugin(plugins: js.Dynamic): Unit = js.native

  val debug: PouchDBDebug = js.native
}


