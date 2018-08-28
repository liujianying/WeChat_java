package com.tencent.mm.ui;

import com.tencent.mm.ak.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public class PhotoEditProxy extends a {
    public PhotoEditProxy(d dVar) {
        super(dVar);
    }

    public int doFav(String str) {
        return ((Integer) REMOTE_CALL("doFavInMM", new Object[]{str})).intValue();
    }

    public void sendImage(String str, String str2, String str3, String str4) {
        REMOTE_CALL("sendImageInMM", new Object[]{str, str2, str3, str4});
    }

    public boolean isAutoSave() {
        return ((Boolean) REMOTE_CALL("isAutoSavePhotoInMM", new Object[0])).booleanValue();
    }

    public String getSelfUsername() {
        return (String) REMOTE_CALL("getSelfUsernameInMM", new Object[0]);
    }

    public String getFullPath(String str) {
        return (String) REMOTE_CALL("getFullPathInMM", new Object[]{str});
    }

    @f
    public void sendImageInMM(String str, String str2, String str3, String str4) {
        l lVar = new l(4, str3, str4, str2, 0, null, 0, "", "", true, af.a.chat_img_template);
        g.Ek();
        g.DF().a(lVar, 0);
        com.tencent.mm.plugin.messenger.a.g.bcT().dF(str, str4);
    }

    @f
    public String getSelfUsernameInMM() {
        return q.GF();
    }

    @f
    public boolean isAutoSavePhotoInMM() {
        return g.Ei().DT().getBoolean(aa.a.sVr, true);
    }

    @f
    public int doFavInMM(String str) {
        ch chVar = new ch();
        ((ad) g.l(ad.class)).a(chVar, str);
        chVar.bJF.bJM = 44;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
        x.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", new Object[]{str});
        return chVar.bJG.ret;
    }

    @f
    public String getFullPathInMM(String str) {
        return o.Pf().getFullPath(str);
    }
}
