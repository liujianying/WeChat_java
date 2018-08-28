package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.plugin.aa.b.3;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class b$3$1 implements a {
    final /* synthetic */ j ezy;
    final /* synthetic */ 3 ezz;

    b$3$1(3 3, j jVar) {
        this.ezz = 3;
        this.ezy = jVar;
    }

    public final void bd(Object obj) {
        if (obj instanceof String) {
            Toast.makeText(ad.getContext(), obj.toString(), 0).show();
        } else {
            x.e("MicroMsg.SubCoreAA", "close aa failed: %s", new Object[]{obj});
            Toast.makeText(ad.getContext(), i.close_paylist_failed, 1).show();
        }
        this.ezy.Wb().Wa();
    }
}
