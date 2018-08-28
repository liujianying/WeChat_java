package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class e$7 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$7(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
        e.p(this.oSe).setEnabled(false);
        e.q(this.oSe);
        e.p(this.oSe).setEnabled(true);
        if (this.oSe.oQd != null && this.oSe.oQd.get() != null) {
            ((c) this.oSe.oQd.get()).bKt();
        }
    }
}
