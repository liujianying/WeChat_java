package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.z;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.o;

public final class d extends o implements b {
    private Cursor eCC;
    private String hpJ;
    private int mBL;

    public d(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, false);
        x.i("MicroMsg.RecentConversationAdapter", "create!");
        this.hpJ = str;
        aMk();
    }

    private void aMk() {
        x.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
        this.eCC = z.Nb().kY(this.hpJ);
        this.mBL = 0;
    }

    public final int getCount() {
        return this.eCC.getCount() + 1;
    }

    protected final a iW(int i) {
        if (i == this.mBL) {
            g gVar = new g(i);
            gVar.jyx = this.ujW.getActivity().getResources().getString(R.l.select_conversation_cur);
            return gVar;
        } else if (i <= this.mBL || !this.eCC.moveToPosition((i - this.mBL) - 1)) {
            x.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return null;
        } else {
            a aVar = new a(i);
            com.tencent.mm.ac.a.a aVar2 = new com.tencent.mm.ac.a.a();
            aVar2.d(this.eCC);
            if (aVar.hpD != -1) {
                return aVar;
            }
            aVar.hpD = aVar2.field_bizChatId;
            c ak = z.Na().ak(aVar2.field_bizChatId);
            if (ak.isGroup()) {
                aVar.eCh = ak.field_chatName;
                aVar.tEb = ak.field_headImageUrl;
                aVar.username = ak.field_brandUserName;
            } else {
                j cz = z.Nc().cz(ak.field_bizChatServId);
                if (cz != null) {
                    aVar.eCh = cz.field_userName;
                    aVar.tEb = cz.field_headImageUrl;
                    aVar.username = cz.field_brandUserName;
                }
            }
            if (bi.K(aVar.eCh)) {
                aVar.eCh = this.ujW.getActivity().getResources().getString(R.l.room_head_name);
            }
            if (!bi.oW(aVar.username)) {
                return aVar;
            }
            aVar.username = aVar2.field_brandUserName;
            return aVar;
        }
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
    }

    public final void a(int i, m mVar, Object obj) {
        aMk();
        notifyDataSetChanged();
    }
}
