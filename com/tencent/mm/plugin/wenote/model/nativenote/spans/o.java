package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class o<V, C extends g<V>> extends t<V, C> {
    public abstract void a(WXRTEditText wXRTEditText, e eVar, V v);

    protected final e p(WXRTEditText wXRTEditText) {
        return wXRTEditText.getParagraphsInSelection();
    }

    public final void a(WXRTEditText wXRTEditText, V v) {
        e paragraphsInSelection = wXRTEditText.getParagraphsInSelection();
        if (wXRTEditText.qqU && wXRTEditText.getSelection().Tw == paragraphsInSelection.Tw && paragraphsInSelection.Tw > 1) {
            ArrayList a = a(wXRTEditText.getText(), paragraphsInSelection, s.qtt);
            if (!a.isEmpty() && wXRTEditText.getLayout().getPrimaryHorizontal(wXRTEditText.getSelection().Tw) == ((float) b.bZC())) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    wXRTEditText.getText().removeSpan(it.next());
                }
                wXRTEditText.getText().insert(paragraphsInSelection.Tw - 1, "\n");
            }
        }
        a(wXRTEditText, paragraphsInSelection, (Object) v);
        u.a(wXRTEditText, new t[]{this});
    }

    protected final void a(Spannable spannable, n nVar, p pVar) {
        pVar.a(a(spannable, (e) nVar, s.qts), nVar);
    }

    protected final s<ArrayList> a(Spannable spannable, e eVar, int i) {
        ArrayList arrayList = new ArrayList();
        Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (actualTypeArguments == null) {
            return null;
        }
        for (Object obj : spannable.getSpans(eVar.Tw, eVar.tK, (Class) actualTypeArguments[actualTypeArguments.length - 1])) {
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
                z = spanStart == i2 && spanEnd == i3 && i2 == i3;
            } else {
                spanStart = spannable.getSpanFlags(obj) & 51;
                z = spanEnd == i2 ? c(spanStart, new int[]{34, 18}) : c(spanStart, new int[]{17, 18});
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
