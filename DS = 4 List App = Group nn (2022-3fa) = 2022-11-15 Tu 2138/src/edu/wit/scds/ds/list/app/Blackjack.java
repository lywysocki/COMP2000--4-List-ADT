
package edu.wit.scds.ds.list.app ;

import java.util.ArrayList ;
import java.util.Scanner ;

/**
 * @author wysockil
 * 
 * @version 1.0.0 2022-12-01 Initial implementation
 */
public class Blackjack
    {

    /**
     * @param args
     */
    public static void main( String[] args )
        {
        Scanner input = new Scanner( System.in ) ;
        Deck d = new Deck() ; // a lot happens here!

        System.out.printf( "%nWelcome to Blackjack%n%n" ) ;
        System.out.printf( "Enter number of human players: " ) ;
        int numPlayers = input.nextInt() ; // put in try catch later in case someone
                                           // puts in something to crash program

// Create our structure for holding all the players
        ArrayList<GenericPlayer> players = new ArrayList<GenericPlayer>( numPlayers ) ;

// Create all the players
        for ( int i = 0 ; i < numPlayers ; i++ )
            {
            System.out.printf( "Enter name for player %d: ", i + 1 ) ;
            String name = input.next() ;

            Player p = new Player( name ) ;
            players.add( p ) ;

            }

// add house, this means house will always be last
        House h = new House() ;
        players.add( h ) ;

// deal cards to all the players
        for ( int i = 0 ; i < players.size() ; i++ )
            {
            GenericPlayer p = players.get( i ) ; // allows for shorthand
            d.draw( p ) ;
            d.draw( p ) ;

            if ( p instanceof House )
                { // Polymorphism
                House house = (House) p ; // casting p to a house
                house.flipFirstCard() ;

                }

            System.out.printf( "%s%n", p ) ;

            }

// main gameplay, are you hitting?
        for ( int i = 0 ; i < players.size() ; i++ )
            {
            GenericPlayer p = players.get( i ) ;
            if ( p instanceof House )
                {
                House house = (House) p ;
                house.flipFirstCard() ;

                }

            while ( !p.isBusted() )
                {
                if ( p.isHitting( input ) )
                    {
                    d.draw( p ) ;
                    System.out.printf( "%s%n", p ) ;

                    }
                else
                    {
                    break ; // kick us out of the while

                    }

                if ( p.getValue() > 21 )
                    {
                    p.busted() ;

                    }

                }

            }

// display the final hands
        System.out.printf( "%nFinal Hands%n%n" ) ;
// for/each loop
        for ( GenericPlayer p : players )
            {
            System.out.printf( "%s%n", p ) ;

            }

// Display results (win, lose, push)
        for ( int i = 0 ; i < players.size() ; i++ )
            {
            GenericPlayer p = players.get( i ) ;
            if ( p instanceof House )
                {
                continue ; // moves on to the next for loop iteration

                }

            if ( p instanceof Player )
                {
                Player player = (Player) p ;

                if ( !player.isBusted() && h.isBusted() )
                    {
                    player.win() ;

                    }
                // should probably get value of house from arrayList
                else if ( player.isBusted() || player.getValue() < h.getValue() )
                    {
                    player.lose() ;

                    }
                else if ( !player.isBusted() && player.getValue() == h.getValue() )
                    {
                    player.push() ;

                    }
                else if ( !player.isBusted() && player.getValue() > h.getValue() )
                    {
                    player.win() ;

                    }

                }

            }

        }

    }
