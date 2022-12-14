
package edu.wit.scds.ds.list.app ;

import java.util.Scanner ;

/**
 * Abstract class for the creation of players (or the house)
 *
 * @author Laura Wysocki
 *
 * @version 1.0.0 2022-12-01 Initial implementation
 */
public abstract class GenericPlayer extends Hand
    {
    // DONE

    /**
     * only to be accessed by Player and House
     */
    protected String name ;
    /**
     * only to be accessed by Player and House
     */
    protected boolean isBusted ;

    /**
     * Creates player with specified name
     *
     * @param playerName
     *     name of player
     */
    public GenericPlayer( String playerName )
        {
        super() ;
        this.name = playerName ;
        this.isBusted = false ;

        } // end 1-arg constructor


    /**
     * getter for busted
     *
     * @return true if player is busted, false if otherwise
     */
    public boolean isBusted()
        {
        return this.isBusted ;

        } // end isBusted()


    /**
     * setter of isBusted
     */
    public void busted()
        {
        this.isBusted = true ;
        System.out.printf( "%s: Busted!%n", this.name ) ;

        } // end busted()
    
    /**
     * tests if hand can be split
     *
     * @return true if player can split, false if otherwise
     */
    public boolean isSplittable()
        {

        return this.cards.get( 0 ).rank.equals( this.cards.get( 1 ).rank ) ;

        } // end isSplittable()
    
    /**
     * Splits hand into two
     *
     * @return second hand
     */
    public Player split()
        {
        
        Player handTwo = new Player( this.name + " second hand" );
        this.name = (this.name + " first hand" );
        handTwo.addCard( this.cards.remove( 1 ) ) ;
        return handTwo ;

        } // end split()
    

    @Override
    public String toString()
        {
        String s ;
        return String.format( "%s: %s", this.name, super.toString() ) ;

        } // end toString()


    /**
     * to be provided by subclass
     *
     * @param s
     *     reads in from console if player is hitting or not (to be overridden by
     *     subclasses)
     *
     * @return true if player is hitting, false if otherwise
     */
    public abstract boolean isHitting( Scanner s ) ;

    } // end class GenericPlayer