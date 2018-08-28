package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.c;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.protocal.c.wn;

public final class d extends a {
    private static int jeu;

    public d(k kVar) {
        super(kVar);
        jeu = a.ad(kVar.context, c.FavImageSize);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar = new a();
            view = a(View.inflate(context, f.fav_listitem_image, null), aVar, gVar);
            aVar.jev = (ImageView) view.findViewById(e.fav_image);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, gVar);
        k.a(bVar2.jev, h.fav_list_img_default, com.tencent.mm.plugin.fav.a.b.c(gVar), gVar, false, jeu, jeu);
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
