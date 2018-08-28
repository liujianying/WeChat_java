package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.BaseIPCService.1;
import com.tencent.mm.ipcinvoker.BaseIPCService.a;
import com.tencent.mm.ipcinvoker.b.b;

class BaseIPCService$1$1 implements Runnable {
    final /* synthetic */ a dmd;
    final /* synthetic */ Parcelable dme;
    final /* synthetic */ b dmf;
    final /* synthetic */ 1 dmg;

    BaseIPCService$1$1(1 1, a aVar, Parcelable parcelable, b bVar) {
        this.dmg = 1;
        this.dmd = aVar;
        this.dme = parcelable;
        this.dmf = bVar;
    }

    public final void run() {
        this.dmd.a(this.dme, new a(this.dmf));
    }
}
