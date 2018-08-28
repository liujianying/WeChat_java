package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.NoCopySpan;
import android.text.Spannable;
import android.widget.TextView;

final class ae {

    private static class a implements NoCopySpan {
        public float Yr;
        public float Ys;
        public int gJn;
        public int gJo;
        public boolean gJp;
        public boolean gJq;
        public boolean gJr;
        @Deprecated
        public boolean gJs;

        public a(float f, float f2, int i, int i2) {
            this.Yr = f;
            this.Ys = f2;
            this.gJn = i;
            this.gJo = i2;
        }
    }

    static a[] d(TextView textView) {
        int i = 0;
        a[] aVarArr = null;
        if (textView != null && (textView.getText() instanceof Spannable)) {
            Spannable spannable = (Spannable) textView.getText();
            aVarArr = (a[]) spannable.getSpans(0, spannable.length(), a.class);
            int length = aVarArr.length;
            while (i < length) {
                spannable.removeSpan(aVarArr[i]);
                i++;
            }
        }
        return aVarArr;
    }
}
