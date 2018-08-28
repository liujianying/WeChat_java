package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class a extends o {
    private String chatroomName;
    private List<String> eCA = c.Ga().il(this.chatroomName);

    public a(l lVar, String str) {
        super(lVar, null, true, true);
        this.chatroomName = str;
        x.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
        au.HU();
        if (this.eCA == null) {
            this.eCA = new ArrayList();
        }
    }

    protected final com.tencent.mm.ui.contact.a.a iW(int i) {
        String str = (String) this.eCA.get(i);
        au.HU();
        ab Yg = c.FR().Yg(str);
        com.tencent.mm.plugin.multitalk.ui.widget.a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.guS = Yg;
        aVar.ujX = bwq();
        return aVar;
    }

    public final int getCount() {
        return this.eCA.size();
    }
}
