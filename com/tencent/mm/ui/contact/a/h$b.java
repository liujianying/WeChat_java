package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a$f;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.ui.contact.a.h.a;

public class h$b extends a$b {
    final /* synthetic */ h umQ;

    public h$b(h hVar) {
        this.umQ = hVar;
        super(hVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(a$f.select_ui_listinfoitem, viewGroup, false);
        a aVar = (a) this.umQ.umP;
        aVar.jye = (TextView) inflate.findViewById(e.info_tv);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
        m.a(h.a(this.umQ), ((a) aVar).jye);
    }

    public final boolean Wi() {
        return false;
    }
}
