package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import android.text.style.CharacterStyle;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class e<V, C extends g<V>> extends t<V, C> {
    public abstract boolean bV(Object obj);

    protected abstract g<V> caE();

    protected abstract V caF();

    protected final com.tencent.mm.plugin.wenote.model.nativenote.manager.e p(WXRTEditText wXRTEditText) {
        return new com.tencent.mm.plugin.wenote.model.nativenote.manager.e(wXRTEditText);
    }

    public void a(WXRTEditText wXRTEditText, V v) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.e p = p(wXRTEditText);
        int i = p.isEmpty() ? 18 : 34;
        Spannable text = wXRTEditText.getText();
        Iterator it = a(text, p, s.qtt).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = caF().equals(v);
            int spanStart = text.getSpanStart(next);
            if (spanStart < p.Tw) {
                if (equals) {
                    p.es(p.Tw - spanStart, 0);
                    i = 34;
                } else {
                    caF();
                    text.setSpan(caE(), spanStart, p.Tw, 33);
                }
            }
            spanStart = text.getSpanEnd(next);
            if (spanStart > p.tK) {
                if (equals) {
                    p.es(0, spanStart - p.tK);
                } else {
                    caF();
                    text.setSpan(caE(), p.tK, spanStart, 34);
                }
            }
            text.removeSpan(next);
        }
        if (v != null) {
            text.setSpan(caE(), p.Tw, p.tK, i);
        }
    }

    protected final s<ArrayList> a(Spannable spannable, com.tencent.mm.plugin.wenote.model.nativenote.manager.e eVar, int i) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : spannable.getSpans(Math.max(0, eVar.Tw - 1), Math.min(spannable.length(), eVar.tK + 1), CharacterStyle.class)) {
            if (bV(obj)) {
                boolean z;
                int spanStart = spannable.getSpanStart(obj);
                int spanEnd = spannable.getSpanEnd(obj);
                int i2 = eVar.Tw;
                int i3 = eVar.tK;
                int max = Math.max(spanStart, i2);
                int min = Math.min(spanEnd, i3);
                if (max > min) {
                    z = false;
                } else if (max < min) {
                    z = true;
                } else if ((spanStart > i2 && spanEnd < i3) || (i2 > spanStart && i3 < spanEnd)) {
                    z = true;
                } else if (i == s.qts) {
                    z = false;
                } else {
                    spanStart = spannable.getSpanFlags(obj) & 51;
                    z = spanEnd == i2 ? c(spanStart, new int[]{34, 18}) : c(spanStart, new int[]{17, 18});
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }
}
