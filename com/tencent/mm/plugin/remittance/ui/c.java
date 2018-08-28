package com.tencent.mm.plugin.remittance.ui;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class c extends o implements b {
    private Cursor eCC;
    private int fromScene;
    int mBK;
    int mBL;
    private List<String> mBM;
    private int mBN = 0;

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2, int i) {
        super(mMBaseSelectContactUI, list2, true, false);
        this.mBM = list;
        this.fromScene = i;
        x.i("MicroMsg.RecentConversationAdapter", "create!");
        aMk();
        ((i) g.l(i.class)).FW().a(this);
    }

    private void aMk() {
        int i;
        Cursor di;
        List list;
        x.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
        this.mBN = 0;
        List arrayList = new ArrayList();
        this.mBK = -1;
        this.mBL = -1;
        if (this.mBM == null || this.mBM.size() <= 0) {
            i = 0;
        } else {
            g.Ek();
            di = ((i) g.l(i.class)).FR().di(this.mBM);
            arrayList.add(di);
            int count = di.getCount();
            if (count > 0) {
                this.mBK = this.ujW.getContentLV().getHeaderViewsCount();
                this.mBN++;
                i = count;
            } else {
                this.mBK = -1;
                i = count;
            }
        }
        List list2 = this.gRN;
        if (list2 != null) {
            list2.addAll(this.mBM);
            list = list2;
        } else {
            list = this.mBM;
        }
        if (this.fromScene == 1) {
            di = ((i) g.l(i.class)).FW().a(s.dAO, list, this.ukn, "");
        } else {
            di = ((i) g.l(i.class)).FW().a(s.dAS, list, this.ukn, "");
        }
        if (di.getCount() > 0) {
            this.mBN++;
            if (i > 0) {
                this.mBL = (i + this.mBK) + 1;
            } else {
                this.mBL = this.ujW.getContentLV().getHeaderViewsCount();
            }
        } else {
            this.mBL = -1;
        }
        arrayList.add(di);
        this.eCC = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
    }

    protected final a iW(int i) {
        if (i == this.mBL || i == this.mBK) {
            a gVar = new com.tencent.mm.ui.contact.a.g(i);
            if (i == this.mBK) {
                if (this.fromScene == 1) {
                    gVar.jyx = this.ujW.getActivity().getResources().getString(com.tencent.mm.plugin.wxpay.a.i.aa_recent_group);
                    return gVar;
                }
                gVar.jyx = this.ujW.getActivity().getResources().getString(com.tencent.mm.plugin.wxpay.a.i.remittance_recent_friends);
                return gVar;
            } else if (i != this.mBL) {
                return gVar;
            } else {
                gVar.jyx = this.ujW.getActivity().getResources().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_select_conversation_cur);
                return gVar;
            }
        }
        int i2;
        if (this.mBN == 2) {
            if (i > this.mBL) {
                i2 = i - 2;
            } else {
                i2 = i - 1;
            }
        } else if (this.mBN == 1) {
            i2 = i - 1;
        } else {
            x.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[]{Integer.valueOf(i)});
            i2 = i;
        }
        if (!this.eCC.moveToPosition(i2)) {
            return null;
        }
        e eVar = new e(i);
        ai aiVar = new ai();
        aiVar.d(this.eCC);
        g.Ek();
        eVar.guS = ((i) g.l(i.class)).FR().Yb(aiVar.field_username);
        if (eVar.guS == null) {
            g.Ek();
            eVar.guS = ((i) g.l(i.class)).FR().Yf(aiVar.field_username);
        }
        return eVar;
    }

    public final int getCount() {
        return this.eCC.getCount() + this.mBN;
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
