package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Map;

class a$1 implements b {
    final /* synthetic */ a tYQ;

    a$1(a aVar) {
        this.tYQ = aVar;
    }

    public final CharSequence a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
        String string = bundle.getString("conv_talker_username", "");
        if (map == null) {
            x.w("MicroMsg.SysMsgHandlerBase", "hy: non map!!");
            return null;
        } else if (bi.oW(str)) {
            x.w("MicroMsg.SysMsgHandlerBase", "hy: non header!!");
            return null;
        } else if (!bi.oW(string)) {
            return this.tYQ.a(map, str, weakReference);
        } else {
            x.w("MicroMsg.SysMsgHandlerBase", "hy: not resolved talker!!");
            return null;
        }
    }
}
