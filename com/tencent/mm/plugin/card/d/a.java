package com.tencent.mm.plugin.card.d;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static List<WeakReference<a>> htB = new ArrayList();

    public static void a(a aVar) {
        if (htB == null) {
            htB = new ArrayList();
        }
        if (aVar == null) {
            x.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
            return;
        }
        x.i("MicroMsg.CDNDownloadHelpper", "register:%d", new Object[]{Integer.valueOf(aVar.hashCode())});
        htB.add(new WeakReference(aVar));
    }

    public static void b(a aVar) {
        int i = 0;
        if (htB != null && aVar != null) {
            x.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", new Object[]{Integer.valueOf(aVar.hashCode())});
            while (true) {
                int i2 = i;
                if (i2 < htB.size()) {
                    WeakReference weakReference = (WeakReference) htB.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            htB.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static void g(String str, String str2, int i, int i2) {
        int i3 = 0;
        if (str == null || str2 == null || i == 0) {
            x.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
            return;
        }
        String str3;
        String ce = ac.ce(str);
        File file = new File(m.hwL);
        if (!file.mkdirs()) {
            x.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + file.exists());
        }
        String str4 = i2 == 2 ? ".jpeg" : ".mp4";
        if (file.getAbsolutePath().endsWith("/")) {
            str3 = file.getAbsolutePath() + ce + str4;
        } else {
            str3 = file.getAbsolutePath() + File.separator + ce + str4;
        }
        x.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", new Object[]{ce, str3});
        x.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3});
        x.i("MicroMsg.CDNDownloadHelpper", "read file length = " + e.cm(str3));
        WeakReference weakReference;
        a aVar;
        if (e.cn(str3) && e.cm(str3) == i) {
            while (i3 < htB.size()) {
                weakReference = (WeakReference) htB.get(i3);
                if (weakReference != null) {
                    aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.cf(str, str3);
                    }
                }
                i3++;
            }
            return;
        }
        x.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", new Object[]{str3});
        i iVar = new i();
        iVar.dPV = new 1(str, str3);
        iVar.ceW = false;
        iVar.field_mediaId = d.a("cardgiftfile", bi.VF(), str, str);
        iVar.field_fullpath = str3;
        iVar.field_totalLen = i;
        iVar.field_fileType = b.dOo;
        iVar.field_fileId = str;
        iVar.field_aesKey = str2;
        iVar.field_priority = b.dOk;
        iVar.field_needStorage = true;
        x.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", new Object[]{Boolean.valueOf(g.ND().b(iVar, -1)), iVar.field_fileId});
        if (!g.ND().b(iVar, -1)) {
            while (i3 < htB.size()) {
                weakReference = (WeakReference) htB.get(i3);
                if (weakReference != null) {
                    aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.fail(str);
                    }
                }
                i3++;
            }
            x.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
        }
    }
}
