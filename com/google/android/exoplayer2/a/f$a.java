package com.google.android.exoplayer2.a;

import android.media.AudioTrack;
import android.os.SystemClock;

class f$a {
    private boolean agR;
    private long agS;
    private long agT;
    private long agU;
    private long agV;
    private long agW;
    private long agX;
    protected AudioTrack aga;
    private int sampleRate;

    private f$a() {
    }

    /* synthetic */ f$a(byte b) {
        this();
    }

    public void a(AudioTrack audioTrack, boolean z) {
        this.aga = audioTrack;
        this.agR = z;
        this.agV = -9223372036854775807L;
        this.agS = 0;
        this.agT = 0;
        this.agU = 0;
        if (audioTrack != null) {
            this.sampleRate = audioTrack.getSampleRate();
        }
    }

    public final void B(long j) {
        this.agW = jm();
        this.agV = SystemClock.elapsedRealtime() * 1000;
        this.agX = j;
        this.aga.stop();
    }

    public final void pause() {
        if (this.agV == -9223372036854775807L) {
            this.aga.pause();
        }
    }

    public final long jm() {
        if (this.agV != -9223372036854775807L) {
            return Math.min(this.agX, ((((SystemClock.elapsedRealtime() * 1000) - this.agV) * ((long) this.sampleRate)) / 1000000) + this.agW);
        }
        int playState = this.aga.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.aga.getPlaybackHeadPosition());
        if (this.agR) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.agU = this.agS;
            }
            playbackHeadPosition += this.agU;
        }
        if (this.agS > playbackHeadPosition) {
            this.agT++;
        }
        this.agS = playbackHeadPosition;
        return playbackHeadPosition + (this.agT << 32);
    }

    public final long jn() {
        return (jm() * 1000000) / ((long) this.sampleRate);
    }

    public boolean jo() {
        return false;
    }

    public long jp() {
        throw new UnsupportedOperationException();
    }

    public long jq() {
        throw new UnsupportedOperationException();
    }
}
