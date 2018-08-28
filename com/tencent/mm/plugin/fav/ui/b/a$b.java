package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.fav.ui.b.a.a;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.ui.MMImageView;

public class a$b extends com.tencent.mm.plugin.fts.a.d.a.a$b {
    final /* synthetic */ a jek;

    public a$b(a aVar) {
        this.jek = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(f.fts_favorite_item, viewGroup, false);
        a aVar = this.jek.jeg;
        aVar.jeh = (MMImageView) inflate.findViewById(e.avatar_iv);
        aVar.eCm = (TextView) inflate.findViewById(e.title_tv);
        aVar.jei = (TextView) inflate.findViewById(e.abstract_tv);
        aVar.jej = (TextView) inflate.findViewById(e.status_tv);
        aVar.contentView = inflate.findViewById(e.search_item_content_layout);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        a aVar3 = (a) aVar;
        a aVar4 = (a) aVar2;
        m.h(aVar3.contentView, this.jek.jtj);
        m.a(context, aVar3.jeh, aVar4.eTp, aVar4.jed, aVar4.jee, false, aVar3.jeh.getMeasuredWidth(), aVar3.jeh.getMeasuredHeight());
        a.a(aVar3.eCm, aVar3.jei, this.jek.jea, this.jek.jeb);
        m.a(this.jek.jec, aVar3.jej);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        a aVar2 = (a) aVar;
        fz fzVar = new fz();
        fzVar.bOL.type = 10;
        fzVar.bOL.bJA = aVar2.fyJ.jsA;
        fzVar.bOL.context = context;
        fzVar.bOL.bOW = new wn();
        if (this.jek.pageType == 1) {
            fzVar.bOL.bOW.scene = 3;
        } else {
            fzVar.bOL.bOW.scene = 4;
        }
        fzVar.bOL.bOW.iVT = 3;
        fzVar.bOL.bOW.index = this.jek.jtm;
        com.tencent.mm.sdk.b.a.sFg.m(fzVar);
        return true;
    }
}
