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
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.platformtools.bi;

public final class f extends a {
    private final int jeu;

    public f(k kVar) {
        super(kVar);
        this.jeu = a.ad(kVar.context, c.FavIconSize);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, com.tencent.mm.plugin.fav.ui.m.f.fav_listitem_appmsg, null), aVar, gVar);
            aVar.gmn = (ImageView) view.findViewById(e.fav_icon);
            aVar.eCm = (TextView) view.findViewById(e.fav_title);
            aVar.eCn = (TextView) view.findViewById(e.fav_desc);
            aVar.jet = (TextView) view.findViewById(e.fav_source);
            aVar.jet.setVisibility(8);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        wk wkVar = gVar.field_favProto.rAP;
        aVar.eCm.setText(bi.oV(wkVar.title));
        aVar.eCn.setText(bi.oV(wkVar.desc));
        aVar.eCm.setSingleLine(false);
        aVar.eCm.setMaxLines(2);
        this.iYh.a(aVar.gmn, null, gVar, h.app_attach_file_icon_unknow, this.jeu, this.jeu);
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
