package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.List;

public final class w extends o implements b {
    private Cursor eCC;
    private int mBL;
    private List<String> ulj;
    private int ulk;
    private boolean ull;
    private int ulm;

    public w(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list) {
        this(mMBaseSelectContactUI, list, true, false, false, 0);
    }

    public w(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, boolean z3, int i) {
        super(mMBaseSelectContactUI, list, z, z2);
        this.ulm = 0;
        x.i("MicroMsg.RecentConversationAdapter", "create!");
        this.ull = z3;
        this.ulm = i;
        aMk();
        ((i) g.l(i.class)).FW().a(this);
    }

    private void aMk() {
        int i;
        int i2 = 0;
        x.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
        if (s.fb(this.ulm, 4)) {
            this.eCC = ((i) g.l(i.class)).FW().a(s.dAS, this.gRN, this.ukn, "");
        } else if (s.fb(this.ulm, 16)) {
            this.eCC = ((i) g.l(i.class)).FW().a(s.dAU, this.gRN, this.ukn, "");
        } else {
            this.eCC = ((i) g.l(i.class)).FW().a(s.dAN, this.gRN, this.ukn, "");
        }
        if (this.ull) {
            i = 2;
        } else {
            i = 0;
        }
        if (this.ulj != null) {
            i2 = this.ulj.size();
        }
        this.ulk = i2;
        this.mBL = i + this.ulk;
        clearCache();
    }

    public final int getCount() {
        return (this.eCC.getCount() + this.mBL) + 1;
    }

    protected final a iW(int i) {
        com.tencent.mm.ui.contact.a.g gVar;
        if (this.mBL > this.ulk) {
            if (i == this.ulk) {
                gVar = new com.tencent.mm.ui.contact.a.g(i);
                gVar.jyx = this.ujW.getActivity().getResources().getString(h.select_contact_official_accounts_title);
            } else if (i == this.ulk + 1) {
                gVar = new com.tencent.mm.ui.contact.a.b(i);
                String string = this.ujW.getActivity().getResources().getString(h.select_contact_official_accounts_title);
                gVar.jxE = com.tencent.mm.plugin.selectcontact.a.g.default_servicebrand_contact;
                gVar.bgn = string;
            }
            a bVar;
            if (i == this.mBL) {
                com.tencent.mm.ui.contact.a.g gVar2 = new com.tencent.mm.ui.contact.a.g(i);
                gVar2.jyx = this.ujW.getActivity().getResources().getString(h.select_contact_conversation_cur);
                return gVar2;
            } else if (i < this.ulk) {
                if (this.ulj == null || i < 0 || i >= this.ulj.size()) {
                    return null;
                }
                bVar = new com.tencent.mm.ui.contact.a.b(i);
                bVar.username = (String) this.ulj.get(i);
                return bVar;
            } else if (i <= this.mBL || !this.eCC.moveToPosition((i - this.mBL) - 1)) {
                x.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
                return gVar;
            } else {
                bVar = new e(i);
                ai aiVar = new ai();
                aiVar.d(this.eCC);
                g.Ek();
                bVar.guS = ((i) g.l(i.class)).FR().Yb(aiVar.field_username);
                if (bVar.guS == null) {
                    g.Ek();
                    bVar.guS = ((i) g.l(i.class)).FR().Yf(aiVar.field_username);
                }
                bVar.ujX = bwq();
                return bVar;
            }
        }
        gVar = null;
        if (i == this.mBL) {
            com.tencent.mm.ui.contact.a.g gVar22 = new com.tencent.mm.ui.contact.a.g(i);
            gVar22.jyx = this.ujW.getActivity().getResources().getString(h.select_contact_conversation_cur);
            return gVar22;
        } else if (i < this.ulk) {
            if (this.ulj == null || i < 0 || i >= this.ulj.size()) {
                return null;
            }
            bVar = new com.tencent.mm.ui.contact.a.b(i);
            bVar.username = (String) this.ulj.get(i);
            return bVar;
        } else if (i <= this.mBL || !this.eCC.moveToPosition((i - this.mBL) - 1)) {
            x.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return gVar;
        } else {
            bVar = new e(i);
            ai aiVar2 = new ai();
            aiVar2.d(this.eCC);
            g.Ek();
            bVar.guS = ((i) g.l(i.class)).FR().Yb(aiVar2.field_username);
            if (bVar.guS == null) {
                g.Ek();
                bVar.guS = ((i) g.l(i.class)).FR().Yf(aiVar2.field_username);
            }
            bVar.ujX = bwq();
            return bVar;
        }
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
        ((i) g.l(i.class)).FW().b(this);
    }

    public final void a(int i, m mVar, Object obj) {
        aMk();
        notifyDataSetChanged();
    }
}
