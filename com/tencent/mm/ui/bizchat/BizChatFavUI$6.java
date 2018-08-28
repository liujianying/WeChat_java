package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.d$a;
import com.tencent.mm.ac.a.d$a.b;
import com.tencent.mm.ac.z;
import com.tencent.mm.sdk.platformtools.x;

class BizChatFavUI$6 implements d$a {
    final /* synthetic */ BizChatFavUI tEG;

    BizChatFavUI$6(BizChatFavUI bizChatFavUI) {
        this.tEG = bizChatFavUI;
    }

    public final void a(b bVar) {
        if (bVar != null && bVar.dNq != null) {
            x.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
            c ak = z.Na().ak(bVar.dNf);
            x.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", new Object[]{Boolean.valueOf(ak.field_needToUpdate)});
            if (BizChatFavUI.b(this.tEG)) {
                BizChatFavUI.c(this.tEG).WT();
            }
        }
    }
}
