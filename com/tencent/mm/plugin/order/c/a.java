package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.c;

public final class a extends ClickableSpan {
    private int doi = -1;
    public a lQF = null;
    private Context mContext = null;
    private int pN = -1;

    public a(Context context) {
        this.mContext = context;
        this.pN = this.mContext.getResources().getColor(c.mall_link_color);
        this.doi = -1;
    }

    public final void onClick(View view) {
        if (this.lQF != null) {
            this.lQF.onClick(view);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(this.pN);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.doi;
    }
}
