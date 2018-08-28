package com.tencent.mm.an;

import com.tencent.mm.g.c.cp;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.bi;

public final class a extends cp {
    public static com.tencent.mm.sdk.e.c.a dhO = cp.wI();
    public String eaZ;
    public String playUrl;

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }

    public final boolean PT() {
        return (this.field_songBgColor == 0 || this.field_songLyricColor == 0) ? false : true;
    }

    public final boolean PU() {
        return !bi.oW(this.field_songHAlbumUrl);
    }

    public final boolean f(int[] iArr) {
        return this.field_songBgColor == iArr[0] && this.field_songLyricColor == iArr[1];
    }

    public final boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.field_musicId.equals(aVar.field_musicId);
    }

    public final avq PV() {
        avq avq = new avq();
        avq.rsp = this.field_originMusicId;
        avq.rYj = this.field_musicType;
        avq.jQb = this.field_appId;
        avq.rYn = this.field_songAlbum;
        avq.rYv = this.field_songAlbumType;
        avq.rYo = this.field_songAlbumUrl;
        avq.rYp = this.field_songWifiUrl;
        avq.rYl = this.field_songName;
        avq.rYm = this.field_songSinger;
        avq.rYq = this.field_songWapLinkUrl;
        avq.rYr = this.field_songWebUrl;
        avq.rYt = this.field_songAlbumLocalPath;
        avq.rvP = this.field_songMediaId;
        avq.rYz = this.field_songSnsAlbumUser;
        avq.rYA = this.field_songSnsShareUser;
        avq.rYC = this.field_hideBanner;
        avq.rYD = this.field_jsWebUrlDomain;
        avq.dGs = this.field_startTime;
        avq.eaZ = this.eaZ;
        avq.protocol = this.field_protocol;
        avq.rYE = this.field_barBackToWebView;
        avq.rYF = this.field_musicbar_url;
        return avq;
    }
}
