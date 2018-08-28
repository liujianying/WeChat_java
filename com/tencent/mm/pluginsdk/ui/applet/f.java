package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.ak.a.b.e;
import com.tencent.mm.ak.a.c.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f implements b {
    private final byte[] qIv;

    public f() {
        g.Eg().Ds();
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        this.qIv = com.tencent.mm.a.g.v(stringBuilder.append(a.Dg()).append("mmbiz").toString().getBytes());
    }

    public final com.tencent.mm.ak.a.d.b mb(String str) {
        x.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", str);
        try {
            com.tencent.mm.ak.a.d.b bVar;
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            if (q.lY(str)) {
                httpURLConnection.setRequestProperty("Referer", q.hZ(d.qVN));
            }
            if (httpURLConnection.getResponseCode() >= l.CTRL_BYTE || com.tencent.mm.modelcdntran.d.c(httpURLConnection) != 0) {
                httpURLConnection.disconnect();
                x.w("MicroMsg.ChattingBizImgDownloader.HttpClientFactory", "httpURLConnectionGet 300");
                bVar = null;
            } else {
                InputStream inputStream = httpURLConnection.getInputStream();
                bVar = new com.tencent.mm.ak.a.d.b(e.m(inputStream), httpURLConnection.getContentType(), (byte) 0);
            }
            if (bVar == null) {
                return bVar;
            }
            boolean z;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (q.Pn() && !bi.oW(bVar.aBC) && q.lY(str) && bVar.aBC.equals("image/webp")) {
                z = true;
            } else {
                z = false;
            }
            x.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b", Boolean.valueOf(z));
            long j = currentTimeMillis2 - currentTimeMillis;
            x.d("MicroMsg.ChattingBizImgDownloader", "download used %d ms", Long.valueOf(j));
            h.mEJ.a(86, 4, j, false);
            if (!z) {
                return bVar;
            }
            h.mEJ.a(86, 17, j, false);
            return bVar;
        } catch (Exception e) {
            x.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", e.toString());
            return new com.tencent.mm.ak.a.d.b(null, null, (byte) 0);
        }
    }
}
