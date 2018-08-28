package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Process;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b$a;
import com.tencent.mm.e.b.g;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.io.InputStream;
import java.io.OutputStream;

public final class i implements d {
    private static Object eoY = new Object();
    private static int eoZ = -1;
    private static int epa;
    private static int epf = 100;
    public int bEf;
    private a eoR;
    private b eoS;
    private a eoT;
    private d.b eoU;
    private volatile boolean eoV;
    private String eoW;
    private String eoX;
    private int epb;
    private int epc;
    private com.tencent.mm.e.c.b epd;
    private int epe;
    private OnCompletionListener epg;
    private OnErrorListener eph;
    private AudioTrack mAudioTrack;
    private String mFileName;
    public int mSampleRate;
    private int mStatus;

    public final int getStatus() {
        return this.mStatus;
    }

    public i() {
        this.eoT = null;
        this.eoU = null;
        this.bEf = 2;
        this.mSampleRate = 16000;
        this.mFileName = "";
        this.mStatus = 0;
        this.eoV = false;
        this.eoW = "";
        this.eoX = "";
        this.epc = 0;
        this.epd = null;
        this.epe = 8;
        this.epg = new 1(this);
        this.eph = new 2(this);
        eoZ++;
        this.epb = eoZ;
        x.i("MicroMsg.SilkPlayer", "[%d] new Instance", new Object[]{Integer.valueOf(this.epb)});
    }

    public i(Context context) {
        this();
        this.eoS = new b(context);
    }

    public final void a(a aVar) {
        this.eoT = aVar;
    }

    public final void a(d.b bVar) {
        this.eoU = bVar;
    }

