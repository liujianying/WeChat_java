package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.e.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends j {
    protected k(String str) {
        super(str);
    }

    public final void aTP() {
        LinkedList m = j.m(optJSONArray("items"));
        Iterator it = m.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            dVar.dj(dVar.jLc);
        }
        d.S(m);
    }
}
