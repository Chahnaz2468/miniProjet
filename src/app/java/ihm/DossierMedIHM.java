package ihm;

import controllers.DossierMedController;
import controllers.PatientController;
import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DossierMedIHM {
    private DossierMedController dmc;
    private PatientController pc;

    public DossierMedIHM() {}

    public DossierMedIHM(DossierMedController dmc) {
        this.dmc = dmc;
    }

    public DossierMedController getDmc() {
        return dmc;
    }

    public void setDmc(DossierMedController dmc) {
        this.dmc = dmc;
    }

    public void showDossierMedMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n===== Menu Gestion des dossiers medicaux =====");
            System.out.println("1. Modifier un dossier");
            System.out.println("2. Retirer un dossier");
            System.out.println("3. trouver un dossier");
            System.out.println("4. Afficher les dossiers");
            System.out.println("5. Retour au Menu Principal");
            System.out.print("Choisissez une option: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un entier.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    this.modifierTypeExLastOrd();
                    break;
                case 2:
                    this.supprimerDossierMed();
                    break;
                case 3:
                    this.findDossierMedByPatientId();
                    break;
                case 4:
                    this.afficherDossierMeds();
                    break;
                case 5:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 5);
    }

    public DossierMed saisir() {
        Scanner sc = new Scanner(System.in);
        Ordonnance ord = new Ordonnance();
        ord.ajouterOrdonnance();
        DossierMed dossierMed;
        System.out.println("Veuillez saisir l'id de patient:");
        int id = sc.nextInt();
        if (dmc.find(id) == null) {
            Patient patient = new Patient();
            System.out.println("Veuillez saisir le patient: ");
            pc.ajouterPatient(patient);
            System.out.println("Veuillez saisir l'id du dossier: ");
            int idd = sc.nextInt();
            List<Ordonnance> ords= new ArrayList<>();
            ords.add(ord);
            dossierMed=new DossierMed(idd,patient,ords);
        }else{
            dossierMed=dmc.find(id);
            List<Ordonnance> ords=dossierMed.getOrds();
            ords.add(ord);
        }
        if (dmc.ajout(dossierMed) ==1)
            System.out.println("succes ");
        else
            System.out.println("Erreur");
        return dossierMed;
    }

    public void modifierTypeExLastOrd() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du dossier à modifier': ");
        int id = sc.nextInt();
        System.out.println("Veuillez saisir le nouveau type d'examen : ");
        String input = sc.next().toUpperCase();
        TypeExamen typeExamen = TypeExamen.valueOf(input);
        switch(dmc.modif(id,typeExamen)){
            case -3:
                System.out.println("Erreur");
                break;
            case -2:
                System.out.println("Aucune ordonnance à modifier.");
                break;
            case -1:
                System.out.println("Le fichier est vide ou inexistant.");
                break;
            case 0:
                System.out.println("Aucun dossier médical trouvé avec cet ID.");
                break;
            case 1:
                System.out.println("Modification faite avec succes.");
                break;
        }
    }

    public void supprimerDossierMed() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du dossier à supprimer: ");
        int id = sc.nextInt();
        switch(dmc.supp(id)){
            case -2:
                System.out.println("Erreur");
                break;
            case -1:
                System.out.println("Le fichier est vide ou inexistant.");
                break;
            case 0:
                System.out.println("Aucun dossier médical trouvé avec cet ID.");
                break;
            case 1:
                System.out.println("Suppresion faite avec succes.");
                break;
        }
    }

    public void afficherDossierMeds() {
        /*List<DossierMed> dossierMeds=dmc.affich();
        if (dossierMeds == null || dossierMeds.isEmpty()) {
            System.out.println("Aucun dossier à afficher.");
            return;
        }

        for (DossierMed dossierMed : dossierMeds) {
            System.out.println("dossier:");
            System.out.println("  ID dossier: " + dossierMed.getId());
            System.out.println("patient");
            System.out.println("  ID: " + dossierMed.getPatient().getId());
            System.out.println("  Nom: " + dossierMed.getPatient().getNom());
            System.out.println("  Prenom: " + dossierMed.getPatient().getPrenom());
            System.out.println("  telephone: " + dossierMed.getPatient().getTelephone());
            System.out.println("  date de naissance: " + dossierMed.getPatient().getDateNaissance());
            System.out.println("  addresse: " + dossierMed.getPatient().getAddresse());
            System.out.println("-----------------------------");
            List<Ordonnance> ords=dossierMed.getOrds();
            for (Ordonnance ord : ords) {
                System.out.println("Ordonnance");
                System.out.println("  Id: " + ord.getId());
                System.out.println("  medecin prescripteur: ");
                System.out.println("  ID: " + ord.getMedPrescri().getId());
                System.out.println("  nom: " + ord.getMedPrescri().getNom());
                System.out.println("  prenom: " + ord.getMedPrescri().getPrenom());
                System.out.println("  telephone: " + ord.getMedPrescri().getTelephone());
                System.out.println("  Specialite: " + ord.getMedPrescri().getSpecialite());
                System.out.println("-----------------------------");
            }
            System.out.println("-----------------------------");
        }*/
        try {
            List<DossierMed> dossierMeds = dmc.affich();
            if (dossierMeds.isEmpty()) {
                System.out.println("Aucun dossier à afficher.");
            } else {
                for (DossierMed dossierMed : dossierMeds) {
                    System.out.println("dossier:");
                    System.out.println("  ID dossier: " + dossierMed.getId());
                    System.out.println("patient");
                    System.out.println("  ID: " + dossierMed.getPatient().getId());
                    System.out.println("  Nom: " + dossierMed.getPatient().getNom());
                    System.out.println("  Prenom: " + dossierMed.getPatient().getPrenom());
                    System.out.println("  telephone: " + dossierMed.getPatient().getTelephone());
                    System.out.println("  date de naissance: " + dossierMed.getPatient().getDateNaissance());
                    System.out.println("  addresse: " + dossierMed.getPatient().getAddresse());
                    System.out.println("-----------------------------");
                    List<Ordonnance> ords=dossierMed.getOrds();
                    for (Ordonnance ord : ords) {
                        System.out.println("Ordonnance");
                        System.out.println("  Id: " + ord.getId());
                        System.out.println("  medecin prescripteur: ");
                        System.out.println("  ID: " + ord.getMedPrescri().getId());
                        System.out.println("  nom: " + ord.getMedPrescri().getNom());
                        System.out.println("  prenom: " + ord.getMedPrescri().getPrenom());
                        System.out.println("  telephone: " + ord.getMedPrescri().getTelephone());
                        System.out.println("  Specialite: " + ord.getMedPrescri().getSpecialite());
                        System.out.println("-----------------------------");
                    }
                    System.out.println("-----------------------------");
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    public void findDossierMedByPatientId(){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du patient propriétaire du dossier à trouver: ");
        int id = sc.nextInt();
        DossierMed dossierMed;
        if (dmc.find(id) == null)
            System.out.println("Erreur");
        else {
            dossierMed = dmc.find(id);
            System.out.println("dossier:");
            System.out.println("  ID dossier: " + dossierMed.getId());
            System.out.println("patient");
            System.out.println("  ID: " + dossierMed.getPatient().getId());
            System.out.println("  Nom: " + dossierMed.getPatient().getNom());
            System.out.println("  Prenom: " + dossierMed.getPatient().getPrenom());
            System.out.println("  telephone: " + dossierMed.getPatient().getTelephone());
            System.out.println("  date de naissance: " + dossierMed.getPatient().getDateNaissance());
            System.out.println("  addresse: " + dossierMed.getPatient().getAddresse());
            System.out.println("-----------------------------");
            List<Ordonnance> ords=dossierMed.getOrds();
            for (Ordonnance ord : ords) {
                System.out.println("Ordonnance");
                System.out.println("  Id: " + ord.getId());
                System.out.println("  medecin prescripteur: ");
                System.out.println("  ID: " + ord.getMedPrescri().getId());
                System.out.println("  nom: " + ord.getMedPrescri().getNom());
                System.out.println("  prenom: " + ord.getMedPrescri().getPrenom());
                System.out.println("  telephone: " + ord.getMedPrescri().getTelephone());
                System.out.println("  Specialite: " + ord.getMedPrescri().getSpecialite());
                System.out.println("-----------------------------");
            }
            System.out.println("-----------------------------");
        }*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du patient propriétaire du dossier à trouver: ");
        int id = sc.nextInt();

        try {
            DossierMed dossierMed = dmc.find(id);
            System.out.println("dossier:");
            System.out.println("  ID dossier: " + dossierMed.getId());
            System.out.println("patient");
            System.out.println("  ID: " + dossierMed.getPatient().getId());
            System.out.println("  Nom: " + dossierMed.getPatient().getNom());
            System.out.println("  Prenom: " + dossierMed.getPatient().getPrenom());
            System.out.println("  telephone: " + dossierMed.getPatient().getTelephone());
            System.out.println("  date de naissance: " + dossierMed.getPatient().getDateNaissance());
            System.out.println("  addresse: " + dossierMed.getPatient().getAddresse());
            System.out.println("-----------------------------");
            List<Ordonnance> ords=dossierMed.getOrds();
            for (Ordonnance ord : ords) {
                System.out.println("Ordonnance");
                System.out.println("  Id: " + ord.getId());
                System.out.println("  medecin prescripteur: ");
                System.out.println("  ID: " + ord.getMedPrescri().getId());
                System.out.println("  nom: " + ord.getMedPrescri().getNom());
                System.out.println("  prenom: " + ord.getMedPrescri().getPrenom());
                System.out.println("  telephone: " + ord.getMedPrescri().getTelephone());
                System.out.println("  Specialite: " + ord.getMedPrescri().getSpecialite());
                System.out.println("-----------------------------");
            }
            System.out.println("-----------------------------");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}

