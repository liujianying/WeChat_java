package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.plugin.j.b.a;
import com.tencent.mm.plugin.j.b.b;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class b$b implements Runnable {
    final /* synthetic */ b hRX;

    private b$b(b bVar) {
        this.hRX = bVar;
    }

    /* synthetic */ b$b(b bVar, byte b) {
        this(bVar);
    }

    public final void run() {
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        b avs = com.tencent.mm.plugin.j.b.avr().avs();
        String a = b.a(this.hRX);
        long VG = bi.VG();
        String str = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + a + "' and msgType in (43,62,44,3,49,268435505 )";
        Cursor cursor = null;
        try {
            cursor = avs.diF.rawQuery(str, null);
            if (cursor != null && cursor.moveToFirst()) {
                pLong.value = cursor.getLong(0);
                pLong2.value = cursor.getLong(1);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.i("MicroMsg.WxFileIndexStorage", "getMediaMsgTimeByUsername [%s] cost[%d]", a, Long.valueOf(bi.bI(VG)));
        pLong2.value--;
        long j = pLong.value;
        VG = Math.max(j - 604800000, pLong2.value);
        try {
            if (!b.b(this.hRX)) {
                if (VG == j) {
                    VG--;
                }
                aI(com.tencent.mm.plugin.j.b.avr().avs().j(b.a(this.hRX), j, VG));
                b.c(this.hRX);
                while (true) {
                    j = VG;
                    if (!b.b(this.hRX) && j > pLong2.value) {
                        VG = Math.max(j - 15552000000L, pLong2.value);
                        if (VG == j) {
                            VG--;
                        }
                        aI(com.tencent.mm.plugin.j.b.avr().avs().j(b.a(this.hRX), j, VG));
                        b.c(this.hRX);
                    } else {
                        return;
                    }
                }
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.CleanChattingDetailAdapter", e2, "", new Object[0]);
        }
    }

    private void aI(List<a> list) {
        int size = list.size();
        HashMap hashMap = new HashMap();
        Collection arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            a aVar = (a) list.get(i);
            i iVar = (i) hashMap.get(Long.valueOf(aVar.field_msgId));
            if (iVar == null) {
                iVar = new i();
                hashMap.put(Long.valueOf(aVar.field_msgId), iVar);
                arrayList.add(iVar);
            }
            iVar.hRo.add(aVar);
            iVar.enK = aVar.field_msgtime;
            iVar.userName = aVar.field_username;
            iVar.bIZ = aVar.field_msgId;
            if (!com.tencent.mm.plugin.j.a.nB(aVar.field_msgSubType)) {
                iVar.size += aVar.field_size;
            }
            switch (aVar.field_msgSubType) {
                case 1:
                    iVar.filePath = g.Ei().dqo + aVar.field_path;
                    iVar.type = 3;
                    break;
                case 2:
                    iVar.bOX = g.Ei().dqo + aVar.field_path;
                    iVar.type = 3;
                    break;
                case 20:
                    iVar.filePath = g.Ei().dqo + aVar.field_path;
                    iVar.type = 1;
                    break;
                case 21:
                    iVar.bOX = g.Ei().dqo + aVar.field_path;
                    iVar.type = 1;
                    break;
                case 30:
                    iVar.filePath = g.Ei().dqo + aVar.field_path;
                    iVar.type = 1;
                    break;
                case 31:
                    iVar.bOX = g.Ei().dqo + aVar.field_path;
                    iVar.type = 1;
                    break;
                case 32:
                    iVar.filePath = g.Ei().dqo + aVar.field_path;
                    iVar.type = 4;
                    break;
                case 33:
                    iVar.bOX = g.Ei().dqo + aVar.field_path;
                    iVar.type = 4;
                    break;
                case 34:
                    iVar.filePath = g.Ei().dqo + aVar.field_path;
                    iVar.type = 4;
                    break;
                case 35:
                    iVar.bOX = g.Ei().dqo + aVar.field_path;
                    iVar.type = 4;
                    break;
                default:
                    break;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((i) it.next()).size <= 0) {
                it.remove();
            }
        }
        b.d(this.hRX).addAll(arrayList);
    }
}
