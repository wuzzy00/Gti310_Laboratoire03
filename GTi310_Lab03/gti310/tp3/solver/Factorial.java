package gti310.tp3.solver;

public class Factorial{
	
	/** Retourner le nombre factoriel, d'un nombre passer en parametre */
    public static int factorial( int n ){
    
        if( n <= 1 )     // base case
            return 1;
        else
            return n * factorial( n - 1 );
    }
}