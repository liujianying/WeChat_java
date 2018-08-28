package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashMap;
import java.util.HashSet;

@a(19)
public class WalletPayUCardElementUI extends WalletBaseUI implements WalletFormView.a {
    private Button eWk;
    private WalletFormView pEh;
    WalletFormView pEi;
    private WalletFormView pEj;
    private TextView pEk;
    private TextView pEl;
    private TextView pEm;
    private b pEn;
    private boolean pEo = false;
    private boolean pEp = false;
    private boolean pEq = false;
    private HashMap<String, PayUBankcardElement> pEr = null;
    private HashSet<String> pEs = null;

    static /* synthetic */ void a(WalletPayUCardElementUI walletPayUCardElementUI, View view, Editable editable) {
        if (!(editable == null || editable.length() == 0)) {
            if (view.getId() == walletPayUCardElementUI.pEh.getId()) {
                walletPayUCardElementUI.pEo = true;
            } else if (view.getId() == walletPayUCardElementUI.pEj.getId()) {
                walletPayUCardElementUI.pEq = true;
            } else if (view.getId() == walletPayUCardElementUI.pEi.getId()) {
                walletPayUCardElementUI.pEp = true;
            }
        }
        walletPayUCardElementUI.pEn.bRi();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pEn = new b(this);
        this.pEr = new HashMap();
        this.pEs = new HashSet();
        this.pEh = (WalletFormView) findViewById(a$f.card_num_et);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.pEh);
        this.pEi = (WalletFormView) findViewById(a$f.date_et);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.pEi);
        this.pEj = (WalletFormView) findViewById(a$f.cvv_et);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.pEj);
        this.pEk = (TextView) findViewById(a$f.wallet_card_num_err_tipmsg);
        this.pEl = (TextView) findViewById(a$f.wallet_card_cvv_err_tipmsg);
        this.eWk = (Button) findViewById(a$f.next_btn);
        d(this.pEh, 0, false);
        d(this.pEj, 0, false);
        this.pEh.setOnInputValidChangeListener(this);
        this.pEj.setOnInputValidChangeListener(this);
        this.pEi.setOnInputValidChangeListener(this);
        this.pEh.setEncryptType(0);
        this.pEj.a(new 1(this));
        this.pEi.a(new 2(this));
        this.pEh.a(new a() {
            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.pEh, editable);
            }
        });
        this.eWk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) WalletPayUCardElementUI.this.pEr.get(WalletPayUCardElementUI.this.pEh.getText());
                if (payUBankcardElement == null) {
                    x.e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
                    return;
                }
                WalletPayUCardElementUI.this.pEh.setEncryptType(50);
                WalletPayUCardElementUI.this.sy.putParcelable("key_card_element", payUBankcardElement);
                WalletPayUCardElementUI.this.sy.putString("key_card_id", WalletPayUCardElementUI.this.pEh.getText());
                WalletPayUCardElementUI.this.sy.putString("key_cvv", WalletPayUCardElementUI.this.pEj.getText());
                WalletPayUCardElementUI.this.sy.putString("key_expire_data", WalletPayUCardElementUI.this.pEi.getText());
                WalletPayUCardElementUI.this.cDL().m(new Object[0]);
            }
        });
        ((TextView) findViewById(a$f.wallet_power_by_tenpay)).setText(v.cDl());
        this.pEm = (TextView) findViewById(a$f.start_introduction_tv);
        c.a(this, this.pEm);
    }

    public void onResume() {
        super.onResume();
        this.pEn.bRi();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof NetScenePayUElementQuery) {
            this.pEr.put(((NetScenePayUElementQuery) lVar).pDZ, (PayUBankcardElement) this.sy.getParcelable("key_card_element"));
            this.pEn.bRi();
            this.pEs.remove(((NetScenePayUElementQuery) lVar).pDZ);
            return true;
        } else if (!(lVar instanceof com.tencent.mm.plugin.wallet_payu.bind.model.a)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                return false;
            }
            this.pEh.setEncryptType(0);
            return false;
        }
    }

    protected final int getLayoutId() {
        return a$g.payu_ui_card_element;
    }

    public final void fE(boolean z) {
    }

    protected final boolean bND() {
        return true;
    }
}
