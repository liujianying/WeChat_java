package com.tencent.map.swlocation.api;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.d.a.a.q;
import com.d.a.a.t;

public class SwEngine {
    public static void startContinousLocationUpdate(Handler handler, int i, int i2, LocationUpdateListener locationUpdateListener, ServerMessageListener serverMessageListener) {
        t.a(handler, (long) i2, locationUpdateListener, serverMessageListener);
    }

    public static void stopContinousLocationUpdate() {
        t.sP();
    }

    public static void creatLocationEngine(Context context, q qVar) {
        t.a(context, qVar);
    }

    public static void setImei(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("SenseWhereEngine:invalid imei!");
        }
        t.setImei(str);
    }

    public static void onDestroy() {
        t.finish();
    }
}
