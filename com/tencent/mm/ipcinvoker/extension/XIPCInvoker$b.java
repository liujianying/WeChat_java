package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.e.a;
import com.tencent.mm.ipcinvoker.e.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;

class XIPCInvoker$b implements c, a {
    c<WrapperParcelable> dnb;
    a dnc;

    XIPCInvoker$b(c<WrapperParcelable> cVar) {
        this.dnb = cVar;
        if (cVar instanceof a) {
            this.dnc = (a) cVar;
        }
    }

    public final void at(Object obj) {
        if (this.dnb != null) {
            this.dnb.at(new WrapperParcelable(null, obj));
        }
    }

    public final void a(b bVar) {
        if (this.dnc != null) {
            this.dnc.a(bVar);
        }
    }
}
