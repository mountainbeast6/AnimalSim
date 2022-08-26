package com.company;

public class River {
    public static Animal[][] river;
    public River(int num, int numx){
        river = new Animal[num][numx];
    }
    public River(){
        river = new Animal[20][20];
    }
    public boolean addAnimal(Animal a) {
        if (a.getX() < 0 || a.getY() < 0 || a.getY() >= river[a.getX()].length || a.getX() >= river.length)
            return false;
        river[a.getX()][a.getY()] = a;
        return true;
    }
    public Animal getAnimalAt(int x, int y){
        if (x < 0 || y < 0 ||y >= river[x].length||x>=river.length)
            throw new ArrayIndexOutOfBoundsException("Position outside River area");
        return river[x][y];
}
    public String toString(){
        String out = "";
        for (int i =0; i<river.length;i++){
            for(int in =0; in<river[i].length;in++){
                if (river[i][in]==null)
                    out+=" - ";
                else
                    out+=" "+river[i][in].getSymbol()+" ";
            }
            out+="\n";
        }
        return out;
    }
    public void run(){

            for (int i = 0; i < river.length; i++) {
                for (int in = 0; in < river[i].length; in++) {
                    if (river[i][in] != null)
                        river[i][in].Move();
                }
            }
            for (int d = 0; d <= 19; d++){
                System.out.println();
            }
            System.out.println(toString());
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
