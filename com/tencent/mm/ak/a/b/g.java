package com.tencent.mm.ak.a.b;

import com.tencent.mm.ak.a.c.n;
import com.tencent.mm.ak.a.d.a;
import com.tencent.mm.sdk.platformtools.x;

public final class g implements n {
    private a<String, Integer> dYg = new a(10);

    public final synchronized boolean md(String str) {
        boolean z;
        if (this.dYg.bb(str)) {
            int intValue = ((Integer) this.dYg.get(str)).intValue();
            this.dYg.put(str, Integer.valueOf(intValue + 1));
            if (intValue >= 50) {
                if (intValue == 50 || intValue % 500 == 0) {
                    x.i("MicroMsg.imageloader.DefaultImageRetryDownloadListener", "Url %s retry over time %d current time:%d, then stop retry download", new Object[]{str, Integer.valueOf(50), Integer.valueOf(intValue)});
                }
                z = false;
            }
            z = true;
        } else {
            this.dYg.put(str, Integer.valueOf(1));
            z = true;
        }
        return z;
    }
}
