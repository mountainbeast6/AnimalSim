package com.company;

public class Bear extends Animal{
    public Bear(int x, int y) {
        super("b",x, y);
    }

    @Override
    protected Animal interact(Animal bell) {
        if(bell.getSymbol().equals(getSymbol())) {
            int county = (int) (Math.random() * River.river[0].length);
            int countx = (int) (Math.random() * River.river.length);
            if (River.river[countx][county] == null) {
                River.river[countx][county] = new Bear(countx, county);
                return River.river[countx][county];
            }
            return null;
        }
        if(bell.getSymbol()!=getSymbol()){
            River.river[bell.getX()][bell.getY()]=null;
        }
        return null;
    }
    public void Move(){
        int choose = (int)(Math.random()*100);
        if(choose<25){
            if(getNeighborRight()==null) {
                River.river[getX()][getY()] = null;
                setX(getX()+1);
                River.river[getX()][getY()] = new Bear(getX(), getY());
            }
            else if (!getNeighborRight().getSymbol().equals("WALL")){
                interact(getNeighborRight());
            }
        }
        else if(choose<50){
            if(getNeighborLeft()==null) {
                River.river[getX()][getY()] = null;
                setX(getX()-1);
                River.river[getX()][getY()] = new Bear(getX(), getY());
            }
            else if (!getNeighborLeft().getSymbol().equals("WALL")){
                interact(getNeighborLeft());
            }
        }
        else if(choose<75){
            if(getNeighborDown()==null) {
                River.river[getX()][getY()] = null;
                setY(getY()-1);
                River.river[getX()][getY()] = new Bear(getX(), getY());
            }
            else if (!getNeighborDown().getSymbol().equals("WALL")){
                interact(getNeighborDown());
            }
        }
        else {
            if(getNeighborUp()==null) {
                River.river[getX()][getY()] = null;
                setY(getY()+1);
                River.river[getX()][getY()] = new Bear(getX(), getY());
            }
            else if (!getNeighborUp().getSymbol().equals("WALL")){
                interact(getNeighborUp());
            }
        }
    }
}
