package com.tencent.mm.vending.j;

public class a {
    public Object[] uRO;

    public final <T> T get(int i) {
        if (this.uRO.length <= i) {
            return null;
        }
        return this.uRO[i];
    }

    public final int size() {
        if (this.uRO == null) {
            return 0;
        }
        return this.uRO.length;
    }

    public static <$1> b<$1> cz($1 $1) {
        a bVar = new b();
        bVar.uRO = new Object[]{$1};
        return (b) bVar;
    }

    public static <$1, $2> c<$1, $2> x($1 $1, $2 $2) {
        a cVar = new c();
        cVar.uRO = new Object[]{$1, $2};
        return (c) cVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object obj2 : this.uRO) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(obj2);
        }
        return stringBuilder.toString();
    }
}
