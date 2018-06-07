package chapter4.part06.web_service_stubbing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import chapter4.CalculateNAV;

public class CalculateNAVTest {
	@Test
	public void computeStockWorth() {
		final CalculateNAV calculateNAV = new CalculateNAV(ticker -> new BigDecimal("6.01"));
		assertEquals(0, calculateNAV.computeStockWorth("GOOG", 1000));
	}
}
