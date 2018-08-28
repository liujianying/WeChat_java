package com.tencent.mm.ak.a.f;

import com.tencent.mm.ak.a.a.b;
import com.tencent.mm.ak.a.a.c;

public final class a implements Runnable {
    private final b dWS = this.dYi.dWS;
    private final c dXk;
    private final com.tencent.mm.ak.a.c.a dXm;
    private final com.tencent.mm.ak.a.c.b dXn;
    private final com.tencent.mm.ak.a.b dYi;
    private final com.tencent.mm.ak.a.c.c dYj;
    private final String url;

    public a(String str, c cVar, com.tencent.mm.ak.a.b bVar, com.tencent.mm.ak.a.c.c cVar2) {
        this.url = str;
        this.dYi = bVar;
        if (cVar == null) {
            this.dXk = this.dWS.dXk;
        } else {
            this.dXk = cVar;
        }
        this.dYj = cVar2;
        if (this.dXk.dXn != null) {
            this.dXn = this.dXk.dXn;
        } else {
            this.dXn = this.dWS.dXn;
        }
        this.dXm = this.dWS.dXm;
    }

    public final void run() {
        com.tencent.mm.ak.a.d.b bVar = new com.tencent.mm.ak.a.d.b();
        bVar = this.dXn.mb(this.url);
        if (bVar == null) {
            this.dYj.a(false, this.dXk.dYc);
        } else if (!(com.tencent.mm.sdk.platformtools.c.decodeByteArray(bVar.data, 10, 10) == null && this.dXk.dXZ) && this.dXm.a(this.url, bVar.data, this.dXk)) {
            if (this.dYj != null) {
                this.dYj.a(true, this.dXk.dYc);
            }
        } else if (this.dYj != null) {
            this.dYj.a(false, this.dXk.dYc);
        }
    }
}
