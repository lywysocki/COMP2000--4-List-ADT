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
 * Representation of a hand of cards
 *
 * @author Noah Gagnon
 *
 * @version 1.0.0 2022-11-15 Initial implementation
 */
public class Hand extends Pile
    {
    // DONE

    /**
     * Constructs a hand of 2
     */
    public Hand()
        {
        super( 2 ) ;

        } // end no-args constructor


    /**
     * Getter for the value of the hand
     *
     * @return value of the hand
     */
    public int getHandValue()
        {

        if ( ( this.cards.size() == 2 ) && isSplittable() )
            {
            Scanner input = new Scanner( System.in ) ;
            System.out.printf( "%s: Do you want to split (y/n)? " ) ;
            String response = input.next() ; // stops a white space
            if ( response.length() == 0 )
                {
                if ( response.charAt( 0 ) == 'y' )
                    {
                    split() ;

                    } // end if
                else if ( ( response.charAt( 0 ) != 'n' ) )
                    {
                    System.out.printf( "Please respond with y or n.%n" ) ;

                    } // end else if

                } // end if

            } // end else

        int value = 0 ;

        for ( Card element : this.cards )
            {

            if ( element.rank.toString().matches( "Q|K|J" ) && ( element.getFaceUp() ) )
                {
                value += 10 ;

                }
            else if ( element.rank.toString().matches( "A" ) && ( element.getFaceUp() ) )
                {
                if ( value <= 10 )
                    {
                    value += 11 ;

                    }

                else
                    {
                    value += 1 ;

                    }

                }
            else

                {
                if ( ! ( element.getFaceUp() ) )
                    {
                    continue ;

                    }

                value += Integer.parseInt( element.rank.toString() ) ;

                }

            }

        return value ;

        } // end getHandValue()


    /**
     * getter for the value of the house's hand
     *
     * @return value of the house's hand
     */
    public int getHouseValue()
        {
        int value = 0 ;

        for ( Card element : this.cards )
            {

            if ( element.rank.toString().matches( "Q|K|J" ) )
                {
                value += 10 ;

                }
            else if ( element.rank.toString().matches( "A" ) )
                {
                if ( value <= 10 )
                    {
                    value += 11 ;

                    }

                else
                    {
                    value += 1 ;

                    }

                }
            else

                {

                value += Integer.parseInt( element.rank.toString() ) ;

                }

            }

        return value ;

        } // end getHouseValue()


    /**
     * Splits hand into two
     *
     * @return second hand
     */
    public Hand split()
        {
        if ( !isSplittable() )
            {
            return null ;

            }

        Hand secondHand = new Hand() ;      ///
        secondHand.addCard( this.cards.remove( 1 ) ) ;
        return secondHand ;

        } // end split()


    /**
     * tests if hand can be split
     *
     * @return true if player can split, false if otherwise
     */
    private boolean isSplittable()
        {

        return this.cards.get( 0 ).toString().equals( this.cards.get( 1 ).toString() ) == true ;

        } // end isSplittable()


    @Override
    public String toString()
        {
        String s = "" ;

        for ( Card element : this.cards )
            {
            s += String.format( "%s ", element ) ;

            }

        s += String.format( "Showing: %d", getHandValue() ) ;

        return s ;

        } // end toString()


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