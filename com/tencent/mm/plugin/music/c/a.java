package com.tencent.mm.plugin.music.c;

import com.tencent.mm.z.d;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class a implements IDataSource {
    public d dGy;

    public a(d dVar) {
        this.dGy = dVar;
    }

    public final void open() {
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "open");
        if (this.dGy != null) {
            this.dGy.open();
        }
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        if (this.dGy != null) {
            return this.dGy.readAt(j, bArr, i, i2);
        }
        Logger.e("MicroMsg.Audio.InputStreamDataSource", "[readAt]audioDataSource is null");
        return -1;
    }

    public final long getSize() {
        return this.dGy != null ? this.dGy.getSize() : 0;
    }

    public final AudioType getAudioType() {
        if (this.dGy == null) {
            Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
            return AudioType.UNSUPPORT;
        }
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "getAudioType:" + this.dGy.Kn());
        switch (this.dGy.Kn()) {
            case 0:
                return AudioType.UNSUPPORT;
            case 1:
                return AudioType.AAC;
            case 2:
                return AudioType.MP3;
            case 3:
                return AudioType.WAV;
            case 4:
                return AudioType.OGG;
            default:
                Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
                return AudioType.UNSUPPORT;
        }
    }

    public final void close() {
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "close");
        if (this.dGy != null) {
            this.dGy.close();
        }
    }
}
