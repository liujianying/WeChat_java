package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.a.m.a;
import com.tencent.mm.plugin.fts.ui.a.m.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public class p$a extends b {
    final /* synthetic */ p jyR;

    public p$a(p pVar) {
        this.jyR = pVar;
        super(pVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_message_item, viewGroup, false);
        a aVar = this.jyR.jyI;
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

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        return ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(this.jyR.hER).a(context, aVar);
    }
}
