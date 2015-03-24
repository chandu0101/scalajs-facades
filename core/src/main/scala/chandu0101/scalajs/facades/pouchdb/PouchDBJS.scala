package chandu0101.scalajs.facades.pouchdb

import chandu0101.scalajs.facades._
import chandu0101.scalajs.facades.pouchdb.PouchDBJS.CALLBACK
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode .
 */


trait PouchDBAjaxOptions extends js.Object

object PouchDBAjaxOptions extends PouchDBAjaxOptionsBuilder(noOpts)

class PouchDBAjaxOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PouchDBAjaxOptions, PouchDBAjaxOptionsBuilder](new PouchDBAjaxOptionsBuilder(_)) {

  def headers(v: String) = jsOpt("headers", v)

  def cache(v: Boolean) = jsOpt("cache", v)

}


trait PouchDBOptions extends js.Object

object PouchDBOptions extends PouchDBOptionsBuilder(noOpts)

class PouchDBOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PouchDBOptions, PouchDBOptionsBuilder](new PouchDBOptionsBuilder(_)) {

  def auto_compaction(v: Boolean) = jsOpt("auto_compaction", v)

  def adapter(v: String) = jsOpt("adapter", v)

  def name(v: String) = jsOpt("name", v)

  def ajax(v: PouchDBAjaxOptions) = jsOpt("ajax", v)

}


trait AllDocsOptions extends js.Object

object AllDocsOptions extends AllDocsOptionsBuilder(noOpts)

class AllDocsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[AllDocsOptions, AllDocsOptionsBuilder](new AllDocsOptionsBuilder(_)) {

  def startkey(v: String) = jsOpt("startkey", v)

  def descending(v: Boolean) = jsOpt("descending", v)

  def keys(v: js.Array[String]) = jsOpt("keys", v)

  def key(v: String) = jsOpt("key", v)

  def inclusive_end(v: Boolean) = jsOpt("inclusive_end", v)

  def conflicts(v: Boolean) = jsOpt("conflicts", v)

  def include_docs(v: Boolean) = jsOpt("include_docs", v)

  def skip(v: Int) = jsOpt("skip", v)

  def attachments(v: Boolean) = jsOpt("attachments", v)

  def endkey(v: String) = jsOpt("endkey", v)

  def limit(v: Int) = jsOpt("limit", v)

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


trait ChangesOptions extends js.Object

object ChangesOptions extends ChangesOptionsBuilder(noOpts)

class ChangesOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ChangesOptions, ChangesOptionsBuilder](new ChangesOptionsBuilder(_)) {

  def doc_ids(v: js.Array[String]) = jsOpt("doc_ids", v)

  def descending(v: Boolean) = jsOpt("descending", v)

  def live(v: Boolean) = jsOpt("live", v)

  def returnDocs(v: Boolean) = jsOpt("returnDocs", v)

  def style(v: String) = jsOpt("style", v)

  def batch_size(v: Int) = jsOpt("batch_size", v)

  def since(v: String) = jsOpt("since", v)

  def view(v: js.Function) = jsOpt("view", v)

  def conflicts(v: Boolean) = jsOpt("conflicts", v)

  def include_docs(v: Boolean) = jsOpt("include_docs", v)

  def attachments(v: Boolean) = jsOpt("attachments", v)

  def limit(v: Int) = jsOpt("limit", v)

  def filter(v: Boolean) = jsOpt("filter", v)

}


trait ReplicateOptions extends js.Object

object ReplicateOptions extends ReplicateOptionsBuilder(noOpts)

class ReplicateOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ReplicateOptions, ReplicateOptionsBuilder](new ReplicateOptionsBuilder(_)) {

  def live(v: Boolean) = jsOpt("live", v)

  def retry(v: Boolean) = jsOpt("retry", v)

  def doc_ids(v: js.Array[String]) = jsOpt("doc_ids", v)

  def query_params(v: String) = jsOpt("query_params", v)

  def batch_size(v: Int) = jsOpt("batch_size", v)

  def since(v: String) = jsOpt("since", v)

  def filter(v: Boolean) = jsOpt("filter", v)

  def create_target(v: Boolean) = jsOpt("create_target", v)

  def batches_limit(v: Int) = jsOpt("batches_limit", v)

}


trait Replicate extends js.Object {
  def to(remoteDB: String, options: ReplicateOptions = ???): ChangesEventEmitter = js.native

