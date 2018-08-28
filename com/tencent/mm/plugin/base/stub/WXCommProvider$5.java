package com.tencent.mm.plugin.base.stub;

import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$5 extends bd<Integer> {
    final /* synthetic */ WXCommProvider hdU;
    final /* synthetic */ Uri hdW;
    final /* synthetic */ int hdX;
    final /* synthetic */ String[] hdY;

    WXCommProvider$5(WXCommProvider wXCommProvider, Integer num, Uri uri, int i, String[] strArr) {
        this.hdU = wXCommProvider;
        this.hdW = uri;
        this.hdX = i;
        this.hdY = strArr;
        super(2000, num, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        x.d("MicroMsg.WXCommProvider", "delete, uri = %s, code = %d", new Object[]{this.hdW.toString(), Integer.valueOf(this.hdX)});
        if (this.hdX != 1) {
            x.e("MicroMsg.WXCommProvider", "delete fail, invalid code = %d", new Object[]{Integer.valueOf(this.hdX)});
            return null;
        }
        int i = 0;
        for (String str : this.hdY) {
            if (!bi.oW(str)) {
                int i2 = (WXCommProvider.a(this.hdU).contains(str) && WXCommProvider.a(this.hdU).edit().remove(str).commit()) ? 1 : 0;
                if (i2 != 0) {
                    i++;
                }
            }
        }
        x.d("MicroMsg.WXCommProvider", "delete result = %d", new Object[]{Integer.valueOf(i)});
        return Integer.valueOf(i);
    }
}
