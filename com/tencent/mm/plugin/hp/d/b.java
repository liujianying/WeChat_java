package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.util.Base64;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.bsz;
import com.tencent.mm.protocal.c.bta;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    public String clientVersion;
    public final int fileSize;
    public final Integer knd;
    public HashMap<Integer, LinkedList<avn>> kne = new HashMap();
    public final Integer knf;
    public final Integer kng;
    public final String knh;
    public final String kni;
    public final String knj;
    public String knk;
    public String knl;
    public String knm;
    public String knn;
    public String kno;
    public int versionCode;

    public b(bta bta) {
        if (bta == null) {
            this.knd = Integer.valueOf(1);
            this.knh = "";
            this.kni = "";
            this.knf = Integer.valueOf(-1);
            this.kng = Integer.valueOf(-1);
            this.knj = "";
            this.fileSize = 0;
            this.knk = "";
            this.knl = "";
            this.versionCode = 0;
            this.clientVersion = "";
            this.knm = "";
            this.knn = "";
            this.kno = "";
            return;
        }
        if (bta.sqv != null) {
            this.kni = bta.sqv.rwt;
            this.knh = bta.sqv.jPK;
            this.fileSize = bta.sqv.ruE;
        } else {
            this.kni = "";
            this.knh = "";
            this.fileSize = 0;
        }
        this.knd = Integer.valueOf(bta.state);
        this.kng = Integer.valueOf(bta.squ);
        if (!(bta.sqs == null || bta.sqs.isEmpty())) {
            int size = bta.sqs.size();
            for (int i = 0; i < size; i++) {
                bsz bsz = (bsz) bta.sqs.get(i);
                if (!(bsz.sqr == null || bsz.sqr.isEmpty())) {
                    this.kne.put(Integer.valueOf(bsz.type), bsz.sqr);
                }
            }
        }
        this.knf = Integer.valueOf(bta.sqt);
        this.knj = bta.rsQ;
        if (bta.sqx == null || bta.sqx.isEmpty()) {
            this.knk = "";
            this.knl = "";
            this.versionCode = 0;
            this.clientVersion = "";
            this.knm = "";
            this.knn = "";
            this.kno = "";
            return;
        }
        Iterator it = bta.sqx.iterator();
        while (it.hasNext()) {
            bsy bsy = (bsy) it.next();
            if (!(bsy == null || bi.oW(bsy.aAL))) {
                if (bsy.aAL.equalsIgnoreCase("newApkMd5")) {
                    this.knk = bsy.value;
                } else if (bsy.aAL.equalsIgnoreCase("oldApkMd5")) {
                    this.knl = bsy.value;
                } else if (bsy.aAL.equalsIgnoreCase("versionCode")) {
                    this.versionCode = bi.WU(bsy.value);
                } else if (bsy.aAL.equalsIgnoreCase("clientVersion")) {
                    this.clientVersion = bsy.value;
                } else if (bsy.aAL.equalsIgnoreCase("alphaTitle")) {
                    this.knm = c.EJ(bsy.value);
                } else if (bsy.aAL.equalsIgnoreCase("alphaContent")) {
                    this.knn = c.EJ(bsy.value);
                } else if (bsy.aAL.equalsIgnoreCase("alphaUrl")) {
                    this.kno = bsy.value;
                }
            }
        }
    }

    public final boolean aWw() {
        Context context = ad.getContext();
        if (!ao.isConnected(context)) {
            return false;
        }
        if (this.kng.intValue() == 1 || this.kng.intValue() != 3) {
            return true;
        }
        return ao.isWifi(context);
    }

    public final boolean aWx() {
        return this.knd.intValue() == 2 || this.knd.intValue() == 4;
    }

    public final boolean aWy() {
        if (this.kne == null || this.kne.isEmpty() || !this.kne.containsKey(Integer.valueOf(4))) {
            return false;
        }
        return true;
    }

    public static String a(HashMap<Integer, LinkedList<avn>> hashMap, int i) {
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        String str = "";
        LinkedList linkedList = (LinkedList) hashMap.get(Integer.valueOf(i));
        if (linkedList == null || linkedList.isEmpty()) {
            return str;
        }
        int size = linkedList.size();
        int i2 = 0;
        while (i2 < size) {
            String str2;
            avn avn = (avn) linkedList.get(i2);
            if (avn.lang.equalsIgnoreCase("default")) {
                str2 = new String(Base64.decode(avn.content, 0));
            } else if (avn.lang.equalsIgnoreCase(w.chP())) {
                return new String(Base64.decode(avn.content, 0));
            } else {
                str2 = str;
            }
            i2++;
            str = str2;
        }
        return str;
    }

    public final String aWz() {
        if (aWy()) {
            return a(this.kne, 4);
        }
        return "";
    }

    public final String toString() {
        return "responseState:" + this.knd + "\ncdnUrl:" + this.knh + "\nfileMd5:" + this.kni + "\npackageType:" + this.knf + "\nnetworkType:" + this.kng + "\npatchId:" + this.knj;
    }
}
