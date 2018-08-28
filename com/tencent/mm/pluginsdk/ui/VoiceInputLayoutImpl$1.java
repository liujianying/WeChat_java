package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputLayoutImpl$1 implements OnLongClickListener {
    final /* synthetic */ VoiceInputLayoutImpl qHI;

    VoiceInputLayoutImpl$1(VoiceInputLayoutImpl voiceInputLayoutImpl) {
        this.qHI = voiceInputLayoutImpl;
    }

    public final boolean onLongClick(View view) {
        x.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[]{Integer.valueOf(this.qHI.qHc)});
        VoiceInputLayoutImpl.a(this.qHI, true);
        VoiceInputLayoutImpl.a(this.qHI).cdt();
        return true;
    }
}
