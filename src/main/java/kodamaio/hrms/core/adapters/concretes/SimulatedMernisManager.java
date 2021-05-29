package kodamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodamaio.hrms.core.adapters.abstracts.SimulatedMernisService;

@Service
public class SimulatedMernisManager implements SimulatedMernisService{

	@Override
	public boolean checkMernis(String firstName, String lastName, String identityNumber, String birthYear) {
		if(firstName.length()<2 || lastName.length()<2 ) {
			System.out.println("İsim ve Soy isim uzunluğu boş bırakılamaz ve 2 den az karakterde olamaz");
			return false;
		}
		
		if(identityNumber.length()!=11 || identityNumber.startsWith("0")) {
			System.out.println("Kimlik numarası 11 karakterden oluşmalı ve 0 ile başlamamalı");
			return false;
		}
		
		if(birthYear.length()!=4) {
			System.out.println("doğum yılı bilgisi 4 karakterden oluşmalı");
			return false;
		}
		
		else {
			System.out.println("Kimlik doğrulama Başarılı!");
			return true;
		}
	}

}
