package com.tencent.mm.app;

import android.content.Context;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.storage.az.b;
import com.tencent.mm.storage.bd;

class WorkerProfile$27 implements b {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$27(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
    }

    public final void a(bd bdVar, PString pString, PString pString2, PInt pInt, boolean z) {
        h.b(bdVar, pString, pString2, pInt, z);
    }

    public final String a(int i, String str, String str2, int i2, Context context) {
        return h.a(i, str, str2, i2, context);
    }
}
