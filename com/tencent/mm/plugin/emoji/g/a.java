package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.bk.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a implements com.tencent.mm.model.bv.a {
    public final void a(com.tencent.mm.ab.d.a aVar) {
        by byVar = aVar.dIN;
        if (byVar.jQd == 10002) {
            String a = ab.a(byVar.rcl);
            if (bi.oW(a)) {
                x.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
                return;
            }
            Map z = bl.z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                String str = (String) z.get(".sysmsg.$type");
                String bE = bi.bE(b.bi(q.zz().getBytes()).Cz(16).lR);
                int intValue;
                if (!bi.oW(str) && str.equalsIgnoreCase("EmojiBackup")) {
                    intValue = Integer.valueOf((String) z.get(".sysmsg.EmojiBackup.OpCode")).intValue();
                    str = (String) z.get(".sysmsg.EmojiBackup.DeviceID");
                    x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[]{bE, str});
                    if (bi.oW(str) || !str.equalsIgnoreCase(bE)) {
                        ArrayList zF = b.zF(a);
                        if (intValue == 1) {
                            if (zF == null || zF.size() <= 0) {
                                x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", new Object[]{Integer.valueOf(zF.size())});
                            ArrayList arrayList = new ArrayList();
                            int size = zF.size();
                            for (int i = 0; i < size; i++) {
                                ta taVar = (ta) zF.get(i);
                                if (taVar != null) {
                                    EmojiInfo Zy = i.aEA().igx.Zy(taVar.rwk);
                                    if (Zy != null && Zy.cnv() && Zy.field_catalog == EmojiInfo.tcH) {
                                        x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "md5:%s not need to download", new Object[]{taVar.rwk});
                                    } else {
                                        arrayList.add(new com.tencent.mm.plugin.emoji.sync.a.a(taVar.rwk, taVar.jPK, taVar.lPl, taVar.rwl, taVar.rwm, taVar.rwn, taVar.rem, taVar.rwq));
                                    }
                                }
                            }
                            if (arrayList.size() > 0) {
                                i.aEx().s(arrayList);
                                i.aEx().ije.aEV();
                            }
                        } else if (intValue == 2) {
                            if (zF == null || zF.size() <= 0) {
                                x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            List arrayList2 = new ArrayList();
                            if (zF != null && zF.size() > 0) {
                                Iterator it = zF.iterator();
                                while (it.hasNext()) {
                                    ta taVar2 = (ta) it.next();
                                    if (taVar2 != null) {
                                        arrayList2.add(taVar2.rwk);
                                    }
                                }
                            }
                            i.aEA().igx.dt(arrayList2);
                            au.HU();
                            c.DT().a(com.tencent.mm.storage.aa.a.sOQ, Boolean.valueOf(false));
                        } else if (intValue == 3) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
                            au.HU();
                            c.DT().a(com.tencent.mm.storage.aa.a.sPb, Long.valueOf(0));
                        }
                        au.HU();
                        c.DT().a(com.tencent.mm.storage.aa.a.sOY, Boolean.valueOf(true));
                        return;
                    }
                    x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                } else if (bi.oW(str) || !str.equalsIgnoreCase("EmotionBackup")) {
                    x.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :" + str);
                    return;
                } else {
                    intValue = Integer.valueOf((String) z.get(".sysmsg.EmotionBackup.OpCode")).intValue();
                    str = (String) z.get(".sysmsg.EmotionBackup.DeviceID");
                    if (bi.oW(str) || !str.equalsIgnoreCase(bE)) {
                        ArrayList zG = b.zG(a);
                        if (zG == null || zG.size() <= 0) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            return;
                        } else if (intValue == 1) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", new Object[]{Integer.valueOf(zG.size())});
                            ArrayList arrayList3 = new ArrayList();
                            intValue = zG.size();
                            for (int i2 = 0; i2 < intValue; i2++) {
                                arrayList3.add(new com.tencent.mm.plugin.emoji.sync.a.b((String) zG.get(i2)));
                            }
                            i.aEx().t(arrayList3);
                            i.aEx().ije.aEV();
                            return;
                        } else if (intValue == 2) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[]{Integer.valueOf(zG.size())});
                            i.aEA().igy.ac(zG);
                            return;
                        } else {
                            return;
                        }
                    }
                    x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(byVar.jQd)});
    }
}
