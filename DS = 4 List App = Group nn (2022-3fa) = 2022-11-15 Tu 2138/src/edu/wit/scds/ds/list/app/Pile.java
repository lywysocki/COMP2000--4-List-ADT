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

import java.util.ArrayList ;
import java.util.List ;

/**
 * Representation of a pile of card
 * <p>
 * the bottom card is at position 0
 *
 * @author Noah Gagnon
 *
 * @version 1.0.0 2022-11-15 Initial implementation
 */
public class Pile
    {
    // DONE

    // data fields
    /** the list of cards - directly accessible by subclasses */
    protected List<Card> cards ;    // instantiate an ArrayList or LinkedList in the
                                    // constructor

    /**
     *
     */
    public Pile()
        {
        this.cards = new ArrayList<>( 52 ) ;

        }


    public Pile( int pileSize )
        {
        this.cards = new ArrayList<>( pileSize ) ;

        }


    /**
     * @param c
     *     card to be added
     */
    public void addCard( Card c )
        {
        this.cards.add( c ) ;

        }


    /**
     * @param c
     *     card to be removed
     */
    public void removeCard( Card c )
        {
        this.cards.remove( c ) ;

        }


    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()            // debugging aid
        {
        return this.cards.toString() ;

        }	// end toString()


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

    }	// end class Pile