package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.mm.an.b;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a {
    public String bKC;
    public String bPg;
    public int bPh;
    private HashMap<String, c> dRX;
    public String ghU;
    public String ghV;

    private static class a {
        private static a ghW = new a();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.dRX = new HashMap();
    }

    public final boolean bE(String str, String str2) {
        if (str2.equalsIgnoreCase("play")) {
            x.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[]{str, this.ghU});
            return true;
        }
        if (str.equalsIgnoreCase(this.ghU)) {
            avq Qa = b.Qa();
            if (Qa != null && Qa.rsp.equals(this.ghV)) {
                return true;
            }
        }
        return false;
    }

    public final void a(c cVar, String str) {
        if (this.dRX.get(str) != null) {
            x.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[]{str});
            return;
        }
        com.tencent.mm.sdk.b.a.sFg.b(cVar);
        this.dRX.put(str, cVar);
    }

    public final void tl(String str) {
        if (this.dRX.get(str) == null) {
            x.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[]{str});
            return;
        }
        com.tencent.mm.sdk.b.a.sFg.c((c) this.dRX.remove(str));
        this.dRX.remove(str);
    }

    public final boolean uu(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
            return false;
        } else if (!str.equalsIgnoreCase(this.ghU)) {
            x.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
            return false;
        } else if (TextUtils.isEmpty(this.ghV)) {
            x.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
            return false;
        } else {
            avq Qa = b.Qa();
            if (Qa == null) {
                x.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
                return false;
            } else if (!this.ghV.equalsIgnoreCase(Qa.rsp)) {
                x.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
                return false;
            } else if (b.PY()) {
                return true;
            } else {
                x.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
                return false;
            }
        }
    }
}
