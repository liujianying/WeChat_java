package com.tencent.wework.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.utils.Log;

class WWAPIImpl$1 extends BroadcastReceiver {
    final /* synthetic */ WWAPIImpl vzG;

    WWAPIImpl$1(WWAPIImpl wWAPIImpl) {
        this.vzG = wWAPIImpl;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (WWAPIImpl.a(this.vzG).equals(intent.getScheme())) {
                BaseMessage p = BaseMessage.p(intent.getData());
                if (p instanceof WWBaseRespMessage) {
                    new Handler(Looper.getMainLooper()).post(new 1(this, p));
                    return;
                }
                return;
            }
            Log.w("WWAPIImpl", "invalid schema: " + intent.getScheme());
        } catch (Throwable th) {
            Log.e("WWAPIImpl", "handle broadcast failed", th);
        }
    }
}
