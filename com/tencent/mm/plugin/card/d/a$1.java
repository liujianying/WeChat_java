package com.tencent.mm.plugin.card.d;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;

class a$1 implements a {
    final /* synthetic */ String eni;
    final /* synthetic */ String ewx;

    a$1(String str, String str2) {
        this.eni = str;
        this.ewx = str2;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        int i2;
        WeakReference weakReference;
        a.a aVar;
        if (i == -21005) {
            x.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", new Object[]{str});
        } else if (i != 0) {
            x.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
            for (i2 = 0; i2 < a.KC().size(); i2++) {
                weakReference = (WeakReference) a.KC().get(i2);
                if (weakReference != null) {
                    aVar = (a.a) weakReference.get();
                    if (aVar != null) {
                        aVar.fail(this.eni);
                    }
                }
            }
        } else if (keep_progressinfo != null) {
            x.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", new Object[]{keep_progressinfo.toString()});
            if (keep_progressinfo.field_toltalLength > 0) {
                i2 = (keep_progressinfo.field_finishedLength * 100) / keep_progressinfo.field_toltalLength;
            } else {
                i2 = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > 100) {
                i2 = 100;
            }
            for (int i3 = 0; i3 < a.KC().size(); i3++) {
                weakReference = (WeakReference) a.KC().get(i3);
                if (weakReference != null) {
                    aVar = (a.a) weakReference.get();
                    if (aVar != null) {
                        aVar.aY(this.eni, i2);
                    }
                }
            }
        } else if (keep_sceneresult != null) {
            if (keep_sceneresult.field_retCode != 0) {
                x.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", new Object[]{str, Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult});
                for (i2 = 0; i2 < a.KC().size(); i2++) {
                    weakReference = (WeakReference) a.KC().get(i2);
                    if (weakReference != null) {
                        aVar = (a.a) weakReference.get();
                        if (aVar != null) {
                            aVar.fail(this.eni);
                        }
                    }
                }
            } else {
                x.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", new Object[]{keep_sceneresult});
                for (i2 = 0; i2 < a.KC().size(); i2++) {
                    weakReference = (WeakReference) a.KC().get(i2);
                    if (weakReference != null) {
                        aVar = (a.a) weakReference.get();
                        if (aVar != null) {
                            aVar.cf(this.eni, this.ewx);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        x.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
    }

    public final byte[] i(String str, byte[] bArr) {
        x.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", new Object[]{str});
        return null;
    }
}
