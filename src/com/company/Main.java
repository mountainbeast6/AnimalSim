package com.company;

public class Main {

    public static void main(String[] args){
	    River river = new River( 40,40);
	    generate(river,6,11);
        for(int i = 0; i <4000; i++){
            river.run();
        }
    }
    public static void generate(River blah,int bears, int fish){
        for(int i =0; i<=bears; i++){
            blah.addAnimal(new Bear(((int)(Math.random()*River.river.length)), ((int)(Math.random()*River.river[1].length))));
        }
        for(int i =0; i<=fish; i++){
            blah.addAnimal(new Animal(((int)(Math.random()*River.river.length)), ((int)(Math.random()*River.river[1].length))));
        }
    }
}
