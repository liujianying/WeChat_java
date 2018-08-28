package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow extends LinearLayout {
    private ImageView eDn;
    private TextView eDo;
    private TextView eDp;
    private WalletFormView eDq;
    private TextView eDr;
    private String username;

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        inflate(getContext(), g.launch_aa_by_person_row, this);
        this.eDn = (ImageView) findViewById(f.aa_avatar);
        this.eDo = (TextView) findViewById(f.aa_username);
        this.eDq = (WalletFormView) findViewById(f.launch_aa_by_person_money_edit);
        this.eDp = (TextView) findViewById(f.launch_aa_by_person_money_unit);
        this.eDr = (TextView) findViewById(f.my_self_note);
    }

    public double getMoneyAmount() {
        String str = this.eDq.getText().toString();
        if (bi.oW(str) || "".equals(str)) {
            return 0.0d;
        }
        return bi.getDouble(str, 0.0d);
    }

    public void setAmountTextChangeWatcher(TextWatcher textWatcher) {
        if (textWatcher != null) {
            this.eDq.a(textWatcher);
        }
    }

    public WalletFormView getAmountEditView() {
        return this.eDq;
    }

    public String getUsername() {
        return this.username;
    }
}
