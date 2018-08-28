package com.tencent.xweb.xwalk;

import org.xwalk.core.Log;
import org.xwalk.core.XWalkLogMessageListener;

class h$5 extends XWalkLogMessageListener {
    final /* synthetic */ h vFd;

    h$5(h hVar) {
        this.vFd = hVar;
    }

    public final void onLogMessage(int i, String str, int i2, String str2) {
        Log.i("WCWebview", "[WCWebview] severity:" + i + ", file:" + str + ", line:" + i2 + ", info:" + str2);
    }
}
