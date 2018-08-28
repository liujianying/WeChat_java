package com.tencent.mm.booter.notification.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.IOException;
import java.nio.charset.Charset;

public final class f {
    boolean cZi;
    MediaPlayer cZj;
    @SuppressLint({"HandlerLeak"})
    ag cZk;
    private ag cZl;
    Context context;

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        String str = null;
        this.cZi = false;
        this.cZj = null;
        this.cZk = new ag(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                x.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", new Object[]{Boolean.valueOf(f.this.cZi)});
                try {
                    if (f.this.cZj != null) {
                        if (f.this.cZj.isPlaying()) {
                            f.this.cZj.stop();
                        }
                        f.this.cZj.release();
                        f.this.cZi = false;
                        x.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", new Object[]{Boolean.valueOf(f.this.cZi)});
                    }
                } catch (IllegalStateException e) {
                    x.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", new Object[]{Boolean.valueOf(f.this.cZi)});
                    if (f.this.cZj != null) {
                        f.this.cZj.release();
                    }
                }
            }
        };
        this.context = ad.getContext();
        String str2 = aa.duN + "deviceconfig.cfg";
        x.i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", new Object[]{str2, Boolean.valueOf(e.cn(str2))});
        if (e.cn(str2)) {
            byte[] f = e.f(str2, 0, -1);
            if (!bi.bC(f)) {
                str2 = new String(f, Charset.defaultCharset());
                if (!bi.oW(str2)) {
                    str = str2;
                }
            }
        }
        q.fd(str);
    }

    public final synchronized void eQ(final String str) {
        if (this.cZl == null) {
            x.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
            HandlerThread cZ = com.tencent.mm.sdk.f.e.cZ("playSoundThread", 0);
            cZ.start();
            this.cZl = new ag(cZ.getLooper());
        }
        this.cZl.post(new Runnable() {
            final /* synthetic */ boolean cZo = false;

            public final void run() {
                f fVar = f.this;
                String str = str;
                boolean z = this.cZo;
                if (fVar.context == null) {
                    fVar.context = ad.getContext();
                }
                if (fVar.context == null) {
                    x.w("MicroMsg.Notification.Tool.Sound", "playSound:context is null!!");
                    return;
                }
                try {
                    AudioManager audioManager = (AudioManager) fVar.context.getSystemService("audio");
                    if (audioManager.getStreamVolume(5) != 0) {
                        Uri defaultUri;
                        fVar.cZk.removeMessages(305419896);
                        fVar.cZk.sendEmptyMessageDelayed(305419896, 8000);
                        x.i("MicroMsg.Notification.Tool.Sound", "doPlaySound playerIsInit: %s", new Object[]{Boolean.valueOf(fVar.cZi)});
                        if (fVar.cZi) {
                            try {
                                if (fVar.cZj != null) {
                                    if (fVar.cZj.isPlaying()) {
                                        fVar.cZj.stop();
                                    }
                                    fVar.cZj.release();
                                    x.i("MicroMsg.Notification.Tool.Sound", "try to release player before playSound playerIsInit: %s", new Object[]{Boolean.valueOf(fVar.cZi)});
                                }
                            } catch (IllegalStateException e) {
                                x.w("MicroMsg.Notification.Tool.Sound", "try to release player before playSound error");
                                if (fVar.cZj != null) {
                                    fVar.cZj.release();
                                }
                            }
                            fVar.cZi = false;
                        }
                        fVar.cZj = new j();
                        x.i("MicroMsg.Notification.Tool.Sound", "doPlaySound player: %s", new Object[]{fVar.cZj});
                        MediaPlayer mediaPlayer = fVar.cZj;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (bi.oW(str)) {
                            defaultUri = RingtoneManager.getDefaultUri(2);
                        } else if (z) {
                            AssetFileDescriptor openFd = fVar.context.getAssets().openFd(str);
                            mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                            openFd.close();
                            defaultUri = null;
                        } else {
                            defaultUri = Uri.parse(str);
                        }
                        if (defaultUri != null) {
                            try {
                                mediaPlayer.setDataSource(fVar.context, defaultUri);
                            } catch (IOException e2) {
                                if (bi.oW(str)) {
                                    x.i("MicroMsg.Notification.Tool.Sound", "setPlayerDataSource IOException soundUri:%s, isAsset:%s", new Object[]{str, Boolean.valueOf(z)});
                                } else {
                                    mediaPlayer.setDataSource(fVar.context, RingtoneManager.getDefaultUri(2));
                                }
                            }
                        }
                        x.i("MicroMsg.Notification.Tool.Sound", "summeranrt setPlayerDataSource tid[%d] [%d]ms", new Object[]{Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (audioManager.isWiredHeadsetOn()) {
                            com.tencent.mm.compatible.b.f.yG();
                            x.d("MicroMsg.Notification.Tool.Sound", "headset on, selected stream type: %s", new Object[]{Integer.valueOf(0)});
                            float streamVolume = (float) audioManager.getStreamVolume(0);
                            float streamMaxVolume = (float) audioManager.getStreamMaxVolume(0);
                            float streamVolume2 = ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
                            x.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s, maxVolume: %s, toneScale: %s", new Object[]{Float.valueOf(streamVolume), Float.valueOf(streamMaxVolume), Float.valueOf(streamVolume / streamMaxVolume)});
                            x.d("MicroMsg.Notification.Tool.Sound", "headset on, toneMUSICVolume: %s, maxMUSICVolume: %s, toneMusicScale: %s", new Object[]{Float.valueOf(r3), Float.valueOf(r5), Float.valueOf(streamVolume2)});
                            if (streamVolume / streamMaxVolume > streamVolume2) {
                                streamVolume = streamMaxVolume * streamVolume2;
                                x.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s", new Object[]{Float.valueOf(streamVolume)});
                            }
                            audioManager.setSpeakerphoneOn(false);
                            x.i("MicroMsg.Notification.Tool.Sound", "notificationSetMode: %s", new Object[]{Integer.valueOf(q.deW.des)});
                            if (q.deW.des == 1) {
                                x.i("MicroMsg.Notification.Tool.Sound", "notification set mode enable, set mode now");
                                if (audioManager.getMode() == 0) {
                                    audioManager.setMode(3);
                                }
                                fVar.cZj.setOnCompletionListener(new 3(fVar, audioManager));
                                fVar.cZj.setOnErrorListener(new 4(fVar, audioManager));
                            } else {
                                fVar.cZj.setOnCompletionListener(new 5(fVar));
                                fVar.cZj.setOnErrorListener(new 6(fVar));
                            }
                            fVar.cZj.setAudioStreamType(0);
                            fVar.cZj.setLooping(true);
                            fVar.cZj.prepare();
                            fVar.cZj.setVolume(streamVolume / streamMaxVolume, streamVolume / streamMaxVolume);
                            fVar.cZj.setLooping(false);
                            fVar.cZj.start();
                            fVar.cZi = true;
                            return;
                        }
                        x.d("MicroMsg.Notification.Tool.Sound", "getStreamVolume =  %d, soundUri = %s", new Object[]{Integer.valueOf(audioManager.getStreamVolume(5)), str});
                        fVar.cZj.setOnCompletionListener(new 7(fVar));
                        fVar.cZj.setOnErrorListener(new 8(fVar));
                        fVar.cZj.setAudioStreamType(5);
                        fVar.cZj.setLooping(true);
                        fVar.cZj.prepare();
                        fVar.cZj.setLooping(false);
                        fVar.cZj.start();
                        fVar.cZi = true;
                        String str2 = "MicroMsg.Notification.Tool.Sound";
                        String str3 = "doPlaySound start finish playerIsInit:%s, myLooper[%b] mainLooper[%b]";
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(fVar.cZi);
                        objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                        objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                        x.i(str2, str3, objArr);
                    }
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e3, "PlaySound Exception:", new Object[0]);
                    try {
                        if (fVar.cZj != null) {
                            fVar.cZj.release();
                        }
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e32, "try to release player in Exception:", new Object[0]);
                    }
                }
            }
        });
    }
}
