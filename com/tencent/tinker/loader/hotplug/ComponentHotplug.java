package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.handler.MHMessageHandler;
import com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.TinkerHackInstrumentation;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;

public final class ComponentHotplug {
    private static volatile boolean vsv = false;
    private static ServiceBinderInterceptor vtX;
    private static ServiceBinderInterceptor vtY;
    private static HandlerMessageInterceptor vtZ;
    private static TinkerHackInstrumentation vua;

    public static synchronized void a(TinkerApplication tinkerApplication, ShareSecurityCheck shareSecurityCheck) {
        synchronized (ComponentHotplug.class) {
            if (!vsv) {
                try {
                    if (IncrementComponentManager.a((Context) tinkerApplication, shareSecurityCheck)) {
                        vtX = new ServiceBinderInterceptor(tinkerApplication, "activity", new AMSInterceptHandler(tinkerApplication));
                        vtY = new ServiceBinderInterceptor(tinkerApplication, "package", new PMSInterceptHandler());
                        vtX.cHc();
                        vtY.cHc();
                        if (VERSION.SDK_INT < 27) {
                            HandlerMessageInterceptor handlerMessageInterceptor = new HandlerMessageInterceptor(hT(tinkerApplication), new MHMessageHandler(tinkerApplication));
                            vtZ = handlerMessageInterceptor;
                            handlerMessageInterceptor.cHc();
                        } else {
                            TinkerHackInstrumentation hU = TinkerHackInstrumentation.hU(tinkerApplication);
                            vua = hU;
                            hU.cHc();
                        }
                        vsv = true;
                    }
                } catch (Throwable th) {
                    ts();
                    UnsupportedEnvironmentException unsupportedEnvironmentException = new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    public static synchronized void cHa() {
        synchronized (ComponentHotplug.class) {
            if (vsv) {
                try {
                    vtX.cHc();
                    vtY.cHc();
                    if (VERSION.SDK_INT < 27) {
                        vtZ.cHc();
                    } else {
                        vua.cHc();
                    }
                } catch (Throwable th) {
                    ts();
                    UnsupportedEnvironmentException unsupportedEnvironmentException = new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    private static Handler hT(Context context) {
        Object c = ShareReflectUtil.c(context, null);
        if (c == null) {
            throw new IllegalStateException("failed to fetch instance of ActivityThread.");
        }
        try {
            return (Handler) ShareReflectUtil.b(c, "mH").get(c);
        } catch (Throwable th) {
            IllegalStateException illegalStateException = new IllegalStateException(th);
        }
    }

    private static synchronized void ts() {
        synchronized (ComponentHotplug.class) {
            if (vsv) {
                try {
                    vtX.ts();
                    vtY.ts();
                    if (VERSION.SDK_INT < 27) {
                        vtZ.ts();
                    } else {
                        TinkerHackInstrumentation tinkerHackInstrumentation = vua;
                        tinkerHackInstrumentation.vuw.set(tinkerHackInstrumentation.vuv, tinkerHackInstrumentation.vuu);
                    }
                } catch (Throwable th) {
                }
                vsv = false;
            }
        }
    }

    private ComponentHotplug() {
        throw new UnsupportedOperationException();
    }
}
