package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a$a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n$c;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public class e$a extends b {
    final /* synthetic */ e jxQ;

    public e$a(e eVar) {
        this.jxQ = eVar;
        super(eVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_conv_message_header_item, viewGroup, false);
        e.b bVar = this.jxQ.jxP;
        bVar.hRY = (TextView) inflate.findViewById(d.header_tv);
        bVar.contentView = inflate.findViewById(d.search_item_content_layout);
        bVar.jxR = inflate.findViewById(d.padding_view);
        bVar.eCl = (ImageView) inflate.findViewById(d.avatar_iv);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void a(Context context, a$a a_a, a aVar, Object... objArr) {
        e.b bVar = (e.b) a_a;
        m.a(this.jxQ.jyx, bVar.hRY);
        bVar.contentView.setBackgroundResource(n$c.list_thicklinecell_bg);
        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.eCl, this.jxQ.talker);
        if (this.jxQ.position == 0) {
            bVar.jxR.setVisibility(8);
        } else {
            bVar.jxR.setVisibility(0);
        }
    }

    public final boolean a(Context context, a aVar) {
        return false;
    }
}
