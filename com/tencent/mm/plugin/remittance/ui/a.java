package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    xb myH = null;
    jc myI;

    public final void brh() {
        x.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
        this.myI = null;
        this.myH = null;
    }

    public final List<xc> bri() {
        if (this.myI != null) {
            return this.myI.rkt;
        }
        return new LinkedList();
    }

    public final boolean brj() {
        if (this.myI != null) {
            return true;
        }
        return false;
    }

    public final boolean brk() {
        if (this.myI == null || this.myI.rkt == null || this.myI.rkt.size() <= 0) {
            return false;
        }
        return true;
    }

    public final void KA(String str) {
        this.myH = null;
        if (str == null) {
            this.myH = null;
        } else if (this.myI == null) {
            x.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
            this.myH = null;
        } else {
            Iterator it = this.myI.rku.iterator();
            while (it.hasNext()) {
                xb xbVar = (xb) it.next();
                if (str.equals(xbVar.rCs)) {
                    this.myH = xbVar;
                    return;
                }
            }
        }
    }

    public final boolean a(List<xc> list, xc xcVar) {
        if (this.myI == null) {
            x.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
            return false;
        }
        xb xbVar;
        CharSequence bigInteger;
        if (xcVar != null) {
            bigInteger = new BigInteger(Long.toBinaryString(xcVar.rCB), 2).toString();
        } else {
            bigInteger = null;
        }
        List<xb> linkedList = new LinkedList();
        Iterator it = this.myI.rku.iterator();
        while (it.hasNext()) {
            xbVar = (xb) it.next();
            if (xcVar == null || (!bi.oW(bigInteger) && xbVar.rCs.contains(bigInteger))) {
                linkedList.add(xbVar);
            }
        }
        List linkedList2 = new LinkedList();
        for (xb xbVar2 : linkedList) {
            if (a((List) list, xbVar2)) {
                linkedList2.add(xbVar2);
            }
        }
        if (linkedList2.size() > 0) {
            Collections.sort(linkedList2, new a(this));
            this.myH = (xb) linkedList2.get(0);
            return true;
        }
        this.myH = null;
        return false;
    }

    private static boolean a(List<xc> list, xb xbVar) {
        if (xbVar.rkt.size() == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (xc xcVar : list) {
            hashSet.add(Long.valueOf(xcVar.rCB));
        }
        Iterator it = xbVar.rkt.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(((xc) it.next()).rCB))) {
                return false;
            }
        }
        return true;
    }
}
