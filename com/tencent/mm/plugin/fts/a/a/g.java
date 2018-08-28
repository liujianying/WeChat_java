package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

public final class g {
    private static final a jsa = new 1();
    public String jrV;
    public String jrW;
    public String[] jrX;
    public String[] jrY;
    public List<c> jrZ = new ArrayList();

    public interface a {
        String[] CB(String str);

        String[] split(String str);
    }

    private g() {
    }

    public final String aQa() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jrZ.size()) {
                return stringBuffer.toString();
            }
            stringBuffer.append("(");
            stringBuffer.append(((c) this.jrZ.get(i2)).aQb());
            stringBuffer.append(")");
            if (i2 != this.jrZ.size() - 1) {
                stringBuffer.append(" AND ");
            }
            i = i2 + 1;
        }
    }

    public static g ax(String str, boolean z) {
        return a(str, z, jsa);
    }

    public static g a(String str, boolean z, a aVar) {
        g gVar = new g();
        gVar.jrV = str;
        gVar.jrW = d.Cv(str);
        gVar.jrX = aVar.split(gVar.jrW);
        gVar.jrY = aVar.CB(gVar.jrW);
        for (String str2 : gVar.jrX) {
            int i;
            boolean z2;
            List list = gVar.jrZ;
            if (z) {
                for (i = 0; i < str2.length(); i++) {
                    if (!com.tencent.mm.plugin.fts.a.g.j(str2.charAt(i))) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = z;
            c cVar = new c();
            b bVar;
            if (z2) {
                b bVar2 = com.tencent.mm.plugin.fts.a.g.jrl;
                List arrayList = new ArrayList();
                char[] toCharArray = str2.toLowerCase().toCharArray();
                for (i = 0; i < toCharArray.length; i++) {
                    if (bVar2.jsQ.jsR[toCharArray[i] - 97] == null) {
                        arrayList.clear();
                        break;
                    }
                    arrayList.add(String.valueOf(toCharArray[i]));
                }
                if (arrayList.size() > 0) {
                    bVar = new b();
                    bVar.jsc = d.jsg;
                    bVar.content = bi.c(arrayList, "​");
                    bVar.jsd = arrayList;
                    cVar.jse.add(bVar);
                }
                List<List> CD = com.tencent.mm.plugin.fts.a.g.jrl.CD(str2);
                if (CD.size() > 0) {
                    for (List list2 : CD) {
                        if (list2.size() > 0) {
                            b bVar3 = new b();
                            bVar3.jsc = d.jsf;
                            bVar3.content = bi.c(list2, "​");
                            bVar3.jsd = list2;
                            cVar.jse.add(bVar3);
                        }
                    }
                }
                bVar = new b();
                bVar.jsc = d.jsh;
                bVar.content = str2;
                cVar.jse.add(bVar);
            } else {
                bVar = new b();
                bVar.jsc = d.jsh;
                bVar.content = str2;
                cVar.jse.add(bVar);
            }
            list.add(cVar);
        }
        return gVar;
    }
}
