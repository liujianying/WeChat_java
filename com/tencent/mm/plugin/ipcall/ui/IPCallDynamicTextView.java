package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ag;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class IPCallDynamicTextView extends TextView {
    private double kvA;
    private double kvB;
    private double kvC;
    private boolean kvD;
    private int kvE = 4000;
    private int kvF = 50;
    DecimalFormat kvG = new DecimalFormat("0.00");
    private String kvH = "";
    private String kvI = "";
    private int kvz;
    private ag mHandler = new 1(this);
    private int mHeight;
    private String mValue;

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IPCallDynamicTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        getViewTreeObserver().addOnGlobalLayoutListener(new 2(this));
    }

    public void setLocHeight(int i) {
        this.kvz = i;
    }

    public final void setValue(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            setText(str2);
            return;
        }
        try {
            this.kvB = Double.parseDouble(Fd(str));
            this.kvH = "";
            int i = 0;
            while (i < str2.length() && !Character.isDigit(str2.charAt(i))) {
                this.kvH += str2.charAt(i);
                i++;
            }
            this.kvI = "";
            i = str2.length() - 1;
            while (i > 0 && !Character.isDigit(str2.charAt(i))) {
                this.kvI += str2.charAt(i);
                i--;
            }
            try {
                this.kvC = Double.parseDouble(str2.substring(this.kvH.length(), str2.length() - this.kvI.length()));
                this.mValue = str2;
                this.kvA = (this.kvC - this.kvB) / ((double) (this.kvE / this.kvF));
                if (this.kvA == 0.0d) {
                    setText(str2);
                    return;
                }
                this.kvA = new BigDecimal(this.kvA).setScale(2, 4).doubleValue();
                if (isShown()) {
                    this.mHandler.sendEmptyMessage(1);
                }
            } catch (NumberFormatException e) {
                setText(str2);
            }
        } catch (NumberFormatException e2) {
            setText(str2);
        }
    }

    public static String Fd(String str) {
        String str2 = "";
        int i = 0;
        while (i < str.length() && !Character.isDigit(str.charAt(i))) {
            str2 = str2 + str.charAt(i);
            i++;
        }
        String str3 = "";
        i = str.length() - 1;
        while (i > 0 && !Character.isDigit(str.charAt(i))) {
            str3 = str3 + str.charAt(i);
            i--;
        }
        return str.substring(str2.length(), str.length() - str3.length());
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mHeight = getMeasuredHeight();
    }
}
