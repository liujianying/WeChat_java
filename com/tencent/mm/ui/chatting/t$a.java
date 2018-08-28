package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.b;
import com.tencent.mm.ui.chatting.viewitems.au;

public class t$a extends b {
    public t$a(a aVar) {
        super(aVar);
    }

    public final void a(Intent intent, au auVar) {
        if (!ai.oW(auVar.ufB)) {
            intent.putExtra("Contact_BIZ_KF_WORKER_ID", auVar.ufB);
        }
    }
}
