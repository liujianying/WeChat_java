package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import java.lang.reflect.Array;

public final class a extends SpannableString {
    private int Ov;
    private Object[] qpK;
    private int[] qpL;

    public a(CharSequence charSequence) {
        super(charSequence.toString());
        f(charSequence, charSequence.length());
    }

    private void f(CharSequence charSequence, int i) {
        this.qpK = new Object[20];
        this.qpL = new int[60];
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            for (Object obj : spanned.getSpans(0, i, Object.class)) {
                if ((obj instanceof CharacterStyle) || (obj instanceof ParagraphStyle)) {
                    int spanStart = spanned.getSpanStart(obj);
                    int spanEnd = spanned.getSpanEnd(obj);
                    int spanFlags = spanned.getSpanFlags(obj);
                    if (spanStart < 0) {
                        spanStart = 0;
                    }
                    if (spanEnd > i) {
                        spanEnd = i;
                    }
                    setSpan(obj, spanStart + 0, spanEnd + 0, spanFlags);
                }
            }
        }
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        if (this.Ov + 1 >= this.qpK.length) {
            int i4 = this.Ov + 10;
            Object obj2 = new Object[i4];
            Object obj3 = new int[(i4 * 3)];
            System.arraycopy(this.qpK, 0, obj2, 0, this.Ov);
            System.arraycopy(this.qpL, 0, obj3, 0, this.Ov * 3);
            this.qpK = obj2;
            this.qpL = obj3;
        }
        this.qpK[this.Ov] = obj;
        this.qpL[(this.Ov * 3) + 0] = i;
        this.qpL[(this.Ov * 3) + 1] = i2;
        this.qpL[(this.Ov * 3) + 2] = i3;
        this.Ov++;
    }

    public final void removeSpan(Object obj) {
        int i = this.Ov;
        Object obj2 = this.qpK;
        Object obj3 = this.qpL;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (obj2[i2] == obj) {
                i -= i2 + 1;
                System.arraycopy(obj2, i2 + 1, obj2, i2, i);
                System.arraycopy(obj3, (i2 + 1) * 3, obj3, i2 * 3, i * 3);
                this.Ov--;
                return;
            }
        }
    }

    public final int getSpanStart(Object obj) {
        int i = this.Ov;
        Object[] objArr = this.qpK;
        int[] iArr = this.qpL;
        for (i--; i >= 0; i--) {
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 0];
            }
        }
        return -1;
    }

    public final int getSpanEnd(Object obj) {
        int i = this.Ov;
        Object[] objArr = this.qpK;
        int[] iArr = this.qpL;
        for (i--; i >= 0; i--) {
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 1];
            }
        }
        return -1;
    }

    public final int getSpanFlags(Object obj) {
        int i = this.Ov;
        Object[] objArr = this.qpK;
        int[] iArr = this.qpL;
        for (i--; i >= 0; i--) {
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 2];
            }
        }
        return 0;
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        int i3 = 0;
        int i4 = this.Ov;
        Object[] objArr = this.qpK;
        int[] iArr = this.qpL;
        Object obj = null;
        Object obj2 = null;
        int i5 = 0;
        while (i5 < i4) {
            if (cls == null || cls.isInstance(objArr[i5])) {
                int i6 = iArr[(i5 * 3) + 0];
                int i7 = iArr[(i5 * 3) + 1];
                if (i6 <= i2 && i7 >= i && (i6 == i7 || i == i2 || !(i6 == i2 || i7 == i))) {
                    if (i3 == 0) {
                        obj2 = objArr[i5];
                        i3++;
                    } else {
                        if (i3 == 1) {
                            obj = (Object[]) Array.newInstance(cls, (i4 - i5) + 1);
                            obj[0] = obj2;
                        }
                        i7 = 16711680 & iArr[(i5 * 3) + 2];
                        if (i7 != 0) {
                            i6 = 0;
                            while (i6 < i3 && i7 <= (getSpanFlags(obj[i6]) & 16711680)) {
                                i6++;
                            }
                            System.arraycopy(obj, i6, obj, i6 + 1, i3 - i6);
                            obj[i6] = objArr[i5];
                            i3++;
                        } else {
                            i6 = i3 + 1;
                            obj[i3] = objArr[i5];
                            i3 = i6;
                        }
                    }
                }
            }
            i5++;
        }
        if (i3 == 0) {
            return (Object[]) Array.newInstance(cls, 0);
        }
        if (i3 == 1) {
            Object[] objArr2 = (Object[]) Array.newInstance(cls, 1);
            objArr2[0] = obj2;
            return objArr2;
        } else if (i3 == obj.length) {
            return (Object[]) obj;
        } else {
            Object[] objArr3 = (Object[]) Array.newInstance(cls, i3);
            System.arraycopy(obj, 0, objArr3, 0, i3);
            return objArr3;
        }
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        int i3 = this.Ov;
        Object[] objArr = this.qpK;
        int[] iArr = this.qpL;
        if (cls == null) {
            cls = Object.class;
        }
        int i4 = 0;
        int i5 = i2;
        while (i4 < i3) {
            int i6 = iArr[(i4 * 3) + 0];
            int i7 = iArr[(i4 * 3) + 1];
            if (i6 <= i || i6 >= i5 || !cls.isInstance(objArr[i4])) {
                i6 = i5;
            }
            if (i7 <= i || i7 >= i6 || !cls.isInstance(objArr[i4])) {
                i7 = i6;
            }
            i4++;
            i5 = i7;
        }
        return i5;
    }
}
