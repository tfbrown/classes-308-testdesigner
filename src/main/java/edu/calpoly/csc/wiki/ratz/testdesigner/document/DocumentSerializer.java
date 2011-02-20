package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * A singleton class that saves and loads Documents.
 * 
 * @author jdisanti
 */
public class DocumentSerializer {
   /**
    * Loads a document from a file.
    * 
    * @param fileName
    *           The file name of the file to load the document from.
    * @return The document that was in the file.
    * @throws IOException
    *            Upon failure to load the document.
    */
   public static Document load(String fileName) throws IOException {
      return load(new FileInputStream(new File(fileName)));
   }

   /**
    * Loads a document from an input stream.
    * 
    * @param stream
    *           The stream to load the document from.
    * @return The document that was in the stream.
    * @throws IOException
    *            Upon failure to load the document.
    */
   public static Document load(InputStream stream) throws IOException {
      ObjectInputStream objReader = new ObjectInputStream(stream);
      try {
         return (Document) objReader.readObject();
      }
      catch (ClassNotFoundException ex) {
         throw new IOException(ex);
      }
   }

   /**
    * Saves a document to file.
    * 
    * @param doc
    *           The document to save.
    * @param fileName
    *           The file name of the file to save the document to. This will be
    *           overwritten if it already exists.
    * @throws IOException
    *            Upon failure to write the file.
    */
   public static void save(Document doc, String fileName) throws IOException {
      save(doc, new FileOutputStream(new File(fileName)));
   }

   /**
    * Saves a document to a stream.
    * 
    * @param doc
    *           The document to save.
    * @param stream
    *           The stream to write the document to.
    * @throws IOException
    *            Upon failure to write the document to the stream.
    */
   public static void save(Document doc, OutputStream stream)
         throws IOException {
      ObjectOutputStream objWriter = new ObjectOutputStream(stream);
      objWriter.writeObject(doc);
   }
}
