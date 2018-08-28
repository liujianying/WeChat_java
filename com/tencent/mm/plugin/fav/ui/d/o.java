package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.c;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;

public final class o extends a {
    private final int jeu;

    public o(k kVar) {
        super(kVar);
        this.jeu = a.ad(kVar.context, c.FavIconSize);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, f.fav_listitem_appmsg, null), aVar, gVar);
            aVar.gmn = (ImageView) view.findViewById(e.fav_icon);
            aVar.eCm = (TextView) view.findViewById(e.fav_title);
            aVar.eCm.setMaxLines(2);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        vx c = com.tencent.mm.plugin.fav.a.b.c(gVar);
        xa xaVar = gVar.field_favProto.rAN;
        TextView textView = aVar.eCm;
        vx c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
        CharSequence charSequence = "";
        if (xaVar != null) {
            charSequence = xaVar.title;
        }
        if (bi.oW(charSequence) && c2 != null) {
            charSequence = c2.title;
        }
        if (bi.oW(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
        int Sz = com.tencent.mm.pluginsdk.c.Sz(c.rzD);
        k kVar = this.iYh;
        ImageView imageView = aVar.gmn;
        if (Sz == com.tencent.mm.pluginsdk.c.cbi()) {
            Sz = h.app_attach_file_icon_webpage;
        }
        kVar.a(imageView, c, gVar, Sz, this.jeu, this.jeu);
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
