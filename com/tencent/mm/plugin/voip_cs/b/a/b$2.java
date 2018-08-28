package com.tencent.mm.plugin.voip_cs.b.a;

import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b oXY;

    b$2(b bVar) {
        this.oXY = bVar;
    }

    public final boolean vD() {
        b.a(this.oXY).setText(ad.getContext().getString(R.l.voip_cs_waiting));
        b.b(this.oXY).setVisibility(0);
        com.tencent.mm.plugin.voip_cs.c.a c = b.c(this.oXY);
        TextView b = b.b(this.oXY);
        int[] iArr = b.oQq;
        if (iArr == null || b == null) {
            x.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        } else {
            c.bLJ();
            c.oQG = 0;
            c.oQE = iArr;
            c.ih = b;
            c.oQF = 500;
            if (c.eOf != null) {
                long j = (long) c.oQF;
                c.eOf.J(j, j);
            }
            x.k("MicroMsg.DynamicTextWrap", "start textview:" + b, new Object[0]);
        }
        return true;
    }
}
