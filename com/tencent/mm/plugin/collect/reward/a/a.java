package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a extends l implements k {
    protected String Yy;
    protected int errCode = 0;
    protected int errType = 0;
    protected WeakReference<Activity> hUT;
    protected boolean hUU = false;
    protected boolean hUV = false;

    protected abstract void b(int i, int i2, String str, q qVar);

    protected boolean aBP() {
        return true;
    }

    public final void o(Activity activity) {
        this.hUT = new WeakReference(activity);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            this.hUU = true;
            if (aBP() && this.hUT != null) {
                Activity activity = (Activity) this.hUT.get();
                if (activity != null) {
                    h.a(activity, activity.getString(i.wallet_unknown_err), null, false, new 1(this));
                }
            }
        }
        this.errCode = i3;
        this.errType = i2;
        this.Yy = str;
        b(i2, i3, str, qVar);
    }

    public final a a(a aVar) {
        if (!(this.hUU || this.hUV)) {
            aVar.i(this);
        }
        return this;
    }

    public final a b(a aVar) {
        if (this.hUV) {
            aVar.i(this);
        }
        return this;
    }

    public final a c(a aVar) {
        if (this.hUU) {
            aVar.i(this);
        }
        return this;
    }
}
