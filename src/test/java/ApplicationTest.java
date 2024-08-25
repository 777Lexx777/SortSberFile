import static org.fest.assertions.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import rw.ReaderAndWriteFileSber;


public class ApplicationTest {
  ReaderAndWriteFileSber readerFileSber = new ReaderAndWriteFileSber();
  String readFileDuplicate = "src/test/java/util/TestFileRead.sh"; //duplicate
  String wright = "src/test/java/util/testFileReadAll.txt";
  String readFileEmpty = "src/test/java/util/TestFileReadEmpty.sh";
  String writeEmpty = "src/test/java/util/TestFileWrigtEmpty.txt";


@Test
  void deleteDuplicateKey() throws IOException {
    // when
    BufferedReader br = new BufferedReader(new FileReader(readFileDuplicate));
    int initialQuantity = 0;

    while (br.readLine() != null) {
      initialQuantity = initialQuantity + 1;
    }
    br.close();

    readerFileSber.copyAndSorted(readFileDuplicate, wright , "=");

    //then
    BufferedReader brW = new BufferedReader(new FileReader(wright));
    int resultQuantity = 0;
    while (brW.readLine() != null) {
      resultQuantity = resultQuantity + 1;

    }
    brW.close();

    assertThat(resultQuantity < initialQuantity).isTrue();

  }

  @Test
  void deleteDuplicateEmptyString() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(readFileEmpty));
    int initialQuantity = 0;
    while (br.readLine() != null) {
      initialQuantity = initialQuantity + 1;
    }
    br.close();

    readerFileSber.copyAndSorted(readFileDuplicate, wright , "=");

    //then
    BufferedReader brW = new BufferedReader(new FileReader(writeEmpty ));
    int resultQuantity = 0;
    while (brW.readLine() != null) {
      resultQuantity = resultQuantity + 1;

    }
    brW.close();
    assertThat(resultQuantity < initialQuantity).isTrue();
  }
}
