package com.tencent.mm.protocal;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n {
    public String host = "";
    public String kCs = "";
    private int port = 80;
    private int type = 0;

    public static class a {
        public final int[] qWI = null;
        public final int[] qWJ;
        public final int qWK;
        public final int qWL;

        public a(int[] iArr, int i, int i2) {
            this.qWJ = iArr;
            this.qWK = i;
            this.qWL = i2;
        }
    }

    public n(int i, String str, int i2, String str2) {
        this.type = i;
        this.kCs = str;
        this.port = i2;
        this.host = str2;
    }

    public final String toString() {
        return this.type + "," + this.kCs + "," + this.port + "," + this.host;
    }

    private static n Uy(String str) {
        String[] split = str.split(",");
        if (split.length < 4) {
            return null;
        }
        n nVar = new n();
        try {
            nVar.type = bi.getInt(split[0], 0);
            nVar.kCs = bi.oV(split[1]);
            nVar.port = bi.getInt(split[2], 0);
            nVar.host = bi.oV(split[3]);
            return nVar;
        } catch (Throwable e) {
            x.e("MicroMsg.MMBuiltInIP", "exception:%s", bi.i(e));
            return null;
        }
    }

    public static String cV(List<n> list) {
        String str = "";
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            str = str2 + ((n) it.next()).toString() + "|";
        }
    }

    public static List<n> Uz(String str) {
        List linkedList = new LinkedList();
        if (!bi.oW(str)) {
            try {
                for (String Uy : str.split("\\|")) {
                    n Uy2 = Uy(Uy);
                    if (Uy2 != null) {
                        linkedList.add(Uy2);
                    }
                }
            } catch (Throwable e) {
                x.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", str);
                x.e("MicroMsg.MMBuiltInIP", "exception:%s", bi.i(e));
            }
        }
        return linkedList;
    }

    public static a fJ(String str, String str2) {
        x.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
        x.d("MicroMsg.MMBuiltInIP", "ports = " + str);
        x.d("MicroMsg.MMBuiltInIP", "timeouts = " + str2);
        int[] WQ = bi.WQ(str);
        int[] WQ2 = bi.WQ(str2);
        if (WQ2 == null || WQ2.length < 2) {
            WQ2 = new int[]{0, 0};
            x.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
        }
        return new a(WQ, (int) (((long) WQ2[0]) * 1000), (int) (((long) WQ2[1]) * 1000));
    }
}
