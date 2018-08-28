package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.d.a;

class a$4 implements a {
    final /* synthetic */ a pNN;
    final /* synthetic */ a.a pNO;
    final /* synthetic */ int val$id;

    public a$4(a aVar, a.a aVar2, int i) {
        this.pNN = aVar;
        this.pNO = aVar2;
        this.val$id = i;
    }

    public final void onDismiss() {
        x.v("FTSSearchActionSheetMgr", "selected pos %d", new Object[]{Integer.valueOf(-1)});
        if (this.pNO != null) {
            this.pNO.eh(-1, this.val$id);
        }
        a.b(this.pNN).remove(Integer.valueOf(this.val$id));
    }
}
