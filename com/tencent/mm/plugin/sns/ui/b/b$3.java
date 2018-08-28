package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.a.a.c;

class b$3 extends c {
    final /* synthetic */ b olf;

    b$3(b bVar) {
        this.olf = bVar;
    }

    public final boolean cO(View view) {
        if (!(view.getTag() instanceof c) && !(view.getTag() instanceof n)) {
            return false;
        }
        n Nk;
        Object tag = view.getTag();
        if (tag instanceof c) {
            Nk = h.Nk(((c) view.getTag()).bSZ);
        } else if (tag instanceof n) {
            Nk = (n) tag;
        } else {
            Nk = null;
        }
        if (Nk != null) {
            this.olf.okv.a(view, Nk.bBe(), Nk.bAJ());
        }
        return true;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        Object tag = view.getTag();
        if ((tag instanceof c) || (tag instanceof n)) {
            n Nk;
            if (tag instanceof c) {
                Nk = h.Nk(((c) tag).bSZ);
            } else if (tag instanceof n) {
                Nk = (n) tag;
            } else {
                Nk = null;
            }
            if (d.QS("favorite")) {
                b bAF = Nk.bAF();
                a bAH = Nk.bAH();
                if (bAF.bzq()) {
                    if (bAF.bzm()) {
                        contextMenu.add(0, 2, 0, view.getContext().getString(j.plugin_favorite_opt));
                    } else if (bAH.nxV == 0) {
                        contextMenu.add(0, 3, 0, view.getContext().getString(j.plugin_favorite_opt));
                    }
                }
                dj djVar = new dj();
                djVar.bLf.bKW = Nk.bBe();
                com.tencent.mm.sdk.b.a.sFg.m(djVar);
                if (djVar.bLg.bKE) {
                    contextMenu.add(0, 18, 0, view.getContext().getString(j.app_open));
                }
            }
            if (Nk != null) {
                com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Nk);
            }
        }
    }
}
