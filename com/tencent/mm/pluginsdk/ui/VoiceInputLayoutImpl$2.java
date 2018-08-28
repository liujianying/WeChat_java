package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputLayoutImpl$2 implements OnTouchListener {
    final /* synthetic */ VoiceInputLayoutImpl qHI;

    VoiceInputLayoutImpl$2(VoiceInputLayoutImpl voiceInputLayoutImpl) {
        this.qHI = voiceInputLayoutImpl;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                VoiceInputLayoutImpl.a(this.qHI, false);
                VoiceInputLayoutImpl.a(this.qHI, bi.VG());
                x.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[]{Integer.valueOf(this.qHI.qHc), Long.valueOf(VoiceInputLayoutImpl.b(this.qHI))});
                VoiceInputLayoutImpl.a(this.qHI).cdv();
                this.qHI.R(false, false);
                break;
            case 1:
                x.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[]{Integer.valueOf(this.qHI.qHc), Boolean.valueOf(VoiceInputLayoutImpl.c(this.qHI))});
                if (!VoiceInputLayoutImpl.c(this.qHI)) {
                    this.qHI.R(false, true);
                    break;
                }
                this.qHI.R(true, false);
                VoiceInputLayoutImpl.a(this.qHI, false);
                VoiceInputLayoutImpl.a(this.qHI, 0);
                break;
        }
        return false;
    }
}
