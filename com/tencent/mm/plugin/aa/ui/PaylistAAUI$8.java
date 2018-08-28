package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.aa.ui.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.y;

class PaylistAAUI$8 implements a {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$8(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final void We() {
        int i;
        int i2 = i.urge_aa_confirm_msg;
        if (s.fq(PaylistAAUI.a(this.eEl))) {
            i = i2;
        } else {
            i = i.urge_aa_confirm_msg_single;
        }
        e.a aVar = new e.a(this.eEl);
        aVar.abz(this.eEl.getString(i.urge_aa_confirm_msg_title));
        View inflate = y.gq(this.eEl).inflate(g.urge_aa_dialog_centerview, null);
        TextView textView = (TextView) inflate.findViewById(f.text);
        ((ImageView) inflate.findViewById(f.image)).setImageResource(com.tencent.mm.plugin.wxpay.a.e.paylist_urge_atall_hint);
        textView.setText(i);
        aVar.qIF.dR(inflate);
        aVar.Gv(i.app_send);
        aVar.uKu = this.eEl.getString(i.app_cancel);
        aVar.uKw = false;
        aVar.a(new 1(this), new 2(this));
        aVar.eIW.show();
        h.mEJ.h(13721, Integer.valueOf(4), Integer.valueOf(7));
    }
}
