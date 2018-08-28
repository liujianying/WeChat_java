package com.tencent.mm.pluginsdk.ui.d;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;

public final class k implements GetChars, Spannable, CharSequence {
    private SpannableString qQb;

    public k() {
        this.qQb = null;
        this.qQb = new SpannableString("");
    }

    public k(CharSequence charSequence) {
        this.qQb = null;
        this.qQb = new SpannableString(charSequence);
    }

    public k(String str) {
        this.qQb = null;
        this.qQb = new SpannableString(str);
    }

    public k(SpannableString spannableString) {
        this.qQb = null;
        this.qQb = spannableString;
    }

    public final void a(Object obj, CharSequence charSequence, int i) {
        c(obj, i, charSequence.length() + i, 33);
    }

    public final void f(Object obj, CharSequence charSequence) {
        a(obj, charSequence, 0);
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        c(obj, i, i2, i3);
    }

    private void c(Object obj, int i, int i2, int i3) {
        if (i >= 0 && i2 <= this.qQb.length()) {
            this.qQb.setSpan(obj, i, i2, i3);
        }
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return this.qQb.getSpans(i, i2, cls);
    }

    public final int getSpanStart(Object obj) {
        return this.qQb.getSpanStart(obj);
    }

    public final int getSpanEnd(Object obj) {
        return this.qQb.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        return this.qQb.getSpanFlags(obj);
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.qQb.nextSpanTransition(i, i2, cls);
    }

    public final int length() {
        return this.qQb.length();
    }

    public final char charAt(int i) {
        return this.qQb.charAt(i);
    }

    public final CharSequence subSequence(int i, int i2) {
        return this.qQb.subSequence(i, i2);
    }

    public final void removeSpan(Object obj) {
        this.qQb.removeSpan(obj);
    }

    public final void getChars(int i, int i2, char[] cArr, int i3) {
        this.qQb.getChars(i, i2, cArr, i3);
    }

    public final String toString() {
        return this.qQb.toString();
    }
}
