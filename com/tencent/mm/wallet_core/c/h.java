package com.tencent.mm.wallet_core.c;

import android.widget.Toast;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class h extends l implements k {
    private static final String uXd = ad.getResources().getString(i.wallet_unknown_err);
    private WeakReference<MMActivity> YC;
    protected String Yy;
    public b diG;
    public e diJ;
    protected int errCode = 0;
    protected int errType = 0;
    public boolean hUU = true;
    public boolean hUV = false;
    public int uXe = 0;
    public String uXf;

    public abstract void b(int i, int i2, String str, q qVar);

    public abstract void f(q qVar);

    public final void m(MMActivity mMActivity) {
        this.YC = new WeakReference(mMActivity);
    }

    public boolean aBQ() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            this.hUU = false;
        }
        if (!this.hUU) {
            f(qVar);
            if (this.uXe != 0) {
                this.hUV = true;
            }
        }
        this.errCode = i3;
        this.errType = i2;
        this.Yy = str;
        x.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.uXe), this.uXf});
        b(i2, i3, str, qVar);
        if (this.YC != null) {
            MMActivity mMActivity = (MMActivity) this.YC.get();
            if (mMActivity == null) {
                return;
            }
            if (this.hUU) {
                x.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
                com.tencent.mm.ui.base.h.a(mMActivity, uXd, null, false, new 1(this, mMActivity));
            } else if (this.hUV && !bi.oW(this.uXf) && aBQ()) {
                x.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
                Toast.makeText(mMActivity, this.uXf, 1).show();
            }
        }
    }

    public int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        Assert.assertNotNull("rr can't be null!", this.diG);
        return a(eVar, this.diG, this);
    }

    public final h a(a aVar) {
        if (!(this.hUU || this.hUV)) {
            aVar.g(this.errCode, this.errType, this.Yy, this);
        }
        return this;
    }

    public final h b(a aVar) {
        if (this.hUV) {
            aVar.g(this.errCode, this.errType, this.Yy, this);
        }
        return this;
    }

    public final h c(a aVar) {
        if (this.hUU) {
            aVar.g(this.errCode, this.errType, this.Yy, this);
        }
        return this;
    }
}
