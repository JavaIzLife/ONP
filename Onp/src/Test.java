import java.util.Arrays;

public class Test {
 
    public static void main(String[] args) {
    	long start = System.currentTimeMillis();
    	String[] wejscie= new String[10];
        String[] stos= new String[19];
        String[] wyjscie= new String[19];
        int ostatni_stosu=-1;
        int ostatni_wyjscie = -1;
        String[] tab = args[0].split("");
        System.out.println(args[1].endsWith("="));
        System.out.println(args.length);
        System.out.println(Arrays.toString(tab));
        
      System.out.println(sprawdzenie(args));

      //tab[0]+=tab[1];
 /*
      int i=0;
      System.out.println("jazda" + tab[0]);

        for(int j=1;j<tab.length;j++) {
        	switch(tab[j]) {
        case "1": case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9":case "0":case ".":
        	if(tab[i].endsWith("1") ||tab[i].endsWith("2")||tab[i].endsWith("3")||tab[i].endsWith("4")||tab[i].endsWith("5")||tab[i].endsWith("6")||tab[i].endsWith("7")||tab[i].endsWith("8")||tab[i].endsWith("9")||tab[i].endsWith("0")||tab[i].endsWith(".")) {
        		tab[i]+=tab[j];
        	tab[j]=null;}
        	else {
        	i++;
        	if(i==j)
        	tab[i]=tab[j];
        	else {
        		tab[i]=tab[j];
        		tab[j]=null;
        	}
        	
        	}
        	break; 
        	
        case "x": case "+":case "=": case "/": case "-": case "^":case "(": case ")":
        	i++;
        	tab[i]=tab[j];
        	tab[j]=null;
        	break;
    	
    	default:
    			break;
        	
        	}
        
      	}
        */
        System.out.println("to jest to" + Arrays.toString(tab));
        int licz=1;
        for(int i1=0;i1<args.length;i1++) {
           
           // int ostatni_stosu= sprawdz(stos);
          // int ostatni_wyjscie = sprawdz(wyjscie);

                        switch(args[i1]) {
                       
                        case "(":
                        	System.out.println("wchodzi");
                                    stos[ostatni_stosu+1] = args[i1];  
                                    ostatni_stosu++;
                        break;
                       
                       
                        case ")":       
                        	
                        	while(ostatni_stosu!=-1&&!stos[ostatni_stosu].equals("(")){
                                        wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                                        stos[ostatni_stosu]=null;
                                        ostatni_stosu--;
                                        ostatni_wyjscie++;
                            } ;
                            stos[ostatni_stosu]=null;
                            ostatni_stosu--;
                        break;
                       
                       
                        case "^":
                            if(ostatni_stosu==-1 || !stos[ostatni_stosu].equals("^") ) {
                                stos[ostatni_stosu+1]=args[i1];
                                ostatni_stosu++;
                            }
                            else {
                                if(stos[ostatni_stosu].equals("^")) {
                                    wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                                    ostatni_wyjscie++;
                                    stos[ostatni_stosu]=args[i1];
                                    
                                }
                            }
                        break;
                       
                        case "x": case "/":
                            if(ostatni_stosu==-1 || stos[ostatni_stosu].equals("-") || stos[ostatni_stosu].equals("+")|| stos[ostatni_stosu].equals("(") ) {
                                stos[ostatni_stosu+1]=args[i1];
                                ostatni_stosu++;
                            }
                            else {
                            	if(ostatni_stosu>=0)
                                while(stos[ostatni_stosu].equals("x") ||stos[ostatni_stosu].equals("/")||stos[ostatni_stosu].equals("^")) {
                                    wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                                    ostatni_wyjscie++;
                                    stos[ostatni_stosu]=args[i1];
                                    if(ostatni_stosu>0) {
                                        ostatni_stosu--;
                                        }
                                        else {
                                    		break;
                                    	} 
                                }
                            }
                        break;
                       
                        case "-": case "+":
                            int y=0;
                        if(ostatni_stosu==-1 || stos[ostatni_stosu].equals("(") ) {
                            stos[ostatni_stosu+1]=args[i1];
                            ostatni_stosu++;
                        }
                        else {
                            while(!stos[ostatni_stosu].equals("(")) {      
                                wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                                ostatni_wyjscie++;
                                
                                stos[ostatni_stosu]=args[i1];
                                
                                if(ostatni_stosu>0) {
                                	ostatni_stosu--;  
                                }
                                else {
                            		break;
                            	}
                            }
                        	
                        	
                        }
                        break;
                       
                        case "=":
                            wyjscie[ostatni_wyjscie+1]=stos[ostatni_stosu];
                            ostatni_wyjscie++;
                            stos[ostatni_stosu]=null;
                            ostatni_stosu--;
                        
                        break;
                       
                        default:
                                    wyjscie[ostatni_wyjscie+1] = args[i1];
                                    ostatni_wyjscie++;
                        break;
                       }  
                        
                        System.out.println(licz + " wyjs" + Arrays.toString(wyjscie));
                        System.out.println(licz+ " stos" + Arrays.toString(stos));                
                        System.out.println();     
                        licz++;
        }   
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        System.out.println(elapsedTimeMillis);
    }

	private static boolean sprawdzenie(String[] args) {
		boolean jest = true;
		for(int i=0; i<args.length;i++) {
	        if(!args[i].endsWith("="))
	        		jest=false;
		break;
		}
		return jest;
	}
}
//wyjs[2, 2, ^, 3.5, ^, 4, 8, x, 2, +, x, 6, 3, /, /, null, null, null, null]