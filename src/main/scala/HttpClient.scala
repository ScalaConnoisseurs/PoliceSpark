
import spray.http._
import spray.client.pipelining._
import akka.actor.ActorSystem

import scala.concurrent.Future


class HttpClient {

  implicit val system = ActorSystem("police-data-client")
  import system.dispatcher // execution context for futures

  val pipeline: HttpRequest => Future[HttpResponse] = sendReceive

  def getLastUpdatedDate() {
    // TODO: Add map(String=>Date)
    pipeline(Get("http://data.police.uk/api/crime-last-updated")).map(response=>response.toString)
  }
  

}
