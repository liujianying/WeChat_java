package com.tencent.mm.ipcinvoker.f;

import android.os.IBinder.DeathRecipient;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements DeathRecipient {
    private String process;

    public a(String str) {
        this.process = str;
    }

    public final void binderDied() {
        x.i("IPC.DeathRecipientImpl", "binderDied(%s)", new Object[]{this.process});
        if (this.process != null && this.process.length() != 0) {
            b.fI(this.process);
        }
    }
}
