package com.tencent.mm.plugin.u;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Pair;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class h {
    private ByteBuffer[] agE;
    private BufferInfo apA = new BufferInfo();
    private ByteBuffer[] apO;
    private int apQ;
    private int apR;
    long aqC;
    protected g ldg;
    protected ag ldh;
    private boolean ldi = false;
    b ldj = null;
    protected long ldk = 0;
    MediaFormat ldl;
    private String ldm;
    int ldn;
    MediaExtractor ldo;
    private f ldp;
    protected MediaCodec ldq;
    private boolean ldr = false;
    private boolean lds = false;
    private volatile Object lock = new Object();
    protected String path;
    protected int state;

    abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo);

    abstract boolean a(MediaCodec mediaCodec);

    abstract String type();

    public h(g gVar, ag agVar) {
        this.ldg = gVar;
        this.ldh = agVar;
        this.state = 0;
        this.apQ = -1;
        this.apR = -1;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    private void bdw() {
        if (this.ldj != null) {
            this.ldk = this.ldj.bdp() * 1000;
        }
    }

    public final void bdx() {
        x.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[]{avA()});
        this.apR = -1;
        this.apQ = -1;
        try {
            if (this.ldq != null) {
                this.ldq.flush();
            }
        } catch (Exception e) {
        }
    }

    public void release() {
        x.i("MicroMsg.TrackDataSource", "%s release", new Object[]{avA()});
        if (this.ldo != null) {
            this.ldo.release();
            this.ldo = null;
        }
        if (this.ldq != null) {
            this.ldq.release();
            this.ldq = null;
        }
        if (this.ldp != null) {
            f fVar = this.ldp;
            if (fVar.lcP != null) {
                try {
                    fVar.lcP.close();
                } catch (IOException e) {
                }
            }
            fVar.eyW.clear();
            fVar.eyW = null;
            fVar.eyX.clear();
            fVar.eyX = null;
            fVar.lcQ = null;
        }
        x.i("MicroMsg.TrackDataSource", "%s finish release", new Object[]{avA()});
    }

    protected final void ll() {
        if (this.ldq != null) {
            x.i("MicroMsg.TrackDataSource", "%s release decoder", new Object[]{avA()});
            bdx();
            this.agE = null;
            this.apO = null;
            long VG = bi.VG();
            synchronized (this.lock) {
                x.i("MicroMsg.TrackDataSource", "%s wait lock cost[%d]", new Object[]{avA(), Long.valueOf(bi.bI(VG))});
                try {
                    this.ldq.stop();
                    this.ldq.release();
                    this.ldq = null;
                } catch (Exception e) {
                    this.ldq.release();
                    this.ldq = null;
                } catch (Throwable th) {
                    this.ldq = null;
                }
            }
            x.i("MicroMsg.TrackDataSource", "%s finish release decoder [%d]", new Object[]{avA(), Long.valueOf(bi.bI(VG))});
        }
    }

    protected final boolean bdy() {
        try {
            x.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[]{avA(), this.ldm});
            this.ldq = MediaCodec.createDecoderByType(this.ldm);
            a(this.ldq);
            this.ldq.start();
            this.apO = this.ldq.getInputBuffers();
            this.agE = this.ldq.getOutputBuffers();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s prepare decoder init decoder error ", new Object[]{avA()});
            this.ldg.Hm(type());
            return false;
        }
    }

    public final void start() {
        x.i("MicroMsg.TrackDataSource", "%s start to play", new Object[]{avA()});
        setState(3);
        onStart();
    }

    public final void pause() {
        x.i("MicroMsg.TrackDataSource", "%s start to pause", new Object[]{avA()});
        setState(4);
        onPause();
    }

    public final long sF(int i) {
        x.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[]{avA(), Integer.valueOf(i), Boolean.valueOf(this.ldi)});
        bdx();
        this.ldi = false;
        if (this.ldp != null) {
            try {
                f fVar = this.ldp;
                long j = (long) (i * 1000);
                int i2 = 0;
                while (i2 < fVar.eyX.size()) {
                    Pair pair = (Pair) fVar.eyX.get(i2);
                    if (j < ((Long) pair.second).longValue()) {
                        break;
                    } else if (j == ((Long) pair.second).longValue()) {
                        fVar.lcR = ((Integer) pair.first).intValue();
                        fVar.lcQ = (g) fVar.eyW.get(fVar.lcR);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0 || i2 == fVar.eyX.size() - 1) {
                    fVar.lcR = ((Integer) ((Pair) fVar.eyX.get(i2)).first).intValue();
                    fVar.lcQ = (g) fVar.eyW.get(fVar.lcR);
                    if (this.ldp.lcQ.eyZ < 0) {
                        w(((long) i) * 1000, -1);
                    }
                    if (this.ldp.lcQ.eyZ < 0) {
                        w(0, -1);
                        this.ldg.bdv();
                    }
                    x.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[]{avA(), Long.valueOf(this.ldp.lcQ.eyZ)});
                    return this.ldp.lcQ.eyZ / 1000;
                }
                fVar.lcR = ((Integer) ((Pair) fVar.eyX.get(i2 - 1)).first).intValue();
                fVar.lcQ = (g) fVar.eyW.get(fVar.lcR);
                if (this.ldp.lcQ.eyZ < 0) {
                    w(((long) i) * 1000, -1);
                }
                if (this.ldp.lcQ.eyZ < 0) {
                    w(0, -1);
                    this.ldg.bdv();
                }
                x.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[]{avA(), Long.valueOf(this.ldp.lcQ.eyZ)});
                return this.ldp.lcQ.eyZ / 1000;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s extractor seek exception %s", new Object[]{avA(), e.toString()});
                return 0;
            }
        }
        try {
            this.ldo.seekTo((long) (i * 1000), 0);
            if (this.ldo.getSampleTime() < 0) {
                w(((long) i) * 1000, -1);
            }
            if (this.ldo.getSampleTime() < 0) {
                w(0, -1);
                this.ldg.bdv();
            }
            x.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d]", new Object[]{avA(), Long.valueOf(this.ldo.getSampleTime()), Long.valueOf(this.ldo.getCachedDuration())});
            return this.ldo.getSampleTime() / 1000;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s extractor seek exception %s", new Object[]{avA(), e2.toString()});
            return 0;
        }
    }

    public final boolean bdz() {
        x.i("MicroMsg.TrackDataSource", "%s start to prepare path %s", new Object[]{avA(), this.path});
        long VG = bi.VG();
        long j = 0;
        try {
            x.i("MicroMsg.TrackDataSource", "%s start to init extractor", new Object[]{avA()});
            this.ldo = new MediaExtractor();
            this.ldo.setDataSource(this.path);
            int trackCount = this.ldo.getTrackCount();
            this.ldn = -1;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.ldo.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string != null && string.contains(type())) {
                    b(trackFormat, string, i);
                    break;
                }
            }
            if (this.ldn < 0) {
                x.w("MicroMsg.TrackDataSource", "%s prepare track but can not find track index.[%d, %d]", new Object[]{avA(), Integer.valueOf(trackCount), Integer.valueOf(this.ldn)});
                this.ldg.Hl("can not find ");
                return false;
            }
            this.ldo.selectTrack(this.ldn);
            this.ldp = null;
            long VG2 = bi.VG();
            try {
                x.i("MicroMsg.TrackDataSource", "%s start to init decoder mime[%s] state[%d]", new Object[]{avA(), this.ldm, Integer.valueOf(this.state)});
                if (!d.sB(this.state)) {
                    synchronized (this.lock) {
                        this.ldq = MediaCodec.createDecoderByType(this.ldm);
                        a(this.ldq);
                        this.ldq.start();
                        this.apO = this.ldq.getInputBuffers();
                        this.agE = this.ldq.getOutputBuffers();
                    }
                    j = bi.VG();
                }
                setState(1);
                x.i("MicroMsg.TrackDataSource", "%s finish to prepare cost[%d %d %d]", new Object[]{avA(), Long.valueOf(bi.bI(VG)), Long.valueOf(VG2 - VG), Long.valueOf(j - VG)});
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.TrackDataSource", "%s prepare init decoder error %s", new Object[]{avA(), e.toString()});
                this.ldg.Hm(type());
                return false;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s prepare init extractor error", new Object[]{avA()});
            this.ldg.Hl(e2.toString());
            return false;
        } catch (Throwable e22) {
            x.e("MicroMsg.TrackDataSource", "%s prepare init extractor error %s", new Object[]{avA(), e22.toString()});
            this.ldg.Hl(e22.toString());
            return false;
        }
    }

    protected final int v(long j, long j2) {
        g gVar;
        String type;
        x.d("MicroMsg.TrackDataSource", "%s start to do some work time[%d %d] state %d", new Object[]{avA(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.state)});
        if (this.ldq != null) {
            do {
                try {
                    if (d(j, j2)) {
                    }
                } catch (Throwable e) {
                    if (this.ldr) {
                        x.e("MicroMsg.TrackDataSource", "%s do some work drain output buffer error %s", new Object[]{avA(), e.toString()});
                    } else {
                        this.ldr = true;
                        x.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s do some work drain output buffer error", new Object[]{avA()});
                    }
                    if (!d.sB(this.state)) {
                        bdx();
                    }
                    gVar = this.ldg;
                    type = type();
                    if (!gVar.ldf && gVar.lda) {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(354, 158, 1, false);
                        com.tencent.mm.plugin.report.service.h.mEJ.h(13836, new Object[]{Integer.valueOf(506), Long.valueOf(bi.VE()), type});
                        gVar.ldf = true;
                    }
                }
                break;
            } while (!d.sB(this.state));
            try {
                x.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", new Object[]{avA(), Integer.valueOf(this.apQ), Integer.valueOf(this.state), Boolean.valueOf(this.ldi)});
                if (d.sB(this.state) || this.ldi) {
                    x.i("MicroMsg.TrackDataSource", "%s feed input buffer is end.", new Object[]{avA()});
                } else {
                    if (this.apQ < 0) {
                        this.apQ = this.ldq.dequeueInputBuffer(0);
                        if (this.apQ < 0) {
                            x.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer", new Object[]{avA()});
                        }
                    }
                    ByteBuffer byteBuffer = this.apO[this.apQ];
                    int x;
                    long j3;
                    int i;
                    if (this.ldp != null) {
                        x = this.ldp.x(byteBuffer);
                        j3 = this.ldp.lcQ.eyZ;
                        i = this.ldp.lcQ.eza;
                        x.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[]{avA(), Integer.valueOf(this.apQ), Integer.valueOf(x), Long.valueOf(j3), Integer.valueOf(i)});
                        if (x <= 0) {
                            this.ldq.queueInputBuffer(this.apQ, 0, 0, 0, 4);
                            this.ldi = true;
                        } else {
                            this.ldq.queueInputBuffer(this.apQ, 0, x, j3, 0);
                            this.apQ = -1;
                            f fVar = this.ldp;
                            fVar.lcR++;
                            if (fVar.lcR < fVar.lcS) {
                                fVar.lcQ = (g) fVar.eyW.get(fVar.lcR);
                                x.d("MicroMsg.Mp4Extractor", "curr sample [%s]", new Object[]{fVar.lcQ});
                            }
                        }
                    } else if (this.ldg.ldd) {
                        this.ldq.queueInputBuffer(this.apQ, 0, 0, this.aqC * 1000, 4);
                        this.ldi = true;
                        this.ldg.ldd = false;
                    } else {
                        x = this.ldo.readSampleData(byteBuffer, 0);
                        j3 = this.ldo.getSampleTime();
                        x.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[]{avA(), Integer.valueOf(this.apQ), Integer.valueOf(x), Long.valueOf(j3), Integer.valueOf(this.ldo.getSampleFlags())});
                        B(i, j3);
                        if (x <= 0) {
                            this.ldq.queueInputBuffer(this.apQ, 0, 0, this.aqC * 1000, 4);
                            this.ldi = true;
                        } else {
                            this.ldq.queueInputBuffer(this.apQ, 0, x, j3, 0);
                            this.apQ = -1;
                            this.ldo.advance();
                            long sampleTime = this.ldo.getSampleTime();
                            if (this.ldg.ldc) {
                                if (this.ldk == 0) {
                                    if (w(j3, sampleTime)) {
                                        x.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[]{avA(), Long.valueOf(sampleTime), Long.valueOf(this.ldk)});
                                        if (Math.abs(this.ldo.getSampleTime() - j3) >= 3000000) {
                                            x.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[]{avA(), Long.valueOf(this.ldo.getSampleTime()), Long.valueOf(j3)});
                                            this.ldh.obtainMessage(5, -2, -2).sendToTarget();
                                        }
                                        bdw();
                                    }
                                } else if (sampleTime < 0 || (sampleTime / 1000) + 1200 > this.ldk) {
                                    x.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[]{avA(), Long.valueOf(sampleTime), Long.valueOf(this.ldk)});
                                    if (w(j3, -1)) {
                                        this.ldh.obtainMessage(5, -3, -3).sendToTarget();
                                    }
                                    bdw();
                                }
                            } else if (w(j3, sampleTime)) {
                                x.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", new Object[]{avA(), Boolean.valueOf(this.ldg.ldc), Long.valueOf(sampleTime), Long.valueOf(this.ldk)});
                                if (Math.abs(this.ldo.getSampleTime() - j3) >= 1000000) {
                                    x.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[]{avA(), Long.valueOf(this.ldo.getSampleTime()), Long.valueOf(j3)});
                                    this.ldg.ldd = true;
                                }
                            }
                            x.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", new Object[]{avA(), Long.valueOf(j3), Long.valueOf(sampleTime)});
                        }
                    }
                }
            } catch (Throwable e2) {
                if (this.lds) {
                    x.e("MicroMsg.TrackDataSource", "%s do some work feed input buffer error %s", new Object[]{avA(), e2.toString()});
                } else {
                    this.lds = true;
                    x.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s do some work feed input buffer error", new Object[]{avA()});
                }
                if (!d.sB(this.state)) {
                    bdx();
                }
                gVar = this.ldg;
                type = type();
                if (!gVar.lde && gVar.lda) {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(354, 157, 1, false);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(13836, new Object[]{Integer.valueOf(505), Long.valueOf(bi.VE()), type});
                    gVar.lde = true;
                }
            }
        }
        x.d("MicroMsg.TrackDataSource", "%s finish to do some work. state %d", new Object[]{avA(), Integer.valueOf(this.state)});
        return this.state;
    }

    private boolean d(long j, long j2) {
        x.d("MicroMsg.TrackDataSource", "%s drain output buffer time[%d %d] index %d", new Object[]{avA(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.apR)});
        if (this.apR < 0) {
            synchronized (this.lock) {
                this.apR = this.ldq.dequeueOutputBuffer(this.apA, 0);
            }
            if (this.apR >= 0) {
                if ((this.apA.flags & 4) != 0) {
                    x.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[]{avA()});
                    setState(9);
                    this.apR = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.agE[this.apR];
                if (byteBuffer != null) {
                    byteBuffer.position(this.apA.offset);
                    byteBuffer.limit(this.apA.offset + this.apA.size);
                }
            } else if (this.apR == -2) {
                this.ldl = this.ldq.getOutputFormat();
                b(this.ldq);
                return true;
            } else if (this.apR == -3) {
                this.agE = this.ldq.getOutputBuffers();
                return true;
            } else {
                x.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d]", new Object[]{avA(), Integer.valueOf(this.apR)});
                return false;
            }
        }
        if ((this.state == 1 ? 1 : null) != null) {
            setState(2);
        }
        x.d("MicroMsg.TrackDataSource", "%s process output buffer index %d ", new Object[]{avA(), Integer.valueOf(this.apR)});
        synchronized (this.lock) {
            if (a(j, j2, this.ldq, this.agE[this.apR], this.apR, this.apA)) {
                this.apR = -1;
                return true;
            }
            return false;
        }
    }

    protected final boolean w(long j, long j2) {
        long VG = bi.VG();
        try {
            if ((j / 1000) + 1000 < this.aqC && j2 == -1) {
                this.ldg.ldb = true;
                this.ldi = false;
                this.ldo.release();
                this.ldo = new MediaExtractor();
                this.ldo.setDataSource(this.path);
                this.ldo.selectTrack(this.ldn);
                this.ldo.seekTo(j, 2);
                long sampleTime = this.ldo.getSampleTime();
                x.w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", new Object[]{avA(), Long.valueOf(j), Long.valueOf(sampleTime), Long.valueOf(j2), Long.valueOf(this.ldk), Long.valueOf(bi.bI(VG))});
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.TrackDataSource", "%s reset extractor error %s", new Object[]{avA(), e.toString()});
        }
        return false;
    }

    protected boolean B(int i, long j) {
        return false;
    }

    protected void b(MediaFormat mediaFormat, String str, int i) {
        x.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d]", new Object[]{avA(), str, Integer.valueOf(i)});
        this.ldn = i;
        this.ldm = str;
        this.aqC = mediaFormat.getLong("durationUs") / 1000;
        this.ldl = mediaFormat;
    }

    protected void b(MediaCodec mediaCodec) {
    }

    protected void onStart() {
    }

    protected void onPause() {
    }

    protected final void setState(int i) {
        x.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", new Object[]{avA(), Integer.valueOf(this.state), Integer.valueOf(i)});
        this.state = i;
    }

    public final String avA() {
        return type() + "_" + this.ldg.avA();
    }
}
