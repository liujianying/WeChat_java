package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class a extends com.tencent.mm.plugin.mmsight.api.a {
    private int aeg;
    private String filePath;
    private int jdD = -1;
    private MediaExtractor ldo;
    private int lhM;
    private c ljP;
    private d ljQ;
    private String ljR;
    private int ljS;
    private int ljT;
    private int ljU;
    private int ljV;
    private int ljW;
    private int ljX;
    private long ljY = -1;
    private long ljZ = -1;
    private int lka = -1;
    private int lkb;
    private Point lkc = null;
    private HandlerThread lkd;
    private a lke;
    private Bitmap lkf;
    private byte[] lkg = null;
    private byte[] lkh = null;
    private int videoFps;

    public a(String str, String str2, int i, int i2, int i3, int i4) {
        if (bi.oW(str) || bi.oW(str2) || i <= 0 || i2 <= 0) {
            x.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)});
            return;
        }
        this.filePath = str;
        this.ljR = str2;
        this.ljU = i;
        this.ljV = i2;
        this.ljW = i3;
        this.lka = i4;
        this.ljX = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a Lo = d.Lo(str);
        if (Lo != null) {
            this.ljS = Lo.width;
            this.ljT = Lo.height;
            this.jdD = Lo.jdD;
            this.videoFps = Lo.ljG;
        }
        this.ljY = 0;
        this.ljZ = (long) this.jdD;
        x.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[]{str, str2, Integer.valueOf(this.ljS), Integer.valueOf(this.ljT), Integer.valueOf(this.ljX), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public a(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        if (bi.oW(str) || bi.oW(str2) || i <= 0 || i2 <= 0) {
            x.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)});
            return;
        }
        this.filePath = str;
        this.ljR = str2;
        this.ljU = i;
        this.ljV = i2;
        this.ljW = i3;
        this.lka = i4;
        this.ljX = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a Lo = d.Lo(str);
        if (Lo != null) {
            this.ljS = Lo.width;
            this.ljT = Lo.height;
            this.videoFps = Lo.ljG;
        }
        this.ljY = j;
        this.ljZ = j2;
        x.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[]{str, str2, Integer.valueOf(this.ljS), Integer.valueOf(this.ljT), Integer.valueOf(this.ljX), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)});
    }

    public final void B(Bitmap bitmap) {
        if (bitmap != null) {
            this.lkf = bitmap;
        }
    }

    public final int bdG() {
        int round = Math.round(((float) this.jdD) / 1000.0f);
        if (this.ljY >= 0 && this.ljZ >= 0) {
            round = Math.round(((float) (this.ljZ - this.ljY)) / 1000.0f) + 1;
        }
        this.lhM = MP4MuxerJNI.initDataBuf(round);
        this.ljP = new c();
        if (this.jdD > 0) {
            round = this.ljP.c(this.filePath, 0, (long) this.jdD, this.videoFps);
        } else if (this.ljY < 0 || this.ljZ < 0) {
            x.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", new Object[]{Integer.valueOf(this.jdD), Long.valueOf(this.ljY), Long.valueOf(this.ljZ)});
            MP4MuxerJNI.releaseDataBuf(this.lhM);
            return -1;
        } else {
            round = this.ljP.c(this.filePath, this.ljY, this.ljZ, this.videoFps);
        }
        x.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", new Object[]{Integer.valueOf(round)});
        if (round < 0) {
            MP4MuxerJNI.releaseDataBuf(this.lhM);
            return -1;
        }
        if (this.lka > 0 && this.lka < this.videoFps) {
            this.ljP.lkq = (double) ((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.lka))));
        }
        this.ljQ = new d(this.ljS, this.ljT, this.ljU, this.ljV, this.ljW, this.lka > 0 ? Math.min(this.lka, this.videoFps) : this.videoFps);
        this.ljP.lkl = new com.tencent.mm.plugin.mmsight.model.b.c.a() {
            public final void a(byte[] bArr, boolean z, long j) {
                int i = 1;
                if (a.this.lkd == null) {
                    a.this.lkd = e.cZ("remuxer_encode", -2);
                    a.this.lkd.start();
                    a.this.lke = new a(a.this, a.this.lkd.getLooper());
                }
                if (a.this.lke != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    Object i2 = bArr != null ? j.lin.i(Integer.valueOf(bArr.length)) : null;
                    if (i2 != null) {
                        System.arraycopy(bArr, 0, i2, 0, i2.length);
                    }
                    obtain.obj = i2;
                    if (!z) {
                        i = 0;
                    }
                    obtain.arg1 = i;
                    obtain.arg2 = (int) j;
                    a.this.lke.sendMessage(obtain);
                }
            }
        };
        this.ljQ.lkr = new 2(this);
        try {
            long j;
            this.ljQ.sU(this.lhM);
            d dVar = this.ljQ;
            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
            dVar.bTv = true;
            this.ljP.beH();
            this.lkd.quitSafely();
            this.lkd.join();
            this.lke = null;
            this.ldo = new MediaExtractor();
            try {
                MediaFormat trackFormat;
                this.ldo.setDataSource(this.filePath);
                String str = null;
                int i = 0;
                while (i < this.ldo.getTrackCount()) {
                    trackFormat = this.ldo.getTrackFormat(i);
                    str = trackFormat.getString("mime");
                    if (str.startsWith("audio/")) {
                        break;
                    }
                    i++;
                }
                trackFormat = null;
                i = -1;
                if (i >= 0 && trackFormat != null && !bi.oW(r2)) {
                    this.aeg = trackFormat.getInteger("channel-count");
                    this.lkb = trackFormat.getInteger("sample-rate");
                    this.ldo.selectTrack(i);
                    if (this.ljY > 0) {
                        this.ldo.seekTo(this.ljY * 1000, 0);
                    }
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
                    while (true) {
                        allocateDirect.clear();
                        int readSampleData = this.ldo.readSampleData(allocateDirect, 0);
                        x.d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", new Object[]{Integer.valueOf(readSampleData)});
                        if (readSampleData <= 0) {
                            x.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxAudio size = %d. Saw eos.", new Object[]{Integer.valueOf(readSampleData)});
                            break;
                        } else if (this.ldo.getSampleTime() >= this.ljZ * 1000) {
                            break;
                        } else if (this.ldo.getSampleTrackIndex() != i) {
                            x.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
                            break;
                        } else {
                            allocateDirect.position(0);
                            MP4MuxerJNI.writeAACData(this.lhM, allocateDirect, readSampleData);
                            this.ldo.advance();
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e, "muxAudio create extractor failed: %s", new Object[]{e.getMessage()});
            }
            String str2 = this.ljR;
            if (this.ljX > 0) {
                str2 = str2 + "tempRotate.mp4";
            }
            long j2 = (long) this.jdD;
            if (j2 <= 0) {
                j = this.ljZ - this.ljY;
            } else {
                j = j2;
            }
            x.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", new Object[]{Integer.valueOf(MP4MuxerJNI.muxing(this.lhM, this.lkb, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, this.aeg, str2, (((float) this.ljQ.frameCount) * 1000.0f) / ((float) j), null, 0))});
            if (this.ljX > 0) {
                SightVideoJNI.tagRotateVideo(str2, this.ljR, this.ljX);
                FileOp.deleteFile(str2);
            }
            MP4MuxerJNI.releaseDataBuf(this.lhM);
            j.lin.Fm();
            return round;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e2, "decode error: %s", new Object[]{e2.getMessage()});
            return -1;
        }
    }

    public final int getType() {
        return 1;
    }
}
