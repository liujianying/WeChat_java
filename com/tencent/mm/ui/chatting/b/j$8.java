package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.List;

class j$8 implements Runnable {
    final /* synthetic */ j tOS;
    final /* synthetic */ List tPa;

    j$8(j jVar, List list) {
        this.tOS = jVar;
        this.tPa = list;
    }

    public final void run() {
        for (bd bdVar : this.tPa) {
            if (bdVar.ckA()) {
                int i;
                e bq = o.Pf().bq(bdVar.field_msgSvrId);
                if (bdVar.field_isSend == 1) {
                    int i2;
                    if (bq.ON()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    i = i2;
                } else if (bq.ON()) {
                    if (com.tencent.mm.a.e.cn(o.Pf().o(f.a(bq).dTL, "", ""))) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                if (bq.offset < bq.dHI || bq.dHI == 0) {
                    o.Pg().a(bq.dTK, bdVar.field_msgId, i, Long.valueOf(bdVar.field_msgId), R.g.chat_img_template, new 1(this));
                }
            } else if (bdVar.cmo()) {
                l.a(bdVar, null);
            } else if (bdVar.cmj() || bdVar.cmk()) {
                r nW = t.nW(bdVar.field_imgPath);
                if (!(nW == null || nW.status == 199)) {
                    if (nW.To()) {
                        x.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                        t.oa(bdVar.field_imgPath);
                    } else {
                        x.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                        t.nS(bdVar.field_imgPath);
                    }
                }
            }
        }
    }
}
