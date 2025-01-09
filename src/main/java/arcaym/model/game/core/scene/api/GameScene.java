package arcaym.model.game.core.scene.api;

import arcaym.model.game.core.objects.api.GameObject;

/**
 * Interface for a game objects manager.
 */
public interface GameScene extends GameSceneView {

    /**
     * Add object to the scene.
     * 
     * @param object game object to add
     */
    void addObject(GameObject object);

    /**
     * Remove object from the scene.
     * 
     * @param object game object to remove
     */
    void removeObject(GameObject object);

}
