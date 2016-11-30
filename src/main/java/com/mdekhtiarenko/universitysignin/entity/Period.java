package com.mdekhtiarenko.universitysignin.entity;

/**
 * Created by mykola.dekhtiarenko on 24.11.16.
 */
public class Period {
    public static final String PREPARATORY = "preparatory";
    public static final String SIGN_IN = "sign_in";
    public static final String FINALE = "finale";

    String period;

    public Period(){
        this.period=PREPARATORY;
    }

    public void setPeriod(String period){
        this.period=period;
    }


    public String toString(){
        return period;
    }

}
