package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.ao.d;
import com.tencent.mm.ui.chatting.viewitems.b.a;

public class ao$c extends b {
    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == -1879048188) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = layoutInflater.inflate(R.i.chatting_item_voip_notify, null);
        view.setTag(new d().dG(view));
        return view;
    }

    protected final boolean cxM() {
        return false;
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.c.a aVar2, bd bdVar, String str) {
        aVar.hrs.setVisibility(0);
        aVar.hrs.setText(h.o(aVar2.tTq.getContext(), bdVar.field_createTime));
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
