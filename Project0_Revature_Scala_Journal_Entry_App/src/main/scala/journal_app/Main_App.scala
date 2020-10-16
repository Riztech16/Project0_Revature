package journal_app

import java.util.Date

import scala.io.StdIn
import scala.util.matching.Regex

class Main_App {

  //Welcome Message
  def Welcome_message():Unit={
    println("Hello! Welcome To Journal App.")
    print("Please Enter Your Name: ")


  }

  def File_Requestor():Unit={
    print("Please enter the file name (csv): ")

    }


  def File_Ask():Unit={
  print("Would you like to import a csv file for the files you have written? (Y or N): ")
  }

  def File_Ask_Dates():Unit={
    print("Would you like to import a csv file containing the dates to fetch the journal entries for? (Y or N): ")
  }




  //User Options
  def User_Options_CRUD():Unit={
    println("Would like to you like to Read, Update, or Delete Entry? Type Update, Delete, or Read ")
  }

  //Verifying user commands via regex
  val commandArgPattern : Regex = "(\\w)".r
  val commandArgPattern1 : Regex = "(\\w+)".r



  //MAIN APP "GUI"
  def main_app:Unit= {

    Welcome_message()
    val Name_Storage: String = StdIn.readLine()


    //Always True while loop


      File_Ask()
      StdIn.readLine() match {
        case commandArgPattern(cmd) if cmd.equalsIgnoreCase("Y") => {
          File_Requestor()
          val File_Name: String = StdIn.readLine()
          CSV_File_Parser.parser(File_Name, Name_Storage)
        }

        case commandArgPattern(cmd) if cmd.equalsIgnoreCase("N") => {
          User_Options_CRUD()
          StdIn.readLine() match {

            case commandArgPattern1(cmd) if cmd.equalsIgnoreCase("Read") => {
              File_Ask_Dates()
              StdIn.readLine() match {
                case commandArgPattern(cmd) if cmd.equalsIgnoreCase("Y") => {
                  File_Requestor()
                  val File_Name: String = StdIn.readLine()
                  CSV_File_Parser.date_parser(File_Name,Name_Storage)

                }
                case commandArgPattern(cmd) if cmd.equalsIgnoreCase("N") => {
                }
              }
            }
              /*
            case commandArgPattern1(cmd) if cmd.equalsIgnoreCase("Update") => {
              File_Ask_Dates()
              StdIn.readLine() match {
                case commandArgPattern(cmd) if cmd.equalsIgnoreCase("Y") => {
                  File_Requestor()
                  val File_Name: String = StdIn.readLine()
                }
                case commandArgPattern(cmd) if cmd.equalsIgnoreCase("N") => {
                }
              }
            }

            case commandArgPattern1(cmd) if cmd.equalsIgnoreCase("Delete") => {
              File_Ask_Dates()
              StdIn.readLine() match {
                case commandArgPattern(cmd) if cmd.equalsIgnoreCase("Y") => {
                  File_Requestor()
                  val File_Name: String = StdIn.readLine()
                }
                case commandArgPattern(cmd) if cmd.equalsIgnoreCase("N") => {
                }
              }

            }
              */
          }
        }

      }
  }
}
