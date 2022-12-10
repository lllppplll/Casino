package Main;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

class WinningLineSlots {

	@Test
	void SlotsThreeOrTwoOfAKind() {
		
		//Arrange
		Slots test = new Slots();
		
		//Act
		int[] output = test.SlotsThreeOrTwoOfAKind(1,2,0);
		
		//Assert
		int[] a = {1,0};
		assertEquals(a[0], output[0]);
		assertEquals(a[1], output[1]);
	}
	
	@Test
	void PriceOfWinningLine() {
		
		//Arrange
		Slots test = new Slots();
		
		//Act
		double output = test.PriceOfWinningLine(2,0);
		
		//Assert
		Double a = 0.2;
		assertEquals(a, output);
	}
	
	@Test
	void GetPlayerProfit() {
		
		//Arrange
		Slots test = new Slots();
		//decimal form of cash
		DecimalFormat df = new DecimalFormat("0.00");
		
		//Act
		double output = test.Collect(0.75, 0.25, 0);
		String c = df.format(output);
		//Assert
		double a = -0.50;
		String b = df.format(a);

		assertEquals(b, c);
	}

}
