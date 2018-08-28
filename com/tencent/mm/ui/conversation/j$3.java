package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.c.am;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.conversation.g.d;
import com.tencent.mm.ui.f.a;
import java.util.HashSet;
import java.util.Iterator;

class j$3 implements a {
    final /* synthetic */ j ure;

    j$3(j jVar) {
        this.ure = jVar;
    }

    public final void Xa() {
        g.vu(12);
        c b = j.b(this.ure);
        b.unJ = -1;
        b.unI.clear();
        if (b.unL == null || b.unK < 0 || !b.unL.cnU()) {
            b.unJ = 0;
        } else if (b.unL.upS) {
            b.unJ = 0;
        } else if (b.unL.upQ) {
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
            b.unJ = 0;
            b.unL.upQ = false;
        } else {
            HashSet hashSet = (HashSet) b.unL.upR.clone();
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", Integer.valueOf(hashSet.size()));
            if (hashSet.contains("floatbottle")) {
                b.unJ = 0;
                return;
            }
            if (!(s.auK() && s.auL())) {
                hashSet.remove("officialaccounts");
            }
            if (hashSet.isEmpty()) {
                b.unJ = 1;
                return;
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                boolean z;
                String str = (String) it.next();
                g gVar = b.unL;
                if (gVar.aaR(str)) {
                    z = false;
                } else {
                    d dVar = (d) gVar.tEl.get(str);
                    z = dVar == null ? false : com.tencent.mm.model.s.fq(str) ? dVar.uoy : dVar.uov;
                }
                if (!z) {
                    am aaQ = b.aaQ(str);
                    if (aaQ == null) {
                        b.unI.put(str, Integer.valueOf(0));
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", str, Integer.valueOf(0));
                    } else {
                        b.unI.put(str, Integer.valueOf(aaQ.field_unReadCount));
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", str, Integer.valueOf(aaQ.field_unReadCount));
                    }
                }
            }
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", Integer.valueOf(b.unI.size()));
            if (b.unI.isEmpty()) {
                b.unJ = 1;
            } else if (b.unI.size() > 20) {
                b.unJ = 0;
            } else {
                b.unJ = 2;
            }
        }
    }

    public final void Xb() {
        j.b(this.ure).cyG();
        if (j.a(this.ure) != null) {
            g a = j.a(this.ure);
            if (!(a.tEl == null || a.upR == null || a.upR.isEmpty())) {
                if (a.upS) {
                    a.tEl.clear();
                    a.upS = false;
                } else {
                    x.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", Integer.valueOf(a.upR.size()));
                    Iterator it = a.upR.iterator();
                    while (it.hasNext()) {
                        a.tEl.remove(it.next());
                    }
                }
                a.upR.clear();
            }
        }
        j.d(this.ure).post(new 1(this));
    }
}
