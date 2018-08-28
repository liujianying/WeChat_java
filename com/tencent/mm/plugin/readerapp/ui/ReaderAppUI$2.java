package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.y.g.a;
import java.util.List;

class ReaderAppUI$2 implements n$d {
    final /* synthetic */ ReaderAppUI mnQ;

    ReaderAppUI$2(ReaderAppUI readerAppUI) {
        this.mnQ = readerAppUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int groupId = menuItem.getGroupId();
        bi biVar;
        long longValue;
        switch (menuItem.getItemId()) {
            case 0:
                if (ReaderAppUI.a(this.mnQ) == 20) {
                    List c = g.bpT().c(((Long) ReaderAppUI.b(this.mnQ).getItem(groupId)).longValue(), ReaderAppUI.a(this.mnQ));
                    if (c.size() > 0) {
                        biVar = (bi) c.get(0);
                        a aVar = new a();
                        aVar.title = biVar.getTitle();
                        aVar.description = biVar.IA();
                        aVar.action = "view";
                        aVar.type = 5;
                        aVar.url = biVar.getUrl();
                        String a = a.a(aVar, null, null);
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", a);
                        intent.putExtra("Retr_Msg_Type", 2);
                        intent.putExtra("Retr_Msg_thumb_path", q.v(biVar.Iz(), biVar.type, "@T"));
                        intent.putExtra("Retr_Msg_Id", 7377812);
                        a = u.ic(biVar.dCW);
                        intent.putExtra("reportSessionId", a);
                        b v = u.Hx().v(a, true);
                        v.p("prePublishId", "msg_" + biVar.dCW);
                        v.p("preUsername", "newsapp");
                        v.p("preChatName", "newsapp");
                        v.p("preMsgIndex", Integer.valueOf(0));
                        v.p("sendAppMsgScene", Integer.valueOf(1));
                        com.tencent.mm.plugin.readerapp.b.a.ezn.l(intent, this.mnQ);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (ReaderAppUI.a(this.mnQ) == 20) {
                    List c2 = g.bpT().c(((Long) ReaderAppUI.b(this.mnQ).getItem(groupId)).longValue(), ReaderAppUI.a(this.mnQ));
                    if (!c2.isEmpty()) {
                        x.i("MicroMsg.ReaderAppUI", "fav time %d, index %d, size %d", new Object[]{Long.valueOf(longValue), Integer.valueOf(ReaderAppUI.c(this.mnQ)), Integer.valueOf(c2.size())});
                        if (ReaderAppUI.c(this.mnQ) >= c2.size()) {
                            ReaderAppUI.a(this.mnQ, 0);
                        }
                        biVar = (bi) c2.get(ReaderAppUI.c(this.mnQ));
                        ch chVar = new ch();
                        String ic = u.ic(biVar.dCW);
                        b v2 = u.Hx().v(ic, true);
                        v2.p("prePublishId", "msg_" + biVar.dCW);
                        v2.p("preUsername", "newsapp");
                        v2.p("preChatName", "newsapp");
                        v2.p("preMsgIndex", Integer.valueOf(0));
                        v2.p("sendAppMsgScene", Integer.valueOf(1));
                        chVar.bJF.bJK = ic;
                        com.tencent.mm.plugin.readerapp.c.b.a(chVar, biVar, ReaderAppUI.c(this.mnQ));
                        chVar.bJF.bJM = 7;
                        chVar.bJF.activity = this.mnQ;
                        com.tencent.mm.sdk.b.a.sFg.m(chVar);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                longValue = ((Long) ReaderAppUI.b(this.mnQ).getItem(groupId)).longValue();
                if (longValue != 0) {
                    g.x(longValue, ReaderAppUI.a(this.mnQ));
                    bj bpT = g.bpT();
                    int a2 = ReaderAppUI.a(this.mnQ);
                    x.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[]{"delete from " + bj.hf(a2) + " where time = " + longValue});
                    if (bpT.dCZ.fV(bj.hf(a2), "delete from " + bj.hf(a2) + " where time = " + longValue)) {
                        bpT.hi(a2);
                        bpT.doNotify();
                    }
                }
                this.mnQ.refresh();
                return;
            default:
                return;
        }
    }
}
