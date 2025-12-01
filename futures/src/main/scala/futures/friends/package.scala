package futures
package friends

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}
import scala.collection.concurrent.TrieMap

case class User(id: String, friends: List[String])

case class UserNotFound(id: String) extends Exception(s"User $id not found")
case class UserIdsDoNotMatch(id1: String, id2: String) extends Exception(s"User ids $id1 and $id2 do not match")

trait Database:
  /** Gets a user by its id asynchronously.
    *
    * @param id
    *   Id of the user.
    * @return
    *   A `Future` that will resolve to the queried [[User]].
    */
  def getUser(id: String): Future[User]

  /** Updates a user in the database asynchronously.
    *
    * @param currentValue
    *   Current value of the user.
    * @param newValue
    *   New value of the user.
    * @return
    *   A `Future` that will resolve to `true` if the operation was successful,
    *   or `false` otherwise.
    */
  def updateUser(currentValue: User, newValue: User): Future[Boolean]

  /** Gets a user by its id asynchronously.
    *
    * @param id
    *   Id of the user.
    * @param callback
    *   Callback to call with the queried [[User]].
    */
  def getUserWithCallback(id: String)(callback: User => Unit): Unit

  /** Updates a user in the database asynchronously.
    *
    * @param currentValue
    *   Current value of the user.
    * @param newValue
    *   New value of the user.
    * @param callback
    *   Callback to call with the result of the operation. The result will be
    *   `true` if the operation was successful, or `false` otherwise.
    */
  def updateUserWithCallback(currentValue: User, newValue: User)(callback: Boolean => Unit): Unit

def makeFriendsWithCallback(
    user1Id: String,
    user2Id: String,
    db: Database
)(
    callback: ((Boolean, Boolean)) => Any
): Unit =
  ???

def makeFriendsMonadicFlatMap(
    user1Id: String,
    user2Id: String,
    db: Database
): Future[(Boolean, Boolean)] =
  ???

def makeFriendsMonadicFor(
    user1Id: String,
    user2Id: String,
    db: Database
): Future[(Boolean, Boolean)] =
  ???

def makeFriendsDirect(
    user1Id: String,
    user2Id: String,
    db: Database
): Future[(Boolean, Boolean)] =
  ???

def makeFriendsMonadicParallel(
    user1Id: String,
    user2Id: String,
    db: Database
): Future[(Boolean, Boolean)] =
  ???

def makeFriendsMonadicParallelFor(
    user1Id: String,
    user2Id: String,
    db: Database
): Future[(Boolean, Boolean)] =
  ???

def makeFriendsDirectParallel(
    user1Id: String,
    user2Id: String,
    db: Database
): Future[(Boolean, Boolean)] =
  ???

class MockDatabase extends Database:
  private val data = TrieMap(
    "aisha" -> User("aisha", List("barbara")),
    "barbara" -> User("barbara", List("aisha", "carlos")),
    "carlos" -> User("carlos", List("barbara"))
  )

  def getUser(id: String): Future[User] =
    Future:
      Thread.sleep(1000)
      println(f"Get user $id")
      data.getOrElse(id, throw UserNotFound(id))

  def updateUser(currentValue: User, newValue: User): Future[Boolean] =
    Future:
      if currentValue.id != newValue.id then throw UserIdsDoNotMatch(currentValue.id, newValue.id)
      Thread.sleep(1000)
      println(f"Update user ${newValue.id}")
      data.replace(newValue.id, currentValue, newValue)

  def getUserWithCallback(id: String)(callback: User => Unit): Unit =
    getUser(id).foreach(callback)

  def updateUserWithCallback(currentValue: User, newValue: User)(callback: Boolean => Unit): Unit =
    updateUser(currentValue, newValue).foreach(callback)
