package unal.poo.practica;

import becker.robots.*;
import java.util.Scanner;
/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class braile
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
            estudiante = new Robot(objetos,4,0, Direction.NORTH,0);
            boolean c=false;
            boolean e=false;
            Move(3);
            TurnRight();
            do{
                int a=LeerL();
                char b=TRsn(a,c);
                if(b=='#'){
                    c=Flip(c);
                }
                System.out.println(b);
                estudiante.turnLeft();
                Move(3);
                TurnRight();
                Move(1);
                TurnRight();
                e=estudiante.canPickThing();
                Move(1);
                estudiante.turnLeft();
            }while(!e);
	}
        
        public static char TRsn(int a, boolean c){
            char[][] ab= new char[2][61];
            ab[0][1]='a';
            ab[1][1]='1';
            ab[0][3]='c';
            ab[1][3]='3';
            ab[1][4]='1';
            ab[0][5]='b';
            ab[1][5]='2';
            ab[0][6]='i';
            ab[1][6]='9';
            ab[0][7]='f';
            ab[1][7]='6';
            ab[0][9]='e';
            ab[1][9]='5';
            ab[0][11]='d';
            ab[1][11]='4';
            ab[1][12]='3';
            ab[0][13]='h';
            ab[1][13]='8';
            ab[0][14]='j';
            ab[1][14]='0';
            ab[0][15]='g';
            ab[1][15]='7';
            ab[0][17]='k';
            ab[0][19]='m';
            ab[1][20]='2';
            ab[0][21]='l';
            ab[0][22]='s';
            ab[0][23]='p';
            ab[0][24]='q';
            ab[0][25]='o';
            ab[0][27]='n';
            ab[1][28]='6';
            ab[0][29]='r';
            ab[0][30]='t';
            ab[0][31]='q';
            ab[1][36]='5';
            ab[1][44]='4';
            ab[0][46]='n';
            ab[0][49]='u';
            ab[0][51]='x';
            ab[1][52]='8';
            ab[0][53]='v';
            ab[1][56]='0';
            ab[0][57]='z';
            ab[0][58]='#';
            ab[0][59]='y';
            ab[0][60]='7';
            int d;
            if(c){
                d=1;
            }else{
                d=0;
            }
            char b=ab[d][a];
            return b;
        }
        
        public static boolean Flip(boolean c){
            return !c;
        }
        
        public static int LeerL(){
            int a = 0;
            if(estudiante.canPickThing()){
                a++;
            }
            Move(1);
            if(estudiante.canPickThing()){
                a+=2;
            }
            TurnOSide();
            movecheck();
            if(estudiante.canPickThing()){
                a+=4;
            }
            Move(1);
            if(estudiante.canPickThing()){
                a+=8;
            }
            TurnOSide();
            movecheck();
            if(estudiante.canPickThing()){
                a+=16;
            }
            Move(1);
            if(estudiante.canPickThing()){
                a+=32;
            }
            return a;
        }
        
        public static void movecheck(){
            Move(1);
            estudiante.turnLeft();
            Move(1);
            estudiante.turnLeft();
        }
        
        public static boolean Par(int a){
            return 0==a%2;
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

