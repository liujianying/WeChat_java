package com.tencent.mm.ui.chatting.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.expt.roomexpt.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class k$5 implements Runnable {
    final /* synthetic */ k tPo;
    final /* synthetic */ String tPp;
    final /* synthetic */ int tPq;
    final /* synthetic */ int tPr;

    k$5(k kVar, String str, int i, int i2) {
        this.tPo = kVar;
        this.tPp = str;
        this.tPq = i;
        this.tPr = i2;
    }

    public final void run() {
        boolean z = false;
        if (!bi.oW(this.tPp)) {
            int i;
            int i2;
            int gK = m.gK(this.tPp);
            au.HU();
            Cursor s = c.FT().s(this.tPp, k.b(this.tPo), k.c(this.tPo));
            if (s == null || !s.moveToFirst()) {
                i = 0;
                i2 = 0;
            } else {
                bd bdVar = new bd();
                i = 0;
                int i3 = 0;
                do {
                    bdVar.d(s);
                    if (bdVar.field_isSend == 1) {
                        i3++;
                    } else {
                        i++;
                    }
                } while (s.moveToNext());
                i2 = i3;
            }
            if (s != null) {
                s.close();
            }
            x.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d", new Object[]{this.tPp, Long.valueOf(k.c(this.tPo) - k.b(this.tPo)), Integer.valueOf(gK), Integer.valueOf(k.a(this.tPo) + i), Integer.valueOf(i2), Integer.valueOf(k.a(this.tPo)), Integer.valueOf(this.tPq), Integer.valueOf(this.tPr)});
            h.mEJ.h(12077, new Object[]{this.tPp, Long.valueOf(k.c(this.tPo) - k.b(this.tPo)), Integer.valueOf(gK), Integer.valueOf(i + k.a(this.tPo)), Integer.valueOf(i2), Integer.valueOf(k.a(this.tPo)), Integer.valueOf(this.tPq), Integer.valueOf(this.tPr)});
            String gT = r.gT(this.tPp);
            d dVar = (d) g.l(d.class);
            String str = this.tPp;
            long c = k.c(this.tPo) - k.b(this.tPo);
            gK = k.a(this.tPo);
            if (this.tPr == 1) {
                z = true;
            }
            dVar.a(str, gT, c, gK, i2, z);
        }
    }
}
