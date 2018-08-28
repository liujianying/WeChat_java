package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pay.a.b;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.o.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletLoanRepaymentUI extends WalletBaseUI {
    private String desc;
    private String eTo;
    private String lNV = "CNY";
    private double mxP;
    protected o oZD;
    private String pfG;
    private String pfH;
    private String pfI;
    private String pfJ;
    private String pfK;
    private String pfL;
    private String pfM;
    private String pfN;
    private int pfO;
    private String token;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.pfL = intent.getStringExtra("appId");
        this.pfG = intent.getStringExtra("timeStamp");
        this.pfH = intent.getStringExtra("nonceStr");
        this.pfI = intent.getStringExtra("packageExt");
        this.pfJ = intent.getStringExtra("signtype");
        this.pfK = intent.getStringExtra("paySignature");
        this.pfM = intent.getStringExtra("url");
        this.pfO = intent.getIntExtra("pay_channel", 0);
        jr(580);
        a(new com.tencent.mm.plugin.wallet_core.c.a(this.pfL, this.pfG, this.pfH, this.pfI, this.pfJ, this.pfK, this.pfM, 7, "getWebPayCheckoutCounterRequst", this.pfO), true, false);
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return -1;
    }

    private void OR(String str) {
        a(new b(str), true, false);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
                this.token = ((com.tencent.mm.plugin.wallet_core.c.a) lVar).blM();
                OR(this.token);
                return true;
            } else if (lVar instanceof b) {
                b bVar = (b) lVar;
                this.lNV = bVar.lNV;
                this.mxP = bVar.mxP;
                this.desc = bVar.desc;
                ad bOX = com.tencent.mm.plugin.wallet_core.model.o.bOX();
                if (bOX.bPh()) {
                    Bankcard bPi = bOX.bPi();
                    if (bPi == null || !bi.oW(bPi.field_forbidWord)) {
                        bNF();
                    } else {
                        a(bPi, this.mxP, this.lNV);
                    }
                } else {
                    h.a(this, getResources().getString(i.wallet_loan_repayment_new_card_tip), "", getString(i.wallet_pay_bankcard_add), getString(i.app_cancel), new 4(this), new 5(this));
                }
                return true;
            } else if (lVar instanceof s) {
                s sVar = (s) lVar;
                if (sVar.bOk()) {
                    x.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_pwd1", this.eTo);
                    bundle.putString("key_jsapi_token", this.token);
                    bundle.putString("key_relation_key", sVar.pjx);
                    bundle.putInt("key_verify_scene", 8);
                    bundle.putString("key_mobile", sVar.pjw);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.ui.l.class, bundle);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", sVar.pju);
                    intent.putExtra("bind_serial", this.pfN);
                    setResult(-1, intent);
                    finish();
                }
                return true;
            }
        }
        return false;
    }

    private void a(Bankcard bankcard, double d, String str) {
        c 1 = new 1(this);
        OnClickListener 2 = new 2(this);
        OnCancelListener 3 = new 3(this);
        this.pfN = bankcard.field_bindSerial;
        this.oZD = o.a((Context) this, this.desc, d, str, bankcard, 1, 2, 3);
    }

    private void bNF() {
        x.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
        startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    }

    protected final void bNG() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 8);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("kreq_token", this.token);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, bundle, new 6(this));
    }

    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        x.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
        if (extras.containsKey("intent_bind_end")) {
            x.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
            OR(this.token);
        } else if (extras.containsKey("jsapi_verifycode_process_end")) {
            x.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
            Intent intent2 = new Intent();
            intent2.putExtra("token", intent.getStringExtra("token"));
            intent2.putExtra("bind_serial", this.pfN);
            setResult(-1, intent2);
            finish();
        } else {
            x.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Bankcard OZ;
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            int intExtra = intent.getIntExtra("ret", -1000);
            if (intExtra == -1003) {
                x.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
                bNG();
            } else if (intExtra == 0) {
                x.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
                OZ = com.tencent.mm.plugin.wallet_core.model.o.bOX().OZ(intent.getStringExtra("bindSerial"));
                if (OZ == null) {
                    x.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
                    finish();
                    return;
                }
                a(OZ, this.mxP, this.lNV);
            } else {
                x.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
            }
        } else {
            ad bOX = com.tencent.mm.plugin.wallet_core.model.o.bOX();
            if (bOX.bPh()) {
                OZ = bOX.bPi();
                if (OZ == null || !bi.oW(OZ.field_forbidWord)) {
                    finish();
                    return;
                } else {
                    a(OZ, this.mxP, this.lNV);
                    return;
                }
            }
            x.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
