package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class f$4 implements OnClickListener {
    final /* synthetic */ f oSK;

    f$4(f fVar) {
        this.oSK = fVar;
    }

    public final void onClick(View view) {
        boolean isChecked = f.a(this.oSK).isChecked();
        x.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[]{Boolean.valueOf(isChecked)});
        f.a(this.oSK).setEnabled(false);
        if (!(this.oSK.oQd == null || this.oSK.oQd.get() == null)) {
            ((c) this.oSK.oQd.get()).iO(isChecked);
        }
        f.a(this.oSK, isChecked ? 1 : 2);
        f.a(this.oSK).setEnabled(true);
    }
}
