package com.tencent.mm.plugin.brandservice.ui;

import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.ab;

class EnterpriseBizContactPlainListUI$a$2 implements Runnable {
    final /* synthetic */ a hpI;

    EnterpriseBizContactPlainListUI$a$2(a aVar) {
        this.hpI = aVar;
    }

    public final void run() {
        this.hpI.WS();
        TextView textView = (TextView) this.hpI.hpF.findViewById(d.enterprist_biz_child_not_found);
        if (!(EnterpriseBizContactPlainListUI.a(this.hpI.hpF) == null || textView == null)) {
            ab Yg = ((i) g.l(i.class)).FR().Yg(EnterpriseBizContactPlainListUI.c(this.hpI.hpF));
            if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                EnterpriseBizContactPlainListUI.a(this.hpI.hpF).setVisibility(8);
                textView.setVisibility(0);
            } else if (EnterpriseBizContactPlainListUI.d(this.hpI.hpF).getCount() <= 0) {
                EnterpriseBizContactPlainListUI.a(this.hpI.hpF).setVisibility(8);
                textView.setVisibility(0);
            } else {
                EnterpriseBizContactPlainListUI.a(this.hpI.hpF).setVisibility(0);
                textView.setVisibility(8);
                EnterpriseBizContactPlainListUI.a(this.hpI.hpF).setAdapter(EnterpriseBizContactPlainListUI.d(this.hpI.hpF));
                EnterpriseBizContactPlainListUI.a(this.hpI.hpF).setOnItemClickListener(EnterpriseBizContactPlainListUI.e(this.hpI.hpF));
            }
        }
        this.hpI.notifyDataSetChanged();
    }
}
