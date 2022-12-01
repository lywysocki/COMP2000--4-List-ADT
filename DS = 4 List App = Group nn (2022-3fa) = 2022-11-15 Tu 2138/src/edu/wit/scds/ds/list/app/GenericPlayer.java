
package edu.wit.scds.ds.list.app ;

/**
 * @author Laura Wysocki
 * 
 * @version 1.0.0 2022-12-01 Initial implementation
 */
public abstract class GenericPlayer extends Hand
    {

    /**
     * 
     */
    protected String name ;
    protected boolean isBusted ;

    /**
     * @param name
     */
    public GenericPlayer( String name )
        {
        super() ; // we don't need to put it b/c hand already has it
        this.name = name ;
        isBusted = false ;

        }


    // getter for isBusted
    /**
     * 
     * 
     * @return
     */
    public boolean isBusted()
        {
        return isBusted ;

        }


    // setter of isBusted
    /**
     * 
     * 
     */
    public void busted()
        {
        isBusted = true ;
        System.out.printf( "%s: Busted!%n", name ) ;

        }


    @Override
    public String toString()
        {
        String s ;
        s = String.format( "%s: %s", name, super.toString() ) ;
        return s ;

        }


    /**
     * 
     * 
     * @param s
     * @return
     */
    public abstract boolean isHitting( Scanner s ) ;

    }
// end class GenericPlayer