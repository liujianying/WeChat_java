package com.tencent.mm.plugin.music.cache.ipc;

import com.tencent.mm.an.a.a;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

final class a$g implements i<IPCAudioParamRequest, IPCVoid> {
    private a$g() {
    }

    private static IPCVoid a(IPCAudioParamRequest iPCAudioParamRequest) {
        boolean z = true;
        try {
            String str = "MicroMsg.Audio.MusicDataSourceCrossProcessImp";
            String str2 = "ipc updateMusicFileIndexBitCache Task, musicId:%s, bitset is valid:%b";
            Object[] objArr = new Object[2];
            objArr[0] = iPCAudioParamRequest.lxx;
            if (iPCAudioParamRequest.lxI == null) {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            ((a) g.l(a.class)).k(iPCAudioParamRequest.lxx, iPCAudioParamRequest.lxI);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc updateMusicFileIndexBitCache task", new Object[0]);
        }
        return new IPCVoid();
    }
}
