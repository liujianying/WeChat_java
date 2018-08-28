package com.tencent.mm.modelstat;

import android.util.Pair;
import com.tencent.mm.modelstat.c.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class c$a {
    List<c> eiA = new ArrayList();
    Map<String, Boolean> eiq = new HashMap();
    long eir;
    long eis;

    static class a extends Exception {
        a(String str) {
            super(str);
        }

        a(Throwable th) {
            super(th);
        }
    }

    private c$a() {
    }

    public final String toString() {
        return "Config{nextUpdateInterval=" + this.eir + ", samplePeriod=" + this.eis + ", eventList=" + this.eiA + '}';
    }

    static c$a nk(String str) {
        c$a c_a = new c$a();
        try {
            Map z = bl.z(str, "eventSampleConf");
            if (z == null) {
                x.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", new Object[]{str});
                throw new a("reportConfigMap is null");
            }
            c_a.eir = bi.getLong((String) z.get(".eventSampleConf.nextUpdateInterval"), 0);
            if (c_a.eir <= 0 || c_a.eir > 432000) {
                c_a.eir = 432000;
            }
            c_a.eis = bi.getLong((String) z.get(".eventSampleConf.samplePeriod"), 0);
            int i = 0;
            while (true) {
                c cVar = new c((byte) 0);
                String str2 = ".eventSampleConf.events.event" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                int i2 = i + 1;
                cVar.id = bi.getInt((String) z.get(str2 + "id"), 0);
                if (cVar.id > 0) {
                    String str3;
                    int i3;
                    String str4;
                    cVar.eiD = bi.getLong((String) z.get(str2 + "expireTime"), 0);
                    cVar.name = (String) z.get(str2 + "name");
                    cVar.eiE = bi.getFloat((String) z.get(str2 + "rate"), 0.0f);
                    cVar.eiF = bi.getInt((String) z.get(str2 + "logId"), 0);
                    cVar.eiG = (String) z.get(str2 + "pages.$type");
                    ArrayList arrayList = new ArrayList();
                    i = 0;
                    while (true) {
                        str3 = str2 + "pages.page" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                        i3 = i + 1;
                        str4 = (String) z.get(str3 + "$id");
                        if (str4 == null) {
                            break;
                        }
                        boolean equals = ((String) z.get(str3 + "$action")).equals("true");
                        arrayList.add(new Pair(str4, Boolean.valueOf(equals)));
                        c_a.eiq.put(str4, Boolean.valueOf(equals));
                        i = i3;
                    }
                    cVar.eiH = arrayList;
                    arrayList = new ArrayList();
                    i = 0;
                    while (true) {
                        str3 = str2 + "specialPVPages.pageItem" + (i > 0 ? Integer.valueOf(i) : "") + ".";
                        i3 = i + 1;
                        str4 = (String) z.get(str3 + "$prePage");
                        if (str4 == null) {
                            break;
                        }
                        arrayList.add(new Pair(str4, (String) z.get(str3 + "$page")));
                        i = i3;
                    }
                    cVar.eiI = arrayList;
                    c_a.eiA.add(cVar);
                    x.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", new Object[]{cVar});
                    i = i2;
                } else {
                    x.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", new Object[]{c_a});
                    return c_a;
                }
            }
        } catch (Throwable e) {
            throw new a(e);
        }
    }
}
