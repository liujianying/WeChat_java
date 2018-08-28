package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.c.a;
import java.util.ArrayList;
import java.util.List;

public final class z implements ao {
    public a bAG;
    public ac tMr = new ac();

    public z(a aVar) {
        this.bAG = aVar;
    }

    public final void a(bd bdVar) {
        if (this.bAG.O(o.class) == null) {
            x.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
            return;
        }
        ((o) this.bAG.O(o.class)).cvn();
        if (bdVar.field_talker.equals(this.bAG.getTalkerUserName()) && bdVar.isText()) {
            aF(bdVar);
        }
    }

    public final void B(List<bd> list) {
        if (this.bAG == null) {
            x.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
        } else if (!s.fq(this.bAG.getTalkerUserName())) {
            List arrayList = new ArrayList();
            for (bd bdVar : list) {
                if (bdVar.field_talker.equals(this.bAG.getTalkerUserName()) && bdVar.isText()) {
                    arrayList.add(bdVar);
                }
            }
            dE(arrayList);
        }
    }

    public final void aF(bd bdVar) {
        if (bdVar != null) {
            List arrayList = new ArrayList();
            arrayList.add(bdVar);
            dE(arrayList);
        }
    }

    private void dE(List<bd> list) {
        if (this.tMr != null && this.bAG != null) {
            this.tMr.a(this.bAG.tTq.getContext(), list);
        }
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
    }
}
