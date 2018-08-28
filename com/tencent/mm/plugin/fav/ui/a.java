package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.b.1;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a extends c<ch> {
    public a() {
        this.sFo = ch.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = -2;
        ch chVar = (ch) bVar;
        if (-2 == chVar.bJF.type) {
            long j = bi.getLong(chVar.bJF.bJv, -1);
            if (0 >= j) {
                x.w("MicroMsg.Fav.FavAddItemListener", "error fav info local id");
            } else {
                g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
                if (bi.oW(dy.field_favProto.fky)) {
                    h.mEJ.h(10873, new Object[]{Integer.valueOf(6)});
                } else {
                    h.mEJ.h(10874, new Object[]{Integer.valueOf(6)});
                }
                dy.field_favProto.Vt(chVar.bJF.desc);
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(dy, "rowid");
                String str = chVar.bJF.desc;
                if (dy == null) {
                    x.w("MicroMsg.Fav.FavAddItemListener", "modRemark, item info is null");
                } else if (dy.field_id <= 0) {
                    x.w("MicroMsg.Fav.FavAddItemListener", "modRemark favid:%d", new Object[]{Integer.valueOf(dy.field_id)});
                } else {
                    j = System.currentTimeMillis();
                    LinkedList linkedList = new LinkedList();
                    auj auj = new auj();
                    auj.rXA = 4;
                    auj.rXB = 0;
                    linkedList.add(auj);
                    LinkedList linkedList2 = new LinkedList();
                    aum aum = new aum();
                    aum.jSt = "favitem.remark";
                    aum.mEl = str;
                    linkedList2.add(aum);
                    aum aum2 = new aum();
                    aum2.jSt = "favitem.remark";
                    aum2.rXG = "time";
                    aum2.mEl = String.valueOf(j);
                    linkedList2.add(aum2);
                    com.tencent.mm.kernel.g.DF().a(new al(dy.field_id, linkedList, linkedList2), 0);
                }
            }
        } else {
            ch.b bVar2 = chVar.bJG;
            if (chVar == null || chVar.bJF == null) {
                i = -1;
            } else {
                int i2;
                if (chVar.bJF.bJH == null) {
                    x.w("MicroMsg.Fav.FavAddService", "handleEvent error, event is null");
                    if (chVar.bJF.bJL == 0) {
                        chVar.bJF.bJL = i.favorite_fail_argument_error;
                    }
                    i2 = chVar.bJF.bJL;
                } else {
                    i2 = 0;
                }
                if (chVar.bJF.activity == null && chVar.bJF.nd == null) {
                    x.i("MicroMsg.Fav.FavAddService", "handleEvent context = null && frament = null");
                }
                if (chVar.bJF.bJL > 0) {
                    i = chVar.bJF.bJL;
                } else if (com.tencent.mm.plugin.fav.a.b.pG(chVar.bJF.type)) {
                    fz fzVar = new fz();
                    fzVar.bOL.type = 36;
                    com.tencent.mm.sdk.b.a.sFg.m(fzVar);
                    if (fzVar.bOM.ret != 1) {
                        i = chVar.bJF.bJL;
                        chVar.bJF.bJN = new 1(chVar);
                    }
                } else {
                    i = i2;
                }
                if (((Integer) com.tencent.mm.kernel.g.Ei().DT().get(225281, Integer.valueOf(0))).intValue() != 1) {
                    x.i("MicroMsg.Fav.FavAddService", "try show intro ui");
                    com.tencent.mm.plugin.fav.a.b.a(chVar.bJF.activity, ".ui.FavTipsUI", new Intent());
                    com.tencent.mm.kernel.g.Ei().DT().set(225281, Integer.valueOf(1));
                }
                c.a(chVar.bJF.type, i, chVar.bJF.activity, chVar.bJF.nd, chVar.bJF.bJO, chVar.bJF.bJN, null);
                x.i("MicroMsg.Fav.FavAddService", "err Type = %d", new Object[]{Integer.valueOf(i)});
                if (i == -9 || i == 0) {
                    i = b.a(chVar);
                }
            }
            bVar2.ret = i;
        }
        return false;
    }
}
