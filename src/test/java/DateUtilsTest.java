/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rwl.dateutils.DateUtils;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rainwhileloop
 */
public class DateUtilsTest {

    public DateUtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void yearFormatTest() {
        Date date = new GregorianCalendar(2015, 7, 4).getTime();
        String year = DateUtils.format(date, DateUtils.YEAR_PATTERN);
//        System.out.println("expected year Output : " + expectedOutput);
        assertEquals("2015", year);
        
        date = new GregorianCalendar(2010, 8, 5).getTime();
        year = DateUtils.format(date, "YYYY");
//        System.out.println("expected year Output : " + expectedOutput);
        assertEquals(year, "2010");
    }
    
    @Test
    public void thaiBuddhistDateTest(){
        String strDate = DateUtils.getThaiBuddhistDate(2558, 8, 4, "d-MMM-yyyy");
        System.out.println("thai date is : " + strDate);
        assertEquals("4-Aug-2558",strDate);
        
        strDate = DateUtils.getThaiBuddhistDate(2558, 8, 31, "dd-MMM-yyyy");
        System.out.println("thai date is : " + strDate);
        assertEquals("31-Aug-2558",strDate);
        
        strDate = DateUtils.getThaiBuddhistDate(2558, 13, 31, "dd-MMM-yyyy");
        System.out.println("thai date is : " + strDate);
        assertNull(strDate);
    }
}
