package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class i extends Preference {
    private int lQB = Integer.MAX_VALUE;
    String lQC;
    private View mView = null;

    public i(Context context) {
        super(context);
        setLayoutResource(g.mall_order_fee_pref);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(f.mall_order_fee_pref_fee);
        ((TextView) view.findViewById(f.mall_order_fee_pref_title)).setText(getTitle());
        textView.setText(this.lQC);
        if (this.lQB != Integer.MAX_VALUE) {
            textView.setTextColor(this.lQB);
        }
    }

    public final void Jx(String str) {
        try {
            this.lQB = Color.parseColor(str);
        } catch (Exception e) {
            this.lQB = -1;
        }
    }
}
