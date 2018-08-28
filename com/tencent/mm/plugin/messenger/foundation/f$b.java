package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

class f$b implements Runnable {
    private String TAG;
    private final q dZJ;
    private final LinkedList<pm> iWX;
    private int lcn;

    public f$b(String str, q qVar, LinkedList<pm> linkedList) {
        this.TAG = str;
        this.dZJ = qVar;
        this.iWX = linkedList;
    }

    public final void run() {
        if (this.dZJ != null) {
            int i = this.dZJ.eaS;
            if (i != 3) {
                if (!this.dZJ.eaR) {
                    if (!(i == 1 || i == 2 || i == 8)) {
                        return;
                    }
                }
                return;
            }
            this.lcn = 0;
            Iterator it = this.iWX.iterator();
            while (it.hasNext()) {
                pm pmVar = (pm) it.next();
                byte[] a = ab.a(pmVar.rtN);
                if (pmVar.rtM == 5) {
                    try {
                        String bhz = ((by) new by().aG(a)).rcj.toString();
                        com.tencent.mm.storage.ab Yg = ((i) g.l(i.class)).FR().Yg(bhz);
                        if (bhz.endsWith("@chatroom") && Yg.csI == 0) {
                            this.lcn++;
                        }
                    } catch (IOException e) {
                        x.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + e.getMessage());
                    }
                }
            }
            if (this.lcn > 0) {
                if (this.lcn <= 5) {
                    f.mDy.a(202, (long) this.lcn, 1, false);
                } else if (this.lcn <= 10) {
                    f.mDy.a(202, 6, 1, false);
                } else if (this.lcn <= 15) {
                    f.mDy.a(202, 7, 1, false);
                } else if (this.lcn <= 20) {
                    f.mDy.a(202, 8, 1, false);
                } else {
                    f.mDy.a(202, 9, 1, false);
                }
                x.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.lcn);
                switch (i) {
                    case 1:
                        f.mDy.a(202, 11, 1, false);
                        break;
                    case 2:
                        f.mDy.a(202, 12, 1, false);
                        break;
                    case 3:
                        f.mDy.a(202, 10, 1, false);
                        break;
                    case 8:
                        f.mDy.a(202, 13, 1, false);
                        break;
                }
                x.i(this.TAG, "muteroom idkeyStat:aiScene = " + i);
            }
        }
    }
}
