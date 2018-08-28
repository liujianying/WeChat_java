package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ac.a.d.a;
import com.tencent.mm.ac.a.d.a.b;
import com.tencent.mm.ac.z;
import com.tencent.mm.sdk.platformtools.x;

class BizChatroomInfoUI$3 implements a {
    final /* synthetic */ BizChatroomInfoUI tFD;

    BizChatroomInfoUI$3(BizChatroomInfoUI bizChatroomInfoUI) {
        this.tFD = bizChatroomInfoUI;
    }

    public final void a(b bVar) {
        if (bVar != null && bVar.dNq != null && bVar.dNf == BizChatroomInfoUI.g(this.tFD) && bVar.dNp != a.a.dNm) {
            x.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
            BizChatroomInfoUI.a(this.tFD, z.Na().ak(BizChatroomInfoUI.g(this.tFD)));
            BizChatroomInfoUI.h(this.tFD);
        }
    }
}
