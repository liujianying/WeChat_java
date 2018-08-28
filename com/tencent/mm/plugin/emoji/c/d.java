package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.g.a.oc;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<oc> {
    public d() {
        this.sFo = oc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oc ocVar = (oc) bVar;
        if (ocVar instanceof oc) {
            if (ocVar.bYY.bJC == 0) {
                com.tencent.mm.plugin.emoji.model.d aEu = i.aEu();
                long j = ocVar.bYY.bZb;
                aEu.ihf.put(Long.valueOf(j), ocVar.bYY.bYZ);
            } else {
                x.i("MicroMsg.emoji.EmojiRevokeMsgListener", "has handle in sys cmd msg extension.");
            }
        }
        return false;
    }
}
