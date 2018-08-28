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
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m$e;
import com.tencent.mm.plugin.fav.ui.m$f;
import com.tencent.mm.plugin.fav.ui.m.c;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wn;
import java.util.LinkedList;

public final class p extends a {
    final int jeu;

    public p(k kVar) {
        super(kVar);
        this.jeu = a.ad(kVar.context, c.FavImageSize);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, m$f.fav_listitem_shortview, null), aVar, gVar);
            aVar.jev = (ImageView) view.findViewById(m$e.fav_image);
            aVar.jeY = (TextView) view.findViewById(m$e.fav_video_duration);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jeY.setVisibility(0);
        LinkedList linkedList = gVar.field_favProto.rBI;
        if (linkedList.size() > 0) {
            aVar.jeY.setText(i.v(context, ((vx) linkedList.getFirst()).duration));
        } else {
            aVar.jeY.setText("");
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
