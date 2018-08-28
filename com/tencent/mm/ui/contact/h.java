package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;
import java.util.List;

public final class h extends o {
    private Cursor eCC = ((i) g.l(i.class)).FR().dh(this.ujo);
    private List<String> ujo;

    public h(MMBaseSelectContactUI mMBaseSelectContactUI, boolean z, List<String> list) {
        super(mMBaseSelectContactUI, new ArrayList(), true, z);
        this.ujo = list;
        g.Ek();
    }

    public final int getCount() {
        return this.eCC.getCount();
    }

    protected final a iW(int i) {
        if (i < 0 || !this.eCC.moveToPosition(i)) {
            x.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        d dVar = new d(i);
        ab abVar = new ab();
        abVar.d(this.eCC);
        dVar.guS = abVar;
        dVar.ujX = bwq();
        return dVar;
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.CustomContactAdapter", "finish!");
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
    }
}
