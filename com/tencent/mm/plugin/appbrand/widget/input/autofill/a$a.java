package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s$g;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a;
import com.tencent.mm.plugin.appbrand.widget.input.c.a.b;

final class a$a implements OnClickListener {
    View SU;
    View eCO;
    final /* synthetic */ a gJP;
    TextView gJQ;
    TextView gJR;
    View gJS;
    b gJT;

    a$a(a aVar, View view) {
        this.gJP = aVar;
        this.SU = view;
        this.gJQ = (TextView) view.findViewById(s$g.title);
        this.gJR = (TextView) view.findViewById(s$g.content);
        this.gJS = view.findViewById(s$g.close);
        this.eCO = view.findViewById(s$g.divider);
        view.setBackgroundResource(f.popup_menu_selector);
        view.setOnClickListener(this);
        this.gJS.setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (this.gJT == null) {
            return;
        }
        if (view.getId() == s$g.close) {
            this.gJP.remove(this.gJT);
            if (a.a(this.gJP) != null) {
                a.a(this.gJP).a(this.gJT.id, a.gKz);
            }
        } else if (view == this.SU && a.a(this.gJP) != null) {
            if (this.gJT != null) {
                a.a(this.gJP).a(this.gJT.id, a.gKA);
            }
            a.c(this.gJP);
            if (a.d(this.gJP) != null) {
                a.d(this.gJP).gJU.getView().clearFocus();
            }
        }
    }
}
