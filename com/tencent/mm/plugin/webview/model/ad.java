package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.protocal.c.arw;
import com.tencent.mm.protocal.c.ary;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ad implements e {
    private a dVu = new 1(this);
    private CopyOnWriteArraySet<b> pRK = new CopyOnWriteArraySet();
    private CopyOnWriteArraySet<d.a> pRL = new CopyOnWriteArraySet();

    public final void a(d.a aVar) {
        if (this.pRL != null && aVar != null && !this.pRL.contains(aVar)) {
            this.pRL.add(aVar);
        }
    }

    public final void a(b bVar) {
        if (this.pRK != null && bVar != null) {
            this.pRK.remove(bVar);
        }
    }

    public final void b(d.a aVar) {
        if (this.pRL != null && aVar != null) {
            this.pRL.remove(aVar);
        }
    }

    private void b(boolean z, String str, String str2, String str3) {
        if (this.pRK != null && this.pRK.size() > 0) {
            Iterator it = this.pRK.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(z, str, str2, str3);
            }
        }
    }

    final void b(boolean z, int i, int i2, String str, String str2) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        if (this.pRL != null && this.pRL.size() > 0) {
            Iterator it = this.pRL.iterator();
            while (it.hasNext()) {
                ((d.a) it.next()).a(z, i, i2, str, str2);
            }
        }
    }

    public final boolean a(String str, String str2, b bVar) {
        ae bUX = com.tencent.mm.plugin.webview.modeltools.e.bUX();
        if (!bi.oW(str2)) {
            for (WebViewJSSDKFileItem webViewJSSDKFileItem : bUX.pRP.values()) {
                if (bi.oV(webViewJSSDKFileItem.fnN).equals(str2)) {
                    break;
                }
            }
        }
        x.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
        WebViewJSSDKFileItem webViewJSSDKFileItem2 = null;
        if (webViewJSSDKFileItem2 != null) {
            webViewJSSDKFileItem2.appId = str;
            x.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[]{str, str2, webViewJSSDKFileItem2.bNH});
            bVar.a(true, webViewJSSDKFileItem2.bNH, webViewJSSDKFileItem2.fnN, null);
        } else {
            au.DF().a(1035, this);
            au.DF().a(new g(str, str2), 0);
            this.pRK.add(bVar);
        }
        return true;
    }

    private void a(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        i iVar = new i();
        iVar.dPV = this.dVu;
        iVar.ceW = false;
        iVar.field_mediaId = webViewJSSDKFileItem.mediaId;
        iVar.field_fullpath = webViewJSSDKFileItem.fnM;
        iVar.field_totalLen = webViewJSSDKFileItem.pRN.field_fileLength;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
        iVar.field_fileId = webViewJSSDKFileItem.pRN.field_fileId;
        iVar.field_aesKey = webViewJSSDKFileItem.pRN.field_aesKey;
        iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        x.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[]{Boolean.valueOf(g.ND().b(iVar, -1)), webViewJSSDKFileItem.fnN});
        if (!g.ND().b(iVar, -1)) {
            b(false, null, null, null);
        }
    }

    public final boolean a(String str, String str2, int i, int i2, int i3, b bVar) {
        WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str2);
        if (Qq == null) {
            x.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str2});
            return false;
        }
        Qq.appId = str;
        if (bVar != null) {
            this.pRK.add(bVar);
        }
        if (i2 == 202) {
            Qq.fnR = false;
        }
        Qq.fnP = true;
        i iVar = new i();
        iVar.dPV = this.dVu;
        iVar.ceW = true;
        iVar.field_mediaId = Qq.mediaId;
        iVar.field_fullpath = Qq.fnM;
        iVar.field_fileType = i;
        iVar.field_talker = "weixin";
        iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
        if (i == com.tencent.mm.modelcdntran.b.dOo) {
            iVar.field_needStorage = true;
        } else {
            iVar.field_needStorage = false;
        }
        iVar.field_isStreamMedia = false;
        iVar.field_appType = i2;
        iVar.field_bzScene = i3;
        iVar.field_force_aeskeycdn = true;
        iVar.field_trysafecdn = false;
        x.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[]{Boolean.valueOf(g.ND().c(iVar)), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn), str2});
        return g.ND().c(iVar);
    }

    public final boolean b(String str, String str2, b bVar) {
        return a(str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, bVar);
    }

    public static boolean rq(String str) {
        WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str);
        if (Qq != null) {
            return g.ND().lw(Qq.mediaId);
        }
        x.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str});
        return false;
    }

    public static boolean Qm(String str) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[]{str});
        return g.ND().lx(str);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(lVar.getType())});
        String str2;
        String str3;
        String str4;
        String str5;
        switch (lVar.getType()) {
            case 1034:
                au.DF().b(1034, this);
                x xVar = (x) lVar;
                str2 = ((asc) xVar.diG.dIE.dIL).rUv;
                str3 = xVar.appId;
                str4 = xVar.bNH;
                WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str4);
                String str6 = "MicroMsg.WebviewFileChooserCdnService";
                str5 = "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b";
                Object[] objArr = new Object[4];
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = Boolean.valueOf(Qq == null);
                x.i(str6, str5, objArr);
                if (i != 0 || i2 != 0) {
                    x.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
                    if (Qq != null) {
                        b(false, Qq.bNH, Qq.mediaId, null);
                        return;
                    }
                    return;
                } else if (!bi.oW(str3) && !bi.oW(str2) && Qq != null) {
                    Qq.fnN = str2;
                    b(true, Qq.bMT, 100, Qq.bNH, Qq.fnN);
                    b(true, Qq.bNH, Qq.fnN, Qq.pRN.field_fileUrl);
                    return;
                } else {
                    return;
                }
            case 1035:
                au.DF().b(1035, this);
                if (i == 0 && i2 == 0) {
                    g gVar = (g) lVar;
                    str2 = gVar.appId;
                    str3 = gVar.fnN;
                    arw arw = ((ary) gVar.diG.dIE.dIL).rUw;
                    str5 = "MicroMsg.WebviewFileChooserCdnService";
                    String str7 = "appid = %s, serverId = %s, cdninfo == null ? %b";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = str2;
                    objArr2[1] = str3;
                    objArr2[2] = Boolean.valueOf(arw == null);
                    x.i(str5, str7, objArr2);
                    if (!bi.oW(str2) && !bi.oW(str3) && arw != null) {
                        str4 = arw.type;
                        x.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[]{str4});
                        if (!bi.oW(str4)) {
                            WebViewJSSDKFileItem Qo;
                            if (str4.toLowerCase().equals("voice")) {
                                Qo = WebViewJSSDKFileItem.Qo(aj.Qx(str2));
                            } else if (str4.toLowerCase().equals("video")) {
                                Qo = WebViewJSSDKFileItem.Qp(aj.Qr(bi.VF()));
                            } else {
                                Qo = WebViewJSSDKFileItem.Qn(aj.Qr(bi.VF()));
                            }
                            Qo.fnP = false;
                            Qo.appId = str2;
                            Qo.fnN = str3;
                            if (Qo.pRN == null) {
                                Qo.pRN = new WebViewJSSDKFileItem.a();
                            }
                            if (arw == null) {
                                x.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
                            } else {
                                Qo.pRN.field_aesKey = arw.rUt;
                                Qo.pRN.field_fileId = arw.rUs;
                                Qo.pRN.field_fileLength = arw.rqN;
                            }
                            com.tencent.mm.plugin.webview.modeltools.e.bUX().b(Qo);
                            a(Qo);
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
                b(false, null, null, null);
                return;
            default:
                return;
        }
    }
}
