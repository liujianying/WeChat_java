package com.tencent.mm.modelrecovery;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;

class PluginRecovery$5 implements RecoveryLogImpl {
    final /* synthetic */ PluginRecovery edj;

    PluginRecovery$5(PluginRecovery pluginRecovery) {
        this.edj = pluginRecovery;
    }

    public final void d(String str, String str2, Object... objArr) {
        x.d(str, str2, objArr);
    }

    public final void v(String str, String str2, Object... objArr) {
        x.v(str, str2, objArr);
    }

    public final void i(String str, String str2, Object... objArr) {
        x.i(str, str2, objArr);
    }

    public final void w(String str, String str2, Object... objArr) {
        x.w(str, str2, objArr);
    }

    public final void e(String str, String str2, Object... objArr) {
        x.e(str, str2, objArr);
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        x.printErrStackTrace(str, th, str2, objArr);
    }
}
