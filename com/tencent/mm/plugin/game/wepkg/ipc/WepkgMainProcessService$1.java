package com.tencent.mm.plugin.game.wepkg.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;

class WepkgMainProcessService$1 extends Handler {
    final /* synthetic */ WepkgMainProcessService keK;

    WepkgMainProcessService$1(WepkgMainProcessService wepkgMainProcessService, Looper looper) {
        this.keK = wepkgMainProcessService;
        super(looper);
    }

    public final void handleMessage(Message message) {
        WepkgMainProcessTask C = WepkgMainProcessService.C(message.getData());
        Messenger messenger = message.replyTo;
        int i = message.what;
        C.fEz = messenger;
        C.mTaskId = i;
        C.aai();
    }
}
