package rw;

import com.github.davidmoten.bigsorter.Sorter;
import java.io.File;
import java.util.logging.Logger;

public class ReaderAndWriteFileSber {
  public static Logger log = Logger.getLogger(ReaderAndWriteFileSber.class.getName());
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public void copyAndSorted(String pathRead, String pathWrite, String  slit) {

    try{
      File input = new File(pathRead);
      File output = new File(pathWrite);
      Sorter
          .serializerLinesUtf8()
          .comparator((a, b) ->
          {String id1 = a.substring(0, a.indexOf(slit));
            String id2 = b.substring(0, b.indexOf(slit));
            return id1.compareTo(id2);
          })
          .input(input)
          .filter(str ->  !str.isEmpty())
          .output(output)
          .unique()
          .sort();
      log.info(ANSI_GREEN+ "File is ready." + pathWrite + ANSI_RESET );

    }catch (Exception e) {
      System.err.println("НЕ верный путь к файлу " +pathRead + " !");
      e.printStackTrace();
    }

  }
}
