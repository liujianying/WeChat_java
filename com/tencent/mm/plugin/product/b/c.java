package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.product.ui.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.apx;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.protocal.c.bnx;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    private d lQK = null;
    public m lQL;
    public List<n> lQM;
    public String lQN;
    public String lQO;
    public String lQP;
    public um lQQ;
    public cf lQR;
    public bfm lQS;
    public String lQT;
    public String lQU;
    public int lQV;
    public Map<String, e> lQW;
    public Map<String, String> lQX = new HashMap();
    public LinkedList<um> lQY;
    public LinkedList<au> lQZ;
    public e lRa;
    private e lRb;
    public Map<String, LinkedList<sg>> lRc = null;
    public int mCount = 1;

    public final void clear() {
        this.lQL = null;
        if (this.lQM != null) {
            this.lQM.clear();
            this.lQM = null;
        }
        this.lQN = null;
        this.lQO = null;
        this.mCount = 1;
        this.lQP = null;
        this.lQQ = null;
        this.lQS = null;
        this.lQT = null;
        this.lQV = 0;
        this.lRa = null;
        if (this.lQW != null) {
            this.lQW.clear();
            this.lQW = null;
        }
        if (this.lQX != null) {
            this.lQX.clear();
        }
        if (this.lQY != null) {
            this.lQY.clear();
            this.lQY = null;
        }
        if (this.lRc != null) {
            this.lRc.clear();
            this.lRc = null;
        }
    }

    public final void a(m mVar, List<n> list) {
        int i;
        int i2 = 0;
        clear();
        this.lQL = mVar;
        this.lQM = list;
        if (bi.oW(this.lQL.lRt)) {
            this.lQL.lRt = this.lQO;
        }
        LinkedList linkedList = this.lQL.lRr;
        this.lQW = new HashMap();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size();
            for (int i3 = 0; i3 < size; i3++) {
                l lVar = (l) linkedList.get(i3);
                a(lVar.lRR.split(";"), lVar);
            }
            bmX();
        }
        if (!(this.lQL.lRp == null || this.lQL.lRp.lRJ == null)) {
            this.lQV = this.lQL.lRp.lRJ.size();
        }
        if (!(this.lQL.lRp == null || this.lQL.lRp.lRD == null || this.lQL.lRp.lRD.size() <= 0)) {
            this.lQT = (String) this.lQL.lRp.lRD.get(0);
        }
        if (!bi.oW(this.lQL.bnb())) {
            y.a(new com.tencent.mm.plugin.product.ui.c(this.lQL.bnb()));
            x.d("MicroMsg.MallProductManager", "product img path : " + bmP());
        }
        if (this.lQL.lRs == null || this.lQL.lRs.lRN == null) {
            i = 0;
        } else {
            i = this.lQL.lRs.lRN.bWA;
        }
        if (this.lQL.lRq != null) {
            i2 = this.lQL.lRq.bWA;
        }
        this.lRb = new e(i, i2);
    }

    public final e bmI() {
        if (this.lRb == null) {
            this.lRb = new e(0, 0);
        }
        return this.lRb;
    }

    public final String bmJ() {
        if (this.lRa == null || bi.oW(this.lRa.url)) {
            return this.lQT;
        }
        return this.lRa.url;
    }

    public final String bmK() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.lQL.lRp.lRJ.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            String str = (String) this.lQX.get(mVar.lRU);
            if (str != null) {
                Iterator it2 = mVar.lRW.iterator();
                while (it2.hasNext()) {
                    h hVar = (h) it2.next();
                    if (str.equals(hVar.id)) {
                        stringBuilder.append(hVar.name).append(" ");
                        break;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void W(Intent intent) {
        cf cfVar = new cf();
        cfVar.hbL = bi.aG(intent.getStringExtra("userName"), "");
        cfVar.rcz = bi.aG(intent.getStringExtra("telNumber"), "");
        cfVar.rcA = bi.aG(intent.getStringExtra("addressPostalCode"), "");
        cfVar.eJI = bi.aG(intent.getStringExtra("proviceFirstStageName"), "");
        cfVar.eJJ = bi.aG(intent.getStringExtra("addressCitySecondStageName"), "");
        cfVar.eJQ = bi.aG(intent.getStringExtra("addressCountiesThirdStageName"), "");
        cfVar.jQf = bi.aG(intent.getStringExtra("addressDetailInfo"), "");
        if (!bi.oW(cfVar.hbL) && !bi.oW(cfVar.rcz)) {
            this.lQR = cfVar;
        }
    }

    public final LinkedList<a> D(Activity activity) {
        LinkedList<a> linkedList = new LinkedList();
        if (this.lQZ != null) {
            Iterator it = this.lQZ.iterator();
            while (it.hasNext()) {
                au auVar = (au) it.next();
                a aVar = new a();
                aVar.jPe = auVar.jPe;
                aVar.lRx = auVar.lRx;
                aVar.jSA = auVar.jSA;
                aVar.hcE = auVar.hcE;
                aVar.jPG = auVar.jPG;
                if (aVar.hcE == 1 && JA(aVar.jSA) > 0) {
                    aVar.lRx = activity.getString(i.mall_product_submit_preferential_summray, new Object[]{b.d((double) r0, this.lQL.lRp.lNV)});
                }
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    public final void uw(int i) {
        if (this.lQY != null && i < this.lQY.size() && i >= 0) {
            this.lQQ = (um) this.lQY.get(i);
        }
    }

    public final int bmL() {
        int i = 0;
        if (!(bmI().bne() || this.lQQ == null)) {
            i = this.lQQ.rlz + 0;
        }
        if (this.lRa != null) {
            i += this.lRa.lRe * this.mCount;
        } else {
            i += this.lQL.lRp.lRB * this.mCount;
        }
        return i - bmM();
    }

    public final int bmM() {
        int i = 0;
        if (this.lRc == null || this.lRc.size() <= 0) {
            return 0;
        }
        Iterator it = this.lRc.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            LinkedList linkedList = (LinkedList) it.next();
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    i2 += ((sg) it2.next()).rlz;
                }
            }
            i = i2;
        }
    }

    private int JA(String str) {
        int i = 0;
        if (this.lRc != null && this.lRc.size() > 0) {
            LinkedList linkedList = (LinkedList) this.lRc.get(str);
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i = ((sg) it.next()).rlz + i;
                }
            }
        }
        return i;
    }

    public final bfm bmN() {
        if (this.lQS != null) {
            return this.lQS;
        }
        if (this.lQK == null) {
            this.lQK = com.tencent.mm.plugin.product.a.a.bmF().bmH();
        }
        d dVar = this.lQK;
        String str = (dVar.lRd == null || dVar.lRd.size() <= 0) ? null : (String) dVar.lRd.get(0);
        if (bi.oW(str)) {
            cf cfVar = this.lQR;
            if (cfVar == null || bi.oW(cfVar.hbL)) {
                return null;
            }
            this.lQS = new bfm();
            this.lQS.jQf = cfVar.hbL;
            this.lQS.sgM = 1;
            return this.lQS;
        }
        this.lQS = new bfm();
        this.lQS.jQf = str;
        this.lQS.sgM = 1;
        return this.lQS;
    }

    public final String getAppId() {
        if (this.lQL.lRq != null) {
            return this.lQL.lRq.bPS;
        }
        return null;
    }

    public final String bmO() {
        if (this.lQL.lRq != null) {
            return this.lQL.lRq.username;
        }
        return null;
    }

    public final String bmP() {
        if (bi.oW(this.lQL.bnb())) {
            return null;
        }
        return com.tencent.mm.plugin.product.ui.c.JC(this.lQL.bnb());
    }

    public final String bmQ() {
        if (this.lQL.lRp != null && this.lQL.lRp.lRL != null) {
            return this.lQL.lRp.lRL.url;
        }
        if (bi.oW(this.lQL.lRt)) {
            return this.lQO;
        }
        return this.lQL.lRt;
    }

    public final int bmR() {
        int i = this.lQL.lRn;
        if (this.lRa == null || i <= this.lRa.lRn) {
            return i;
        }
        return this.lRa.lRn;
    }

    public final boolean bmS() {
        return (this.mCount <= 0 || this.lQL == null || this.mCount > bmR() || this.lQL.lRp == null || this.lQL.lRp.lRJ == null) ? false : true;
    }

    public final boolean bmT() {
        if (!bmS() || this.lQX == null || this.lQX.size() != this.lQV) {
            return false;
        }
        if (this.lQV > 0) {
            if (this.lRa == null || this.mCount <= 0 || this.mCount > bmR()) {
                return false;
            }
            return true;
        } else if (this.lQV == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean bmU() {
        if (!bmT() || this.lQR == null) {
            return false;
        }
        if (bmI().bne() || this.lQQ != null) {
            return true;
        }
        return false;
    }

    public final LinkedList<bie> bmV() {
        LinkedList<bie> linkedList = new LinkedList();
        bie bie = new bie();
        bie.hbF = this.mCount;
        bie.rJU = this.lQL.lRl;
        bie.sdV = this.lQL.lRt;
        bie.sdW = this.lQP;
        linkedList.add(bie);
        return linkedList;
    }

    public final bnx bmW() {
        bnx bnx = new bnx();
        bnx.rmM = this.lQN;
        bnx.lOS = 1;
        bnx.slP = new LinkedList();
        bbs bbs = new bbs();
        bbs.hbF = this.mCount;
        bbs.rJU = this.lQL.lRl;
        bbs.jPe = this.lQL.lRp.name;
        if (this.lRa != null) {
            bbs.sdU = this.lRa.lRe;
        } else {
            bbs.sdU = this.lQL.lRp.lRB;
        }
        bbs.sdV = this.lQL.lRt;
        bbs.sdW = this.lQP;
        bbs.hcE = this.lQL.lRm;
        bbs.sdS = this.lQV;
        bbs.sdT = new LinkedList();
        for (String str : this.lQX.keySet()) {
            String str2 = (String) this.lQX.get(str);
            apx apx = new apx();
            apx.riD = str;
            apx.mEl = str2;
            bbs.sdT.add(apx);
        }
        bbs.sea = new LinkedList();
        bbs.sdZ = 0;
        if (this.lRc != null && this.lRc.size() > 0) {
            for (LinkedList linkedList : this.lRc.values()) {
                bbs.sea.addAll(linkedList);
                bbs.sdZ = linkedList.size() + bbs.sdZ;
            }
        }
        bnx.slP.add(bbs);
        bnx.slR = new LinkedList();
        bnx.slS = 1;
        this.lQS = bmN();
        if (this.lQS != null) {
            bnx.slR.add(this.lQS);
        } else {
            this.lQS = new bfm();
            this.lQS.sgM = 0;
            bnx.slR.add(this.lQS);
        }
        bnx.rII = this.lQR;
        bnx.slQ = this.lQQ;
        return bnx;
    }

    public final void bmX() {
        if (this.lQX != null) {
            Iterator it = this.lQL.lRp.lRJ.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                Iterator it2 = mVar.lRW.iterator();
                while (it2.hasNext()) {
                    boolean z;
                    h hVar = (h) it2.next();
                    String str = mVar.lRU;
                    String str2 = hVar.id;
                    String str3;
                    e eVar;
                    if (this.lQX == null || this.lQW == null) {
                        z = false;
                    } else if (this.lQX.containsKey(str)) {
                        str3 = (String) this.lQX.get(str);
                        this.lQX.put(str, str2);
                        str2 = I(this.lQX);
                        this.lQX.put(str, str3);
                        eVar = (e) this.lQW.get(str2);
                        z = eVar != null ? eVar.lRn > 0 : false;
                    } else {
                        this.lQX.put(str, str2);
                        str3 = I(this.lQX);
                        this.lQX.remove(str);
                        eVar = (e) this.lQW.get(str3);
                        z = eVar != null ? eVar.lRn > 0 : false;
                    }
                    hVar.lRP = z;
                    x.d("MicroMsg.MallProductManager", "(" + mVar.lRU + " , " + hVar.id + ") hasStock--> " + hVar.lRP);
                }
            }
        }
    }

    public static String I(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Object arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new 1());
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey()).append(":").append((String) entry.getValue()).append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
        return stringBuilder.toString();
    }

    private void a(String[] strArr, l lVar) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = -1 >>> (32 - length);
            for (int i2 = 1; i2 <= i; i2++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i3 = 0; i3 < length; i3++) {
                    if (((i2 << (31 - i3)) >> 31) == -1) {
                        stringBuilder.append(strArr[i3]).append(";");
                    }
                }
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
                e eVar = (e) this.lQW.get(stringBuilder.toString());
                if (eVar != null) {
                    if (eVar.lRe < lVar.lRS) {
                        eVar.lRe = lVar.lRS;
                    }
                    if (eVar.lRf > lVar.lRS) {
                        eVar.lRf = lVar.lRS;
                    }
                    eVar.lRn += lVar.lRn;
                } else {
                    eVar = new e();
                    eVar.lRe = lVar.lRS;
                    eVar.lRf = lVar.lRS;
                    eVar.lRn = lVar.lRn;
                    eVar.lRT = lVar.lRT;
                    eVar.url = lVar.url;
                    this.lQW.put(stringBuilder.toString(), eVar);
                }
            }
        }
    }

    public final String bmY() {
        g.a aVar = new g.a();
        aVar.title = this.lQL.lRp.name;
        aVar.description = bmZ();
        aVar.type = 13;
        aVar.url = bmQ();
        aVar.thumburl = this.lQL.bnb();
        aVar.dwX = this.lQL.lRm;
        aVar.dwY = a(this.lQL);
        return g.a.a(aVar, null, null);
    }

    public final String bmZ() {
        return b.d((double) this.lQL.lRp.lRC, this.lQL.lRp.lNV);
    }

    public final String a(m mVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mallProductInfo>");
        stringBuilder.append("<type>").append(mVar.lRm).append("</type>");
        stringBuilder.append("<id>").append(mVar.lRl).append("</id>");
        stringBuilder.append("<version>").append(mVar.lRp.version).append("</version>");
        stringBuilder.append("<name>").append(bi.WS(mVar.lRp.name)).append("</name>");
        stringBuilder.append("<highPrice>").append(mVar.lRp.lRB).append("</highPrice>");
        stringBuilder.append("<lowPrice>").append(mVar.lRp.lRC).append("</lowPrice>");
        stringBuilder.append("<originPrice>").append(mVar.lRp.lRA).append("</originPrice>");
        stringBuilder.append("<sourceUrl>").append(bi.WS(this.lQL.lRt)).append("</sourceUrl>");
        if (mVar.lRp.lRD != null) {
            stringBuilder.append("<imgCount>").append(mVar.lRp.lRD.size()).append("</imgCount>");
            stringBuilder.append("<imgList>");
            Iterator it = mVar.lRp.lRD.iterator();
            while (it.hasNext()) {
                stringBuilder.append("<imgUrl>").append(bi.WS((String) it.next())).append("</imgUrl>");
            }
            stringBuilder.append("</imgList>");
        }
        stringBuilder.append("<shareInfo>");
        stringBuilder.append("<shareUrl>").append(bi.WS(bmQ())).append("</shareUrl>");
        stringBuilder.append("<shareThumbUrl>").append(bi.WS(mVar.bnb())).append("</shareThumbUrl>");
        stringBuilder.append("</shareInfo>");
        if (this.lQL.lRq != null) {
            stringBuilder.append("<sellerInfo>");
            stringBuilder.append("<appID>").append(mVar.lRq.bPS).append("</appID>");
            stringBuilder.append("<appName>").append(mVar.lRq.name).append("</appName>");
            stringBuilder.append("<usrName>").append(mVar.lRq.username).append("</usrName>");
            stringBuilder.append("</sellerInfo>");
        }
        stringBuilder.append("</mallProductInfo>");
        return stringBuilder.toString();
    }
}
