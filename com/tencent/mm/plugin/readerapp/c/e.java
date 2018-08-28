package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.readerapp.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.r.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e implements f {
    public static e mnr = new e();

    private e() {
    }

    public final void a(int i, Map<String, by> map, boolean z) {
        x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "onFunctionMsgUpdate, op: %s, msgIdMap.size: %s, needUpdateTime: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(map.size()), Boolean.valueOf(z)});
        for (String str : map.keySet()) {
            by byVar = (by) map.get(str);
            List<bi> a = a(byVar, str);
            if (a != null) {
                long j = ((long) byVar.lOH) * 1000;
                if (!(a == null || a.size() == 0)) {
                    x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "processInfoList, op: %s, infoList.size: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(a.size())});
                    bi biVar;
                    if (i == 1) {
                        for (bi biVar2 : a) {
                            x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "delete info, functionMsgId: %s", new Object[]{biVar2.IB()});
                            g.bpT().b(biVar2.IB(), biVar2.type, true, true);
                        }
                    } else if (i == 0) {
                        bi biVar3 = null;
                        int i2 = 0;
                        int i3 = 0;
                        List H = g.bpT().H(str, ((bi) a.get(0)).type);
                        bi biVar4 = null;
                        x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, functionMsgId: %s, oldInfoList: %s", new Object[]{str, H});
                        Object obj = null;
                        for (bi biVar5 : a) {
                            if (biVar3 == null) {
                                i3 = biVar5.type;
                                biVar5.dCU = 1;
                                biVar3 = biVar5;
                            }
                            if (H == null) {
                                x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, insert new msg, functionMsgId: %s", new Object[]{biVar5.IB()});
                                i2++;
                                g.bpT().a(biVar5);
                            } else {
                                int i4;
                                if (z) {
                                    biVar5.time = j;
                                    if (biVar3 != null) {
                                        biVar3.time = j;
                                    }
                                    i4 = i2 + 1;
                                } else {
                                    if (biVar4 == null) {
                                        biVar2 = (bi) H.get(0);
                                        Iterator it = H.iterator();
                                        while (true) {
                                            biVar4 = biVar2;
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            biVar2 = (bi) it.next();
                                            if (biVar2.dCU != 1) {
                                                biVar2 = biVar4;
                                            }
                                        }
                                    }
                                    biVar5.time = biVar4.time;
                                    if (biVar3 != null) {
                                        biVar3.time = biVar4.time;
                                    }
                                    i4 = i2;
                                }
                                x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, update the exist one, functionMsgId: %s, time: %s", new Object[]{biVar5.IB(), Long.valueOf(biVar5.time)});
                                if (obj == null) {
                                    g.bpT().b(biVar5.IB(), biVar5.type, false, false);
                                    obj = 1;
                                }
                                g.bpT().a(biVar5);
                                i2 = i4;
                            }
                        }
                        if (i2 > 0) {
                            ai Yq = ((i) g.l(i.class)).FW().Yq(bi.he(i3));
                            if (Yq == null || !Yq.field_username.equals(bi.he(i3))) {
                                ai aiVar = new ai();
                                aiVar.setUsername(bi.he(i3));
                                aiVar.setContent(biVar3 == null ? "" : biVar3.getTitle());
                                aiVar.as(biVar3 == null ? com.tencent.mm.sdk.platformtools.bi.VF() : biVar3.time);
                                aiVar.eX(0);
                                aiVar.eV(1);
                                ((i) g.l(i.class)).FW().d(aiVar);
                            } else {
                                Yq.as(biVar3.time);
                                Yq.eX(0);
                                if (!(com.tencent.mm.sdk.platformtools.bi.oW(biVar3.getTitle()) || biVar3.getTitle().equals(Yq.field_content)) || Yq.field_unReadCount == 0) {
                                    Yq.setContent(biVar3.getTitle());
                                    Yq.eV(Yq.field_unReadCount + 1);
                                }
                                ((i) g.l(i.class)).FW().a(Yq, bi.he(i3));
                            }
                        }
                        g.bpT().doNotify();
                    }
                }
            }
            h.mEJ.h(13440, new Object[]{Integer.valueOf(1)});
        }
    }

    private static List<bi> a(by byVar, String str) {
        String trim = ab.a(byVar.rcl).trim();
        if (trim.indexOf("<") != -1) {
            trim = trim.substring(trim.indexOf("<"));
        }
        long j = ((long) byVar.lOH) * 1000;
        x.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg, createTime: %s, content: %s", new Object[]{Integer.valueOf(byVar.lOH), trim});
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        List<bi> arrayList = new ArrayList();
        try {
            Map z = bl.z(trim, "mmreader");
            int i = 0;
            while (i <= 0) {
                String str2 = ".mmreader.category" + (i > 0 ? Integer.valueOf(i) : "");
                int i2 = com.tencent.mm.sdk.platformtools.bi.getInt((String) z.get(str2 + ".$type"), 0);
                if (i2 != 0) {
                    if (i2 != 20 && i2 != 11) {
                        x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error Type:" + i2);
                        break;
                    }
                    trim = (String) z.get(str2 + ".name");
                    if (com.tencent.mm.sdk.platformtools.bi.oW(trim)) {
                        x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".name  error");
                        break;
                    }
                    String str3 = (String) z.get(str2 + ".topnew.cover");
                    String str4 = (String) z.get(str2 + ".topnew.digest");
                    int i3 = com.tencent.mm.sdk.platformtools.bi.getInt((String) z.get(str2 + ".$count"), 0);
                    if (i3 == 0) {
                        x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$count  error");
                        break;
                    }
                    if (i3 > 1) {
                        str2 = str2 + (i2 == 20 ? ".newitem" : ".item");
                    } else {
                        str2 = str2 + ".item";
                    }
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= i3) {
                            break;
                        }
                        String str5 = str2 + (i5 > 0 ? Integer.valueOf(i5) : "");
                        bi biVar = new bi();
                        biVar.dCW = (long) byVar.rci;
                        biVar.title = (String) z.get(str5 + ".title");
                        if (i5 == 0) {
                            biVar.dCU = 1;
                            biVar.dzy = str3;
                            biVar.dzA = com.tencent.mm.sdk.platformtools.bi.oW(str4) ? (String) z.get(str5 + ".digest") : str4;
                        } else {
                            biVar.dzy = (String) z.get(str5 + ".cover");
                            biVar.dzA = (String) z.get(str5 + ".digest");
                        }
                        biVar.dCV = z.containsKey(new StringBuilder().append(str5).append(".vedio").toString()) ? 1 : 0;
                        biVar.url = (String) z.get(str5 + ".url");
                        biVar.dCP = (String) z.get(str5 + ".shorturl");
                        biVar.dCQ = (String) z.get(str5 + ".longurl");
                        biVar.dCR = com.tencent.mm.sdk.platformtools.bi.getLong((String) z.get(str5 + ".pub_time"), 0);
                        String str6 = (String) z.get(str5 + ".tweetid");
                        if (str6 == null || "".equals(str6)) {
                            str6 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i5)));
                            x.d("MicroMsg.ReaderFuncMsgUpdateMgr", "create tweetID = " + str6);
                        }
                        biVar.dCO = str6;
                        biVar.dCS = (String) z.get(str5 + ".sources.source.name");
                        biVar.dCT = (String) z.get(str5 + ".sources.source.icon");
                        biVar.time = ((long) i) + j;
                        biVar.type = i2;
                        biVar.name = trim;
                        biVar.dCX = str;
                        arrayList.add(biVar);
                        String[] strArr = new Object[2];
                        strArr[0] = com.tencent.mm.pluginsdk.f.h.h(ad.getContext().getString(a.g.fmt_date), biVar.dCR);
                        strArr[1] = com.tencent.mm.pluginsdk.f.h.c(ad.getContext(), biVar.time, false);
                        x.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parse info, pubtime: %s, time: %s", strArr);
                        i4 = i5 + 1;
                    }
                    i++;
                } else {
                    x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error");
                    break;
                }
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReaderFuncMsgUpdateMgr", e, "", new Object[0]);
            x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg error: %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
