package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.wn;

public final class m extends a {

    public static class a extends b {
        TextView hPq;
    }

    public m(k kVar) {
        super(kVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar = new a();
            view = a(View.inflate(context, f.fav_listitem_text, null), aVar, gVar);
            aVar.hPq = (TextView) view.findViewById(e.fav_text);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, gVar);
        if (gVar.field_favProto.desc == null || gVar.field_favProto.desc.length() <= 0) {
            bVar2.hPq.setText("");
        } else {
            bVar2.hPq.setText(j.a(bVar2.hPq.getContext(), gVar.field_favProto.desc, bVar2.hPq.getTextSize()));
        }
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
