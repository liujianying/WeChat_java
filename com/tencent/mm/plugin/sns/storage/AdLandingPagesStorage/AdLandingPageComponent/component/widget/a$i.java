package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.media.MediaPlayer;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$i implements Runnable {
    final /* synthetic */ a nGD;
    double ncM;
    MediaPlayer ndc;
    int type;

    private a$i(a aVar) {
        this.nGD = aVar;
        this.ncM = -1.0d;
    }

    /* synthetic */ a$i(a aVar, byte b) {
        this(aVar);
    }

    private void bhP() {
        x.i("MicroMsg.SightPlayController", "stopPlayer");
        try {
            if (this.ndc != null) {
                this.ndc.stop();
                this.ndc.release();
                this.ndc = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", new Object[]{e.getMessage()});
            this.ndc = null;
        }
    }

    public final double bvR() {
        if (this.ndc == null) {
            return 0.0d;
        }
        return (double) this.ndc.getCurrentPosition();
    }

    public final void run() {
        String str;
        String str2 = "MicroMsg.SightPlayController";
        String str3 = "do play sound, operation %s";
        Object[] objArr = new Object[1];
        switch (this.type) {
            case 0:
                str = "stop";
                break;
            case 1:
                str = "start";
                break;
            case 2:
                str = "pause";
                break;
            case 3:
                str = "resume";
                break;
            case 4:
                str = "seek";
                break;
            default:
                str = "unknown";
                break;
        }
        objArr[0] = str;
        x.i(str2, str3, objArr);
        switch (this.type) {
            case 0:
                bhP();
                return;
            case 1:
                bhP();
                if (!bi.oW(a.a(this.nGD))) {
                    try {
                        this.ndc = new j();
                        this.ndc.setDisplay(null);
                        this.ndc.reset();
                        this.ndc.setDataSource(a.a(this.nGD));
                        this.ndc.setAudioStreamType(3);
                        this.ndc.setOnErrorListener(new 1(this));
                        this.ndc.prepare();
                        this.ndc.start();
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", new Object[]{e.getMessage()});
                        x.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[]{a.a(this.nGD)});
                        this.nGD.clear();
                        if (a.b(this.nGD) != null) {
                            a.b(this.nGD).wS(-1);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 2:
                try {
                    if (this.ndc != null && this.ndc.isPlaying()) {
                        this.ndc.pause();
                        return;
                    }
                    return;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", new Object[]{e2.getMessage()});
                    bhP();
                    return;
                }
            case 3:
                try {
                    if (this.ndc != null) {
                        this.ndc.start();
                        return;
                    }
                    return;
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", new Object[]{e22.getMessage()});
                    bhP();
                    return;
                }
            case 4:
                try {
                    x.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[]{Double.valueOf(this.ncM)});
                    this.ndc.seekTo((int) (this.ncM * 1000.0d));
                    return;
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", new Object[]{e222.getMessage()});
                    return;
                }
            default:
                return;
        }
    }
}
