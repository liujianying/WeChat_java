package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.d.a.c.i;
import com.tencent.d.b.f.f;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.b.b;
import com.tencent.mm.plugin.walletlock.fingerprint.a.a;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c$a;

public class FingerprintWalletLockUI extends MMActivity {
    private String eIe;
    private String eWo = null;
    private TextView gVv;
    private int jhh = 0;
    private c kjn = null;
    private ProgressDialog kjo = null;
    private boolean lnh = true;
    private boolean mcv = false;
    private boolean pGC = false;
    private TextView pGI;
    private TextView pGJ;
    private Animation pGK;
    private String pGL;
    private String pGM;
    private d pGN;
    private h pGO;
    private b pGP;
    private String pGQ = "-1";
    private int pGR = -1;
    private int pGS = -1;
    private String sS;

    static /* synthetic */ void a(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenFailed errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        com.tencent.mm.plugin.walletlock.b.h.Z(fingerprintWalletLockUI.pGS, 2, 1);
        fingerprintWalletLockUI.tn(str);
    }

    static /* synthetic */ void b(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        x.e("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        a.bRv();
        fingerprintWalletLockUI.dismissDialog();
        if (i == 3) {
            com.tencent.mm.plugin.walletlock.b.h.Z(fingerprintWalletLockUI.pGS, 2, 2);
            a.H(System.currentTimeMillis(), 0);
            fingerprintWalletLockUI.pGI.setText(g.wallet_lock_fingerprint_too_many_trial_error);
            fingerprintWalletLockUI.pGI.setTextColor(fingerprintWalletLockUI.getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.red));
        } else if (i == 8) {
            fingerprintWalletLockUI.bRy();
        } else {
            fingerprintWalletLockUI.tn(str);
        }
    }

    static /* synthetic */ void d(FingerprintWalletLockUI fingerprintWalletLockUI) {
        com.tencent.mm.plugin.walletlock.b.h.Z(fingerprintWalletLockUI.pGS, 2, 0);
        i iVar = com.tencent.mm.plugin.walletlock.b.g.pIt.pIv;
        if (iVar != null) {
            fingerprintWalletLockUI.pGQ = iVar.vlF;
            x.v("MicroMsg.FingerprintWalletLockUI", "alvinluo authSuccess and mFid: %s", new Object[]{fingerprintWalletLockUI.pGQ});
            if (fingerprintWalletLockUI.pGM.equals("action.switch_on_pattern")) {
                fingerprintWalletLockUI.pGM = fingerprintWalletLockUI.pGL;
                fingerprintWalletLockUI.bRz();
            } else if (!fingerprintWalletLockUI.pGM.equals("action.verify_pattern")) {
            } else {
                if (a.PH(fingerprintWalletLockUI.pGQ)) {
                    fingerprintWalletLockUI.pGM = fingerprintWalletLockUI.pGL;
                    fingerprintWalletLockUI.bRz();
                    return;
                }
                fingerprintWalletLockUI.zx(2);
            }
        }
    }

