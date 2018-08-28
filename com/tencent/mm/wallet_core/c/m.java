package com.tencent.mm.wallet_core.c;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;

public abstract class m extends l implements k {
    public String dox = "";
    public int fdx = 0;
    public long iNJ = 0;
    private int isz = 0;
    private long pCV;
    public Bundle sy;

    public abstract void e(int i, int i2, String str, q qVar);

    public int baY() {
        return -1;
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis() - this.pCV;
        String str2 = "";
        String str3 = "";
        this.isz = baY();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.sy != null) {
            str2 = this.sy.getString("key_TransId");
            str3 = this.sy.getString("key_reqKey");
            if (this.iNJ == 0) {
                this.iNJ = this.sy.getLong("key_SessionId", 0);
            }
            if (this.fdx == 0) {
                this.fdx = this.sy.getInt("key_scene");
            }
        }
        h.mEJ.h(11170, new Object[]{Integer.valueOf(getType()), Integer.valueOf(this.isz), Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(ao.getNetType(ad.getContext())), this.dox, str2, str3, Long.valueOf(this.iNJ), Long.valueOf(currentTimeMillis2)});
        q.a(getType(), baY(), i2, i3, currentTimeMillis, this.fdx, this.dox);
        e(i2, i3, str, qVar);
    }

    public final int a(e eVar, q qVar, k kVar) {
        this.pCV = System.currentTimeMillis();
        return super.a(eVar, qVar, kVar);
    }
}
