package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.y;

public class LaunchAAByPersonNameAmountRow extends LinearLayout {
    TextView eBQ;
    TextView eCM;
    private View eCO;

    public LaunchAAByPersonNameAmountRow(Context context) {
        super(context);
        init(context);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        y.gq(context).inflate(g.launch_aa_by_person_name_amount_row, this, true);
        this.eCM = (TextView) findViewById(f.username);
        this.eBQ = (TextView) findViewById(f.amount);
        this.eCO = findViewById(f.divider);
    }

    public void setDividerVisible(boolean z) {
        this.eCO.setVisibility(z ? 0 : 8);
    }
}
