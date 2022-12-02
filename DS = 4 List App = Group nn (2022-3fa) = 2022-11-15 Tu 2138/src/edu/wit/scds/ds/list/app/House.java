
package edu.wit.scds.ds.list.app ;

import java.util.Scanner ;

/**
 * 
 * 
 * @author Laura Wysocki
 *
 * @version 1.0.0 2022-12-01 Initial implementation
 */
public class House extends GenericPlayer
    {
    // DONE

    /**
     * sets house player's name to 'house'
     */
    public House()
        {
        // Player name is House
        super( "House" ) ;

        } // end no-args constructor


    @Override
    public boolean isHitting( Scanner s )
        {
        if ( ( getHouseValue() <= 16 ) && !this.isBusted )
            {
            return true ; // are hitting

            }
        return false ; // not hitting

        } // end isHitting()


    /**
     * Only shows one of House's cards
     */
    public void flipFirstCardDown()
        {
        if ( this.cards.size() == 0 )
            {
            return ;

            } // end if

        // will crash if cards is empty
        this.cards.get( 0 ).setFaceUp(false) ;

        } // end flipFirstCardDown()
    
    /**
     * Flips first card so it's visible
     * 
     */
    public void flipFirstCardUp()
        {
        if ( this.cards.size() == 0 )
            {
            return ;

            } // end if

        this.cards.get( 0 ).setFaceUp(true) ;

        } // flipFirstCardUp()

    } // end class House