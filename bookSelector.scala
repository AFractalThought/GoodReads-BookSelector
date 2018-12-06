object bookSelector extends App {

  import scala.xml.XML
  import scala.util.Random

  val queryStart = "https://www.goodreads.com/review/list/" 
  val key = "Plt3iqOPsprkANSAmD6mWw"

  // this call is used to get number of books from bookshelf and for the final call
  def buildCall_Piece1(id: String, shelf: String): String = {
    queryStart ++ id ++ ".xml?key=" ++ key ++ "&v=2&shelf=" ++ shelf
  }

  // the call requires the number of books to list from the bookshelf
  // since we are randomly selecting from the whole  bookshelf, we want the total number
  // as of now the max number that will be selected is 200. will update later.
  def getTotalNumberOfBooks(callPiece1: String): Int = {
    val xml = XML.load(callPiece1)
    val n = ((xml \\ "reviews")(0) \ "@total").toString.toInt
    if (n < 200) n else 200
  }

  // this is the final call to retrieves all the books in the bookshelf
  def buildCall(callPiece1: String, totalBooksInShelf: Int): String = {       
    callPiece1 ++ "&per_page=" ++ totalBooksInShelf.toString ++ "&sort=num_ratings"
  }

  // this retrieves the necessary text
  def getTextFromXML(xml: scala.xml.Elem, query: String): List[String] = {
    val nodeSeqText = xml \\ query
    nodeSeqText.map(_.text).toList
  }

  // this is where the call is actually made, text extracted and book randomly selected
  def chooseBook(call: String, totalBooksInShelf: Int): String = {
    val xml = XML.load(call)
    val books = getTextFromXML(xml, "title")
    val authors = getTextFromXML(xml, "name")

    val n = scala.util.Random.nextInt(totalBooksInShelf)
    books(n) ++ " by " ++ authors(n)
  }

  // prompts for arguments to call
  val userId = scala.io.StdIn.readLine("What is your user id? \n (You can find it by going to your profile & looking at web address. \n For example the id for this user profile is 4333445: \n https://www.goodreads.com/user/show/4333445-arielle) \n")
  val bookShelf = scala.io.StdIn.readLine("What bookshelf do you want to randomly select from? ('to-read' is a common one) \n This can take up to 30 seconds. The API is quite slow.")
  
  // main
  val callPiece1 = buildCall_Piece1(userId, bookShelf)
  val totalBooksInShelf = getTotalNumberOfBooks(callPiece1)
  val call = buildCall(callPiece1, totalBooksInShelf)
  val selection = chooseBook(call, totalBooksInShelf)

  println(selection)

}
