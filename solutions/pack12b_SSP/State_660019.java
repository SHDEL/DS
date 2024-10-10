package solutions.pack12b_SSP;

import java.lang.Thread.State;
import java.lang.reflect.Array;
import java.util.Arrays;

public class State_660019 {
    private int[] array;
    private int level;
    private State_660019 left, rigth;

    public State_660019(int[] array, int level) {
        this.array = Arrays.copyOf(array, array.length);
        this.level = level;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setLeft(State_660019 l) {
        this.left = l;
    }

    public void setRigth(State_660019 r) {
        this.rigth = r;
    }

    public State_660019 getLeft() {
        return this.left;
    }

    public State_660019 getRight() {
        return this.rigth;
    }

    public int getLevel() {
        return this.level;
    }
}
