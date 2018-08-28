package com.tencent.mm.pluginsdk.ui;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.modelvoiceaddr.f.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

class VoiceInputLayout$2 implements b {
    final /* synthetic */ VoiceInputLayout qHD;

    VoiceInputLayout$2(VoiceInputLayout voiceInputLayout) {
        this.qHD = voiceInputLayout;
    }

    public final void TZ() {
        x.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[]{Integer.valueOf(this.qHD.qHc)});
        if (VoiceInputLayout.c(this.qHD) != null) {
            VoiceInputLayout.c(this.qHD).SO();
        }
        VoiceInputLayout.d(this.qHD).sendEmptyMessage(0);
    }

    public final void Ud() {
        x.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
        VoiceInputLayout.a(this.qHD).removeMessages(0);
        VoiceInputLayout.a(this.qHD).removeMessages(1);
        VoiceInputLayout.e(this.qHD).cdJ();
        this.qHD.reset(false);
    }

    public final void a(String[] strArr, Set<String> set) {
        VoiceInputLayout.e(this.qHD).b(strArr, set);
        VoiceInputLayout.a(this.qHD).removeMessages(0);
        VoiceInputLayout.a(this.qHD).sendEmptyMessageDelayed(0, (long) VoiceInputLayout.f(this.qHD));
    }

    public final void B(int i, int i2, int i3) {
        VoiceInputLayout.a(this.qHD).removeMessages(0);
        VoiceInputLayout.a(this.qHD).removeMessages(1);
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt("localCode", i);
        bundle.putInt("errType", i2);
        bundle.putInt("errCode", i3);
        message.setData(bundle);
        message.what = 1;
        VoiceInputLayout.d(this.qHD).sendMessage(message);
    }
}
