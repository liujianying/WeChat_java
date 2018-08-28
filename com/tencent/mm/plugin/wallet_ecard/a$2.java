package com.tencent.mm.plugin.wallet_ecard;

import android.content.Context;
import com.tencent.mm.g.a.le;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$2 extends c<le> {
    final /* synthetic */ a pBo;

    a$2(a aVar) {
        this.pBo = aVar;
        this.sFo = le.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        le leVar = (le) bVar;
        int i = 1;
        if (leVar.bVx.scene > 0) {
            i = leVar.bVx.scene;
        }
        Context context = (Context) leVar.bVx.YC.get();
        if (context != null) {
            com.tencent.mm.plugin.wallet_ecard.a.b.a(i, null, "WEB_DEBIT", null, context, null);
        }
        return false;
    }
}
