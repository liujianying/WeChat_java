package com.tencent.mm.plugin.u;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class a extends h {
    private AudioTrack aga;
    private int channels;
    private boolean hEj = false;
    private int sampleRate;

    public a(g gVar, ag agVar) {
        super(gVar, agVar);
    }

    final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        x.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[]{avA(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)});
        if (d.sE(this.state)) {
            if (this.aga == null) {
                Object obj;
                x.i("MicroMsg.AudioTrackDataSource", "%s init audio track", new Object[]{avA()});
                if (this.channels == 0) {
                    this.channels = this.ldl.getInteger("channel-count");
                }
                int i2 = this.channels == 1 ? 4 : 12;
                this.aga = new d(3, getSampleRate(), i2, AudioTrack.getMinBufferSize(getSampleRate(), i2, 2));
                if (this.aga == null || this.aga.getState() == 1) {
                    setMute(this.hEj);
                    obj = 1;
                } else {
                    x.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", new Object[]{avA(), Integer.valueOf(this.aga.getState())});
                    this.aga.release();
                    this.aga = null;
                    obj = null;
                }
                if (obj == null) {
                    return false;
                }
            }
            if (d.sz(this.state) && (this.aga.getPlayState() == 2 || this.aga.getPlayState() == 1)) {
                onStart();
            }
            if ((this.state == 4 ? 1 : null) != null && this.aga.getPlayState() == 3) {
                onPause();
            }
            try {
                this.ldg.lcX = bufferInfo.presentationTimeUs;
                byte[] bArr = new byte[bufferInfo.size];
                byteBuffer.get(bArr);
                byteBuffer.clear();
                if (bArr.length > 0) {
                    this.aga.write(bArr, 0, bArr.length);
                }
                x.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track", new Object[]{avA(), Integer.valueOf(i), Long.valueOf(this.ldg.lcX)});
                mediaCodec.releaseOutputBuffer(i, false);
            } catch (Exception e) {
                x.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", new Object[]{avA(), e.toString()});
            }
            return true;
        }
        x.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", new Object[]{avA(), Integer.valueOf(this.state)});
        return false;
    }

    protected final void onStart() {
        x.i("MicroMsg.AudioTrackDataSource", "%s on start", new Object[]{avA()});
        if (this.aga != null && this.aga.getState() == 1) {
            this.aga.play();
        }
    }

    protected final void onPause() {
        x.i("MicroMsg.AudioTrackDataSource", "%s on pause", new Object[]{avA()});
        if (this.aga != null && this.aga.getState() == 1) {
            this.aga.pause();
        }
    }

    public final void release() {
        try {
            this.aga.flush();
            this.aga.release();
        } catch (Exception e) {
        }
        super.release();
    }

    public final void setMute(boolean z) {
        if (this.aga == null) {
            x.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", new Object[]{avA(), Boolean.valueOf(z)});
            this.hEj = z;
        } else if (com.tencent.mm.compatible.util.d.fS(21)) {
            x.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", new Object[]{avA(), Boolean.valueOf(z)});
            if (z) {
                this.aga.setStereoVolume(0.0f, 0.0f);
            } else {
                this.aga.setStereoVolume(1.0f, 1.0f);
            }
        } else {
            x.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", new Object[]{avA(), Boolean.valueOf(z)});
            if (z) {
                this.aga.setVolume(0.0f);
            } else {
                this.aga.setVolume(1.0f);
            }
        }
    }

    final boolean a(MediaCodec mediaCodec) {
        x.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", new Object[]{avA()});
        mediaCodec.configure(this.ldl, null, null, 0);
        return false;
    }

    private int getSampleRate() {
        if (this.sampleRate == 0) {
            this.sampleRate = this.ldl.getInteger("sample-rate");
        }
        return this.sampleRate;
    }

    protected final void b(MediaCodec mediaCodec) {
        x.i("MicroMsg.AudioTrackDataSource", "%s on output format changed", new Object[]{avA()});
        this.sampleRate = 0;
        this.channels = 0;
        if (this.aga != null) {
            try {
                this.aga.flush();
                this.aga.release();
            } catch (Exception e) {
            }
        }
        this.aga = null;
    }

    final String type() {
        return "audio";
    }
}
