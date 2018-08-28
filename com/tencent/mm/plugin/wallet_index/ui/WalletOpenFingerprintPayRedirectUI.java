package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class WalletOpenFingerprintPayRedirectUI extends AutoLoginActivity implements e {
    private boolean Fe = false;
    private Dialog eXG = null;

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] hdM = new int[a.values().length];

        static {
            try {
                hdM[a.qEF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hdM[a.qEH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hdM[a.qEG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Ek();
        g.Eh().dpP.a(385, this);
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final boolean A(Intent intent) {
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Ek();
        g.Eh().dpP.b(385, this);
    }

    protected final void a(a aVar, Intent intent) {
        x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = " + aVar);
        switch (AnonymousClass3.hdM[aVar.ordinal()]) {
            case 1:
                x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
                g.Ek();
                g.Eh().dpP.a(new y(null, 19), 0);
                if (this.eXG != null) {
                    this.eXG.dismiss();
                    this.eXG = null;
                }
                this.eXG = com.tencent.mm.wallet_core.ui.g.e(this, new 1(this));
                return;
            case 2:
            case 3:
                x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = " + aVar);
                b(1, false, "");
                break;
            default:
                x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = " + aVar);
                break;
        }
        b(2, true, getString(a$i.wallet_app_err_system_busy_tip));
    }

    private void b(int i, boolean z, String str) {
        x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", new Object[]{Integer.valueOf(i)});
        if (this.eXG != null && this.eXG.isShowing()) {
            this.eXG.dismiss();
            this.eXG = null;
        }
        if (z) {
            h.a(this, str, "", false, new 2(this));
        } else {
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.eXG != null && this.eXG.isShowing()) {
            this.eXG.dismiss();
            this.eXG = null;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof y)) {
            return;
        }
        if (this.Fe) {
            x.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
            return;
        }
        this.Fe = true;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
            p.bNp();
            ag bNq = p.bNq();
            if (bNq == null || !bNq.bPs()) {
                x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
                b(5, true, getString(a$i.wallet_fingerprint_redirect_not_open_fp_payment));
                return;
            } else if (com.tencent.mm.plugin.wallet.b.a.bOh() && q.deQ.dfa == 1) {
                Intent intent = new Intent();
                intent.putExtra("key_is_from_system", true);
                d.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                finish();
                return;
            } else {
                x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
                b(6, true, getString(a$i.wallet_fingerprint_support_not_fp_pay));
                return;
            }
        }
        x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
        b(3, true, getString(a$i.wallet_app_err_system_busy_tip));
    }
}
