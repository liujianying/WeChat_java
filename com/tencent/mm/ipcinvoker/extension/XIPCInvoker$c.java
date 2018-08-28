package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;

class XIPCInvoker$c implements i<WrapperParcelable, WrapperParcelable> {
    private XIPCInvoker$c() {
    }

    public final /* synthetic */ Object av(Object obj) {
        WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
        Object obj2 = wrapperParcelable.dna;
        String str = wrapperParcelable.dnd;
        if (str == null || str.length() == 0) {
            b.e("IPC.XIPCInvoker", "proxy SyncInvoke failed, class is null or nil.", new Object[0]);
            return new WrapperParcelable(null, null);
        }
        i iVar = (i) j.d(str, i.class);
        if (iVar != null) {
            return new WrapperParcelable(null, iVar.av(obj2));
        }
        b.w("IPC.XIPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", new Object[]{str});
        return new WrapperParcelable(null, null);
    }
}
