package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.protocal.c.sz;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class r$b extends e implements c {
    public sz eKA = new sz();

    public final int G(byte[] bArr) {
        this.eKA = (sz) new sz().aG(bArr);
        k.a(this, this.eKA.six);
        return this.eKA.six.rfn;
    }
}
