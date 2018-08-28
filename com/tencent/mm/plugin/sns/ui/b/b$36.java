package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.sns.abtest.a;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.protocal.c.bsu;

class b$36 extends c {
    final /* synthetic */ b olf;

    b$36(b bVar) {
        this.olf = bVar;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        as asVar = (as) view.getTag();
        n Nk = af.byo().Nk(asVar.bSZ);
        if (Nk != null) {
            contextMenu.add(0, 0, 0, this.olf.activity.getString(i$j.app_copy));
            if (d.QS("favorite")) {
                contextMenu.add(0, 1, 0, this.olf.activity.getString(i$j.plugin_favorite_opt));
            }
            bsu bAJ = Nk.bAJ();
            if (asVar.nZw || !(bAJ == null || bAJ.sqe == 1 || asVar.nZx)) {
                if (asVar.bDG()) {
                    ap.b(contextMenu, true);
                } else {
                    ap.a(contextMenu, true);
                }
            }
            a.a(contextMenu, Nk);
        }
    }

    public final boolean cO(View view) {
        if (!(view.getTag() instanceof as)) {
            return false;
        }
        n Nk = af.byo().Nk(((as) view.getTag()).bSZ);
        if (Nk == null) {
            return false;
        }
        this.olf.okv.a(view, Nk.bBe(), Nk.bAJ());
        return true;
    }
}
