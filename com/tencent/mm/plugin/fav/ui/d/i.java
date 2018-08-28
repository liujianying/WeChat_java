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
import com.tencent.mm.plugin.fav.ui.m$c;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.platformtools.bi;

public final class i extends a {
    private final String jeO;
    private final int jeu;

    public i(k kVar) {
        super(kVar);
        this.jeu = a.ad(kVar.context, m$c.FavIconSize);
        this.jeO = kVar.context.getString(com.tencent.mm.plugin.fav.ui.m.i.favorite_product);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, f.fav_listitem_appmsg, null), aVar, gVar);
            aVar.gmn = (ImageView) view.findViewById(e.fav_icon);
            aVar.eCm = (TextView) view.findViewById(e.fav_title);
            aVar.eCn = (TextView) view.findViewById(e.fav_desc);
            aVar.eCn.setVisibility(8);
            aVar.jet = (TextView) view.findViewById(e.fav_source);
            aVar.jet.setVisibility(0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        aVar.eCm.setText(bi.oV(gVar.field_favProto.rAP.title));
        aVar.jet.setText(bi.aG(com.tencent.mm.plugin.fav.a.b.getAppName(context, gVar.field_favProto.rBG.appId), this.jeO));
        this.iYh.a(aVar.gmn, null, gVar, h.app_attach_file_icon_unknow, this.jeu, this.jeu);
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
