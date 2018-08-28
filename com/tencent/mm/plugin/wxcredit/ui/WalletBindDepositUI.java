package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletBindDepositUI extends WalletBaseUI {
    private Button eUb;
    private boolean jVj = true;
    private ElementQuery pkA = new ElementQuery();
    private WalletFormView psQ;
    private WalletFormView pui;
    private WalletFormView qwL;

    static /* synthetic */ boolean e(WalletBindDepositUI walletBindDepositUI) {
        if (!walletBindDepositUI.psQ.ZF()) {
            s.makeText(walletBindDepositUI, i.wallet_card_err_bankcard_id, 0).show();
            return false;
        } else if (!walletBindDepositUI.pui.ZF()) {
            s.makeText(walletBindDepositUI, i.wallet_card_bankcard_type_tips, 0).show();
            return false;
        } else if (walletBindDepositUI.qwL.ZF()) {
            return true;
        } else {
            s.makeText(walletBindDepositUI, i.wallet_card_mobile_hint, 0).show();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return g.walle_wxcredit_bind_deposit_ui;
    }

    public final void initView() {
        setMMTitle(i.wallet_bind_deposit_title);
        this.psQ = (WalletFormView) findViewById(f.wallet_card_bankcard_id);
        a.b(this.psQ);
        this.pui = (WalletFormView) findViewById(f.wallet_card_type);
        this.qwL = (WalletFormView) findViewById(f.mobile_et);
        a.c(this, this.qwL);
        this.eUb = (Button) findViewById(f.next_btn);
        d(this.psQ, 0, false);
        d(this.qwL, 0, false);
        this.pui.setOnClickListener(new 1(this));
        this.eUb.setOnClickListener(new 2(this));
    }

    private void aL() {
        if (bi.oW(this.pkA.knE)) {
            this.pui.setText("");
        } else if (2 == this.pkA.pnt) {
            this.pui.setText(this.pkA.knE + " " + getString(i.wallet_credit_card));
        } else {
            this.pui.setText(this.pkA.knE + " " + getString(i.wallet_deposit_card));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    ElementQuery elementQuery = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    if (elementQuery.bOE()) {
                        this.pkA = elementQuery;
                        aL();
                        return;
                    }
                    h.i(this, i.wallet_bind_deposit_bank_type_err, i.app_tip);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        boolean z = false;
        if (i == 0 && i2 == 0 && (lVar instanceof t)) {
            t tVar = (t) lVar;
            if (tVar.pjz != null) {
                if (tVar.pjz.bOE()) {
                    this.pkA = tVar.pjz;
                    aL();
                    if (this.pkA.pnr && this.pkA.isError()) {
                        h.i(this, i.wallet_bank_broken, i.app_tip);
                        return true;
                    }
                    c af = com.tencent.mm.wallet_core.a.af(this);
                    if (af != null) {
                        int i3 = this.pkA.pjA;
                        if (af != null) {
                            if (af.jfZ.containsKey("key_support_bankcard")) {
                                int cCR = af.cCR();
                                z = cCR == 0 ? true : Bankcard.dY(cCR, i3);
                            } else {
                                z = true;
                            }
                        }
                        if (!z) {
                            if (af.bQH()) {
                                x.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
                                h.i(this, i.wallet_allow_international_bankcard, i.app_tip);
                            } else {
                                x.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
                                h.i(this, i.wallet_allow_domestic_bankcard, i.app_tip);
                            }
                            this.psQ.bqn();
                            return true;
                        }
                    }
                    aL();
                    return true;
                }
                h.i(this, i.wallet_bind_deposit_bank_type_err, i.app_tip);
                return true;
            }
        }
        return false;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
