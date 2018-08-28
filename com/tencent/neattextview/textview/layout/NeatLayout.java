package com.tencent.neattextview.textview.layout;

import android.text.TextPaint;
import com.tencent.neattextview.textview.a.a;

public class NeatLayout extends b {
    private int vaX = 0;

    private native int nComputeBreak(String str, float[] fArr, float f, float f2, int[] iArr, float[] fArr2, float f3, boolean[] zArr, char[] cArr, float[] fArr3, char[] cArr2, float[] fArr4, boolean[] zArr2);

    static {
        System.loadLibrary("linebreak");
    }

    public NeatLayout(CharSequence charSequence, float[] fArr) {
        super(charSequence, fArr);
    }

    public final void a(TextPaint textPaint, float f, int i, boolean z) {
        float textSize = textPaint.getTextSize() / 2.0f;
        float textSize2 = z ? textPaint.getTextSize() / 6.0f : 0.0f;
        int length = this.vae.length();
        int[] iArr = new int[length];
        float[] fArr = new float[length];
        boolean[] zArr = new boolean[length];
        int nComputeBreak = nComputeBreak(this.vae, this.vag, 0.0f, f + textSize, iArr, fArr, textSize2, zArr, a.uZZ, this.vaj, a.uZY, this.vai, this.vaD);
        this.vaX = nComputeBreak;
        int i2 = 0;
        int i3 = 0;
        while (i3 < nComputeBreak && i3 < i) {
            int i4 = iArr[i3];
            boolean z2 = zArr[i3];
            length = i4 - i2;
            float f2 = 0.0f;
            textSize2 = f - fArr[i3];
            Object obj = Math.abs(textSize2) <= textSize ? 1 : null;
            if (obj != null) {
                if (i4 - 1 >= 0 && this.vaf[i4 - 1] == 10) {
                    length--;
                }
                int i5 = i2;
                while (i5 < i4) {
                    if (this.vaf[i5] != 10 && this.vag[i5] == 0.0f) {
                        length--;
                    }
                    i5++;
                }
                f2 = textSize2 / ((float) (Math.max(2, length) - 1));
            }
            a(this.vaf, i2, i4, obj != null ? f : fArr[i3], this.vag, this.val.size(), f2, z2);
            i3++;
            i2 = i4;
        }
    }

    public final int cEg() {
        return this.vaX;
    }
}
