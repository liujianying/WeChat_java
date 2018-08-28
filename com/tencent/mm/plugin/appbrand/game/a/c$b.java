package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.game.a.c.a;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.fts.a.d.a.a$b;
import com.tencent.mm.sdk.platformtools.bi;

public class c$b extends a$b {
    final /* synthetic */ c fAL;

    public c$b(c cVar) {
        this.fAL = cVar;
        super(cVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(h.minigame_fts_item, viewGroup, false);
        a aVar = this.fAL.fAJ;
        aVar.eCl = (ImageView) inflate.findViewById(g.avatar_iv);
        aVar.eCm = (TextView) inflate.findViewById(g.title_tv);
        aVar.contentView = inflate.findViewById(g.search_item_content_layout);
        aVar.fyO = (TextView) inflate.findViewById(g.secondary_text);
        aVar.fAK = (TextView) inflate.findViewById(g.desc_tv);
        aVar.fyP = (TextView) inflate.findViewById(g.tag_text);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        c cVar = (c) aVar2;
        a aVar3 = (a) aVar;
        if (cVar.fAH == null) {
            aVar3.contentView.setVisibility(8);
            return;
        }
        aVar3.contentView.setVisibility(0);
        aVar3.eCm.setText(this.fAL.fyL);
        aVar3.fyP.setVisibility(8);
        aVar3.fAK.setVisibility(8);
        aVar3.fyO.setVisibility(8);
        CharSequence jB;
        if (cVar.fAG != null) {
            jB = com.tencent.mm.plugin.appbrand.appcache.a.jB(cVar.fAG.fig);
            if (bi.oW(jB)) {
                aVar3.fyP.setVisibility(8);
            } else {
                aVar3.fyP.setText(jB);
                aVar3.fyP.setVisibility(0);
            }
        } else {
            jB = cVar.fAH.field_BriefIntro;
            if (bi.oW(jB)) {
                aVar3.fAK.setVisibility(8);
            } else {
                aVar3.fAK.setText(jB);
                aVar3.fAK.setVisibility(0);
            }
        }
        b.Ka().a(aVar3.eCl, cVar.fAH.field_IconUrl, com.tencent.mm.modelappbrand.b.a.JZ(), f.dGr);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        c cVar = (c) aVar;
        qu quVar = new qu();
        quVar.cbq.userName = cVar.fAH.field_UserName;
        quVar.cbq.cbt = 0;
        if (cVar.fAG != null) {
            quVar.cbq.cbt = cVar.fAG.fig;
        }
        quVar.cbq.cbx = true;
        quVar.cbq.scene = 1027;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        return true;
    }
}
