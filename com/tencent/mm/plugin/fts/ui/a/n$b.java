package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.a.n.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n$d;
import com.tencent.mm.plugin.fts.ui.n$f;
import com.tencent.mm.plugin.fts.ui.n.e;

public class n$b extends b {
    final /* synthetic */ n jyN;

    public n$b(n nVar) {
        this.jyN = nVar;
        super(nVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_more_item, viewGroup, false);
        a aVar = new a(this.jyN);
        aVar.jxy = (TextView) inflate.findViewById(n$d.tip_tv);
        aVar.gmn = (ImageView) inflate.findViewById(n$d.icon_iv);
        aVar.contentView = inflate.findViewById(n$d.search_item_content_layout);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        a aVar3 = (a) aVar;
        n nVar = (n) aVar2;
        m.h(aVar3.contentView, this.jyN.jtj);
        aVar3.jxy.setText(nVar.jyK);
        aVar3.gmn.setImageResource(n$f.fts_more_button_icon);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("detail_query", this.jyN.jrx.jrV);
        intent.putExtra("detail_type", this.jyN.jtk);
        intent.putExtra("Search_Scene", this.jyN.jsZ);
        d.b(context, ".ui.FTSDetailUI", intent);
        return true;
    }
}
