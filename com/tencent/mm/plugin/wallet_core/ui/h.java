package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.c;

public class h extends ClickableSpan {
    private int doi = -1;
    private Context mContext = null;
    int pN = -1;
    public a pvm = null;

    public h(Context context) {
        this.mContext = context;
        this.pN = this.mContext.getResources().getColor(c.wallet_link_color);
        this.doi = this.mContext.getResources().getColor(c.transparent);
    }

    public void onClick(View view) {
        if (this.pvm != null) {
            this.pvm.onClick(view);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(false);
        textPaint.setColor(this.pN);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.doi;
    }
}
