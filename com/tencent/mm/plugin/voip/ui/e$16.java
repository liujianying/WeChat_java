package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class e$16 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$16(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
        if (ao.isWifi(this.oSe.getActivity()) || q.bKO()) {
            e.c(this.oSe);
        } else {
            h.a(this.oSe.getActivity(), R.l.voip_not_wifi_warnning_message, R.l.voip_not_wifi_warnning_title, new 1(this), new 2(this));
        }
    }
}
