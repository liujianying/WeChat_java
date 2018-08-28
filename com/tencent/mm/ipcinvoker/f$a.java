package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.b.b.a;
import com.tencent.mm.ipcinvoker.f.b;
import com.tencent.mm.ipcinvoker.f.c;

class f$a extends a implements c {
    c dmE;
    String dmw;

    f$a(String str, c cVar) {
        this.dmE = cVar;
        this.dmw = str;
        b.a(str, this);
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", new Object[]{Integer.valueOf(cVar.hashCode())});
    }

    public final void i(Bundle bundle) {
        c cVar = this.dmE;
        if (cVar == null) {
            com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
        } else if (bundle == null) {
            cVar.at(null);
        } else {
            bundle.setClassLoader(f.class.getClassLoader());
            if (bundle.getBoolean("__command_release_ref")) {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "release ref of callback(%s)", new Object[]{Integer.valueOf(cVar.hashCode())});
                recycle();
                return;
            }
            cVar.at(bundle.getParcelable("__remote_task_result_data"));
        }
    }

    public final void recycle() {
        this.dmE = null;
        b.b(this.dmw, this);
    }

    protected final void finalize() {
        recycle();
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "finalize(%s)", new Object[]{Integer.valueOf(hashCode())});
        super.finalize();
    }
}
