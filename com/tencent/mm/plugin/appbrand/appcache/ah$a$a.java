package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.model.am;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.appcache.ah.c;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import javax.net.ssl.SSLException;

abstract class ah$a$a implements a {
    private final c fhn;

    abstract void b(m mVar);

    ah$a$a(c cVar) {
        this.fhn = cVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i != 0) {
            b(new m(this.fhn, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[]{this.fhn.cco(), Integer.valueOf(i)})), 3));
            x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[]{this.fhn.cco(), Integer.valueOf(i)});
            return 0;
        } else if (keep_progressinfo != null) {
            com.tencent.mm.pluginsdk.g.a.c.c cVar = this.fhn.qDp;
            if (cVar != null) {
                cVar.a(this.fhn.cco(), new WxaPkgLoadProgress((int) ((((float) keep_progressinfo.field_finishedLength) / ((float) keep_progressinfo.field_toltalLength)) * 100.0f), (long) keep_progressinfo.field_finishedLength, (long) keep_progressinfo.field_toltalLength));
            }
            return 0;
        } else {
            if (keep_sceneresult != null) {
                x.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s", new Object[]{this.fhn.cco(), Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_httpResponseHeader});
                if (keep_sceneresult.field_retCode != 0) {
                    m mVar;
                    if (keep_sceneresult.field_fileLength <= 0 || this.fhn.bM((long) keep_sceneresult.field_fileLength)) {
                        mVar = new m(this.fhn, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[]{this.fhn.cco(), Integer.valueOf(keep_sceneresult.field_retCode)})), keep_sceneresult.field_httpStatusCode, 3);
                    } else {
                        mVar = new m(this.fhn, new com.tencent.mm.pluginsdk.g.a.b.a(), keep_sceneresult.field_httpStatusCode, 3);
                    }
                    b(mVar);
                } else {
                    b(new m(this.fhn, (long) keep_sceneresult.field_fileLength, null));
                    int cm = e.cm(this.fhn.abZ().getFilePath());
                    if (am.a.dBs != null) {
                        am.a.dBs.aY(cm, 0);
                    }
                }
            }
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
