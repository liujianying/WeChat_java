package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.List;

public final class d extends o {
    private String chatroomName;
    private List<String> eCA = h.pb(this.chatroomName);

    public d(l lVar, String str) {
        super(lVar, null, true, true);
        this.chatroomName = str;
        x.i("MicroMsg.AASelectInitAdapter", "resetData");
    }

    protected final a iW(int i) {
        String str = (String) this.eCA.get(i);
        g.Ek();
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        c cVar = new c(i);
        cVar.bIY = this.chatroomName;
        cVar.guS = Yg;
        cVar.ujX = true;
        return cVar;
    }

    public final int getCount() {
        return this.eCA.size();
    }
}
