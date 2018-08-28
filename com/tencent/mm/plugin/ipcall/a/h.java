package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.g.a.ij;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends c<ij> {
    public a koL;

    public interface a {
        void a(bcd bcd);
    }

    public h() {
        this.sFo = ij.class.getName().hashCode();
    }

    private boolean a(ij ijVar) {
        if (ijVar instanceof ij) {
            Object obj = ijVar.bRR.bRS;
            if (obj != null && obj.length > 0 && obj[0] == (byte) 101) {
                Object obj2 = new byte[(obj.length - 1)];
                System.arraycopy(obj, 1, obj2, 0, obj2.length);
                try {
                    bcd bcd = (bcd) new bcd().aG(obj2);
                    x.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[]{Integer.valueOf(bcd.rxG), Long.valueOf(bcd.rxH), Integer.valueOf(bcd.kpJ)});
                    LinkedList linkedList = bcd.sew;
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            bcm bcm = (bcm) it.next();
                            x.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[]{Integer.valueOf(bcm.sdf), Integer.valueOf(bcm.seH), Integer.valueOf(bcm.seG)});
                        }
                    }
                    if (this.koL != null) {
                        this.koL.a(bcd);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[]{e.getMessage()});
                }
            }
        }
        return false;
    }
}
