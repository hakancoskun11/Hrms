package kodamaio.hrms.core.utilities;

import kodamaio.hrms.services.FakeMernis;

public class IdentityValidation {
	public static boolean isRealPerson(String tcno) {
		FakeMernis mernis = new FakeMernis();
		return mernis.validate(tcno);
	}
}