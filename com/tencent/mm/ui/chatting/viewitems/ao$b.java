package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.viewitems.ao.d;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.chatting.viewitems.b.c;

public class ao$b extends ao$a {
    public final boolean aq(int i, boolean z) {
        if (i == -1879048187) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_voip);
        rVar.setTag(new d().dG(rVar));
        return rVar;
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.c.a aVar2, bd bdVar, String str) {
        d dVar = (d) aVar;
        c c = c(aVar2);
        if (dVar != null) {
            dVar.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
            dVar.hrH.setOnLongClickListener(c);
            dVar.hrH.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
        }
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
