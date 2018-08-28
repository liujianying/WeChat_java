package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.api.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.m.a;
import java.util.List;

public final class p extends q {
    private String bWm;
    private Cursor eCC;
    private ag handler = new ag(Looper.getMainLooper());
    private String hpJ;
    private a ujV;
    private List<String> uko = null;

    public p(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, 0);
        this.hpJ = str;
        x.i("MicroMsg.MMSearchContactAdapter", "Create!");
        Wj();
    }

    public final void a(a aVar) {
        this.ujV = aVar;
    }

    public final void bA(String str, boolean z) {
        if (this.ujV != null) {
            this.ujV.q(str, getCount(), z);
        }
    }

    private void Wj() {
        x.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.bWm = null;
        clearCache();
    }

    public final int getCount() {
        return this.eCC == null ? 0 : this.eCC.getCount();
    }

    protected final com.tencent.mm.ui.contact.a.a iW(int i) {
        if (i < 0 || !this.eCC.moveToPosition(i)) {
            x.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        com.tencent.mm.ui.bizchat.a aVar = new com.tencent.mm.ui.bizchat.a(i);
        c cVar = new c();
        cVar.d(this.eCC);
        if (aVar.hpD == -1) {
            aVar.hpD = cVar.field_bizChatLocalId;
            if (cVar.isGroup()) {
                aVar.eCh = cVar.field_chatName;
                aVar.tEb = cVar.field_headImageUrl;
                aVar.username = cVar.field_brandUserName;
            } else {
                j cz = ((g) com.tencent.mm.kernel.g.l(g.class)).cz(cVar.field_bizChatServId);
                if (cz != null) {
                    aVar.eCh = cz.field_userName;
                    aVar.tEb = cz.field_headImageUrl;
                    aVar.username = cz.field_brandUserName;
                }
            }
            if (bi.K(aVar.eCh)) {
                aVar.eCh = this.ujW.getActivity().getResources().getString(h.select_contact_room_head_name);
            }
            if (bi.oW(aVar.username)) {
                aVar.username = cVar.field_brandUserName;
            }
        }
        return aVar;
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.MMSearchContactAdapter", "finish!");
        Wj();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
