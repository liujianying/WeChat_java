package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j {
    List<a> cWy;
    long mcE = 0;
    private e mcF;
    a mcG;
    private int mcH = 0;
    int mcI = 1;
    private int mcJ = 2;
    int mcK = 3;
    int status = this.mcH;

    j(String str) {
        this.mcF = new e(str, 1);
        byte[] readFromFile = e.readFromFile(this.mcF.mcn + "address");
        if (readFromFile != null) {
            this.mcF.a("address", null, readFromFile);
            e.deleteFile(this.mcF.mcn + "address");
        } else {
            readFromFile = this.mcF.m("address", null);
        }
        if (readFromFile != null) {
            try {
                this.mcG = new a().aF(readFromFile);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
                this.mcG = new a();
                this.mcG.JN("");
            }
        } else {
            this.mcG = new a();
            this.mcG.JN("");
        }
        this.cWy = new ArrayList();
    }

    protected final void finalize() {
        this.cWy.clear();
    }

    public final List<i> JS(String str) {
        List<i> list = this.mcG.mca;
        if (this.status <= this.mcI) {
            bom();
            return list;
        } else if (str == null || str.length() == 0) {
            return list;
        } else {
            List<i> arrayList = new ArrayList();
            for (i iVar : list) {
                if (iVar != null && ((iVar.name != null && iVar.name.contains(str)) || ((iVar.mcD != null && iVar.mcD.contains(str)) || (iVar.kCs != null && iVar.kCs.contains(str))))) {
                    a.b(iVar);
                    arrayList.add(iVar);
                }
            }
            return arrayList;
        }
    }

    public final void bom() {
        if (this.status != this.mcJ) {
            if (bi.VF() - this.mcE <= 600000) {
                for (a onComplete : this.cWy) {
                    onComplete.onComplete();
                }
                return;
            }
            this.status = this.mcJ;
            Map hashMap = new HashMap();
            hashMap.put("syncinfo", this.mcG.mbY == null ? "" : this.mcG.mbY);
            x.d("MicroMsg.Plugin.MailAddrMgr", "%s", new Object[]{"sync~~~"});
            w.bow().b("/cgi-bin/syncaddrlist", hashMap, new c(), new 1(this));
        }
    }

    public final void a(a aVar) {
        for (a aVar2 : this.cWy) {
            if (aVar2 == aVar) {
                return;
            }
        }
        this.cWy.add(aVar);
    }

    public final void b(a aVar) {
        for (a aVar2 : this.cWy) {
            if (aVar2 == aVar) {
                this.cWy.remove(aVar2);
                return;
            }
        }
    }

    public final void bL(List<i> list) {
        a aVar = this.mcG;
        if (!(list == null || list.size() == 0)) {
            for (i iVar : list) {
                int i = 0;
                Iterator it = aVar.mca.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    i iVar2 = (i) it.next();
                    if (iVar2.kCs.equalsIgnoreCase(iVar.kCs)) {
                        aVar.uT(i2);
                        iVar2.mcC++;
                        aVar.a(iVar2);
                        break;
                    }
                    i = i2 + 1;
                }
            }
        }
        save();
    }

    final void save() {
        try {
            this.mcF.a("address", null, this.mcG.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
        }
    }

    public static i JT(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        int lastIndexOf = trim.trim().lastIndexOf(" ");
        if (lastIndexOf == -1) {
            return null;
        }
        i iVar = new i();
        iVar.name = trim.substring(0, lastIndexOf);
        iVar.kCs = trim.substring(lastIndexOf + 1);
        return iVar;
    }
}
