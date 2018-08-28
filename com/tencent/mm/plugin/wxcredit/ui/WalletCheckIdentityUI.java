package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletCheckIdentityUI extends WalletBaseUI {
    private WalletFormView phM;
    private WalletFormView psR;
    private String qwN;

    static /* synthetic */ boolean a(WalletCheckIdentityUI walletCheckIdentityUI, String str, String str2) {
        if (bi.oW(str)) {
            s.makeText(walletCheckIdentityUI, i.wallet_check_indentity_name_err, 0).show();
            return false;
        } else if (!bi.oW(str2) && str2.length() >= 4 && (!bi.oW(walletCheckIdentityUI.qwN) || walletCheckIdentityUI.phM.ZF())) {
            return true;
        } else {
            s.makeText(walletCheckIdentityUI, i.wallet_card_identify_err_hint, 0).show();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.wallet_wxcredit_check_indentity_ui;
    }

    public final void initView() {
        setMMTitle(i.wallet_check_indentity_title);
        this.psR = (WalletFormView) findViewById(f.name_et);
        a.e(this, this.psR);
        this.phM = (WalletFormView) findViewById(f.identity_et);
        a.c(this.phM);
        d(this.phM, 1, false);
        CharSequence string = this.sy.getString("key_pre_name");
        this.qwN = this.sy.getString("key_pre_indentity");
        if (!bi.oW(string)) {
            this.psR.getPrefilledTv().setText(string);
            this.psR.setHint(getString(i.wallet_card_username_last_hint));
        }
        if (!bi.oW(this.qwN)) {
            this.phM.setMaxInputLength(4);
            this.phM.getPrefilledTv().setText(this.qwN);
            this.phM.setHint(getString(i.wallet_card_identify_last_hint));
        }
        findViewById(f.next_btn).setOnClickListener(new 1(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
