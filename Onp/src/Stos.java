import java.util.*;

public class Stos{

   private String[] Stos;
   private int ostatniStosu;

   
   public Stos()
   {
       Stos = new String[10];
       ostatniStosu = -1;//keep track of where the top element is on the stack.
   }


   public String usun()
  {      
      if(ostatniStosu==-1)
      {
          //throw exception here
      }
      return Stos[ostatniStosu--];
  }


   public void dodaj(String num)
   {
       if(ostatniStosu== Stos.length-1)
       {
           //throw exception here
       }
       else
       {
            Stos[++ostatniStosu] = num;//add to the stack           
        }       
   }


   public int wierzcholek()
   {
       return ostatniStosu;
   }


   public boolean isEmpty()
   {
       return (ostatniStosu == -1)? true : false;
   }

   public static void main(String [] arg)
   {
       Stos stos = new Stos();
       stos.dodaj("1");
       stos.dodaj("2");
       stos.dodaj("3");

       System.out.println(stos.usun());
   }
}