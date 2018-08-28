package com.tencent.mm.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.app.WeChatSplashStartup.2;

class WeChatSplashStartup$2$1 implements OnClickListener {
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ 2 bzt;

    WeChatSplashStartup$2$1(2 2, Runnable runnable) {
        this.bzt = 2;
        this.bzs = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.bzs.run();
    }
}
