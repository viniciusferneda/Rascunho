package arredondamento;

import java.math.BigDecimal;

public class Arredondamento {

	public static void main(String[] args) {
		BigDecimal vlCobradoCredora = new BigDecimal(6333528.92).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal vlContestadoCredora = new BigDecimal(437461.05).setScale(2, BigDecimal.ROUND_HALF_UP);

		Integer vlCobradoPercentualCredora = vlCobradoCredora.multiply(new BigDecimal(100))
				.divide((vlContestadoCredora.add(vlCobradoCredora)), 0, BigDecimal.ROUND_HALF_UP).intValue();
		Integer vlContestadoPercentualCredora = vlContestadoCredora.multiply(new BigDecimal(100))
				.divide((vlCobradoCredora.add(vlContestadoCredora)), 0, BigDecimal.ROUND_HALF_UP).intValue();

		BigDecimal vlCobradoDevedora = new BigDecimal(2168408.66).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal vlContestadoDevedora = new BigDecimal(82774.13).setScale(2, BigDecimal.ROUND_HALF_UP);

		Integer vlCobradoPercentualDevedora = vlCobradoDevedora.multiply(new BigDecimal(100))
				.divide((vlContestadoDevedora.add(vlCobradoDevedora)), 0, BigDecimal.ROUND_HALF_UP).intValue();
		Integer vlContestadoPercentualDevedora = vlContestadoDevedora.multiply(new BigDecimal(100))
				.divide((vlCobradoDevedora.add(vlContestadoDevedora)), 0, BigDecimal.ROUND_HALF_UP).intValue();

		System.out.println("********Credora**********");
		System.out.println("Cobrado (R$) = " + vlCobradoCredora);
		System.out.println("Cobrado (%) = " + vlCobradoPercentualCredora);
		System.out.println("Contestado (R$) = " + vlContestadoCredora);
		System.out.println("Contestado (%) = " + vlContestadoPercentualCredora);

		System.out.println("********Devedora**********");
		System.out.println("Cobrado (R$) = " + vlCobradoDevedora);
		System.out.println("Cobrado (%) = " + vlCobradoPercentualDevedora);
		System.out.println("Contestado (R$) = " + vlContestadoDevedora);
		System.out.println("Contestado (%) = " + vlContestadoPercentualDevedora);

	}
}
