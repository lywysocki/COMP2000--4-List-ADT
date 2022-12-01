/* @formatter:off
 *
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: List application - card game
 * Fall, 2022
 *
 * Usage restrictions:
 *
 * You may use this code for exploration, experimentation, and furthering your
 * learning for this course. You may not use this code for any other
 * assignments, in my course or elsewhere, without explicit permission, in
 * advance, from myself (and the instructor of any other course).
 *
 * Further, you may not post (including in a public repository such as on github)
 * nor otherwise share this code with anyone other than current students in my
 * sections of this course. Violation of these usage restrictions will be considered
 * a violation of the Wentworth Institute of Technology Academic Honesty Policy.
 *
 * Do not remove this notice.
 *
 * @formatter:on
 */

package edu.wit.scds.ds.list.app ;

import java.util.Scanner ;

/**
 * Representation of a player
 *
 * @author Laura Wysocki
 *
 * @version 1.0.0 2022-11-15 Initial implementation
 */
public class Player extends GenericPlayer
    {
    // TODO implement this

    /**
     * @param name
     */
    public Player( String name )
        {
        super( name ) ;
        // TODO Auto-generated constructor stub

        }


    public void win()
        {
        System.out.printf( "%s: Wins!%n", name ) ;

        }


    public void lose()
        {
        System.out.printf( "%s: Lost%n", name ) ;

        }


    public void push()
        {
        System.out.printf( "%s: Pushed%n", name ) ;

        }


    @Override
    public boolean isHitting( Scanner s )
        {
        // TODO Auto-generated method stub
        do
            {
            System.out.printf( "%s: Do you want to hit (y/n)? ", name ) ;
            String response = s.next() ; // stops a white space
            if ( response.length() == 0 )
                {
                continue ;

                }

            if ( response.charAt( 0 ) == 'y' )
                {
                return true ;

                }
            else if ( response.charAt( 0 ) == 'n' )
                {
                return false ;

                }
            else
                {
                System.out.printf( "Please respond with y or n.%n" ) ;

                }

            }
        while ( true ) ;

        }


    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {
        // OPTIONAL for testing and debugging

        }   // end main()

    }	// end class Player