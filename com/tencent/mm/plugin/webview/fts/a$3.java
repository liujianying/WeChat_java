package com.tencent.mm.plugin.webview.fts;

import android.view.MenuItem;
import com.tencent.mm.plugin.webview.fts.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n$d;

class a$3 implements n$d {
    final /* synthetic */ a pNN;
    final /* synthetic */ a pNO;
    final /* synthetic */ int val$id;

    public a$3(a aVar, a aVar2, int i) {
        this.pNN = aVar;
        this.pNO = aVar2;
        this.val$id = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.v("FTSSearchActionSheetMgr", "selected pos %d", new Object[]{Integer.valueOf(i)});
        if (this.pNO != null) {
            this.pNO.eh(i, this.val$id);
        }
        a.b(this.pNN).remove(Integer.valueOf(this.val$id));
    }
}
