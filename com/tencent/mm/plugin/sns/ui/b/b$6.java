package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.sns.abtest.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.bsu;

class b$6 extends c {
    final /* synthetic */ b olf;

    b$6(b bVar) {
        this.olf = bVar;
    }

    public final boolean cO(View view) {
        String str;
        Object tag = view.getTag();
        if (tag instanceof ap) {
            str = ((ap) tag).bNH;
        } else if (tag instanceof r) {
            str = ((r) tag).bKW;
        } else {
            str = null;
        }
        if (str == null) {
            return false;
        }
        this.olf.okv.a(view, str, af.byo().Nl(str).bAJ());
        return true;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        String str;
        Object tag = view.getTag();
        if (tag instanceof ap) {
            str = ((ap) tag).bNH;
        } else if (tag instanceof r) {
            str = ((r) tag).bKW;
        } else {
            str = null;
        }
        if (str != null) {
            n Nl = af.byo().Nl(str);
            bsu bAJ = Nl.bAJ();
            if (d.QS("favorite")) {
                switch (bAJ.sqc.ruz) {
                    case 1:
                        contextMenu.add(0, 2, 0, view.getContext().getString(j.plugin_favorite_opt));
                        break;
                    case 15:
                        contextMenu.add(0, 10, 0, view.getContext().getString(j.plugin_favorite_opt));
                        break;
                }
            }
            a.a(contextMenu, Nl);
        }
    }
}
