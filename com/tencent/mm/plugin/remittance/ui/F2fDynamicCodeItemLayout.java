package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class F2fDynamicCodeItemLayout extends LinearLayout {
    TextView idh;
    TextView myG;

    public F2fDynamicCodeItemLayout(Context context) {
        super(context);
        init();
    }

    public F2fDynamicCodeItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public F2fDynamicCodeItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(g.remittance_f2f_dynamic_code_item_layout, this);
        this.myG = (TextView) inflate.findViewById(f.rfdi_left_tv);
        this.idh = (TextView) inflate.findViewById(f.rfdi_right_tv);
    }
}
