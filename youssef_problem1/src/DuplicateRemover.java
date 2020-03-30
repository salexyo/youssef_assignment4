// Samira Youssef
// sa855342

import java.util.*;
import java.io.*;

public class DuplicateRemover
{
  private HashSet<String> uniqueWords;

  public DuplicateRemover()
  {
    uniqueWords = new HashSet<>();
  }

  public void remove(String dataFile)
  {
    Scanner sc = null;

    // Check if the file exists.
    try
    {
      sc = new Scanner(new File(dataFile));
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }

    // Iterate through the file and add each word to the set.
    while (sc.hasNext())
    {
      // Capitalization does not matter, so store the lower case
      // version.
      uniqueWords.add(sc.next().toLowerCase());
    }

    sc.close();
  }

  public void write(String outputFile)
  {
    Writer fileWriter = null;

    try
    {
      fileWriter = new FileWriter(outputFile, false);
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }

    // Write each word in the set to the specified file.
    // Note: Capitalization was not considered, so this will
    // print the lower case version of any unique word that was
    // seen in the input file.
    for (String word : uniqueWords)
    {
      try
      {
        fileWriter.write(word + " ");
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    // Close the file writer.
    try
    {
      fileWriter.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
