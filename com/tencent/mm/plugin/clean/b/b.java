package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.plugin.j.b.a;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b implements Runnable {
    private long hQF = 0;
    private List<String> hQJ;
    private List<i> hQK;
    private h hQL;

    public b(List<String> list, List<i> list2, h hVar) {
        this.hQJ = list;
        this.hQK = list2;
        this.hQL = hVar;
    }

    private void aH(List<a> list) {
        int size = list.size();
        HashSet hashSet = new HashSet();
        au.HU();
        long dO = c.FO().dO(Thread.currentThread().getId());
        for (int i = 0; i < size; i++) {
            a aVar = (a) list.get(i);
            long VG = bi.VG();
            if (!hashSet.contains(Long.valueOf(aVar.field_msgId))) {
                au.HU();
                bd dW = c.FT().dW(aVar.field_msgId);
                if (!(dW.field_msgId == 0 || dW.cmu())) {
                    com.tencent.mm.plugin.j.b avr = com.tencent.mm.plugin.j.b.avr();
                    long j = aVar.field_msgId;
                    avr.hsJ = true;
                    avr.hsI.add(Long.valueOf(j));
                    x.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", new Object[]{Integer.valueOf(avr.hashCode()), Long.valueOf(j), bi.cjd()});
                    dW.cmv();
                    au.HU();
                    c.FT().a(aVar.field_msgId, dW);
                }
                hashSet.add(Long.valueOf(aVar.field_msgId));
                x.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", new Object[]{avy(), Long.valueOf(bi.bI(VG))});
            }
            if (!(aVar == null || com.tencent.mm.plugin.j.a.nB(aVar.field_msgSubType) || aVar.field_size <= 0)) {
                this.hQF += aVar.field_size;
                FileOp.deleteFile(g.Ei().dqo + aVar.field_path);
                aVar.field_path = "";
                aVar.field_size = 0;
                com.tencent.mm.plugin.j.b.avr().avs().a(aVar.sKx, aVar, false);
            }
            x.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", new Object[]{avy(), Long.valueOf(bi.bI(VG))});
        }
        au.HU();
        c.FO().gp(dO);
    }

    public final void run() {
        int i;
        long j;
        if (this.hQJ != null) {
            long VG = bi.VG();
            int size = this.hQJ.size();
            i = 0;
            Iterator it = this.hQJ.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    String str = (String) it.next();
                    if (!bi.oW(str)) {
                        long VG2 = bi.VG();
                        PLong pLong = new PLong();
                        PLong pLong2 = new PLong();
                        com.tencent.mm.plugin.j.b.b avs = com.tencent.mm.plugin.j.b.avr().avs();
                        long VG3 = bi.VG();
                        String str2 = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + str + "' and msgSubType in (1,20,23,30,32,34 ) and size > 0 ";
                        Cursor cursor = null;
                        try {
                            cursor = avs.diF.rawQuery(str2, null);
                            if (cursor != null && cursor.moveToFirst()) {
                                pLong.value = cursor.getLong(0);
                                pLong2.value = cursor.getLong(1);
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", new Object[]{str2});
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable th) {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                        x.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", new Object[]{str, Long.valueOf(bi.bI(VG3))});
                        pLong2.value--;
                        j = pLong.value;
                        VG3 = Math.max(j - 2592000000L, pLong2.value);
                        if (VG3 == j) {
                            VG3--;
                        }
                        List i3 = com.tencent.mm.plugin.j.b.avr().avs().i(str, j, VG3);
                        long size2 = ((long) i3.size()) + 0;
                        aH(i3);
                        while (true) {
                            j = VG3;
                            if (j <= pLong2.value) {
                                break;
                            }
                            VG3 = Math.max(j - 2592000000L, pLong2.value);
                            if (VG3 == j) {
                                VG3--;
                            }
                            i3 = com.tencent.mm.plugin.j.b.avr().avs().i(str, j, VG3);
                            size2 += (long) i3.size();
                            aH(i3);
                        }
                        x.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", new Object[]{avy(), str, Long.valueOf(size2), Long.valueOf(pLong2.value), Long.valueOf(pLong.value), Long.valueOf(bi.bI(VG2))});
                    }
                    i = i2 + 1;
                    if (this.hQL != null) {
                        this.hQL.cq(i, size);
                    }
                } else {
                    if (this.hQL != null) {
                        this.hQL.ck(this.hQF);
                    }
                    com.tencent.mm.plugin.j.b.avr().avv();
                    x.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", new Object[]{avy(), Long.valueOf(bi.bI(VG))});
                    return;
                }
            }
        } else if (this.hQK != null) {
            j = bi.VG();
            int size3 = this.hQK.size();
            i = 0;
            Iterator it2 = this.hQK.iterator();
            while (true) {
                int i4 = i;
                if (!it2.hasNext()) {
                    break;
                }
                aH(((i) it2.next()).hRo);
                i = i4 + 1;
                if (this.hQL != null) {
                    this.hQL.cq(i, size3);
                }
            }
            if (this.hQL != null) {
                this.hQL.ck(this.hQF);
            }
            com.tencent.mm.plugin.j.b.avr().avv();
            x.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", new Object[]{avy(), Long.valueOf(bi.bI(j))});
        }
    }

    private String avy() {
        return hashCode();
    }
}
