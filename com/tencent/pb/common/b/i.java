package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;
import java.lang.ref.WeakReference;

public final class i implements c {
    private WeakReference<c> vcE;

    public i(c cVar) {
        this.vcE = new WeakReference(cVar);
    }

    public final void r(int i, byte[] bArr) {
        if (this.vcE == null || this.vcE.get() == null) {
            c.x("OnRespForLongAIDLImpl fail", "callback is null, errCode=" + i);
            return;
        }
        ((c) this.vcE.get()).r(i, bArr);
    }
}
