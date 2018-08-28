package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.model.q;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.b;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FavOpenApiEntry extends MMActivity {
    private String appId;
    private al bAZ = new al(new al.a() {
        public final boolean vD() {
            if (FavOpenApiEntry.this.getWindow() != null && FavOpenApiEntry.this.getWindow().getDecorView() != null && FavOpenApiEntry.this.getWindow().getDecorView().getWindowToken() != null) {
                FavOpenApiEntry.a(FavOpenApiEntry.this, FavOpenApiEntry.this.jga.message);
                return false;
            } else if (FavOpenApiEntry.this.jgc >= 10) {
                return false;
            } else {
                FavOpenApiEntry.b(FavOpenApiEntry.this);
                return true;
            }
        }
    }, true);
    private Intent bSk;
    private String bhd;
    private Bundle jfZ;
    private Req jga;
    private String jgb;
    private int jgc = 0;

    static /* synthetic */ int b(FavOpenApiEntry favOpenApiEntry) {
        int i = favOpenApiEntry.jgc + 1;
        favOpenApiEntry.jgc = i;
        return i;
    }

    static /* synthetic */ void b(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage == null) {
            x.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = wXMediaMessage.getType();
        g gVar;
        vx vxVar;
        switch (type) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (!bi.oW(wXTextObject.text)) {
                    gVar = new g();
                    gVar.field_type = 1;
                    a(wXMediaMessage, gVar);
                    gVar.field_favProto.Vv(wXTextObject.text);
                    favOpenApiEntry.H(gVar);
                    b.B(gVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addText null!");
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || e.cn(wXImageObject.imagePath)) {
                    gVar = new g();
                    gVar.field_type = 2;
                    a(wXMediaMessage, gVar);
                    favOpenApiEntry.H(gVar);
                    gVar.field_favProto.rBI.add(a(wXMediaMessage, wXImageObject.imagePath, wXImageObject.imageData, gVar.field_type));
                    b.B(gVar);
                    break;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) wXMediaMessage.mediaObject;
                if (!bi.oW(wXMusicObject.musicDataUrl) || !bi.oW(wXMusicObject.musicUrl) || !bi.oW(wXMusicObject.musicLowBandUrl)) {
                    gVar = new g();
                    gVar.field_type = 7;
                    a(wXMediaMessage, gVar);
                    vxVar = new vx();
                    vxVar.UH(wXMusicObject.musicUrl);
                    vxVar.UJ(wXMusicObject.musicLowBandUrl);
                    vxVar.UI(wXMusicObject.musicDataUrl);
                    vxVar.UB(wXMediaMessage.title);
                    vxVar.UC(wXMediaMessage.description);
                    a(wXMediaMessage, vxVar, gVar.field_type);
                    vxVar.kX(true);
                    vxVar.CF(gVar.field_type);
                    gVar.field_favProto.rBI.add(vxVar);
                    favOpenApiEntry.H(gVar);
                    b.B(gVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addMusic, both url null");
                break;
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) wXMediaMessage.mediaObject;
                if (!bi.oW(wXVideoObject.videoLowBandUrl) || !bi.oW(wXVideoObject.videoUrl)) {
                    gVar = new g();
                    gVar.field_type = 4;
                    a(wXMediaMessage, gVar);
                    vxVar = new vx();
                    vxVar.UH(wXVideoObject.videoUrl);
                    vxVar.UJ(wXVideoObject.videoLowBandUrl);
                    vxVar.UB(wXMediaMessage.title);
                    vxVar.UC(wXMediaMessage.description);
                    a(wXMediaMessage, vxVar, gVar.field_type);
                    vxVar.kX(true);
                    vxVar.CF(gVar.field_type);
                    gVar.field_favProto.rBI.add(vxVar);
                    favOpenApiEntry.H(gVar);
                    b.B(gVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addVideo, both url null");
                break;
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                if (!bi.oW(wXWebpageObject.webpageUrl)) {
                    gVar = new g();
                    gVar.field_sessionId = favOpenApiEntry.getIntent().getStringExtra("reportSessionId");
                    gVar.field_type = 5;
                    a(wXMediaMessage, gVar);
                    favOpenApiEntry.H(gVar);
                    gVar.field_favProto.rBG.VD(wXWebpageObject.webpageUrl);
                    if (wXMediaMessage.thumbData != null) {
                        vx vxVar2 = new vx();
                        vxVar2.UB(wXMediaMessage.title);
                        vxVar2.UC(wXMediaMessage.description);
                        a(wXMediaMessage, vxVar2, gVar.field_type);
                        vxVar2.kX(true);
                        vxVar2.CF(gVar.field_type);
                        gVar.field_favProto.rBI.add(vxVar2);
                    }
                    b.B(gVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addUrl null!");
                break;
            case 6:
                WXFileObject wXFileObject = (WXFileObject) wXMediaMessage.mediaObject;
                if (wXFileObject.fileData == null && !e.cn(wXFileObject.filePath)) {
                    x.e("MicroMsg.FavOpenApiEntry", "addFile data null");
                    break;
                }
                gVar = new g();
                gVar.field_type = 8;
                a(wXMediaMessage, gVar);
                favOpenApiEntry.H(gVar);
                gVar.field_favProto.rBI.add(a(wXMediaMessage, wXFileObject.filePath, wXFileObject.fileData, gVar.field_type));
                b.B(gVar);
                break;
                break;
            default:
                x.e("MicroMsg.FavOpenApiEntry", "unsupport type = " + type);
                break;
        }
        favOpenApiEntry.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.bSk == null) {
            this.bSk = getIntent();
        }
        this.jfZ = this.bSk.getExtras();
        this.appId = this.jfZ.getString("SendAppMessageWrapper_AppId");
        if (this.appId == null) {
            this.appId = Uri.parse(this.jfZ.getString("_mmessage_content")).getQueryParameter("appid");
        }
        this.jga = new Req(this.jfZ);
        if (this.jga.scene != 2) {
            x.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
            finish();
            return;
        }
        this.jgb = getString(R.l.favorite);
        String appName = com.tencent.mm.plugin.fav.a.b.getAppName(this, this.appId);
        this.bhd = getString(R.l.confirm_dialog_source, new Object[]{appName});
        this.bAZ.J(100, 100);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.bSk = intent;
    }

    protected void onResume() {
        super.onResume();
    }

    private static void a(WXMediaMessage wXMediaMessage, g gVar) {
        gVar.field_sourceType = 4;
        gVar.field_favProto.Vu(wXMediaMessage.title);
        gVar.field_favProto.Vv(wXMediaMessage.description);
    }

    private void H(g gVar) {
        wr wrVar = new wr();
        wrVar.VC(this.appId);
        wrVar.CO(4);
        wrVar.Vw(q.GF());
        wrVar.Vx(q.GF());
        gVar.field_fromUser = wrVar.bSS;
        gVar.field_toUser = wrVar.toUser;
        gVar.field_favProto.a(wrVar);
    }

    private static vx a(WXMediaMessage wXMediaMessage, String str, byte[] bArr, int i) {
        vx vxVar = new vx();
        vxVar.UB(wXMediaMessage.title);
        vxVar.UC(wXMediaMessage.description);
        vxVar.CF(i);
        if (str != null) {
            vxVar.UP(str);
            vxVar.UL(e.cp(str));
        } else {
            String u = com.tencent.mm.a.g.u(bArr);
            if (bArr.length >= 256) {
                vxVar.UN(u);
            } else {
                Object obj = new byte[256];
                System.arraycopy(bArr, 0, obj, 0, 256);
                vxVar.UN(com.tencent.mm.a.g.u(obj));
            }
            vxVar.UM(u);
            vxVar.fO((long) bArr.length);
            vxVar.UO(com.tencent.mm.plugin.fav.a.b.bm(vxVar.toString(), i));
            e.e(com.tencent.mm.plugin.fav.a.b.b(vxVar), bArr);
        }
        a(wXMediaMessage, vxVar, i);
        return vxVar;
    }

    private static void a(WXMediaMessage wXMediaMessage, vx vxVar, int i) {
        if (wXMediaMessage.thumbData != null) {
            String u = com.tencent.mm.a.g.u(wXMediaMessage.thumbData);
            vxVar.UR(u);
            if (wXMediaMessage.thumbData.length >= 256) {
                vxVar.US(u);
            } else {
                Object obj = new byte[256];
                System.arraycopy(wXMediaMessage.thumbData, 0, obj, 0, 256);
                vxVar.US(com.tencent.mm.a.g.u(obj));
            }
            if (bi.oW(vxVar.jdM)) {
                vxVar.UO(com.tencent.mm.plugin.fav.a.b.bm(vxVar.toString(), i));
            }
            vxVar.fP((long) wXMediaMessage.thumbData.length);
            e.e(com.tencent.mm.plugin.fav.a.b.c(vxVar), wXMediaMessage.thumbData);
            return;
        }
        vxVar.kY(true);
    }

    private com.tencent.mm.pluginsdk.ui.applet.q.a a(final WXMediaMessage wXMediaMessage) {
        return new com.tencent.mm.pluginsdk.ui.applet.q.a() {
            public final void a(boolean z, String str, int i) {
                if (z) {
                    FavOpenApiEntry.b(FavOpenApiEntry.this, wXMediaMessage);
                    ReportUtil.a(FavOpenApiEntry.this, ReportUtil.c(FavOpenApiEntry.this.getIntent().getExtras(), 0));
                    return;
                }
                FavOpenApiEntry.this.finish();
                ReportUtil.a(FavOpenApiEntry.this, ReportUtil.c(FavOpenApiEntry.this.getIntent().getExtras(), -2));
            }
        };
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
