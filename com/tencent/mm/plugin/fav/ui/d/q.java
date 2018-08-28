package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m$e;
import com.tencent.mm.plugin.fav.ui.m$f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.protocal.c.wn;

public final class q extends a {
    public q(k kVar) {
        super(kVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        CharSequence string;
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar = new a();
            view = a(View.inflate(context, m$f.fav_listitem_voice, null), aVar, gVar);
            aVar.eCm = (TextView) view.findViewById(m$e.fav_title);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, gVar);
        int bD = (int) com.tencent.mm.plugin.fav.a.b.bD((long) com.tencent.mm.plugin.fav.a.b.c(gVar).duration);
        TextView textView = bVar2.eCm;
        context = this.iYh.context;
        if (bD <= 0) {
            string = context.getString(i.favorite_voice_length, new Object[]{Integer.valueOf(0)});
        } else {
            string = context.getString(i.favorite_voice_length, new Object[]{Integer.valueOf(bD)});
        }
        textView.setText(string);
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
