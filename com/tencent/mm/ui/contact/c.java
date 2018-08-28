package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.selectcontact.a$h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends o implements b {
    private Cursor eCC;
    private int mBL;
    private a uhM;
    private int uhN;
    private int uhO;
    private int uhP;
    private int uhQ;
    private int uhR;
    private int uhS;
    private HashMap<String, Integer> uhT;
    private SparseArray<String> uhU;

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, a aVar, boolean z3) {
        super(mMBaseSelectContactUI, list, z, z2, z3);
        this.uhN = Integer.MAX_VALUE;
        this.mBL = Integer.MAX_VALUE;
        this.uhO = Integer.MAX_VALUE;
        this.uhP = Integer.MAX_VALUE;
        this.uhQ = Integer.MAX_VALUE;
        this.uhR = Integer.MAX_VALUE;
        this.uhS = Integer.MAX_VALUE;
        this.uhT = null;
        this.uhU = null;
        x.i("MicroMsg.AlphabetContactAdapter", "create!");
        if (aVar != null) {
            this.uhM = aVar;
        } else {
            this.uhM = new a();
        }
        g.Ek();
        ((i) g.l(i.class)).FR().a(this);
        aMk();
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, a aVar) {
        this(mMBaseSelectContactUI, list, true, z, aVar, false);
    }

    private void aMk() {
        this.uhN = Integer.MAX_VALUE;
        this.mBL = Integer.MAX_VALUE;
        this.uhO = Integer.MAX_VALUE;
        this.uhP = Integer.MAX_VALUE;
        this.uhQ = Integer.MAX_VALUE;
        this.uhS = Integer.MAX_VALUE;
        if (this.uhT != null) {
            this.uhT.clear();
        } else {
            this.uhT = new HashMap();
        }
        if (this.uhU != null) {
            this.uhU.clear();
        } else {
            this.uhU = new SparseArray();
        }
        List arrayList = new ArrayList();
        int count;
        int i;
        Cursor dm;
        String[] H;
        if (this.uhM.uhZ) {
            g.Ek();
            Cursor h = ((i) g.l(i.class)).FR().h(bi.F(this.uhM.uic.split(",")), false);
            arrayList.add(h);
            count = h.getCount();
            x.d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", new Object[]{Integer.valueOf(count)});
            if (count > 0) {
                this.uhS = 0;
                count = (count + 1) + 0;
                bb(this.uhS, "☆");
                i = count;
            } else {
                this.uhS = Integer.MAX_VALUE;
                i = 0;
            }
            if (this.uhM.ugF == "@all.contact.without.chatroom.without.openim") {
                g.Ek();
                dm = ((i) g.l(i.class)).FR().dm(bi.F(this.uhM.uib.split(",")));
            } else {
                g.Ek();
                dm = ((i) g.l(i.class)).FR().dl(bi.F(this.uhM.uib.split(",")));
            }
            arrayList.add(dm);
            count = dm.getCount();
            if (count > 0) {
                this.uhO = i;
                i += count + 1;
                bb(this.uhO, "☆");
            } else {
                this.uhO = Integer.MAX_VALUE;
            }
            List F = bi.F(this.uhM.uib.split(","));
            g.Ek();
            arrayList.add(((i) g.l(i.class)).FR().h(F, true));
            H = s.H(F);
            int[] G = s.G(F);
            if (!(H == null || G == null)) {
                for (count = 0; count < H.length; count++) {
                    if (count < G.length) {
                        bb(G[count] + i, H[count]);
                        i++;
                    }
                }
                h.getCount();
            }
        } else {
            if (this.uhM.uia) {
                this.uhR = 0;
                bb(this.uhR, "nonLimit");
                i = 1;
            } else {
                i = 0;
            }
            List F2;
            if (this.uhM.uie && this.uhM.uif != null) {
                F2 = bi.F(this.uhM.uif.split(";"));
                g.Ek();
                dm = ((i) g.l(i.class)).FR().dh(F2);
                arrayList.add(dm);
                count = dm.getCount();
                if (count > 0) {
                    this.uhN = i;
                    i += count + 1;
                    bb(this.uhN, "↑");
                } else {
                    this.uhN = Integer.MAX_VALUE;
                }
            } else if (this.uhM.uhV) {
                F2 = g.dR(this.gRN);
                if (F2.size() == 0) {
                    g.Ek();
                    dm = ((i) g.l(i.class)).FR().bdj();
                } else {
                    g.Ek();
                    dm = ((i) g.l(i.class)).FR().dh(F2);
                }
                arrayList.add(dm);
                count = dm.getCount();
                if (count > 0) {
                    this.mBL = i;
                    i += count + 1;
                    bb(this.mBL, "↑");
                } else {
                    this.mBL = Integer.MAX_VALUE;
                }
            }
            if (this.uhM.uhW) {
                if (this.uhM.ugF == "@all.contact.without.chatroom.without.openim") {
                    g.Ek();
                    dm = ((i) g.l(i.class)).FR().do(this.gRN);
                } else {
                    g.Ek();
                    dm = ((i) g.l(i.class)).FR().dn(this.gRN);
                }
                arrayList.add(dm);
                count = dm.getCount();
                if (count > 0) {
                    this.uhO = i;
                    i += count + 1;
                    bb(this.uhO, "☆");
                } else {
                    this.uhO = Integer.MAX_VALUE;
                }
            }
            g.Ek();
            Cursor b = ((i) g.l(i.class)).FR().b(this.uhM.ugF, "", this.gRN);
            arrayList.add(b);
            H = s.a(this.uhM.ugF, "", "", this.gRN);
            int[] b2 = s.b(this.uhM.ugF, "", this.gRN, "");
            if (!(H == null || b2 == null)) {
                int i2 = i;
                for (count = 0; count < H.length; count++) {
                    if (count < b2.length) {
                        bb(b2[count] + i2, H[count]);
                        i2++;
                    }
                }
                i += b.getCount() + H.length;
            }
            if (this.uhM.uhX) {
                g.Ek();
                dm = ((i) g.l(i.class)).FR().c("@all.chatroom.contact", "", this.gRN);
                arrayList.add(dm);
                count = dm.getCount();
                if (count > 0) {
                    this.uhP = i;
                    i += count + 1;
                    bb(this.uhP, this.ujW.getActivity().getString(a$h.address_chatroom_contact_nick));
                } else {
                    this.uhP = Integer.MAX_VALUE;
                }
            }
            if (this.uhM.uhY) {
                g.Ek();
                dm = ((i) g.l(i.class)).FR().c("@verify.contact", "", this.gRN);
                arrayList.add(dm);
                if (dm.getCount() > 0) {
                    this.uhQ = i;
                    bb(this.uhQ, this.ujW.getActivity().getString(a$h.select_contact_official_accounts_title));
                } else {
                    this.uhQ = Integer.MAX_VALUE;
                }
            }
        }
        x.d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", new Object[]{this.uhT.toString()});
        this.eCC = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
    }

    private void bb(int i, String str) {
        this.uhT.put(str, Integer.valueOf(i));
        this.uhU.put(i, str);
    }

    public final int aaJ(String str) {
        if (str.equals("↑")) {
            return 0;
        }
        if (this.uhT == null || !this.uhT.containsKey(str)) {
            return -1;
        }
        return ((Integer) this.uhT.get(str)).intValue() + this.ujW.getContentLV().getHeaderViewsCount();
    }

    public final int getCount() {
        return this.eCC.getCount() + this.uhT.size();
    }

    protected final a iW(int i) {
        if (i == this.uhS) {
            return bc(i, this.ujW.getActivity().getString(a$h.select_contact_wechat_sport_recent_like_contact_name));
        }
        if (i == this.uhN) {
            return bc(i, this.uhM.uig);
        }
        if (i == this.mBL) {
            return bc(i, this.ujW.getActivity().getString(a$h.select_contact_near_contact_catalog_name));
        }
        if (i == this.uhO) {
            return bc(i, this.ujW.getActivity().getString(a$h.select_contact_favour_contact_catalog_name));
        }
        if (i == this.uhP) {
            return bc(i, this.ujW.getActivity().getString(a$h.address_chatroom_contact_nick));
        }
        if (i == this.uhQ) {
            return bc(i, this.ujW.getActivity().getString(a$h.select_contact_official_accounts_title));
        }
        if (i == this.uhR) {
            return new j(i);
        }
        if (this.uhU.indexOfKey(i) >= 0) {
            return bc(i, (String) this.uhU.get(i));
        }
        int i2 = i;
        int i3 = 0;
        while (i3 <= this.uhU.size()) {
            if (this.uhU.indexOfKey(i2) >= 0) {
                i3++;
            }
            i2--;
            if (i2 < 0) {
                break;
            }
        }
        if (this.eCC.moveToPosition(i - i3)) {
            x.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i - i3)});
            ab abVar = new ab();
            abVar.d(this.eCC);
            a dVar = new d(i);
            dVar.guS = abVar;
            dVar.ujX = bwq();
            dVar.ujY = this.ujY;
            return dVar;
        }
        x.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i - i3)});
        return null;
    }

    private static a bc(int i, String str) {
        com.tencent.mm.ui.contact.a.g gVar = new com.tencent.mm.ui.contact.a.g(i);
        gVar.jyx = str;
        return gVar;
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.AlphabetContactAdapter", "finish!");
        if (this.eCC != null) {
            this.eCC.close();
            this.eCC = null;
        }
        g.Ek();
        ((i) g.l(i.class)).FR().b(this);
    }

    public final void a(int i, m mVar, Object obj) {
        aMk();
        notifyDataSetChanged();
    }

    protected final boolean c(a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.uhS, this.uhN, this.mBL, this.uhO, this.uhP, this.uhQ};
        for (int i2 = 0; i2 < 6; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        if (this.uhU.indexOfKey(i) < 0) {
            return false;
        }
        return true;
    }
}
