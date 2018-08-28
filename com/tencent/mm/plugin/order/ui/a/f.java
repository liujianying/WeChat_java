package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference {
    private OnClickListener iFK;
    private String jNk;
    private boolean jNo;
    private int lQm = Integer.MAX_VALUE;
    private int lQn = -1;
    private int lQo = -1;
    private View mView = null;

    public f(Context context) {
        super(context);
        setLayoutResource(g.mall_order_common_pref);
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
        TextView textView = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.mall_order_common_pref_content);
        ((TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.mall_order_common_pref_title)).setText(getTitle());
        if (this.lQm != Integer.MAX_VALUE) {
            textView.setTextColor(this.lQm);
        }
        if (!this.jNo) {
            textView.setOnClickListener(null);
            textView.setText(j.a(this.mContext, this.jNk, textView.getTextSize()));
        } else if (this.lQn < 0 || this.lQo <= 0) {
            textView.setTextColor(this.mContext.getResources().getColor(c.mall_link_color));
            textView.setOnClickListener(this.iFK);
            textView.setText(j.a(this.mContext, this.jNk, textView.getTextSize()));
        } else {
            a aVar = new a(this.mContext);
            CharSequence spannableString = new SpannableString(this.jNk);
            aVar.lQF = new 1(this);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(aVar, this.lQn, this.lQo, 33);
            textView.setText(spannableString);
        }
    }

    public final void Jw(String str) {
        try {
            this.lQm = Color.parseColor(str);
        } catch (Exception e) {
            this.lQm = Integer.MAX_VALUE;
        }
    }

    public final void setContent(String str) {
        this.jNk = str;
        this.jNo = false;
    }

    public final void a(String str, int i, int i2, OnClickListener onClickListener) {
        this.jNk = str;
        this.jNo = true;
        this.lQn = i;
        this.lQo = i2;
        this.iFK = onClickListener;
    }
}
