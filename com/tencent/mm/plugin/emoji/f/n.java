package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.adg;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends l implements k {
    private final b diG;
    private e diJ;
    private final int fdx;
    public byte[] iiN;
    public int iiP;
    private boolean iiQ;
    private ArrayList<ts> iiR;
    public final int mType;

    public n(int i, int i2) {
        this(i, null, i2);
    }

    public n(int i, byte[] bArr, int i2) {
        this(i, bArr, i2, false);
    }

    public n(int i, byte[] bArr, int i2, boolean z) {
        this.iiQ = false;
        this.iiR = new ArrayList();
        this.iiN = null;
        a aVar = new a();
        aVar.dIG = new adg();
        aVar.dIH = new adh();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionlist";
        aVar.dIF = TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_FINAL_REASON;
        aVar.dII = 210;
        aVar.dIJ = 1000000210;
        this.diG = aVar.KT();
        this.iiN = bArr;
        this.mType = i;
        this.fdx = i2;
        this.iiQ = z;
    }

    public final int getType() {
        return TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_FINAL_REASON;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        adg adg = (adg) this.diG.dID.dIL;
        if (this.iiN != null) {
            adg.rcT = ab.O(this.iiN);
        } else {
            adg.rcT = new bhy();
        }
        x.d("MicroMsg.emoji.NetSceneGetEmotionList", adg.rcT == null ? "Buf is NULL" : adg.rcT.toString());
        adg.rgA = this.mType;
        adg.otY = this.fdx;
        if (this.mType == 7) {
            adg.rHA = this.iiP;
        }
        return a(eVar, this.diG, this);
    }

    public final adh aEQ() {
        return this.diG == null ? null : (adh) this.diG.dIE.dIL;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + i2 + "   errCode:" + i3);
        if (this.mType == 8) {
            if (i2 == 0 && i3 == 0) {
                au.HU();
                c.DT().a(aa.a.sOS, Long.valueOf(System.currentTimeMillis()));
            } else {
                au.HU();
                c.DT().a(aa.a.sOS, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            }
        }
        if (this.mType == 11) {
            if (i2 == 0 && i3 == 0) {
                au.HU();
                c.DT().a(aa.a.sOW, Long.valueOf(System.currentTimeMillis()));
            } else {
                au.HU();
                c.DT().a(aa.a.sOW, Long.valueOf((System.currentTimeMillis() - 28800000) + 600000));
            }
            i.aEA().igA.a(this.mType, aEQ());
        }
        if (i2 == 0 || i2 == 4) {
            adh adh = (adh) ((b) qVar).dIE.dIL;
            if (adh.rcT != null) {
                this.iiN = ab.a(adh.rcT);
            }
            if (this.mType == 8) {
                if (i3 == 0) {
                    aER();
                    r(this.iiR);
                    au.HU();
                    c.DT().a(aa.a.sOS, Long.valueOf(System.currentTimeMillis()));
                } else if (i3 == 2) {
                    aER();
                    ((adg) ((b) qVar).dID.dIL).rcT = ((adh) ((b) qVar).dIE.dIL).rcT;
                    a(this.dIX, this.diJ);
                } else if (i3 == 3) {
                    if (this.iiR != null) {
                        this.iiR.clear();
                    }
                    ((adg) ((b) qVar).dID.dIL).rcT = new bhy();
                    a(this.dIX, this.diJ);
                }
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public static f a(adh adh) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
        if (adh == null) {
            return null;
        }
        f fVar = new f();
        if (adh != null) {
            fVar.ihp = adh.rHB;
            List arrayList = new ArrayList();
            if (!(adh.rHC == null || adh.rHC.isEmpty())) {
                Object[] toArray = adh.rHC.toArray();
                if (toArray != null && toArray.length > 0) {
                    for (Object obj : toArray) {
                        if (obj != null && (obj instanceof ts)) {
                            ts tsVar = (ts) obj;
                            if (!(tsVar == null || bi.oW(tsVar.rem))) {
                                arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(tsVar));
                            }
                        }
                    }
                }
            }
            fVar.ihq = arrayList;
            fVar.ihr = adh.rHD;
            fVar.ihs = adh.rHF;
            Collection collection = adh.rHN;
            if (fVar.ihu == null) {
                fVar.ihu = new LinkedList();
                fVar.ihu.addAll(collection);
            }
            fVar.iht = adh.rHJ;
        }
        return fVar;
    }

    protected final int Cc() {
        return 100;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    private void aER() {
        adh aEQ = aEQ();
        if (aEQ == null || aEQ.rHC == null || aEQ.rHC.size() <= 0) {
            x.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
        } else {
            this.iiR.addAll(aEQ.rHC);
        }
    }

    private void r(ArrayList<ts> arrayList) {
        com.tencent.mm.storage.emotion.a aVar = i.aEA().igy;
        if (aVar == null) {
            x.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
            return;
        }
        long j;
        h hVar;
        ts tsVar;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (aVar.diF instanceof h) {
            h hVar2 = (h) aVar.diF;
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround preparedDownloadCustomEmojiList in a transaction, ticket = %d", new Object[]{Long.valueOf(hVar2.dO(Thread.currentThread().getId()))});
            j = r4;
            hVar = hVar2;
        } else {
            j = -1;
            hVar = null;
        }
        Iterator it;
        EmojiGroupInfo emojiGroupInfo;
        if (arrayList == null || arrayList.size() <= 0) {
            it = aVar.cni().iterator();
            while (it.hasNext()) {
                emojiGroupInfo = (EmojiGroupInfo) it.next();
                if (emojiGroupInfo.field_sync > 0) {
                    x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[]{emojiGroupInfo.field_productID});
                    aVar.Zu(emojiGroupInfo.field_productID);
                }
            }
            aVar.Zu("com.tencent.xin.emoticon.tusiji");
        } else if (arrayList == null || arrayList.size() <= 0) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
        } else {
            Map cnh = aVar.cnh();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", new Object[]{Integer.valueOf(arrayList.size())});
            for (int i = 0; i < r13; i++) {
                tsVar = (ts) arrayList.get(i);
                if (tsVar == null || bi.oW(tsVar.rem)) {
                    x.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                } else {
                    EmojiGroupInfo emojiGroupInfo2;
                    x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", new Object[]{tsVar.rem});
                    arrayList2.add(tsVar.rem);
                    if (cnh.containsKey(tsVar.rem)) {
                        emojiGroupInfo2 = (EmojiGroupInfo) cnh.get(tsVar.rem);
                        if (emojiGroupInfo2 == null) {
                            emojiGroupInfo2 = new EmojiGroupInfo();
                        }
                        emojiGroupInfo2.field_productID = tsVar.rem;
                    } else if (tsVar.rem.equals("com.tencent.xin.emoticon.tusiji")) {
                        emojiGroupInfo2 = (EmojiGroupInfo) cnh.get(String.valueOf(EmojiGroupInfo.tcy));
                        if (emojiGroupInfo2 == null) {
                            emojiGroupInfo2 = new EmojiGroupInfo();
                        }
                        emojiGroupInfo2.field_productID = String.valueOf(EmojiGroupInfo.tcy);
                    } else {
                        emojiGroupInfo2 = new EmojiGroupInfo();
                        emojiGroupInfo2.field_productID = tsVar.rem;
                    }
                    if (tsVar.rem.equals("com.tencent.xin.emoticon.tusiji")) {
                        emojiGroupInfo2.field_flag = 0;
                        emojiGroupInfo2.field_packName = "emoji_custom_all";
                        emojiGroupInfo2.field_type = EmojiGroupInfo.TYPE_SYSTEM;
                    } else {
                        emojiGroupInfo2.field_packName = tsVar.rwQ;
                        emojiGroupInfo2.field_type = EmojiGroupInfo.tcv;
                    }
                    emojiGroupInfo2.field_packIconUrl = tsVar.jPG;
                    emojiGroupInfo2.field_packGrayIconUrl = tsVar.rxd;
                    emojiGroupInfo2.field_packCoverUrl = tsVar.rwY;
                    emojiGroupInfo2.field_packDesc = tsVar.rwR;
                    emojiGroupInfo2.field_packAuthInfo = tsVar.rwS;
                    emojiGroupInfo2.field_packPrice = tsVar.rwT;
                    emojiGroupInfo2.field_packType = tsVar.rwU;
                    emojiGroupInfo2.field_packFlag = tsVar.rwV;
                    emojiGroupInfo2.field_packExpire = (long) tsVar.rwZ;
                    emojiGroupInfo2.field_packTimeStamp = (long) tsVar.rxy;
                    emojiGroupInfo2.field_sort = 1;
                    emojiGroupInfo2.field_idx = i;
                    if (emojiGroupInfo2.field_sync == 0) {
                        if (emojiGroupInfo2.field_status == 7 && emojiGroupInfo2.field_packStatus == 1) {
                            emojiGroupInfo2.field_sync = 2;
                        } else {
                            emojiGroupInfo2.field_sync = 1;
                        }
                    }
                    if (emojiGroupInfo2.field_sync == 2) {
                        emojiGroupInfo2.field_status = 7;
                    }
                    if (emojiGroupInfo2.field_sync == 2 && !tsVar.rem.equals("com.tencent.xin.emoticon.tusiji")) {
                        at atVar = new at();
                        atVar.bIi.type = 1;
                        atVar.bIi.bIl = tsVar.rem;
                        com.tencent.mm.sdk.b.a.sFg.m(atVar);
                        if (!atVar.bIj.bGZ) {
                            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", new Object[]{tsVar.rem});
                            emojiGroupInfo2.field_sync = 1;
                        }
                    }
                    x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", new Object[]{emojiGroupInfo2.field_productID, Long.valueOf(emojiGroupInfo2.field_lastUseTime), Integer.valueOf(emojiGroupInfo2.field_sort)});
                    aVar.a(emojiGroupInfo2);
                }
            }
            for (EmojiGroupInfo emojiGroupInfo3 : cnh.values()) {
                if (!(emojiGroupInfo3 == null || bi.oW(emojiGroupInfo3.field_productID) || emojiGroupInfo3.field_productID.equals(String.valueOf(EmojiGroupInfo.tcz)))) {
                    if (emojiGroupInfo3.field_productID.equals(String.valueOf(EmojiGroupInfo.tcy))) {
                        if (!arrayList2.contains("com.tencent.xin.emoticon.tusiji")) {
                            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[]{"com.tencent.xin.emoticon.tusiji"});
                            arrayList3.add("com.tencent.xin.emoticon.tusiji");
                        }
                    } else if (!arrayList2.contains(emojiGroupInfo3.field_productID)) {
                        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[]{emojiGroupInfo3.field_productID});
                        arrayList3.add(emojiGroupInfo3.field_productID);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    aVar.Zu((String) it.next());
                }
            }
            aVar.b("event_update_group", 0, bi.cjd().toString());
        }
        if (hVar != null) {
            hVar.gp(j);
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - valueOf.longValue())});
        aVar.b("event_update_group", 0, bi.cjd().toString());
        ArrayList arrayList4;
        Iterator it2;
        if (!this.iiQ) {
            ArrayList arrayList5 = (ArrayList) aVar.cnr();
            if (arrayList5.size() > 0) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[]{Integer.valueOf(arrayList5.size())});
                arrayList4 = new ArrayList();
                it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!bi.oW(str)) {
                        if (str.equals(String.valueOf(EmojiGroupInfo.tcy))) {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                        } else {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(str));
                        }
                    }
                }
                i.aEx().t(arrayList4);
                if (!i.aEx().ije.iju) {
                    i.aEx().ije.aEV();
                }
            }
        } else if (arrayList != null && arrayList.size() > 0) {
            x.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[]{Integer.valueOf(arrayList.size())});
            arrayList4 = new ArrayList();
            it2 = arrayList.iterator();
            while (it2.hasNext()) {
                tsVar = (ts) it2.next();
                if (!(tsVar == null || bi.oW(tsVar.rem))) {
                    if (tsVar.rem.equals(String.valueOf(EmojiGroupInfo.tcy))) {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                    } else {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(tsVar.rem, (byte) 0));
                    }
                }
            }
            i.aEx().t(arrayList4);
            if (!i.aEx().ije.iju) {
                i.aEx().ije.aEV();
            }
        }
    }
}
