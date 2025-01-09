package arcaym.model.game.core.components.api;

import java.util.Optional;

import arcaym.common.utils.Optionals;
import arcaym.model.game.core.engine.api.InteractiveObject;
import arcaym.model.game.core.objects.api.GameObject;

/**
 * Interface for basic {@link GameObject} component.
 */
public interface GameComponent extends InteractiveObject {

    /**
     * Set component game object.
     * 
     * @param object game object
     */
    void setObject(GameObject object);

    /**
     * Get component game object.
     * 
     * @return game object
     */
    Optional<GameObject> getObject();

    /**
     * Get component game object.
     * 
     * @return game object
     * @throws IllegalStateException if the game object is missing
     */
    default GameObject getRequiredObject() {
        return Optionals.orIllegalState(this.getObject(), "Missing attached game object");
    }

}
