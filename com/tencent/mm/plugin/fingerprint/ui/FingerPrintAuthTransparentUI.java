package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class FingerPrintAuthTransparentUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    private c jgt = new 1(this);
    private i jhc = null;
    Dialog jhd;
    private j jhe = null;
    private int jhf = -1;
    private Animation jhg;
    private int jhh = 0;
    private boolean jhi = false;
    private int jhj = 0;
    private boolean jhk = false;
    View view = null;

    static /* synthetic */ void a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        fingerPrintAuthTransparentUI.jhi = false;
        com.tencent.mm.plugin.fingerprint.a.aMW();
        com.tencent.mm.plugin.fingerprint.a.aMX();
        com.tencent.mm.plugin.fingerprint.b.c.release();
        fingerPrintAuthTransparentUI.jhc.dismiss();
        fingerPrintAuthTransparentUI.jhe.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.jhf, 2);
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthTransparentUI.jhh > 1) {
            fingerPrintAuthTransparentUI.jhh = currentTimeMillis;
            ((TextView) fingerPrintAuthTransparentUI.view.findViewById(f.tips)).setVisibility(8);
            TextView textView = (TextView) fingerPrintAuthTransparentUI.view.findViewById(f.errortip);
            textView.setVisibility(4);
            if (fingerPrintAuthTransparentUI.jhg == null) {
                fingerPrintAuthTransparentUI.jhg = AnimationUtils.loadAnimation(fingerPrintAuthTransparentUI.mController.tml, com.tencent.mm.plugin.wxpay.a.a.finger_print_layout_anim);
            }
            textView.startAnimation(fingerPrintAuthTransparentUI.jhg);
            ah.i(new 6(fingerPrintAuthTransparentUI, textView), fingerPrintAuthTransparentUI.jhg.getDuration());
        }
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, boolean z) {
        com.tencent.mm.plugin.soter.c.a.dK(2, fingerPrintAuthTransparentUI.jhj);
        if (z) {
            com.tencent.mm.plugin.soter.c.a.c(10, -1000223, -1, "user permanent cancelled");
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled and checked as not show anymore");
            g.Ek();
            g.Ei().DT().a(aa.a.sQv, Boolean.valueOf(true));
        } else {
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled but will show again");
            com.tencent.mm.plugin.soter.c.a.c(1, -1000223, -1, "user cancelled");
        }
        fingerPrintAuthTransparentUI.finish();
    }

    static /* synthetic */ void c(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        com.tencent.mm.plugin.soter.c.a.dK(3, fingerPrintAuthTransparentUI.jhj);
        Bundle ae = com.tencent.mm.wallet_core.a.ae(fingerPrintAuthTransparentUI);
        String str = "";
        if (ae != null) {
            str = ae.getString("key_pwd1");
        }
        fingerPrintAuthTransparentUI.jhe.a(fingerPrintAuthTransparentUI, new 11(fingerPrintAuthTransparentUI), str);
        fingerPrintAuthTransparentUI.dO(true);
        if (fingerPrintAuthTransparentUI.jhc != null && fingerPrintAuthTransparentUI.jhc.isShowing()) {
            fingerPrintAuthTransparentUI.jhc.dismiss();
        }
    }

    static /* synthetic */ void d(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "showIdentifyUI!");
        fingerPrintAuthTransparentUI.view = LayoutInflater.from(fingerPrintAuthTransparentUI).inflate(com.tencent.mm.plugin.wxpay.a.g.fingerprint_auth_dialog_layout, null);
        ViewParent parent = fingerPrintAuthTransparentUI.view.getParent();
        ViewGroup viewGroup = parent != null ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ((ImageView) fingerPrintAuthTransparentUI.view.findViewById(f.fingerPrint_auth_dialog_close_iv)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (FingerPrintAuthTransparentUI.this.jhc != null) {
                    FingerPrintAuthTransparentUI.this.jhc.cancel();
                }
                FingerPrintAuthTransparentUI.aNL();
                FingerPrintAuthTransparentUI.this.finish();
            }
        });
        if (fingerPrintAuthTransparentUI.jhc != null && fingerPrintAuthTransparentUI.jhc.isShowing()) {
            fingerPrintAuthTransparentUI.jhc.dismiss();
            fingerPrintAuthTransparentUI.jhc = null;
        }
        fingerPrintAuthTransparentUI.jhc = new i(fingerPrintAuthTransparentUI, com.tencent.mm.plugin.wxpay.a.j.mmdialog);
        fingerPrintAuthTransparentUI.jhc.setContentView(fingerPrintAuthTransparentUI.view);
        fingerPrintAuthTransparentUI.jhc.setCanceledOnTouchOutside(false);
        fingerPrintAuthTransparentUI.jhc.setCancelable(true);
        fingerPrintAuthTransparentUI.jhc.show();
        fingerPrintAuthTransparentUI.jhc.setOnCancelListener(new 13(fingerPrintAuthTransparentUI));
        h.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.jhc);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
        if (!e.aNm()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
            finish();
        } else if (q.GS()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
            finish();
        } else if (e.aNy()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
            finish();
        } else {
            com.tencent.mm.plugin.fingerprint.a.aMW();
            com.tencent.mm.plugin.fingerprint.a.aMX();
            if (com.tencent.mm.plugin.fingerprint.b.c.aNf()) {
                if (com.tencent.mm.compatible.e.q.deQ.deZ != 1) {
                    x.e("MicroMsg.FingerPrintAuthTransparentUI", "hy: device config force to not support");
                    finish();
                }
                ag bOW = o.bOW();
                com.tencent.mm.plugin.fingerprint.a.aMW();
                com.tencent.mm.plugin.fingerprint.a.aMX();
                this.jhe = com.tencent.mm.plugin.fingerprint.b.c.aNg();
                this.jhk = g.Ei().DT().getBoolean(aa.a.sQx, false);
                if (!bOW.bPs() || e.aNy()) {
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + bOW.bPs() + ";isOpenTouch:" + e.aNy());
                    x.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
                    finish();
                    return;
                }
                x.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
                com.tencent.d.b.f.f.cFZ().cGa();
                com.tencent.mm.plugin.report.service.h.mEJ.h(12924, new Object[]{Integer.valueOf(1)});
                com.tencent.mm.plugin.soter.c.a.xO(0);
                if (g.Ei().DT().getBoolean(aa.a.sQu, true)) {
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
                    g.Ei().DT().a(aa.a.sQu, Boolean.valueOf(false));
                    g.Ei().DT().a(aa.a.sQx, Boolean.valueOf(false));
                    h.a(this, this.jhk ? getString(a$i.guide_open_text_for_transparent_recover) : getString(a$i.guide_open_text_for_transparent), "", getString(a$i.btn_guide_open_fingerprint), getString(a$i.app_cancel), false, new 7(this), new 8(this));
                    g.Ei().DT().a(aa.a.sQw, Integer.valueOf(1));
                    this.jhj = 1;
                    com.tencent.mm.plugin.soter.c.a.dK(1, this.jhj);
                    return;
                }
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
                View inflate = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.fingerprint_guide_dialog, null);
                CheckBox checkBox = (CheckBox) inflate.findViewById(f.fingerprint_not_show_any_more_cb);
                this.jhj = ((Integer) g.Ei().DT().get(aa.a.sQw, null)).intValue() + 1;
                g.Ei().DT().a(aa.a.sQw, Integer.valueOf(this.jhj));
                com.tencent.mm.plugin.soter.c.a.dK(1, this.jhj);
                h.a(this, false, null, inflate, getString(a$i.btn_guide_open_fingerprint), getString(a$i.app_cancel), new 9(this), new 10(this, checkBox));
                return;
            }
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.jhi) {
            fe(false);
        }
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
        WakeLock newWakeLock = ((PowerManager) this.mController.tml.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        aNL();
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    protected void onStop() {
        super.onStop();
        finish();
    }

    private void fe(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.aMW();
        com.tencent.mm.plugin.fingerprint.a.aMX();
        com.tencent.mm.plugin.fingerprint.b.c.abort();
        com.tencent.mm.plugin.fingerprint.b.c.release();
        if (!com.tencent.mm.plugin.fingerprint.b.c.aNf()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
        } else if (com.tencent.mm.plugin.fingerprint.b.c.a(this.jgt, z) != 0) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "startFingerprintAuth failed!");
        }
    }

    private static void aNL() {
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.aMW();
        if (com.tencent.mm.plugin.fingerprint.a.aMX() != null) {
            com.tencent.mm.plugin.fingerprint.b.c.aNe();
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return this.jhe.d(i, i2, str, lVar);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void finish() {
        if (this.jhe != null) {
            this.jhe.clear();
        }
        super.finish();
    }

    private void BL(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = getString(-1);
        } else {
            string = str;
        }
        h.a(this, string, "", getString(a$i.wallet_i_know_it), false, new 3(this));
    }

    protected final void dO(boolean z) {
        if (z) {
            this.jhd = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        } else if (this.jhd != null && this.jhd.isShowing()) {
            this.jhd.dismiss();
            this.jhd = null;
        }
    }

    public void onDestroy() {
        if (this.jhc != null && this.jhc.isShowing()) {
            this.jhc.dismiss();
            this.jhc = null;
        }
        if (this.jhg != null) {
            this.jhg.cancel();
        }
        dO(false);
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void af(int i, String str) {
        dO(false);
        if (i == 0) {
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
            a(new y(null, 19), false, false);
            h.a(this.mController.tml, false, null, LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.finger_print_auth_success_dialog_layout, null), getString(a$i.wallet_i_know_it), "", new 2(this), null);
        } else if (i == -2) {
            String string;
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
            int i2 = a$i.fingerprint_open_fail;
            if (TextUtils.isEmpty(str)) {
                string = getString(i2);
            } else {
                string = str;
            }
            h.a(this, string, "", getString(a$i.fingerprint_try_again), getString(a$i.app_cancel), false, new 4(this), new 5(this));
        } else {
            BL(str);
        }
    }
}
