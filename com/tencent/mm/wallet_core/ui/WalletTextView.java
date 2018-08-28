package com.tencent.mm.wallet_core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Selection;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.f.a;
import java.util.regex.Pattern;

@SuppressLint({"AppCompatCustomView"})
public class WalletTextView extends TextView {
    private static final String TAG = ("MicroMsg." + new StringBuilder("weiVtxeTtellaW").reverse().toString());
    private String mPrefix;
    private Object sHv;
    private Object uZh;
    private int uZi;

    public WalletTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WalletTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sHv = "";
        this.uZh = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.WalletTextViewAttrs, i, 0);
        this.uZi = obtainStyledAttributes.getInteger(k.WalletTextViewAttrs_walletTypeFace, 4);
        this.mPrefix = obtainStyledAttributes.getString(k.WalletTextViewAttrs_walletPrefix);
        obtainStyledAttributes.recycle();
        cDQ();
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        Object obj;
        this.sHv = charSequence;
        String charSequence2 = charSequence.toString();
        if (charSequence2 == null || charSequence2.length() == 0) {
            obj = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder(7);
            for (int i = 0; i < 7; i++) {
                stringBuilder.append((char) ((int) ((6222620280936476253L >> ((6 - i) * 8)) & 255)));
            }
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            obj = charSequence2.replaceAll(stringBuilder2, stringBuilder.toString());
        }
        this.uZh = obj;
        if (!bi.oW(this.mPrefix)) {
            charSequence = this.mPrefix + charSequence;
        }
        if (!(this.uZi == 4 || bi.K(charSequence) || !Pattern.compile(".*?[a-zA-Z]+.*?").matcher(charSequence).matches())) {
            x.i(TAG, "force use std font");
            this.uZi = 4;
            cDQ();
        }
        super.setText(charSequence, bufferType);
    }

    private void cDQ() {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), e.Hc(this.uZi)));
    }

    public void setTypeface(int i) {
        this.uZi = i;
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), e.Hc(i)));
    }

    public void setPrefix(String str) {
        this.mPrefix = str;
    }

    @Deprecated
    public CharSequence getText() {
        boolean z = true;
        a cDt = a.cDt();
        if (b.lFJ.bI(this)) {
            if (cDt.uXQ.containsKey(this)) {
                z = false;
            } else {
                cDt.uXQ.put(this, Boolean.valueOf(true));
                f.mDy.a(715, 0, 1, false);
                if ((com.tencent.mm.wallet_core.f.b.cDw() || h.Ae()) && com.tencent.mm.wallet_core.f.b.cDu()) {
                    d.mOw.vJ(Integer.MIN_VALUE);
                }
                z = false;
            }
        }
        if (z) {
            return (CharSequence) this.sHv;
        }
        x.printErrStackTrace(TAG, new Throwable(), "check point 0.", new Object[0]);
        if (!com.tencent.mm.wallet_core.f.b.cDw() && !h.Ae()) {
            return (CharSequence) this.sHv;
        }
        return (CharSequence) (com.tencent.mm.wallet_core.f.b.cDv() ? this.uZh : this.sHv);
    }

    public int getSelectionStart() {
        return Selection.getSelectionStart((CharSequence) this.sHv);
    }

    public int getSelectionEnd() {
        return Selection.getSelectionEnd((CharSequence) this.sHv);
    }
}
