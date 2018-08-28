package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;

class c$3 implements g {
    final /* synthetic */ gq kdk;

    c$3(gq gqVar) {
        this.kdk = gqVar;
    }

    public final void me(String str) {
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        this.kdk.bPN.nc = 2;
        this.kdk.bPN.url = str;
        a.sFg.m(this.kdk);
        if (bVar != null) {
            int i = bVar.bJu;
            if (bVar.status != 0 || bVar.bitmap == null) {
                if (i == 2) {
                    h.mEJ.a(858, 14, 1, false);
                }
            } else if (i == 2) {
                h.mEJ.a(858, 13, 1, false);
            }
        }
    }
}
