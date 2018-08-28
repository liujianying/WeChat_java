package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class v {
    public HttpsURLConnection esX;

    public v(String str) {
        this(new URL(str));
    }

    private v(URL url) {
        this.esX = null;
        try {
            this.esX = (HttpsURLConnection) url.openConnection();
        } catch (Throwable e) {
            x.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", e.getMessage());
            x.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bi.i(e));
        } catch (Throwable e2) {
            x.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", e2.getMessage());
            x.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bi.i(e2));
        } catch (Throwable e22) {
            x.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + e22.getMessage());
            x.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bi.i(e22));
        }
    }

    public final void UK() {
        this.esX.setConnectTimeout(3000);
    }

    public final void UL() {
        this.esX.setReadTimeout(3000);
    }

    public final void UM() {
        this.esX.setUseCaches(true);
    }
}
