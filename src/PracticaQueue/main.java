package QUEUE;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
class Sesion4{
    public static void main(String[]args){
        Queue <Jugador>premiumlargo = new PriorityQueue(Comparator.reverseOrder());
        Queue <Jugador>premiumcorto = new PriorityQueue(Comparator.reverseOrder());
        Queue <Jugador>normallargo = new LinkedBlockingQueue<Jugador>();
        Queue <Jugador>normalcorto = new LinkedBlockingQueue<Jugador>();
        SequentialFile file= new SequentialFile("player_request.csv", ";");
        Jugador player=new Jugador();
        file.readInto(player);
        while (!file.endOfFile()) {
            file.readInto(player);
            System.out.println("Processing player: "+player);
            if (player.isPremium()) {
                if (player.getMatchType() == 'S') premiumcorto.insert(player,player.getSkillLevel());
                else premiumlargo.insert(player,player.getSkillLevel());
            } else {
                if (player.getMatchType() == 'S') normalcorto.offer(player);
                else normallargo.offer(player);
            }
        }
        file.close();
        Jugador player1, player2;
        while(premiumcorto.size()>1 || premiumlargo.size()>1 || normalcorto.size()>1 || normallargo.size()>1){
            for(int i=0; i<2; i++){
                if(premiumlargo.size()>1){
                    player1=premiumlargo.poll();
                    player2=premiumlargo.poll();
                    System.out.println("Processing premium long match. Players:\nPlayer 1 ID: "+player1.getPlayerID()+" Player 1 skill level: "+player1.getSkillLevel()+"\nPlayer 2 ID: "+player2.getPlayerID()+" Player 2 skill level: "+player2.getSkillLevel());
                }
            }
            for(int i=0; i<2; i++){
                if(premiumcorto.size()>1){
                    player1=premiumcorto.poll();
                    player2=premiumcorto.poll();
                    System.out.println("Processing premium short match. Players:\nPlayer 1 ID: "+player1.getPlayerID()+" Player 1 skill level: "+player1.getSkillLevel()+"\nPlayer 2 ID: "+player2.getPlayerID()+" Player 2 skill level: "+player2.getSkillLevel());
                }
            }
            if(normallargo.size()>1){
                player1=normallargo.poll();
                player2=normallargo.poll();
                System.out.println("Processing non-premium long match. Players:\nPlayer 1 ID: "+player1.getPlayerID()+" Player 1 skill level: "+player1.getSkillLevel()+"\nPlayer 2 ID: "+player2.getPlayerID()+" Player 2 skill level: "+player2.getSkillLevel());
            }
            if(normalcorto.size()>1){
                player1=normalcorto.poll();
                player2=normalcorto.poll();
                System.out.println("Processing non-premium short match. Players:\nPlayer 1 ID: "+player1.getPlayerID()+" Player 1 skill level: "+player1.getSkillLevel()+"\nPlayer 2 ID: "+player2.getPlayerID()+" Player 2 skill level: "+player2.getSkillLevel());
            }
        }
