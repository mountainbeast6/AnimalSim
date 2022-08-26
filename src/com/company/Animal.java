package com.company;

public class Animal {
    private int x;
    private int y;
    private String Symbol;
    public Animal (int x, int y){
        Symbol = "f";

        this.x = x;

        this.y = y;
    }
    public Animal (String a, int x, int y){
        Symbol = a;

        this.x = x;

        this.y = y;
    }
    protected Animal interact(Animal bell){
        if(bell.getSymbol().equals(Symbol)){
            int county = (int)(Math.random()*River.river[0].length);
            int countx=(int)(Math.random()*River.river.length);
            if(River.river[countx][county]==null){
                River.river[countx][county]=new Animal(countx,county);
                return River.river[countx][county];
            }
        }
        return null;
    }
    public Animal getNeighborUp(){
        if (x < 0 || y < 0 || y+1 >= River.river[x].length||x>=River.river.length)
            return new Wall();
        return River.river[x][y+1];
    }
    public Animal getNeighborDown(){
        if (x<0 || y-1 < 0 || y >= River.river[x].length||x>=River.river.length)
            return new Wall();
        return River.river[x][y-1];
    }
    public Animal getNeighborRight(){
        if (x < 0 || y < 0 || y >= River.river[x].length||x+1>=River.river.length)
            return new Wall();
            return River.river[x+1][y];
    }
    public Animal getNeighborLeft(){
        if (x-1 < 0 || y < 0 || y >= River.river[x].length||x>=River.river.length)
            return new Wall();
        return River.river[x-1][y];
    }
    public void setSymbol(String symbol) {
        Symbol = symbol;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
    public String getSymbol() {
        return Symbol;
    }
    public void Move(){
        int choose = (int)(Math.random()*100);
        if(choose<25){
            if(getNeighborRight()==null) {
                River.river[x][y] = null;
                x+=1;
                River.river[x][y] = new Animal(x, y);
            }
            else if (!getNeighborRight().Symbol.equals("WALL")){
                interact(getNeighborRight());
            }
        }
        else if(choose<50){
            if(getNeighborLeft()==null) {
                River.river[x][y] = null;
                x-=1;
                River.river[x][y] = new Animal(x, y);
            }
            else if (!getNeighborLeft().Symbol.equals("WALL")){
                interact(getNeighborLeft());
            }
        }
        else if(choose<75){
            if(getNeighborDown()==null) {
                River.river[x][y] = null;
                y -= 1;
                River.river[x][y] = new Animal(x, y);
            }
            else if (!getNeighborDown().Symbol.equals("WALL")){
                interact(getNeighborDown());
            }
        }
        else {
            if(getNeighborUp()==null) {
                River.river[x][y] = null;
                y += 1;
                River.river[x][y] = new Animal(x, y);
            }
            else if (!getNeighborUp().Symbol.equals("WALL")){
                interact(getNeighborUp());
            }
        }
    }
}