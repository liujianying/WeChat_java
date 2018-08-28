package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import java.util.List;

public final class b extends q {
    private String bWm;
    private String chatroomName;
    private String[] eCB;
    private Cursor eCC;

    public b(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        this.chatroomName = str;
        au.HU();
        List il = c.Ga().il(this.chatroomName);
        if (il != null) {
            this.eCB = bi.cW(il);
        }
    }

    public final void a(String str, int[] iArr, boolean z) {
        x.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[]{str});
        clearCache();
        this.bWm = str;
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
        if (!(bi.oW(this.bWm) || this.eCB == null)) {
            au.HU();
            this.eCC = c.FR().a(this.eCB, "@all.chatroom", this.bWm, null, null);
        }
        notifyDataSetChanged();
        bA(str, true);
    }

    protected final a iW(int i) {
        if (!this.eCC.moveToPosition(i)) {
            return null;
        }
        ab abVar = new ab();
        abVar.d(this.eCC);
        com.tencent.mm.plugin.multitalk.ui.widget.a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.guS = abVar;
        aVar.ujX = bwq();
        aVar.bWm = this.bWm;
        return aVar;
    }

    public final void finish() {
        super.finish();
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
    }

    public final int getCount() {
        if (this.eCC == null) {
            return 0;
        }
        return this.eCC.getCount();
    }
}
