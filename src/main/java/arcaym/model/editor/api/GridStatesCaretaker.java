package arcaym.model.editor.api;

/**
 * Class used to save old states in form of a {@link Memento}.
 */
public interface GridStatesCaretaker {
    /**
     * Saves to the collection of previews states the given {@link Memento}.
     * 
     * @param state The state to save to the collection
     */
    void saveSnapshot(Memento state);

    /**
     * Recovers the latest snapshot saved.
     * If multiple calls are made consecutevly, recovers the second to last.
     * 
     * @return The {@link Memento} class consisting in the state to recover
     */
    Memento recoverSnapshot();
}
