package trackrtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import trackr.Avis;
import java.util.Date;

public class AvisTest {

	@Test
	public void testGetNombreEtoiles() {
		Avis avis = new Avis(null, null, new Date(), "Super film", 5);
		assertEquals(5, avis.getNombreEtoiles(), "Le nombre d'étoiles doit être 5");
	}
}
