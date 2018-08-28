package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.contact.a.f.a;

public class f$b extends b {
    final /* synthetic */ f umK;

    public f$b(f fVar) {
        this.umK = fVar;
        super(fVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(f.select_ui_listcreatechatroomitem, viewGroup, false);
        a aVar = (a) this.umK.umI;
        aVar.eCn = (TextView) inflate.findViewById(e.desc_tv);
        aVar.umJ = inflate.findViewById(e.header_diviver_view);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
        a aVar3 = (a) aVar;
        m.a(f.a((f) aVar2), aVar3.eCn);
        if (this.umK.position == 0) {
            aVar3.umJ.setVisibility(8);
        } else {
            aVar3.umJ.setVisibility(0);
        }
    }

    public final boolean Wi() {
        return false;
    }
}
