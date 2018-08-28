package com.tencent.mm.plugin.music.model.e;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.an.d;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.music.d.a;
import com.tencent.mm.plugin.music.model.b.a.b;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class e extends a {
    boolean lxb;
    public boolean lyX = false;
    boolean lzA;
    public boolean lzB = false;
    public boolean lzC = false;
    public boolean lzD = false;
    public boolean lzE = false;
    public boolean lzF = false;
    public boolean lzG = false;
    public boolean lzH = false;
    public boolean lzI = false;
    public boolean lzJ = false;
    public int lzK = 0;
    private d lzL;
    public b lzM = new b() {
        public final void tE(int i) {
            if (i == 1) {
                if (e.this.lzz != null && !e.this.lxb && e.this.lzy != null) {
                    e.this.lzy.IA(a.g(e.this.lzz.bTF, e.this.lzz.iXC));
                    e eVar = e.this;
                    if (h.big().requestFocus()) {
                        x.i("MicroMsg.Music.MusicPlayer", "startPlay");
                        try {
                            if (eVar.lzy != null) {
                                eVar.lzy.play();
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "startPlay", new Object[0]);
                        }
                        eVar.lxb = true;
                        eVar.lzA = false;
                        return;
                    }
                    x.e("MicroMsg.Music.MusicPlayer", "request focus error");
                }
            } else if (i == -2 || i == 5 || i == 19) {
                ah.A(new 1(this, i));
            } else if (i == -1 || i == 6 || i == 4) {
                ah.A(new 2(this));
                e.a(e.this, h.bic().bhR(), i);
            }
        }
    };
    com.tencent.mm.plugin.music.b.a.b lzy;
    public com.tencent.mm.plugin.music.model.b.a lzz;

    static /* synthetic */ void a(e eVar, com.tencent.mm.an.a aVar, int i) {
        if (aVar == null) {
            x.e("MicroMsg.Music.MusicPlayer", "currentMusic is null, don't idKeyReportMusicError");
            return;
        }
        x.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicError, action:%d", new Object[]{Integer.valueOf(i)});
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        int i2 = aVar.field_musicType;
        x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKeyByMusicType, musicType:" + i2);
        switch (i2) {
            case 0:
                i2 = 60;
                break;
            case 1:
                i2 = 61;
                break;
            case 4:
                i2 = 62;
                break;
            case 5:
                i2 = 63;
                break;
            case 6:
                i2 = 64;
                break;
            case 7:
                i2 = 5;
                break;
            case 8:
                i2 = 65;
                break;
            case 9:
                i2 = 66;
                break;
            default:
                i2 = 6;
                break;
        }
        iDKey2.SetKey(i2);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        if (i == -1) {
            iDKey3.SetKey(12);
        } else if (i == 6) {
            iDKey3.SetKey(46);
        } else if (i == -2) {
            iDKey3.SetKey(13);
        } else if (i == 5) {
            iDKey3.SetKey(16);
        } else if (i == 4) {
            iDKey3.SetKey(14);
        } else if (i == 20) {
            iDKey3.SetKey(11);
        } else if (i == 21) {
            iDKey3.SetKey(47);
        } else if (i == 19) {
            iDKey3.SetKey(190);
        }
        iDKey3.SetValue(1);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(558);
        iDKey4.SetValue(1);
        if (i != 19 && (eVar.getMimeType() == null || !eVar.getMimeType().contains("text/html"))) {
            if (i == 21) {
                i2 = aVar.field_musicType;
                x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerPlayErrIdKeyByMusicType, musicType:" + i2);
                switch (i2) {
                    case 0:
                        i2 = 159;
                        break;
                    case 1:
                        i2 = 160;
                        break;
                    case 4:
                        i2 = 161;
                        break;
                    case 6:
                        i2 = 162;
                        break;
                    case 7:
                        i2 = 163;
                        break;
                    case 8:
                        i2 = 164;
                        break;
                    case 9:
                        i2 = 165;
                        break;
                    default:
                        i2 = 188;
                        break;
                }
                iDKey4.SetKey(i2);
                arrayList.add(iDKey4);
            } else if (i == -1 || i == 6 || i == -2 || i == 5 || i == 4) {
                i2 = aVar.field_musicType;
                x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerNetworkErrIdKeyByMusicType, musicType:" + i2);
                switch (i2) {
                    case 0:
                        i2 = 151;
                        break;
                    case 1:
                        i2 = com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX;
                        break;
                    case 4:
                        i2 = 153;
                        break;
                    case 6:
                        i2 = JsApiMakeVoIPCall.CTRL_INDEX;
                        break;
                    case 7:
                        i2 = 155;
                        break;
                    case 8:
                        i2 = 156;
                        break;
                    case 9:
                        i2 = 157;
                        break;
                    default:
                        i2 = 188;
                        break;
                }
                iDKey4.SetKey(i2);
                arrayList.add(iDKey4);
            }
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        x.i("MicroMsg.Music.MusicPlayer", "hasStatForHttpErr:%b, hasStatForUrlErr:%b, hasStatForNetworkErr:%b, hasStatForHttpRangeErr:%b, hasStatDownloadExceptionErr:%b", new Object[]{Boolean.valueOf(eVar.lzB), Boolean.valueOf(eVar.lzD), Boolean.valueOf(eVar.lzG), Boolean.valueOf(eVar.lzC), Boolean.valueOf(eVar.lzE)});
        if (i == -1 && !eVar.lzB) {
            eVar.lzB = true;
            i2 = 0;
            if (eVar.lzz != null) {
                i2 = eVar.lzz.lyH;
            }
            if (i2 == 403) {
                iDKey = new IDKey();
                iDKey.SetID(558);
                iDKey.SetValue(1);
                iDKey.SetKey(d.tH(700));
                arrayList.add(iDKey);
            }
            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0)});
        }
        if (i == 6 && !eVar.lzC) {
            eVar.lzC = true;
            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        }
        if (i == -2 && !eVar.lzD) {
            eVar.lzD = true;
            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        }
        if (i == 5 && !eVar.lzE) {
            eVar.lzE = true;
            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
            i2 = 0;
            if (eVar.lzz != null) {
                i2 = eVar.lzz.dAa;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2)});
        }
        if (i == 19 && !eVar.lzF) {
            eVar.lzF = true;
            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        }
        if (i == 4 && !eVar.lzG) {
            eVar.lzG = true;
            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        }
        if (i == 20 && !eVar.lzH) {
            eVar.lzH = true;
            if (eVar.lzy != null && (eVar.lzy instanceof c)) {
                eVar.lzK = ((c) eVar.lzy).dAa;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(iDKey3);
            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList2, true);
        }
        if (i == 21 && !eVar.lzI && eVar.lzH) {
            eVar.lzI = true;
            if (eVar.getMimeType() == null || !eVar.getMimeType().contains("text/html")) {
                Object obj;
                int i3 = eVar.lzK;
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(558);
                iDKey5.SetValue(1);
                iDKey5.SetKey(d.tH(i3));
                arrayList.add(iDKey5);
                switch (eVar.lzK) {
                    case 704:
                    case 705:
                    case 706:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    iDKey2 = new IDKey();
                    iDKey2.SetID(558);
                    iDKey2.SetValue(1);
                    i2 = aVar.field_musicType;
                    x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerDecodeErrIdKeyByMusicType, musicType:" + i2);
                    switch (i2) {
                        case 0:
                            i2 = 194;
                            break;
                        case 1:
                            i2 = 195;
                            break;
                        case 4:
                            i2 = 196;
                            break;
                        case 6:
                            i2 = 197;
                            break;
                        case 7:
                            i2 = 198;
                            break;
                        case 8:
                            i2 = 199;
                            break;
                        case 9:
                            i2 = 200;
                            break;
                        default:
                            i2 = 188;
                            break;
                    }
                    iDKey2.SetKey(i2);
                    arrayList.add(iDKey2);
                }
                i2 = i3;
            } else {
                i2 = 701;
                iDKey = new IDKey();
                iDKey.SetID(558);
                iDKey.SetValue(1);
                iDKey.SetKey(d.tH(701));
                arrayList.add(iDKey);
            }
            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0)});
        }
    }

    public e() {
        bir();
    }

    public final void b(com.tencent.mm.an.a aVar, boolean z) {
        if (this.lzy == null) {
            if (z || !com.tencent.mm.compatible.util.d.fT(15)) {
                x.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
                this.lzy = new b();
            } else {
                x.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
                this.lzy = new c();
            }
            this.lzy.o(aVar);
            this.lzy.a(new com.tencent.mm.plugin.music.b.a.e() {
                long lzN;

                public final void m(com.tencent.mm.an.a aVar) {
                    x.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
                    e.this.o(aVar.PV());
                }

                public final void n(com.tencent.mm.an.a aVar) {
                    com.tencent.mm.an.a bhR = h.bic().bhR();
                    if (bhR != null && bhR.a(aVar) && e.this.lzy != null && e.this.lzy.isPlaying()) {
                        int biu = e.this.lzy.biu();
                        int duration = e.this.lzy.getDuration();
                        if (biu > 0 && duration > 0) {
                            float f = ((float) biu) / ((float) duration);
                            if (e.this.lzz != null) {
                                float f2;
                                com.tencent.mm.plugin.music.model.b.a aVar2 = e.this.lzz;
                                aVar2.lyF = f;
                                boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
                                if (aVar2.isStop && isNetworkConnected) {
                                    if (aVar2.iXC) {
                                        if (aVar2.bTF.field_songWifiFileLength != 0) {
                                            f2 = ((float) aVar2.bTF.field_wifiDownloadedLength) / ((float) aVar2.bTF.field_songWifiFileLength);
                                        }
                                    } else if (aVar2.bTF.field_songFileLength != 0) {
                                        f2 = ((float) aVar2.bTF.field_downloadedLength) / ((float) aVar2.bTF.field_songFileLength);
                                    }
                                    if (f2 < 1.0f && f2 - f <= 0.15f && isNetworkConnected) {
                                        x.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(isNetworkConnected)});
                                        aVar2.start();
                                    }
                                }
                                if (e.this.lzz != null && e.this.lzz.isStop) {
                                    Object obj;
                                    com.tencent.mm.plugin.music.model.b.a aVar3 = e.this.lzz;
                                    if (aVar3.iXC) {
                                        if (aVar3.bTF.field_songWifiFileLength != 0) {
                                            f2 = ((float) aVar3.bTF.field_wifiDownloadedLength) / ((float) aVar3.bTF.field_songWifiFileLength);
                                        }
                                        obj = null;
                                        if (obj == null) {
                                            x.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                            e.this.stopPlay();
                                        }
                                    } else {
                                        if (aVar3.bTF.field_songFileLength != 0) {
                                            f2 = ((float) aVar3.bTF.field_downloadedLength) / ((float) aVar3.bTF.field_songFileLength);
                                        }
                                        obj = null;
                                        if (obj == null) {
                                            x.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                            e.this.stopPlay();
                                        }
                                    }
                                    if (f2 >= 1.0f) {
                                        obj = 1;
                                    } else {
                                        if (f2 - f > 0.05f) {
                                            obj = 1;
                                        }
                                        obj = null;
                                    }
                                    if (obj == null) {
                                        x.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                        e.this.stopPlay();
                                    }
                                }
                            }
                            if (e.this.lwX != null) {
                                e.this.lwX.co(biu, duration);
                            }
                        }
                    }
                }

                public final void c(com.tencent.mm.an.a aVar, boolean z) {
                    x.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
                    com.tencent.mm.an.a bhR = h.bic().bhR();
                    if (bhR != null) {
                        if (bhR.a(aVar)) {
                            e.this.stopPlay();
                        }
                        avq PV = aVar.PV();
                        e.this.r(PV);
                        if (z) {
                            e.this.u(PV);
                        }
                    }
                }

                public final void d(com.tencent.mm.an.a aVar, boolean z) {
                    com.tencent.mm.an.a bhR = h.bic().bhR();
                    if (bhR != null) {
                        x.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[]{Boolean.valueOf(z)});
                        if (z) {
                            e.a(e.this, aVar, 20);
                        } else {
                            e.a(e.this, aVar, 21);
                        }
                        avq PV = aVar.PV();
                        if (bhR.a(aVar)) {
                            x.i("MicroMsg.Music.MusicPlayer", "stop");
                            e.this.stopPlay();
                            if (z) {
                                x.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
                                e.this.b(bhR, true);
                                e.this.lzz = new com.tencent.mm.plugin.music.model.b.a(bhR);
                                e.this.lzz.lyI = e.this.lzM;
                                e.this.lzz.start();
                                return;
                            }
                            ah.A(new 1(this));
                            e.this.r(PV);
                            return;
                        }
                        x.i("MicroMsg.Music.MusicPlayer", "send stop event");
                        e.this.r(PV);
                    }
                }
            });
        }
    }

    public final void pause() {
        this.lyX = false;
        x.i("MicroMsg.Music.MusicPlayer", "pause");
        try {
            if (this.lzy != null && this.lzy.isPlaying()) {
                this.lzy.pause();
                this.lzA = true;
                q(h.bic().bhS());
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "pause", new Object[0]);
        }
    }

    public final void bhB() {
        x.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
        pause();
        h.big().bhO();
    }

    public final boolean bho() {
        return this.lxb && this.lyX;
    }

    public final void bhn() {
        this.lyX = true;
        x.i("MicroMsg.Music.MusicPlayer", "passivePause");
        try {
            if (this.lzy != null && this.lzy.isPlaying()) {
                this.lzy.pause();
                q(h.bic().bhS());
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "passivePause", new Object[0]);
        }
    }

    public final void resume() {
        try {
            if (this.lzy == null || this.lzy.isPlaying()) {
                x.i("MicroMsg.Music.MusicPlayer", "music is playing");
                return;
            }
            x.i("MicroMsg.Music.MusicPlayer", "resume");
            if (h.big().requestFocus()) {
                this.lzy.play();
                p(h.bic().bhS());
                return;
            }
            x.e("MicroMsg.Music.MusicPlayer", "request focus error");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "resume", new Object[0]);
        }
    }

    public final boolean PY() {
        boolean z = false;
        if (this.lzy == null) {
            return z;
        }
        try {
            return this.lzy.isPlaying();
        } catch (Throwable th) {
            return z;
        }
    }

    public final boolean PZ() {
        return this.lxb;
    }

    public final void stopPlay() {
        x.i("MicroMsg.Music.MusicPlayer", "stopPlay");
        if (this.lzy != null && (this.lzy instanceof c)) {
            String biv = this.lzy.biv();
            if (TextUtils.isEmpty(biv) && this.lzz != null) {
                biv = getMimeType();
            }
            x.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicMimeType mineType:%s, hasStatForMimeType:%b", new Object[]{biv, Boolean.valueOf(this.lzJ)});
            if (!(TextUtils.isEmpty(biv) || this.lzJ)) {
                x.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicMimeType OK");
                this.lzJ = true;
                IDKey iDKey = new IDKey();
                iDKey.SetID(558);
                int i = "audio/3gpp".equalsIgnoreCase(biv) ? 70 : "audio/amr-wb".equalsIgnoreCase(biv) ? 71 : ("audio/mpeg".equalsIgnoreCase(biv) || biv.equalsIgnoreCase("audio/mp3")) ? 72 : ("audio/mp4a-latm".equalsIgnoreCase(biv) || biv.startsWith("audio/mp4")) ? 73 : "audio/qcelp".equalsIgnoreCase(biv) ? 74 : "audio/vorbis".equalsIgnoreCase(biv) ? 75 : "audio/opus".equalsIgnoreCase(biv) ? 76 : "audio/g711-alaw".equalsIgnoreCase(biv) ? 77 : "audio/g711-mlaw".equalsIgnoreCase(biv) ? 78 : "audio/raw".equalsIgnoreCase(biv) ? 79 : "audio/flac".equalsIgnoreCase(biv) ? 80 : "audio/gsm".equalsIgnoreCase(biv) ? 81 : "audio/ac3".equalsIgnoreCase(biv) ? 82 : "audio/eac3".equalsIgnoreCase(biv) ? 83 : "audio/x-ms-wma".equalsIgnoreCase(biv) ? 84 : "audio/x-wav".equalsIgnoreCase(biv) ? 85 : ("audio/x-ape".equalsIgnoreCase(biv) || "application/x-ape".equalsIgnoreCase(biv)) ? 86 : 87;
                iDKey.SetKey(i);
                iDKey.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
                if (h.bic().bhR() != null) {
                    int IB = d.IB(biv);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14486, new Object[]{Integer.valueOf(0), Integer.valueOf(r1.field_musicType), Integer.valueOf(IB), biv});
                }
            }
        }
        try {
            if (this.lzz != null) {
                this.lzz.isStop = true;
                this.lzz = null;
            }
            if (this.lzy != null) {
                this.lzy.stop();
                this.lzy = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "stopPlay", new Object[0]);
        }
        h.big().bhO();
        this.lxb = false;
        this.lyX = false;
    }

    public final int getDuration() {
        if (this.lzy != null) {
            return this.lzy.getDuration();
        }
        return -1;
    }

    private int getDownloadPercent() {
        if (this.lzz == null) {
            return 0;
        }
        int i;
        com.tencent.mm.plugin.music.model.b.a aVar = this.lzz;
        if (aVar.iXC) {
            x.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[]{Long.valueOf(aVar.bTF.field_songWifiFileLength), Long.valueOf(aVar.bTF.field_wifiDownloadedLength)});
            i = aVar.bTF.field_songWifiFileLength != 0 ? (int) ((aVar.bTF.field_wifiDownloadedLength * 100) / aVar.bTF.field_songWifiFileLength) : 0;
        } else {
            x.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[]{Long.valueOf(aVar.bTF.field_songFileLength), Long.valueOf(aVar.bTF.field_downloadedLength)});
            i = aVar.bTF.field_songFileLength != 0 ? (int) ((aVar.bTF.field_downloadedLength * 100) / aVar.bTF.field_songFileLength) : 0;
        }
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public final boolean if(int i) {
        x.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[]{Integer.valueOf(i)});
        try {
            int duration = getDuration();
            int downloadPercent = getDownloadPercent();
            if (duration < 0 || i > duration) {
                x.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
                stopPlay();
                return false;
            }
            duration = (int) ((((double) downloadPercent) / 100.0d) * ((double) duration));
            if (downloadPercent != 100 && i > duration) {
                i = duration - 2000;
                x.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[]{Integer.valueOf(i)});
            }
            if (this.lzy != null && i >= 0) {
                this.lzy.seek((long) i);
                s(h.bic().bhS());
                return true;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "seekTo", new Object[0]);
        }
    }

    public final d bhq() {
        int i;
        int duration = getDuration();
        int biu = this.lzy != null ? this.lzy.biu() : -1;
        if (PY()) {
            i = 1;
        } else {
            if (this.lxb && (this.lzA || this.lwW)) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = 2;
            }
        }
        x.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[]{Integer.valueOf(i)});
        int downloadPercent = getDownloadPercent();
        if (duration <= 0) {
            downloadPercent = 0;
        }
        if (this.lzL != null) {
            this.lzL.j(duration, biu, i, downloadPercent);
        } else {
            this.lzL = new d(duration, biu, i, downloadPercent);
        }
        this.lzL.bTG = false;
        this.lzL.ebh = this.lzq;
        return this.lzL;
    }

    public final boolean bhp() {
        return false;
    }

    private String getMimeType() {
        String str = "";
        if (this.lzz != null) {
            str = this.lzz.mimeType;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        com.tencent.mm.an.a bhR = h.bic().bhR();
        if (bhR != null) {
            return bhR.field_mimetype;
        }
        return str;
    }
}
