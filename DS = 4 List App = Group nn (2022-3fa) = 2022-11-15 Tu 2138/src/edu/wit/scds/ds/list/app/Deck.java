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

import java.util.Random ;

/**
 * Representation of a deck of cards
 *
 * @author Noah Gagnon
 *
 * @version 1.0.0 2022-11-15 Initial implementation
 */
public class Deck extends Pile
    {
    // TODO implement this

    /**
    *
    */
    Random rand = new Random() ;

    /**
     * 
     */
    public Deck()
        {
        super() ;
        populateDeck() ;

        }


    /**
     * @param h creates player's hand
     */
    public void draw( Hand h )
        {
        int r = this.rand.nextInt( this.cards.size() ) ;
        h.addCard( this.cards.get( r ) ) ;
        this.cards.remove( r ) ;

        }


    // controlled access to populateDeck() from outside
    /**
     *
     *
     */
    public void shuffle()
        {
        populateDeck() ;

        }


    /**
     *
     *
     *
     */
    private void populateDeck()
        {
        Suit[] suits = Suit.values() ;
        Rank[] ranks = Rank.values() ;
        for ( final Suit suit : suits )
            {

            // skip placeholder suit
            if ( Suit.NONE.equals( suit ) )
                {
                continue ;

                }

            for ( final Rank rank : ranks )
                {

                // skip non-playing card(s) - Joker
                if ( Rank.JOKER.equals( rank ) )
                    {
                    continue ;

                    }

                // build a card
                final Card newCard = new Card( suit, rank ) ;
                this.cards.add( newCard ) ;

                // public Card( final Suit theSuit, final Rank theRank )
                }

            }

        }


    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( String[] args )
        {
        // OPTIONAL for testing and debugging
        Deck testDeck = new Deck() ;

        for ( final Card aCard : testDeck.cards )
            {
            aCard.reveal() ;

            }

        System.out.println( testDeck.toString() ) ;

        }	// end main()

    }	// end class Deck