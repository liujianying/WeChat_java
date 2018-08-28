package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.ui.contact.a.a.b;

public class a$b extends b {
    final /* synthetic */ a tEf;

    public a$b(a aVar) {
        this.tEf = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate;
        if (a.fi(context)) {
            inflate = LayoutInflater.from(context).inflate(f.select_ui_listcontactitem_large, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(context).inflate(f.select_ui_listcontactitem, viewGroup, false);
        }
        a.a aVar = this.tEf.tEe;
        aVar.eCl = (ImageView) inflate.findViewById(e.avatar_iv);
        aVar.eTm = (TextView) inflate.findViewById(e.title_tv);
        aVar.eCn = (TextView) inflate.findViewById(e.desc_tv);
        aVar.eCn.setVisibility(8);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
        a aVar3 = (a) aVar2;
        a.a aVar4 = (a.a) aVar;
        m.a(aVar3.eCh, aVar4.eTm);
        o.Pj().a(aVar3.tEb, aVar4.eCl, a.aae(aVar3.username));
    }

    public final boolean Wi() {
        return false;
    }
}
