package br.com.javaPro_modulo1.desafio;

public abstract class HashBase {

    private static final int MAX_LOAD = 10;

    protected int mask;

    protected int len;

    protected int size;

    protected int deletedCount;

    protected int level;

    protected boolean zeroKey;

    private int maxSize, minSize, maxDeleted;

    public HashBase() {
    	clear(0);
    }

    protected abstract void rehash(int newLevel);

    public int size() {
        return size + (zeroKey ? 1 : 0);
    }

    void checkSizePut() {
        if (deletedCount > size) {
            rehash(level);
        }
        if (size + deletedCount >= maxSize) {
            rehash(level + 1);
        }
    }

    protected void checkSizeRemove() {
        if (size < minSize && level > 0) {
            rehash(level - 1);
        } else if (deletedCount > maxDeleted) {
            rehash(level);
        }
    }

    protected void clear(int newLevel) {
        minSize = size * 3 / 4;
        size = 0;
        level = newLevel;
        len = 2 << level;
        mask = len - 1;
        maxSize = (int) (len * MAX_LOAD / 100L);
        deletedCount = 0;
        maxDeleted = 20 + len / 2;
    }

    protected int getIndex(int hash) {
        return hash & mask;
    }
}
