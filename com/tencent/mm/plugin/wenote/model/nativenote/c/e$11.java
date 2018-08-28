package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class e$11 implements OnClickListener {
    final /* synthetic */ e qsJ;

    public e$11(e eVar) {
        this.qsJ = eVar;
    }

    public final void onClick(View view) {
        x.i("NoteSelectManager", "unbold");
        this.qsJ.cav();
    }
}
