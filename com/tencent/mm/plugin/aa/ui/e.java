package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.q;
import java.util.List;

public final class e extends q {
    private String bWm;
    private String chatroomName;
    private String[] eCB;
    private Cursor eCC;

    public e(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        this.chatroomName = str;
        List il = ((b) g.l(b.class)).Ga().il(this.chatroomName);
        if (il != null) {
            this.eCB = bi.cW(il);
        }
    }

    public final void a(String str, int[] iArr, boolean z) {
        x.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[]{str});
        clearCache();
        this.bWm = str;
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
        if (!(bi.oW(this.bWm) || this.eCB == null)) {
            g.Ek();
            this.eCC = ((i) g.l(i.class)).FR().a(this.eCB, "@all.chatroom", this.bWm, null, null);
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
        d dVar = new d(i);
        dVar.guS = abVar;
        dVar.ujX = true;
        return dVar;
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
