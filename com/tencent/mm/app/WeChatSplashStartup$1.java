package com.tencent.mm.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.o.a;

class WeChatSplashStartup$1 extends c<lt> {
    final /* synthetic */ a bzo;
    final /* synthetic */ WeChatSplashStartup bzp;

    WeChatSplashStartup$1(WeChatSplashStartup weChatSplashStartup, a aVar) {
        this.bzp = weChatSplashStartup;
        this.bzo = aVar;
        this.sFo = lt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.WeChatSplashStartup", "Replay pending messages.");
                WeChatSplashStartup$1.this.bzo.ckf();
            }
        });
        dead();
        return false;
    }
}
