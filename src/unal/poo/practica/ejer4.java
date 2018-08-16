package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class ejer4
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
            estudiante = new Robot(objetos,0, 1, Direction.SOUTH,0);
            for(int i=0;i<5;i++){
                Move(1);
                PutFEnd();
                estudiante.turnLeft();
            }                        
	}
        
        public static void PutFEnd(){
           int a;
           a=EatFEnd();
           estudiante.turnLeft();
           for(int i=0;i<a;i++){
               estudiante.putThing();
               Move(1);
           }
           TurnOSide();
           Move(a);
        }
        
        public static int EatFEnd(){
           int a=0;
           while(estudiante.canPickThing()){
               a++;
               estudiante.pickThing();
           }
           return a;
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

