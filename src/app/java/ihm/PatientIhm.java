package ihm;

import controllers.ControllerPrincipal;
import controllers.PatientController;
import entities.Patient;


import exceptions.PatientRedondanceException;

import java.util.List;
import java.util.Scanner;

public class PatientIhm {
    PatientController patientController;

    public PatientIhm() {}

    public PatientIhm(PatientController patientController) {

        this.patientController = patientController;
    }

    public void showPatientMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Menu Gestion des patients =====");
            System.out.println("1. Afficher les patients");
            System.out.println("2. Afficher un patient");
            System.out.println("3. modifier un patient");
            System.out.println("4. retirer un patient");
            System.out.println("5. Retour au Menu Principal");
            System.out.print("Choisissez une option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Patient> patients = patientController.afficherPatients();
                    if (patients != null) {
                        for (Patient p : patients) {

                                System.out.printf("Patient id: %d, nom:%s, prenom:%s, telephone:%s, date de naissance: %s,  adresse: %s",
                                        p.getId(), p.getNom(),p.getPrenom(),p.getTelephone(),p.getDateNaissance(), p.getAddresse());

                        }
                    }
                    else
                        System.out.println("Aucun patient à afficher");
                    break;
                case 2:
                    this.trouverPatient();
                    break;
                case 3:
                    patients = patientController.afficherPatients();
                    if (patients.isEmpty()) {
                        System.out.println("Aucun patient n'est enregistré.");
                        break;
                    }

                    System.out.println("Entrez l'id du patient à modifier:");
                    int id = scanner.nextInt();
                    if (id <= 0 || id > patients.size()) {
                        System.out.println("Le patient avec l'ID " + id + " n'existe pas.");
                        break;
                    }else{
                        System.out.println("Entrez la nouvelle date de naissance");
                        String dateNaissance=scanner.nextLine();
                        System.out.println("Entrez la nouvelle addresse");
                        String addresse=scanner.nextLine();
                        System.out.println("Entrez le nom");
                        String nom=scanner.nextLine();
                        System.out.println("Entrez le prénom");
                        String prenom=scanner.nextLine();
                        System.out.println("Entrez le nouveau numéro de téléphone ");
                        String telephone = scanner.next();
                        Patient newPatient = new Patient(id, nom, prenom, telephone, dateNaissance, addresse);
                        patientController.modifiererPatient(id, newPatient);
                        System.out.println("Le patient a été modifié.");
                    }
                    break;
                case 4:
                    patients = patientController.afficherPatients();
                    if (patients.isEmpty()) {
                        System.out.println("Aucun patient n'est enregistré.");
                        break;
                    }
                    System.out.println("Entrez l'id de Patient à retirer:");
                    id = scanner.nextInt();
                    Patient patientToRemove = patientController.trouverPatient(id);
                    if (patientToRemove == null) {
                        System.out.println("Le patient avec l'ID " + id + " n'existe pas.");
                    } else {
                        patientController.retirerPatient(id);
                        System.out.println("Le patient avec l'ID " + id + " a été retiré.");
                    }
                    break;
                case 5:
                    ControllerPrincipal controllerPrincipal = new ControllerPrincipal();
                    controllerPrincipal.init();
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice !=5);
    }

    public Patient saisirPatient(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du patient:");
        String nom= scanner.next();
        System.out.println("Entrez le prénom du patient:");
        String prenom= scanner.next();
        System.out.println("Entrez le numéro de téléphone du patient:");
        String telephone = scanner.next();
        System.out.println("Entrez le date de naissance du patient:");
        String dateNaissance= scanner.next();
        System.out.println("Entrez l'addesse du patient:");
        String addresse= scanner.next();
        return new Patient(id, nom, prenom, telephone, dateNaissance, addresse);
    }

    public void trouverPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id de patient à trouver:");
        int id = scanner.nextInt();
        List<Patient> patients = patientController.afficherPatients();
        if (patients.isEmpty()) {
            System.out.println("Aucun patient n'est enregistré.");
            return;
        }
        if (id <= 0 || id > patients.size()) {
            System.out.println("L'id de patient n'existe pas.");
        } else {
            Patient p = patientController.trouverPatient(id);
            System.out.println("Nom du patient: " + p.getNom());
            System.out.println("Prénom du patient: " + p.getPrenom());
            System.out.println("Numéro de téléphone: " + p.getTelephone());
            System.out.println("Date de naissance: " + p.getDateNaissance());
            System.out.println("Adresse: " + p.getAddresse());
        }
    }
}

