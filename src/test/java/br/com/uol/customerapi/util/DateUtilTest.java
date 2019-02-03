package br.com.uol.customerapi.util;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void shouldConvertToDate() {
        assertEquals(DateUtil.convertToDate("dd-MM-yyyy", "01-02-2019"), new Date(1548990000000L));
    }

    @Test
    public void shouldConvertToPattern() {
        assertEquals(DateUtil.convertToPattern("dd-MM-yyyy", new Date(1549074359848L)), "01-02-2019");
    }

}