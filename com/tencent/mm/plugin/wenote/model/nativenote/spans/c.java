package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;

public final class c extends o<Boolean, d> {
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
        while (i < size) {
            n nVar = (n) paragraphs.get(i);
            ArrayList a = a(text, nVar, s.qtt);
            this.qsN.a(a, nVar);
            boolean booleanValue = nVar.a(eVar) ? bool.booleanValue() : !a.isEmpty();
            boolean z = i > 0 && nVar.caK() == 1 && ((n) paragraphs.get(i - 1)).caK() == 1 && !bool.booleanValue();
            if (z ? false : booleanValue) {
                this.qsN.a(new d(b.bZC(), nVar.isEmpty(), nVar.qsT, nVar.qsU), nVar);
                u.qty.a(text, nVar, this.qsN);
                u.qtw.a(text, nVar, this.qsN);
            }
            i++;
        }
        this.qsN.c(text);
    }

    public final int caD() {
        return 1;
    }
}
