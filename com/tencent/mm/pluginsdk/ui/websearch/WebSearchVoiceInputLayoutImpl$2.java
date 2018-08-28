package com.tencent.mm.pluginsdk.ui.websearch;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebSearchVoiceInputLayoutImpl$2 implements OnTouchListener {
    final /* synthetic */ WebSearchVoiceInputLayoutImpl qUF;

    WebSearchVoiceInputLayoutImpl$2(WebSearchVoiceInputLayoutImpl webSearchVoiceInputLayoutImpl) {
        this.qUF = webSearchVoiceInputLayoutImpl;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                WebSearchVoiceInputLayoutImpl.a(this.qUF, false);
                WebSearchVoiceInputLayoutImpl.a(this.qUF, bi.VG());
                x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[]{Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(this.qUF)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(this.qUF))});
                WebSearchVoiceInputLayoutImpl.b(this.qUF).cdv();
                this.qUF.R(false, false);
                break;
            case 1:
                x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[]{Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(this.qUF)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(this.qUF))});
                if (!WebSearchVoiceInputLayoutImpl.f(this.qUF)) {
                    this.qUF.R(false, true);
                    break;
                }
                this.qUF.R(true, false);
                WebSearchVoiceInputLayoutImpl.a(this.qUF, false);
                WebSearchVoiceInputLayoutImpl.a(this.qUF, 0);
                break;
        }
        return false;
    }
}
