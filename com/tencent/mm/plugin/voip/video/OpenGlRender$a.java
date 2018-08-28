package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class OpenGlRender$a extends ag {
    final /* synthetic */ OpenGlRender oUY;

    public OpenGlRender$a(OpenGlRender openGlRender, Looper looper) {
        this.oUY = openGlRender;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.oUY.requestRender();
    }
}
