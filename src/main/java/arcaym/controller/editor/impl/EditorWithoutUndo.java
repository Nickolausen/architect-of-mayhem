package arcaym.controller.editor.impl;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import arcaym.common.utils.Position;
import arcaym.controller.editor.api.Editor;
import arcaym.model.editor.EditorGridException;
import arcaym.model.editor.EditorType;
import arcaym.model.editor.api.Grid;
import arcaym.model.editor.impl.GridImpl;
import arcaym.model.editor.saves.LevelMetadata;
import arcaym.model.editor.saves.MetadataManagerImpl;
import arcaym.model.game.objects.api.GameObjectType;

/**
 * An editor implementation with no undo feature.
 */
public class EditorWithoutUndo implements Editor {

    private GameObjectType selectedObject = GameObjectType.FLOOR;
    // temporal static list of all objects
    private List<GameObjectType> availableObjectList = List.of(
        GameObjectType.COIN,
        GameObjectType.FLOOR,
        GameObjectType.MOVING_X_OBSTACLE,
        GameObjectType.MOVING_Y_OBSTACLE,
        GameObjectType.SPIKE,
        GameObjectType.USER_PLAYER,
        GameObjectType.WALL,
        GameObjectType.WIN_GOAL);
    // TODO
    private final Grid editorGrid;
    private final LevelMetadata metadata;

    /**
     * Creates an editor controller without the ability do undo / redo.
     * @param x Width of the grid
     * @param y Height of the grid
     * @param type The type of grid that needs to be created
     * @param name The name to give to the level
     */
    public EditorWithoutUndo(
        final int x, 
        final int y, 
        final EditorType type,
        final String name) {
        this.editorGrid = new GridImpl(x, y, type);
        this.metadata = new LevelMetadata(
            name,
            UUID.randomUUID().toString(),
            type,
            Position.of(x, y));
    }

    /**
     * Creates an editor controller starting from a metadata object.
     * @param metadata The object with internal data.
     */
    public EditorWithoutUndo(
        final LevelMetadata metadata) {
        this.editorGrid = new GridImpl(metadata);
        this.metadata = new LevelMetadata(
            metadata.levelName(),
            metadata.uuid(),
            metadata.type(),
            metadata.size());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void play() {
        // LevelBuilder.build;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateListOfAvailableObjects(final List<GameObjectType> availableList) {
        this.availableObjectList = List.copyOf(availableList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<GameObjectType> getListOfAvailableObjects() {
        return this.availableObjectList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSelectedObject(final GameObjectType object) {
        this.selectedObject = object;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void undo() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redo() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canUndo() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canRedo() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eraseArea(final Collection<Position> positions) throws EditorGridException {
        this.editorGrid.removeObjects(positions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyChange(final Collection<Position> positions) throws EditorGridException {
        this.editorGrid.setObjects(positions, selectedObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean saveLevel() {
        return this.editorGrid.saveState(metadata.uuid())
            && new MetadataManagerImpl().saveMetadata(metadata);
    }
}
