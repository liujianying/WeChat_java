package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class c implements d {
    public final b b(a aVar) {
        Throwable e;
        int i;
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.ReaderAppMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        }
        g.bpT().aW((long) byVar.rci);
        String a = ab.a(byVar.rcl);
        long VF = bi.VF();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        int i2 = 0;
        List<com.tencent.mm.model.bi> arrayList = new ArrayList();
        int i3 = 0;
        int i4;
        try {
            Map z = bl.z(a, "mmreader");
            if (z == null) {
                return null;
            }
            String str;
            com.tencent.mm.model.bi biVar;
            i2 = 0;
            int i5 = 0;
            while (i2 <= 0) {
                try {
                    String str2 = ".mmreader.category" + (i2 > 0 ? Integer.valueOf(i2) : "");
                    i3 = bi.getInt((String) z.get(str2 + ".$type"), 0);
                    if (i3 != 0) {
                        if (i3 != 20 && i3 != 11) {
                            x.e("MicroMsg.ReaderAppMsgExtension", "get " + str2 + ".$type  error Type:" + i3);
                            i4 = i2;
                            break;
                        }
                        a = (String) z.get(str2 + ".name");
                        if (bi.oW(a)) {
                            x.e("MicroMsg.ReaderAppMsgExtension", "get " + str2 + ".name  error");
                            i5 = i3;
                            i4 = i2;
                            break;
                        }
                        String str3 = (String) z.get(str2 + ".topnew.cover");
                        str = (String) z.get(str2 + ".topnew.digest");
                        int i6 = bi.getInt((String) z.get(str2 + ".$count"), 0);
                        if (i6 == 0) {
                            x.e("MicroMsg.ReaderAppMsgExtension", "get " + str2 + ".$count  error");
                            i5 = i3;
                            i4 = i2;
                            break;
                        }
                        if (i6 > 1) {
                            str2 = str2 + (i3 == 20 ? ".newitem" : ".item");
                        } else {
                            str2 = str2 + ".item";
                        }
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= i6) {
                                break;
                            }
                            String str4 = str2 + (i8 > 0 ? Integer.valueOf(i8) : "");
                            com.tencent.mm.model.bi biVar2 = new com.tencent.mm.model.bi();
                            biVar2.dCW = (long) byVar.rci;
                            biVar2.title = (String) z.get(str4 + ".title");
                            if (i8 == 0) {
                                long j = bi.getLong((String) z.get(str4 + ".pub_time"), 0);
                                if (j > 0) {
                                    VF = 1000 * j;
                                }
                                biVar2.dCU = 1;
                                biVar2.dzy = str3;
                                biVar2.dzA = bi.oW(str) ? (String) z.get(str4 + ".digest") : str;
                            } else {
                                biVar2.dzy = (String) z.get(str4 + ".cover");
                                biVar2.dzA = (String) z.get(str4 + ".digest");
                            }
                            biVar2.dCV = z.containsKey(new StringBuilder().append(str4).append(".vedio").toString()) ? 1 : 0;
                            biVar2.url = (String) z.get(str4 + ".url");
                            biVar2.dCP = (String) z.get(str4 + ".shorturl");
                            biVar2.dCQ = (String) z.get(str4 + ".longurl");
                            biVar2.dCR = bi.getLong((String) z.get(str4 + ".pub_time"), 0);
                            String str5 = (String) z.get(str4 + ".tweetid");
                            if (str5 == null || "".equals(str5)) {
                                str5 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i8)));
                                x.d("MicroMsg.ReaderAppMsgExtension", "create tweetID = " + str5);
                            }
                            biVar2.dCO = str5;
                            biVar2.dCS = (String) z.get(str4 + ".sources.source.name");
                            biVar2.dCT = (String) z.get(str4 + ".sources.source.icon");
                            biVar2.time = ((long) i2) + VF;
                            biVar2.type = i3;
                            biVar2.name = a;
                            arrayList.add(biVar2);
                            i7 = i8 + 1;
                        }
                        i2++;
                        i5 = i3;
                    } else {
                        x.e("MicroMsg.ReaderAppMsgExtension", "get " + str2 + ".$type  error");
                        i4 = i2;
                        break;
                    }
                } catch (Exception e2) {
                    e = e2;
                    i = i5;
                    i4 = i2;
                    x.printErrStackTrace("MicroMsg.ReaderAppMsgExtension", e, "", new Object[0]);
                    i5 = i;
                    x.d("MicroMsg.ReaderAppMsgExtension", "type = " + i5 + ", want to receive news? " + bpR());
                    for (com.tencent.mm.model.bi biVar3 : arrayList) {
                        Object obj;
                        if (!bi.oW(biVar3.getTitle())) {
                            if (bi.oW(biVar3.getUrl())) {
                                x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + biVar3.Iv() + ", type = " + biVar3.type);
                                obj = null;
                                break;
                            }
                        }
                        x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + biVar3.Iv() + ", type = " + biVar3.type);
                        obj = null;
                        break;
                    }
                    i = 1;
                    if (arrayList.size() > 0) {
                    }
                    return null;
                }
            }
            i4 = i2;
            x.d("MicroMsg.ReaderAppMsgExtension", "type = " + i5 + ", want to receive news? " + bpR());
            for (com.tencent.mm.model.bi biVar32 : arrayList) {
                Object obj2;
                if (!bi.oW(biVar32.getTitle())) {
                    if (bi.oW(biVar32.getUrl())) {
                        x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + biVar32.Iv() + ", type = " + biVar32.type);
                        obj2 = null;
                        break;
                    }
                }
                x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + biVar32.Iv() + ", type = " + biVar32.type);
                obj2 = null;
                break;
            }
            i = 1;
            if (arrayList.size() > 0 || obj2 == null) {
                return null;
            }
            int i9 = 0;
            com.tencent.mm.model.bi biVar4 = null;
            i3 = 0;
            while (i3 < arrayList.size()) {
                if (g.bpT().a((com.tencent.mm.model.bi) arrayList.get(i3))) {
                    if (biVar4 == null) {
                        biVar32 = (com.tencent.mm.model.bi) arrayList.get(i3);
                        biVar32.dCU = 1;
                    } else {
                        biVar32 = biVar4;
                    }
                    i9++;
                } else {
                    biVar32 = biVar4;
                }
                i3++;
                biVar4 = biVar32;
            }
            if (i9 > 0) {
                ai Yq = ((i) g.l(i.class)).FW().Yq(com.tencent.mm.model.bi.he(i5));
                if (Yq == null || !Yq.field_username.equals(com.tencent.mm.model.bi.he(i5))) {
                    ai aiVar = new ai();
                    aiVar.setUsername(com.tencent.mm.model.bi.he(i5));
                    aiVar.setContent(biVar4 == null ? "" : biVar4.getTitle());
                    aiVar.as(biVar4 == null ? bi.VF() : biVar4.time);
                    aiVar.eX(0);
                    aiVar.eV(i4);
                    ((i) g.l(i.class)).FW().d(aiVar);
                } else {
                    Yq.setContent(biVar4.getTitle());
                    Yq.as(biVar4.time);
                    Yq.eX(0);
                    Yq.eV(Yq.field_unReadCount + i4);
                    ((i) g.l(i.class)).FW().a(Yq, com.tencent.mm.model.bi.he(i5));
                }
                g.bpT().doNotify();
                str = biVar4.getTitle();
                bd bdVar = new bd();
                bdVar.setContent(str);
                bdVar.ep(com.tencent.mm.model.bi.he(i5));
                bdVar.setType(1);
                bdVar.setMsgId(7377812);
                return new b(bdVar, true);
            }
            x.e("MicroMsg.ReaderAppMsgExtension", "insert error");
            return null;
        } catch (Throwable e3) {
            e = e3;
            i = i3;
            i4 = i2;
        }
    }

    public static boolean bpR() {
        return (q.GL() & 1024) == 0;
    }

    public final void h(bd bdVar) {
    }
}
