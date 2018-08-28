package com.tencent.mm.ao;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.protocal.c.btb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bh;

public final class d implements e {
    public a ebC = null;

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.NewTipsManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (lVar.getType() == 597 && i == 0 && i2 == 0) {
            boolean z = ((a) lVar).ebi;
            bh Do = a.bjj().Do(((a) lVar).ebj);
            if (Do != null) {
                Do.field_isReject = z;
                x.i("MicroMsg.NewTipsManager", "Newtips push is reject: %s", new Object[]{Boolean.valueOf(z)});
                a.bjj().a(Do, new String[0]);
            }
        }
    }

    public static void b(int i, int i2, String str, String str2) {
        bh Do = a.bjj().Do(i);
        if (Do == null) {
            Do = new bh();
            Do.field_tipId = i;
            Do.field_tipVersion = 1;
            Do.field_tipkey = str;
            Do.field_tipType = i2;
            if (Do.field_tipsShowInfo == null) {
                Do.field_tipsShowInfo = new btb();
            }
            Do.field_tipsShowInfo.path = str2;
            a.bjj().f(Do);
            if (i2 != b.ebk) {
                return;
            }
            if (!Do.field_isExit || 1 != Do.field_tipVersion) {
                g.DF().a(new a(i, str), 0);
                x.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
                return;
            }
            return;
        }
        if (i2 == b.ebk && !(Do.field_isExit && 1 == Do.field_tipVersion)) {
            g.DF().a(new a(i, str), 0);
            x.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
        }
        if ((i2 == b.ebk && 1 != Do.field_tipVersion) || (i2 == b.ebl && Do.field_tipVersion <= 0)) {
            Do.field_tipId = i;
            Do.field_tipVersion = 1;
            Do.field_tipkey = str;
            Do.field_tipType = i2;
            Do.field_isExit = false;
            if (Do.field_tipsShowInfo == null) {
                Do.field_tipsShowInfo = new btb();
            }
            Do.field_tipsShowInfo.path = str2;
            a.bjj().a(Do, new String[0]);
        }
    }

    public static void ih(int i) {
        bh Do = a.bjj().Do(i);
        if (Do == null) {
            x.e("MicroMsg.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
            return;
        }
        x.i("MicroMsg.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(true)});
        if (Do.field_tipType == b.ebk) {
            Do.field_hadRead = true;
            a.bjj().a(Do, new String[0]);
        }
        if (Do.field_tipType == b.ebl) {
            Do.field_hadRead = true;
            a.bjj().a(Do, new String[0]);
        }
        ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", bi.VF()).commit();
    }

    public static void m(int i, long j) {
        bh Do = a.bjj().Do(i);
        if (Do == null) {
            x.e("MicroMsg.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
            return;
        }
        Do.field_pagestaytime = j;
        a.bjj().a(Do, new String[0]);
    }
}
