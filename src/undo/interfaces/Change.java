package undo.interfaces;

/**
 * An abstraction of a change that can be registered with an
 * {@link UndoManager} and applied to a {@link Document}. 
 *
 */
public interface Change {

	public static String INSERTION = "insertion";
	public static String DELETION = "deletion";
	
	/**
	 * Returns the type of the change. 
	 */
	public String getType();
	
	/**
	 * Apply this change to the given document.
	 * 
	 * @param doc The document to apply the change to.
	 * @throws IllegalStateException If the change cannot be applied to <code>doc</code>
	 * 			(that is if the document refuses the application of the change). 
	 */
	public void apply(Document doc) throws IllegalStateException;

	/**
	 * Reverts this change in the given document.
	 * 
	 * @param doc The document to revert the change in.
	 * @throws IllegalStateException If the change cannot be reverted in <code>doc</code>
	 * 			(that is if the document refuses the reversion of the change). 
	 */
	public void revert(Document doc) throws IllegalStateException;

}
