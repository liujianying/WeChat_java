package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.a.m.a;
import com.tencent.mm.plugin.fts.ui.a.m.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.n$e;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.sdk.platformtools.bi;

public class g$a extends b {
    final /* synthetic */ g jyh;

    public g$a(g gVar) {
        this.jyh = gVar;
        super(gVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(n$e.fts_message_item, viewGroup, false);
        a aVar = this.jyh.jyI;
        aVar.eCl = (ImageView) inflate.findViewById(d.avatar_iv);
        aVar.eTm = (TextView) inflate.findViewById(d.nickname_tv);
        aVar.hPq = (TextView) inflate.findViewById(d.msg_tv);
        aVar.contentView = inflate.findViewById(d.search_item_content_layout);
        aVar.hrs = (TextView) inflate.findViewById(d.time_tv);
        aVar.eCl.getLayoutParams().width = com.tencent.mm.bp.a.ad(context, n.b.SettingCatalogPadding);
        aVar.eCl.getLayoutParams().height = com.tencent.mm.bp.a.ad(context, n.b.SettingCatalogPadding);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        g gVar = (g) aVar2;
        a aVar3 = (a) aVar;
        m.h(aVar3.contentView, this.jyh.jtj);
        if (bi.oW(gVar.fyJ.talker)) {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, gVar.fyJ.jrv);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, gVar.fyJ.talker);
        }
        m.a(gVar.jyg, aVar3.eTm);
        m.a(gVar.eCi, aVar3.hPq);
        m.a(gVar.jyG, aVar3.hrs);
    }
}
