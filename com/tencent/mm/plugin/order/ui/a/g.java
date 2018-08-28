package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g extends Preference {
    private static int lQq;
    private static float lQr = 16.0f;
    f gua;
    String lQs;
    private String[] lQt;
    private TruncateAt lQu;
    private boolean lQv = false;
    private View mView = null;

    public g(Context context) {
        super(context);
        setLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mall_order_deployable_pref);
        lQq = context.getResources().getColor(c.mall_order_pref_content_color);
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
        TextView textView = (TextView) view.findViewById(a.f.mall_order_deployable_pref_content_summary);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.mall_order_deployable_pref_content_container);
        ((TextView) view.findViewById(a.f.mall_order_deployable_pref_title)).setText(getTitle());
        if (this.lQt == null || this.lQt.length <= 1) {
            textView.setTextColor(lQq);
        } else {
            textView.setOnClickListener(new 1(this, textView, linearLayout));
        }
        textView.setText(this.lQs);
    }

    public final void a(String[] strArr, TruncateAt truncateAt) {
        this.lQt = strArr;
        this.lQu = truncateAt;
        this.lQv = true;
    }
}
