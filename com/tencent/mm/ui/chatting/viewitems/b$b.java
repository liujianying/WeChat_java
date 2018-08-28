package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ac.h.a;
import com.tencent.mm.ac.z;
import com.tencent.mm.protocal.c.cgc;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class b$b implements a {
    com.tencent.mm.ui.chatting.c.a bAG;
    private String qkj;

    protected b$b(com.tencent.mm.ui.chatting.c.a aVar, String str) {
        this.qkj = str;
        this.bAG = aVar;
    }

    public final void d(LinkedList<cgc> linkedList) {
        int i = 0;
        z.MZ().b(this);
        x.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
        if (linkedList != null && linkedList.size() > 0) {
            x.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[]{Integer.valueOf(linkedList.size()), this.qkj});
            if (this.bAG != null) {
                if (linkedList != null && linkedList.size() != 0) {
                    for (int i2 = 0; i2 < linkedList.size(); i2++) {
                        cgc cgc = (cgc) linkedList.get(i2);
                        if (!(cgc == null || bi.oW(cgc.sAB) || !cgc.sAB.equals(this.qkj))) {
                            x.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
                            if (!bi.oW(cgc.rTW)) {
                                x.i("MicroMsg.ChattingItem", "needCallback: true");
                                i = 1;
                                break;
                            }
                        }
                    }
                }
                if (i != 0) {
                    ah.A(new 1(this));
                }
            }
        }
    }

    public final String MQ() {
        return this.qkj;
    }
}
