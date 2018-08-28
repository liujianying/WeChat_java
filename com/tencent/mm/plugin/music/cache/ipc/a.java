package com.tencent.mm.plugin.music.cache.ipc;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

public final class a {

    private static final class f implements i<IPCVoid, IPCBoolean> {
        private f() {
        }

        private static IPCBoolean bhN() {
            try {
                x.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc showAudioToast");
                return new IPCBoolean(((Boolean) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sWt, Boolean.valueOf(false))).booleanValue());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc showAudioToast task", new Object[0]);
                return new IPCBoolean(false);
            }
        }
    }

    public static void k(String str, byte[] bArr) {
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.lxx = str;
        iPCAudioParamRequest.lxI = bArr;
        x.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "updateMusicFileIndexBitCache");
        XIPCInvoker.a("com.tencent.mm", iPCAudioParamRequest, g.class);
        x.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "updateMusicFileIndexBitCache end ");
    }
}
