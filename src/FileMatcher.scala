/**
 * Taken from page 169 in 'Programming in scala 2'nd edition'
 */

object FileMatcher {
  
  private def filesHere : Array[java.io.File] = (new java.io.File("d:\\downloads")).listFiles()
  
  /**
   * filesMatching takes a function argument called matcher.
   * The function matcher takes a String parameter and returns a boolean
   */
  private def filesMatching() = 
    for(file <- filesHere; if(!file.isDirectory()))
    	yield file

  def filesEnding() = 
    filesMatching()
    
    def main(args:Array[String]) {

      val dir : java.io.File = new java.io.File("d:\\downloads\\created");  
      dir.mkdir();
      
      val pdfFileArray : List[java.io.File] = filesEnding().toList
      
      val fileNameSet = pdfFileArray.groupBy(_.getName().split('.').last).keys
      
      for(fileName <- fileNameSet){
        println(fileName)
      }
    }

}