package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow extends LinearLayout {
    private ImageView eBM;
    private TextView eCM;
    private WalletFormView eCN;
    private View eCO;
    private TextWatcher eCP = null;
    private String username;

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        y.gq(context).inflate(a$g.launch_aa_by_person_amount_select_row, this, true);
        this.eBM = (ImageView) findViewById(a$f.avatar);
        this.eCM = (TextView) findViewById(a$f.username);
        this.eCN = (WalletFormView) findViewById(a$f.money_edit);
        this.eCO = findViewById(a$f.divider);
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.eCP = textWatcher;
        this.eCN.a(textWatcher);
    }

    public WalletFormView getMoneyEdit() {
        return this.eCN;
    }

    public String getUsername() {
        return this.username;
    }

    public double getAmount() {
        String str = this.eCN.getText().toString();
        if (bi.oW(str) || "".equals(str)) {
            return 0.0d;
        }
        return bi.getDouble(str, 0.0d);
    }

    public void setDividerVisible(boolean z) {
        this.eCO.setVisibility(z ? 0 : 8);
    }
}
