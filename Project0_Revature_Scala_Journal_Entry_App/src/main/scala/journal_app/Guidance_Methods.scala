package journal_app

object Guidance_Methods {

  def Welcome_message():Unit={
    println("Hello! Welcome To Journal App.")
    print("Please Enter Your Name: ")
  }

  def File_Ask():Unit={
    print("Would you like to import a csv file for the files you have written? (Y or N): ")
  }

  def File_Requestor():Unit={
    print("Please enter the file name (csv): ")

  }

  //User Options
  def User_Options_CRUD():Unit={
    println("Would like to you like to Read, Update, or Delete Entry? Type Update, Delete, or Read ")
  }

  def File_Ask_Dates():Unit={
    print("Import the file containing the date or dates for which you want the entries retrieved (.csv): ")
  }

  def File_Ask_Dates_Update():Unit={
    print("Import the file containing the date or dates for which you want the entries to be updated (.csv): ")
  }

  def Ok_To_Update():Unit={
    print("Whenever ready type ok: ")
  }

  def File_Ok_To_Update():Unit={
    print("Please enter the file name (csv): ")

  }

  def File_Ask_Dates_Deleted():Unit={
    print("Import the file containing the date or dates for which you want the entries deleted (.csv): ")
  }
  def Exit_Message():Unit={
    println("Goodbye Take Care")
  }
}
