package journal_app

import scala.io.Source

object CSV_File_Parser {

 def parser(filename:String,Person_Name:String):Unit={

   val bufferedSource = Source.fromFile(filename)
   for (line <- bufferedSource.getLines()) {
     val Array(notes,date) = line.split(",")
      CRUDER.Add_One_or_Many(notes,date,Person_Name)
   }

 }

  def date_parser(filename:String,Person_Name:String):Unit={

    val bufferedSource = Source.fromFile(filename)
    for (line <- bufferedSource.getLines()) {

      if(line.contains(',')) {
        val date = line.split(",")
        CRUDER.Read_Many(date,Person_Name)
      }
      else{
        CRUDER.Read_One(line,Person_Name)
      }
    }

  }

  def Update_parser(filename:String,Person_Name:String):Unit={

    val bufferedSource = Source.fromFile(filename)
    for (line <- bufferedSource.getLines()) {
      val Array(notes,date) = line.split(",")
      CRUDER.Update_One_or_Many(notes,date,Person_Name)
    }

  }

  def date_delete_parser(filename:String,Person_Name:String):Unit={

    val bufferedSource = Source.fromFile(filename)
    for (line <- bufferedSource.getLines()) {

      if(line.contains(',')) {
        val date = line.split(",")
        CRUDER.Delete_Many(date,Person_Name)
      }
      else{
        CRUDER.Delete_One(line,Person_Name)
      }
    }
  }

}
