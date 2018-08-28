package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;

class LoadProtocolJNITask$1 implements Runnable {
    final /* synthetic */ LoadProtocolJNITask this$0;

    LoadProtocolJNITask$1(LoadProtocolJNITask loadProtocolJNITask) {
        this.this$0 = loadProtocolJNITask;
    }

    public void run() {
        MMProtocalJni.setClientPackVersion(d.qVN);
    }
}
