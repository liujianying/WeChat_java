package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.b.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public abstract class b$b extends b {
    final /* synthetic */ b jxD;

    public b$b(b bVar) {
        this.jxD = bVar;
        super(bVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_contact_item, viewGroup, false);
        a aVar = this.jxD.jxB;
        aVar.eCl = (ImageView) inflate.findViewById(d.avatar_iv);
        aVar.eCm = (TextView) inflate.findViewById(d.title_tv);
        aVar.eCn = (TextView) inflate.findViewById(d.desc_tv);
        aVar.jxC = (TextView) inflate.findViewById(d.item_desc_tv);
        aVar.contentView = inflate.findViewById(d.search_item_content_layout);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        a aVar3 = (a) aVar;
        b bVar = (b) aVar2;
        m.h(aVar3.contentView, this.jxD.jtj);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, bVar.username);
        m.a(bVar.hqx, aVar3.eCm);
        m.a(bVar.hqy, aVar3.eCn);
        m.a(bVar.jxA, aVar3.jxC);
    }
}
