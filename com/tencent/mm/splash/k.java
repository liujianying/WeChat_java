package com.tencent.mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import java.lang.reflect.Field;

final class k extends Instrumentation {
    public Instrumentation sNk;

    public k(Instrumentation instrumentation) {
        this.sNk = instrumentation;
        ckl();
    }

    public final Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        if (h.sMB != null) {
            h.sMB.cR(str);
        }
        Activity newActivity;
        if (!h.cjV() || h.ckc().getCanonicalName().equals(str)) {
            newActivity = super.newActivity(classLoader, str, intent);
            if (!j.ckk()) {
                return newActivity;
            }
            h.b("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
            intent.putExtra("splash-hack-activity-recreate", true);
            return newActivity;
        }
        newActivity = new i();
        newActivity.sMW = str;
        h.b("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", str);
        h.sMv.add(newActivity);
        return newActivity;
    }

    private void ckl() {
        Field[] declaredFields = Instrumentation.class.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            declaredFields[i].set(this, declaredFields[i].get(this.sNk));
        }
    }
}
