
package edu.wit.scds.ds.list.app ;

import java.util.ArrayList ;
import java.util.Scanner ;

/**
 * Card game blackjack which can be played in the terminal with as many players as
 * you'd like
 *
 * @author Laura Wysocki
 *
 * @version 1.0.0 2022-12-01 Initial implementation
 */
public class Blackjack
    {
    // DONE

    /**
     * @param args
     *     an array of command-line arguments for the application
     */
    public static void main( String[] args )
        {
        Scanner input = new Scanner( System.in ) ;
        Deck d = new Deck() ; // a lot happens here!

        System.out.printf( "%nWelcome to Blackjack%n%n" ) ;
        System.out.printf( "This game is to be played by 2 or more people" ) ;
        System.out.printf( "Enter number of human players (if # is < 2 the number of players will default to 2): " ) ;

        int numPlayers = input.nextInt() ;

        if ( numPlayers < 2 )
            {
            numPlayers = 2 ;

            }

        /**
         * Create our structure for holding all the players
         */
        ArrayList<GenericPlayer> players = new ArrayList<>( numPlayers ) ;

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
        for ( GenericPlayer p : players )
            {
            d.draw( p ) ;
            d.draw( p ) ;

            if ( p instanceof House house )
                {
                house.flipFirstCardDown() ;

                } // end if

            System.out.printf( "%s%n", p ) ;

            } // end for

        /**
         * main gameplay, are you hitting?
         */
        for ( GenericPlayer p : players )
            {
            if ( p instanceof House house )
                {
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

                if ( p.getHouseValue() > 21 )
                    {
                    p.busted() ;

                    } // end if

                } // end while

            } // end for

        /**
         * display the final hands
         */
        System.out.printf( "%nFinal Hands%n%n" ) ;

        h.flipFirstCardUp() ;
        for ( GenericPlayer p : players )
            {
            System.out.printf( "%s%n", p ) ;

            } // end for

        /**
         * Display results (win, lose, push)
         */
        for ( GenericPlayer p : players )
            {
            if ( p instanceof House )
                {
                continue ; // moves on to the next for loop iteration

                } // end if

            if ( p instanceof Player player )
                {
                if ( !player.isBusted() && h.isBusted() )
                    {
                    player.win() ;

                    } // end if

                else if ( !player.isBusted() && ( player.getHouseValue() == h.getHouseValue() ) )
                    {
                    player.push() ;

                    } // end else if
                else if ( !player.isBusted() && ( player.getHouseValue() > h.getHouseValue() ) )
                    {
                    player.win() ;

                    } // end else if
                else if ( player.isBusted() || ( player.getHouseValue() < h.getHouseValue() ) )
                    {
                    player.lose() ;

                    } // end else if

                } // end if

            } // end for

        } // end main()

    } // end class Blackjack
