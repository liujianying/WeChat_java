package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Looper;
import android.os.Vibrator;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.k.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    public boolean bwu = false;
    private AudioManager dge;
    ag dvh = new ag(Looper.getMainLooper());
    private b epT;
    private Vibrator hXL;
    public Context mContext;
    public MediaPlayer oVd;
    public int oVe = GLIcon.RIGHT;
    public long oVf;
    public long oVg;
    a oVh;

    public i(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.dge = au.HV().daT;
            if (this.dge == null) {
                this.dge = (AudioManager) this.mContext.getSystemService("audio");
            }
            this.hXL = (Vibrator) this.mContext.getSystemService("vibrator");
        }
        this.epT = new b(ad.getContext());
    }

    public final void iX(boolean z) {
        int i = 0;
        x.i("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            if (d.fR(21)) {
                i = 3;
            } else {
                i = 2;
            }
        }
        if (z && q.deN.dch >= 0) {
            i = q.deN.dch;
        } else if (!z && q.deN.dcf >= 0) {
            i = q.deN.dcf;
        }
        if (i != this.dge.getMode()) {
            this.dge.setMode(i);
        }
        if (z != this.dge.isSpeakerphoneOn()) {
            this.dge.setSpeakerphoneOn(z);
        }
    }

    public final void iY(boolean z) {
        if (!this.bwu) {
            x.i("MicroMsg.RingPlayer", "now we start play ");
            try {
                this.oVd = j.c(this.mContext, RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1));
                if (this.oVd != null) {
                    this.oVd.stop();
                    this.oVd.prepare();
                    this.oVd.setLooping(true);
                    iX(true);
                    if (z) {
                        this.oVd.setVolume(0.6f, 0.6f);
                    } else {
                        bMj();
                    }
                    switch (this.dge.getRingerMode()) {
                        case 2:
                            if (this.oVd != null) {
                                this.oVd.start();
                                break;
                            }
                            break;
                    }
                    this.bwu = true;
                }
            } catch (Exception e) {
                x.e("ex", e.getMessage());
            }
        }
    }

    public final void stop() {
        x.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[]{Boolean.valueOf(this.bwu)});
        if (this.hXL != null) {
            this.hXL.cancel();
            this.hXL = null;
        }
        if (this.oVd != null && this.bwu) {
            try {
                this.oVd.stop();
                this.oVd.release();
                if (this.oVh != null) {
                    this.dvh.removeCallbacks(this.oVh);
                }
                this.bwu = false;
                au.HV().setMode(0);
            } catch (Exception e) {
                x.e("MicroMsg.RingPlayer", e.toString());
            }
        }
    }

    public final boolean alf() {
        return !this.bwu;
    }

    public final void m(int i, int i2, boolean z) {
        boolean booleanValue;
        Exception e;
        boolean Ao;
        if (i2 == 0) {
            try {
                au.HU();
                booleanValue = ((Boolean) c.DT().get(73217, Boolean.valueOf(true))).booleanValue();
            } catch (Exception e2) {
                e = e2;
                booleanValue = true;
            }
        } else if (i2 == 1 || i2 == 2) {
            au.HU();
            booleanValue = ((Boolean) c.DT().get(73218, Boolean.valueOf(true))).booleanValue();
        } else {
            booleanValue = true;
        }
        try {
            boolean Am = a.Am();
            Ao = a.Ao();
            x.i("MicroMsg.RingPlayer", "startPlayCustomRing, voipSound: %s, msgSound: %s, msgShake: %s, isCallingParty: %s", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(Am), Boolean.valueOf(Ao), Boolean.valueOf(z)});
            if (z) {
                Am = true;
            }
            booleanValue = Am;
        } catch (Exception e3) {
            e = e3;
            x.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
            Ao = true;
            if (!!booleanValue) {
            }
            if (booleanValue) {
                try {
                    this.oVf = System.currentTimeMillis();
                    this.oVd = new j();
                    try {
                        int yQ;
                        int i3;
                        this.oVd.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                        this.oVd.setOnCompletionListener(new 1(this));
                        this.oVd.setOnErrorListener(new 2(this));
                        booleanValue = au.HV().yE();
                        boolean yK = au.HV().yK();
                        x.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(yK)});
                        if (booleanValue) {
                            yQ = au.HV().yQ();
                            iX(false);
                            i3 = yQ;
                        } else if (z || yK) {
                            if (q.deN.dce >= 0) {
                                yQ = q.deN.dce;
                            } else {
                                yQ = 0;
                            }
                            if (yK || i2 == 1) {
                                iX(false);
                                i3 = yQ;
                            } else {
                                if (q.deN.dcb >= 0) {
                                    yQ = q.deN.dcb;
                                } else {
                                    yQ = 3;
                                }
                                iX(true);
                                i3 = yQ;
                            }
                        } else {
                            if (au.HV().yE() || q.deN.dcg < 0) {
                                yQ = 2;
                            } else {
                                yQ = q.deN.dcg;
                            }
                            iX(true);
                            i3 = yQ;
                        }
                        this.oVd.setAudioStreamType(i3);
                        if (yK || booleanValue) {
                            int streamMaxVolume = this.dge.getStreamMaxVolume(i3);
                            yQ = this.dge.getStreamVolume(i3);
                            if (yQ > streamMaxVolume / 2) {
                                yQ = streamMaxVolume / 2;
                            }
                            this.dge.setStreamVolume(i3, yQ, 0);
                        } else if (z) {
                            this.oVd.setVolume(0.6f, 0.6f);
                        } else if (Ao) {
                            bMj();
                        }
                        this.oVd.setLooping(true);
                        this.oVd.prepare();
                        this.oVd.start();
                        if (System.currentTimeMillis() - this.oVf > 2000) {
                            this.oVe = 3;
                        }
                    } catch (Throwable th) {
                        x.e("MicroMsg.RingPlayer", "startPlayCustomRing failed, " + th.getMessage());
                        this.oVe = 2;
                        try {
                            this.oVd = j.c(this.mContext, RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1));
                            if (this.oVd != null) {
                                this.oVd.stop();
                                this.oVd.prepare();
                                this.oVd.setLooping(true);
                                if (z) {
                                    this.oVd.setVolume(0.6f, 0.6f);
                                } else if (Ao) {
                                    bMj();
                                }
                                this.oVd.start();
                                this.oVe = 0;
                            } else {
                                return;
                            }
                        } catch (Exception e4) {
                            x.e("ex", e4.getMessage());
                            this.oVe = 2;
                        }
                    }
                    this.bwu = true;
                } catch (Exception e42) {
                    x.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e42.toString());
                }
            } else if (Ao && !z) {
                bMj();
            }
        }
        if ((!booleanValue && !Ao) || this.bwu) {
            return;
        }
        if (booleanValue) {
            try {
                this.oVf = System.currentTimeMillis();
                this.oVd = new j();
                try {
                    int yQ2;
                    int i32;
                    this.oVd.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                    this.oVd.setOnCompletionListener(new 1(this));
                    this.oVd.setOnErrorListener(new 2(this));
                    booleanValue = au.HV().yE();
                    boolean yK2 = au.HV().yK();
                    x.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(yK2)});
                    if (booleanValue) {
                        yQ2 = au.HV().yQ();
                        iX(false);
                        i32 = yQ2;
                    } else if (z || yK2) {
                        if (q.deN.dce >= 0) {
                            yQ2 = q.deN.dce;
                        } else {
                            yQ2 = 0;
                        }
                        if (yK2 || i2 == 1) {
                            iX(false);
                            i32 = yQ2;
                        } else {
                            if (q.deN.dcb >= 0) {
                                yQ2 = q.deN.dcb;
                            } else {
                                yQ2 = 3;
                            }
                            iX(true);
                            i32 = yQ2;
                        }
                    } else {
                        if (au.HV().yE() || q.deN.dcg < 0) {
                            yQ2 = 2;
                        } else {
                            yQ2 = q.deN.dcg;
                        }
                        iX(true);
                        i32 = yQ2;
                    }
                    this.oVd.setAudioStreamType(i32);
                    if (yK2 || booleanValue) {
                        int streamMaxVolume2 = this.dge.getStreamMaxVolume(i32);
                        yQ2 = this.dge.getStreamVolume(i32);
                        if (yQ2 > streamMaxVolume2 / 2) {
                            yQ2 = streamMaxVolume2 / 2;
                        }
                        this.dge.setStreamVolume(i32, yQ2, 0);
                    } else if (z) {
                        this.oVd.setVolume(0.6f, 0.6f);
                    } else if (Ao) {
                        bMj();
                    }
                    this.oVd.setLooping(true);
                    this.oVd.prepare();
                    this.oVd.start();
                    if (System.currentTimeMillis() - this.oVf > 2000) {
                        this.oVe = 3;
                    }
                } catch (Throwable th2) {
                    x.e("MicroMsg.RingPlayer", "startPlayCustomRing failed, " + th2.getMessage());
                    this.oVe = 2;
                    try {
                        this.oVd = j.c(this.mContext, RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1));
                        if (this.oVd != null) {
                            this.oVd.stop();
                            this.oVd.prepare();
                            this.oVd.setLooping(true);
                            if (z) {
                                this.oVd.setVolume(0.6f, 0.6f);
                            } else if (Ao) {
                                bMj();
                            }
                            this.oVd.start();
                            this.oVe = 0;
                        } else {
                            return;
                        }
                    } catch (Exception e422) {
                        x.e("ex", e422.getMessage());
                        this.oVe = 2;
                    }
                }
                this.bwu = true;
            } catch (Exception e4222) {
                x.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e4222.toString());
            }
        } else if (Ao && !z) {
            bMj();
        }
    }

    public final void a(int i, long j, boolean z, int i2) {
        this.oVf = System.currentTimeMillis();
        this.oVd = new j();
        try {
            this.oVd.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
            this.oVd.setOnCompletionListener(new 3(this, i, j, z, i2));
            this.oVd.setOnErrorListener(new 4(this));
            this.oVd.setAudioStreamType(i2);
            if (z) {
                this.oVd.setVolume(0.6f, 0.6f);
            } else {
                bMj();
            }
            this.oVd.setLooping(false);
            this.oVd.prepare();
            this.oVd.start();
            if (System.currentTimeMillis() - this.oVf > 2000) {
                this.oVe = 3;
            }
        } catch (Exception e) {
            x.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e.toString());
        }
    }

    private void bMj() {
        if (this.mContext.getSharedPreferences(ad.chY(), 0).getBoolean("settings_shake", true)) {
            int ringerMode = this.dge.getRingerMode();
            x.i("MicroMsg.RingPlayer", "system ringer mode: %s", new Object[]{Integer.valueOf(ringerMode)});
            if (ringerMode == 1 || ringerMode == 2) {
                this.hXL = (Vibrator) this.mContext.getSystemService("vibrator");
                if (this.hXL != null) {
                    this.hXL.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
                    return;
                }
                return;
            }
            x.i("MicroMsg.RingPlayer", "system not open vibrate");
        }
    }

    public final void n(int i, int i2, boolean z) {
        this.oVe = 0;
        if (i == 0) {
            iY(z);
        } else {
            m(i, i2, z);
        }
    }

    public final void o(int i, int i2, boolean z) {
        if (i != R.k.playend || au.HV().yE() || au.HV().yK() || !(this.dge.getRingerMode() == 0 || this.dge.getRingerMode() == 1)) {
            this.mContext.getSharedPreferences(ad.chY(), 0).getBoolean("settings_shake", true);
            x.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(false)});
            this.oVg = System.currentTimeMillis();
            MediaPlayer jVar = new j();
            try {
                jVar.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                jVar.setOnCompletionListener(new 5(this));
                jVar.setOnErrorListener(new 6(this));
                if (z) {
                    jVar.setAudioStreamType(au.HV().yE() ? au.HV().yQ() : 0);
                }
                if (i == R.k.playend && (au.HV().yE() || au.HV().yK())) {
                    jVar.setVolume(0.5f, 0.5f);
                }
                jVar.prepare();
                jVar.setLooping(false);
                jVar.start();
                if (System.currentTimeMillis() - this.oVg > 2000) {
                    this.oVe = 7;
                }
            } catch (Throwable th) {
                x.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[]{th});
                this.oVe = 6;
            }
        }
    }

    public final int bMk() {
        x.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.oVe);
        return this.oVe;
    }
}
