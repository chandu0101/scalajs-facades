package chandu0101.scalajs.facades.pouchdb

import chandu0101.scalajs.facades.pouchdb.PouchDBJS.CALLBACK
import org.scalajs.dom

import scala.concurrent.{Promise, Future}
import scala.scalajs.js
import scala.scalajs.js.UndefOr

/**
 * Created by chandrasekharkode .
 */
class PouchDB(pouchDBJS : PouchDBJS) {

  val name : String = pouchDBJS._db_name

  def wrapPouchCall(f: (PouchDBJS.CALLBACK) => Unit) = {
    val promise = Promise[js.Dynamic]()
    f((err: js.UndefOr[js.Dynamic], response: js.UndefOr[js.Dynamic]) => {
      if (js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def get(docId: String, options: js.UndefOr[GetOptions] = GetOptions()) : Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.getWithCallback(docId,options,cb))
  }

  def destroy(options: js.UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.destroy(cb))
  }

  def put(doc: js.Dynamic, docId: js.UndefOr[String] = js.undefined, docRev: js.UndefOr[String] = js.undefined, options: js.UndefOr[js.Object] = js.undefined): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.put(doc,docId,docRev,options,cb))
  }

  def post(doc: js.Dynamic, options: js.UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.post(doc,options,cb))
  }

  def remove(doc: js.Object, options: UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.remove(doc,options,cb))
  }

  def removeWithId(docId: String, docRev : String, options: UndefOr[js.Dynamic] = js.undefined): Unit = {
    wrapPouchCall(cb => pouchDBJS.removeWithId(docId,docRev,options,cb))
  }


  def bulkDocs(docs: js.Any, options: UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.bulkDocs(docs,options,cb))
  }

  def allDocs(options: AllDocsOptions = AllDocsOptions()): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.allDocs(options,cb))
  }

  def changes(options : ChangesOptions = ChangesOptions()) : ChangesEventEmitter = {
    pouchDBJS.changes(options)
  }

  val replicate: Replicate = pouchDBJS.replicate

  def putAttachment(docId: String, attachmentId: String, rev: String, attachment: dom.Blob, `type`: String): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.putAttachment(docId,attachmentId,rev,attachment,`type`,cb))
  }

  def getAttachment(docId: String, attachmentId: String, options: UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.getAttachment(docId,attachmentId,options,cb))
  }

  def removeAttachment(docId: String, attachmentId: String, rev: String): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.removeAttachment(docId,attachmentId,rev,cb))
  }

  def query(fun: js.Function, options: QueryOptions = QueryOptions()): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.query(fun,options,cb))
  }

  def viewCleanup(options: UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.viewCleanup(options,cb))
  }

  def info: Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.info(cb))
  }

  def compact(options: UndefOr[js.Dynamic] = js.undefined) :Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.compact(options,cb))
  }

  def revsDiff(diff: js.Array[String]):Future[js.Dynamic] = {
    wrapPouchCall(cb => pouchDBJS.revsDiff(diff,cb))
  }

  def sync(remoteDB: String, options: ReplicateOptions = ReplicateOptions()): ChangesEventEmitter = pouchDBJS.sync(remoteDB,options)

}

object PouchDB {
  // may be there is better way ,lets find out latter
  def create(name: js.UndefOr[String] = js.undefined, options: js.UndefOr[PouchDBOptions] = js.undefined) = new PouchDB(new PouchDBJS(name,options))

  def replicate(source: String, target: String, options: ReplicateOptions = ReplicateOptions()): ChangesEventEmitter = PouchDBJS.replicate(source,target,options)

  def sync(src: String, target: String, options: ReplicateOptions = ReplicateOptions()): ChangesEventEmitter = PouchDBJS.sync(src,target,options)

  def plugin(plugins: js.Dynamic): Unit = PouchDBJS.plugin(plugins)

  def enableDebug(to : String = "*") = PouchDBJS.debug.enable(to)
  
  def disableDebug = PouchDBJS.debug.disable()
}