    static /* synthetic */ void g(FingerprintWalletLockUI fingerprintWalletLockUI) {
        Intent intent = new Intent();
        intent.putExtra("key_wallet_lock_setting_scene", 1);
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.walletlock.a.b.class)).b((Activity) fingerprintWalletLockUI, intent, 3);
    }

    static /* synthetic */ void i(FingerprintWalletLockUI fingerprintWalletLockUI) {
        fingerprintWalletLockUI.dismissDialog();
        ah.A(new Runnable() {
            public final void run() {
                a.bRs();
                a.PG(FingerprintWalletLockUI.this.pGQ);
                a.fy(-1);
                com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.pIt;
                com.tencent.mm.plugin.walletlock.b.g.bRZ();
            }
        });
        Toast.makeText(fingerprintWalletLockUI, g.wallet_lock_fingerprint_open_success, 0).show();
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.walletlock.a.b.class)).zw(2);
        com.tencent.mm.plugin.walletlock.b.i.pIx.bSh();
        fingerprintWalletLockUI.aO(0, "open fingerprint lock ok");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
        Intent intent = getIntent();
        this.sS = intent.getStringExtra("action");
        this.pGM = this.sS;
        this.pGL = intent.getStringExtra("next_action");
        this.eIe = intent.getStringExtra("token");
        this.eWo = intent.getStringExtra("key_pay_passwd");
        this.pGS = intent.getIntExtra("scene", -1);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[]{this.sS, this.pGL});
        if (this.sS.equals("action.verify_pattern")) {
            this.pGR = 2;
            com.tencent.mm.plugin.walletlock.b.h.bSe();
        } else if (this.sS.equals("action.switch_on_pattern")) {
            this.pGR = 1;
        }
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[]{Boolean.valueOf(this.lnh)});
        if (this.lnh) {
            this.pGN = new com.tencent.mm.plugin.walletlock.fingerprint.a.c();
            this.pGO = new h();
            this.mcv = false;
            f.cFZ().cGa();
            this.kjo = com.tencent.mm.ui.base.h.a(this, getString(g.app_waiting), false, null);
            bRx();
            if (this.sS.equals("action.switch_on_pattern")) {
                this.pGC = false;
            } else {
                this.pGC = true;
            }
            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.pGC)});
            com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.pIt;
            boolean bSa = com.tencent.mm.plugin.walletlock.b.g.bSa();
            com.tencent.mm.plugin.walletlock.b.g gVar2 = com.tencent.mm.plugin.walletlock.b.g.pIt;
            if (com.tencent.mm.plugin.walletlock.b.g.bRt() && !bSa) {
                x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[]{Boolean.valueOf(bSa)});
                if (e.bRE()) {
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
                    ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.walletlock.a.b.class)).zw(1);
                    gVar = com.tencent.mm.plugin.walletlock.b.g.pIt;
                    com.tencent.mm.plugin.walletlock.b.g.bRZ();
                    finish();
                    Intent intent = new Intent(this, GestureGuardLogicUI.class);
                    intent.addFlags(131072);
                    intent.putExtra("action", "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
                    intent.setPackage(ad.getPackageName());
                    if (!com.tencent.mm.kernel.g.Ei().DT().getBoolean(aa.a.sYF, false)) {
                        intent.putExtra("verify_title", getString(g.wallet_lock_verify_by_gesture_when_not_support_fingerprint));
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sYF, Boolean.valueOf(true));
                        com.tencent.mm.kernel.g.Ei().DT().lm(true);
                    }
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[]{Boolean.valueOf(r1)});
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(12097, new Object[]{Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                } else {
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
                    bNd();
                    this.kjn = new c$a(this).Gr(g.wallet_lock_not_support_fingerprint).Gt(g.wallet_lock_set_gesture).a(new 13(this)).e(new 12(this)).anj();
                    this.kjn.setCanceledOnTouchOutside(false);
                    this.kjn.b(getString(g.wallet_lock_close), false, new 14(this));
                    this.kjn.show();
                }
            } else if (com.tencent.d.a.a.hz(this)) {
                Bundle bundle = new Bundle();
                bundle.putString("key_pay_passwd", this.eWo);
                bundle.putBoolean("key_fp_lock_offline_mode", this.pGC);
                this.pGN.a(new 8(this), bundle);
            } else {
                bRy();
            }
            x.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        }
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
        dismissDialog();
        release();
        this.lnh = true;
    }

    protected final void initView() {
        super.initView();
        this.pGI = (TextView) findViewById(com.tencent.mm.plugin.walletlock.a.d.fingerprint_tips);
        this.pGJ = (TextView) findViewById(com.tencent.mm.plugin.walletlock.a.d.pay_pwd_verify);
        this.gVv = (TextView) findViewById(com.tencent.mm.plugin.walletlock.a.d.fingerprint_lock_close_btn);
        this.pGJ.setOnClickListener(new 1(this));
        this.gVv.setOnClickListener(new 7(this));
    }

    private void bRx() {
        if (this.sS.equals("action.verify_pattern")) {
            this.pGI.setText(g.wallet_lock_fingerprint_verify_tips);
            this.pGI.setTextColor(getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.normal_text_color));
            this.pGJ.setVisibility(0);
            return;
        }
        this.pGI.setText(g.wallet_lock_fingerprint_open_tips);
        this.pGI.setTextColor(getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.normal_text_color));
        this.pGJ.setVisibility(8);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.walletlock.a.e.fingerprint_wallet_lock_ui;
    }

    private void bRy() {
        bNd();
        c$a c_a = new c$a(this);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[]{Integer.valueOf(this.pGR)});
        if (this.pGR == 2) {
            c_a.Gr(g.wallet_lock_no_fingerprint_when_offline_verify).Gt(g.wallet_lock_set_again).a(new 10(this)).Gu(g.app_cancel).b(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
                }
            });
        } else {
            c_a.Gr(g.wallet_lock_no_fingerprint_tips).abx(getString(g.app_ok)).a(new 11(this));
        }
        this.kjn = c_a.anj();
        this.kjn.setCanceledOnTouchOutside(false);
        this.kjn.show();
    }

    private void dismissDialog() {
        bNd();
        if (this.kjn != null && this.kjn.isShowing()) {
            this.kjn.dismiss();
        }
    }

    public void onBackPressed() {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
        finish();
        com.tencent.mm.plugin.walletlock.b.i.pIx.bSi();
    }

    private void bRz() {
        x.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[]{this.pGM});
        if (bi.oW(this.pGM)) {
            finish();
            return;
        }
        String str = this.pGM;
        boolean z = true;
        switch (str.hashCode()) {
            case -1423990800:
                if (str.equals("next_action.goto_protected_page")) {
                    z = true;
                    break;
                }
                break;
            case -1305462654:
                if (str.equals("action.verify_pattern")) {
                    z = true;
                    break;
                }
                break;
            case -639789777:
                if (str.equals("next_action.switch_on_pattern")) {
                    z = true;
                    break;
                }
                break;
            case 1420518755:
                if (str.equals("action.switch_on_pattern")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
                this.pGP = new a(this, this);
                this.pGQ = "-1";
                if (this.pGO == null) {
                    this.pGO = new h();
                }
                h hVar = this.pGO;
                b bVar = this.pGP;
                1 1 = new 1(hVar, bVar);
                hVar.jgQ = new com.tencent.d.b.c.a();
                com.tencent.d.b.f.b bVar2 = new com.tencent.d.b.f.b.a().hK(this).a(hVar.jgQ).acG(com.tencent.mm.plugin.walletlock.b.g.pIt.pIu).Hq(3).a(1).vml;
                com.tencent.mm.plugin.walletlock.b.g.pIt.pIv = null;
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
                com.tencent.d.b.a.a(new 2(hVar, bVar), bVar2);
                return;
            case true:
                i iVar = com.tencent.mm.plugin.walletlock.b.g.pIt.pIv;
                if (iVar == null) {
                    tn(getString(g.wallet_lock_fingerprint_system_error));
                    return;
                }
                String str2 = iVar.vlM;
                String str3 = iVar.signature;
                if (this.pGN != null) {
                    this.kjo = com.tencent.mm.ui.base.h.a(this, getString(g.wallet_lock_fingerprint_verifying), false, null);
                    this.pGN.a(new 5(this), this.eIe, str2, str3);
                    return;
                }
                return;
            case true:
                a.fy(SystemClock.elapsedRealtime());
                bRA();
                return;
            default:
                return;
        }
    }

    private void bRA() {
        this.lnh = false;
        ah.i(new 2(this), 200);
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
            com.tencent.mm.plugin.walletlock.b.i.pIx.jM(true);
            com.tencent.mm.plugin.walletlock.b.i.pIx.jN(true);
            intent.addFlags(131072);
            startActivity(intent);
            overridePendingTransition(com.tencent.mm.plugin.walletlock.a.a.slide_left_in, com.tencent.mm.plugin.walletlock.a.a.slide_right_out);
            return;
        }
        x.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    }

    private void zx(int i) {
        Intent intent = new Intent();
        if (i == 1) {
            intent.putExtra("action", "action.touchlock_verify_by_paypwd");
        } else if (i == 2) {
            intent.putExtra("action", "action.touchlock_need_verify_paypwd");
            intent.putExtra("key_wallet_lock_input_new_fp_tips", getString(g.wallet_lock_new_fingerprint_need_verify_paypwd_tips));
        }
        intent.putExtra("key_wallet_lock_type", 2);
        com.tencent.mm.bg.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i);
    }

    private void bNd() {
        if (this.kjo != null && this.kjo.isShowing()) {
            this.kjo.dismiss();
        }
    }

    private void zK(String str) {
        if (bi.oW(str)) {
            str = getString(g.wallet_lock_fingerprint_verify_system_error);
        }
        dismissDialog();
        this.kjn = com.tencent.mm.ui.base.h.a(this, str, "", new 3(this));
        this.kjn.setCanceledOnTouchOutside(false);
    }

    private void tn(String str) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - this.jhh > 1) {
            this.jhh = currentTimeMillis;
            dismissDialog();
            if (this.pGI != null) {
                this.pGI.setText(str);
                this.pGI.setTextColor(getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.red));
                this.pGI.setVisibility(4);
                if (this.pGK == null) {
                    this.pGK = AnimationUtils.loadAnimation(this.mController.tml, com.tencent.mm.plugin.walletlock.a.a.fingerprint_tips_anim);
                }
                this.pGI.startAnimation(this.pGK);
                ah.i(new 4(this), this.pGK.getDuration());
            }
        }
    }

    private void release() {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", new Object[]{Boolean.valueOf(this.mcv)});
        if (!this.mcv) {
            this.mcv = true;
            if (this.pGO != null) {
                h hVar = this.pGO;
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo release fingerprint auth");
                if (hVar.jgQ != null) {
                    hVar.jgQ.mR(true);
                }
            }
            if (this.pGN != null) {
                this.pGN.release();
            }
            f.cFZ().cGa();
        }
    }

    private void aO(int i, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(-1), Integer.valueOf(i), str});
        release();
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        intent.putExtra("key_err_msg", str);
        setResult(-1, intent);
        finish();
    }

    public void finish() {
        super.finish();
        release();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (intent == null) {
            x.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", new Object[]{Integer.valueOf(intExtra)});
        if (i == 1) {
            if (intExtra == 0) {
                bRA();
                com.tencent.mm.plugin.walletlock.b.h.bSc();
            } else if (intExtra == -1) {
                this.lnh = false;
                zK(getString(g.wallet_lock_verify_by_pay_pwd_error));
            }
        } else if (i == 2) {
            if (intExtra == 0) {
                a.PG(this.pGQ);
                a.fy(SystemClock.elapsedRealtime());
                bRA();
            } else if (intExtra == -1) {
                this.lnh = false;
                zK(getString(g.wallet_lock_verify_by_pay_pwd_error));
            }
        } else if (i == 3) {
            if (intExtra == 0) {
                bRA();
                return;
            }
            finish();
            com.tencent.mm.plugin.walletlock.b.i.pIx.bSi();
        } else if (i == 4) {
            if (intExtra == 0) {
                bRA();
            } else if (intExtra == -1) {
                this.lnh = false;
                zK(getString(g.wallet_lock_gesture_open_failed));
            } else {
                finish();
                com.tencent.mm.plugin.walletlock.b.i.pIx.bSi();
            }
        } else if (i != 5) {
        } else {
            if (intExtra == 0) {
                ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.walletlock.a.b.class)).zw(0);
                com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.pIt;
                com.tencent.mm.plugin.walletlock.b.g.bRv();
                Toast.makeText(this, getString(g.wallet_lock_close_all_success), 0).show();
                bRA();
            } else if (intExtra == -1) {
                this.lnh = false;
                zK(getString(g.wallet_lock_close_error));
            } else if (intExtra == 4) {
                finish();
                com.tencent.mm.plugin.walletlock.b.i.pIx.bSi();
            }
        }
    }
}
