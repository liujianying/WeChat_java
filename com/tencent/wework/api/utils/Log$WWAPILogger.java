package com.tencent.wework.api.utils;

class Log$WWAPILogger implements Log$ILogger {
    Log$ILogger vzO;

    Log$WWAPILogger(Log$ILogger log$ILogger) {
        this.vzO = log$ILogger;
    }

    public final void a(int i, String str, String str2, Throwable th) {
        this.vzO.a(i, "WWAPI-" + str, str2, th);
    }
}
