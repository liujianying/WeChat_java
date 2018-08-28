package com.tencent.mm.plugin.sight.draft.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.draft.ui.b.e;
import com.tencent.mm.sdk.platformtools.x;

class b$c implements OnClickListener {
    final /* synthetic */ b neG;

    private b$c(b bVar) {
        this.neG = bVar;
    }

    /* synthetic */ b$c(b bVar, byte b) {
        this(bVar);
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof e) {
            b.f(this.neG).bwe();
            e eVar = (e) view.getTag();
            if (eVar.neN == null) {
                x.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
                return;
            }
            eVar.neN.field_fileStatus = 6;
            o.Te().c(eVar.neN, new String[]{"localId"});
            this.neG.a(null, null);
        }
    }
}
