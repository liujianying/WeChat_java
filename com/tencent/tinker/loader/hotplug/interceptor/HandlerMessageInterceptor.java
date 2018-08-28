package com.tencent.tinker.loader.hotplug.interceptor;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;

public class HandlerMessageInterceptor extends Interceptor<Callback> {
    private static Field vui;
    private final Handler vug;
    private final MessageHandler vuh;

    public interface MessageHandler {
        boolean handleMessage(Message message);
    }

    private static class CallbackWrapper implements Callback, ITinkerHotplugProxy {
        private final MessageHandler vuh;
        private final Callback vuj;
        private volatile boolean vuk = false;

        CallbackWrapper(MessageHandler messageHandler, Callback callback) {
            this.vuh = messageHandler;
            this.vuj = callback;
        }

        public boolean handleMessage(Message message) {
            if (this.vuk) {
                return false;
            }
            boolean handleMessage;
            this.vuk = true;
            this.vuh.handleMessage(message);
            if (this.vuj != null) {
                handleMessage = this.vuj.handleMessage(message);
            } else {
                handleMessage = false;
            }
            this.vuk = false;
            return handleMessage;
        }
    }

    protected final /* synthetic */ void cH(Object obj) {
        vui.set(this.vug, (Callback) obj);
    }

    protected final /* synthetic */ Object cHb() {
        return (Callback) vui.get(this.vug);
    }

    protected final /* synthetic */ Object cI(Object obj) {
        Callback callback = (Callback) obj;
        return (callback == null || !ITinkerHotplugProxy.class.isAssignableFrom(callback.getClass())) ? new CallbackWrapper(this.vuh, callback) : callback;
    }

    static {
        vui = null;
        synchronized (HandlerMessageInterceptor.class) {
            if (vui == null) {
                try {
                    vui = ShareReflectUtil.d(Handler.class, "mCallback");
                } catch (Throwable th) {
                }
            }
        }
    }

    public HandlerMessageInterceptor(Handler handler, MessageHandler messageHandler) {
        this.vug = handler;
        this.vuh = messageHandler;
    }
}
