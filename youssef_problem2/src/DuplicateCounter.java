// Samira Youssef
// sa855342

import java.util.*;
import java.io.*;

public class DuplicateCounter
{
  private HashMap<String, Integer> wordCounter;

  public DuplicateCounter()
  {
    wordCounter = new HashMap<>();
  }

  public void count(String dataFile)
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

    // Iterate through the file and add each word to the map.
    // Increment if necessary.
    while (sc.hasNext())
    {
      // Capitalization does not matter, so store the lower case
      // version.
      String word = sc.next().toLowerCase();

      if (wordCounter.containsKey(word))
      {
        int count = wordCounter.get(word);
        wordCounter.put(word, count + 1);
      }
      else
      {
        wordCounter.put(word, 1);
      }
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
    for (String word : wordCounter.keySet())
    {
      try
      {
        fileWriter.write(word + ": " + wordCounter.get(word) + "\n");
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
