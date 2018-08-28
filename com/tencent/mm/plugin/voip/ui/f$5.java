package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class f$5 implements OnClickListener {
    final /* synthetic */ f oSK;

    f$5(f fVar) {
        this.oSK = fVar;
    }

    public final void onClick(View view) {
        boolean isChecked = f.b(this.oSK).isChecked();
        x.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[]{Boolean.valueOf(isChecked)});
        f.b(this.oSK).setEnabled(false);
        if (!(this.oSK.oQd == null || this.oSK.oQd.get() == null)) {
            ((c) this.oSK.oQd.get()).gD(isChecked);
        }
        f.a(this.oSK, isChecked);
        f.b(this.oSK).setEnabled(true);
    }
}
