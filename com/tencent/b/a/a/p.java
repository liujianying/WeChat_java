package com.tencent.b.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import java.lang.reflect.Method;

public class p {
    private static volatile p bvN = null;
    private boolean bvO = false;
    private Context context = null;

    public final boolean u(String str, String str2) {
        if (this.bvO) {
            try {
                return System.putString(this.context.getContentResolver(), str, str2);
            } catch (Exception e) {
            }
        }
        return false;
    }

    private p(Context context) {
        this.context = context.getApplicationContext();
        this.bvO = s.o(this.context, "android.permission.WRITE_SETTINGS");
        if (VERSION.SDK_INT >= 23) {
            try {
                Method declaredMethod = System.class.getDeclaredMethod("canWrite", new Class[]{Context.class});
                declaredMethod.setAccessible(true);
                this.bvO = ((Boolean) declaredMethod.invoke(null, new Object[]{this.context})).booleanValue();
            } catch (Exception e) {
            }
        }
    }

    public static p aG(Context context) {
        if (bvN == null) {
            synchronized (p.class) {
                if (bvN == null) {
                    bvN = new p(context);
                }
            }
        }
        return bvN;
    }
}
