package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.g.a;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h extends e<ate> {
    private String kCA = "";
    private List<ate> list = new ArrayList();
    private int nKI = 0;
    private int nKJ = 0;
    private dx nKZ;
    private cj nLa;
    private a nLb;
    private String path = "";

    public h(a aVar) {
        this.nLb = aVar;
    }

    public final void cq(List<ate> list) {
        if (this.nLb == null) {
            return;
        }
        if (list != null) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            hashMap.clear();
            hashMap2.clear();
            int size = list.size();
            x.d("MicroMsg.ArtistAdapterHelper", "initFixType " + size);
            int i = 0;
            int i2 = 0;
            int i3;
            for (int i4 = 0; i4 < size; i4 = i3 + i4) {
                String str = ((ate) list.get(i4)).jOS;
                i3 = i4 + 1 < size ? !str.equals(((ate) list.get(i4 + 1)).jOS) ? 1 : i4 + 2 < size ? !str.equals(((ate) list.get(i4 + 2)).jOS) ? 2 : 3 : 2 : 1;
                hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                hashMap2.put(Integer.valueOf(i), Integer.valueOf(i3));
                i2 += i3;
                i++;
            }
            this.nKI = i + 1;
            this.nKJ = list.size();
            x.d("MicroMsg.ArtistAdapterHelper", "icount " + this.nKI);
            this.list = list;
            this.nLb.a(this.list, hashMap, hashMap2, this.nKJ, this.nKI, this.nKZ);
            return;
        }
        this.nLb.bBJ();
    }

    public final List<ate> bBI() {
        List<ate> arrayList = new ArrayList();
        try {
            arrayList.clear();
            this.nLa = null;
            String str = this.path + this.kCA + "_ARTISTF.mm";
            if (FileOp.cn(str)) {
                this.nLa = (cj) new cj().aG(FileOp.e(str, 0, -1));
            }
            if (this.nLa == null) {
                String str2 = this.path + this.kCA + "_ARTIST.mm";
                this.nLa = a.MP(new String(FileOp.e(str2, 0, (int) FileOp.mI(str2))));
                if (this.nLa == null) {
                    FileOp.deleteFile(str2);
                    return null;
                }
                FileOp.deleteFile(str);
                FileOp.l(str, this.nLa.toByteArray());
            }
            if (this.nLa == null) {
                return null;
            }
            Iterator it = this.nLa.rcM.iterator();
            while (it.hasNext()) {
                alh alh = (alh) it.next();
                String str3 = alh.jPe;
                Iterator it2 = alh.ruA.iterator();
                while (it2.hasNext()) {
                    ate ate = (ate) it2.next();
                    ate.jOS = str3;
                    arrayList.add(ate);
                }
            }
            this.nKZ = this.nLa.rcL;
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ArtistAdapterHelper", e, "loadData failed.", new Object[0]);
            return null;
        }
    }

    public final void eO(String str, String str2) {
        this.kCA = str;
        this.path = str2;
        fu(true);
    }
}
