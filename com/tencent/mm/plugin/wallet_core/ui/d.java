package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    public OnClickListener iFK;
    private View ido;
    public String jNk;
    public boolean jNo;
    public int lQm = Integer.MAX_VALUE;
    private int lQn = -1;
    private int lQo = -1;
    private View mView = null;

    public d(Context context) {
        super(context, null);
        setLayoutResource(g.key_value_preference);
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
        TextView textView = (TextView) view.findViewById(f.value_pref_tv);
        ((TextView) view.findViewById(f.key_pref_tv)).setText(getTitle());
        this.ido = view;
        if (this.lQm != Integer.MAX_VALUE) {
            textView.setTextColor(this.lQm);
        }
        if (!this.jNo) {
            textView.setOnClickListener(null);
            textView.setText(j.a(this.mContext, this.jNk, textView.getTextSize()));
        } else if (this.lQn < 0 || this.lQo <= 0) {
            if (this.lQm != Integer.MAX_VALUE) {
                textView.setTextColor(this.lQm);
            } else {
                textView.setTextColor(this.mContext.getResources().getColor(c.mall_link_color));
            }
            textView.setOnClickListener(this.iFK);
            textView.setText(j.a(this.mContext, this.jNk, textView.getTextSize()));
        } else {
            h hVar = new h(this.mContext);
            CharSequence spannableString = new SpannableString(this.jNk);
            hVar.pvm = new 1(this);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(hVar, this.lQn, this.lQo, 33);
            textView.setText(spannableString);
        }
    }
}
