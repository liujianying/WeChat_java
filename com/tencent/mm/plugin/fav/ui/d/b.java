package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd.a;

public final class b extends a {
    public b(k kVar) {
        super(kVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        com.tencent.mm.plugin.fav.ui.d.a.b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, f.fav_listitem_appmsg, null), aVar, gVar);
            aVar.gmn = (ImageView) view.findViewById(e.fav_icon);
            aVar.eCm = (TextView) view.findViewById(e.fav_title);
            aVar.eCm.setSingleLine(false);
            aVar.eCm.setMaxLines(2);
            aVar.eCn = (TextView) view.findViewById(e.fav_desc);
            aVar.jet = (TextView) view.findViewById(e.fav_source);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        a GR = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().GR(com.tencent.mm.plugin.fav.a.b.c(gVar).desc);
        if (GR.otZ == null || GR.otZ.length() <= 0) {
            x.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
        }
        if (bi.oW(a(GR))) {
            aVar.eCn.setVisibility(8);
        } else {
            aVar.eCn.setText(a(GR));
        }
        aVar.jet.setText(m.i.favorite_friend_card);
        aVar.jet.setVisibility(0);
        ImageView imageView = aVar.gmn;
        String str = GR.otZ;
        if (bi.oW(str)) {
            imageView.setImageResource(d.default_avatar);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        }
        return view;
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }

    private static String a(a aVar) {
        Object obj;
        Object obj2 = 1;
        Object obj3 = null;
        String str = aVar.cCR;
        if (bi.oW(str)) {
            str = aVar.otZ;
            if (ab.XT(str) || s.hd(str)) {
                obj3 = 1;
            }
            obj = obj3;
        } else {
            obj = null;
        }
        if (obj != null || ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yc(str)) {
            obj2 = obj;
        }
        return (obj2 != null || s.gU(aVar.pOR)) ? "" : str;
    }
}
