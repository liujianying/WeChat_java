package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

public final class r implements e {
    Context context;
    p jnR;
    al lYo = new al(new 1(this), false);
    h mMA;
    String url;

    public r(Context context) {
        this.context = context;
    }

    final void b(String str, int i, byte[] bArr) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("geta8key_session_id", i);
        intent.putExtra("geta8key_cookie", bArr);
        b.ezn.j(intent, this.context);
    }

    public final void a(int i, int i2, String str, l lVar) {
        this.lYo.SO();
        if (this.jnR != null) {
            this.jnR.dismiss();
        }
        au.DF().b(233, this);
        h hVar = (h) lVar;
        if (i == 0 && i2 == 0) {
            String QL = hVar.QL();
            if (QL == null || QL.length() == 0) {
                b(this.url, hVar.QS(), hVar.QT());
                return;
            } else {
                b(QL, hVar.QS(), hVar.QT());
                return;
            }
        }
        x.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        b(this.url, hVar.QS(), hVar.QT());
    }
}
