package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class g$89 implements a {
    final /* synthetic */ g qiK;
    final /* synthetic */ Intent val$intent;

    g$89(g gVar, Intent intent) {
        this.qiK = gVar;
        this.val$intent = intent;
    }

    public final void x(String str, boolean z) {
        int i = 42;
        if (g.j(this.qiK) == null) {
            x.w("MicroMsg.MsgHandler", "getNow callback, msghandler has already been detached!");
            g.a(this.qiK, g.k(this.qiK), "profile:fail", null);
            return;
        }
        if (g.l(this.qiK) != null) {
            g.l(this.qiK).dismiss();
        }
        au.HU();
        com.tencent.mm.l.a Yg = c.FR().Yg(str);
        if (Yg == null || ((int) Yg.dhP) <= 0) {
            au.HU();
            Yg = c.FR().Yd(str);
        }
        if (Yg == null || ((int) Yg.dhP) <= 0) {
            z = false;
        } else {
            str = Yg.field_username;
        }
        if (z) {
            com.tencent.mm.aa.c.J(str, 3);
            q.KJ().jO(str);
            this.val$intent.addFlags(268435456);
            this.val$intent.putExtra("Contact_User", str);
            if (Yg.ckW()) {
                if (g.m(this.qiK) != null) {
                    i = g.m(this.qiK).getInt("Contact_Scene", 42);
                }
                h.mEJ.k(10298, Yg.field_username + "," + i);
                this.val$intent.putExtra("Contact_Scene", i);
            }
            g.a(this.qiK, this.val$intent);
            g.a(this.qiK, g.k(this.qiK), "profile:ok", null);
            return;
        }
        Toast.makeText(ad.getContext(), g.j(this.qiK).getString(R.l.fmt_self_qrcode_getting_err, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
        g.a(this.qiK, g.k(this.qiK), "profile:fail", null);
    }
}
