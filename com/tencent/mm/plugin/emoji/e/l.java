package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.h;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.p;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class l {
    private static int cfZ = -1;
    public static boolean igJ = false;
    public static boolean igK = false;
    public static boolean igL = false;
    public static boolean igM = false;
    public static ArrayList<EmojiGroupInfo> igN = new ArrayList();
    public static HashMap<String, ArrayList<EmojiInfo>> igO = new HashMap();
    public p igA;
    public j igB;
    public com.tencent.mm.storage.emotion.l igC;
    public h igD;
    public n igE;
    r igF;
    t igG;
    f igH;
    public v igI;
    public final a igP = new a() {
        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (!bi.oW(str) && str.equals("event_update_group")) {
                x.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[]{(String) lVar.obj});
                if (g.Eg().Dx()) {
                    i.aEv().aDI();
                } else {
                    return;
                }
            }
            if (!bi.oW(str)) {
                if (str.equals("event_update_group") || str.equalsIgnoreCase("productID")) {
                    x.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
                    l.igJ = true;
                    l.igM = true;
                }
            }
        }
    };
    public final a igQ = new 2(this);
    public final a igR = new a() {
        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (str != null) {
                if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                    l.igK = true;
                } else if (g.Eg().Dx()) {
                    EmojiInfo zi = ((c) g.n(c.class)).getEmojiMgr().zi(str);
                    if (zi != null && zi.field_catalog == EmojiInfo.tcH) {
                        l.igK = true;
                    }
                }
            }
        }
    };
    public final com.tencent.mm.sdk.b.c igS = new 4(this);
    public d igx;
    public com.tencent.mm.storage.emotion.a igy;
    public com.tencent.mm.storage.emotion.c igz;

    public l() {
        au.HU();
        this.igx = new d(com.tencent.mm.model.c.FO());
        au.HU();
        this.igy = new com.tencent.mm.storage.emotion.a(com.tencent.mm.model.c.FO());
        au.HU();
        this.igz = new com.tencent.mm.storage.emotion.c(com.tencent.mm.model.c.FO());
        au.HU();
        this.igB = new j(com.tencent.mm.model.c.FO());
        au.HU();
        this.igC = new com.tencent.mm.storage.emotion.l(com.tencent.mm.model.c.FO());
        au.HU();
        this.igD = new h(com.tencent.mm.model.c.FO());
        au.HU();
        this.igA = new p(com.tencent.mm.model.c.FO());
        au.HU();
        this.igE = new n(com.tencent.mm.model.c.FO());
        au.HU();
        this.igF = new r(com.tencent.mm.model.c.FO());
        au.HU();
        this.igG = new t(com.tencent.mm.model.c.FO());
        au.HU();
        this.igH = new f(com.tencent.mm.model.c.FO());
        this.igI = new v();
    }

    public final void aEf() {
        Context context = ad.getContext();
        if (context != null) {
            au.HU();
            x.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[]{String.valueOf(((Boolean) com.tencent.mm.model.c.DT().get(274480, Boolean.valueOf(true))).booleanValue())});
            if (((Boolean) com.tencent.mm.model.c.DT().get(274480, Boolean.valueOf(true))).booleanValue()) {
                this.igx.gg(context);
                this.igy.gg(context);
            }
            au.HU();
            com.tencent.mm.model.c.DT().set(274480, Boolean.valueOf(false));
        }
        au.HU();
        if (((Integer) com.tencent.mm.model.c.DT().get(aa.a.sPg, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.qVN) {
            long currentTimeMillis = System.currentTimeMillis();
            i.aEA().igy.cnu();
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sPg, Integer.valueOf(com.tencent.mm.protocal.d.qVN));
            x.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        au.HU();
        if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sPh, Boolean.valueOf(true))).booleanValue()) {
            long dO;
            int gp;
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.storage.emotion.a aVar = i.aEA().igy;
            com.tencent.mm.bt.h hVar = null;
            if (aVar.diF instanceof com.tencent.mm.bt.h) {
                com.tencent.mm.bt.h hVar2 = (com.tencent.mm.bt.h) aVar.diF;
                dO = hVar2.dO(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dO = -1;
            }
            ArrayList cni = aVar.cni();
            if (!cni.isEmpty()) {
                Iterator it = cni.iterator();
                while (it.hasNext()) {
                    EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) it.next();
                    if (!(emojiGroupInfo == null || bi.oW(emojiGroupInfo.field_productID))) {
                        int zs = aVar.zs(emojiGroupInfo.field_productID);
                        if (emojiGroupInfo.field_count != zs) {
                            emojiGroupInfo.field_count = zs;
                            aVar.diF.update("EmojiGroupInfo", emojiGroupInfo.wH(), "productID=?", new String[]{emojiGroupInfo.field_productID});
                        }
                    }
                }
            }
            if (hVar != null) {
                gp = hVar.gp(dO);
            } else {
                gp = -1;
            }
            aVar.b("event_update_group", 0, bi.cjd().toString());
            Object obj = gp >= 0 ? 1 : null;
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sPh, Boolean.valueOf(obj == null));
            x.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        }
    }

    public final d asE() {
        return this.igx;
    }

    public final ArrayList<EmojiGroupInfo> aDW() {
        if (igN == null) {
            igN = new ArrayList();
        }
        if (igN.size() == 0 || igJ) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                igN = this.igy.cnn();
            } else {
                igN = (ArrayList) this.igy.cnf();
            }
        }
        igJ = false;
        return igN;
    }

    public final int aDX() {
        if (cfZ == -1 || igM) {
            cfZ = this.igy.cnj();
        }
        return cfZ;
    }

    public final ArrayList<EmojiInfo> aDY() {
        if (igO == null) {
            igO = new HashMap();
        }
        if (!igO.containsKey("custom") || igK) {
            igO.put("custom", (ArrayList) this.igx.cnG());
        }
        igK = false;
        return (ArrayList) igO.get("custom");
    }
}
