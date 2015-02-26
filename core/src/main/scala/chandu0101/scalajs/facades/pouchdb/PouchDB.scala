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

  def get(docId: String, options: js.UndefOr[GetOptions] = GetOptions()) : Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.getWithCallback(docId,options,callback = (err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def destroy(options: js.UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.destroy((err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def put(doc: js.Dynamic, docId: js.UndefOr[String] = js.undefined, docRev: js.UndefOr[String] = js.undefined, options: js.UndefOr[js.Object] = js.undefined): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.put(doc,docId,docRev,options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def post(doc: js.Dynamic, options: js.UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.post(doc,options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def remove(doc: js.Object, options: UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.remove(doc,options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def removeWithId(docId: String, docRev : String, options: UndefOr[js.Dynamic] = js.undefined): Unit = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.removeWithId(docId,docRev,options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }


  def bulkDocs(docs: js.Any, options: UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.bulkDocs(docs,options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def allDocs(options: AllDocsOptions = AllDocsOptions()): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.allDocs(options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def changes(options : ChangesOptions = ChangesOptions()) : ChangesEventEmitter = {
    pouchDBJS.changes(options)
  }

  val replicate: Replicate = pouchDBJS.replicate

  def putAttachment(docId: String, attachmentId: String, rev: String, attachment: dom.Blob, `type`: String): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.putAttachment(docId,attachmentId,rev,attachment,`type`,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def getAttachment(docId: String, attachmentId: String, options: UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.getAttachment(docId,attachmentId,options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def removeAttachment(docId: String, attachmentId: String, rev: String): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.removeAttachment(docId,attachmentId,rev,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def query(fun: js.Function, options: QueryOptions = QueryOptions()): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.query(fun,options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def viewCleanup(options: UndefOr[js.Dynamic] = js.undefined): Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.viewCleanup(options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def info: Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.info((err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def compact(options: UndefOr[js.Dynamic] = js.undefined) :Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.compact(options,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
  }

  def revsDiff(diff: js.Array[String]):Future[js.Dynamic] = {
    val promise = Promise[js.Dynamic]
    pouchDBJS.revsDiff(diff,(err : js.UndefOr[js.Dynamic], response :js.UndefOr[js.Dynamic]) => {
      if(js.isUndefined(err) || err == null) promise.success(response.get)
      else promise.failure(PouchDBException(err.get))
    })
    promise.future
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
