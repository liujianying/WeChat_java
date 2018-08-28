package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(19)
public class WalletVerifyCodeUI extends WalletBaseUI implements WalletFormView.a {
    private Button eUb;
    private com.tencent.mm.plugin.ai.a fKa = null;
    private Orders mCZ;
    private PayInfo mCn;
    private Authen pdF;
    private int pyH = 60000;
    protected WalletFormView pyI = null;
    private Button pyJ;
    private String pyK;
    private String pyL;
    private boolean pyM = false;
    private a pyN = null;
    private TextView pyO;
    private boolean pyP = false;
    private boolean pyQ = true;
    private h pyR = new h();
    private g.a pyS = new 2(this);

    static /* synthetic */ boolean a(WalletVerifyCodeUI walletVerifyCodeUI, g.a aVar) {
        if (walletVerifyCodeUI.pyP) {
            x.i("MicroMsg.WalletVertifyCodeUI", "isCertInstalled passed");
            return false;
        } else if (walletVerifyCodeUI.pyR.bOD()) {
            x.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall %s", new Object[]{aVar});
            if (bi.oW(walletVerifyCodeUI.pyI.getText())) {
                x.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall sms error %s", new Object[]{aVar});
                return false;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyCodeUI.a(new g(walletVerifyCodeUI.pyI.getText(), walletVerifyCodeUI.bNs(), aVar, true), true, true);
            return true;
        } else if (walletVerifyCodeUI.pyR.bOC()) {
            x.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isNeedInstall %s", new Object[]{aVar});
            com.tencent.mm.plugin.report.service.h.mEJ.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyCodeUI.a(new g(walletVerifyCodeUI.pyI.getText(), walletVerifyCodeUI.bNs(), aVar, false), true, true);
            return true;
        } else {
            x.i("MicroMsg.WalletVertifyCodeUI", "no need installcert");
            return false;
        }
    }

    static /* synthetic */ void e(WalletVerifyCodeUI walletVerifyCodeUI) {
        if (walletVerifyCodeUI.pyL == null) {
            walletVerifyCodeUI.pyL = "";
        }
        CharSequence format = String.format(q.GS() ? walletVerifyCodeUI.getString(i.wallet_verify_code_get_failed_reason_payu) : walletVerifyCodeUI.getString(i.wallet_verify_code_get_failed_reason), new Object[]{walletVerifyCodeUI.pyL});
        LayoutInflater layoutInflater = (LayoutInflater) walletVerifyCodeUI.mController.tml.getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(com.tencent.mm.plugin.wxpay.a.g.illustraction_dialog_msg_tv, null);
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(d.LargePadding);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setText(format);
        com.tencent.mm.ui.base.h.a(walletVerifyCodeUI.mController.tml, walletVerifyCodeUI.getString(i.wallet_verify_code_get_failed_title), walletVerifyCodeUI.getString(i.wallet_i_know_it), textView, new 4(walletVerifyCodeUI));
    }

    public void onCreate(Bundle bundle) {
        int i = 2;
        super.onCreate(bundle);
        setMMTitle(i.wallet_verify_phone);
        this.mCn = (PayInfo) this.sy.getParcelable("key_pay_info");
        this.mCZ = (Orders) this.sy.getParcelable("key_orders");
        this.pyL = this.sy.getString("key_bank_phone");
        this.fKa = new com.tencent.mm.plugin.ai.a(this);
        this.fKa.eNC = getResources().getStringArray(b.wallet_sms_content);
        this.fKa.ngW = new 1(this);
        this.fKa.start();
        this.pyR = new h(this.sy);
        this.pyM = false;
        initView();
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
        Object[] objArr = new Object[2];
        int i2 = (this.mCn == null || this.mCn.bVY == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.pyM) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hVar.h(10706, objArr);
        c.bQW();
        c.b(this, this.sy, 4);
        if (this.pyR.bOB()) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(13731, new Object[]{Integer.valueOf(5)});
            if (!bi.oW(this.pyR.pmX.title)) {
                setMMTitle(this.pyR.pmX.title);
            }
            findViewById(f.cert_tip_ll).setVisibility(8);
            ((TextView) findViewById(f.cert_tip_state)).setText(this.pyR.pmX.uWW);
            if (this.pyO != null) {
                String bQD = bQD();
                this.pyO.setText(bi.q(this.pyR.pmX.uWX, new Object[]{bQD}));
                this.pyO.setGravity(1);
            }
            if (!(this.eUb == null || bi.oW(this.pyR.pmX.uWY))) {
                this.eUb.setText(this.pyR.pmX.uWY);
            }
        } else {
            findViewById(f.cert_tip_ll).setVisibility(8);
        }
        this.uYO.jr(1580);
    }

