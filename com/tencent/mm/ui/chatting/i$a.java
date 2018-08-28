package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.mw;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class i$a implements a {
    private Set<Long> tIB;
    private p tIC;
    private ah tID;

    public i$a(Set<Long> set, p pVar, ah ahVar) {
        this.tIB = set;
        this.tIC = pVar;
        this.tID = ahVar;
    }

    public final boolean Kr() {
        Set<Long> set = this.tIB;
        List linkedList = new LinkedList();
        for (Long l : set) {
            au.HU();
            bd dW = c.FT().dW(l.longValue());
            if (dW.field_msgId == l.longValue()) {
                if (dW.aQm()) {
                    b.ehL.c(dW, h.g(dW));
                } else {
                    b.ehL.y(dW);
                }
            }
            linkedList.add(l);
            mw mwVar = new mw();
            mwVar.bXL.type = 3;
            mwVar.bXL.bJC = l.longValue();
            com.tencent.mm.sdk.b.a.sFg.m(mwVar);
        }
        com.tencent.mm.model.bd.I(linkedList);
        if (this.tID != null) {
            this.tID.a(ah$a.del);
        }
        return true;
    }

    public final boolean Ks() {
        if (this.tIC != null) {
            this.tIC.dismiss();
            if (this.tID != null) {
                this.tID.b(ah$a.del);
            }
        }
        return true;
    }
}
