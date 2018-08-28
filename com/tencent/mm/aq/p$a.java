package com.tencent.mm.aq;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;
import java.util.List;

class p$a extends al {
    final /* synthetic */ p ecq;

    public p$a(p pVar, List<b> list, LinkedList<Integer> linkedList) {
        this.ecq = pVar;
        super(g.Em().lnJ.getLooper(), new 1(pVar, list, linkedList), true);
    }
}
