package com.tencent.mm.ui.chatting.g;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.y.g.a;
import java.util.Date;
import java.util.LinkedList;

class d$1 implements Runnable {
    final /* synthetic */ boolean tXV = true;
    final /* synthetic */ d tYl;

    d$1(d dVar) {
        this.tYl = dVar;
    }

    public final void run() {
        Object linkedList = new LinkedList();
        au.HU();
        Cursor bA = c.FT().bA(this.tYl.gBf, this.tYl.gBh);
        if (bA == null) {
            x.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
            return;
        }
        u ih;
        if (s.fq(this.tYl.gBf)) {
            au.HU();
            ih = c.Ga().ih(this.tYl.gBf);
        } else {
            ih = null;
        }
        long j = 0;
        while (bA.moveToNext()) {
            try {
                bd bdVar = new bd();
                bdVar.d(bA);
                String str = bdVar.field_content;
                if (str != null) {
                    a gp = a.gp(str);
                    if ((6 == gp.type ? 1 : null) != null) {
                        long b = com.tencent.mm.ui.gridviewheaders.a.czj().b(new Date(bdVar.field_createTime));
                        if (j != b) {
                            linkedList.add(new b.c(bdVar.field_createTime));
                            d dVar = this.tYl;
                            dVar.tYk++;
                        }
                        String i = d.i(bdVar, s.fq(this.tYl.gBf));
                        ab Yg = ((i) g.l(i.class)).FR().Yg(i);
                        String str2 = "";
                        if (ih != null) {
                            str2 = ih.gT(i);
                        }
                        int Bx = com.tencent.mm.plugin.fav.ui.c.Bx(gp.dwp);
                        d$a d_a = new d$a(this.tYl, bdVar.field_createTime, gp.type, gp.title, bdVar.field_msgId, Yg.field_username, Yg.BK(), Yg.field_conRemark, str2);
                        d_a.iconRes = Bx;
                        d_a.desc = bi.bF((long) gp.dwo);
                        linkedList.add(d_a);
                        j = b;
                    }
                }
            } finally {
                bA.close();
            }
        }
        this.tYl.gBc.addAll(linkedList);
        this.tYl.tYc = this.tYl.gBc;
        linkedList.clear();
        x.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[]{Integer.valueOf(this.tYl.gBc.size())});
        ah.A(new 1(this));
    }
}
