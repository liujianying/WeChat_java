package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;

public class WalletItemView extends LinearLayout {
    private String cZH;
    private TextView gsY;
    private String lQs;
    private int lSS;
    private TextView lSk;
    private Object mData;
    private int mType;

    public WalletItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lSS = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.WalletItemView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(k.WalletItemView_walletTitle, 0);
        if (resourceId != 0) {
            this.cZH = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(k.WalletItemView_walletSummary, 0);
        if (resourceId != 0) {
            this.lQs = context.getString(resourceId);
        }
        this.lSS = obtainStyledAttributes.getInt(k.WalletItemView_android_lines, 1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(g.wallet_item_view, this, true);
        this.gsY = (TextView) inflate.findViewById(f.title_tv);
        this.lSk = (TextView) inflate.findViewById(f.summary_tv);
        if (this.gsY != null) {
            this.gsY.setText(this.cZH);
        }
        if (this.lSk != null) {
            this.lSk.setText(this.lQs);
            this.lSk.setLines(this.lSS);
        }
    }

    public WalletItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitle(String str) {
        this.cZH = str;
        this.gsY.setText(this.cZH);
    }

    public void setSummary(String str) {
        this.lQs = str;
        this.lSk.setText(this.lQs);
    }

    public void setSummary(Spanned spanned) {
        this.lQs = spanned.toString();
        this.lSk.setText(this.lQs);
    }

    public int getType() {
        return this.mType;
    }

    public Object getData() {
        return this.mData;
    }
}
