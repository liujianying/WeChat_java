package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;

public class g$b extends b {
    final /* synthetic */ g umN;

    public g$b(g gVar) {
        this.umN = gVar;
        super(gVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(f.select_ui_listheaderitem, viewGroup, false);
        g$a g_a = this.umN.umM;
        g_a.hRY = (TextView) inflate.findViewById(e.header_tv);
        inflate.setTag(g_a);
        return inflate;
    }

    public final void a(Context context, a aVar, a aVar2, boolean z, boolean z2) {
        m.a(((g) aVar2).jyx, ((g$a) aVar).hRY);
    }

    public final boolean Wi() {
        return false;
    }
}
