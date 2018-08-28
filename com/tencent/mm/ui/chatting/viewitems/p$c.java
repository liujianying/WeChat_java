package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.p.a;
import com.tencent.mm.ui.chatting.viewitems.p.f;
import com.tencent.mm.ui.chatting.viewitems.p.g;
import com.tencent.mm.ui.chatting.viewitems.p.h;
import com.tencent.mm.ui.chatting.viewitems.p.i;
import java.util.ArrayList;
import java.util.List;

class p$c extends b$a {
    LinearLayout hrw;
    List<a> hrz = new ArrayList();
    TextView tZU;
    f ubM = new f();
    h ubN = new h();
    p$e ubO = new p$e();
    i ubP = new i();
    p$d ubQ = new p$d();
    g ubR = new g();

    p$c() {
    }

    public final b$a dF(View view) {
        ViewGroup viewGroup = this.hrw;
        a aVar = new a();
        aVar.hri = view;
        aVar.hrj = view.findViewById(R.h.top_line);
        aVar.hrk = view.findViewById(R.h.content_ll);
        aVar.eGX = (TextView) view.findViewById(R.h.title);
        aVar.hrm = (TextView) view.findViewById(R.h.summary);
        aVar.hrn = view.findViewById(R.h.cover_area);
        aVar.hro = (ImageView) view.findViewById(R.h.cover);
        aVar.hrp = (ImageView) view.findViewById(R.h.play_icon);
        viewGroup.addView(view, viewGroup.getChildCount());
        this.hrz.add(aVar);
        return this;
    }
}
