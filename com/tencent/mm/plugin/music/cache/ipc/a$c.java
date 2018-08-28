package com.tencent.mm.plugin.music.cache.ipc;

import com.tencent.mm.an.a.a;
import com.tencent.mm.an.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

final class a$c implements i<IPCString, IPCAudioParamResponse> {
    private a$c() {
    }

    private static IPCAudioParamResponse b(IPCString iPCString) {
        try {
            x.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getPieceMusicInfo Task, src:%s", iPCString);
            f mr = ((a) g.l(a.class)).mr(iPCString.value);
            if (mr != null) {
                return new IPCAudioParamResponse(mr);
            }
            x.e("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "pmInfo is null");
            return new IPCAudioParamResponse();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getPieceMusicInfo task", new Object[0]);
        }
    }
}
