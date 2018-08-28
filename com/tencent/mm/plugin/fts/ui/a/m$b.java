package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a$a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.m.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public class m$b extends b {
    final /* synthetic */ m jyJ;

    public m$b(m mVar) {
        this.jyJ = mVar;
        super(mVar);
    }

    public View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(e.fts_message_item, viewGroup, false);
        a aVar = this.jyJ.jyI;
        aVar.eCl = (ImageView) inflate.findViewById(d.avatar_iv);
        aVar.eTm = (TextView) inflate.findViewById(d.nickname_tv);
        aVar.hPq = (TextView) inflate.findViewById(d.msg_tv);
        aVar.hrs = (TextView) inflate.findViewById(d.time_tv);
        aVar.contentView = inflate.findViewById(d.search_item_content_layout);
        inflate.setTag(aVar);
        return inflate;
    }

    public void a(Context context, a$a a_a, com.tencent.mm.plugin.fts.a.d.a.a aVar, Object... objArr) {
        m mVar = (m) aVar;
        a aVar2 = (a) a_a;
        m.h(aVar2.contentView, this.jyJ.jtj);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.eCl, mVar.username);
        m.a(mVar.eCh, aVar2.eTm);
        m.a(mVar.eCi, aVar2.hPq);
        m.a(mVar.jyG, aVar2.hrs);
    }

    public boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        return ((n) g.n(n.class)).getItemClickHandler(this.jyJ.hER).a(context, aVar);
    }
}
