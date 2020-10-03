package com.company;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Formation {


    private String codeDeFormation ;
    private ArrayList <Etudient > listeEtudient  ;
    //private static int cpt = 0;

    //constracture
    public Formation  (String code){
        this.codeDeFormation = code;
        this.listeEtudient = new ArrayList<Etudient>();
    }

    //getter and setter
    public String getCodeDeFormation() {
        return codeDeFormation;
    }

    public void setCodeDeFormation(String codeDeFormation) {
        this.codeDeFormation = codeDeFormation;
    }

    public ArrayList<Etudient> getListeEtudient() {
        return listeEtudient;
    }

    public void setListeEtudient(ArrayList<Etudient> listeEtudient) {
        this.listeEtudient = listeEtudient;
    }
/*
    public static int getCpt() {
        return ++cpt;
    }

    public static void setCpt(int cpt) {
        Formation.cpt = cpt;
    }
*/
    //methode

    //q1

    public void addEtudient (Etudient e){
        listeEtudient.add(e);
    }

    //q3
    // for get
    List <Etudient> trouver (String name){

        LinkedList <Etudient> list = new LinkedList<Etudient>();
      for (int i = 0 ; i < listeEtudient.size() ; i++){
        Etudient x = listeEtudient.get(i);
        if (x.equals(name)){
            list.add(x);
        }
    }

    //iterator


        Iterator <Etudient> iterator = listeEtudient.iterator();
        while (iterator.hasNext()){
            Etudient e =iterator.next();
            if (e.getNom() == name) {
                list.addLast(e);
            }
        }

        //for each
        for ( Etudient etd : listeEtudient){
            if (etd.getNom() == name) {
                list.addLast(etd);
            }
        }

        return list ;
    }

    //q4

    void modifier (int matricule , String nom){
        Etudient e ;
        // for get
        for (int i=1 ; i < listeEtudient.size();i++){

            e = listeEtudient.get(i);
            if (e.getMatricule() == matricule){
                listeEtudient.set(i,new Etudient(nom, matricule));
            }
        }
        //iterator
        Iterator <Etudient> iteerator = listeEtudient.iterator();
        int cpt=0;
        while (iteerator.hasNext()) {
            e=iteerator.next();
            cpt++;
            if (e.getMatricule() == matricule){
                listeEtudient.set(cpt,new Etudient(nom, matricule));
            }

        }
        cpt=0;
        //for each
        for (Etudient etd:listeEtudient){
            cpt++;
            if (etd.getMatricule() == matricule){
                listeEtudient.set(cpt,new Etudient(nom, matricule));
            }
        }
    }


    //q8-b

    public int fonction8 (String nom){
        int nbEtudiant= 0;
        for (Etudient e : this.listeEtudient) {
            if(EtudiantEtrangie.class.isInstance(e)&&
                    e.getNom().equals(nom)){
                nbEtudiant++;
            }
        }
        return nbEtudiant;
    }




}




class Etudient {


    private int matricule;
    private String nom ;

    //constucteur
    public Etudient (String nom , int matricule){
        this.nom = nom;
        this.matricule = matricule;
    }

    //getter and setter
    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public boolean equals (Object o){
        if(Etudient.class.isInstance(o)) {
            Etudient e= (Etudient) o;
            return (e.getMatricule()== this.getMatricule()) &&
                    (e.getNom().equals(this.getNom()));
        }else {
            return false;
        }
    }

}


class EtudiantAlgerien extends Etudient {

    public EtudiantAlgerien(String nom, int matricule) {
        super(nom, matricule);
    }
}

class  EtudiantEtrangie extends Etudient {

    private String nationaliter;



    public EtudiantEtrangie (String nom , int matricule , String nationaliter){
        super(nom, matricule);
        this.nationaliter = nationaliter;
    }


    public String getNationaliter() {
        return nationaliter;
    }

    public void setNationaliter(String nationaliter) {
        this.nationaliter = nationaliter;
    }
}


public class Main {

    public static void main(String[] args) {

        Formation javaformation = new Formation("azert");

        javaformation.addEtudient(new Etudient("ali",1));
        javaformation.addEtudient(new Etudient("karim",2));
        javaformation.addEtudient(new Etudient("mohamed",3));
        javaformation.addEtudient(new Etudient("ali",4));
        javaformation.addEtudient(new Etudient("sarar",5));
List <Etudient> list = javaformation.trouver("ali");
        for (Etudient e : list ){
        System.out.println(e.getNom());
        }
        System.out.println();

        for (Etudient e : javaformation.getListeEtudient() ){
            System.out.println(e.getMatricule()+","+e.getNom());
        }
        System.out.println();

        System.out.println("4,ali"+javaformation.getListeEtudient().contains(new Etudient("ali",4)));
        System.out.println();
        javaformation.getListeEtudient().remove(new Etudient("ali",4));

        for (Etudient e : javaformation.getListeEtudient() ){
            System.out.println(e.getMatricule()+","+e.getNom());
        }


        Formation javaformation2 = new Formation("code2");
        javaformation2.setListeEtudient(new ArrayList<Etudient>(javaformation.getListeEtudient()));
    }
}
