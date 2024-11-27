package controllers;
import ihm.MenuPrincipal;
import persistance.ExamenRepository;
import persistance.SalleRepository;
import services.*;

public class ControllerPrincipal {

	SalleController salleController;
	ExamenController examenController;
	MedPrescriController medPrescriController;
	MedRadioController medRadioController;
	TechController techController;
	MenuPrincipal menuPrincipal;

	public ControllerPrincipal() {
		this.salleController = new SalleController(new SalleService(new SalleRepository(20)));
		this.examenController = new ExamenController(new ExamenServices());
		this.medPrescriController = new MedPrescriController(new MedPrescriServices());
		this.medRadioController = new MedRadioController(new MedRadioServices());
		this.techController = new TechController(new TechServices());
		this.menuPrincipal = new MenuPrincipal(this);
	}

	public void init() {
		System.out.println("Welcome to the Radiology Center Management System");
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
}

