package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a$b;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public class l$b extends a$b {
    final /* synthetic */ l jyE;

    public l$b(l lVar) {
        this.jyE = lVar;
        super(lVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_info_item, viewGroup, false);
        l$a l_a = (l$a) this.jyE.jyD;
        l_a.jye = (TextView) inflate.findViewById(d.info_tv);
        l_a.jxR = inflate.findViewById(d.padding_view);
        inflate.setTag(l_a);
        return inflate;
    }

    public final void a(Context context, a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        l$a l_a = (l$a) aVar;
        m.a(this.jyE.jyB, l_a.jye);
        if (this.jyE.position == 0) {
            l_a.jxR.setVisibility(8);
        } else {
            l_a.jxR.setVisibility(0);
        }
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        return false;
    }
}
