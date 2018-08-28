package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.platformtools.x;

class e$13 implements OnClickListener {
    final /* synthetic */ e qsJ;

    public e$13(e eVar) {
        this.qsJ = eVar;
    }

    public final void onClick(View view) {
        x.i("NoteSelectManager", "select all");
        this.qsJ.cav();
        if (e.cD()) {
            int bZN = c.bZD().bZN();
            int bZO = c.bZD().bZO();
            b Bv = c.bZD().Bv(bZN);
            b Bv2 = c.bZD().Bv(bZO);
            if (Bv == null || Bv2 == null) {
                x.e("NoteSelectManager", "select all: item is null");
                e.h(this.qsJ);
                return;
            }
            int length;
            if (Bv2.getType() == 1) {
                Spanned Sk = a.Sk(((h) Bv2).content);
                if (Sk == null) {
                    x.e("NoteSelectManager", "select all: spanned is null");
                    e.h(this.qsJ);
                    return;
                }
                length = Sk.length();
            } else {
                length = 1;
            }
            e.e(this.qsJ);
            this.qsJ.w(bZN, 0, bZO, length);
            this.qsJ.cax();
            this.qsJ.cav();
            e.j(this.qsJ);
            this.qsJ.ky(false);
            this.qsJ.kw(false);
            return;
        }
        x.e("NoteSelectManager", "select all: not init");
    }
}
