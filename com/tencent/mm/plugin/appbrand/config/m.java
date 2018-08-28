package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.byl;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.protocal.c.zd;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class m {

    public static class a {
        private static String as(String str, int i) {
            return String.format("%s_%s_local_version", new Object[]{str, Integer.valueOf(i)});
        }

        public static String at(String str, int i) {
            return String.format("%s_%s_server_version", new Object[]{str, Integer.valueOf(i)});
        }

        private static String au(String str, int i) {
            return String.format("%s_%s_config", new Object[]{str, Integer.valueOf(i)});
        }

        public static void A(String str, int i, int i2) {
            if (e.abf() != null) {
                e.abf().bd(as(str, i), String.valueOf(i2));
            }
        }

        public static void B(String str, int i, int i2) {
            if (e.abf() != null) {
                e.abf().bd(at(str, i), String.valueOf(i2));
            }
        }

        public static void h(String str, int i, String str2) {
            if (e.abf() != null) {
                e.abf().bd(au(str, i), str2);
            }
        }

        public static int av(String str, int i) {
            if (e.abf() == null) {
                return 0;
            }
            return bi.getInt(e.abf().get(as(str, i), "0"), 0);
        }

        public static String aw(String str, int i) {
            if (e.abf() == null) {
                return "";
            }
            return e.abf().get(au(str, i), "");
        }
    }

    public interface b {
        void a(int i, int i2, String str, com.tencent.mm.ab.b bVar);
    }

    public interface c {
        void qR(String str);
    }

    public static void a(String str, LinkedList<byl> linkedList) {
        a(str, linkedList, true);
    }

    public static void a(String str, LinkedList<byl> linkedList, boolean z) {
        if (bi.oW(str)) {
            x.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
        } else if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
        } else {
            LinkedList linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                byl byl = (byl) it.next();
                x.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[]{Integer.valueOf(byl.version), Integer.valueOf(byl.type)});
                int av = a.av(str, byl.type);
                int i = byl.version;
                a.B(str, byl.type, i);
                if (i != 0) {
                    if (i > av) {
                        linkedList2.add(z(str, byl.type, byl.version));
                    } else if (i != av) {
                        x.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[]{Integer.valueOf(av), Integer.valueOf(i)});
                        if (bi.oW(a.aw(str, byl.type))) {
                            linkedList2.add(z(str, byl.type, byl.version));
                        }
                    } else if (bi.oW(a.aw(str, byl.type))) {
                        linkedList2.add(z(str, byl.type, byl.version));
                    }
                }
            }
            x.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[]{str, Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size())});
            if (z && linkedList2.size() != 0) {
                x.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[]{str});
                a(linkedList2, new 1(str));
            }
        }
    }

    private static zc z(String str, int i, int i2) {
        zc zcVar = new zc();
        zcVar.jQb = str;
        zcVar.hcE = i;
        zcVar.rcV = i2;
        return zcVar;
    }

    public static String a(String str, int i, int i2, c cVar, boolean z) {
        if (e.abf() == null) {
            return "";
        }
        boolean z2;
        int av = a.av(str, i);
        int i3 = e.abf() == null ? 0 : bi.getInt(e.abf().get(a.at(str, i), "0"), 0);
        String aw = a.aw(str, i);
        if (i3 == 0 || (!bi.oW(aw) && i3 <= av)) {
            z2 = false;
        } else {
            z2 = true;
        }
        x.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(av)});
        x.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[]{aw, Boolean.valueOf(z2)});
        if (!z2) {
            cVar.qR(aw);
        } else if (z) {
            b 2 = new 2(cVar, str);
            LinkedList linkedList = new LinkedList();
            zc zcVar = new zc();
            zcVar.jQb = str;
            zcVar.hcE = i;
            zcVar.rcV = i3;
            zcVar.rFj = i2;
            linkedList.add(zcVar);
            a(linkedList, 2);
        }
        return aw;
    }

    private static void a(LinkedList<zc> linkedList, b bVar) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIF = 1138;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
        aVar.dIH = new ze();
        aVar.dII = 0;
        aVar.dIJ = 0;
        zd zdVar = new zd();
        zdVar.rFk = linkedList;
        aVar.dIG = zdVar;
        v.a(aVar.KT(), new 3(bVar), true);
    }
}
