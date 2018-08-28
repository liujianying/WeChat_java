package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class e$19 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$19(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
        if (this.oSe.oQd != null && this.oSe.oQd.get() != null && ((c) this.oSe.oQd.get()).bKr()) {
            e.a(this.oSe).setEnabled(false);
            e.f(this.oSe).setEnabled(false);
            e.g(this.oSe).setVisibility(0);
            e.g(this.oSe).setText(R.l.voip_cancel_call);
        }
    }
}
