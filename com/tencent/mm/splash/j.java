package com.tencent.mm.splash;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mm.compatible.util.d;
import java.lang.reflect.Field;

final class j implements Callback {
    public static int sMX = 100;
    public static int sMY = 113;
    public static int sMZ = 114;
    public static int sNa = 115;
    public static int sNb = 116;
    public static int sNc = 121;
    public static int sNd = 122;
    public static int sNe = 126;
    public static int sNf = 145;
    private static boolean sNg = false;
    private static Runnable sNh;
    private static boolean sNj = false;
    Callback lGF;
    private Context mContext;
    private boolean sNi = false;

    public j(Context context, Callback callback) {
        this.mContext = context;
        this.lGF = callback;
    }

    public static void aa(Runnable runnable) {
        sNg = true;
        sNh = runnable;
    }

    public static boolean ckk() {
        return sNj;
    }

    public final boolean handleMessage(Message message) {
        if (this.sNi) {
            h.b("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
            return true;
        }
        sNj = false;
        h.b("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", Integer.valueOf(message.what), Boolean.valueOf(h.cjV()), Boolean.valueOf(h.cjW()));
        if (sNg && message.what == 987654321) {
            if (sNh != null) {
                h.b("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
                sNh.run();
            }
            return true;
        }
        if (h.cjV() && !h.cjW()) {
            h.b("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", Integer.valueOf(message.what), Boolean.valueOf(h.cjV()));
            if (message.what == sMY || message.what == sMZ || message.what == sNa || message.what == sNb || message.what == sNc || message.what == sNd || message.what == sNf) {
                Message obtain = Message.obtain();
                obtain.copyFrom(message);
                h.sMw.add(obtain);
                if (h.sMB != null) {
                    h.sMB.vh();
                }
                return true;
            }
        }
        if (message.what == sNe) {
            if (h.sMC.size() > 0) {
                sNj = true;
            }
            h.b("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", Integer.valueOf(h.sMC.size()));
            Object obj = message.obj;
            if (d.fT(25)) {
                try {
                    if (l.sNt == null) {
                        Field declaredField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
                        declaredField.setAccessible(true);
                        l.sNt = declaredField;
                    }
                    h.b("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", Boolean.valueOf(((Boolean) l.sNt.get(obj)).booleanValue()));
                    l.sNt.set(obj, Boolean.valueOf(false));
                } catch (Throwable e) {
                    h.a(e, "");
                }
            }
        }
        if (this.lGF == null) {
            return false;
        }
        this.sNi = true;
        boolean handleMessage = this.lGF.handleMessage(message);
        this.sNi = false;
        return handleMessage;
    }
}
