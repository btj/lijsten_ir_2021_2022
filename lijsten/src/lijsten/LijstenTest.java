package lijsten;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LijstenTest {

	@Test
	void test() {
		NietLegeLijst eenTweeDrie = new NietLegeLijst(1,
				new NietLegeLijst(2,
						new NietLegeLijst(3, new LegeLijst())));
		Lijst mijnLijst = eenTweeDrie;
		
		assertEquals(3, mijnLijst.getLength());
		assertEquals(1, eenTweeDrie.getKop());
		Lijst tweeDrie = new NietLegeLijst(2, new NietLegeLijst(3, new LegeLijst()));
		assertEquals(tweeDrie, eenTweeDrie.getStaart());
		assertNotEquals(tweeDrie, eenTweeDrie);
		assertEquals("[1, 2, 3]", eenTweeDrie + "");
		assertEquals("[]", new LegeLijst() + "");
		Lijst tweeTweeDrie = new NietLegeLijst(2, tweeDrie);
		assertNotEquals(eenTweeDrie, tweeTweeDrie);
	}

}
