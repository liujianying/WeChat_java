package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishUI extends WalletBaseUI {
    private Button lqN;
    private WalletTextView pbA;
    private TextView pbB;
    private TextView pbC;
    private TextView pbz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pbz = (TextView) findViewById(a$f.succ_wording_tv);
        this.pbA = (WalletTextView) findViewById(a$f.amount_tv);
        this.lqN = (Button) findViewById(a$f.finish_button);
        this.pbB = (TextView) findViewById(a$f.profile_wording_tv);
        this.pbC = (TextView) findViewById(a$f.upgrade_wording_tv);
        int intExtra = getIntent().getIntExtra("key_mode", 1);
        double doubleExtra = getIntent().getDoubleExtra("key_amount", 0.0d);
        CharSequence stringExtra = getIntent().getStringExtra("profile_date_wording");
        CharSequence stringExtra2 = getIntent().getStringExtra("profile_upgrade_wording");
        if (intExtra == 1) {
            this.pbz.setText(getString(i.wallet_lqt_save_succ_wording));
            setMMTitle(getString(i.wallet_lqt_save_succ_wording));
        } else if (intExtra == 2) {
            this.pbz.setText(getString(i.wallet_lqt_fetch_succ_wording));
            setMMTitle(getString(i.wallet_lqt_fetch_succ_wording));
        }
        this.pbA.setText(e.A(doubleExtra));
        this.lqN.setOnClickListener(new 1(this));
        if (!bi.oW(stringExtra)) {
            this.pbB.setText(stringExtra);
            this.pbB.setVisibility(0);
        }
        if (!bi.oW(stringExtra2)) {
            this.pbC.setText(j.c(this, stringExtra2, (int) this.pbC.getTextSize()));
            this.pbC.setClickable(true);
            this.pbC.setOnTouchListener(new m());
            this.pbC.setVisibility(0);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return a$g.wallet_lqt_save_fetch_finish_ui;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
