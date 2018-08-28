package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

class b$1 implements a {
    final /* synthetic */ b fnW;

    b$1(b bVar) {
        this.fnW = bVar;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        x.i("MicroMsg.AppbrandCdnService", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
    }

    public final byte[] i(String str, byte[] bArr) {
        x.i("MicroMsg.AppbrandCdnService", "decodePrepareResponse, mediaId = %s", new Object[]{str});
        return null;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        String str2;
        a aVar;
        String str3 = "MicroMsg.AppbrandCdnService";
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
        c abk = e.abk();
        if (!bi.oW(str)) {
            for (a aVar2 : abk.fnX.values()) {
                if (bi.oV(aVar2.mediaId).equals(str)) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        x.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByMediaID error, media id is null or nil");
        aVar = null;
        if (aVar == null) {
            x.e("MicroMsg.AppbrandCdnService", "get item by media id failed, media is : %s", new Object[]{str});
            return 0;
        } else if (i == -21005) {
            x.i("MicroMsg.AppbrandCdnService", "duplicate request, ignore this request, media id is %s", new Object[]{str});
            return 0;
        } else if (i != 0) {
            x.e("MicroMsg.AppbrandCdnService", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
            b.a(this.fnW, false, aVar.bNH, aVar.mediaId, null);
            return 0;
        } else if (keep_progressinfo != null) {
            int i2;
            x.i("MicroMsg.AppbrandCdnService", "progressInfo : %s", new Object[]{keep_progressinfo.toString()});
            int i3 = 0;
            if (keep_progressinfo.field_toltalLength > 0) {
                i3 = (keep_progressinfo.field_finishedLength * 100) / keep_progressinfo.field_toltalLength;
            }
            if (i3 < 0) {
                i2 = 0;
            } else if (i3 > 100) {
                i2 = 100;
            } else {
                i2 = i3;
            }
            b bVar = this.fnW;
            boolean z2 = aVar.fnP;
            int i4 = aVar.bMT;
            String str5 = aVar.bNH;
            str4 = aVar.mediaId;
            x.i("MicroMsg.AppbrandCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i2), str5, str4});
            if (bVar.fnT != null && bVar.fnT.size() > 0) {
                Iterator it = bVar.fnT.iterator();
                while (it.hasNext()) {
                    ((d.a) it.next()).B(i2, str5);
                }
            }
            return 0;
        } else {
            if (keep_sceneresult != null) {
                if (keep_sceneresult.field_retCode != 0) {
                    x.e("MicroMsg.AppbrandCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{str, Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult});
                    b.a(this.fnW, false, aVar.bNH, aVar.mediaId, null);
                } else {
                    x.i("MicroMsg.AppbrandCdnService", "cdn trans suceess, media id : %s", new Object[]{str});
                    if (aVar != null) {
                        if (aVar.fnO == null) {
                            aVar.fnO = new a.a();
                        }
                        if (keep_sceneresult == null) {
                            x.e("MicroMsg.AppBrandMediaCdnItem", "sceneResult info is null");
                        } else {
                            aVar.fnO.field_aesKey = keep_sceneresult.field_aesKey;
                            aVar.fnO.field_fileId = keep_sceneresult.field_fileId;
                            aVar.fnO.field_fileUrl = keep_sceneresult.field_fileUrl;
                            aVar.fnO.field_fileLength = keep_sceneresult.field_fileLength;
                            aVar.fnN = aVar.fnO.field_fileId;
                        }
                        e.abk().a(aVar);
                        b.a(this.fnW, true, aVar.bNH, aVar.fnN, aVar.fnO.field_fileUrl);
                    }
                }
            }
            return 0;
        }
    }
}
