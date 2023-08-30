package com.ookawara.animeapi.exception;

public class AnimeNotFoundException extends RuntimeException{

    public AnimeNotFoundException(){
        super();
    }

    public AnimeNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    public AnimeNotFoundException(String message){
        super(message);
    }
    public AnimeNotFoundException(Throwable cause){
        super(cause);
    }
}
