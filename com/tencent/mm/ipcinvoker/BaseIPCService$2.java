package com.tencent.mm.ipcinvoker;

import android.os.Process;

class BaseIPCService$2 implements Runnable {
    final /* synthetic */ BaseIPCService dmc;

    BaseIPCService$2(BaseIPCService baseIPCService) {
        this.dmc = baseIPCService;
    }

    public final void run() {
        Process.killProcess(Process.myPid());
    }
}
