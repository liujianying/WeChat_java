package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.sdk.platformtools.x;

class f$6 implements OnClickListener {
    final /* synthetic */ f oSK;

    f$6(f fVar) {
        this.oSK = fVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
        h.mEJ.a(11526, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(2)});
        if (this.oSK.oQd != null && this.oSK.oQd.get() != null && ((c) this.oSK.oQd.get()).bKq()) {
            f.c(this.oSK).setEnabled(false);
            f.d(this.oSK).setText(R.l.voip_waitting);
            this.oSK.oQx.a(f.e(this.oSK), d.oQq);
            f.f(this.oSK).setVisibility(0);
            f.g(this.oSK).setVisibility(8);
            f.c(this.oSK).setVisibility(8);
            f.h(this.oSK).setVisibility(8);
            f.i(this.oSK).setVisibility(0);
        }
    }
}
