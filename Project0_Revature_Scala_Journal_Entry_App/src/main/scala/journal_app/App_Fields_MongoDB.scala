package journal_app
import org.bson.types.ObjectId
import java.text.SimpleDateFormat


case class App_Fields_MongoDB(_id: ObjectId, Name_entry:String, journal_entry: String, date_entry: Option[String])

object App_Fields_MongoDB {
  def apply( Name_entry:String,journal_entry: String, date_entry: Option[String]) : App_Fields_MongoDB = App_Fields_MongoDB(new ObjectId(), Name_entry,journal_entry, date_entry)
}
