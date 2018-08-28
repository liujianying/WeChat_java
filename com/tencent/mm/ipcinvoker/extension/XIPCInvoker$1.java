package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;
import com.tencent.mm.ipcinvoker.h.b;

class XIPCInvoker$1 implements c<WrapperParcelable> {
    final /* synthetic */ c dmx;

    XIPCInvoker$1(c cVar) {
        this.dmx = cVar;
    }

    public final /* synthetic */ void at(Object obj) {
        WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
        if (this.dmx == null) {
            return;
        }
        if (wrapperParcelable == null) {
            b.w("IPC.XIPCInvoker", "async invoke callback error, wrapper parcelable data is null!", new Object[0]);
            this.dmx.at(null);
            return;
        }
        this.dmx.at(wrapperParcelable.dna);
    }
}
