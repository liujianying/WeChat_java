package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.l;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.y;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.mm.y.g$a;
import java.util.List;

public final class d implements com.tencent.mm.plugin.messenger.a.d {
    public final void D(String str, String str2, int i) {
        if (str == null || str2 == null) {
            x.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[]{str, str2});
            return;
        }
        au.DF().a(new i(str, str2, i), 0);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, String str4) {
        a(context, str, str2, str3, i, i2, null, str4);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, bri bri, String str4) {
        int i3 = 1;
        if (context == null) {
            x.w("MicroMsg.SendMsgMgr", "send vedio context is null");
        } else if (str == null || str2 == null) {
            x.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[]{str, str2});
        } else {
            au.HU();
            if (c.isSDCardAvailable()) {
                a aVar = new a();
                context.getResources().getString(R.l.app_tip);
                p a = h.a(context, context.getResources().getString(R.l.app_sending), true, new 1(this, aVar));
                aVar.context = context;
                aVar.fileName = str2;
                aVar.uDW = str3;
                aVar.eXG = a;
                aVar.userName = str;
                aVar.bZN = str4;
                aVar.uDZ = false;
                if (62 == i) {
                    aVar.elY = 11;
                }
                if (i <= 0) {
                    i3 = 0;
                }
                aVar.uDq = i3;
                aVar.enM = i2;
                aVar.uDX = false;
                aVar.uEa = bri;
                aVar.execute(new Object[0]);
                return;
            }
            x.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
            Toast.makeText(context, R.l.msgretr_share_nosdcard_fail, 1).show();
        }
    }

    public final void a(Context context, String str, String str2, int i, String str3, String str4) {
        if (str == null || str2 == null) {
            x.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", new Object[]{str, str2});
            return;
        }
        au.HU();
        if (c.isSDCardAvailable()) {
            au.DF().a(new l(4, q.GF(), str, str2, i, null, 0, str3, str4, true, R.g.chat_img_template), 0);
            br.IE().c(br.dDm, null);
            return;
        }
        x.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
        Toast.makeText(context, R.l.msgretr_share_nosdcard_fail, 1).show();
    }

    public final void a(String str, byte[] bArr, String str2, String str3) {
        if (str == null) {
            x.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
            return;
        }
        x.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[]{str2});
        g$a gp = g$a.gp(bi.WT(str2));
        if (gp == null) {
            x.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
            return;
        }
        b bVar = new b();
        x.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[]{gp.bGP});
        if (!bi.oW(gp.bGP)) {
            long j = bi.getLong(gp.bGP, -1);
            if (j != -1) {
                ao.asF().b(j, bVar);
                if (bVar.sKx != j) {
                    bVar = ao.asF().SR(gp.bGP);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(gp.bGP)) {
                        bVar = null;
                    }
                    if (bVar == null) {
                        x.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[]{gp.bGP});
                    } else {
                        x.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[]{gp.bGP, Long.valueOf(bVar.sKx), bVar.field_fileFullPath});
                    }
                }
            } else {
                bVar = ao.asF().SR(gp.bGP);
                if (bVar == null || !bVar.field_mediaSvrId.equals(gp.bGP)) {
                    bVar = null;
                }
                if (bVar == null) {
                    x.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[]{gp.bGP});
                } else {
                    x.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[]{gp.bGP, Long.valueOf(bVar.sKx), bVar.field_fileFullPath});
                }
            }
        }
        String str4 = "";
        if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(""))) {
            au.HU();
            str4 = com.tencent.mm.pluginsdk.model.app.l.al(c.Gk(), gp.title, gp.dwp);
            j.q(bVar.field_fileFullPath, str4, false);
            x.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[]{bVar.field_fileFullPath, str4, Integer.valueOf(e.cm(bVar.field_fileFullPath))});
        }
        g$a a = g$a.a(gp);
        a.dwr = 3;
        com.tencent.mm.pluginsdk.model.app.l.a(a, gp.appId, gp.appName, str, str4, bArr, str3);
    }

    public final void l(String str, String str2, boolean z) {
        if (z) {
            au.DF().a(new i(bi.aG(str2, ""), y.aaP(str), ab.XR(str) ? 66 : 42), 0);
            return;
        }
        List F = bi.F(bi.aG(str2, "").split(","));
        String aaP = y.aaP(str);
        for (int i = 0; i < F.size(); i++) {
            int i2;
            String str3 = (String) F.get(i);
            if (ab.XR(str)) {
                i2 = 66;
            } else {
                i2 = 42;
            }
            au.DF().a(new i(str3, aaP, i2), 0);
        }
    }

    public final void dF(String str, String str2) {
        List<String> F = bi.F(bi.aG(str2, "").split(","));
        if (!TextUtils.isEmpty(str)) {
            for (String str3 : F) {
                ow owVar = new ow();
                owVar.bZQ.bZR = str3;
                owVar.bZQ.content = str;
                owVar.bZQ.type = s.hQ(str3);
                owVar.bZQ.flags = 0;
                com.tencent.mm.sdk.b.a.sFg.m(owVar);
            }
        }
    }
}
