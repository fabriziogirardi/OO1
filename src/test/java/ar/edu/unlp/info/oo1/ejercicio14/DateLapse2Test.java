package ar.edu.unlp.info.oo1.ejercicio14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateLapse2Test
{
    Intervalable dateLapse;

    @BeforeEach
    void setUp()
    {
        LocalDate from = LocalDate.of(2021, 2, 1);

        dateLapse = new DateLapse2(from, 9);
    }

    @Test
    void getFrom()
    {
        assertEquals(LocalDate.of(2021, 2, 1), dateLapse.getFrom());
    }

    @Test
    void getTo()
    {
        assertEquals(LocalDate.of(2021, 2, 10), dateLapse.getTo());
    }

    @Test
    void sizeInDays()
    {
        assertEquals(9, dateLapse.sizeInDays());
    }

    @Test
    void includesDate()
    {
        assertTrue(dateLapse.includesDate(LocalDate.of(2021, 2, 1)));
        assertTrue(dateLapse.includesDate(LocalDate.of(2021, 2, 10)));
        assertTrue(dateLapse.includesDate(LocalDate.of(2021, 2, 5)));
        assertFalse(dateLapse.includesDate(LocalDate.of(2021, 2, 11)));
        assertFalse(dateLapse.includesDate(LocalDate.of(2021, 1, 31)));
        assertFalse(dateLapse.includesDate(null));
    }
}