package journal_app
import java.io._
object CSV_File_Creator {

  def Read_out_file(notes:List[String],dates:List[String]):Unit={
  val pw = new PrintWriter(new File("Readout.csv"))
    for(n <- 0 to (dates.length-1)){
      pw.write(notes(n)+","+dates(n)+"\n")
    }
    pw.close
  }

}
