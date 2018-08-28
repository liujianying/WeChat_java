package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.a.l;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e$a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class u$6 implements Runnable {
    final /* synthetic */ u tKV;

    u$6(u uVar) {
        this.tKV = uVar;
    }

    public final void run() {
        Throwable e;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.tKV.mim).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.connect();
                this.tKV.mio = httpURLConnection2.getHeaderField("Location");
                InputStream inputStream = httpURLConnection2.getInputStream();
                int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                if (headerFieldInt <= 0) {
                    x.e("MicroMsg.ChattingQQMailFooterHandler", "error content-length");
                    inputStream.close();
                } else {
                    byte[] bArr = new byte[headerFieldInt];
                    inputStream.read(bArr);
                    inputStream.close();
                    byte[] a = l.a(Base64.decode(bArr, 0), l.p(this.tKV.mContext, "rsa_public_key_forwx.pem"));
                    this.tKV.mip = new String(a);
                    ah.A(new Runnable() {
                        public final void run() {
                            if (bi.oW(u$6.this.tKV.mio) || bi.oW(u$6.this.tKV.mip)) {
                                u.a(u$6.this.tKV);
                                return;
                            }
                            u uVar = u$6.this.tKV;
                            x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[downloadQQMail]");
                            e$a e_a = new e$a();
                            e_a.yQ(uVar.mio);
                            e_a.yS(uVar.mContext.getResources().getString(R.l.download_qqmail_apk_file_name));
                            e_a.yT(uVar.mip);
                            e_a.ef(true);
                            e_a.ox(1);
                            uVar.iyn = d.aCU().a(e_a.ick);
                            if (uVar.iyn > 0) {
                                uVar.duR = uVar.mContext.getSharedPreferences("QQMAIL", 4);
                                uVar.duR.edit().putLong("qqmail_downloadid", uVar.iyn).apply();
                                uVar.ctT();
                            }
                        }
                    });
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = httpURLConnection2;
            } catch (Throwable th) {
                e = th;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw e;
            }
        } catch (Throwable e3) {
            e = e3;
            try {
                x.printErrStackTrace("MicroMsg.ChattingQQMailFooterHandler", e, "", new Object[0]);
                u.a(this.tKV);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable e32) {
                e = e32;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw e;
            }
        }
    }
}
