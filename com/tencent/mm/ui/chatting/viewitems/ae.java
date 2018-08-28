package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.storage.bd;

public final class ae extends b {
    private af udP = new af();
    private ac udQ = new ac();
    private ag udR = new ag();
    private ap udS = new ap();

    interface a {
        void b(b$a b_a, int i, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar);
    }

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == 10000 || i == 10002 || i == 570425393 || i == 64 || i == 603979825) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = layoutInflater.inflate(R.i.chatting_item_system, null);
        b bVar = new b(this);
        bVar.jEz = view;
        bVar.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        bVar.ucQ = (TextView) view.findViewById(R.h.chatting_content_itv);
        view.setTag(bVar);
        return view;
    }

    public final void a(b$a b_a, int i, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar, String str) {
        a aVar2;
        if (bdVar.getType() == 10002) {
            aVar2 = this.udQ;
        } else if (bdVar.getType() == 570425393) {
            aVar2 = this.udR;
        } else if (bdVar.getType() == 603979825) {
            aVar2 = this.udS;
        } else {
            aVar2 = this.udP;
        }
        aVar2.b(b_a, i, aVar, bdVar);
    }

    protected final boolean cxM() {
        return false;
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
