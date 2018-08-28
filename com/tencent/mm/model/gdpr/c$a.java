package com.tencent.mm.model.gdpr;

import com.tencent.mm.al.b;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;

final class c$a implements i<IPCVoid, IPCBoolean> {
    private c$a() {
    }

    public final /* synthetic */ Object av(Object obj) {
        boolean z = g.Eg().Dx() && b.ml((String) g.Ei().DT().get(274436, null));
        return new IPCBoolean(z);
    }
}
