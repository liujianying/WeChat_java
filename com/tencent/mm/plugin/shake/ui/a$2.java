package com.tencent.mm.plugin.shake.ui;

import android.os.Message;
import com.tencent.mm.aq.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

class a$2 extends ag {
    final /* synthetic */ boolean hlD;
    final /* synthetic */ r hlE = null;

    a$2(boolean z) {
        this.hlD = z;
    }

    public final void handleMessage(Message message) {
        int i;
        int GQ = q.GQ();
        if (this.hlD) {
            i = GQ & -257;
        } else {
            i = GQ | ab.CTRL_BYTE;
        }
        x.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", new Object[]{Boolean.valueOf(this.hlD), Integer.valueOf(GQ), Integer.valueOf(i)});
        au.HU();
        c.DT().set(34, Integer.valueOf(i));
        au.HU();
        c.FQ().b(new l("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.hlD) {
            m.buF();
        }
        if (this.hlE != null) {
            this.hlE.a(null, null);
        }
    }
}
