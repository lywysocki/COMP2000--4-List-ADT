
package edu.wit.scds.ds.list.app ;

import java.util.ArrayList ;
import java.util.Scanner ;

/**
 * Card game blackjack which can be played in the terminal with as many players as you'd like
 * 
 * @author Laura Wysocki
 * 
 * @version 1.0.0 2022-12-01 Initial implementation
 */
public class Blackjack
    {
    // DONE

    /**
     * @param args an array of command-line arguments for the application
     */
    public static void main( String[] args )
        {
        Scanner input = new Scanner( System.in ) ;
        Deck d = new Deck() ; // a lot happens here!

        System.out.printf( "%nWelcome to Blackjack%n%n" ) ;
        System.out.printf( "Enter number of human players: " ) ;
        int numPlayers = input.nextInt() ; // put in try catch later in case someone
                                           // puts in something to crash program


        /**
         * Create our structure for holding all the players
         */
        ArrayList<GenericPlayer> players = new ArrayList<GenericPlayer>( numPlayers ) ;


        /**
         * Create all the players
         */
        for ( int i = 0 ; i < numPlayers ; i++ )
            {
            System.out.printf( "Enter name for player %d: ", i + 1 ) ;
            String name = input.next() ;

            Player p = new Player( name ) ;
            players.add( p ) ;

            } // end for


        /**
         * add house, this means house will always be last
         */
        House h = new House() ;
        players.add( h ) ;


        /**
         * deal cards to all the players
         */
        for ( int i = 0 ; i < players.size() ; i++ )
            {
            GenericPlayer p = players.get( i ) ; // allows for shorthand
            d.draw( p ) ;
            d.draw( p ) ;

            if ( p instanceof House )
                {
                House house = (House) p ; // casting p to a house
                house.flipFirstCardDown() ;

                } // end if

            System.out.printf( "%s%n", p ) ;

            } // end for


        /**
         * main gameplay, are you hitting?
         */
        for ( int i = 0 ; i < players.size() ; i++ )
            {
            GenericPlayer p = players.get( i ) ;
            if ( p instanceof House )
                {
                House house = (House) p ;
                house.flipFirstCardDown() ;

                } // end if

            while ( !p.isBusted() )
                {
                if ( p.isHitting( input ) )
                    {
                    d.draw( p ) ;
                    System.out.printf( "%s%n", p ) ;

                    } // end if
                else
                    {
                
                    break ; // kick us out of the while

                    } // end else

                if ( p.getHandValue() > 21 )
                    {
                    p.busted() ;

                    } // end if

                } // end while

            } // end for


        /**
         * display the final hands
         */
        System.out.printf( "%nFinal Hands%n%n" ) ;

        h.flipFirstCardUp();
        for ( GenericPlayer p : players )
            {
            System.out.printf( "%s%n", p ) ;

            } // end for


        /**
         * Display results (win, lose, push)
         */
        for ( int i = 0 ; i < players.size() ; i++ )
            {
            GenericPlayer p = players.get( i ) ;
            if ( p instanceof House )
                {
                continue ; // moves on to the next for loop iteration

                } // end if

            if ( p instanceof Player )
                {
                Player player = (Player) p ;

                if ( !player.isBusted() && h.isBusted() )
                    {
                    player.win() ;

                    } // end if
                
                else if ( player.isBusted() || player.getHandValue() < h.getHandValue() )
                    {
                    player.lose() ;

                    } // end else if
                else if ( !player.isBusted() && player.getHandValue() == h.getHandValue() )
                    {
                    player.push() ;

                    } // end else if
                else if ( !player.isBusted() && player.getHandValue() > h.getHandValue() )
                    {
                    player.win() ;

                    } // end else if

                } // end if

            } // end for

        } // end main()

    } // end class Blackjack
