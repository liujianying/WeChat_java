package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;

public class i$b extends b {
    final /* synthetic */ i umS;

    public i$b(i iVar) {
        this.umS = iVar;
        super(iVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(f.select_ui_listmoreitem, viewGroup, false);
        i$a i_a = (i$a) this.umS.umP;
        i_a.jxI = (TextView) inflate.findViewById(e.more_tv);
        i_a.jxJ = (ImageView) inflate.findViewById(e.more_arrow);
        inflate.setTag(i_a);
        return inflate;
    }

    public final void a(Context context, a aVar, a aVar2, boolean z, boolean z2) {
        i$a i_a = (i$a) aVar;
        i iVar = (i) aVar2;
        Resources resources = context.getResources();
        if (this.umS.jxF) {
            m.a(resources.getString(h.search_more_contact, new Object[]{resources.getString(iVar.jxE)}), i_a.jxI);
            i_a.jxJ.setRotation(0.0f);
            return;
        }
        m.a(resources.getString(h.search_more_contact_collapse), i_a.jxI);
        i_a.jxJ.setRotation(180.0f);
    }

    public final boolean Wi() {
        return false;
    }
}
