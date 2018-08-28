package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements OnClickListener {
    final /* synthetic */ e qsJ;

    public e$2(e eVar) {
        this.qsJ = eVar;
    }

    public final void onClick(View view) {
        x.i("NoteSelectManager", "delete");
        if (!e.cD() || !e.k(this.qsJ)) {
            x.e("NoteSelectManager", "delete: not init or not editable");
            this.qsJ.cav();
        } else if (e.l(this.qsJ)) {
            if (e.m(this.qsJ) != null) {
                e.m(this.qsJ).bZp();
            }
        } else if (e.m(this.qsJ) != null) {
            e.m(this.qsJ).bZq();
        } else {
            this.qsJ.caC();
        }
    }
}
