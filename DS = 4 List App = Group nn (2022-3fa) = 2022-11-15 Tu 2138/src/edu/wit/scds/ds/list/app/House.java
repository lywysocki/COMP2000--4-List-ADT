
package edu.wit.scds.ds.list.app ;

import java.util.Scanner ;

/**
 * @author Laura Wysocki
 *
 * @version 1.0.0 2022-12-01 Initial implementation
 */
public class House extends GenericPlayer
    {

    /**
     * 
     */
    public House()
        {
        // Player name is House
        super( "House" ) ;

        }


    @Override
    public boolean isHitting( Scanner s )
        {
        if ( ( getValue() <= 16 ) && !this.isBusted )
            {
            return true ; // are hitting

            }
        return false ; // not hitting

        }


    /**
     * Only shows one of House's cards
     */
    public void flipFirstCard()
        {
        if ( this.cards.size() == 0 )
            {
            return ;

            }

        // will crash if cards is empty
        this.cards.get( 0 ).flip() ;

        }

    }
// end class House