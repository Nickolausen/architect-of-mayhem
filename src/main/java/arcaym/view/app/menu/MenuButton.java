package arcaym.view.app.menu;

import java.util.Objects;

import javax.swing.JButton;

import arcaym.view.api.ViewComponent;
import arcaym.view.utils.SwingUtils;

/**
 * View for a {@link MainMenu} button.
 */
public class MenuButton implements ViewComponent<JButton> {

    private static final float FONT_SCALE = 2.0f;

    private final String text;

    /**
     * Initialize button with text.
     * 
     * @param text button text
     */
    public MenuButton(final String text) {
        this.text = Objects.requireNonNull(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JButton build() {
        final var button = new JButton(this.text);
        SwingUtils.changeFontSize(button, FONT_SCALE);
        return button;
    }

}
