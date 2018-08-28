package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.k.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n$d;
import com.tencent.mm.plugin.fts.ui.n.e;

public class k$b extends b {
    final /* synthetic */ k jyA;

    public k$b(k kVar) {
        this.jyA = kVar;
        super(kVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_header_item, viewGroup, false);
        a aVar = (a) this.jyA.afD();
        aVar.hRY = (TextView) inflate.findViewById(n$d.header_tv);
        aVar.jxR = inflate.findViewById(n$d.padding_view);
        aVar.contentView = inflate.findViewById(n$d.search_item_content_layout);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        a aVar3 = (a) aVar;
        m.a(this.jyA.jyx, aVar3.hRY);
        if (this.jyA.position == 0) {
            aVar3.jxR.setVisibility(8);
        } else {
            aVar3.jxR.setVisibility(0);
        }
        m.i(aVar3.contentView, this.jyA.jtj);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        return false;
    }
}
