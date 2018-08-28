package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.f.d.a;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.sdk.platformtools.bi;

public class d$b extends b {
    final /* synthetic */ d fyQ;

    public d$b(d dVar) {
        this.fyQ = dVar;
        super(dVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(h.app_brand_fts_weapp_item, viewGroup, false);
        a aVar = this.fyQ.fyN;
        aVar.eCl = (ImageView) inflate.findViewById(g.avatar_iv);
        aVar.eCm = (TextView) inflate.findViewById(g.title_tv);
        aVar.contentView = inflate.findViewById(g.search_item_content_layout);
        aVar.fyO = (TextView) inflate.findViewById(g.secondary_text);
        aVar.fyP = (TextView) inflate.findViewById(g.tag_text);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        d dVar = (d) aVar2;
        a aVar3 = (a) aVar;
        if (dVar.fyK == null) {
            aVar3.contentView.setVisibility(8);
            return;
        }
        aVar3.contentView.setVisibility(0);
        aVar3.eCm.setText(this.fyQ.fyL);
        CharSequence jB = com.tencent.mm.plugin.appbrand.appcache.a.jB(this.fyQ.fyK.fig);
        if (bi.oW(jB)) {
            aVar3.fyP.setVisibility(8);
        } else {
            aVar3.fyP.setText(jB);
            aVar3.fyP.setVisibility(0);
        }
        com.tencent.mm.modelappbrand.b.b.Ka().a(aVar3.eCl, dVar.fyK.fmb, com.tencent.mm.modelappbrand.b.a.JZ(), f.dGr);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        d dVar = (d) aVar;
        qu quVar = new qu();
        quVar.cbq.userName = dVar.fyK.bGy;
        quVar.cbq.cbt = dVar.fyK.fig;
        quVar.cbq.cbx = true;
        quVar.cbq.scene = 1027;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        return true;
    }
}
