package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.ui.tools.CustomFitTextView;
import com.tencent.mm.w.a.d;

public class WalletPayUSecurityQuestionView extends LinearLayout {
    private Context mContext;
    private TextView pGu;
    private CustomFitTextView pGv;
    String pGw;

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        CharSequence charSequence;
        super(context, attributeSet);
        this.mContext = context;
        String str = "";
        String str2 = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, k.EditHintView, -1, 0);
            int resourceId = obtainStyledAttributes.getResourceId(k.EditHintView_tipmsg, 0);
            if (resourceId != 0) {
                str = this.mContext.getString(resourceId);
            }
            resourceId = obtainStyledAttributes.getResourceId(k.EditHintView_hint, 0);
            if (resourceId != 0) {
                str2 = this.mContext.getString(resourceId);
            }
            boolean z2 = obtainStyledAttributes.getBoolean(k.EditHintView_android_clickable, false);
            obtainStyledAttributes.recycle();
            z = z2;
            charSequence = str;
        } else {
            z = false;
            Object charSequence2 = str;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(g.payu_view_secret_question, this, true);
        this.pGu = (TextView) inflate.findViewById(f.tip_tv);
        this.pGv = (CustomFitTextView) inflate.findViewById(f.pre_filled_tv);
        this.pGu.setText(charSequence2);
        CustomFitTextView customFitTextView = this.pGv;
        customFitTextView.a(str2, customFitTextView.maxLines, customFitTextView.uwQ, customFitTextView.uwO, customFitTextView.getResources().getColor(d.hint_text_color));
        if (z) {
            this.pGv.setEnabled(false);
            this.pGv.setTextColor(getResources().getColor(c.wallet_common_clickable_text_color));
            this.pGv.setFocusable(false);
            this.pGv.setClickable(false);
            this.pGv.setBackgroundResource(e.transparent_background);
            setBackgroundResource(e.comm_list_item_selector);
            return;
        }
        this.pGv.setEnabled(false);
        this.pGv.setFocusable(false);
        this.pGv.setClickable(false);
        this.pGv.setBackgroundResource(e.transparent_background);
        setBackgroundResource(e.list_item_normal);
    }

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setQuestionText(String str) {
        this.pGw = str;
        KeyListener keyListener = this.pGv.getKeyListener();
        this.pGv.setInputType(1);
        this.pGv.setKeyListener(null);
        setValStr(str);
        this.pGv.setKeyListener(keyListener);
    }

    public String getCurrentQuestion() {
        return this.pGw;
    }

    public void setValStr(String str) {
        CustomFitTextView customFitTextView = this.pGv;
        customFitTextView.a(str, 3, false, -1, customFitTextView.getCurrentTextColor());
    }
}
