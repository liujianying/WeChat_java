package com.tencent.mm.plugin.music.c;

import com.tencent.mm.z.d;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource.Factory;

public final class b implements Factory {
    public d dGy;

    public b(d dVar) {
        this.dGy = dVar;
    }

    public final IDataSource createDataSource() {
        return new a(this.dGy);
    }
}
