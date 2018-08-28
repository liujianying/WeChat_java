package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.a.f.a;

@TargetApi(19)
class f$b extends a {
    private final AudioTimestamp agY = new AudioTimestamp();
    private long agZ;
    private long aha;
    private long ahb;

    public f$b() {
        super((byte) 0);
    }

    public final void a(AudioTrack audioTrack, boolean z) {
        super.a(audioTrack, z);
        this.agZ = 0;
        this.aha = 0;
        this.ahb = 0;
    }

    public final boolean jo() {
        boolean timestamp = this.aga.getTimestamp(this.agY);
        if (timestamp) {
            long j = this.agY.framePosition;
            if (this.aha > j) {
                this.agZ++;
            }
            this.aha = j;
            this.ahb = j + (this.agZ << 32);
        }
        return timestamp;
    }

    public final long jp() {
        return this.agY.nanoTime;
    }

    public final long jq() {
        return this.ahb;
    }
}
