package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.plugin.aa.b.3;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class b$3$2 implements a<Void, Boolean> {
    final /* synthetic */ j ezy;
    final /* synthetic */ 3 ezz;

    b$3$2(3 3, j jVar) {
        this.ezz = 3;
        this.ezy = jVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.SubCoreAA", "close aa success: %s", new Object[]{(Boolean) obj});
        this.ezy.Wb().Wa();
        Toast.makeText(ad.getContext(), a$i.close_aa_notify_tips, 0).show();
        return uQG;
    }
}
