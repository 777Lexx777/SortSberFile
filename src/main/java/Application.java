import java.util.logging.Logger;
import rw.ReaderAndWriteFileSber;

public class Application {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static Logger log = Logger.getLogger(Application.class.getName());

  public static void main(String[] args) {
    ReaderAndWriteFileSber readerFile = new ReaderAndWriteFileSber();
    if(args.length == 3){
      readerFile.copyAndSorted(args[0],args[1],args[2]);
    }else {
      log.info(ANSI_BLUE+ "НЕ верное реданы аргументы! " + ANSI_RESET);
    }
  }
}
