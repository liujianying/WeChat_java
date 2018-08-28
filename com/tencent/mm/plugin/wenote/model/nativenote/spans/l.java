package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import android.util.SparseIntArray;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l extends o<Boolean, m> {
    private p qsN = new p();

    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Object obj) {
        Boolean bool = (Boolean) obj;
        Spannable text = wXRTEditText.getText();
        if (bool == null) {
            bool = Boolean.valueOf(false);
        }
        this.qsN.qtb.clear();
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i = 0;
        int i2 = 1;
        while (i < size) {
            int i3;
            int i4;
            Object next;
            n nVar = (n) paragraphs.get(i);
            int i5 = 0;
            List a = u.qtz.a(text, nVar, s.qts);
            if (a.isEmpty()) {
                i3 = 0;
            } else {
                Iterator it = a.iterator();
                while (true) {
                    i4 = i5;
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    i5 = next instanceof g ? ((Integer) ((g) next).getValue()).intValue() + i4 : i4;
                }
                i3 = i4;
            }
            sparseIntArray.put(i2, i3);
            ArrayList a2 = a(text, nVar, s.qtt);
            this.qsN.a(a2, nVar);
            boolean booleanValue = nVar.a(eVar) ? bool.booleanValue() : !a2.isEmpty();
            next = (i <= 0 || nVar.caK() != 1 || ((n) paragraphs.get(i - 1)).caK() != 1 || bool.booleanValue()) ? null : 1;
            if (next != null ? false : booleanValue) {
                i4 = 1;
                for (int i6 = 1; i6 < i2; i6++) {
                    i5 = sparseIntArray.get(i6);
                    int i7 = sparseIntArray2.get(i6);
                    if (i5 < i3) {
                        i5 = 1;
                    } else if (i5 != i3) {
                    } else {
                        i5 = i7 == 0 ? 1 : i7 + 1;
                    }
                    i4 = i5;
                }
                sparseIntArray2.put(i2, i4);
                this.qsN.a(new m(i4, b.bZC(), nVar.isEmpty(), nVar.qsT, nVar.qsU), nVar);
                u.qtx.a(text, nVar, this.qsN);
                u.qtw.a(text, nVar, this.qsN);
            }
            i++;
            i2++;
        }
        this.qsN.c(text);
    }

    public final int caD() {
        return 2;
    }
}
