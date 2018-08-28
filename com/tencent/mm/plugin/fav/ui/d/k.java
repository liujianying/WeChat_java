package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.m.c;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wn;
import java.util.HashSet;
import java.util.LinkedList;

public final class k extends a {
    private HashSet<Long> jeW = new HashSet();
    final int jeu;

    public k(com.tencent.mm.plugin.fav.ui.k kVar) {
        super(kVar);
        this.jeu = a.ad(kVar.context, c.FavImageSize);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, f.fav_listitem_shortview, null), aVar, gVar);
            aVar.jev = (ImageView) view.findViewById(e.fav_image);
            aVar.jeY = (TextView) view.findViewById(e.fav_video_duration);
        } else {
            aVar = (a) view.getTag();
        }
        LinkedList linkedList = gVar.field_favProto.rBI;
        if (linkedList.size() > 0) {
            int i = ((vx) linkedList.getFirst()).duration;
            aVar.jeY.setText(i.v(context, i));
            if (!(gVar == null || i > 1 || this.jeW.contains(Long.valueOf(gVar.field_localId)))) {
                this.jeW.add(Long.valueOf(gVar.field_localId));
                com.tencent.mm.kernel.g.Em().H(new 1(this, gVar));
            }
            aVar.jeY.setVisibility(0);
        } else {
            aVar.jeY.setVisibility(8);
        }
        a(aVar, gVar);
        this.iYh.a(aVar.jev, b.c(gVar), gVar, h.app_attach_file_icon_video, this.jeu, this.jeu);
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
