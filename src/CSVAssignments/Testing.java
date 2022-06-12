package CSVAssignments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.csv.CSVParser;
import org.junit.jupiter.api.*;
import edu.duke.*;

public class Testing {

    @Test
    void findColdestHour() {
        FileResource fr = new FileResource("data/2013/weather-2013-01-23.csv");
        CSVParser parser = fr.getCSVParser();
        
        assertEquals(19.0, ColdestDay.coldestHourInFile(parser));
        assertEquals(1,1);
    }
    
}