package com.tencent.mm.plugin.normsg;

import android.support.annotation.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Keep
public class CProxyStub implements InvocationHandler {
    @Keep
    private final long mNativePtr;

    private native void nativeFinalize();

    public native Object invoke(Object obj, Method method, Object[] objArr);

    private CProxyStub(long j) {
        synchronized (this) {
            this.mNativePtr = j;
        }
    }

    protected void finalize() {
        try {
            synchronized (this) {
                nativeFinalize();
            }
        } catch (Throwable th) {
        } finally {
            super.finalize();
        }
    }
}
