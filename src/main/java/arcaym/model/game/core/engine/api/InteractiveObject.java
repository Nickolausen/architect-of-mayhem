package arcaym.model.game.core.engine.api;

import arcaym.model.game.core.events.api.EventsScheduler;
import arcaym.model.game.core.events.api.EventsSubscriber;
import arcaym.model.game.core.scene.api.GameSceneInfo;
import arcaym.model.game.events.api.GameEvent;
import arcaym.model.game.events.impl.InputEvent;

/**
 * Interface for an object that reacts to game updates.
 */
public interface InteractiveObject {

    /**
     * Setup object before game.
     * 
     * @param gameEventsSubscriber game events subscriber
     * @param inputEventsSubscriber input events subscriber
     * @param gameScene game scene
     * @param gameState game state
     */
    void setup(
        EventsSubscriber<GameEvent> gameEventsSubscriber, 
        EventsSubscriber<InputEvent> inputEventsSubscriber,
        GameSceneInfo gameScene, 
        GameStateInfo gameState
    );

    /**
     * Update object for new game frame.
     * 
     * @param deltaTime time since last update
     * @param eventsScheduler game events scheduler
     * @param gameScene game scene
     * @param gameState game state
     */
    void update(
        long deltaTime, 
        EventsScheduler<GameEvent> eventsScheduler, 
        GameSceneInfo gameScene,
        GameStateInfo gameState
    );

}
