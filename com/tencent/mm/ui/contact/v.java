package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.ui.base.MaskLayout;

public final class v extends LinearLayout {
    private Context context;
    private String uld;

    public v(Context context, String str) {
        super(context);
        this.context = context;
        this.uld = str;
        View inflate = View.inflate(getContext(), R.i.openim_item_in_addressui_header, this);
        View findViewById = findViewById(R.h.enterprise_biz_item_ll);
        inflate.setOnClickListener(new 1(this));
        findViewById.setOnTouchListener(new 2(this));
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.h.biz_contact_entrance_avatar_iv);
        String h = ((b) g.l(b.class)).h(this.uld, "openim_acct_type_icon", a.euj);
        if (h != null) {
            ImageView imageView = (ImageView) maskLayout.getContentView();
            c.a aVar = new c.a();
            aVar.dXy = true;
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            aVar.dXA = stringBuilder.append(g.Ei().dqp).append("openim/").append(com.tencent.mm.a.g.u(h.getBytes())).toString();
            o.Pj().a(h, imageView, aVar.Pt(), null, null);
        }
        ((TextView) findViewById(R.h.enterprise_biz_title)).setText(((b) g.l(b.class)).h(this.uld, "openim_acct_type_title", a.eui));
    }
}
