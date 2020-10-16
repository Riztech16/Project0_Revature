package journal_app

import org.mongodb.scala.{MongoClient, MongoCollection, Observable}

import scala.concurrent.Await
import scala.concurrent.duration.{Duration, SECONDS}
import org.mongodb.scala.bson.codecs.Macros._
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.model.Filters
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Updates._
import org.mongodb.scala.model.Sorts._
import org.mongodb.scala.model.Projections._

import scala.collection.mutable.ListBuffer

object CRUDER {

  val codecRegistry = fromRegistries(fromProviders(classOf[App_Fields_MongoDB]), MongoClient.DEFAULT_CODEC_REGISTRY)
  val client = MongoClient()
  val db = client.getDatabase("Notesdb").withCodecRegistry(codecRegistry)
  val collection: MongoCollection[App_Fields_MongoDB] = db.getCollection("notes")

  def getResults[T](obs: Observable[T]): Seq[T] = {
    Await.result(obs.toFuture(), Duration(10, SECONDS))

  }


  def Addone_or_Many(notes: String, date: String, Name: String): Unit = {
    getResults(collection.insertOne(App_Fields_MongoDB(Name_entry = Name, journal_entry = notes, date_entry = Some(date))))

  }
  /*
    def Update_One_Or_Many(notes: String, date: String, Name: String): Unit = {
      getResults(collection.insertOne(App_Fields_MongoDB(Name_entry = Name, journal_entry = notes, date_entry = Some(date))))

    }

    def Delete_One_Or_Many(notes: String, date: String, Name: String): Unit = {
      getResults(collection.insertOne(App_Fields_MongoDB(Name_entry = Name, journal_entry = notes, date_entry = Some(date))))
    }
  */

  def Read_Many(date:Array[String], Name: String): Unit = {
    var Notes_collected = new ListBuffer[String]
    var Dates_collected = new ListBuffer[String]

    for (d<-date) {
      val Results = getResults(collection.find(and(equal("Name_entry", Name), equal("date_entry", d))))(0)

      Notes_collected += Results.journal_entry
      Dates_collected += d
    }
      CSV_File_Creator.Read_out_file(Notes_collected.toList,Dates_collected.toList)
  }

  def Read_One(date:String, Name: String): Unit = {
    var Notes_collected = new ListBuffer[String]
    var Dates_collected = new ListBuffer[String]

    val Results = getResults(collection.find(and(equal("Name_entry", Name), equal("date_entry", date))))(0)

    Notes_collected += Results.journal_entry
    Dates_collected += date

    CSV_File_Creator.Read_out_file(Notes_collected.toList,Dates_collected.toList)
  }


}
