package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ad;
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

class g$1 implements Runnable {
    final /* synthetic */ boolean tXV = true;
    final /* synthetic */ g tYD;

    g$1(g gVar) {
        this.tYD = gVar;
    }

    public final void run() {
        Object linkedList = new LinkedList();
        au.HU();
        Cursor bI = c.FT().bI(this.tYD.gBf, this.tYD.gBh);
        if (bI == null) {
            x.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
            return;
        }
        u ih;
        if (s.fq(this.tYD.gBf)) {
            au.HU();
            ih = c.Ga().ih(this.tYD.gBf);
        } else {
            ih = null;
        }
        long j = 0;
        while (bI.moveToNext()) {
            try {
                long b;
                bd bdVar = new bd();
                bdVar.d(bI);
                String str = bdVar.field_content;
                if (str != null) {
                    a J = a.J(str, bdVar.field_reserved);
                    if (g.lN(bi.WU(J.dyb)) || g.lN(bdVar.getType())) {
                        Object obj;
                        String i = g.i(bdVar, s.fq(this.tYD.gBf));
                        ab Yg = ((i) g.l(i.class)).FR().Yg(i);
                        String str2 = "";
                        if (ih != null) {
                            str2 = ih.gT(i);
                        }
                        g$a g_a;
                        if (g.lN(bdVar.getType())) {
                            g_a = new g$a(this.tYD, bdVar.field_createTime, bdVar.getType(), J.dxz, bdVar.field_msgId, Yg.field_username, Yg.BK(), Yg.field_conRemark, str2);
                            tj tjVar = new tj();
                            tjVar.ceU.bXz = J.dxB;
                            com.tencent.mm.sdk.b.a.sFg.m(tjVar);
                            boolean z = bdVar.field_isSend == 1 ? tjVar.ceV.ceW : !tjVar.ceV.ceW;
                            if (tjVar.ceV.status == -2) {
                                z = false;
                            }
                            if (z) {
                                int i2;
                                int i3 = tjVar.ceV.status;
                                if (i3 <= 0) {
                                    i3 = J.dxy;
                                }
                                g_a.nickname = this.tYD.mContext.getResources().getString(R.l.startup_remittance, new Object[]{g_a.nickname});
                                switch (i3) {
                                    case 1:
                                    case 7:
                                        i2 = -352966;
                                        break;
                                    case 3:
                                        i2 = -470621;
                                        break;
                                    case 4:
                                        i2 = -470621;
                                        break;
                                    case 5:
                                        i2 = -470621;
                                        break;
                                    case 6:
                                        i2 = -470621;
                                        break;
                                    default:
                                        i2 = -352966;
                                        break;
                                }
                                g_a.tYG = i2;
                                g_a.desc = g.a(this.tYD, this.tYD.mContext, bdVar, J, z, i3);
                                Context context = this.tYD.mContext;
                                if (J != null && context != null) {
                                    switch (i3) {
                                        case 1:
                                        case 7:
                                            i2 = R.k.c2c_remittance_icon;
                                            break;
                                        case 3:
                                            i2 = R.k.c2c_remittance_received_icon;
                                            break;
                                        case 4:
                                            i2 = R.k.c2c_remittance_rejected_icon;
                                            break;
                                        case 5:
                                            i2 = R.k.c2c_remittance_received_icon;
                                            break;
                                        case 6:
                                            i2 = R.k.c2c_remittance_cancle_icon;
                                            break;
                                        default:
                                            i2 = R.k.c2c_remittance_icon;
                                            break;
                                    }
                                }
                                i2 = R.k.c2c_remittance_icon;
                                g_a.iconRes = i2;
                                obj = g_a;
                            } else {
                                x.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", new Object[]{Boolean.valueOf(tjVar.ceV.ceW), Integer.valueOf(tjVar.ceV.status), Long.valueOf(bdVar.field_msgId), this.tYD.tYa.gy(g_a.timestamp), g_a.toString()});
                            }
                        } else {
                            g_a = new g$a(this.tYD, bdVar.field_createTime, bdVar.getType(), J.dxW, bdVar.field_msgId, Yg.field_username, Yg.BK(), Yg.field_conRemark, str2);
                            g_a.tYF = bi.WU(J.dyb);
                            g$a obj2;
                            if (g_a.tYF == bi.WU("1001")) {
                                g_a.nickname = this.tYD.mContext.getResources().getString(R.l.startup_aa, new Object[]{g_a.nickname});
                                g_a.desc = com.tencent.mm.ui.chatting.g.b(J, bdVar.field_isSend == 1);
                                g_a.tYG = com.tencent.mm.ui.chatting.g.d(J, bdVar.field_isSend == 1);
                                g_a.iconRes = com.tencent.mm.ui.chatting.g.a(J, bdVar.field_isSend == 1);
                                obj2 = g_a;
                            } else {
                                ti tiVar = new ti();
                                tiVar.ceP.ceR = J.dyc;
                                com.tencent.mm.sdk.b.a.sFg.m(tiVar);
                                g_a.nickname = this.tYD.mContext.getResources().getString(R.l.startup_c2c, new Object[]{g_a.nickname});
                                g_a.desc = com.tencent.mm.ui.chatting.g.a(tiVar.ceQ.ceS, tiVar.ceQ.ceT, bdVar.field_isSend == 1, J);
                                int identifier = this.tYD.mContext.getResources().getIdentifier(((com.tencent.mm.y.c) J.u(com.tencent.mm.y.c.class)).dwg, "drawable", ad.getPackageName());
                                g_a.iconRes = com.tencent.mm.ui.chatting.g.t(tiVar.ceQ.ceS, tiVar.ceQ.ceT, bdVar.field_isSend == 1);
                                if (g_a.iconRes <= 0) {
                                    g_a.iconRes = identifier;
                                }
                                obj2 = g_a;
                            }
                        }
                        b = com.tencent.mm.ui.gridviewheaders.a.czj().b(new Date(bdVar.field_createTime));
                        if (j != b) {
                            linkedList.add(new b.c(bdVar.field_createTime));
                        }
                        linkedList.add(obj2);
                        j = b;
                    }
                }
                b = j;
                j = b;
            } finally {
                bI.close();
            }
        }
        this.tYD.gBc.addAll(linkedList);
        this.tYD.tYc = this.tYD.gBc;
        linkedList.clear();
        ah.A(new Runnable() {
            public final void run() {
                if (g$1.this.tYD.tXZ != null) {
                    g$1.this.tYD.tXZ.y(g$1.this.tXV, g$1.this.tYD.gBc.size());
                }
            }
        });
    }
}
