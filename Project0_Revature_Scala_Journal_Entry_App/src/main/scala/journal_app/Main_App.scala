package journal_app
import scala.io.StdIn
import scala.util.matching.Regex

class Main_App {

  //Verifying user commands via regex
  val commandArgPattern : Regex = "(\\w)".r
  val commandArgPattern1 : Regex = "(\\w+)".r

  //MAIN APP "GUI"
  def main_app:Unit= {

    Guidance_Methods.Welcome_message()
    val Name_Storage: String = StdIn.readLine()
    var continue_running_whileloop: Boolean = true

    //Always True while loop
    while(continue_running_whileloop) {
      Guidance_Methods.File_Ask()

      StdIn.readLine() match {
        case commandArgPattern(cmd) if cmd.equalsIgnoreCase("Y") => {
          Guidance_Methods.File_Requestor()
          val File_Name: String = StdIn.readLine()
          CSV_File_Parser.parser(File_Name, Name_Storage)
        }

        case commandArgPattern(cmd) if cmd.equalsIgnoreCase("N") => {
          Guidance_Methods.User_Options_CRUD()
          StdIn.readLine() match {

            case commandArgPattern1(cmd) if cmd.equalsIgnoreCase("Read") => {
              Guidance_Methods.File_Ask_Dates()
              val File_Name: String = StdIn.readLine()
              CSV_File_Parser.date_parser(File_Name, Name_Storage)
            }

            case commandArgPattern1(cmd) if cmd.equalsIgnoreCase("Update") => {
              Guidance_Methods.File_Ask_Dates()
              val File_Name: String = StdIn.readLine()
              CSV_File_Parser.date_parser(File_Name, Name_Storage)
              Guidance_Methods.File_Ok_To_Update()

              StdIn.readLine() match {
                case commandArgPattern1(cmd) if cmd.equalsIgnoreCase("Ok") => {
                  CSV_File_Parser.Update_parser("Update_Entries.csv", Name_Storage)
                }
              }
            }
            case commandArgPattern1(cmd) if cmd.equalsIgnoreCase("Delete") => {
              Guidance_Methods.File_Ask_Dates_Deleted()
              val File_Name: String = StdIn.readLine()
              CSV_File_Parser.date_delete_parser(File_Name, Name_Storage)
            }

          }
        }
        case commandArgPattern1(cmd) if cmd.equalsIgnoreCase("exit")=> continue_running_whileloop=false
        case notRecognized => println(s"$notRecognized not a recognized command")

      }
    }
  }
}
