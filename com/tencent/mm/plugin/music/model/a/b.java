package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.mm.an.a;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static aa<String, String> lyD = new aa(20);
    private static aa<String, Long> lyE = new aa(20);

    public static void h(a aVar) {
        boolean z = true;
        boolean z2 = false;
        if (aVar == null) {
            x.e("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, music is null");
            return;
        }
        int i;
        boolean isWifi = ao.isWifi(ad.getContext());
        PBool pBool = new PBool();
        String a = g.a(bi.oW(aVar.field_songWifiUrl) ? aVar.field_songWebUrl : aVar.field_songWifiUrl, aVar.field_songWapLinkUrl, isWifi, pBool);
        x.i("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", new Object[]{a});
        x.i("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", new Object[]{aVar.field_songWifiUrl});
        String str = "MicroMsg.Music.MusicUrlParser";
        String str2 = "isWifi:%d, isQQMusic:%d";
        Object[] objArr = new Object[2];
        if (isWifi) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(pBool.value ? 1 : 0);
        x.i(str, str2, objArr);
        if (isWifi) {
            z2 = pBool.value;
        }
        if (com.tencent.mm.plugin.music.d.b.IG(a)) {
            x.i("MicroMsg.Music.MusicUrlParser", "can match shake music wifi url");
        } else {
            z = z2;
        }
        aVar.playUrl = a;
        e.aH(a, z);
    }

    public static void dU(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            lyD.put(str, str2);
            lyE.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static String Iw(String str) {
        String str2 = (TextUtils.isEmpty(str) || !lyD.bb(str)) ? null : (String) lyD.get(str);
        if (str2 == null) {
            return str;
        }
        return str2;
    }

    public static boolean i(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.playUrl)) {
            return false;
        }
        if (!Ix(aVar.playUrl)) {
            return false;
        }
        if (g.tB(aVar.field_musicType)) {
            if (e.c(aVar)) {
                x.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
                return false;
            }
        } else if (e.b(aVar)) {
            x.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
            return false;
        }
        if (!lyD.bb(aVar.playUrl)) {
            return true;
        }
        long j = 0;
        if (lyE.bb(aVar.playUrl)) {
            j = ((Long) lyE.get(aVar.playUrl)).longValue();
        }
        if (System.currentTimeMillis() - j <= 86400000) {
            return false;
        }
        lyD.remove(aVar.playUrl);
        lyE.remove(aVar.playUrl);
        x.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
        return true;
    }

    public static boolean Ix(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("wxshakemusic")) {
            return true;
        }
        return false;
    }

    public static String Iy(String str) {
        if (!Ix(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("wxshakemusic");
        if (lastIndexOf > 1) {
            return str.substring(0, lastIndexOf - 1);
        }
        return str;
    }

    public static String mv(String str) {
        String Iw = Iw(str);
        if (!TextUtils.isEmpty(Iw) && !Iw.equalsIgnoreCase(str)) {
            x.i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", new Object[]{Iw});
            return Iw;
        } else if (!Ix(str)) {
            return "";
        } else {
            x.i("MicroMsg.Music.MusicUrlParser", "play url :%s", new Object[]{Iy(Iw)});
            return Iy(Iw);
        }
    }
}
