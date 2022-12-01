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

/**
 * Representation of a hand of cards
 *
 * @author Laura Wysocki
 *
 * @version 1.0.0 2022-11-15 Initial implementation
 */
public class Hand extends Pile
    {
    // TODO implement this

    public Hand()
        {
        super( 5 ) ;

        }


    public int getValue()
        {
        int value = 0 ;

        for ( int i = 0 ; i < cards.size() ; i++ )
            {
            if ( cards.get( i ).isFlipped() )
                {
                if ( cards.get( i ).getValue() == 0 )
                    {
                    int one = value += 1 ;
                    int eleven = value += 11 ;

                    if ( one < eleven && eleven < 21 )
                        {
                        value = eleven ;
                        break ;

                        }

                    }

                continue ; // moves to next iteration of the loop

                }
            else
                {
                value += cards.get( i ).getValue() ;

                }

            }

        return value ;

        }


    public String toString()
        {
        String s = "" ;

        for ( int i = 0 ; i < cards.size() ; i++ )
            {
            s += String.format( "%s ", cards.get( i ) ) ;

            }

        s += String.format( "Showing: %d", getValue() ) ;

        return s ;

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

        }	// end main()

    }	// end class Hand