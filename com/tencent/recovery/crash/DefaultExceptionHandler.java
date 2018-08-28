package com.tencent.recovery.crash;

import java.lang.Thread.UncaughtExceptionHandler;

public class DefaultExceptionHandler extends RecoveryExceptionHandler {
    private UncaughtExceptionHandler vhm;

    public DefaultExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.vhm = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        super.uncaughtException(thread, th);
        if (this.vhm != null) {
            this.vhm.uncaughtException(thread, th);
        }
    }
}
