package com.tencent.mm.plugin.music.cache.ipc;

import com.tencent.mm.an.a.a;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

final class a$e implements i<IPCAudioParamRequest, IPCVoid> {
    private a$e() {
    }

    private static IPCVoid a(IPCAudioParamRequest iPCAudioParamRequest) {
        try {
            x.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setMusicMIMETypeByMusicId Task, musicId:%s, mimeType:%s", new Object[]{iPCAudioParamRequest.lxx, iPCAudioParamRequest.mimeType});
            ((a) g.l(a.class)).aq(iPCAudioParamRequest.lxx, iPCAudioParamRequest.mimeType);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc setMusicMIMETypeByMusicId task", new Object[0]);
        }
        return new IPCVoid();
    }
}
