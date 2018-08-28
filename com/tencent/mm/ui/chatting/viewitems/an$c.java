package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.an.a;
import com.tencent.mm.ui.chatting.viewitems.an.i;

public class an$c extends a {
    public final /* bridge */ /* synthetic */ String b(com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
        return super.b(aVar, bdVar);
    }

    public final /* bridge */ /* synthetic */ boolean bba() {
        return super.bba();
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 50) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new r(layoutInflater, R.i.chatting_item_from_voip);
        view.setTag(new i().dG(view));
        return view;
    }

    public final void a(b.a aVar, int i, com.tencent.mm.ui.chatting.c.a aVar2, bd bdVar, String str) {
        i.a((i) aVar, bdVar, true, i, aVar2, k(aVar2), c(aVar2));
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
