package com.tencent.mm.plugin.appbrand.q;

import android.database.Cursor;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.y.g.a;
import java.util.Iterator;

class b$1 implements Runnable {
    final /* synthetic */ String dhh;
    final /* synthetic */ int gBo = 10;

    b$1(String str) {
        this.dhh = str;
    }

    public final void run() {
        u ih;
        b.aoq().clear();
        if (s.fq(this.dhh)) {
            ih = ((b) g.l(b.class)).Ga().ih(this.dhh);
        } else {
            ih = null;
        }
        int i = 0;
        int i2 = 100;
        while (true) {
            int i3 = i;
            if (i2 < 100 || b.aoq().size() >= this.gBo) {
                x.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", Integer.valueOf(b.aoq().size()));
                ah.A(new 1(this));
            } else {
                Cursor bB = ((i) g.l(i.class)).bcY().bB(this.dhh, i3);
                if (bB != null) {
                    try {
                        i2 = bB.getCount();
                    } catch (Throwable th) {
                        if (bB != null) {
                            bB.close();
                        }
                    }
                } else {
                    i2 = 0;
                }
                while (bB != null && bB.moveToNext()) {
                    cm bdVar = new bd();
                    bdVar.setMsgId(bB.getLong(0));
                    bdVar.ax(bB.getLong(1));
                    bdVar.ay(bB.getLong(2));
                    bdVar.setContent(bB.getString(3));
                    bdVar.eX(bB.getInt(4));
                    String str = bdVar.field_content;
                    if (str != null) {
                        a gp = a.gp(str);
                        if (gp != null && b.lN(gp.type)) {
                            Object obj;
                            String a = b.a(bdVar, s.fq(this.dhh), this.dhh);
                            ai Yg = ((i) g.l(i.class)).FR().Yg(a);
                            String str2 = "";
                            if (ih != null) {
                                str2 = ih.gT(a);
                            }
                            d dVar = new d(bdVar.field_createTime, gp.type, gp.title, bdVar.field_msgId, Yg.field_username, Yg.BK(), Yg.field_conRemark, str2, bi.aG(gp.dyT, gp.appId), gp, bdVar.field_msgSvrId);
                            Iterator it = b.aoq().iterator();
                            while (it.hasNext()) {
                                if (bi.fS(dVar.dyT, ((d) it.next()).dyT)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                dVar.desc = gp.title;
                                WxaAttributes rR = ((c) g.l(c.class)).rR(dVar.bXA.dyS);
                                dVar.title = rR != null ? rR.field_nickname : dVar.bXA.bZH;
                                dVar.imagePath = rR != null ? rR.field_brandIconURL : dVar.bXA.dzb;
                                b.aoq().add(dVar);
                            }
                            if (b.aoq().size() >= this.gBo) {
                                break;
                            }
                        }
                    }
                }
                if (bB != null) {
                    bB.close();
                }
                i = i3 + i2;
            }
        }
        x.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", Integer.valueOf(b.aoq().size()));
        ah.A(new 1(this));
    }
}
