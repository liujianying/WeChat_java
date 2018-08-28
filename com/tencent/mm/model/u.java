package com.tencent.mm.model;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class u {
    private static volatile u dAX;
    private Map<String, c> dAY = new a((byte) 0);

    public static u Hx() {
        if (dAX == null) {
            synchronized (u.class) {
                if (dAX == null) {
                    dAX = new u();
                }
            }
        }
        return dAX;
    }

    private u() {
    }

    public final b ia(String str) {
        c cVar = (c) this.dAY.get(str);
        if (cVar != null) {
            return cVar.dBa;
        }
        return null;
    }

    public final b v(String str, boolean z) {
        c cVar = (c) this.dAY.get(str);
        if (cVar == null) {
            if (!z) {
                return null;
            }
            cVar = new c();
            this.dAY.put(str, cVar);
        }
        return cVar.dBa;
    }

    public final b ib(String str) {
        c cVar = (c) this.dAY.remove(str);
        if (cVar != null) {
            return cVar.dBa;
        }
        return null;
    }

    public static String ic(String str) {
        return "SessionId@" + str + "#" + System.nanoTime();
    }

    public String toString() {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataCenter \nDataStore size : ").append(this.dAY.size());
        Set<Entry> linkedHashSet = new LinkedHashSet(this.dAY.entrySet());
        for (Entry entry : linkedHashSet) {
            if (entry != null) {
                c cVar = (c) entry.getValue();
                if (cVar != null) {
                    stringBuilder.append("\nDataStore id : ").append((String) entry.getKey());
                    stringBuilder.append(", CT : ").append(cVar.dBb).append("ms");
                    stringBuilder.append(", TTL : ").append((currentTimeMillis - cVar.dBb) / 1000).append("s");
                }
            }
        }
        linkedHashSet.clear();
        return stringBuilder.toString();
    }
}
