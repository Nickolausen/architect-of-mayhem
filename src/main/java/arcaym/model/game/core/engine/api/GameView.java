package arcaym.model.game.core.engine.api;

import java.util.Set;

import arcaym.model.game.core.events.api.Events;
import arcaym.model.game.core.objects.api.GameObjectView;

/**
 * Interface for a game view.
 */
public interface GameView extends Events.GameEventsObserver {

    /**
     * Render al the game objects.
     * 
     * @param gameObjects game objects
     */
    void render(Set<GameObjectView> gameObjects);

}