    public final void aK(boolean z) {
        x.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        this.eoV = true;
        this.bEf = 2;
        bV(z);
        try {
            this.mAudioTrack.play();
        } catch (Exception e) {
            h.mEJ.a(161, 0, 1, false);
            h.mEJ.a(161, 3, 1, false);
            x.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[]{e.getMessage()});
        }
        this.eoV = false;
    }

    private void bV(boolean z) {
        int i;
        AudioTrack dVar;
        int i2 = 3;
        if (this.mAudioTrack != null) {
            x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            try {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
            } catch (Exception e) {
                x.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", new Object[]{e.getMessage()});
            }
            this.mAudioTrack = null;
        }
        int i3 = this.mSampleRate;
        int i4 = this.bEf;
        int i5 = this.epe;
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        if (q.deN.dby) {
            q.deN.dump();
            if (z && q.deN.dcb >= 0) {
                i = q.deN.dcb;
            } else if (!z && q.deN.dcc >= 0) {
                i = q.deN.dcc;
            }
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i3, i4, 2);
        x.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minBufferSize), Integer.valueOf(i5)});
        d dVar2 = new d(i, i3, i4, i5 * minBufferSize);
        if (dVar2.getState() == 0) {
            dVar2.release();
            x.i("AudioDeviceFactory", "reconstruct AudioTrack");
            if (i != 0) {
                i2 = 0;
            }
            dVar = new d(i2, i3, i4, i5 * minBufferSize);
        } else {
            dVar = dVar2;
        }
        x.i("AudioDeviceFactory", "AudioTrack state: " + dVar.getState());
        this.mAudioTrack = dVar;
        if (this.mAudioTrack == null || this.mAudioTrack.getState() == 0) {
            h.mEJ.a(161, 0, 1, false);
            h.mEJ.a(161, 2, 1, false);
            try {
                if (this.mAudioTrack != null) {
                    this.mAudioTrack.release();
                    this.mAudioTrack = null;
                }
            } catch (Exception e2) {
            }
        }
    }

    public final boolean M(String str, boolean z) {
        return N(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return N(str, z);
    }

    private boolean N(String str, boolean z) {
        int i = 2;
        if (this.mStatus != 0) {
            x.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            return false;
        }
        if (af.exQ) {
            aB(str, g.bEF);
        }
        x.i("MicroMsg.SilkPlayer", "startPlay");
        this.mStatus = 1;
        this.mFileName = str;
        synchronized (eoY) {
            oe(str);
        }
        if (af.exQ) {
            int i2;
            String str2 = g.bEE;
            if (this.bEf == 2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.epd = new com.tencent.mm.e.c.b(str2, i2, this.mSampleRate);
        }
        String str3 = "MicroMsg.SilkPlayer";
        String str4 = "startPlay, sampleRate: %d, channelCnt: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mSampleRate);
        if (this.bEf == 2) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        x.d(str3, str4, objArr);
        try {
            return bW(z);
        } catch (Throwable e) {
            try {
                return bW(true);
            } catch (Exception e2) {
                x.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e)});
                this.mStatus = -1;
                return false;
            }
        }
    }

    private void oe(String str) {
        int available;
        epa = this.epb;
        x.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", new Object[]{Integer.valueOf(this.epb)});
        try {
            InputStream openRead = com.tencent.mm.vfs.d.openRead(str);
            available = openRead.available();
            x.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", new Object[]{Integer.valueOf(available)});
            if (!f.yz().yE() || available >= 5000) {
                this.epe = 8;
            } else {
                this.epe = 1;
            }
            byte[] bArr = new byte[available];
            openRead.read(bArr, 0, available);
            this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
            MediaRecorder.SilkDecUnInit();
            MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
            available = -1;
            c fJ = com.tencent.mm.model.c.c.Jx().fJ("100268");
            if (fJ.isValid()) {
                available = bi.getInt((String) fJ.ckq().get("SilkAudioPlayerAgcOn"), 0);
            }
            if (1 == available || available == 0) {
                MediaRecorder.SetVoiceSilkDecControl(epf, new byte[]{(byte) available}, 1);
            }
            openRead.close();
        } catch (Throwable e) {
            h.mEJ.a(161, 0, 1, false);
            h.mEJ.a(161, 1, 1, false);
            x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e)});
        }
        x.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", new Object[]{Integer.valueOf(this.epb), Integer.valueOf(this.epc)});
        byte[] bArr2 = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2)];
        short s = (short) ((this.mSampleRate * 20) / 1000);
        for (available = 0; available < this.epc; available++) {
            if (MediaRecorder.SilkDoDec(bArr2, s) <= 0) {
                x.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", new Object[]{Integer.valueOf(this.epb), Integer.valueOf(MediaRecorder.SilkDoDec(bArr2, s))});
                return;
            }
        }
    }

    private boolean bW(boolean z) {
        if (!com.tencent.mm.vfs.d.cn(this.mFileName)) {
            return false;
        }
        try {
            bV(z);
            if (this.mAudioTrack == null) {
                return false;
            }
            if (this.eoS != null) {
                this.eoS.requestFocus();
            }
            return TC();
        } catch (Throwable e) {
            if (this.eoS != null) {
                this.eoS.zY();
            }
            x.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + e.getMessage());
            x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e)});
            return false;
        }
    }

    private boolean TC() {
        if (this.mAudioTrack == null) {
            return false;
        }
        try {
            x.i("MicroMsg.SilkPlayer", "play");
            this.mAudioTrack.play();
            this.eoR = new a(this, (byte) 0);
            e.b(this.eoR, "SilkPlayer_play_" + this.epb, 10);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[]{e.getMessage()});
            h.mEJ.a(161, 0, 1, false);
            h.mEJ.a(161, 3, 1, false);
            return false;
        }
    }

    public final boolean aI(boolean z) {
        if (this.mStatus != 1) {
            return false;
        }
        this.mStatus = 2;
        synchronized (this.eoX) {
            try {
                x.v("MicroMsg.SilkPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.eoX.wait();
                x.v("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable e) {
                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e)});
                return false;
            }
        }
        if (this.eoS != null && z) {
            this.eoS.zY();
        }
        return true;
    }

    public final boolean vY() {
        if (this.mStatus != 2) {
            return false;
        }
        this.mStatus = 1;
        synchronized (this.eoW) {
            try {
                x.v("MicroMsg.SilkPlayer", "before mpause.notify");
                this.eoW.notify();
                x.v("MicroMsg.SilkPlayer", "after mpause.notify");
            } catch (Throwable e) {
                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e)});
                return false;
            }
        }
        if (this.eoS != null) {
            this.eoS.requestFocus();
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.mStatus == 1;
    }

    public final boolean wk() {
        x.i("MicroMsg.SilkPlayer", "stop  status:" + this.mStatus);
        if (this.mStatus == 1 || this.mStatus == 2) {
            this.mStatus = 3;
            synchronized (this.eoW) {
                try {
                    this.eoW.notify();
                    if (this.eoS != null) {
                        this.eoS.zY();
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e)});
                    if (this.eoS != null) {
                        this.eoS.zY();
                    }
                    return false;
                } catch (Throwable th) {
                    if (this.eoS != null) {
                        this.eoS.zY();
                    }
                }
            }
            return true;
        }
        x.e("MicroMsg.SilkPlayer", "stop  error status:" + this.mStatus);
        return false;
    }

    public final double wb() {
        return 0.0d;
    }

    public final void b(b$a b_a) {
        if (b_a != null && this.eoS != null) {
            this.eoS.a(b_a);
        }
    }

    public final String aB(String str, String str2) {
        InputStream openRead;
        Throwable e;
        String str3 = null;
        if (this.mStatus != 0) {
            x.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            return str3;
        }
        this.mStatus = 1;
        this.mFileName = str;
        try {
            openRead = com.tencent.mm.vfs.d.openRead(str);
            try {
                int available = openRead.available();
                byte[] bArr = new byte[available];
                openRead.read(bArr, 0, available);
                this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
                MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
                x.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit in silkToPcm", new Object[]{Integer.valueOf(this.epb)});
                openRead.close();
                return of(str2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            openRead = str3;
        }
        x.e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", new Object[]{this.mFileName, e.getMessage()});
        x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e)});
        this.mStatus = -1;
        if (openRead == null) {
            return str3;
        }
        try {
            openRead.close();
            return str3;
        } catch (Throwable e4) {
            x.printErrStackTrace("MicroMsg.SilkPlayer", e4, "", new Object[0]);
            return str3;
        }
    }

    private String of(String str) {
        OutputStream mG;
        Throwable e;
        x.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl()");
        if (com.tencent.mm.vfs.d.cn(this.mFileName)) {
            try {
                x.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread start");
                Process.setThreadPriority(-16);
                byte[] bArr = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) << 1)];
                short s = (short) ((this.mSampleRate * 20) / 1000);
                og(str);
                mG = com.tencent.mm.vfs.d.mG(str);
                while (true) {
                    if (this.mStatus != 1 && this.mStatus != 2) {
                        break;
                    }
                    int SilkDoDec = MediaRecorder.SilkDoDec(bArr, s);
                    if (SilkDoDec < 0) {
                        this.mStatus = 0;
                    } else {
                        while (this.eoV) {
                            try {
                                Thread.sleep(20);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    x.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread exception: " + e.getMessage());
                                    x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e)});
                                    this.mStatus = 0;
                                    if (mG != null) {
                                        try {
                                            mG.close();
                                        } catch (Throwable e3) {
                                            x.printErrStackTrace("MicroMsg.SilkPlayer", e3, "", new Object[0]);
                                        }
                                    }
                                    return null;
                                } catch (Throwable e32) {
                                    x.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl exception: " + e32.getMessage());
                                    x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bi.i(e32)});
                                    return null;
                                }
                            }
                        }
                        mG.write(bArr, 0, s * 2);
                        mG.flush();
                        if (SilkDoDec == 0) {
                            this.mStatus = 0;
                        }
                    }
                }
                x.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread end");
                mG.close();
                int SilkDecUnInit = MediaRecorder.SilkDecUnInit();
                x.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit in silkToPcmImpl", new Object[]{Integer.valueOf(this.epb)});
                if (SilkDecUnInit == 0) {
                    return str;
                }
                x.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl res: " + SilkDecUnInit);
                return str;
            } catch (Exception e4) {
                e32 = e4;
                mG = null;
            }
        } else {
            x.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl(), file not exist, fileName = %s", new Object[]{this.mFileName});
            return null;
        }
    }

    private static boolean og(String str) {
        if (str == null) {
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf == -1) {
                x.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
                return false;
            }
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str.substring(0, lastIndexOf + 1));
            if (!bVar.exists()) {
                boolean z = bVar.mkdirs() || bVar.isDirectory();
                x.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", new Object[]{r3, Boolean.valueOf(z)});
            }
            return true;
        } catch (Exception e) {
            x.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", new Object[]{e.getMessage()});
            return false;
        }
    }
}
