package com.tencent.mm.plugin.backup.backupui;

import com.tencent.mm.plugin.backup.a.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class a$a implements a {
    private final WeakReference<a> gYU;

    a$a(a aVar) {
        this.gYU = new WeakReference(aVar);
    }

    public final void mv(int i) {
        a aVar = (a) this.gYU.get();
        if (aVar != null) {
            a.a(aVar, i);
        } else {
            x.e(a.bP(), "BackupChatBanner WeakReference is null!");
        }
    }
}
