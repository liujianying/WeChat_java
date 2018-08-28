package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.c.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n$d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.g;

public class c$b extends b {
    final /* synthetic */ c jxK;

    public c$b(c cVar) {
        this.jxK = cVar;
        super(cVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_collapse_more_item, viewGroup, false);
        a aVar = this.jxK.jxH;
        aVar.jxI = (TextView) inflate.findViewById(n$d.more_tv);
        aVar.jxJ = (ImageView) inflate.findViewById(n$d.more_arrow);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        a aVar3 = (a) aVar;
        c cVar = (c) aVar2;
        Resources resources = context.getResources();
        if (this.jxK.jxF) {
            m.a(resources.getString(g.search_more_contact, new Object[]{resources.getString(cVar.jxE)}), aVar3.jxI);
            aVar3.jxJ.setRotation(0.0f);
            return;
        }
        m.a(resources.getString(g.search_more_contact_collapse), aVar3.jxI);
        aVar3.jxJ.setRotation(180.0f);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        return false;
    }
}