  def from(remoteDB: String, options: ReplicateOptions = ???): ChangesEventEmitter = js.native
}


trait QueryOptions extends js.Object

object QueryOptions extends QueryOptionsBuilder(noOpts)

class QueryOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[QueryOptions, QueryOptionsBuilder](new QueryOptionsBuilder(_)) {

  def startkey(v: String) = jsOpt("startkey", v)

  def descending(v: Boolean) = jsOpt("descending", v)

  def reduce(v: Boolean) = jsOpt("reduce", v)

  def key(v: String) = jsOpt("key", v)

  def inclusive_end(v: Boolean) = jsOpt("inclusive_end", v)

  def include_docs(v: Boolean) = jsOpt("include_docs", v)

  def skip(v: Int) = jsOpt("skip", v)

  def endkey(v: String) = jsOpt("endkey", v)

  def limit(v: Int) = jsOpt("limit", v)

  def keys(v: js.Array[String]) = jsOpt("keys", v)

  def stale(v: String) = jsOpt("stale", v)

  def group(v: Boolean) = jsOpt("group", v)

  def group_level(v: Int) = jsOpt("group_level", v)

  def conflicts(v: Boolean) = jsOpt("conflicts", v)

  def attachments(v: Boolean) = jsOpt("attachments", v)

}


trait PouchDBDebug extends js.Object {
  def enable(to: String = "*"): Unit = js.native

  def disable(): Unit = js.native

}


trait GetOptions extends js.Object

object GetOptions extends GetOptionsBuilder(noOpts)

class GetOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GetOptions, GetOptionsBuilder](new GetOptionsBuilder(_)) {

  def revs(v: Boolean) = jsOpt("revs", v)

  def revs_info(v: Boolean) = jsOpt("revs_info", v)

  def open_revs(v: js.Dynamic) = jsOpt("open_revs", v)

  def conflicts(v: Boolean) = jsOpt("conflicts", v)

  def rev(v: String) = jsOpt("rev", v)

  def attachments(v: Boolean) = jsOpt("attachments", v)

  def ajax(v: PouchDBAjaxOptions) = jsOpt("ajax", v)

}


trait FindOptions extends js.Object

object FindOptions extends FindOptionsBuilder(noOpts)

class FindOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[FindOptions,FindOptionsBuilder](new FindOptionsBuilder(_)) {

  def selector(v: js.Object) = jsOpt("selector",v)

  def limit(v: Int) = jsOpt("limit",v)

  def skip(v: Int) = jsOpt("skip",v)

  def sort(v: JArray[String]) = jsOpt("sort",v)

  def fields(v: JArray[String]) = jsOpt("fields",v)


}



trait QuickSearchOptions extends js.Object

object QuickSearchOptions extends QuickSearchOptionsBuilder(noOpts)

class QuickSearchOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[QuickSearchOptions, QuickSearchOptionsBuilder](new QuickSearchOptionsBuilder(_)) {

  def highlighting_post(v: String) = jsOpt("highlighting_post", v)

  def stale(v: String) = jsOpt("stale", v)

  def mm(v: Int) = jsOpt("mm", v)

  def query(v: String) = jsOpt("query", v)

  def skip(v: Int) = jsOpt("skip", v)

  def filter(v: js.Function1[js.Dynamic, Boolean]) = jsOpt("filter", v)

  def include_docs(v: Boolean) = jsOpt("include_docs", v)

  def destroy(v: Boolean) = jsOpt("destroy", v)

  def build(v: Boolean) = jsOpt("build", v)

  def fields(v: js.Array[String]) = jsOpt("fields", v)

  def fieldsBoosting(v: js.Object) = jsOpt("fields", v)

  def highlighting(v: Boolean) = jsOpt("highlighting", v)

  def highlighting_pre(v: String) = jsOpt("highlighting_pre", v)

  def limit(v: Int) = jsOpt("limit", v)

}


trait IndexOptions extends js.Object

object IndexOptions extends IndexOptionsBuilder(noOpts)

class IndexOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[IndexOptions,IndexOptionsBuilder](new IndexOptionsBuilder(_)) {

  def ddoc(v: String) = jsOpt("ddoc",v)

  def fields(v: JArray[String]) = jsOpt("fields",v)

  def tpe(v: String) = jsOpt("type",v)

  def name(v: String) = jsOpt("name",v)

}


