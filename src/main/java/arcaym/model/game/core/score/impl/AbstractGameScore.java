package arcaym.model.game.core.score.impl;

import arcaym.common.utils.representation.FieldRepresentation;
import arcaym.common.utils.representation.StringRepresentation;
import arcaym.common.utils.representation.TypeRepresentation;
import arcaym.model.game.core.score.api.GameScore;

/**
 * Abstract implementation of {@link GameScore}.
 * It provides score access and initialization while leaving manipulation logic.
 */
@TypeRepresentation
public abstract class AbstractGameScore implements GameScore {

    private int value;

    /**
     * Initialize game score with a starting value.
     * @param value starting value
     */
    protected AbstractGameScore(final int value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @FieldRepresentation
    public int getValue() {
        return this.value;
    }

    /**
     * Set current value.
     * 
     * @param value new value
     */
    protected void setValue(final int value) {
        this.value = value;
    }

    /**
     * Change current value of certain amount.
     * 
     * @param amount change value
     */
    protected void changeValue(final int amount) {
        this.value += amount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return StringRepresentation.ofObject(this);
    }

}
