package controllers;
import ihm.MenuPrincipal;
import service.*;

public class ControllerPrincipal {

	SalleController salleController;
	ExamenController examenController;
	MedPrescriController medPrescriController;
	MedRadioController medRadioController;
	TechController techController;
	PatientController patientController;
	MenuPrincipal menuPrincipal;

	public ControllerPrincipal() {
		this.salleController = new SalleController(new SalleService(new SalleRepository(20)));
		this.examenController = new ExamenController(new ExamenServices());
		this.medPrescriController = new MedPrescriController(new MedPrescriServices());
		this.medRadioController = new MedRadioController(new MedRadioServices());
		this.techController = new TechController(new TechServices());
		this.patientController = new PatientController(new PatientServices());
		this.menuPrincipal = new MenuPrincipal(this);
	}

	public void init() {

		menuPrincipal.showMenu();
	}

	public void gestionSalle() {
		salleController.init();
	}

	public void gestionExamens() {
		examenController.showExamenMenu();
	}

	public void gestionMedPrescris() {
		medPrescriController.showMedPrescriMenu();
	}

	public void gestionMedRadios() {
		medRadioController.showMedRadioMenu();
	}

	public void gestionTech() {
		techController.showTechMenu();
	}

    public void gestionPatient() {
	PatientController.showPatientMenu();
}
}

