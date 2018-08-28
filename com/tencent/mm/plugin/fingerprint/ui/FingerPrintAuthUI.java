package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.d.b.f.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class FingerPrintAuthUI extends WalletBaseUI implements a {
    private boolean isPaused = false;
    private Dialog jhd = null;
    private j jhe = null;
    private Animation jhg;
    private int jhh = 0;
    private TextView jhn;
    private c jho;
    private a jhp;
    private boolean jhq = false;
    private final int jhr = 1;

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthUI.jhh > 1) {
            fingerPrintAuthUI.jhh = currentTimeMillis;
            fingerPrintAuthUI.jhn.setText(i.fingerprint_auth_error_tip);
            fingerPrintAuthUI.jhn.setTextColor(fingerPrintAuthUI.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
            fingerPrintAuthUI.jhn.setVisibility(4);
            if (fingerPrintAuthUI.jhg == null) {
                fingerPrintAuthUI.jhg = AnimationUtils.loadAnimation(fingerPrintAuthUI.mController.tml, com.tencent.mm.plugin.wxpay.a.a.finger_print_layout_anim);
            }
            fingerPrintAuthUI.jhn.startAnimation(fingerPrintAuthUI.jhg);
            ah.i(new 3(fingerPrintAuthUI), fingerPrintAuthUI.jhg.getDuration());
        }
    }

    static /* synthetic */ boolean c(FingerPrintAuthUI fingerPrintAuthUI) {
        String str = "MicroMsg.FingerPrintAuthUI";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!fingerPrintAuthUI.isPaused);
        x.i(str, str2, objArr);
        return !fingerPrintAuthUI.isPaused;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(i.open_fingerprint_auth_title));
        this.jhn = (TextView) findViewById(a$f.input_tips);
        com.tencent.mm.plugin.fingerprint.a.aMW();
        this.jho = com.tencent.mm.plugin.fingerprint.a.aMX();
        this.jhe = c.aNg();
        Bundle ae = com.tencent.mm.wallet_core.a.ae(this);
        if (ae != null) {
            String string = ae.getString("pwd");
            if (TextUtils.isEmpty(string)) {
                x.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
                bn(getString(i.fingerprint_open_fail), -1);
                com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, -1, "get user pwd error");
                return;
            } else if (e.aNm()) {
                dO(true);
                f.cFZ().cGa();
                this.jhe.a((Context) this, new 1(this), string);
                return;
            } else {
                x.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
                return;
            }
        }
        x.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
        bn(getString(i.fingerprint_open_fail), -1);
        com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
    }

    protected final void dO(boolean z) {
        ah.A(new 2(this, z));
    }

    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (this.jhq) {
            fe(false);
        }
    }

    private void fe(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.aMW();
        com.tencent.mm.plugin.fingerprint.a.aMX();
        c.abort();
        c.release();
        if (c.aNf()) {
            if (this.jhp == null) {
                this.jhp = new a(this, this);
            }
            if (c.a(this.jhp, z) != 0) {
                x.e("MicroMsg.FingerPrintAuthUI", "startFingerprintAuth failed!");
                return;
            }
            return;
        }
        x.e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
    }

    public void onPause() {
        super.onPause();
        this.isPaused = true;
        WakeLock newWakeLock = ((PowerManager) this.mController.tml.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        x.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.aMW();
        if (com.tencent.mm.plugin.fingerprint.a.aMX() != null) {
            c.aNe();
        }
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    public void onDestroy() {
        x.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
        if (this.jhg != null) {
            this.jhg.cancel();
        }
        this.jhp = null;
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (this.jhe.d(i, i2, str, lVar)) {
            return true;
        }
        if (!(lVar instanceof y)) {
            return false;
        }
        dO(false);
        com.tencent.mm.wallet_core.a.c(this, new Bundle(), 0);
        Toast.makeText(this, i.fingerprint_open_success, 0).show();
        return true;
    }

    private void bn(String str, int i) {
        ah.A(new 4(this, str, i));
    }

    protected final int getLayoutId() {
        return a$g.fingerprint_authorize_layout;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void af(int i, String str) {
        if (i == 0) {
            x.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
            a(new y(null, 19), false, false);
            return;
        }
        dO(false);
        x.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
        h.a(this, getString(i.fingerprint_open_fail), "", new 5(this));
    }
}
