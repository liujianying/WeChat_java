package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.an.b;
import com.tencent.mm.ui.chatting.viewitems.an.i;
import com.tencent.mm.ui.chatting.viewitems.b.a;

public class an$g extends b {
    public final /* bridge */ /* synthetic */ boolean bba() {
        return super.bba();
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 50) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_voip);
        rVar.setTag(new i().dG(rVar));
        return rVar;
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.c.a aVar2, bd bdVar, String str) {
        i.a((i) aVar, bdVar, false, i, aVar2, k(aVar2), c(aVar2));
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
        return false;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
        return false;
    }
}
