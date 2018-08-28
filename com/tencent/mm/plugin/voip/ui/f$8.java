package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class f$8 implements OnClickListener {
    final /* synthetic */ f oSK;

    f$8(f fVar) {
        this.oSK = fVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
        if (this.oSK.oQd != null && this.oSK.oQd.get() != null && ((c) this.oSK.oQd.get()).bKl()) {
            this.oSK.co(this.oSK.getString(R.l.voip_finish_call), -1);
        }
    }
}
