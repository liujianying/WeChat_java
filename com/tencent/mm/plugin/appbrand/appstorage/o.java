package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class o extends g {
    private final ag fgC;

    public o(ag agVar) {
        this.fgC = agVar;
    }

    public final boolean bV(String str) {
        return true;
    }

    public final j ra(String str) {
        Closeable qN = this.fgC.qN(str);
        if (qN == null) {
            return j.fkO;
        }
        bi.d(qN);
        return j.fkI;
    }

    public final j b(String str, h<List<h>> hVar) {
        if (ra(str) == j.fkI) {
            return j.fkQ;
        }
        String qC = a.qC(str);
        ag agVar = this.fgC;
        List<ag.a> linkedList = new LinkedList();
        for (ag.a add : agVar.fhb.values()) {
            linkedList.add(add);
        }
        String quote = Pattern.quote(qC);
        for (ag.a add2 : linkedList) {
            if (add2.fileName.startsWith(qC)) {
                String replaceFirst = add2.fileName.replaceFirst(quote, "");
                if (replaceFirst.split("/").length <= 1) {
                    Object linkedList2;
                    h hVar2 = new h();
                    hVar2.fileName = replaceFirst;
                    if (hVar.value == null) {
                        linkedList2 = new LinkedList();
                    } else {
                        List linkedList22 = (List) hVar.value;
                    }
                    hVar.value = linkedList22;
                    ((List) hVar.value).add(hVar2);
                }
            }
        }
        return hVar.value == null ? j.fkO : j.fkI;
    }

    public final j rf(String str) {
        return b(str, new h());
    }

    public final j a(String str, h<ByteBuffer> hVar) {
        Closeable qN = this.fgC.qN(str);
        if (qN == null) {
            return j.fkO;
        }
        j jVar;
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(qN.available());
            if (qN instanceof com.tencent.mm.plugin.appbrand.l.a) {
                allocateDirect.put(((com.tencent.mm.plugin.appbrand.l.a) qN).gqu);
            } else {
                allocateDirect.put(ByteBuffer.wrap(c.p(qN)));
            }
            allocateDirect.rewind();
            hVar.value = allocateDirect;
            jVar = j.fkI;
            return jVar;
        } catch (Exception e) {
            jVar = e;
            x.printErrStackTrace("MicroMsg.WxaPkgFileSystem", jVar, "readFile", new Object[0]);
            return j.fkJ;
        } finally {
            bi.d(qN);
        }
    }

    public final j a(String str, FileStructStat fileStructStat) {
        Closeable qN = this.fgC.qN(str);
        if (qN == null) {
            return j.fkO;
        }
        ag agVar = this.fgC;
        FileStructStat fileStructStat2 = agVar.fhc;
        if (fileStructStat2 == null) {
            fileStructStat2 = new FileStructStat();
            FileStat.stat(agVar.fgV.getAbsolutePath(), fileStructStat2);
            agVar.fhc = fileStructStat2;
        }
        fileStructStat2.fillAnother(fileStructStat);
        try {
            fileStructStat.st_size = (long) qN.available();
            bi.d(qN);
        } catch (Exception e) {
            x.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", new Object[]{str});
        }
        return j.fkI;
    }

    public final void initialize() {
        this.fgC.abW();
    }

    public final void release() {
        this.fgC.close();
    }
}
