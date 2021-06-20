package java8.inaction.chapter14.part03;

import java.util.function.DoubleUnaryOperator;

import org.junit.Test;

public class CurryingUsing {
	@Test
	public void curriedConverterTest() {
		DoubleUnaryOperator convertCtoF = Currying.curriedConverter(9.0/5, 32);
		DoubleUnaryOperator convertUSDtoGBP = Currying.curriedConverter(0.6, 0);
        DoubleUnaryOperator convertKmtoMi = Currying.curriedConverter(0.6214, 0);

        System.out.println(convertCtoF.applyAsDouble(24));
        System.out.println(convertUSDtoGBP.applyAsDouble(100));
        System.out.println(convertKmtoMi.applyAsDouble(20));

        DoubleUnaryOperator convertFtoC = Currying.expandedCurriedConverter(-32, 5.0/9, 0);
        System.out.println(convertFtoC.applyAsDouble(98.6));
	}
}
