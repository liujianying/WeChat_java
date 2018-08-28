package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.j;

class XIPCInvoker$a implements a<WrapperParcelable, WrapperParcelable> {
    private XIPCInvoker$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
        Object obj2 = wrapperParcelable.dna;
        String str = wrapperParcelable.dnd;
        if (str == null || str.length() == 0) {
            b.e("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, class is null or nil.", new Object[0]);
            return;
        }
        a aVar = (a) j.d(str, a.class);
        if (aVar == null) {
            b.w("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, newInstance(%s) return null.", new Object[]{str});
            return;
        }
        aVar.a(obj2, new XIPCInvoker$b(cVar));
    }
}
