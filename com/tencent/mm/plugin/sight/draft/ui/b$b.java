package com.tencent.mm.plugin.sight.draft.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.sight.draft.ui.b.e;

class b$b implements OnLongClickListener {
    final /* synthetic */ b neG;

    private b$b(b bVar) {
        this.neG = bVar;
    }

    /* synthetic */ b$b(b bVar, byte b) {
        this(bVar);
    }

    public final boolean onLongClick(View view) {
        if (view.getTag() instanceof e) {
            e eVar = (e) view.getTag();
            if (!(eVar.neN == null || -1 == eVar.neN.field_fileStatus)) {
                this.neG.a(b$d.EDIT, true);
            }
        }
        return true;
    }
}
