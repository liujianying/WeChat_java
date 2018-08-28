package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.x;

class v$4 implements v$d {
    final /* synthetic */ v mdU;

    v$4(v vVar) {
        this.mdU = vVar;
    }

    public final void d(int i, int i2, String str, String str2) {
        x.d("MicroMsg.ShareModeMailAppService", "finishedSendOneFile, currentFileCount: %d, totalFileNum: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.mdU.mdG.put(str, str2);
        this.mdU.uW((int) (10.0f + (80.0f * (((float) i) / ((float) i2)))));
    }
}
