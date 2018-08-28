package com.tencent.wework.api;

import com.tencent.wework.api.WWAPIImpl.1;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.utils.Log;

class WWAPIImpl$1$1 implements Runnable {
    final /* synthetic */ BaseMessage vzH;
    final /* synthetic */ 1 vzI;

    WWAPIImpl$1$1(1 1, BaseMessage baseMessage) {
        this.vzI = 1;
        this.vzH = baseMessage;
    }

    public void run() {
        try {
            WWAPIImpl.b(this.vzI.vzG).get(((WWBaseRespMessage) this.vzH).transaction);
            WWAPIImpl.b(this.vzI.vzG).remove(((WWBaseRespMessage) this.vzH).transaction);
        } catch (Throwable th) {
            Log.e("WWAPIImpl", "handle message failed", th);
        }
    }
}
