package com.tencent.matrix.iocanary.core;

import com.tencent.matrix.d.b;
import com.tencent.matrix.iocanary.c.a;
import java.util.ArrayList;

public class IOCanaryJniBridge {
    private static b bqW;
    private static boolean bqX;
    private static boolean bqY;

    private static final class ConfigKey {
        static final int MAIN_THREAD_THRESHOLD = 0;
        static final int REPEAT_READ_THRESHOLD = 2;
        static final int SMALL_BUFFER_THRESHOLD = 1;

        private ConfigKey() {
        }
    }

    private static final class DetectorType {
        static final int MAIN_THREAD_IO = 0;
        static final int REPEAT_READ = 2;
        static final int SMALL_BUFFER = 1;

        private DetectorType() {
        }
    }

    private static final class JavaContext {
        private final String stack;
        private final String threadName;

        private JavaContext() {
            this.stack = a.getThrowableStack(new Throwable());
            this.threadName = Thread.currentThread().getName();
        }
    }

    private static native boolean doHook();

    private static native boolean doUnHook();

    private static native void enableDetector(int i);

    private static native void setConfig(int i, long j);

    public static void a(com.tencent.matrix.iocanary.a.a aVar, b bVar) {
        b.v("Matrix.IOCanaryJniBridge", "install sIsTryInstall:%b", Boolean.valueOf(bqX));
        if (!bqX) {
            if (tt()) {
                bqW = bVar;
                if (aVar != null) {
                    try {
                        if (aVar.el(1)) {
                            enableDetector(0);
                            setConfig(0, ((long) aVar.bqM) * 1000);
                        }
                        if (aVar.el(4)) {
                            enableDetector(1);
                            setConfig(1, (long) aVar.bqN);
                        }
                        if (aVar.el(2)) {
                            enableDetector(2);
                            setConfig(2, (long) aVar.bqP);
                        }
                    } catch (Throwable e) {
                        b.printErrStackTrace("Matrix.IOCanaryJniBridge", e, "call jni method error", new Object[0]);
                        return;
                    }
                }
                doHook();
                bqX = true;
                return;
            }
            b.e("Matrix.IOCanaryJniBridge", "install loadJni failed", new Object[0]);
        }
    }

    public static void ts() {
        if (bqX) {
            doUnHook();
            bqX = false;
        }
    }

    private static boolean tt() {
        if (bqY) {
            return true;
        }
        try {
            System.loadLibrary("io-canary");
            bqY = true;
            return true;
        } catch (Exception e) {
            b.e("Matrix.IOCanaryJniBridge", "hook: e: %s", e.getLocalizedMessage());
            bqY = false;
            return false;
        }
    }

    public static void onIssuePublish(ArrayList<IOIssue> arrayList) {
        if (bqW != null) {
            bqW.y(arrayList);
        }
    }

    private static JavaContext getJavaContext() {
        try {
            return new JavaContext();
        } catch (Throwable th) {
            b.printErrStackTrace("Matrix.IOCanaryJniBridge", th, "get javacontext exception", new Object[0]);
            return null;
        }
    }
}
