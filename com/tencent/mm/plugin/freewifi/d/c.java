package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ah;

public abstract class c extends l implements k {
    protected Activity activity;
    protected b diG;
    protected e diJ;
    protected e jkx;

    protected abstract void aOR();

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        m.BV("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + i2 + "," + i3 + "]");
        if (this.jkx != null) {
            this.jkx.a(i2, i3, str, this);
        }
        if ((this.activity == null || !this.activity.isFinishing()) && this.diJ != null) {
            ah.A(new 1(this, i, i2, i3, str, qVar, bArr));
        }
    }

    protected void b(int i, int i2, int i3, String str) {
    }

    public final void b(e eVar) {
        this.diJ = eVar;
        m.BV("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        au.DF().a(this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.jkx = eVar2;
        return a(eVar, this.diG, this);
    }

    public final c s(Activity activity) {
        this.activity = activity;
        return this;
    }
}
