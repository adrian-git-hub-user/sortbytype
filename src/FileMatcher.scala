/**
 * Taken from page 169 in 'Programming in scala 2'nd edition'
 */

object FileMatcher {
  
  private def filesHere = (new java.io.File("d:\\downloads")).listFiles()
  
  /**
   * filesMatching takes a function argument called matcher.
   * The function matcher takes a String parameter and returns a boolean
   */
  private def filesMatching(matcher: (String) => Boolean) = 
    for(file <- filesHere; if matcher(file.getName))
    	yield file

  def filesEnding(query: String) = 
    filesMatching(_.endsWith(query))
    
    def main(args:Array[String]) {
     // println("here")
      val pdfFileArray = filesEnding(".pdf")
      val dir = new java.io.File("d:\\downloads\\nameoffolder");  
      dir.mkdir();
      
      for(fileName <- pdfFileArray){
        println(fileName)
      }
    }

}