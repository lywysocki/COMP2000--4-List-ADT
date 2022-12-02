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

    /**
     * 
     */
    public Hand()
        {
        super( 2 ) ;

        }


    /**
     * @return value of the hand
     */
    public int getHandValue()
        {
        int value = 0 ;

        for ( int i = 0 ; i < this.cards.size() ; i++ )
            {

            if ( this.cards.get( i ).rank.toString().matches( "Q|K|J" ) &&
                 ( this.cards.get( i ).getFaceUp() ) )
                {
                value += 10 ;

                }
            else if ( this.cards.get( i ).rank.toString().matches( "A" ) &&
                      ( this.cards.get( i ).getFaceUp() ) )
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
                if ( ! ( this.cards.get( i ).getFaceUp() ) )
                    {
                    continue ;

                    }

                value += Integer.parseInt( this.cards.get( i ).rank.toString() ) ;

                }

            }

        return value ;

        }
    
    public int getHouseValue()
        {
        int value = 0 ;

        for ( int i = 0 ; i < this.cards.size() ; i++ )
            {

            if ( this.cards.get( i ).rank.toString().matches( "Q|K|J" )  )
                {
                value += 10 ;

                }
            else if ( this.cards.get( i ).rank.toString().matches( "A" ) )
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
                

                value += Integer.parseInt( this.cards.get( i ).rank.toString() ) ;

                }

            }

        return value ;

        }


    /**
     * @return
     */
    public Hand split()
        {
        if ( !isSplittable() )
            {
            return null ;

            }
        else
            {
            Hand split = new Hand() ;      ///
            split.addCard( this.cards.remove( 1 ) ) ;
            // value = this.cards.get( 0 ).getValue() ;
            boolean isSplit = true ;
            return split ;

            }

        }


// test
// test
    /**
     * @return
     */
    private boolean isSplittable()
        {

        // TODO Auto-generated method stub
        return false ;

        }


    @Override
    public String toString()
        {
        String s = "" ;

        for ( int i = 0 ; i < this.cards.size() ; i++ )
            {
            s += String.format( "%s ", this.cards.get( i ) ) ;

            }

        s += String.format( "Showing: %d", getHandValue() ) ;

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