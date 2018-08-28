package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.a.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.f;

public class a$b extends b {
    final /* synthetic */ a jxz;

    public a$b(a aVar) {
        this.jxz = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_search_contact_item, viewGroup, false);
        a aVar = new a(this.jxz);
        aVar.gmn = (ImageView) inflate.findViewById(d.icon_iv);
        aVar.jxy = (TextView) inflate.findViewById(d.tip_tv);
        aVar.contentView = inflate.findViewById(d.search_item_content_layout);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        a aVar3 = (a) aVar;
        m.h(aVar3.contentView, this.jxz.jtj);
        m.a(this.jxz.jxv, aVar3.jxy);
        aVar3.gmn.setImageResource(f.search_add_icon_green);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        return false;
    }
}
