package com.tencent.mm.e.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.e.b.g;
import com.tencent.mm.e.c.a.a;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c implements a {
    private static a bFM = new a();
    public BlockingQueue<g.a> bFC = new ArrayBlockingQueue(1024);
    public boolean bFD = false;
    private String bFE;
    private int bFF = 0;
    private byte[] bFG = null;
    private int bFH = 16000;
    private Object bFI = new Object();
    public a bFJ = null;
    private int bFK;
    private boolean bFL = false;
    private FileOutputStream mFileOutputStream;
    private int mSampleRate = 16000;

    public c(int i, int i2) {
        this.mSampleRate = i;
        this.bFH = i2;
    }

    public final boolean df(String str) {
        x.i("MicroMsg.SilkWriter", "initWriter path: " + str);
        if (str == null) {
            x.e("MicroMsg.SilkWriter", "path is null");
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            this.bFE = str;
            this.mFileOutputStream = fileOutputStream;
            int zj = m.zj();
            if ((zj & 1024) != 0) {
                this.bFK = 4;
            } else if ((zj & 512) != 0) {
                this.bFK = 2;
            } else {
                x.e("TAG", "initWriter cpuType error! silk don't support arm_v5!!!!");
                return false;
            }
            if (MediaRecorder.SilkEncInit(this.mSampleRate, this.bFH, this.bFK) != 0) {
                x.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error:%d", new Object[]{Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.bFH, this.bFK))});
                return false;
            }
            this.bFG = new byte[(((this.mSampleRate * 20) * 2) / BaseReportManager.MAX_READ_COUNT)];
            zj = -1;
            com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100279");
            if (fJ.isValid()) {
                zj = bi.getInt((String) fJ.ckq().get("isVoiceMsgOptOpen"), 0);
            }
            if (1 == zj) {
                this.bFL = true;
            }
            if (zj == 0) {
                this.bFL = false;
            }
            if (this.bFL) {
                MediaRecorder.SetVoiceSilkControl(200, 1);
                x.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
            } else {
                MediaRecorder.SetVoiceSilkControl(200, 0);
                x.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", new Object[]{e.getMessage()});
            return false;
        }
    }

    public final void wA() {
        x.i("MicroMsg.SilkWriter", "waitStop");
        synchronized (this) {
            this.bFD = true;
        }
        if (this.bFJ != null) {
            try {
                e.U(this.bFJ);
            } catch (Throwable e) {
                x.e("MicroMsg.SilkWriter", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        synchronized (this.bFI) {
            MediaRecorder.SilkEncUnInit();
        }
        x.i("MicroMsg.SilkWriter", "finish Thread file:" + this.bFE);
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                x.e("MicroMsg.SilkWriter", "close silk file:" + this.bFE + "msg:" + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public final boolean wB() {
        x.i("MicroMsg.SilkWriter", "resetWriter");
        synchronized (this.bFI) {
            MediaRecorder.SilkEncUnInit();
        }
        if (MediaRecorder.SilkEncInit(this.mSampleRate, this.bFH, this.bFK) == 0) {
            return true;
        }
        x.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error:%d", new Object[]{Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.bFH, this.bFK))});
        return false;
    }

    public final int a(g.a aVar) {
        return a(aVar, 0, false);
    }

    public final int a(g.a aVar, int i, boolean z) {
        com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
        short s = (short) (((this.mSampleRate * 20) * 2) / BaseReportManager.MAX_READ_COUNT);
        short s2 = this.bFF + aVar.bEG;
        int i2 = 0;
        Object obj = new byte[s];
        byte[] bArr = new byte[((this.bFL ? 6 : 1) * s)];
        String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("VoiceNoiseSuppression");
        boolean z2 = !bi.oW(value) ? bi.getInt(value, 1) == 1 : true;
        if (z) {
            z2 = false;
        }
        x.d("MicroMsg.SilkWriter", "noise suppression: %b", new Object[]{Boolean.valueOf(z2)});
        int i3 = 0;
        while (s2 >= s) {
            int SilkDoEnc;
            if (this.bFF > 0) {
                try {
                    System.arraycopy(this.bFG, 0, obj, 0, this.bFF);
                    System.arraycopy(aVar.buf, 0, obj, this.bFF, s - this.bFF);
                    i2 += s - this.bFF;
                    this.bFF = 0;
                } catch (Exception e) {
                    x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, leftBufSize:%d copySize:%d error:%s", new Object[]{Integer.valueOf(this.bFF), Integer.valueOf(s - this.bFF), e.getMessage()});
                    return -1;
                }
            }
            try {
                System.arraycopy(aVar.buf, i2, obj, 0, s);
                i2 += s;
            } catch (Exception e2) {
                x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d framelen:%d error:%s", new Object[]{Integer.valueOf(i2), Short.valueOf(s), e2.getMessage()});
                return -1;
            }
            short s3 = s2 - s;
            short[] sArr = new short[1];
            synchronized (this.bFI) {
                if (this.bFL) {
                    if (s3 >= s || !aVar.bEH) {
                        MediaRecorder.SetVoiceSilkControl(CdnLogic.kAppTypeNearEvent, 0);
                    } else {
                        MediaRecorder.SetVoiceSilkControl(CdnLogic.kAppTypeNearEvent, 1);
                        x.i("MicroMsg.SilkWriter", "silk do encode mark last frame");
                    }
                }
                SilkDoEnc = MediaRecorder.SilkDoEnc(obj, s, bArr, sArr, z2);
            }
            Object obj2 = null;
            if (z && sArr[0] >= (short) 10 && bArr[0] == (byte) 2 && bArr[1] == (byte) 35 && bArr[2] == (byte) 33 && bArr[3] == (byte) 83 && bArr[4] == (byte) 73 && bArr[5] == (byte) 76 && bArr[6] == (byte) 75 && bArr[7] == (byte) 95 && bArr[8] == (byte) 86 && bArr[9] == (byte) 51) {
                x.i("MicroMsg.SilkWriter", "writeSilkFile deleteHead & bDeleteHead true");
                obj2 = 1;
            }
            if (SilkDoEnc != 0) {
                this.bFF = 0;
                x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode failed, ret:%d", new Object[]{Integer.valueOf(SilkDoEnc)});
                return -1;
            }
            x.v("MicroMsg.SilkWriter", "encoutdatalen: %s, framelen: %s, lastframe: %s, byteBuf.len: %s", new Object[]{Short.valueOf(sArr[0]), Short.valueOf(s), Boolean.valueOf(aVar.bEH), Integer.valueOf(aVar.bEG)});
            try {
                if (sArr[0] < bArr.length && sArr[0] > (short) 0) {
                    if (!z || obj2 == null) {
                        this.mFileOutputStream.write(bArr, 0, sArr[0]);
                        i3 += sArr[0];
                    } else {
                        x.i("MicroMsg.SilkWriter", "writeSilkFile bDeleteHead copyOfRange");
                        this.mFileOutputStream.write(Arrays.copyOfRange(bArr, 1, bArr.length), 0, sArr[0] - 1);
                        i3 += sArr[0] - 1;
                        s2 = s3;
                    }
                }
                s2 = s3;
            } catch (IOException e3) {
                x.e("MicroMsg.SilkWriter", "writeSilkFile Write File Error file:%s", new Object[]{this.bFE});
                return -1;
            }
        }
        try {
            this.mFileOutputStream.flush();
            try {
                System.arraycopy(aVar.buf, i2, this.bFG, this.bFF, s2);
                this.bFF += s2;
                long Ad = aVar2.Ad();
                if (i == 1) {
                    a aVar3 = bFM;
                    aVar3.bFz = ((aVar3.bFz * ((long) aVar3.count)) + Ad) / ((long) (aVar3.count + 1));
                    aVar3.count++;
                }
                x.d("MicroMsg.SilkWriter", "writeSilkFile append2silkfile silkTime:" + Ad + " useFloat:" + i + " avg:" + bFM.bFz + " cnt:" + bFM.count);
                return i3;
            } catch (Exception e22) {
                x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d leftBufSize:%d leftSize:%d error:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.bFF), Integer.valueOf(s2), e22.getMessage()});
                return -1;
            }
        } catch (IOException e4) {
            x.e("MicroMsg.SilkWriter", "writeSilkFile flush File Error file:%s", new Object[]{this.bFE});
            return -1;
        }
    }
}
