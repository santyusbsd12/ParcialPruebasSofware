package com.tdea.parcial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTests {

    @Test
    public void TheHourIsBetweenZeroAndSix() {
    	String resultado = Utils.getTimeOfDay(4);
    	
    	Assertions.assertEquals("Night", resultado);
    }
    
    @Test
    public void TheHourIsBetweenSixAndTwelve() {
    	String resultado = Utils.getTimeOfDay(8);
    	
    	Assertions.assertEquals("Morning", resultado);
    }
    
    @Test
    public void TheHourIsBetweenTwelveAndEighteen() {
    	String resultado = Utils.getTimeOfDay(17);
    	
    	Assertions.assertEquals("Afternoon", resultado);
    }
    
    @Test
    public void TheHourIsAfterOfEighteen() {
    	String resultado = Utils.getTimeOfDay(22);
    	
    	Assertions.assertEquals("Evening", resultado);
    }
    
    @Test
    public void TheHourIsOutsideLine() {
    	String resultado = Utils.getTimeOfDay(30);
    	
    	Assertions.assertEquals("Invalid hour", resultado);
    }
}
