package com.tencent.mm.kiss.widget.textview;

import com.tencent.mm.kiss.widget.textview.a.a;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    public static c dtC = new c();
    public ConcurrentHashMap<Integer, b> dtD = new ConcurrentHashMap();

    public final void a(a aVar, f fVar) {
        if (aVar != null) {
            b bVar = (b) this.dtD.get(Integer.valueOf(aVar.hashCode()));
            if (bVar != null) {
                bVar.a(fVar);
                this.dtD.put(Integer.valueOf(aVar.hashCode()), bVar);
                return;
            }
            bVar = new b();
            bVar.a(fVar);
            this.dtD.put(Integer.valueOf(aVar.hashCode()), bVar);
        }
    }

    public final f a(a aVar, CharSequence charSequence) {
        if (aVar != null) {
            b bVar = (b) this.dtD.get(Integer.valueOf(aVar.hashCode()));
            if (bVar != null) {
                return bVar.m(charSequence);
            }
        }
        return null;
    }

    public final void EZ() {
        for (b bVar : this.dtD.values()) {
            bVar.dtB.clear();
        }
        this.dtD.clear();
    }

    public static int a(a aVar) {
        return aVar.hashCode();
    }
}
