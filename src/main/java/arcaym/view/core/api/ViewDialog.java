package arcaym.view.core.api;

import java.awt.Component;

/**
 * Interface for a view dialog window.
 * 
 * @param <P> parent component type
 * @param <R> return type
 */
public interface ViewDialog<P extends Component, R> {

    /**
     * Show dialog.
     * 
     * @param window window info
     * @param parent parent component
     * @return dialog result
     */
    R show(WindowInfo window, P parent);

}
