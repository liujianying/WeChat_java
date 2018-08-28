package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends o<Boolean, k> {
    private p qsN = new p();

    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Object obj) {
        Boolean bool = (Boolean) obj;
        Spannable text = wXRTEditText.getText();
        if (bool == null) {
            bool = Boolean.valueOf(false);
        }
        this.qsN.qtb.clear();
        ArrayList paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i = 0;
        k kVar = null;
        while (i < size) {
            n nVar = (n) paragraphs.get(i);
            ArrayList a = a(text, nVar, s.qtt);
            this.qsN.a(a, nVar);
            k kVar2 = (a.isEmpty() || !(a.get(0) instanceof k)) ? null : (k) a.get(0);
            boolean z = kVar2 != null && kVar2.qsW;
            if (kVar != null && kVar == kVar2 && z) {
                z = false;
            }
            boolean z2 = !a.isEmpty();
            boolean booleanValue = nVar.a(eVar) ? bool.booleanValue() : z2;
            Object obj2 = (i <= 0 || nVar.caK() != 1 || ((n) paragraphs.get(i - 1)).caK() != 1 || bool.booleanValue()) ? null : 1;
            boolean z3 = obj2 != null ? false : booleanValue;
            if (z3) {
                this.qsN.a(new k(z, b.bZC(), nVar.isEmpty(), nVar.qsT, nVar.qsU), nVar);
                u.qty.a(text, nVar, this.qsN);
                u.qtx.a(text, nVar, this.qsN);
            }
            if (!z3 && z2) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    text.removeSpan(it.next());
                }
            }
            i++;
            kVar = kVar2;
        }
        this.qsN.c(text);
    }

    public final int caD() {
        return 3;
    }
}
