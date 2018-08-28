package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import android.content.Intent;
import android.media.AudioManager;
import com.eclipsesource.v8.BuildConfig;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.music.model.f.a;
import com.tencent.mm.plugin.music.model.f.b;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class h implements ar {
    private c bannerOnInitListener = new 4(this);
    private AudioManager daT;
    private c<d> juU = new 5(this);
    private c lyA = new 3(this);
    private c lyv;
    private e lyw;
    private a lyx;
    private ClipboardManager lyy;
    private b lyz;

    private static h bib() {
        return (h) p.v(h.class);
    }

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        HashMap<Integer, com.tencent.mm.bt.h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("Music".hashCode()), new 1(this));
        hashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new com.tencent.mm.bt.h.d() {
            public final String[] xb() {
                return new String[]{i.a(cy.wI(), "PieceMusicInfo")};
            }
        });
        return hashMap;
    }

    public static e bic() {
        if (bib().lyw == null) {
            bib().lyw = new e();
        }
        return bib().lyw;
    }

    public static a bid() {
        if (bib().lyx == null) {
            bib().lyx = new a(g.Ei().dqq);
        }
        return bib().lyx;
    }

    public static AudioManager bie() {
        if (bib().daT == null) {
            bib().daT = (AudioManager) ad.getContext().getSystemService("audio");
        }
        return bib().daT;
    }

    public static ClipboardManager bif() {
        if (bib().lyy == null) {
            bib().lyy = (ClipboardManager) ad.getContext().getSystemService("clipboard");
        }
        return bib().lyy;
    }

    public static c big() {
        if (bib().lyv == null) {
            bib().lyv = new c();
        }
        return bib().lyv;
    }

    public static b bih() {
        if (bib().lyz == null) {
            bib().lyz = new b(g.Ei().dqq);
        }
        return bib().lyz;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        this.juU.cht();
        this.lyA.cht();
        this.bannerOnInitListener.cht();
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.lyw != null) {
            e eVar = this.lyw;
            eVar.PW();
            x.i("MicroMsg.Music.MusicPlayerManager", BuildConfig.BUILD_TYPE);
            if (eVar.lyd != null) {
                com.tencent.mm.plugin.music.model.e.g gVar = eVar.lyd;
                x.i("MicroMsg.Music.QQMusicPlayer", BuildConfig.BUILD_TYPE);
                if (gVar.lwZ != null) {
                    gVar.lwZ.release();
                    gVar.lwZ = null;
                }
                gVar.bis();
            }
            if (eVar.lye != null) {
                com.tencent.mm.plugin.music.model.c.a aVar = eVar.lye;
                x.i("MicroMsg.Music.ExoMusicPlayer", BuildConfig.BUILD_TYPE);
                aVar.fLN.removeMessages(100);
                aVar.bis();
                if (aVar.lyN != null) {
                    aVar.lyN.b(aVar.lyT);
                    aVar.lyN.aeE.remove(aVar);
                    aVar.lyN.release();
                    aVar.lyN = null;
                }
                if (aVar.lyR != null) {
                    aVar.lyR.kE();
                    aVar.lyR = null;
                }
                aVar.lyO = null;
                aVar.lyQ = null;
            }
            ah.M(eVar.lyk);
            eVar.lyb.clear();
            g.Eh().dpP.b(520, eVar);
            g.Eh().dpP.b(940, eVar);
            g.Eh().dpP.b(769, eVar);
            com.tencent.mm.plugin.music.model.notification.b bVar = eVar.lyf;
            x.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
            Intent intent = new Intent();
            intent.setClass(ad.getContext(), MMMusicPlayerService.class);
            ad.getContext().stopService(intent);
            bVar.lzf = null;
            bVar.fIu.dead();
        }
        this.lyw = null;
        this.lyv = null;
        this.lyx = null;
        this.daT = null;
        this.lyy = null;
        this.lyz = null;
        com.tencent.mm.sdk.b.a.sFg.c(this.lyA);
        this.lyA.dead();
        this.bannerOnInitListener.dead();
        this.juU.dead();
    }
}
