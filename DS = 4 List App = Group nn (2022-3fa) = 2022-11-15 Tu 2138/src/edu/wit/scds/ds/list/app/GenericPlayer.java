
package edu.wit.scds.ds.list.app ;

import java.util.Scanner ;

/**
 * @author Laura Wysocki
 *
 * @version 1.0.0 2022-12-01 Initial implementation
 */
public abstract class GenericPlayer extends Hand
    {

    /**
     * only to be accessed by Player and House
     */
    protected String name ;
    /**
     * only to be accessed by Player and House
     */
    protected boolean isBusted ;

    /**
     * @param name
     */
    public GenericPlayer( String name )
        {
        super() ; // we don't need to put it b/c hand already has it
        this.name = name ;
        this.isBusted = false ;

        }


    // getter for isBusted
    /**
     * @return true if player is busted, false if otherwise
     */
    public boolean isBusted()
        {
        return this.isBusted ;

        }


    /**
     * setter of isBusted
     */
    public void busted()
        {
        this.isBusted = true ;
        System.out.printf( "%s: Busted!%n", this.name ) ;

        }


    @Override
    public String toString()
        {
        String s ;
        return String.format( "%s: %s", this.name, super.toString() ) ;

        }


    /**
     * @param s
     *     reads in from console if player is hitting or not (to be overridden by
     *     subclasses)
     *
     * @return true if player is hitting, false if otherwise
     */
    public abstract boolean isHitting( Scanner s ) ;

    }
// end class GenericPlayer