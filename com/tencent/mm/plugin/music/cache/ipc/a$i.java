package com.tencent.mm.plugin.music.cache.ipc;

import com.tencent.mm.an.a.a;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

final class a$i implements i<IPCAudioParamRequest, IPCVoid> {
    private a$i() {
    }

    private static IPCVoid a(IPCAudioParamRequest iPCAudioParamRequest) {
        try {
            x.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileCacheComplete Task, musicId:%s, complete:%d", new Object[]{iPCAudioParamRequest.lxx, Integer.valueOf(iPCAudioParamRequest.lxH)});
            ((a) g.l(a.class)).P(iPCAudioParamRequest.lxx, iPCAudioParamRequest.lxH);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc updateMusicFileCacheComplete task", new Object[0]);
        }
        return new IPCVoid();
    }
}
