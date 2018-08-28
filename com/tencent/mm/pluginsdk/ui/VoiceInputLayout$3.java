package com.tencent.mm.pluginsdk.ui;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputLayout$3 extends ag {
    final /* synthetic */ VoiceInputLayout qHD;

    VoiceInputLayout$3(VoiceInputLayout voiceInputLayout) {
        this.qHD = voiceInputLayout;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                VoiceInputLayout voiceInputLayout = this.qHD;
                x.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[]{Integer.valueOf(voiceInputLayout.qHc)});
                if (voiceInputLayout.qHc == 2) {
                    voiceInputLayout.qHc = 3;
                    voiceInputLayout.giD.removeMessages(0);
                    voiceInputLayout.giD.sendEmptyMessageDelayed(0, (long) voiceInputLayout.qHz);
                    voiceInputLayout.giD.sendEmptyMessageDelayed(1, (long) voiceInputLayout.qHA);
                    voiceInputLayout.cN(false);
                    return;
                }
                return;
            case 1:
                Bundle data = message.getData();
                this.qHD.af(data.getInt("localCode"), data.getInt("errType"), data.getInt("errCode"));
                return;
            default:
                return;
        }
    }
}
