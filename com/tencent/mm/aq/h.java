package com.tencent.mm.aq;

import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.aqb;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class h extends b {
    private aqb ech;

    public h(List<a> list) {
        super(36);
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.eci);
        }
        this.ech = new aqb();
        this.ech.hbF = list.size();
        this.ech.hbG = linkedList;
        this.lcH = this.ech;
    }
}
