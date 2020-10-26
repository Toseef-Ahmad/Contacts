interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;
    int prevX;
    int prevY;

    private void memorizeCoordinates() {
        this.prevX = entity.getX();
        this.prevY = entity.getY();
    }

    public void execute() {
        memorizeCoordinates();
        entity.setX(prevX + xMovement);
        entity.setY(prevY + yMovement);
    }

    public void undo() {
        entity.setX(prevX);
        entity.setY(prevY);
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;
    int lastIndex;

    private int emptySlot() {
        int invLength = entity.getInventoryLength();
        for (int i = 0; i < invLength; i++) {
            String currentSlot = entity.getInventoryItem(i);
            if (currentSlot == null) {
                return i;
            }
        }
        return invLength;
    }

    public void execute() {
        lastIndex = emptySlot();
        if (lastIndex != entity.getInventoryLength()) {
            entity.setInventoryItem(lastIndex, item);
        }
    }

    public void undo() {
        if (lastIndex != entity.getInventoryLength()) {
            entity.setInventoryItem(lastIndex, null);
        }
    }
}
