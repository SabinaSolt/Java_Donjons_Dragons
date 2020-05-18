package main;

import armes.*;
import ennemies.*;
import potions.*;
import exceptions.PersonnageHorsPlateauException;

import java.util.ArrayList;
/**/

public class Plateau {
    private int derniereCase = 64;
    private int caseCourante = 1;
    private ArrayList<Case> listCases;
//    private String[] typeCaseSpec={"Dragon", "Sorcier", "Gobelin", "Massue", "Epee",
//    "Eclair", "BouleFeu", "PotionStandard", "PotionGrande"};
//    private int[] maxCaseSpec={4,10,10,5,4,5,2,6,2};
//    private int[] compteurCaseSpec={0,0,0,0,0,0,0,0,0};

    public Plateau() {
        this.listCases = new ArrayList();
        // initie le plateau avec les cases vides
        for (int i = 0; i < derniereCase; i++) {
            listCases.add(new CaseVide());
            // Switch commenté
//            switch (i + 1) {
//                case 45:
//                case 52:
//                case 56:
//                case 62:
//                    listCases.add(new Dragon());
//                    break;
//                case 10:
//                case 20:
//                case 25:
//                case 32:
//                case 35:
//                case 36:
//                case 37:
//                case 40:
//                case 44:
//                case 47:
//                    listCases.add(new Sorcier());
//                    break;
//
//                case 3:
//                case 6:
//                case 9:
//                case 12:
//                case 15:
//                case 18:
//                case 21:
//                case 24:
//                case 27:
//                case 30:
//                    listCases.add(new Gobelin());
//                    break;
//                case 2:
//                case 5:
//                case 11:
//                case 22:
//                case 38:
//                    listCases.add(new Massue());
//                    break;
//                case 19:
//                case 26:
//                case 42:
//                case 53:
//                    listCases.add(new Epee());
//                    break;
//                case 1:
//                case 4:
//                case 8:
//                case 17:
//                case 23:
//                    listCases.add(new Eclair());
//                    break;
//                case 48:
//                case 49:
//                    listCases.add(new BouleFeu());
//                    break;
//                case 7:
//                case 13:
//                case 31:
//                case 33:
//                case 39:
//                case 43:
//                    listCases.add(new PotionStandard());
//                    break;
//                case 28:
//                case 41:
//                    listCases.add(new PotionGrande());
//                    break;
//                case 64:
//                    listCases.add(new DernierCase());
//                    break;
//                default:
//                    listCases.add(new CaseVide());
            
        }

        listCases.set(derniereCase-1, new DernierCase());

        // Disposer les cases spéciales sur le plateau d'une manière aléatoire
        //Parcours les tableaux des cases spéciales
        //for(int i=0; i<maxCaseSpec.length; i++)
        for(ListCaseSpec caseK : ListCaseSpec.values()) {
            //Boucle répetée jusqu'à ce que le nombre des cases spéc atteigne son max
            do {
                int caseAleatoire = (int) (Math.random() * 63);
                if (listCases.get(caseAleatoire) instanceof CaseVide) {
                    listCases.set(caseAleatoire, caseK.getCaseACreer());

//                    switch(typeCaseSpec[i]) {
//                        case "Dragon":
//                            listCases.set(caseAleatoire, new Dragon());
//                            break;
//                        case "Sorcier":
//                            listCases.set(caseAleatoire, new Sorcier());
//                            break;
//                        case "Gobelin":
//                            listCases.set(caseAleatoire, new Gobelin());
//                            break;
//                        case "Massue":
//                            listCases.set(caseAleatoire, new Massue());
//                            break;
//                        case "Epee":
//                            listCases.set(caseAleatoire, new Epee());
//                            break;
//                        case "Eclair":
//                            listCases.set(caseAleatoire, new Eclair());
//                            break;
//                        case "BouleFeu":
//                            listCases.set(caseAleatoire, new BouleFeu());
//                            break;
//                        case "PotionStandard":
//                            listCases.set(caseAleatoire, new PotionStandard());
//                            break;
//                        case "PotionGrande":
//                            listCases.set(caseAleatoire, new PotionGrande());
//                            break;
//                    }

                    //   compteurCaseSpec[i]=compteurCaseSpec[i]+1;
                    caseK.incrementCompteurCase();
                }
                // } while (compteurCaseSpec[i]<maxCaseSpec[i]);
            } while (caseK.getCompteurCase()<caseK.getMaxCase());
        }
    }

    //Getters

    public int getDerniereCase() {
        return derniereCase;
    }

    public int getNumeroCaseCourante() {
        return caseCourante;
    }
    public Case getCase(int index) {

        if (index < 0 & index > derniereCase) {
            index = caseCourante;
        }
        return listCases.get(index);
    }

    //Setters
    public void setCaseCourante(int nombrePas) throws PersonnageHorsPlateauException {
        this.caseCourante = this.caseCourante + nombrePas;
        if (this.caseCourante > derniereCase) {
            this.caseCourante = derniereCase;
            throw new PersonnageHorsPlateauException();
        }
    }

    @Override
    public String toString() {
        String str="";
            for(int i=0; i<listCases.size();i++) {
                int j=i+1;
                str=str+ "\nCase "+ j+": "+listCases.get(i).getName();
            }
        System.out.println(str);
        return str;
    }
}
