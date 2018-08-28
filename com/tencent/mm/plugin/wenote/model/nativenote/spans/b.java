package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import android.text.style.StyleSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.Iterator;

public final class b extends e<Boolean, BoldSpan> {
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, Object obj) {
        Boolean bool = (Boolean) obj;
        e p = p(wXRTEditText);
        int i = p.isEmpty() ? 18 : 34;
        Spannable text = wXRTEditText.getText();
        Iterator it = a(text, p, s.qtt).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = BoldSpan.caG().equals(bool);
            int spanStart = text.getSpanStart(next);
            if (spanStart < p.Tw) {
                if (equals) {
                    p.es(p.Tw - spanStart, 0);
                    i = 34;
                } else {
                    BoldSpan.caG();
                    text.setSpan(new BoldSpan(), spanStart, p.Tw, 33);
                }
            }
            spanStart = text.getSpanEnd(next);
            if (spanStart > p.tK) {
                if (equals) {
                    p.es(0, spanStart - p.tK);
                } else {
                    BoldSpan.caG();
                    text.setSpan(new BoldSpan(), p.tK, spanStart, 34);
                }
            }
            text.removeSpan(next);
        }
        if (bool != null && bool.booleanValue()) {
            text.setSpan(new BoldSpan(), p.Tw, p.tK, i);
        }
    }

    protected final /* synthetic */ g caE() {
        return new BoldSpan();
    }

    protected final /* synthetic */ Object caF() {
        return BoldSpan.caG();
    }

    public final boolean bV(Object obj) {
        if (obj instanceof BoldSpan) {
            return true;
        }
        return (obj instanceof StyleSpan) && ((StyleSpan) obj).getStyle() == 1;
    }

    public final int caD() {
        return 0;
    }
}
