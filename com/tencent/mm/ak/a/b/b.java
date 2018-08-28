package com.tencent.mm.ak.a.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class b implements com.tencent.mm.ak.a.c.b {
    public final com.tencent.mm.ak.a.d.b mb(String str) {
        x.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[]{str});
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(20000);
            if (httpURLConnection == null) {
                x.i("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= 300) {
                httpURLConnection.disconnect();
                x.w("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String contentType = httpURLConnection.getContentType();
            byte[] m = e.m(inputStream);
            httpURLConnection.disconnect();
            return new com.tencent.mm.ak.a.d.b(m, contentType);
        } catch (Throwable e) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bi.i(e)});
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (Throwable e2) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bi.i(e2)});
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (Throwable e22) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bi.i(e22)});
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (Throwable e222) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bi.i(e222)});
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (Throwable e2222) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bi.i(e2222)});
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (Throwable e22222) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bi.i(e22222)});
            return new com.tencent.mm.ak.a.d.b(null, null);
        } catch (Throwable e222222) {
            x.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[]{bi.i(e222222)});
            return new com.tencent.mm.ak.a.d.b(null, null);
        }
    }
}
