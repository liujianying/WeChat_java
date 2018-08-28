package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static Map<String, a> nxB = new ConcurrentHashMap();
    private static volatile long nxC = 0;

    private static void bzj() {
        synchronized (nxB) {
            if (bi.bI(nxC) <= 120000) {
                return;
            }
            nxC = bi.VG();
            nxB.clear();
        }
    }

    private static String MS(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    public static void a(String str, String str2, int i, int i2, int i3, long j) {
        try {
            b bVar = new b((byte) 0);
            bVar.nxD = MS(str);
            bVar.mMimeType = str2;
            bVar.mWidth = i;
            bVar.mHeight = i2;
            bVar.nxF = i3;
            bVar.nxG = j;
            StringBuilder stringBuilder = new StringBuilder(1024);
            stringBuilder.append(bVar.nxD).append(',').append(bVar.mMimeType).append(',').append(bVar.mWidth).append(',').append(bVar.mHeight).append(',').append(bVar.nxF).append(',').append(bVar.nxG);
            String stringBuilder2 = stringBuilder.toString();
            x.i("MicroMsg.SnsImgStats", "report up: " + stringBuilder2);
            h.mEJ.k(13512, stringBuilder2);
        } catch (Exception e) {
        }
    }

    public static void a(String str, String str2, int i, String str3, int i2, int i3, int i4, long j, long j2) {
        try {
            a aVar = new a((byte) 0);
            aVar.nxD = MS(str2);
            aVar.nxE = i;
            aVar.mMimeType = str3;
            aVar.mWidth = i2;
            aVar.mHeight = i3;
            aVar.nxF = i4;
            aVar.nxG = j;
            aVar.nxH = j2;
            nxB.put(str, aVar);
        } catch (Exception e) {
        }
    }

    public static void ag(String str, long j) {
        try {
            a aVar = (a) nxB.remove(str);
            if (aVar != null) {
                aVar.nxI = j;
                StringBuilder stringBuilder = new StringBuilder(1024);
                stringBuilder.append(aVar.nxD).append(',').append(aVar.nxE).append(',').append(aVar.mMimeType).append(',').append(aVar.mWidth).append(',').append(aVar.mHeight).append(',').append(aVar.nxF).append(',').append(aVar.nxG).append(',').append(aVar.nxH).append(',').append(aVar.nxI);
                String stringBuilder2 = stringBuilder.toString();
                x.i("MicroMsg.SnsImgStats", "report dl: " + stringBuilder2);
                h.mEJ.k(13513, stringBuilder2);
                bzj();
            }
        } catch (Exception e) {
        } finally {
            bzj();
        }
    }
}
