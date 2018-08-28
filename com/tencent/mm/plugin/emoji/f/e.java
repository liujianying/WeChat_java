package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.fs;
import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends l implements k {
    public static int iip = 0;
    public static int iiq = 1;
    public final b diG;
    private com.tencent.mm.ab.e diJ;
    private ArrayList<String> iio = new ArrayList();
    private HashMap<String, ta> iir = new HashMap();
    public int iis = 0;
    private LinkedList<String> iit = new LinkedList();
    private int mIndex = 0;

    public e() {
        a aVar = new a();
        aVar.dIG = new fs();
        aVar.dIH = new ft();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.dIF = 697;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.mIndex = 0;
        this.iis = iip;
        this.iit = new LinkedList();
    }

    public e(LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.dIG = new fs();
        aVar.dIH = new ft();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.dIF = 697;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.mIndex = 0;
        this.iis = iiq;
        this.iit = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        ft ftVar;
        if (this.iis == iip) {
            if (i2 == 0 && i3 == 0) {
                ftVar = (ft) this.diG.dIE.dIL;
                fs fsVar = (fs) this.diG.dID.dIL;
                int i4;
                if (ftVar.rgC == 0 && (ftVar.rfd == null || ftVar.rfd.size() <= 0)) {
                    this.diJ.a(i2, i3, str, this);
                    x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
                    h.mEJ.a(164, 0, 1, false);
                    return;
                } else if (ftVar.rgC == 1) {
                    String str2 = "MicroMsg.emoji.NetSceneBatchEmojiDownLoad";
                    String str3 = "[cpan] preparedDownloadCustomEmojiList size:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(this.iir == null ? 0 : this.iir.size());
                    x.i(str2, str3, objArr);
                    this.diJ.a(i2, i3, str, this);
                    au.HU();
                    c.DT().a(aa.a.sPb, Long.valueOf(System.currentTimeMillis()));
                    a(ftVar);
                    List list = this.iio;
                    if (list == null || list.size() <= 0) {
                        x.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
                        au.HU();
                        c.DT().a(aa.a.sOQ, Boolean.valueOf(false));
                    } else {
                        long dO;
                        String str4;
                        String str5;
                        if (list.size() < n.aEj()) {
                            au.HU();
                            c.DT().a(aa.a.sOQ, Boolean.valueOf(false));
                        }
                        au.HU();
                        boolean booleanValue = ((Boolean) c.DT().get(aa.a.sOT, Boolean.valueOf(true))).booleanValue();
                        d dVar = i.aEA().igx;
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (list == null || list.size() <= 0) {
                            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
                        } else {
                            com.tencent.mm.bt.h hVar = null;
                            if (dVar.diF instanceof com.tencent.mm.bt.h) {
                                com.tencent.mm.bt.h hVar2 = (com.tencent.mm.bt.h) dVar.diF;
                                dO = hVar2.dO(Thread.currentThread().getId());
                                hVar = hVar2;
                            } else {
                                dO = -1;
                            }
                            i4 = 1;
                            Iterator it = list.iterator();
                            while (true) {
                                int i5 = i4;
                                if (it.hasNext()) {
                                    str4 = (String) it.next();
                                    EmojiInfo Zy = dVar.Zy(str4);
                                    if (Zy == null || bi.oW(Zy.Xh()) || !Zy.cnv()) {
                                        Zy = new EmojiInfo();
                                        Zy.field_md5 = str4;
                                        Zy.field_catalog = 85;
                                        Zy.field_source = EmojiInfo.tcT;
                                        Zy.field_lastUseTime = System.currentTimeMillis();
                                    } else {
                                        Zy.field_source = EmojiInfo.tcT;
                                        if (Zy.field_catalog == EmojiInfo.tcB) {
                                            Zy.field_catalog = EmojiInfo.tcH;
                                        }
                                    }
                                    Zy.field_reserved3 = i5;
                                    if (booleanValue) {
                                        x.d("MicroMsg.emoji.EmojiInfoStorage", "need repair");
                                        Zy.field_temp = 2;
                                    }
                                    if (Zy.cnv()) {
                                        at atVar = new at();
                                        atVar.bIi.type = 0;
                                        atVar.bIi.bIk = Zy;
                                        com.tencent.mm.sdk.b.a.sFg.m(atVar);
                                        if (!atVar.bIj.bGZ) {
                                            x.d("MicroMsg.emoji.EmojiInfoStorage", "decode failed re download.");
                                            Zy.field_temp = 2;
                                        }
                                    } else {
                                        x.d("MicroMsg.emoji.EmojiInfoStorage", "file don't exist");
                                        Zy.field_temp = 2;
                                    }
                                    i4 = i5 + 1;
                                    if (dVar.diF.replace("EmojiInfo", "md5", Zy.wH()) < 0) {
                                        if (hVar != null) {
                                            hVar.gp(dO);
                                        }
                                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    }
                                } else {
                                    if (hVar != null) {
                                        hVar.gp(dO);
                                    }
                                    str5 = "MicroMsg.emoji.EmojiInfoStorage";
                                    str2 = "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d";
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                    objArr2[1] = Integer.valueOf(list == null ? 0 : list.size());
                                    x.i(str5, str2, objArr2);
                                }
                            }
                        }
                        au.HU();
                        c.DT().a(aa.a.sOT, Boolean.valueOf(false));
                        d dVar2 = i.aEA().igx;
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
                        dO = System.currentTimeMillis();
                        if (list == null || list.size() <= 0) {
                            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
                        } else {
                            List<String> cnI = dVar2.cnI();
                            if (cnI.size() <= 0) {
                                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
                            } else {
                                Object arrayList = new ArrayList();
                                for (String str42 : cnI) {
                                    if (!list.contains(str42.toLowerCase())) {
                                        arrayList.add(str42);
                                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[]{str42});
                                    }
                                }
                                dVar2.dt(arrayList);
                                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - dO), Integer.valueOf(arrayList.size())});
                            }
                        }
                        ArrayList arrayList2 = (ArrayList) i.aEA().igx.cnJ();
                        if (arrayList2.size() > 0) {
                            x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[]{Integer.valueOf(arrayList2.size())});
                            ArrayList arrayList3 = new ArrayList();
                            int size = arrayList2.size();
                            i4 = 0;
                            while (true) {
                                int i6 = i4;
                                if (i6 >= size) {
                                    break;
                                }
                                str5 = ((String) arrayList2.get(i6)).toLowerCase();
                                if (this.iir == null || !this.iir.containsKey(str5) || this.iir.get(str5) == null) {
                                    x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "emoji info list no contains md5:%s", new Object[]{str5});
                                } else {
                                    ta taVar = (ta) this.iir.get(str5);
                                    arrayList3.add(new com.tencent.mm.plugin.emoji.sync.a.a(str5, taVar.jPK, taVar.lPl, taVar.rwl, taVar.rwm, taVar.rwn, taVar.rem, taVar.rwq));
                                }
                                i4 = i6 + 1;
                            }
                            i.aEx().ije.ijp = list.size();
                            i.aEx().s(arrayList3);
                            i.aEx().ije.aEV();
                            h.mEJ.h(11595, new Object[]{Integer.valueOf(2)});
                            if (ao.isWifi(ad.getContext())) {
                                h.mEJ.h(11595, new Object[]{Integer.valueOf(3)});
                            }
                        } else {
                            au.HU();
                            c.DT().a(aa.a.sOY, Boolean.valueOf(false));
                            x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
                        }
                        com.tencent.mm.sdk.b.a.sFg.m(new nb());
                    }
                    h.mEJ.a(164, 0, 1, false);
                    return;
                } else {
                    x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[]{Integer.valueOf(fsVar.rgz), Integer.valueOf(ftVar.rfd.size())});
                    this.diJ.a(i2, i3, str, this);
                    fsVar.rgz = ftVar.rgz;
                    this.mIndex = fsVar.rgz;
                    a(ftVar);
                    i4 = a(this.dIX, this.diJ);
                    if (i < 0) {
                        x.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[]{Integer.valueOf(i4)});
                        return;
                    }
                    return;
                }
            }
            this.diJ.a(i2, i3, str, this);
            h.mEJ.a(164, 1, 1, false);
            au.HU();
            c.DT().a(aa.a.sPb, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
        } else if (i2 == 0 && i3 == 0) {
            ftVar = (ft) this.diG.dIE.dIL;
            if (ftVar.rgD == null || ftVar.rgD.size() <= 0) {
                x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
            } else {
                i.aEA().igx.dv(ftVar.rgD);
            }
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    private void a(ft ftVar) {
        if (ftVar == null) {
            x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
        } else if (ftVar.rgD == null || ftVar.rgD.size() <= 0) {
            x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
        } else {
            Iterator it = ftVar.rgD.iterator();
            while (it.hasNext()) {
                ta taVar = (ta) it.next();
                String toLowerCase = taVar.rwk.toLowerCase();
                this.iio.add(toLowerCase);
                this.iir.put(toLowerCase, taVar);
            }
        }
    }

    public final int getType() {
        return 697;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        fs fsVar = (fs) this.diG.dID.dIL;
        fsVar.rgz = this.mIndex;
        fsVar.rgA = this.iis;
        fsVar.rgB = this.iit;
        return a(eVar, this.diG, this);
    }

    protected final int Cc() {
        return 20;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }
}
