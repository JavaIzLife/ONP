import java.util.Arrays;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Test {
 
    public static void main(String[] args) throws ScriptException {
    	long start = System.currentTimeMillis();
        String[] stos= new String[50];
        String[] wyjscie= new String[50];
        String[][] twoDimentional = new String[args.length][50];
        Double[] rozwiazanie = null;
        int ostatni_stosu;
        int ostatni_wyjscie;
 	   int licznik=0;
 	   
	    //test
      if(sprawdzenie(args)) {
    	  for(int i=0;i<args.length;i++) {
    		  twoDimentional[i]=args[i].split( "(?<=op)|(?=op)".replace("op", "[-+*/()^=]"));
    	  }
     
    	  System.out.println(Arrays.deepToString(twoDimentional));
       for(int j=0;j<args.length;j++) {
		licznik++;
    	   ostatni_stosu=-1;
    	   ostatni_wyjscie=-1;
    	   Arrays.fill(stos, null);
    	   Arrays.fill(wyjscie, null);
        for(int i1=0;i1<twoDimentional[j].length;i1++) {
           
        

                        switch(twoDimentional[j][i1]) {
                       
                        case "(":
                                    stos[ostatni_stosu+1] = twoDimentional[j][i1];  
                                    ostatni_stosu++;
                        break;
                       
                       
                        case ")":       
                        	
                        	while(ostatni_stosu>-1&&!stos[ostatni_stosu].equals("(")){
                                        wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                                        stos[ostatni_stosu]=null;
                                        ostatni_stosu--;
                                        ostatni_wyjscie++;
                            }
                            stos[ostatni_stosu]=null;
                            ostatni_stosu--;
                        break;
                       
                       
                        case "^":
                            if(ostatni_stosu==-1 || !stos[ostatni_stosu].equals("^") ) {
                                stos[ostatni_stosu+1]=twoDimentional[j][i1];
                                ostatni_stosu++;
                            }
                            else {
                            	
                            	while(ostatni_stosu>-1 && stos[ostatni_stosu].equals("^")) {
                                	wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                                    stos[ostatni_stosu]=null;
                                    ostatni_wyjscie++;
                                    ostatni_stosu--;
                                }
                                    stos[ostatni_stosu+1]=twoDimentional[j][i1];
                                    ostatni_stosu++;
                            }
                        break;
                       
                        case "x": case "/":
                            if(ostatni_stosu==-1 || stos[ostatni_stosu].equals("-") || stos[ostatni_stosu].equals("+")|| stos[ostatni_stosu].equals("(") ) {
                                stos[ostatni_stosu+1]=twoDimentional[j][i1];
                                ostatni_stosu++;
                            }
                            else {
                                while(ostatni_stosu>-1 && (stos[ostatni_stosu].equals("x") ||stos[ostatni_stosu].equals("/")||stos[ostatni_stosu].equals("^"))) {
                                	wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                                    stos[ostatni_stosu]=null;
                                    ostatni_wyjscie++;
                                    ostatni_stosu--;
                                }
                                    stos[ostatni_stosu+1]=twoDimentional[j][i1];
                                    ostatni_stosu++;
                            }
                        break;
                       
                        case "-": case "+":
                        if(ostatni_stosu==-1 || stos[ostatni_stosu].equals("(") ) {
                            stos[ostatni_stosu+1]=twoDimentional[j][i1];
                            ostatni_stosu++;
                        }
                        else {
                            while(ostatni_stosu>-1 && !stos[ostatni_stosu].equals("(")) {      
                                wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                                stos[ostatni_stosu]=null;
                                ostatni_wyjscie++;
                                ostatni_stosu--;
                            }
                                stos[ostatni_stosu+1]=twoDimentional[j][i1];
                                ostatni_stosu++;
                        }
                        break;
                       
                        case "=":
                        	while(ostatni_stosu>-1) {
                            wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                            ostatni_wyjscie++;
                            stos[ostatni_stosu]=null;
                            ostatni_stosu--;
                        	}
                        break;
                       
                        default:
                                    wyjscie[ostatni_wyjscie+1] = twoDimentional[j][i1];
                                    ostatni_wyjscie++;
                        break;
                       }  
                      /*
                        System.out.println(licznik + Arrays.toString(wyjscie));
                        System.out.println(licznik + Arrays.toString(stos));
                        System.out.println();*/
        }  
	     System.out.print(licznik + " rownanie w ONP :  ");

        for(int i2=0;i2<wyjscie.length;i2++)
        {
        	   if (wyjscie[i2]!=null) {
        		   rozwiazanie[i2]=(double) i2;
        	   }
        	}
        System.out.println(Arrays.toString(rozwiazanie));
       
        
       }
      }
       else
    	   System.out.println("Popraw wprowadzone dane!");
      
      
      
      
      
      
      
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        System.out.println("Czas wykonywania programu w milisekundach: " + elapsedTimeMillis);
    }

	private static boolean sprawdzenie(String[] args) {
		boolean isThereEqual = true;
		for(int i=0; i<args.length;i++) {
	        if(!args[i].endsWith("=")) {
	        		isThereEqual=false;
		break;
	        }
		}
		return isThereEqual;
	}
	
}


