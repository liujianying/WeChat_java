package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.platformtools.bi;

public final class c extends a {
    public c(k kVar) {
        super(kVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar = new a();
            view = a(View.inflate(context, f.fav_listitem_comm_card, null), aVar, gVar);
            aVar.gmn = (ImageView) view.findViewById(e.fav_icon);
            aVar.eCm = (TextView) view.findViewById(e.fav_title);
            aVar.eCn = (TextView) view.findViewById(e.fav_detail);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, gVar);
        vx c = com.tencent.mm.plugin.fav.a.b.c(gVar);
        CharSequence charSequence = gVar.field_favProto.title;
        if (bi.oW(charSequence)) {
            charSequence = c.title;
        }
        bVar2.eCm.setText(charSequence);
        bVar2.eCn.setText(com.tencent.mm.plugin.fav.a.b.aj((float) c.rzJ));
        if (c.rAw == 2) {
            bVar2.eCn.setText(">25MB");
        }
        bVar2.gmn.setImageResource(com.tencent.mm.plugin.fav.ui.c.Bx(c.rzD));
        return view;
    }

    public final void a(View view, wn wnVar) {
        g gVar = ((a) view.getTag()).iWQ;
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), gVar, wnVar);
    }
}
