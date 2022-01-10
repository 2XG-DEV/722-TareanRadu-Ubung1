package models;

import enums.Grosse;

public class Kunde {
    private int id;
    private String unternehmensName;
    private Enum<Grosse> unternehmensGrosse;
    private int anzahlMitarbeiter;
    private int einkommen;
    private String ort;

    public Kunde(int id, String unternehmensName, Enum<Grosse> unternehmensGrosse, int anzahlMitarbeiter, int einkommen, String ort) {
        this.id = id;
        this.unternehmensName = unternehmensName;
        this.unternehmensGrosse = unternehmensGrosse;
        this.anzahlMitarbeiter = anzahlMitarbeiter;
        this.einkommen = einkommen;
        this.ort = ort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnternehmensName() {
        return unternehmensName;
    }

    public void setUnternehmensName(String unternehmensName) {
        this.unternehmensName = unternehmensName;
    }

    public Enum<Grosse> getUnternehmensGrosse() {
        return unternehmensGrosse;
    }

    public void setUnternehmensGrosse(Enum<Grosse> unternehmensGrosse) {
        this.unternehmensGrosse = unternehmensGrosse;
    }

    public int getAnzahlMitarbeiter() {
        return anzahlMitarbeiter;
    }

    public void setAnzahlMitarbeiter(int anzahlMitarbeiter) {
        this.anzahlMitarbeiter = anzahlMitarbeiter;
    }

    public int getEinkommen() {
        return einkommen;
    }

    public void setEinkommen(int einkommen) {
        this.einkommen = einkommen;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String toCSV(){
        return this.id + "," + this.unternehmensName + "," + this.unternehmensGrosse + "," + this.anzahlMitarbeiter + "," + this.einkommen + "," + this.ort + "\n";
    }
}
