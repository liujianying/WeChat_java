package com.tencent.mm.ui.chatting.g;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
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

class h$1 implements Runnable {
    final /* synthetic */ boolean tXV = true;
    final /* synthetic */ h tYI;

    h$1(h hVar) {
        this.tYI = hVar;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        au.HU();
        Cursor bA = c.FT().bA(this.tYI.gBf, this.tYI.gBh);
        if (bA == null) {
            x.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
            return;
        }
        u ih;
        if (s.fq(this.tYI.gBf)) {
            au.HU();
            ih = c.Ga().ih(this.tYI.gBf);
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
                    if (gp != null) {
                        h hVar = this.tYI;
                        int i = gp.type;
                        hVar.getType();
                        if (hVar.tYH.contains(Integer.valueOf(i))) {
                            long b = com.tencent.mm.ui.gridviewheaders.a.czj().b(new Date(bdVar.field_createTime));
                            if (j != b) {
                                linkedList.add(new b.c(bdVar.field_createTime));
                                h hVar2 = this.tYI;
                                hVar2.tYk++;
                            }
                            String i2 = h.i(bdVar, s.fq(this.tYI.gBf));
                            ab Yg = ((i) g.l(i.class)).FR().Yg(i2);
                            String str2 = "";
                            if (ih != null) {
                                str2 = ih.gT(i2);
                            }
                            int Bx = com.tencent.mm.plugin.fav.ui.c.Bx(gp.dwp);
                            String appName = com.tencent.mm.plugin.fav.a.b.getAppName(this.tYI.mContext, gp.bZG);
                            au.HU();
                            ab Yg2 = c.FR().Yg(gp.bZG);
                            if (Yg2 == null || !Yg2.field_username.equals(gp.bZG)) {
                                am.a.dBr.a(gp.bZG, "", null);
                            } else {
                                appName = Yg2.BL();
                            }
                            h.a aVar = new h.a(this.tYI, bdVar.field_createTime, gp.type, gp.title, bdVar.field_msgId, Yg.field_username, Yg.BK(), Yg.field_conRemark, str2);
                            aVar.bhd = bi.oW(appName) ? gp.description : appName;
                            aVar.appId = gp.appId;
                            if (bi.oW(bdVar.field_imgPath)) {
                                aVar.imagePath = gp.thumburl;
                            } else {
                                aVar.imagePath = bdVar.field_imgPath;
                            }
                            aVar.iconRes = Bx;
                            linkedList.add(aVar);
                            j = b;
                        }
                    }
                }
            } finally {
                bA.close();
            }
        }
        this.tYI.gBc.addAll(linkedList);
        this.tYI.tYc = this.tYI.gBc;
        linkedList.clear();
        ah.A(new 1(this));
    }
}
