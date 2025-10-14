package QUEUE;

import java.util.*;


public class Jugador implements Comparable<Jugador> {
    private String RequestID;
    private String PlayerID;
    private boolean PremiumSubscription;
    private int SkillLevel;
    private char MatchType; 

    
    public Jugador() {} //para evitar errores de compilación al crear un objeto vacio en el main

    
    public Jugador(String requestID, String playerID, boolean premium, int skill, char matchType) {
        this.RequestID = requestID;
        this.PlayerID = playerID;
        this.PremiumSubscription = premium;
        this.SkillLevel = skill;
        this.MatchType = matchType;
    }

    
    public void readData(String line) {
        String[] a = line.split(";"); // separo las palabras por los ; que se ponen automaticamente al cambiar de celda al convertir desde excel
        this.RequestID = a[0];
        this.PlayerID = a[1];
        this.PremiumSubscription = Boolean.parseBoolean(a[2]); //convierto la palabra "true" o "false" en su valor como booleano
        this.SkillLevel = Integer.parseInt(a[3]); // convierto los numeros como String a integers. (originalmente toda la linea son Strings)
        this.MatchType = a[4].charAt(); 
    }

    
    public String getRequestID() {
         return RequestID; }
    public String getPlayerID() {
         return PlayerID; }
    public boolean isPremium() {
         return PremiumSubscription; }
    public int getSkillLevel() {
         return SkillLevel; }
    public char getMatchType() {
         return MatchType; }

    @Override
    public String toString() {
        return "RequestID: " + RequestID +" PlayerID: " + PlayerID +" Premium: " + PremiumSubscription +" SkillLevel: " + SkillLevel +" MatchType: " + MatchType;
    }
    @Override
    public int compareTo(Jugador otro) {
        return Integer.compare(otro.SkillLevel, this.SkillLevel);
    }
}
