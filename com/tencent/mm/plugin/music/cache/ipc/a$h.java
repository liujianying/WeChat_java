package com.tencent.mm.plugin.music.cache.ipc;

import com.tencent.mm.an.a.a;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

final class a$h implements i<IPCString, IPCString> {
    private a$h() {
    }

    private static IPCString a(IPCString iPCString) {
        try {
            x.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updatePieceMusicInfo Task, src:%s", new Object[]{iPCString});
            return new IPCString(((a) g.l(a.class)).ms(iPCString.value));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc updatePieceMusicInfo task", new Object[0]);
            return new IPCString("");
        }
    }
}
