import com.company.EmploymentOpportunity;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

public class EmploymentOpportunityTest {
    @Test
    public void testGetPlaceForPeople_1() throws Exception {
        EmploymentOpportunity employmentOpportunity = new EmploymentOpportunity(new Scanner(new File("src/test/peoplePlaceTest1.txt")));
        long actual = employmentOpportunity.getPlacesForPeople();
        long expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPlaceForPeople_2() throws Exception {
        EmploymentOpportunity employmentOpportunity = new EmploymentOpportunity(new Scanner(new File("src/test/peoplePlaceTest2.txt")));
        long actual = employmentOpportunity.getPlacesForPeople();
        long expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPlaceForPeople_3() throws Exception {
        EmploymentOpportunity employmentOpportunity = new EmploymentOpportunity(new Scanner(new File("src/test/peoplePlaceTest3.txt")));
        long actual = employmentOpportunity.getPlacesForPeople();
        long expected = 4;
        Assert.assertEquals(expected, actual);
    }
}
