package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class ejer2
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,1, 2, Direction.SOUTH,0);
                        
            MoveNWall(3);
            SearchAPick();
            TurnOSide();
            MoveRWall(3);
            TurnOSide();
	}
        
        public static void MoveRWall(){
                if(estudiante.frontIsClear()){
                    Move(1);
                }else{
                     TurnRight();
                     MoveNWall();
                }
        }
        
        public static void MoveRWall(int a){
            for(int j=0;j<a;j++){
                if(estudiante.frontIsClear()){
                    Move(1);
                }else{
                     TurnRight();
                     MoveNWall();
                }
            }
        }
        
        public static void MoveNWall(){
                if(estudiante.frontIsClear()){
                    Move(1);
                }else{
                     estudiante.turnLeft();
                     MoveNWall();
                }
        }
        
        public static void MoveNWall(int a){
            for(int j=0;j<a;j++){
                if(estudiante.frontIsClear()){
                    Move(1);
                }else{
                     estudiante.turnLeft();
                     MoveNWall();
                }
            }
        }
        
        public static void SearchAPick(){
            if(estudiante.canPickThing()){
                estudiante.pickThing();
            }
        }
        
        public static void TurnOSide(){
            for(int j=0;j<2;j++) estudiante.turnLeft();
        }
        
        public static void TurnRight(){
            for(int j=0;j<3;j++) estudiante.turnLeft();
        }
        
        public static void Move(int a){
            for(int j=0;j<a;j++) estudiante.move();
        }
}

