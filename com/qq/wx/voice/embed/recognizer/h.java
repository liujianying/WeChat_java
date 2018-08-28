package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;
import com.tencent.mm.plugin.sns.i$l;

final class h extends Handler {
    private /* synthetic */ g bgt;

    h(g gVar) {
        this.bgt = gVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case i$l.AppCompatTheme_buttonStyle /*100*/:
                this.bgt.bgu.ej(message.getData().getInt("errorCode"));
                return;
            case m.CTRL_INDEX /*200*/:
                this.bgt.bgu.a((a) message.obj);
                return;
            default:
                return;
        }
    }
}
