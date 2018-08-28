package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.f;
import com.tencent.mm.sdk.platformtools.bi;

public class i$b extends b {
    final /* synthetic */ i jyq;

    public i$b(i iVar) {
        this.jyq = iVar;
        super(iVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_create_talker_message_item, viewGroup, false);
        i$a i_a = new i$a(this.jyq);
        i_a.jxy = (TextView) inflate.findViewById(d.tip_tv);
        i_a.gmn = (ImageView) inflate.findViewById(d.icon_iv);
        i_a.jxR = inflate.findViewById(d.padding_view);
        i_a.contentView = inflate.findViewById(d.search_item_content_layout);
        inflate.setTag(i_a);
        return inflate;
    }

    public final void a(Context context, a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        i$a i_a = (i$a) aVar;
        i iVar = (i) aVar2;
        m.h(i_a.contentView, this.jyq.jtj);
        i_a.jxy.setText(iVar.jyn);
        i_a.gmn.setImageResource(f.fts_more_button_icon);
        if (this.jyq.position == 0 || !this.jyq.jym) {
            i_a.jxR.setVisibility(8);
        } else {
            i_a.jxR.setVisibility(0);
        }
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("key_talker_query", this.jyq.jrx.jrY[0]);
        intent.putExtra("key_query", this.jyq.jrx.jrY[1]);
        intent.putExtra("Search_Scene", this.jyq.jsZ);
        if (bi.oW(this.jyq.jso)) {
            com.tencent.mm.plugin.fts.a.d.b(context, ".ui.FTSTalkerMessageUI", intent);
        } else {
            intent.putExtra("key_conv", this.jyq.jso);
            intent.putExtra("detail_type", 1);
            com.tencent.mm.plugin.fts.a.d.b(context, ".ui.FTSConvTalkerMessageUI", intent);
        }
        return true;
    }
}
