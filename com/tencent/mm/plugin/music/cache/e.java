package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.mm.an.f;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.cache.ipc.a.b;
import com.tencent.mm.plugin.music.cache.ipc.a.d;
import com.tencent.mm.plugin.music.cache.ipc.a.h;
import com.tencent.mm.plugin.music.d.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.util.Map;

public final class e {
    private static aa<String, Boolean> lxA = new aa(20);
    private static aa<String, Integer> lxB = new aa(20);
    private static aa<String, Integer> lxC = new aa(20);
    private static aa<String, Long> lxD = new aa(20);
    private static aa<String, String> lxE = new aa(20);
    private static String lxF = null;
    private static int lxG = 0;
    private static aa<String, String> lxz = new aa(20);

    public static void Ii(String str) {
        IPCString iPCString = (IPCString) XIPCInvoker.a("com.tencent.mm", new IPCString(str), h.class);
        CharSequence IE = iPCString == null ? a.IE(str) : iPCString.value;
        if (!TextUtils.isEmpty(IE) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(IE)) {
            lxz.put(str, IE);
        }
    }

    public static String Gq() {
        if (lxF != null) {
            return lxF;
        }
        IPCString iPCString = (IPCString) XIPCInvoker.a("com.tencent.mm", null, com.tencent.mm.plugin.music.cache.ipc.a.a.class);
        String str = iPCString == null ? null : iPCString.value;
        if (TextUtils.isEmpty(str)) {
            x.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[]{str});
            return com.tencent.mm.compatible.util.e.bnE;
        }
        x.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[]{str});
        lxF = str;
        return str;
    }

    public static int bhL() {
        if (lxG != 0) {
            return lxG;
        }
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a("com.tencent.mm", new IPCInteger(3), d.class);
        lxG = iPCInteger == null ? 3 : iPCInteger.value;
        x.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[]{Integer.valueOf(lxG)});
        if (lxG == 0) {
            lxG = 3;
        }
        return lxG;
    }

    public static String Ij(String str) {
        if (lxz.bb(str)) {
            return (String) lxz.get(str);
        }
        return "";
    }

    public static void aH(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            lxA.put(str, Boolean.valueOf(z));
        }
    }

    public static boolean Ik(String str) {
        if (lxA.bb(str)) {
            return ((Boolean) lxA.get(str)).booleanValue();
        }
        return false;
    }

    public static void k(String str, Map<String, String> map) {
        if (map != null && Ik(str)) {
            map.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
            map.put("referer", "stream12.qqmusic.qq.com");
        }
    }

    public static void dR(String str, String str2) {
        x.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType mimeType:%s", new Object[]{str2});
        Object Ij = Ij(str);
        if (TextUtils.isEmpty(Ij)) {
            x.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
            return;
        }
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.lxx = Ij;
        iPCAudioParamRequest.mimeType = str2;
        XIPCInvoker.a("com.tencent.mm", iPCAudioParamRequest, com.tencent.mm.plugin.music.cache.ipc.a.e.class);
    }

    public static String Il(String str) {
        Object Ij = Ij(str);
        if (TextUtils.isEmpty(Ij)) {
            x.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
            return null;
        }
        IPCString iPCString = (IPCString) XIPCInvoker.a("com.tencent.mm", new IPCString(Ij), b.class);
        return iPCString == null ? null : iPCString.value;
    }

    public static String Im(String str) {
        if (lxE.bb(str)) {
            return (String) lxE.get(str);
        }
        return null;
    }

    public static void dS(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            lxE.put(str, str2);
        }
    }

    public static long In(String str) {
        if (lxD.bb(str)) {
            return ((Long) lxD.get(str)).longValue();
        }
        return -1;
    }

    public static void Z(String str, long j) {
        if (j > 0) {
            lxD.put(str, Long.valueOf(j));
        }
    }

    public static long Io(String str) {
        File file = new File(a.IF(str));
        return file.exists() ? file.length() : -1;
    }

    public static void deleteFile(String str) {
        Logger.i("MicroMsg.PieceFileCache", "deleteFileByUrl");
        f.deleteFile(a.IF(str));
    }

    public static void bL(String str, int i) {
        if (str != null) {
            lxB.put(str, Integer.valueOf(i));
        }
    }

    public static int Ip(String str) {
        if (str == null || !lxB.bb(str)) {
            return 0;
        }
        return ((Integer) lxB.get(str)).intValue();
    }

    public static void bM(String str, int i) {
        if (str != null) {
            lxC.put(str, Integer.valueOf(i));
        }
    }

    public static int Iq(String str) {
        if (str == null || !lxC.bb(str)) {
            return 0;
        }
        return ((Integer) lxC.get(str)).intValue();
    }

    public static boolean b(com.tencent.mm.an.a aVar) {
        boolean isWifi = ao.isWifi(ad.getContext());
        boolean z = isWifi ? aVar.field_wifiEndFlag == 1 : aVar.field_endFlag == 1;
        if (z && new File(a.g(aVar, isWifi)).exists()) {
            return true;
        }
        return false;
    }

    public static boolean c(com.tencent.mm.an.a aVar) {
        int i;
        if (aVar == null || TextUtils.isEmpty(aVar.playUrl)) {
            i = 0;
        } else {
            f mr = ((com.tencent.mm.an.a.a) g.l(com.tencent.mm.an.a.a.class)).mr(a.IE(aVar.playUrl));
            i = (mr == null || mr.field_fileCacheComplete != 1) ? 0 : 1;
        }
        if (i != 0) {
            String str = aVar.playUrl;
            Logger.i("MicroMsg.PieceFileCache", "existFileByUrl");
            str = a.IF(str);
            Logger.i("MicroMsg.PieceFileCache", "existFile, fileName:" + str);
            x.i("MicroMsg.PieceFileCache", "the piece File exist:%b", new Object[]{Boolean.valueOf(new File(str).exists())});
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }
}