    protected final String bQD() {
        String aG = bi.aG(this.sy.getString("key_mobile"), "");
        if (bi.oW(aG)) {
            Bankcard bankcard = (Bankcard) this.sy.getParcelable("key_bankcard");
            if (bankcard != null) {
                return bankcard.field_mobile;
            }
        }
        return aG;
    }

    protected final void bQE() {
        int i = 2;
        x.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
        Object[] objArr = new Object[2];
        int i2 = (this.mCn == null || this.mCn.bVY == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.pyM) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hVar.h(10706, objArr);
        this.pyM = true;
        this.pyJ.setClickable(false);
        this.pyJ.setEnabled(false);
        if (this.pyN != null) {
            this.pyN.cancel();
            this.pyN = null;
        }
        a aVar = new a(this, (long) this.pyH);
        this.pyN = aVar;
        aVar.start();
        if (this.fKa != null) {
            this.fKa.start();
        }
        if (!cDL().s(new Object[]{this.pyK}) && !mM(false)) {
            this.pdF = (Authen) this.sy.getParcelable("key_authen");
            if (this.pdF == null) {
                x.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
            } else {
                c.bQW();
            }
        }
    }

    protected final void initView() {
        com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
        final Bankcard bankcard = (Bankcard) this.sy.getParcelable("key_bankcard");
        this.pyO = (TextView) findViewById(f.bind_wallet_verify_hint);
        String bQD = bQD();
        if (bi.oW(bQD) && bankcard != null) {
            bQD = bankcard.field_mobile;
            this.sy.putString("key_mobile", bQD);
        }
        CharSequence cDM = cDM();
        if (bi.K(cDM)) {
            String string;
            TextView textView = this.pyO;
            if (q.GS()) {
                string = getString(i.wallet_verify_code_bind_hint_payu);
            } else {
                string = getString(i.wallet_verify_code_bind_hint);
            }
            textView.setText(String.format(string, new Object[]{bQD}));
            this.pyO.setGravity(3);
        } else {
            this.pyO.setText(cDM);
            this.pyO.setGravity(3);
        }
        this.pyI = (WalletFormView) findViewById(f.bind_mcontact_verify_num);
        this.pyI.setOnInputValidChangeListener(this);
        this.pyJ = (Button) findViewById(f.get_verify_btn);
        this.pyJ.setOnClickListener(new 5(this, bankcard));
        this.pyJ.setClickable(false);
        this.pyJ.setEnabled(false);
        if (this.pyN != null) {
            this.pyN.cancel();
            this.pyN = null;
        }
        a aVar = new a(this, (long) this.pyH);
        this.pyN = aVar;
        aVar.start();
        this.eUb = (Button) findViewById(f.bind_mcontact_verify_btn);
        this.eUb.setOnClickListener(new 6(this));
        TextView textView2 = (TextView) findViewById(f.bind_wallet_reset_mobile);
        boolean z = this.sy.getBoolean("key_is_changing_balance_phone_num");
        boolean z2 = this.sy.getBoolean("key_need_show_switch_phone", false);
        if (!z || z2) {
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        PayInfo payInfo = (PayInfo) this.sy.getParcelable("key_pay_info");
        int i;
        if (payInfo != null) {
            i = payInfo.bVY;
        } else {
            i = 0;
        }
        if (z2) {
            textView2.setText(i.wallet_verify_code_get_failed_title);
            textView2.setOnClickListener(new 7(this, bankcard));
        } else if (af == null || !af.cCU() || i == 11 || i == 21) {
            textView2.setText(q.GS() ? getString(i.wallet_verify_code_get_failed_payu) : getString(i.wallet_verify_code_get_failed));
            textView2.setOnClickListener(new 10(this));
        } else if (bankcard.bOs() || bankcard.bOt()) {
            textView2.setText(this.sy.getString("key_verify_tail_wording", getString(i.wallet_verify_code_get_failed_title)));
            textView2.setOnClickListener(new 9(this, bankcard));
        } else {
            textView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.ui.base.h.a(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.getString(i.wallet_pay_reset_info_tips, new Object[]{bankcard.field_desc, bankcard.field_mobile}), "", WalletVerifyCodeUI.this.getString(i.wallet_pay_reset_info), WalletVerifyCodeUI.this.getString(i.app_cancel), new 1(this), null);
                }
            });
        }
        this.pyI.requestFocus();
        addIconOptionMenu(0, e.wallet_qanda_icon, new 11(this));
        setBackBtn(new 12(this));
    }

    protected final void bQF() {
        Bundle bundle = this.sy;
        String string = this.sy.getString("key_pwd1");
        this.pyK = this.pyI.getText();
        p pVar = new p();
        pVar.eJn = string;
        pVar.mpb = this.mCn;
        pVar.pqM = this.pyK;
        pVar.token = bi.aG(this.sy.getString("kreq_token"), "");
        Bankcard bankcard = (Bankcard) bundle.getParcelable("key_bankcard");
        if (bankcard != null) {
            pVar.lMV = bankcard.field_bankcardType;
            pVar.lMW = bankcard.field_bindSerial;
            pVar.plq = bi.aG(bankcard.field_arrive_type, "");
        } else {
            pVar.lMV = this.sy.getString("key_bank_type");
            if (bi.oW(pVar.lMV)) {
                pVar.lMV = this.sy.getString("key_bind_card_type", "");
            }
        }
        x.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + pVar.mpb + " mVerifyCode: " + this.pyK);
        bundle.putString("key_verify_code", this.pyK);
        com.tencent.mm.wallet_core.a.af(this);
        x.i("MicroMsg.WalletVertifyCodeUI", "do verify result : " + cDL().m(new Object[]{this.pyK, pVar}));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + i2 + " errMsg :" + str);
        if (!(lVar instanceof g)) {
            if (i == 0 && i2 == 0) {
                boolean z;
                com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
                if (lVar instanceof y) {
                    this.sy.putBoolean("intent_bind_end", true);
                    com.tencent.mm.ui.base.h.bA(this, getString(i.wallet_bank_card_bind_success_tips));
                    x.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
                    z = true;
                } else {
                    if (!(lVar instanceof m)) {
                        if (af.c(this, null)) {
                            a(new y(bNs(), 13), true, false);
                            x.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
                        } else {
                            z = true;
                        }
                    }
                    z = false;
                }
                if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.q) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(10707, new Object[]{Integer.valueOf(2), Integer.valueOf(c.bQX())});
                }
                if (this.pdF != null && (lVar instanceof com.tencent.mm.wallet_core.tenpay.model.i)) {
                    String blM = ((com.tencent.mm.wallet_core.tenpay.model.i) lVar).blM();
                    if (!bi.oW(blM)) {
                        this.sy.putString("kreq_token", blM);
                    }
                }
                if (z) {
                    x.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
                    com.tencent.mm.wallet_core.a.j(this, this.sy);
                    finish();
                    return true;
                }
            }
            return false;
        } else if (i2 == 0 || !((g) lVar).caB) {
            return true;
        } else {
            com.tencent.mm.ui.base.h.a(this.mController.tml, str, null, false, new 3(this));
            return true;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_verify_code;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.fKa != null) {
            this.fKa.stop();
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void fE(boolean z) {
        if (this.pyI.dX(null)) {
            this.eUb.setEnabled(true);
            this.eUb.setClickable(true);
            return;
        }
        this.eUb.setEnabled(false);
        this.eUb.setClickable(false);
    }

    public void onDestroy() {
        if (this.fKa != null) {
            this.fKa.stop();
        }
        this.uYO.js(1580);
        super.onDestroy();
    }

    protected final boolean bND() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_need_confirm_finish", false);
        if ((this.mCn == null || !this.mCn.jNf) && !booleanExtra) {
            return super.bND();
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.WalletVertifyCodeUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.WalletVertifyCodeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case MapRouteSectionWithName.kMaxRoadNameLength /*128*/:
                if (iArr[0] == 0 && this.fKa != null) {
                    this.fKa.start();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final boolean k(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[]{Integer.valueOf(i2), lVar});
        if ((lVar instanceof g) && i2 == 0) {
            this.pyP = true;
            s.makeText(this, i.wallet_password_setting_digitalcert_install_verify_install_toast, 0).show();
            x.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
        }
        return true;
    }
}
