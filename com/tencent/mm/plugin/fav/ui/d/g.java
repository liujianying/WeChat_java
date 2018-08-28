package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.c;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wn;
import java.util.HashSet;
import java.util.Set;

public final class g extends a {
    private final int jeu;
    private Set<ImageView> jew;
    private OnClickListener jex = new 1(this);

    public g(k kVar) {
        super(kVar);
        this.jeu = a.ad(kVar.context, c.FavIconSize);
        this.jew = new HashSet();
    }

    public final View a(View view, ViewGroup viewGroup, com.tencent.mm.plugin.fav.a.g gVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar = new a();
            view = a(View.inflate(context, f.fav_listitem_appmsg, null), aVar, gVar);
            aVar.gmn = (ImageView) view.findViewById(e.fav_icon);
            aVar.eCm = (TextView) view.findViewById(e.fav_title);
            aVar.eCn = (TextView) view.findViewById(e.fav_desc);
            aVar.jez = (ImageView) view.findViewById(e.fav_icon_mask);
            aVar.jet = (TextView) view.findViewById(e.fav_source);
            aVar.jet.setVisibility(8);
            aVar.jez.setOnClickListener(this.jex);
            aVar.jez.setVisibility(0);
            this.jew.add(aVar.jez);
            bVar = aVar;
        } else {
            bVar = (a) view.getTag();
        }
        a(bVar, gVar);
        vx c = com.tencent.mm.plugin.fav.a.b.c(gVar);
        bVar.eCm.setText(c.title);
        bVar.eCn.setText(c.desc);
        this.iYh.a(bVar.gmn, c, gVar, h.app_attach_file_icon_music, this.jeu, this.jeu);
        bVar.jez.setTag(gVar);
        if (com.tencent.mm.plugin.fav.a.b.e(c)) {
            bVar.jez.setImageResource(d.music_pauseicon);
        } else {
            bVar.jez.setImageResource(d.music_playicon);
        }
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
