package com.example.myphotoapp.Exception;

public class RestrictedInfoException extends Exception{
    @Override
    public String getMessage(){
        return "Classified Information";
    }

}
