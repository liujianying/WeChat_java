package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.sdk.platformtools.al.a;

class g$7 implements a {
    final /* synthetic */ g iuX;

    g$7(g gVar) {
        this.iuX = gVar;
    }

    public final boolean vD() {
        int size = this.iuX.iuI.size();
        int i = 0;
        while (i < size) {
            if (((b) this.iuX.iuI.get(i)).cCX.contains("internet_to_device") && ((b) this.iuX.iuI.get(i)).cCX.contains("wechat_to_device") && !this.iuX.iuJ.contains(this.iuX.iuI.get(i))) {
                this.iuX.iuJ.add(this.iuX.iuI.get(i));
                g.aR(this.iuX.iuJ);
            }
            i++;
        }
        return true;
    }
}
