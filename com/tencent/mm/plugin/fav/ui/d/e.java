package com.tencent.mm.plugin.fav.ui.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.platformtools.bi;

public final class e extends a {
    public e(k kVar) {
        super(kVar);
    }

    @SuppressLint({"ResourceType"})
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar = new a();
            view = a(View.inflate(context, f.fav_listitem_comm_card, null), aVar, gVar);
            aVar.gmn = (ImageView) view.findViewById(com.tencent.mm.plugin.fav.ui.m.e.fav_icon);
            aVar.eCm = (TextView) view.findViewById(com.tencent.mm.plugin.fav.ui.m.e.fav_title);
            aVar.eCn = (TextView) view.findViewById(com.tencent.mm.plugin.fav.ui.m.e.fav_detail);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, gVar);
        bVar2.gmn.setImageResource(h.app_attach_file_icon_location);
        we weVar = gVar.field_favProto.rAL;
        CharSequence charSequence = gVar.field_favProto.fky;
        if (!bi.oW(charSequence)) {
            bVar2.eCm.setText(j.a(bVar2.eCm.getContext(), charSequence, bVar2.eCm.getTextSize()));
            if (com.tencent.mm.plugin.fav.ui.j.BC(weVar.bWB)) {
                bVar2.eCn.setText(weVar.bWB);
                return view;
            }
        } else if (com.tencent.mm.plugin.fav.ui.j.BC(weVar.bWB)) {
            bVar2.eCm.setText(weVar.bWB);
        } else {
            bVar2.eCm.setText(weVar.label);
            bVar2.eCn.setVisibility(8);
            return view;
        }
        bVar2.eCn.setText(weVar.label);
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
