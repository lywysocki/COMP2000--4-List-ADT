
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
     * @param name
     */
    public House()
        {
        super( "House" ) ;
        // TODO Auto-generated constructor stub

        }


    @Override
    public boolean isHitting( Scanner s )
        {
        if ( getValue() <= 16 && this.isBusted == false )
            {
            return true ; // we are hitting

            }
        else
            {
            return false ; // we not hitting

            }

        }


    /**
     * 
     * 
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