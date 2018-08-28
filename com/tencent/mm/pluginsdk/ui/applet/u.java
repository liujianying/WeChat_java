package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

public final class u implements e {
    Context context;
    p jnR;
    private al lYo = new al(new 1(this), false);
    h mMA;
    private String qJP;

    public u(Context context) {
        this.context = context;
    }

    public final void TM(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
            return;
        }
        this.qJP = str;
        au.HU();
        String str2 = (String) c.DT().get(46, null);
        au.HU();
        x.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[]{str2, bi.oV((String) c.DT().get(72, null))});
        if (bi.oW(str2) && bi.oW(r1)) {
            TN(str);
            return;
        }
        au.DF().a(233, this);
        this.mMA = new h(o.cx(str), (int) System.currentTimeMillis());
        au.DF().a(this.mMA, 0);
        this.lYo.J(3000, 3000);
    }

    private void TN(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.context.getString(R.l.contact_info_qzone_url, new Object[]{str}));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("neverGetA8Key", true);
        d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
    }

    public final void a(int i, int i2, String str, l lVar) {
        this.lYo.SO();
        if (this.jnR != null) {
            this.jnR.dismiss();
        }
        au.DF().b(233, this);
        if (i == 0 && i2 == 0) {
            h hVar = (h) lVar;
            String QL = hVar.QL();
            if (QL == null || QL.length() == 0) {
                TN(this.qJP);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", QL);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("geta8key_session_id", hVar.QS());
            d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
            return;
        }
        x.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        TN(this.qJP);
    }
}
