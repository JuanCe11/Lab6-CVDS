/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.game;

import java.util.Random;
import java.util.LinkedList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author 2146124
 */
@ManagedBean(name = "game")
//@ApplicationScoped
@SessionScoped 
public class Game {
    private LinkedList<Integer> orderTries;
    private int numberGuess;
    private int tries;
    private String status;
    private int score;
    private int triedNumber;
    
    public Game(){
        orderTries=new LinkedList<Integer>();
        Random rand = new Random();
        numberGuess= rand.nextInt(10) + 1;
        tries=0;
        status="Sigue intentando";
        score=100000;
        triedNumber=0;
    }
    
    public int getTries(){
        return tries;
    }
    
    public void guess(){
        if(triedNumber<11 && triedNumber>0){
            tries++;
            orderTries.add(triedNumber);
            if(triedNumber!=numberGuess){
                if(score-10000<=0){
                    score=0;
                    status=this.getLoseState();
                }else{
                    score-=10000;
                }
            }else{
                status=this.getWinState();
            }
        }
    }
    
    public void restart(){
        Random rand = new Random();
        numberGuess= rand.nextInt(10) + 1;
        tries=0;
        status="Sigue intentando";
        score=100000;
        triedNumber=0;
        orderTries.clear();
    }
    
    public String getStatus(){
        return status;
    }
    
    public int getScore(){
        return score;
    }
    
    public int getNumberGuess(){
        return numberGuess;
    }
    
    public int getTriedNumber(){
        return triedNumber;
    }
    
    public void setTriedNumber(int triedNumber){
        this.triedNumber=triedNumber;
    }
    
    public String getWinState(){
        return "Victoria se gano "+score + " para la pola";
    }
    
    public String getLoseState(){
        return "Perdiste no ganaste nada";
    }
    
    public LinkedList<Integer> getOrderTries(){
        return orderTries;
    }
}
