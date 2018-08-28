package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.protocal.c.arw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class ad$1 implements a {
    final /* synthetic */ ad pRM;

    ad$1(ad adVar) {
        this.pRM = adVar;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
    }

    public final byte[] i(String str, byte[] bArr) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[]{str});
        return null;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        String str2;
        WebViewJSSDKFileItem webViewJSSDKFileItem;
        String str3 = "MicroMsg.WebviewFileChooserCdnService";
        String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = keep_progressinfo == null ? "null" : keep_progressinfo.toString();
        if (keep_sceneresult == null) {
            str2 = "null";
        } else {
            str2 = keep_sceneresult.toString();
        }
        objArr[3] = str2;
        x.i(str3, str4, objArr);
        ae bUX = e.bUX();
        if (!bi.oW(str)) {
            for (WebViewJSSDKFileItem webViewJSSDKFileItem2 : bUX.pRP.values()) {
                if (bi.oV(webViewJSSDKFileItem2.mediaId).equals(str)) {
                    webViewJSSDKFileItem = webViewJSSDKFileItem2;
                    break;
                }
            }
        }
        x.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
        webViewJSSDKFileItem = null;
        if (webViewJSSDKFileItem == null) {
            x.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", new Object[]{str});
            return 0;
        } else if (i == -21005) {
            x.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", new Object[]{str});
            return 0;
        } else if (i != 0) {
            x.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
            ad.a(this.pRM, false, webViewJSSDKFileItem.bNH, webViewJSSDKFileItem.mediaId, null);
            return 0;
        } else if (keep_progressinfo != null) {
            x.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", new Object[]{keep_progressinfo.toString()});
            int i2 = 0;
            if (keep_progressinfo.field_toltalLength > 0) {
                i2 = (keep_progressinfo.field_finishedLength * 100) / keep_progressinfo.field_toltalLength;
            }
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > 100) {
                i2 = 100;
            }
            this.pRM.b(webViewJSSDKFileItem.fnP, webViewJSSDKFileItem.bMT, i2, webViewJSSDKFileItem.bNH, webViewJSSDKFileItem.mediaId);
            return 0;
        } else {
            if (keep_sceneresult != null) {
                if (keep_sceneresult.field_retCode != 0) {
                    x.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{str, Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult});
                    ad.a(this.pRM, false, webViewJSSDKFileItem.bNH, webViewJSSDKFileItem.mediaId, null);
                } else {
                    x.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s", new Object[]{str});
                    if (webViewJSSDKFileItem != null) {
                        webViewJSSDKFileItem.c(keep_sceneresult);
                        if (webViewJSSDKFileItem.fnP && webViewJSSDKFileItem.fnR) {
                            ad adVar = this.pRM;
                            if (webViewJSSDKFileItem == null) {
                                x.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                            } else {
                                arw arw = new arw();
                                arw.rUt = webViewJSSDKFileItem.pRN.field_aesKey;
                                arw.rqN = webViewJSSDKFileItem.pRN.field_fileLength;
                                arw.rUs = webViewJSSDKFileItem.pRN.field_fileId;
                                arw.type = webViewJSSDKFileItem.bUj();
                                x.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", new Object[]{webViewJSSDKFileItem.appId, webViewJSSDKFileItem.bNH, arw.rUt, Integer.valueOf(arw.rqN), arw.rUs});
                                arw.rUu = webViewJSSDKFileItem.bUi();
                                au.DF().a(1034, adVar);
                                au.DF().a(new x(webViewJSSDKFileItem.appId, webViewJSSDKFileItem.bNH, arw), 0);
                            }
                        } else {
                            ad.a(this.pRM, true, webViewJSSDKFileItem.bNH, webViewJSSDKFileItem.fnN, webViewJSSDKFileItem.pRN.field_fileUrl);
                        }
                    }
                }
            }
            return 0;
        }
    }
}
