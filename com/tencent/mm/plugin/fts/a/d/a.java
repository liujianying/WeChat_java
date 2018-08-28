package com.tencent.mm.plugin.fts.a.d;

public abstract class a implements d {
    public /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        if (getPriority() < dVar.getPriority()) {
            return -1;
        }
        return getPriority() > dVar.getPriority() ? 1 : 0;
    }
}
