package com.tencent.mm.k;

import com.tencent.mm.g.a.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {
    private HashMap<String, String> dgV = new HashMap();
    public boolean dgW = false;

    public final synchronized String getValue(String str) {
        if (!this.dgW) {
            x.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            kS();
        }
        x.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", str.trim(), this.dgV.get(str));
        return (String) this.dgV.get(str);
    }

    public final int getInt(String str, int i) {
        try {
            return Integer.parseInt(getValue(str));
        } catch (Exception e) {
            x.e("MicroMsg.DynamicConfig", "parseInt failed, val: " + str);
            return i;
        }
    }

    public final synchronized List<String> fl(String str) {
        List<String> arrayList;
        if (!this.dgW) {
            x.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            kS();
        }
        arrayList = new ArrayList();
        if (!bi.oW(str)) {
            for (String str2 : this.dgV.keySet()) {
                if (str2.matches(str)) {
                    arrayList.add(this.dgV.get(str2));
                }
            }
        }
        x.d("MicroMsg.DynamicConfig", "searchValues, entry:%s, size:%d", str, Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    @Deprecated
    public final synchronized void put(String str, String str2) {
        if (!(str == null || str2 == null)) {
            x.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", str.trim(), str2);
            this.dgV.put(str, str2);
        }
    }

    public synchronized void kS() {
        g.Ek();
        if (g.Ei() != null) {
            g.Ek();
            if (g.Ei().DT() != null) {
                this.dgW = true;
                g.Ek();
                n((String) g.Ei().DT().get(278529, null), false);
            }
        }
        g.Ek();
        if (g.Ei() != null) {
            g.Ek();
            if (g.Ei().DT() != null) {
                this.dgW = true;
                g.Ek();
                n((String) g.Ei().DT().get(278530, null), true);
            }
        }
    }

    public final synchronized void a(String str, Map<String, String> map, boolean z) {
        if (!bi.oW(str)) {
            x.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", Boolean.valueOf(z), com.tencent.mm.a.g.cu(str));
            if (z) {
                g.Ek();
                g.Ei().DT().set(278530, str);
            } else {
                g.Ek();
                g.Ei().DT().set(278529, str);
                g.Ek();
                g.Ei().DT().set(278530, "");
            }
            if (map != null) {
                b(map, z);
            } else {
                n(str, z);
            }
            a.sFg.m(new cm());
        }
    }

    public final void n(String str, boolean z) {
        b(bl.z(str, "sysmsg"), z);
    }

    private void b(Map<String, String> map, boolean z) {
        if (map != null) {
            if (!z) {
                this.dgV.clear();
            }
            int i = 0;
            while (i < 10000) {
                String str;
                if (z) {
                    str = ".sysmsg.dynacfg_split.Item" + (i == 0 ? "" : Integer.valueOf(i));
                } else {
                    str = ".sysmsg.dynacfg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                }
                String str2 = str + ".$key";
                str = (String) map.get(str);
                str2 = (String) map.get(str2);
                if (str2 == null || bi.oW(str2.trim())) {
                    break;
                }
                this.dgV.put(str2.trim(), str != null ? str : "");
                x.d("MicroMsg.DynamicConfig", "put %s %s", str2.trim(), str);
                i++;
            }
            x.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", this.dgV.toString());
        }
    }
}
