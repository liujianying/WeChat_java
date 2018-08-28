package com.tencent.mm.app;

import com.tencent.mm.g.a.gi;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class PusherProfile$1 extends c<gi> {
    final /* synthetic */ PusherProfile bze;

    PusherProfile$1(PusherProfile pusherProfile) {
        this.bze = pusherProfile;
        this.sFo = gi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = "gcm";
        String str2 = "GCMDoSyncEvent Notify Now Always should be MM_NEWSYNC_DEFAULT_SELECTOR  & SCENE_SYNC_GCM  atapter == null[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(aa.Vb() == null);
        x.i(str, str2, objArr);
        if (aa.Vb() != null) {
            aa.Vb().onPush(2147480001, new byte[0]);
        } else {
            aa.cb(true);
        }
        return true;
    }
}
