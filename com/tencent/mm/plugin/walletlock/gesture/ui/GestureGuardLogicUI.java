package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.b.i;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.a.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.axe;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.protocal.c.bga;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c;
import java.util.List;

@a(19)
public class GestureGuardLogicUI extends MMActivity implements OnClickListener, PatternLockView.a {
    private String eIe = null;
    private int jGg = 0;
    private ag mHandler = new ag(Looper.getMainLooper());
    private int mStatus;
    private int pGS = -1;
    private int pHb = 0;
    private int pHc = 0;
    private a[] pHd = null;
    private Animation pHe = null;
    private List<f> pHf = null;
    private List<f> pHg = null;
    private boolean pHh = false;
    private int pHi = 0;
    private l pHj = null;
    private l pHk = null;
    private String pHl = null;
    private ViewFlipper pHm = null;
    private Dialog pHn = null;
    private boolean pHo = true;
    private boolean pHp = false;
    private String pHq;

    static /* synthetic */ void bRS() {
        z.a(q.GF(), 9, "PatternLockUpdate", "");
        h.mEJ.h(11473, new Object[0]);
    }

    static /* synthetic */ int k(GestureGuardLogicUI gestureGuardLogicUI) {
        int i = gestureGuardLogicUI.pHi + 1;
        gestureGuardLogicUI.pHi = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!ad.getPackageName().equals(intent.getPackage()) || bi.oW(intent.getStringExtra("action")) || bi.oW(intent.getStringExtra("next_action"))) {
            x.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
            finish();
            return;
        }
        this.pHm = new ViewFlipper(this);
        this.pHd = new a[]{new a(this), new a(this), new a(this)};
        a[] aVarArr = this.pHd;
        int length = aVarArr.length;
        while (i < length) {
            a aVar = aVarArr[i];
            this.pHm.addView(aVar.mView);
            aVar.pHz.setOnPatternListener(this);
            aVar.pHA.setOnClickListener(this);
            i++;
        }
        setContentView(this.pHm);
        this.eIe = getIntent().getStringExtra("token");
        this.pHl = getIntent().getStringExtra("type");
        this.pHq = getIntent().getStringExtra("verify_title");
        this.pGS = getIntent().getIntExtra("scene", -1);
        if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            com.tencent.mm.plugin.walletlock.b.h.bSe();
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.mStatus == 0) {
            int i;
            g bRI = d.bRI();
            if (bRI.pGZ != -1) {
                e.a(bRI);
                if (bRI.pHa / 1000 < 600) {
                    d.I(bRI.pGZ, bRI.pHa);
                    i = 1;
                    if (i != 0) {
                        this.pHi = d.bRM();
                        if (this.pHi != -1) {
                            return;
                        }
                    }
                    this.pHi = 0;
                }
                d.bRJ();
            }
            i = 0;
            if (i != 0) {
                this.pHi = d.bRM();
                if (this.pHi != -1) {
                    return;
                }
            }
            this.pHi = 0;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.pHj != null) {
            com.tencent.mm.kernel.g.DF().c(this.pHj);
            this.pHj = null;
        }
        if (this.pHk != null) {
            com.tencent.mm.kernel.g.DF().c(this.pHk);
            this.pHk = null;
        }
        if (this.pHn != null && this.pHn.isShowing()) {
            this.pHn.dismiss();
        }
        if (this.pHm != null) {
            this.pHm.removeAllViews();
            this.pHm = null;
        }
        for (int i = 0; i < this.pHd.length; i++) {
            a aVar = this.pHd[i];
            aVar.pHz.setOnClickListener(null);
            aVar.pHA.setOnClickListener(null);
            aVar.mView = null;
            aVar.pHx = null;
            aVar.pHy = null;
            aVar.pHz = null;
            aVar.pHA = null;
            this.pHd[i] = null;
        }
        this.pHd = null;
    }

    protected final void initView() {
        YC();
        setMMSubTitle(com.tencent.mm.plugin.walletlock.a.g.wechat_authenticate_safely);
        this.pHe = AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.walletlock.a.a.shake_object_animate);
        this.pHb = getResources().getColor(b.gesture_color_tip_norm_text);
        this.pHc = getResources().getColor(b.gesture_color_tip_wrong_text);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("action");
        intent.getStringExtra("next_action");
        if ("action.switch_on_pattern".equals(stringExtra)) {
            this.mStatus = 16;
            X(1, false);
        } else if ("action.verify_pattern".equals(stringExtra)) {
            if (com.tencent.mm.plugin.walletlock.gesture.a.b.bRF()) {
                this.pHh = true;
                this.mStatus = 20;
            } else {
                this.pHh = false;
                this.mStatus = 0;
            }
            X(0, false);
        }
        setBackBtn(new 1(this));
        x.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[]{Integer.valueOf(this.mStatus)}));
        bRP();
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (intent == null) {
            x.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", 0);
        if (intExtra == 0) {
            this.eIe = intent.getStringExtra("key_token");
            this.pHl = intent.getStringExtra("key_type");
            String stringExtra = getIntent().getStringExtra("next_action");
            if ("next_action.goto_protected_page".equals(stringExtra) || "next_action.modify_pattern".equals(stringExtra)) {
                if ("next_action.modify_pattern".equals(stringExtra)) {
                    this.pHp = true;
                }
                this.pHo = false;
                setBackBtn(null);
                lD(false);
                this.mStatus = 16;
                X(1, false);
            } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                String str = this.eIe;
                AnonymousClass12 anonymousClass12 = new v.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.ab.b bVar, l lVar) {
                        if (i2 == 0) {
                            d.bRN();
                            d.bRH();
                            d.bRJ();
                            Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_toast_disabled), 0).show();
                        } else {
                            Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_err_runtime), 0).show();
                        }
                        GestureGuardLogicUI.this.eIe = null;
                        GestureGuardLogicUI.this.pHl = null;
                        GestureGuardLogicUI.this.finish();
                        return 0;
                    }
                };
                b(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        GestureGuardLogicUI.this.pHd[GestureGuardLogicUI.this.jGg].pHz.bRV();
                        if (GestureGuardLogicUI.this.pHj != null && !GestureGuardLogicUI.this.pHj.aBS) {
                            com.tencent.mm.kernel.g.DF().c(GestureGuardLogicUI.this.pHj);
                        }
                    }
                });
                if (str == null) {
                    bNd();
                    anonymousClass12.a(3, -6, getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_err_token_not_exists), null, null);
                } else {
                    com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
                    aVar.dIG = new bfz();
                    aVar.dIH = new bga();
                    aVar.dIF = 688;
                    aVar.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
                    com.tencent.mm.ab.b KT = aVar.KT();
                    bfz bfz = (bfz) KT.dID.dIL;
                    bfz.she = new bhy().bq(str.getBytes());
                    bfz.nc = 3;
                    v.a(KT, new 14(this, anonymousClass12), false);
                }
            } else {
                this.mStatus = 1;
            }
            bRP();
        } else if (intExtra == -1) {
            Toast.makeText(this, getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_err_runtime), 0).show();
        }
    }

    public void onClick(View view) {
        if (view.getId() == com.tencent.mm.plugin.walletlock.a.d.tv_forgotpwd) {
            Intent intent = new Intent();
            intent.putExtra("action", "action.verify_paypwd");
            intent.putExtra("key_wallet_lock_type", 1);
            com.tencent.mm.bg.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, 1001);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (bRO()) {
            return false;
        }
        p(0, 4, "user cancel when setting gesture");
        return false;
    }

    private void p(int i, int i2, String str) {
        x.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        setResult(i, intent);
        finish();
    }

    private boolean bRO() {
        if (this.mStatus == 20 || this.mStatus == 0 || this.mStatus == 2 || this.mStatus == 1) {
            bRR();
            return false;
        }
        if (this.pHo) {
            String stringExtra = getIntent().getStringExtra("next_action");
            stringExtra = ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) ? getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_dlg_tip_is_break_modify_proc) : getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_dlg_tip_is_break_open_proc);
            new c.a(this).mF(false).abu(stringExtra).Gt(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_dlg_btn_yes).a(new 20(this)).Gu(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_dlg_btn_no).b(new 19(this)).anj().show();
        } else {
            new c.a(this).mF(true).Gr(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_dlg_tip_please_set_a_pwd).Gt(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_dlg_btn_ok).a(new 18(this)).anj().show();
        }
        return true;
    }

    private void bRP() {
        while (true) {
            final a aVar = this.pHd[this.jGg];
            String stringExtra;
            List list;
            com.tencent.mm.ab.b.a aVar2;
            axd axd;
            long elapsedRealtime;
            switch (this.mStatus) {
                case 0:
                    setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_title_input_pattern));
                    this.pHh = false;
                    aVar.pHz.setEnableInput(true);
                    aVar.pHz.setOnPatternListener(this);
                    if (!"next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        aVar.pHx.setText(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_tip_input_orig_pattern));
                    } else if (bi.oW(this.pHq)) {
                        aVar.pHx.setText(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_tip_input_pattern));
                    } else {
                        aVar.pHx.setText(this.pHq);
                    }
                    aVar.pHx.setTextColor(this.pHb);
                    if (aVar.pHA.getVisibility() != 0) {
                        aVar.pHA.setVisibility(0);
                        return;
                    }
                    return;
                case 1:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        aVar.pHz.bRV();
                        X(1, true);
                        this.mStatus = 16;
                    } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                        list = this.pHg;
                        26 26 = new 26(this);
                        b(new 10(this));
                        aVar2 = new com.tencent.mm.ab.b.a();
                        aVar2.dIG = new axd();
                        aVar2.dIH = new axe();
                        aVar2.dIF = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.ab.b KT = aVar2.KT();
                        axd = (axd) KT.dID.dIL;
                        axd.nc = 3;
                        axd.sam = new bhy().bq(e.cJ(list));
                        v.a(KT, new 11(this, 26), false);
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra)) {
                        d.fy(SystemClock.elapsedRealtime());
                        bRQ();
                        com.tencent.mm.plugin.walletlock.b.h.Z(this.pGS, 1, 0);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    d.I(elapsedRealtime, 0);
                    d.zy(this.pHi);
                    d.bRv();
                    if (this.pHi == 5) {
                        this.pHh = true;
                        d.H(elapsedRealtime, 0);
                        aVar.pHz.bRV();
                        aVar.pHz.setEnableInput(false);
                        this.mStatus = 20;
                        bRP();
                        c.a aVar3 = new c.a(this);
                        aVar3.mF(false).abu(String.format(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_dlg_fmt_tries_too_much), new Object[]{Long.valueOf(10)}));
                        aVar3.Gt(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_dlg_btn_forgot).a(new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.this.pHd[GestureGuardLogicUI.this.jGg].pHA);
                            }
                        });
                        aVar3.Gu(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_dlg_btn_cancel).b(new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                GestureGuardLogicUI.this.bRR();
                                GestureGuardLogicUI.this.finish();
                            }
                        });
                        aVar3.anj().show();
                    } else {
                        aVar.pHz.setEnableInput(false);
                        aVar.pHz.setDisplayMode(PatternLockView.b.pIe);
                        a(String.format(getResources().getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_fmt_input_pattern_wrong), new Object[]{Integer.valueOf(5 - this.pHi)}), new a() {
                            public final void onDone() {
                                GestureGuardLogicUI.this.mStatus = 0;
                                aVar.pHz.bRV();
                                aVar.pHz.setEnableInput(true);
                            }
                        });
                    }
                    x.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[]{getIntent().getStringExtra("next_action")});
                    if (!"next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        return;
                    }
                    if (this.pHi == 5) {
                        com.tencent.mm.plugin.walletlock.b.h.Z(this.pGS, 1, 2);
                        return;
                    } else {
                        com.tencent.mm.plugin.walletlock.b.h.Z(this.pGS, 1, 1);
                        return;
                    }
                case 16:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) {
                        setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_title_modify_pattern));
                    } else {
                        setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_title_switch_on_pattern));
                    }
                    this.pHh = false;
                    aVar.pHz.setEnableInput(true);
                    aVar.pHz.setOnPatternListener(this);
                    aVar.pHx.setText(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_tip_input_new_pattern));
                    aVar.pHx.setTextColor(getResources().getColor(b.gesture_color_tip_norm_text));
                    if (aVar.pHA.getVisibility() != 8) {
                        aVar.pHA.setVisibility(8);
                        return;
                    }
                    return;
                case 17:
                    aVar.pHx.setText(getResources().getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_tip_input_again));
                    aVar.pHx.setTextColor(this.pHb);
                    aVar.pHz.bRV();
                    aVar.pHz.setEnableInput(true);
                    if (aVar.pHA.getVisibility() != 8) {
                        aVar.pHA.setVisibility(8);
                        return;
                    }
                    return;
                case 18:
                    String stringExtra2 = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra2)) {
                        if (this.pHp) {
                            this.pHp = false;
                            a(this.eIe, this.pHf, new 21(this));
                            return;
                        }
                        list = this.pHg;
                        List list2 = this.pHf;
                        22 22 = new 22(this);
                        aVar2 = new com.tencent.mm.ab.b.a();
                        b(new 8(this));
                        aVar2.dIG = new axd();
                        aVar2.dIH = new axe();
                        aVar2.dIF = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.ab.b KT2 = aVar2.KT();
                        axd = (axd) KT2.dID.dIL;
                        axd.nc = 1;
                        axd.sam = new bhy().bq(e.cJ(list));
                        axd.san = new bhy().bq(e.cJ(list2));
                        v.a(KT2, new 9(this, 22), false);
                        return;
                    } else if ("next_action.switch_on_pattern".equals(stringExtra2)) {
                        a(this.eIe, this.pHf, new 23(this));
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra2)) {
                        a(this.eIe, this.pHf, new 24(this));
                        return;
                    } else {
                        return;
                    }
                case 19:
                    aVar.pHz.setEnableInput(false);
                    aVar.pHz.setDisplayMode(PatternLockView.b.pIe);
                    a(getResources().getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_tip_input_mismatch), new 25(this, aVar));
                    return;
                case 20:
                    setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_title_input_pattern));
                    this.pHh = true;
                    aVar.pHz.setEnableInput(false);
                    aVar.pHz.setOnPatternListener(null);
                    elapsedRealtime = (long) Math.ceil(((double) (600 - (d.bRG().pHa / 1000))) / 60.0d);
                    aVar.pHx.setText(String.format(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_tip_fmt_tries_too_much), new Object[]{Long.valueOf(elapsedRealtime)}));
                    aVar.pHx.setTextColor(getResources().getColor(b.gesture_color_tip_wrong_text));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(PatternLockView patternLockView, List<f> list) {
        boolean z = true;
        if (this.mStatus == 16) {
            if (list.size() < 4) {
                patternLockView.setEnableInput(false);
                patternLockView.setDisplayMode(PatternLockView.b.pIe);
                a(String.format(getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_fmt_pattern_too_short), new Object[]{Integer.valueOf(4)}), new 2(this, patternLockView));
                return;
            }
            this.pHf = list;
            patternLockView.bRV();
            this.mStatus = 17;
            X(2, true);
        } else if (this.mStatus == 0) {
            3 3 = new 3(this, list);
            ayz bRL = d.bRL();
            ayy bRK = d.bRK();
            h.mEJ.h(11453, new Object[0]);
            b(new 6(this));
            boolean z2 = e.b(bRK) ? e.b(bRL) ? bRK.version < bRL.sbK : false : true;
            x.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[]{Boolean.valueOf(e.b(bRL)), Boolean.valueOf(e.b(bRK)), Boolean.valueOf(z2)}));
            if (z2) {
                com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
                aVar.dIG = new axd();
                aVar.dIH = new axe();
                aVar.dIF = 689;
                aVar.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                com.tencent.mm.ab.b KT = aVar.KT();
                axd axd = (axd) KT.dID.dIL;
                axd.nc = 2;
                axd.sam = new bhy().bq(e.cJ(list));
                v.a(KT, new 7(this, 3), false);
                return;
            }
            bNd();
            ayy bRK2 = d.bRK();
            if (bRK2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.Eg();
                stringBuilder.append(new o(com.tencent.mm.kernel.a.Df()).longValue());
                stringBuilder.append('_');
                stringBuilder.append(new String(e.cJ(list)));
                z = new String(bRK2.sbH.siK.lR).equals(com.tencent.mm.a.g.u(stringBuilder.toString().getBytes()));
            }
            if (z) {
                3.a(3, 0, null, null, null);
                return;
            } else {
                3.a(3, -3, null, null, null);
                return;
            }
        } else if (this.mStatus != 17) {
            return;
        } else {
            if (this.pHf.equals(list)) {
                patternLockView.bRV();
                this.pHh = false;
                this.pHi = 0;
                d.bRN();
                d.bRH();
                d.bRJ();
                d.bRv();
                this.mStatus = 18;
            } else {
                this.mStatus = 19;
            }
        }
        bRP();
    }

    private void a(String str, List<f> list, v.a aVar) {
        b(new 4(this));
        if (str == null) {
            bNd();
            aVar.a(3, -6, getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_err_token_not_exists), null, null);
            return;
        }
        com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
        aVar2.dIG = new bfz();
        aVar2.dIH = new bga();
        aVar2.dIF = 688;
        aVar2.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
        com.tencent.mm.ab.b KT = aVar2.KT();
        bfz bfz = (bfz) KT.dID.dIL;
        bfz.she = new bhy().bq(str.getBytes());
        bfz.shf = new bhy().bq(e.cJ(list));
        v.a(KT, new 5(this, aVar), false);
    }

    private void bRQ() {
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            i.pIx.jM(true);
            i.pIx.jN(true);
            intent.addFlags(131072);
            startActivity(intent);
        } else {
            x.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
        }
        finish();
    }

    private void bRR() {
        String stringExtra = getIntent().getStringExtra("next_action");
        if (this.mStatus == 20 || "next_action.goto_protected_page".equals(stringExtra)) {
            i.pIx.bSi();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        a aVar = this.pHd[this.jGg];
        if (aVar.pHz != null) {
            PatternLockView patternLockView = aVar.pHz;
            boolean z2 = z && !this.pHh;
            patternLockView.setEnableInput(z2);
        }
    }

    public final void a(PatternLockView patternLockView) {
        patternLockView.setDisplayMode(PatternLockView.b.pId);
    }

    private void X(int i, boolean z) {
        int i2 = i - this.jGg;
        if (i2 != 0) {
            this.jGg = i;
            if (!z) {
                this.pHm.setInAnimation(null);
                this.pHm.setOutAnimation(null);
            } else if (i2 > 0) {
                this.pHm.setInAnimation(this, com.tencent.mm.plugin.walletlock.a.a.slide_right_in);
                this.pHm.setOutAnimation(this, com.tencent.mm.plugin.walletlock.a.a.slide_left_out);
            } else {
                this.pHm.setInAnimation(this, com.tencent.mm.plugin.walletlock.a.a.slide_left_in);
                this.pHm.setOutAnimation(this, com.tencent.mm.plugin.walletlock.a.a.slide_right_out);
            }
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.pHm.showNext();
                }
                return;
            }
            while (i2 < 0) {
                this.pHm.showPrevious();
                i2++;
            }
        }
    }

    private void a(String str, a aVar) {
        TextView textView = this.pHd[this.jGg].pHx;
        textView.getText().toString();
        textView.setText(str);
        textView.setTextColor(this.pHc);
        textView.startAnimation(this.pHe);
        this.pHe.setAnimationListener(new 15(this, aVar));
    }

    private void b(OnCancelListener onCancelListener) {
        if (this.pHn == null) {
            this.pHn = com.tencent.mm.ui.base.h.a(this, getString(com.tencent.mm.plugin.walletlock.a.g.gesture_pwd_msg_loading), false, onCancelListener);
        } else {
            this.pHn.show();
        }
    }

    private void bNd() {
        if (this.pHn != null && this.pHn.isShowing()) {
            this.pHn.dismiss();
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
