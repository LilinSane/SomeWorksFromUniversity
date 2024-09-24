package com.example.lab4server.checkers;

public class HitChecker {
    public boolean isHit(float x, float y, float r){
        if(r >= 0){
            if(x <= 0 && y <= 0){
                if(Math.abs(x) <= r && !(y <= (-1) * r/2)){return true;}
            }
            if (x <= 0 && y >= 0){
                if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r/2, 2)){return true;}
            }
            if (x >= 0 && y >= 0){
                if(y < -x + r/2){return true;}
            }
        }
        else{
            if(x >= 0 && y >= 0){
                if(x <= (-1)*r && (y <= (-1) * r/2)){return true;}
            }
            if (x >= 0 && y <= 0){
                if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r/2, 2)){return true;}
            }
            if (x <= 0 && y <= 0){
                if(!(y < Math.abs(x) + r/2)){return true;}
            }
        }
        return false;
    }
}
