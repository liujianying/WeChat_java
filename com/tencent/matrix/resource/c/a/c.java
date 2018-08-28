package com.tencent.matrix.resource.c.a;

import java.util.HashMap;
import java.util.Map;

public enum c {
    OBJECT(2, 0),
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);
    
    private static Map<Integer, c> bsn;
    private int fi;
    private int mId;

    static {
        bsn = new HashMap();
        c[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            c cVar = values[i];
            bsn.put(Integer.valueOf(cVar.mId), cVar);
            i++;
        }
    }

    private c(int i, int i2) {
        this.mId = i;
        this.fi = i2;
    }

    public static c en(int i) {
        return (c) bsn.get(Integer.valueOf(i));
    }

    public final int getSize(int i) {
        return this.fi != 0 ? this.fi : i;
    }
}
