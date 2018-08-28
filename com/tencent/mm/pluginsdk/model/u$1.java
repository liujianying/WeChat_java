package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.d;

class u$1 implements ValueCallback<Boolean> {
    final /* synthetic */ Context ePr;
    final /* synthetic */ String ewx;
    final /* synthetic */ String qzx;

    u$1(String str, String str2, Context context) {
        this.ewx = str;
        this.qzx = str2;
        this.ePr = context;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            u.fz(this.ewx, this.qzx);
        } else if (d.isTbsCoreInited()) {
            u.fA(this.ewx, this.qzx);
        } else {
            x.i("MicroMsg.TBSHelper", "tbs preInit");
            d.a(this.ePr, new 1(this));
        }
    }
}
