package com.tencent.mm.plugin.music.model.c;

import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.h.q;
import com.google.android.exoplayer2.h.q.c;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.n;
import com.tencent.mm.plugin.music.model.c.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

class a$a implements a {
    final /* synthetic */ a lyY;

    private a$a(a aVar) {
        this.lyY = aVar;
    }

    /* synthetic */ a$a(a aVar, byte b) {
        this(aVar);
    }

    public final void ai(boolean z) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + z + "]");
    }

    public final void b(boolean z, int i) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "state [" + this.lyY.bij() + ", " + z + ", " + com.tencent.mm.plugin.music.b.b.a.tN(i) + "]");
        a aVar = this.lyY;
        if (aVar.lyN != null) {
            boolean iC = aVar.lyN.iC();
            int iB = aVar.lyN.iB();
            if (iC && iB == 3) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
                if (aVar.lyW != null) {
                    aVar.lyW.bil();
                }
            } else if (!iC && iB == 3 && aVar.lyM == 2) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
                if (aVar.lyW != null) {
                    aVar.lyW.bim();
                }
            } else if (!iC && iB == 3 && aVar.lyM == 3) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
                if (aVar.lyW != null) {
                    aVar.lyW.bin();
                }
            }
            int q = f.q(iC, iB);
            if (q != aVar.lyS.lyZ[3]) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + iC + "," + iB + "]");
                aVar.lyS.p(iC, iB);
                if (q == f.q(true, 4)) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
                    if (aVar.lyW != null) {
                        aVar.lyW.bip();
                        return;
                    }
                    return;
                }
                if (aVar.lyS.b(new int[]{f.q(false, 1), f.q(false, 2), f.q(false, 3)}, false)) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
                    if (aVar.lyW != null) {
                        aVar.lyW.bik();
                    }
                } else if (((aVar.lyS.b(new int[]{100, 2, 3}, true) | aVar.lyS.b(new int[]{2, 100, 3}, true)) | aVar.lyS.b(new int[]{100, 3, 2, 3}, true)) != 0) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
                    if (aVar.lyW != null) {
                        aVar.lyW.bio();
                    }
                } else {
                    if (aVar.lyS.b(new int[]{f.q(true, 3), f.q(true, 2)}, false)) {
                        x.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
                        aVar.cY(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, aVar.getDownloadPercent());
                        return;
                    }
                    if (aVar.lyS.b(new int[]{f.q(true, 2), f.q(true, 3)}, false)) {
                        x.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
                        aVar.cY(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_HTTP_LOCATION_HEADER_IS_NULL, aVar.getDownloadPercent());
                    }
                }
            }
        }
    }

    public final void a(e eVar) {
        x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "playerFailed [" + this.lyY.bij() + "]", new Object[0]);
        a aVar = this.lyY;
        if (eVar != null) {
            Throwable cause = eVar.getCause();
            if (cause == null) {
                aVar.cX(-4999, -1);
            } else if (cause instanceof c) {
                if (cause.toString().contains("Unable to connect")) {
                    boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
                    x.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + isNetworkConnected + " caused by:\n" + cause.toString());
                    if (isNetworkConnected) {
                        aVar.cX(-4000, -3);
                        return;
                    } else {
                        aVar.cX(-4000, -2);
                        return;
                    }
                } else if (cause instanceof q.e) {
                    String th = cause.toString();
                    if (th.contains("403")) {
                        aVar.cX(-4000, -10);
                    } else if (th.contains("404")) {
                        aVar.cX(-4000, -11);
                    } else if (th.contains("500")) {
                        aVar.cX(-4000, -12);
                    } else if (th.contains("502")) {
                        aVar.cX(-4000, -13);
                    } else {
                        aVar.cX(-4000, -30);
                    }
                }
            } else if (cause instanceof n) {
                aVar.cX(-4001, -1);
            } else if (cause instanceof IllegalStateException) {
                aVar.cX(-4002, -1);
            } else if (cause instanceof b.a) {
                aVar.cX(-4003, -1);
            } else {
                aVar.cX(-4999, -1);
            }
        }
        x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "ExoPlaybackException", new Object[0]);
    }

    public final void iS() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
    }

    public final void a(p pVar) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[]{Float.valueOf(pVar.aex), Float.valueOf(pVar.pitch)}));
    }
}
