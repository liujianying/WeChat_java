package com.tencent.mm.aw;

import com.tencent.mm.a.f;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements e {
    public static int chatType = 0;
    private static final f<Integer, a> dzj = new f(5);
    private static d eho;
    public boolean dFt = false;
    private int ecw = 3;

    public static final class b {
        public String eeG = "";
        public int ehg = 0;
        public int ehh = 0;
        public int sampleRate = 0;
    }

    public static String getPrefix() {
        switch (chatType) {
            case 0:
                return "single_";
            case 1:
                return "chatroom_";
            case 2:
                return "app_";
            default:
                return "single_";
        }
    }

    public static int ni(String str) {
        int i = 5;
        if (!(str == null || str.length() == 0)) {
            if (str.startsWith("single")) {
            }
            if (str.startsWith("chatroom")) {
                i = 7;
            }
            if (str.startsWith("app")) {
                i = 8;
            }
            x.d("upload", "type " + i);
        }
        return i;
    }

    public static d RI() {
        if (eho == null) {
            eho = new d();
        }
        return eho;
    }

    public final void release() {
        this.dFt = false;
        g.DF().b(159, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof n) || ((n) lVar).Lf() != 9) {
            x.d("upload", "another scene");
        } else if (lVar.getType() == 159) {
            if (i == 0 && i2 == 0) {
                g.Ek();
                g.Ei().DT().set(81944, Long.valueOf(bi.VE()));
            } else {
                int i3 = this.ecw - 1;
                this.ecw = i3;
                if (i3 < 0) {
                    g.Ek();
                    g.Ei().DT().set(81944, Long.valueOf(((bi.VF() - 86400000) + 3600000) / 1000));
                    this.ecw = 3;
                }
            }
            release();
        }
    }

    public static void RJ() {
        g.Ek();
        g.Ei().DT().set(16646145, Integer.valueOf(0));
    }

    public static void RK() {
        g.Ek();
        Integer valueOf = Integer.valueOf(bi.f((Integer) g.Ei().DT().get(16646145, null)));
        if (valueOf.intValue() < 0) {
            valueOf = Integer.valueOf(0);
        }
        g.Ek();
        g.Ei().DT().set(16646145, Integer.valueOf(valueOf.intValue() + 1));
    }
}
