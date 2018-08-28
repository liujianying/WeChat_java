package com.tencent.mm.plugin.music.a;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.g.a.t;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.plugin.music.cache.ipc.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.a;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.util.ArrayList;

class f$1 implements PlayerListenerCallback {
    a lxl = null;
    final /* synthetic */ f lxm;

    f$1(f fVar) {
        this.lxm = fVar;
    }

    static /* synthetic */ void a(f$1 f_1) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "_onPrepared");
        f_1.lxl = f_1.lxm.bGY;
        if (f_1.lxm.dGA || f_1.lxm.lxc) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
            if (f_1.lxm.lwZ != null) {
                f_1.lxm.lwZ.stop();
            }
            if (f_1.lxm.lxc) {
                f_1.lxm.bhv();
            }
        } else if (f_1.lxm.dGs != 0) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "seek to startTime:%d", new Object[]{Integer.valueOf(f_1.lxm.dGs)});
            f_1.lxm.if(f_1.lxm.dGs);
        } else {
            if (!(f_1.lxm.lwZ == null || f_1.lxm.lwZ.getCurrentAudioInformation() == null || f_1.lxm.lwZ.getCurrentAudioInformation().getAudioType() == null)) {
                f_1.lxm.audioType = f_1.lxm.lwZ.getCurrentAudioInformation().getAudioType();
                if (f_1.lxm.audioType != null) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "getAudioType:%d", new Object[]{Integer.valueOf(f_1.lxm.audioType.getValue())});
                }
                f fVar = f_1.lxm;
                if (fVar.audioType != null) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType audioType:%d, isStatMineType:%b", new Object[]{Integer.valueOf(fVar.audioType.getValue()), Boolean.valueOf(fVar.lxi)});
                    if (!fVar.lxi) {
                        x.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType OK");
                        fVar.lxi = true;
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(688);
                        int value = fVar.audioType.getValue();
                        value = value == 2 ? 42 : value == 3 ? 43 : value == 4 ? 44 : value == 5 ? 45 : value == 6 ? 46 : value == 7 ? 47 : value == 8 ? 48 : value == 9 ? 49 : 50;
                        iDKey.SetKey(value);
                        iDKey.SetValue(1);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(iDKey);
                        h.mEJ.b(arrayList, true);
                    }
                }
            }
            f_1.lxm.bhs();
            if (f_1.lxm.lxg) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "start to play");
                try {
                    if (f_1.lxm.lwZ != null) {
                        f_1.lxm.lwZ.setVolume((float) f_1.lxm.bGY.dGx, (float) f_1.lxm.bGY.dGx);
                        f_1.lxm.lwZ.start();
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "_onPrepared", new Object[0]);
                    f_1.lxm.tp(502);
                    f.a(f_1.lxm, 502);
                }
                f_1.lxm.lxb = true;
                return;
            }
            x.i("MicroMsg.Audio.QQAudioPlayer", "autoplay is false, don't start auto play!");
        }
    }

    static /* synthetic */ void b(f$1 f_1) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "_onPreparing");
        f_1.lxl = f_1.lxm.bGY;
        if (f_1.lxl == null) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "cbMusic is null");
        } else if (f_1.lxm.dGA || f_1.lxm.lxc) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
        } else {
            f fVar = f_1.lxm;
            x.i("MicroMsg.Audio.BaseAudioPlayer", "onPreparintEvent");
            t tVar = new t();
            tVar.bHb.action = 9;
            tVar.bHb.state = "waiting";
            tVar.bHb.bGW = fVar.bhr();
            tVar.bHb.appId = fVar.getAppId();
            com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
        }
    }

    static /* synthetic */ void c(f$1 f_1) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "_onStart");
        f_1.lxl = f_1.lxm.bGY;
        if (f_1.lxm.dGA || f_1.lxm.lxc) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
            if (f_1.lxm.lwZ != null && f_1.lxm.lxb) {
                f_1.lxm.lxb = false;
                f_1.lxm.lwZ.stop();
                return;
            }
            return;
        }
        f_1.lxm.bht();
        if (f_1.lxm.lxd != null) {
            f_1.lxm.lxd.isStop = true;
        }
        f_1.lxm.lxd = new f.a(f_1.lxm, (byte) 0);
        f_1.lxm.lxd.isStop = false;
    }

    static /* synthetic */ void d(f$1 f_1) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "_onPause");
        f_1.lxm.bhv();
    }

    static /* synthetic */ void e(f$1 f_1) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "_onStop");
        if (f_1.lxl == null) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "currentMusic is null");
            return;
        }
        f_1.lxm.lxb = false;
        f_1.lxm.dkh = System.currentTimeMillis();
        if (!f_1.lxm.bGW.equalsIgnoreCase(f_1.lxl.bGW)) {
            return;
        }
        if (f_1.lxm.dGA) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
            f_1.lxm.bhv();
            return;
        }
        f_1.lxm.bhw();
    }

    static /* synthetic */ void f(f$1 f_1) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "_onCompletion");
        if (!f_1.lxm.bGY.dGv) {
            f_1.lxm.bhy();
        }
        if (f_1.lxm.lxd != null) {
            f_1.lxm.lxd.isStop = true;
            f_1.lxm.lxd = null;
        }
        f_1.lxm.dkh = System.currentTimeMillis();
        x.i("MicroMsg.Audio.QQAudioPlayer", "play end, isPausedOnBackground:%b, playParam.loop:%b, isStartPlaying:%b, ", new Object[]{Boolean.valueOf(f_1.lxm.dGA), Boolean.valueOf(f_1.lxm.bGY.dGv), Boolean.valueOf(f_1.lxm.lxb)});
        if (f_1.lxm.dGA) {
            f_1.lxm.lxb = false;
            f_1.lxm.dGs = 0;
            f_1.lxm.lxg = true;
            x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground is true, do stop player and don't play again");
        } else if (f_1.lxm.lxc) {
            f_1.lxm.lxb = false;
            f_1.lxm.dGs = 0;
            f_1.lxm.lxg = true;
            x.i("MicroMsg.Audio.QQAudioPlayer", "isForcePause is true, do stop player and don't play again");
        } else if (f_1.lxm.bGY.dGv && f_1.lxm.lxb) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "play end normally and loop play again");
            f_1.lxm.lxb = false;
            f_1.lxm.dGs = 0;
            f_1.lxm.lxg = true;
            f.a(f_1.lxm);
        } else {
            x.i("MicroMsg.Audio.QQAudioPlayer", "play end, but not loop play");
            f_1.lxm.lxb = false;
            f_1.lxm.dGs = 0;
            f_1.lxm.lxg = true;
        }
    }

    public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
    }

    public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
    }

    public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer) {
        this.lxm.giD.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete");
                if (f$1.this.lxm.dGs != 0) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[]{Integer.valueOf(f$1.this.lxm.dGs)});
                    f$1.this.lxm.dGs = 0;
                    f$1.a(f$1.this);
                    return;
                }
                f$1 f_1 = f$1.this;
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
                f_1.lxm.bhx();
                if (f_1.lxm.PY()) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
                    f_1.lxm.bhu();
                }
            }
        });
    }

    public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
        x.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), this.lxm.bGW});
        if (this.lxl == null) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
            return;
        }
        boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
        if (i2 == 80 && isNetworkConnected) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
        }
        if (this.lxm.aBN > 0) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[]{Integer.valueOf(this.lxm.aBN)});
            return;
        }
        this.lxm.lxb = false;
        f fVar = this.lxm;
        fVar.aBN++;
        this.lxm.isA = i2;
        this.lxm.dkh = System.currentTimeMillis();
        f.a(this.lxm, i2);
        if (this.lxm.bGW.equalsIgnoreCase(this.lxl.bGW)) {
            this.lxm.stopPlay();
            ah.A(new Runnable() {
                public final void run() {
                    IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", null, f.class);
                    if (iPCBoolean == null ? false : iPCBoolean.value) {
                        Toast.makeText(ad.getContext(), ad.getContext().getString(e.music_file_wrong), 0).show();
                    }
                }
            });
        }
        this.lxm.tp(i2);
        if (this.lxm.lxd != null) {
            this.lxm.lxd.isStop = true;
            this.lxm.lxd = null;
        }
        if (i == 91 && i2 == 55) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
            com.tencent.mm.plugin.music.cache.e.deleteFile(this.lxm.lxf);
        }
    }

    public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
    }

    public final void onStateChanged(final int i) {
        this.lxm.giD.post(new Runnable() {
            public final void run() {
                String str = f$1.this.lxm.bGW;
                x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[]{Integer.valueOf(i), str});
                if (i == 3) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
                    f$1.b(f$1.this);
                    f$1.this.lxm.lxj = System.currentTimeMillis();
                } else if (i == 2) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
                    x.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - f$1.this.lxm.lxj)});
                    f$1.a(f$1.this);
                } else if (i == 4) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
                    x.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - f$1.this.lxm.lxj)});
                    f$1.c(f$1.this);
                } else if (i == 5) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
                    f$1.d(f$1.this);
                } else if (i == 6) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
                    f$1.e(f$1.this);
                } else if (i == 7) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                    f$1.f(f$1.this);
                } else if (i == 8) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
                    x.i("MicroMsg.Audio.QQAudioPlayer", "_onEnd");
                } else if (i == 9) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
                }
            }
        });
    }

    public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
    }
}
