package com.tencent.mm.plugin.music.model.e;

import android.widget.Toast;
import com.tencent.mm.an.a;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;

class g$1 implements PlayerListenerCallback {
    a lzU = null;
    final /* synthetic */ g lzV;

    g$1(g gVar) {
        this.lzV = gVar;
    }

    public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
    }

    public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
        x.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
    }

    public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer) {
        x.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete");
        if (this.lzV.dGs != 0) {
            x.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[]{Integer.valueOf(this.lzV.dGs)});
            this.lzV.dGs = 0;
            biy();
            return;
        }
        x.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
        if (this.lzU == null) {
            x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            return;
        }
        avq PV = this.lzU.PV();
        this.lzV.s(PV);
        if (this.lzV.PY()) {
            x.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
            this.lzV.p(PV);
        }
    }

    public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
        x.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a bhR = h.bic().bhR();
        if (bhR == null) {
            x.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
            return;
        }
        this.lzU = this.lzV.bTF;
        if (this.lzU == null) {
            x.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
            return;
        }
        boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
        if (i2 == 80 && isNetworkConnected) {
            x.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
        }
        if (this.lzV.aBN > 0) {
            x.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[]{Integer.valueOf(this.lzV.aBN)});
            return;
        }
        g gVar = this.lzV;
        gVar.aBN++;
        g.a(this.lzV, this.lzU, i2);
        avq PV = this.lzU.PV();
        if (bhR.a(this.lzU)) {
            this.lzV.stopPlay();
            ah.A(new Runnable() {
                public final void run() {
                    Toast.makeText(ad.getContext(), ad.getContext().getString(e.music_file_wrong), 0).show();
                }
            });
        }
        this.lzV.r(PV);
        this.lzV.a(PV, i2);
        if (this.lzV.lzT != null) {
            this.lzV.lzT.isStop = true;
            this.lzV.lzT = null;
        }
        if (i == 91 && i2 == 55) {
            x.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
            com.tencent.mm.plugin.music.cache.e.deleteFile(this.lzV.lxf);
        }
    }

    public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
        x.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
    }

    public final void onStateChanged(int i) {
        x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", new Object[]{Integer.valueOf(i)});
        if (i == 3) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
            x.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
            this.lzU = this.lzV.bTF;
            if (this.lzU == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                return;
            }
            this.lzV.m(this.lzU.PV());
        } else if (i == 2) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
            biy();
        } else if (i == 4) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
            x.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
            this.lzU = this.lzV.bTF;
            if (this.lzU == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                return;
            }
            this.lzV.o(this.lzU.PV());
            if (this.lzV.lzT != null) {
                this.lzV.lzT.isStop = true;
            }
            this.lzV.lzT = new g.a(this.lzV, (byte) 0);
            g.a aVar = this.lzV.lzT;
            aVar.isStop = false;
            com.tencent.mm.sdk.f.e.post(aVar, "music_play_progress_runnable");
        } else if (i == 5) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
            x.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
            if (this.lzU == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                return;
            }
            this.lzV.q(this.lzU.PV());
        } else if (i == 6) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
            x.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
            if (this.lzU == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            } else if (h.bic().bhR() == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
            } else if (this.lzV.bTF.a(this.lzU)) {
                this.lzV.r(this.lzV.bTF.PV());
            }
        } else if (i == 7) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
            x.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
            if (this.lzU == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                return;
            }
            this.lzV.lxb = false;
            this.lzV.u(this.lzU.PV());
            if (this.lzV.lzT != null) {
                this.lzV.lzT.isStop = true;
                this.lzV.lzT = null;
            }
        } else if (i == 8) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
            x.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
        } else if (i == 9) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
        }
    }

    public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
        x.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
    }

    private void biy() {
        x.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
        if (this.lzV.dGs != 0) {
            x.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[]{Integer.valueOf(this.lzV.dGs)});
            this.lzV.if(this.lzV.dGs);
            return;
        }
        x.i("MicroMsg.Music.QQMusicPlayer", "start to play");
        if (!h.big().requestFocus()) {
            x.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
        } else if (this.lzV.bTF == null) {
            x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        } else {
            this.lzV.n(this.lzV.bTF.PV());
            try {
                if (this.lzV.lwZ != null) {
                    this.lzV.lwZ.start();
                    if (!(this.lzV.lwZ.getCurrentAudioInformation() == null || this.lzV.lwZ.getCurrentAudioInformation().getAudioType() == null)) {
                        x.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[]{Integer.valueOf(this.lzV.lwZ.getCurrentAudioInformation().getAudioType().getValue())});
                        this.lzV.audioType = this.lzV.lwZ.getCurrentAudioInformation().getAudioType();
                        g.a(this.lzV);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "_onPrepared", new Object[0]);
                this.lzV.a(this.lzV.bTF.PV(), 502);
                g.a(this.lzV, this.lzV.bTF, 502);
            }
            this.lzV.lxb = true;
        }
    }
}
