package com.tencent.mm.plugin.card.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.card.d.g;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;

public final class o extends c<pi> {
    public o() {
        this.sFo = pi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pi piVar = (pi) bVar;
        if (piVar instanceof pi) {
            Object obj = piVar.cag.bRw;
            long j = piVar.cag.bIZ;
            String str = piVar.cag.bRx;
            d xQ = g.xQ(obj);
            if (xQ == null) {
                x.e("ShareCardEventListener", "item == null");
            } else if (TextUtils.isEmpty(obj)) {
                x.e("ShareCardEventListener", "cardAppMsg is empty");
            } else {
                a gp = a.gp(((i) com.tencent.mm.kernel.g.l(i.class)).bcY().dW(j).field_content);
                if (gp != null) {
                    gp.dxE = g.a(xQ);
                    gp.bRw = obj;
                    gp.dxF = xQ.hwh;
                    gp.dxG = xQ.cae;
                    gp.dxH = xQ.huV;
                    byte[] bArr = null;
                    Bitmap a = y.a(new m(gp.thumburl));
                    if (a != null) {
                        bArr = com.tencent.mm.sdk.platformtools.c.Q(a);
                    }
                    ((com.tencent.mm.plugin.card.compat.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.card.compat.a.a.class)).b(gp, gp.appId, xQ.hwh, str, bArr);
                    return true;
                }
            }
        }
        return false;
    }
}
