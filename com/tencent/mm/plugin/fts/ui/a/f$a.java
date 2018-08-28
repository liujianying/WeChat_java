package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a$b;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.a.f.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.sdk.platformtools.bi;

public class f$a extends a$b {
    final /* synthetic */ f jxZ;

    public f$a(f fVar) {
        this.jxZ = fVar;
        super(fVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_conv_talker_header_item, viewGroup, false);
        b bVar = this.jxZ.jxY;
        bVar.jya = (TextView) inflate.findViewById(d.header_1_tv);
        bVar.jyb = (ImageView) inflate.findViewById(d.avatar_1_iv);
        bVar.jyc = (TextView) inflate.findViewById(d.header_2_tv);
        bVar.jyd = (ImageView) inflate.findViewById(d.avatar_2_iv);
        bVar.jye = (TextView) inflate.findViewById(d.info_tv);
        bVar.contentView = inflate.findViewById(d.search_item_content_layout);
        bVar.jxR = inflate.findViewById(d.padding_view);
        inflate.setTag(bVar);
        return inflate;
    }

    public void a(Context context, a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        b bVar = (b) aVar;
        m.a(this.jxZ.jxS, bVar.jya);
        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.jyb, this.jxZ.jxT);
        m.a(this.jxZ.jxU, bVar.jyc);
        if (bi.oW(this.jxZ.jxV)) {
            bVar.jyd.setVisibility(8);
        } else {
            bVar.jyd.setVisibility(0);
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.jyd, this.jxZ.jxV);
        }
        m.i(bVar.contentView, this.jxZ.jtj);
        if (this.jxZ.position == 0) {
            bVar.jxR.setVisibility(8);
        } else {
            bVar.jxR.setVisibility(0);
        }
        bVar.jye.setVisibility(0);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        return false;
    }
}
