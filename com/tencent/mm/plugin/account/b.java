package com.tencent.mm.plugin.account;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.LinkedList;

public class b implements ar {
    private static HashMap<Integer, d> cVM;
    private k eEA;
    private an eEB;
    private ap eEC;
    private q eED;
    private o eEE;
    private com.tencent.mm.plugin.account.friend.a.d eEF = new com.tencent.mm.plugin.account.friend.a.d();
    private LinkedList<arf> eEG = null;
    private c eEH = new c();
    private e eEI = new e();
    private f eEJ = new f();
    private com.tencent.mm.sdk.b.c eEK = new 1(this);
    private com.tencent.mm.sdk.b.c eEL = new 5(this);
    private com.tencent.mm.sdk.b.c eEM = new 6(this);
    private com.tencent.mm.sdk.b.c eEN = new 3(this);
    private com.tencent.mm.plugin.account.friend.a.b eEy;
    private h eEz;

    private static synchronized b WD() {
        b bVar;
        synchronized (b.class) {
            bVar = (b) p.v(b.class);
        }
        return bVar;
    }

    public static com.tencent.mm.plugin.account.friend.a.b getAddrUploadStg() {
        g.Eg().Ds();
        if (WD().eEy == null) {
            WD().eEy = new com.tencent.mm.plugin.account.friend.a.b(g.Ei().dqq);
        }
        return WD().eEy;
    }

    public static h getFacebookFrdStg() {
        g.Eg().Ds();
        if (WD().eEz == null) {
            WD().eEz = new h(g.Ei().dqq);
        }
        return WD().eEz;
    }

    public static k getFrdExtStg() {
        g.Eg().Ds();
        if (WD().eEA == null) {
            WD().eEA = new k(g.Ei().dqq);
        }
        return WD().eEA;
    }

    public static an getQQGroupStg() {
        g.Eg().Ds();
        if (WD().eEB == null) {
            WD().eEB = new an(g.Ei().dqq);
        }
        return WD().eEB;
    }

    public static q getInviteFriendOpenStg() {
        g.Eg().Ds();
        if (WD().eED == null) {
            WD().eED = new q(g.Ei().dqq);
        }
        return WD().eED;
    }

    public static ap getQQListStg() {
        g.Eg().Ds();
        if (WD().eEC == null) {
            WD().eEC = new ap(g.Ei().dqq);
        }
        return WD().eEC;
    }

    public static void setFriendData(LinkedList<arf> linkedList) {
        g.Eg().Ds();
        WD().eEG = linkedList;
    }

    public static LinkedList<arf> getFriendData() {
        g.Eg().Ds();
        return WD().eEG;
    }

    public static void clearFriendData() {
        g.Eg().Ds();
        WD().eEG = null;
    }

    public final void onAccountRelease() {
        a.sFg.c(this.eEN);
        a.sFg.c(this.eEM);
        a.sFg.c(this.eEH);
        a.sFg.c(this.eEI);
        a.sFg.c(this.eEJ);
        a.sFg.c(this.eEK);
        a.sFg.c(this.eEL);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(42), this.eEF);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(66), this.eEF);
        this.eEG = null;
    }

    public final void gi(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new 7());
        cVM.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new 8());
        cVM.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new 9());
        cVM.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new 10());
        cVM.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new 11());
        cVM.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new 12());
        cVM.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new 2());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void bn(boolean z) {
        com.tencent.mm.ab.d.c.a(Integer.valueOf(42), this.eEF);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(66), this.eEF);
        a.sFg.b(this.eEN);
        a.sFg.b(this.eEM);
        a.sFg.b(this.eEH);
        a.sFg.b(this.eEI);
        a.sFg.b(this.eEJ);
        a.sFg.b(this.eEK);
        a.sFg.b(this.eEL);
        ((n) g.n(n.class)).getFTSTaskDaemon().a(-86016, new 4(this));
    }

    public final void bo(boolean z) {
    }

    public static o getGoogleFriendStorage() {
        g.Eg().Ds();
        if (WD().eEE == null) {
            WD().eEE = new o(g.Ei().dqq);
        }
        return WD().eEE;
    }
}
