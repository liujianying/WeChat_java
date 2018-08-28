package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI extends WalletECardBaseUI {
    private Button eUb;
    private ElementQuery pkA;
    private WalletFormView pui;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.ecard_element_input_title);
        initView();
        aL();
    }

    protected final void initView() {
        this.pui = (WalletFormView) findViewById(f.wallet_card_type);
        this.pui.setOnClickListener(new 1(this));
        this.eUb = (Button) findViewById(f.next_btn);
        this.eUb.setOnClickListener(new 2(this));
    }

    private void aL() {
        if (this.pkA == null) {
            this.pkA = new ElementQuery();
        }
        if (bi.oW(this.pkA.knE)) {
            this.pui.setText("");
        } else if (!bi.oW(this.pkA.pnu)) {
            this.pui.setText(this.pkA.knE + " " + this.pkA.pnu);
        } else if (2 == this.pkA.pnt) {
            this.pui.setText(this.pkA.knE + " " + getString(i.wallet_credit_card));
        } else {
            this.pui.setText(this.pkA.knE + " " + getString(i.wallet_deposit_card));
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.ecard_element_input_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.pkA = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    aL();
                    return;
                default:
                    super.onActivityResult(i, i2, intent);
                    return;
            }
        }
    }
}
