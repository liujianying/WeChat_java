package com.tencent.mm.plugin.music.model;

import android.content.ContentValues;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.music.model.c.a;
import com.tencent.mm.plugin.music.model.d.c;
import com.tencent.mm.plugin.music.model.e.g;
import com.tencent.mm.plugin.music.model.notification.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.agx;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.oe;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class e implements com.tencent.mm.ab.e {
    public int lya;
    public List<String> lyb;
    public com.tencent.mm.plugin.music.model.e.e lyc = new com.tencent.mm.plugin.music.model.e.e();
    public g lyd = new g();
    a lye = new a();
    b lyf = new b();
    public com.tencent.mm.plugin.music.model.d.b lyg;
    private com.tencent.mm.plugin.music.model.d.a lyh;
    private c lyi;
    public boolean lyj;
    Runnable lyk = new Runnable() {
        public final void run() {
            x.i("MicroMsg.Music.MusicPlayerManager", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[]{Boolean.valueOf(e.this.bhQ().PZ()), Boolean.valueOf(e.this.bhQ().PY())});
            if (e.this.bhQ().PZ() && !r1) {
                e.this.bhQ().stopPlay();
            }
        }
    };
    public int mode = 1;

    public e() {
        b bVar = this.lyf;
        x.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
        bVar.fIu = new b$1(bVar);
        bVar.fIu.cht();
        com.tencent.mm.kernel.g.Eh().dpP.a(520, this);
        com.tencent.mm.kernel.g.Eh().dpP.a(769, this);
        this.lyb = new ArrayList();
    }

    public final void e(avq avq) {
        if (avq == null && this.lyb.size() == 0) {
            x.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null && musicList's size is 0");
            return;
        }
        if (avq != null) {
            this.lyb.clear();
            this.lyb.add(com.tencent.mm.plugin.music.d.a.x(avq));
            this.lya = 0;
            h.bid().w(avq);
            if (this.mode == 2) {
                bhT();
            }
        }
        x.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic, threadId:%d", new Object[]{Integer.valueOf(Process.myTid())});
        if (avq == null) {
            avq = bhS();
        }
        if (avq != null) {
            x.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", new Object[]{Integer.valueOf(avq.rYj)});
        }
        com.tencent.mm.an.a bhR = bhR();
        if (bhR == null || !g.g(bhR)) {
            x.e("MicroMsg.Music.MusicPlayerManager", "music or url is null, do not start music");
            f(avq);
        } else if (bhR.field_isBlock == 1) {
            x.i("MicroMsg.Music.MusicPlayerManager", "not play new music, music is block %s", new Object[]{bhR.field_musicId});
            f(avq);
            f.a(bhR, true);
        } else {
            x.i("MicroMsg.Music.MusicPlayerManager", "music protocol:%s", new Object[]{bhR.field_protocol});
            if (this.lyh != null) {
                com.tencent.mm.kernel.g.Eh().dpP.c(this.lyh);
            }
            com.tencent.mm.kernel.g.Eh().dpP.a(940, this);
            this.lyh = new com.tencent.mm.plugin.music.model.d.a(bhR.field_musicType, bhR);
            com.tencent.mm.kernel.g.Eh().dpP.a(this.lyh, 0);
            com.tencent.mm.plugin.music.model.a.b.h(bhR);
            if (com.tencent.mm.plugin.music.model.a.b.i(bhR)) {
                x.i("MicroMsg.Music.MusicPlayerManager", "get shake music new url to play");
                Is(bhR.playUrl);
                return;
            }
            d(bhR);
        }
    }

    final void f(avq avq) {
        if (g.l(avq)) {
            this.lye.v(avq);
        } else if (avq == null || !g.tB(avq.rYj)) {
            this.lyc.v(avq);
        } else {
            this.lyd.v(avq);
        }
    }

    final void d(com.tencent.mm.an.a aVar) {
        if (g.l(aVar.PV())) {
            x.i("MicroMsg.Music.MusicPlayerManager", "use exoMusicPlayer");
            bhP();
            this.lye.j(aVar);
        } else if (g.tB(aVar.field_musicType)) {
            x.i("MicroMsg.Music.MusicPlayerManager", "use qqMusicPlayer");
            bhP();
            this.lyd.j(aVar);
        } else {
            x.i("MicroMsg.Music.MusicPlayerManager", "use musicPlayer");
            bhP();
            com.tencent.mm.plugin.music.model.e.e eVar = this.lyc;
            x.i("MicroMsg.Music.MusicPlayer", "init and start download");
            eVar.stopPlay();
            f.a(aVar, false);
            x.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
            eVar.lzB = false;
            eVar.lzC = false;
            eVar.lzD = false;
            eVar.lzE = false;
            eVar.lzF = false;
            eVar.lzG = false;
            eVar.lzH = false;
            eVar.lzI = false;
            eVar.lzJ = false;
            eVar.lzK = 0;
            eVar.b(aVar, false);
            if (aVar == null) {
                x.i("MicroMsg.Music.MusicPlayer", "music is null");
            } else {
                x.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s", new Object[]{aVar.field_songWifiUrl});
                eVar.lzz = new com.tencent.mm.plugin.music.model.b.a(aVar);
                eVar.lzz.lyI = eVar.lzM;
                eVar.lzz.start();
            }
        }
        if (aVar.field_musicType != 11) {
            bhX();
        }
    }

    private void bhP() {
        if (this.lyc.PY()) {
            this.lyc.stopPlay();
        }
        if (this.lyd.PY()) {
            this.lyd.stopPlay();
        }
        if (this.lye.PY()) {
            this.lye.stopPlay();
        }
    }

    public final com.tencent.mm.plugin.music.b.a.c bhQ() {
        avq bhS = bhS();
        if (g.l(bhS)) {
            return this.lye;
        }
        if (bhS == null || !g.tB(bhS.rYj)) {
            return this.lyc;
        }
        return this.lyd;
    }

    public final synchronized void f(List<avq> list, boolean z) {
        if (list != null) {
            if (list.size() != 0) {
                if (z) {
                    this.lyb.clear();
                }
                for (avq avq : list) {
                    this.lyb.add(com.tencent.mm.plugin.music.d.a.x(avq));
                    h.bid().w(avq);
                }
            }
        }
        x.i("MicroMsg.Music.MusicPlayerManager", "appendMusicList error");
    }

    public final com.tencent.mm.an.a bhR() {
        if (this.lyb.size() <= this.lya) {
            return null;
        }
        return h.bid().IC((String) this.lyb.get(this.lya));
    }

    public final avq bhS() {
        if (this.lyb.size() <= this.lya) {
            return null;
        }
        com.tencent.mm.an.a IC = h.bid().IC((String) this.lyb.get(this.lya));
        return IC != null ? IC.PV() : null;
    }

    public final void PW() {
        this.lyc.stopPlay();
        if (this.lyd != null) {
            this.lyd.stopPlay();
        }
        if (this.lye != null) {
            this.lye.stopPlay();
        }
        ah.M(this.lyk);
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2;
        com.tencent.mm.an.a aVar;
        if (lVar instanceof com.tencent.mm.plugin.music.model.d.a) {
            x.i("MicroMsg.Music.MusicPlayerManager", "onSceneEnd errCode:%d", new Object[]{Integer.valueOf(i2)});
            com.tencent.mm.kernel.g.Eh().dpP.b(940, this);
            if (i == 4 && i2 == -24) {
                oe oeVar = ((com.tencent.mm.plugin.music.model.d.a) lVar).lza;
                if (bhR() != null && oeVar.rsp.equals(bhR().field_musicId)) {
                    PW();
                }
                com.tencent.mm.plugin.music.model.f.a bid = h.bid();
                str2 = oeVar.rsp;
                ContentValues contentValues = new ContentValues();
                contentValues.put("isBlock", Integer.valueOf(1));
                bid.diF.update("Music", contentValues, "musicId=?", new String[]{str2});
                aVar = (com.tencent.mm.an.a) bid.lzX.get(str2);
                if (aVar != null) {
                    aVar.field_isBlock = 1;
                }
                x.i("MicroMsg.Music.MusicPlayerManager", "onSceneEnd music is block %s", new Object[]{bhR().field_musicId});
            }
        } else if (lVar instanceof com.tencent.mm.plugin.music.model.d.b) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.music.model.d.b bVar = (com.tencent.mm.plugin.music.model.d.b) lVar;
                agx agx = bVar.lzb;
                String str3 = bVar.bTF.field_musicId;
                if (agx != null && str3 != null) {
                    for (String str22 : this.lyb) {
                        if (str22.equals(str3)) {
                            str3 = ab.b(agx.rKj);
                            String b = ab.b(agx.rKk);
                            String b2 = ab.b(agx.rKi);
                            com.tencent.mm.plugin.music.model.f.a bid2 = h.bid();
                            boolean z = bVar.lzc;
                            com.tencent.mm.an.a IC = bid2.IC(str22);
                            if (IC == null) {
                                x.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[]{str22});
                            } else {
                                if (!bi.oW(str3)) {
                                    IC.field_songAlbumUrl = str3;
                                }
                                IC.field_songHAlbumUrl = b;
                                IC.field_songLyric = b2;
                                bid2.c(IC, new String[]{"songAlbumUrl", "songHAlbumUrl", "songLyric"});
                                bid2.lzX.put(str22, IC);
                                bid2.e(IC, z);
                            }
                            x.i("MicroMsg.Music.MusicPlayerManager", "get response %s %s %s", new Object[]{str3, b, b2});
                            if (!bi.oW(b)) {
                                jt jtVar = new jt();
                                jtVar.bTE.action = 6;
                                jtVar.bTE.bTF = bVar.bTF;
                                com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        } else if (lVar instanceof c) {
            x.i("MicroMsg.Music.MusicPlayerManager", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            c cVar = (c) lVar;
            x.i("MicroMsg.Music.MusicPlayerManager", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[]{cVar.playUrl, cVar.lze});
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.music.model.a.b.dU(cVar.playUrl, cVar.lze);
            } else {
                h.mEJ.a(558, 214, 1, true);
            }
            aVar = bhR();
            if (aVar != null && !TextUtils.isEmpty(aVar.playUrl) && aVar.playUrl.equalsIgnoreCase(cVar.playUrl)) {
                x.i("MicroMsg.Music.MusicPlayerManager", "music playUrl is same, start to play shake music");
                d(aVar);
            } else if (aVar != null) {
                x.i("MicroMsg.Music.MusicPlayerManager", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[]{aVar.playUrl, cVar.playUrl});
            }
        }
    }

    final void Is(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Music.MusicPlayerManager", "GetShakeMusicUrl, url is null");
            return;
        }
        if (this.lyi != null) {
            com.tencent.mm.kernel.g.Eh().dpP.c(this.lyi);
            this.lyi = null;
        }
        x.e("MicroMsg.Music.MusicPlayerManager", "GetShakeMusicUrl, url is %s", new Object[]{str});
        this.lyi = new c(str);
        com.tencent.mm.kernel.g.Eh().dpP.a(this.lyi, 0);
        h.mEJ.a(558, 213, 1, true);
    }

    public final void bhT() {
        com.tencent.mm.sdk.f.e.post(new a(this, (byte) 0), "music_get_list_task");
    }

    public final void bhU() {
        if (this.mode != 1) {
            this.lya++;
            this.lya %= this.lyb.size();
            bhV();
            e(null);
        }
    }

    public final void bhV() {
        if (this.lyc.PY()) {
            this.lyc.bTH = true;
        }
        if (this.lyd.PY()) {
            this.lyd.bTH = true;
        }
        if (this.lye.PY()) {
            this.lye.bTH = true;
        }
    }

    public final boolean bhW() {
        return this.lyb.size() > 0 && this.mode == 2;
    }

    public static void bhX() {
        x.i("MicroMsg.Music.MusicPlayerManager", "sendPreemptedEvent");
        jt jtVar = new jt();
        jtVar.bTE.action = 10;
        jtVar.bTE.state = "preempted";
        jtVar.bTE.appId = "not from app brand appid";
        jtVar.bTE.bTG = true;
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
    }

    public final void bhY() {
        x.i("MicroMsg.Music.MusicPlayerManager", "stopMusicDelayIfPaused, delay_ms:%d", new Object[]{Integer.valueOf(600000)});
        ah.M(this.lyk);
        ah.i(this.lyk, 600000);
    }
}
