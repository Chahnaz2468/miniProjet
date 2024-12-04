package controllers;
import ihm.MenuPrincipal;
import persistance.CentreRepository;
import persistance.CompteRenduRepository;
import persistance.PatientRepository;

import ihm.PatientIhm;
import services.*;

public class ControllerPrincipal {
	CentreController centreController;
	SalleController salleController;
	ExamenController examenController;
	MedPrescriController medPrescriController;
	MedRadioController medRadioController;
	TechController techController;
	PatientController patientController;
	DossierMedController dossierMedController;
	RendezVousController rendezVousController;
	CompteRenduController compteRenduController;
	FinanceController financeController;
	MenuPrincipal menuPrincipal;

	public ControllerPrincipal() {
		this.centreController=new CentreController(new CentreServices(new CentreRepository()));
		this.salleController = new SalleController(new services.SalleService(new persistance.SalleRepository()));
		this.examenController = new ExamenController(new ExamenServices());
		this.medPrescriController = new MedPrescriController(new MedPrescriServices());
		this.medRadioController = new MedRadioController(new MedRadioServices());
		this.techController = new TechController(new TechServices());
		this.patientController = new PatientController(new PatientService(new PatientRepository()));
		this.dossierMedController = new DossierMedController(new DossierMedServices());
		this.rendezVousController = new RendezVousController(new RendezVousServices());
		this.compteRenduController=new CompteRenduController(new CompteRenduServices(new CompteRenduRepository(new CentreRepository())));
		this.financeController=new FinanceController(new FinanceServices());
		this.menuPrincipal = new MenuPrincipal(this);
	}

	public void init() {

		menuPrincipal.showMenu();
	}

	public void gestionCentre() {centreController.init();}

	public void gestionSalle() {
		salleController.init();
	}

	public void gestionExamens() {
		examenController.init();
	}

	public void gestionMedPrescris() {
		medPrescriController.init();
	}

	public void gestionMedRadios() {
		medRadioController.init();
	}

	public void gestionTech() {
		techController.init();
	}

    public void gestionPatient() {patientController.init();}

	public void gestionDossierMed() {dossierMedController.init();}

	public void gestionRendezVous() {rendezVousController.init();}

	public void gestionCompteRendu() {compteRenduController.init();}

	public void gestionFinance(){financeController.init();}
}


