/**
 * 
 */
package br.com.javaPro_modulo1.desafio;

/**
 * @author Genilson.Xavier
 *
 */
public class EstruturaDeDadosHash extends HashBase{

    public static final int NOT_FOUND = -1;

    private static final int DELETED = 1;
    private int[] keys;
    private int[] values;
    private int zeroValue;
    //private int newLevel = 1;

	protected void clear2( int newLevel ) {
        super.clear(newLevel);
        keys = new int[len];
        values = new int[len];
    }

	protected void clear() {
		clear2(1);
	}	
	

    public void put(int key, int value) {
        if (key == 0) {
            zeroKey = true;
            zeroValue = value;
            return;
        }
        try {
            checkSizePut();
        } catch (Exception e) {
            
        }
        int index = getIndex(key);
        int plus = 1;
        int deleted = -1;
        do {
            int k = keys[index];
            if (k == 0) {
                if (values[index] != DELETED) {
                    
                    if (deleted >= 0) {
                        index = deleted;
                        deletedCount--;
                    }
                    size++;
                    keys[index] = key;
                    values[index] = value;
                    return;
                }
                
                if (deleted < 0) {
                    deleted = index;
                }
            } else if (k == key) {
                
                values[index] = value;
                return;
            }
            index = (index + plus++) & mask;
        } while(plus <= len);
    }


    public void remove(int key) {
        if (key == 0) {
            zeroKey = false;
            return;
        }
        try {
            checkSizeRemove();
        } catch (Exception e) {
            
        }
        int index = getIndex(key);
        int plus = 1;
        do {
            int k = keys[index];
            if (k == key) {
                
                keys[index] = 0;
                values[index] = DELETED;
                deletedCount++;
                size--;
                return;
            } else if (k == 0 && values[index] == 0) {
                
                return;
            }
            index = (index + plus++) & mask;
        } while(plus <= len);
        
    }

    protected void rehash(int newLevel) {
        int[] oldKeys = keys;
        int[] oldValues = values;
        clear2(newLevel);
        for (int i = 0; i < oldKeys.length; i++) {
            int k = oldKeys[i];
            if (k != 0) {
                put(k, oldValues[i]);
            }
        }
    }


    public int get(int key) {
        if (key == 0) {
            return zeroKey ? zeroValue : NOT_FOUND;
        }
        int index = getIndex(key);
        int plus = 1;
        do {
            int k = keys[index];
            if (k == 0 && values[index] == 0) {
                
                return NOT_FOUND;
            } else if (k == key) {
                
                return values[index];
            }
            index = (index + plus++) & mask;
        } while(plus <= len);
        return NOT_FOUND;
    }
}