trait CreateIndexOptions extends js.Object

object CreateIndexOptions extends CreateIndexOptionsBuilder(noOpts)

class CreateIndexOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[CreateIndexOptions,CreateIndexOptionsBuilder](new CreateIndexOptionsBuilder(_)) {
  def index(v: IndexOptions) = jsOpt("index",v)
}

case class PouchDBException(err: js.Dynamic) extends Exception


@JSName("PouchDB")
class PouchDBJS extends js.Object {

  var _db_name: String = js.native

  def this(name: UndefOr[String] = undefined, options: UndefOr[PouchDBOptions] = undefined) = this()

  def destroy(callback: CALLBACK = ???): Unit = js.native

  @JSName("destory")
  def destroyWithOptions(options: UndefOr[js.Dynamic] = undefined, callback: CALLBACK = ???): Unit = js.native

  def put(doc: js.Dynamic, docId: UndefOr[String] = undefined, docRev: UndefOr[String] = undefined, options: UndefOr[js.Object] = undefined, callback: CALLBACK = ???): Unit = js.native

  def post(doc: js.Dynamic, options: UndefOr[js.Dynamic] = undefined, callback: CALLBACK = ???): Unit = js.native

  @JSName("get")
  def getWithCallback(docId: String, options: UndefOr[GetOptions] = undefined, callback: CALLBACK = ???): Unit = js.native

  def get(docId: String, callback: CALLBACK = ???): Unit = js.native

  //  def get(docId: String, options: js.UndefOr[GetOptions] = GetOptions()): Promise[js.Dynamic] = js.native

  def remove(doc: js.Object, options: UndefOr[js.Dynamic] = undefined, callback: CALLBACK = ???): Unit = js.native

  @JSName("remove")
  def removeWithId(docId: String, docRev: String, options: UndefOr[js.Dynamic] = undefined, callback: CALLBACK = ???): Unit = js.native

  def bulkDocs(docs: js.Any, options: UndefOr[js.Dynamic] = undefined, callback: CALLBACK = ???): Unit = js.native

  def allDocs(options: AllDocsOptions = ???, callback: CALLBACK = ???): Unit = js.native

  def changes(options: ChangesOptions = ???): ChangesEventEmitter = js.native

  val replicate: Replicate = js.native

  def sync(remoteDB: String, options: ReplicateOptions = ???): ChangesEventEmitter = js.native

  def putAttachment(docId: String, attachmentId: String, rev: String, attachment: dom.Blob, `type`: String, callback: CALLBACK = ???): Unit = js.native

  def getAttachment(docId: String, attachmentId: String, options: UndefOr[js.Dynamic] = undefined, callback: CALLBACK = ???): Unit = js.native

  def removeAttachment(docId: String, attachmentId: String, rev: String, callback: CALLBACK = ???): Unit = js.native

  def query(fun: js.Function, options: QueryOptions = ???, callback: CALLBACK = ???): Unit = js.native

  def viewCleanup(options: UndefOr[js.Dynamic] = undefined, callback: CALLBACK = ???): Unit = js.native

  def info(callback: CALLBACK): Unit = js.native

  def compact(options: UndefOr[js.Dynamic] = undefined, callback: CALLBACK = ???): Unit = js.native

  def revsDiff(diff: js.Array[String], callback: CALLBACK = ???): Unit = js.native

  def search(options: QuickSearchOptions, callback: CALLBACK): Unit = js.native

  def createIndex(options: CreateIndexOptions,callback : CALLBACK) : Unit = js.native

  def getIndexes(callback : CALLBACK) : Unit = js.native

  def deleteIndex(index : js.Object,callback: CALLBACK):Unit = js.native

  def find(request : FindOptions,callback : CALLBACK) : Unit = js.native

}


@JSName("PouchDB")
object PouchDBJS extends EventEmitter {

  type CALLBACK = js.Function2[UndefOr[js.Dynamic], UndefOr[js.Dynamic], _]

  def replicate(source: String, target: String, options: ReplicateOptions = ???): ChangesEventEmitter = js.native

  def sync(src: String, target: String, options: ReplicateOptions = ???): ChangesEventEmitter = js.native

  def defaults(options: js.Dynamic): PouchDBJS = js.native

  def plugin(plugins: js.Dynamic): Unit = js.native

  val debug: PouchDBDebug = js.native

}


