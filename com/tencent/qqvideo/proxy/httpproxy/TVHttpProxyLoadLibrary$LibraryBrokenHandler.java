package com.tencent.qqvideo.proxy.httpproxy;

import java.lang.Thread.UncaughtExceptionHandler;

class TVHttpProxyLoadLibrary$LibraryBrokenHandler implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler mParent;

    public TVHttpProxyLoadLibrary$LibraryBrokenHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mParent = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Object obj;
        Object obj2 = 1;
        if ((th instanceof UnsatisfiedLinkError) || ((th instanceof NoSuchMethodError) && th.getMessage().matches(".*sig(nature)?[=:].*"))) {
            int obj3 = 1;
        } else {
            obj3 = null;
        }
        if (obj3 != null) {
            try {
                TVHttpProxyLoadLibrary.access$1(TVHttpProxyLoadLibrary.access$0());
            } catch (Exception e) {
            }
            if (obj2 != null) {
                th = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th);
            }
            this.mParent.uncaughtException(thread, th);
        }
        obj2 = null;
        if (obj2 != null) {
            th = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th);
        }
        this.mParent.uncaughtException(thread, th);
    }
}
