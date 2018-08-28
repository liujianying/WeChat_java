package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.protocal.c.bye;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class m extends l implements k {
    public int bOh;
    public final b diG;
    private e diJ;
    public String eLb;
    public List<String> qyZ;
    public String qza;
    private List<String> qzb;

    private m(String str, String str2, int i) {
        this.qyZ = null;
        this.bOh = 0;
        this.qzb = null;
        Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
        this.qyZ = new LinkedList();
        this.qyZ.add(str);
        this.bOh = 3;
        a aVar = new a();
        aVar.dIG = new byd();
        aVar.dIH = new bye();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.dIF = 137;
        aVar.dII = 44;
        aVar.dIJ = 1000000044;
        this.diG = aVar.KT();
        byd byd = (byd) this.diG.dID.dIL;
        byd.rfe = 3;
        byd.rKZ = "";
        LinkedList linkedList = new LinkedList();
        byb byb = new byb();
        byb.mEl = str;
        byb.sud = str2;
        byb.rEJ = com.tencent.mm.plugin.d.a.ZN().Gw().XH(str);
        byb.siA = null;
        linkedList.add(byb);
        byd.suk = linkedList;
        byd.suj = linkedList.size();
        linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        byd.sum = linkedList;
        byd.sul = linkedList.size();
        byd.rTr = new bhy().bq(com.tencent.mm.plugin.normsg.a.b.lFJ.bjE());
        x.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s", new Object[]{Integer.valueOf(byd.suk.size()), Integer.valueOf(byd.sum.size()), str2, byb.rEJ});
    }

    public m(int i, List<String> list, List<Integer> list2, List<String> list3, String str, String str2, Map<String, Integer> map, String str3, String str4) {
        List list32;
        int i2;
        int i3;
        int i4;
        this.qyZ = null;
        this.bOh = 0;
        this.qzb = null;
        Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", i != 3);
        this.bOh = i;
        this.qyZ = list;
        if (list32 == null || list32.size() == 0) {
            list32 = new LinkedList();
        }
        a aVar = new a();
        aVar.dIG = new byd();
        aVar.dIH = new bye();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.dIF = 137;
        aVar.dII = 44;
        aVar.dIJ = 1000000044;
        this.diG = aVar.KT();
        if (list32 != null && list32.size() > 0) {
            if (list32.size() == list.size()) {
                i2 = 0;
                while (true) {
                    i3 = i2;
                    if (i3 >= list32.size()) {
                        break;
                    }
                    com.tencent.mm.plugin.d.a.ZN().Gw().x((String) list.get(i3), 2147483633, (String) list32.get(i3));
                    i2 = i3 + 1;
                }
            } else {
                x.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", new Object[]{Integer.valueOf(list32.size()), Integer.valueOf(list.size())});
            }
        }
        if (i == 2) {
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= list.size()) {
                    break;
                }
                list32.add(bi.aG(com.tencent.mm.plugin.d.a.ZN().Gw().XH((String) list.get(i4)), ""));
                i2 = i4 + 1;
            }
        }
        byd byd = (byd) this.diG.dID.dIL;
        byd.rfe = i;
        byd.rKZ = str;
        this.qza = str;
        LinkedList linkedList = new LinkedList();
        i4 = 0;
        while (true) {
            i3 = i4;
            if (i3 < list.size()) {
                String str5;
                byb byb = new byb();
                byb.mEl = (String) list.get(i3);
                if (str2 == null) {
                    str5 = "";
                } else {
                    str5 = str2;
                }
                byb.sud = str5;
                g Gw = com.tencent.mm.plugin.d.a.ZN().Gw();
                String str6 = byb.mEl;
                ((Integer) list2.get(i3)).intValue();
                byb.rEJ = bi.aG(Gw.XH(str6), "");
                if (TextUtils.isEmpty(byb.rEJ) && list32 != null && list32.size() > i3) {
                    byb.rEJ = (String) list32.get(i3);
                }
                byb.siA = str3;
                if (map != null) {
                    if (map.containsKey(byb.mEl)) {
                        byb.sue = ((Integer) map.get(byb.mEl)).intValue();
                    }
                }
                byb.sui = str4;
                x.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s", new Object[]{Integer.valueOf(this.bOh), Integer.valueOf(i3), byb.mEl, byb.rEJ, str3, str4});
                linkedList.add(byb);
                i4 = i3 + 1;
            } else {
                byd.suk = linkedList;
                byd.suj = linkedList.size();
                LinkedList linkedList2 = new LinkedList();
                linkedList2.addAll(list2);
                byd.sum = linkedList2;
                byd.sul = linkedList2.size();
                byd.rTr = new bhy().bq(com.tencent.mm.plugin.normsg.a.b.lFJ.bjE());
                x.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[]{Integer.valueOf(this.bOh), Integer.valueOf(byd.suk.size()), Integer.valueOf(byd.sum.size()), bi.c(list32, ","), str3, bi.cjd()});
                return;
            }
        }
    }

    public m(List<String> list, List<Integer> list2, String str, String str2, Map<String, Integer> map, String str3) {
        this(2, list, list2, null, str, str2, map, str3, "");
    }

    public m(String str, String str2, int i, byte b) {
        this(str, str2, i);
    }

    public m(int i, List<String> list, List<Integer> list2, String str, String str2) {
        this(i, list, list2, null, str, str2, null, null, "");
    }

    public final void fy(String str, String str2) {
        Iterator it = ((byd) this.diG.dID.dIL).suk.iterator();
        while (it.hasNext()) {
            byb byb = (byb) it.next();
            byb.suf = str;
            byb.sug = str2;
        }
    }

    public final String cby() {
        if (this.diG == null || this.diG.dIE == null) {
            return "";
        }
        return ((bye) this.diG.dIE.dIL).hbL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int cbz() {
        return this.bOh;
    }

    public final int getType() {
        return 30;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.diJ.a(i2, i3, str, this);
    }
}
