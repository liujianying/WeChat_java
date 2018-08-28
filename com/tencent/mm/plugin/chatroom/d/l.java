package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhs;
import com.tencent.mm.protocal.c.bht;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;

public final class l extends com.tencent.mm.ab.l implements k {
    private b diG;
    private e diJ;

    public l(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bhs();
        aVar.dIH = new bht();
        aVar.uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
        aVar.dIF = TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_VIDEO_TRACK_LAGGING;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bhs bhs = (bhs) this.diG.dID.dIL;
        bhs.siz = str;
        bhs.siA = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_VIDEO_TRACK_LAGGING;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.diJ.a(i2, i3, str, this);
    }
}
