package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import java.util.ArrayList;
import java.util.Iterator;

public final class p {
    final ArrayList<a> qtb = new ArrayList();

    private static class a {
        final f qtc;
        final n qtd;
        final boolean qte;

        a(Object obj, n nVar, boolean z) {
            this.qtc = (f) obj;
            this.qtd = nVar;
            this.qte = z;
        }
    }

    public final void a(ArrayList<Object> arrayList, n nVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof f) {
                this.qtb.add(new a(next, nVar, true));
            }
        }
    }

    public final void a(Object obj, n nVar) {
        this.qtb.add(new a(obj, nVar, false));
    }

    public final void c(Spannable spannable) {
        Iterator it = this.qtb.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            f fVar = aVar.qtc;
            int i = aVar.qtd.Tw;
            int spanStart;
            if (aVar.qte) {
                spanStart = spannable.getSpanStart(fVar);
                if (spanStart >= 0 && spanStart < i) {
                    spannable.setSpan(fVar.caH(), spanStart, i, 34);
                }
                spannable.removeSpan(fVar);
            } else {
                n nVar = aVar.qtd;
                int i2 = aVar.qtd.tK;
                spanStart = (nVar.qsU && nVar.isEmpty()) ? 34 : (nVar.qsU && nVar.qsT) ? 18 : nVar.qsU ? 34 : 33;
                if (i2 > spannable.length()) {
                    i2 = spannable.length();
                }
                spannable.setSpan(fVar, i, i2, spanStart);
            }
        }
    }
}
