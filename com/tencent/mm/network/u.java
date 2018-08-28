package com.tencent.mm.network;

import com.tencent.mm.hardcoder.HardCoderJNI;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class u {
    private Map<String, List<String>> aBE = null;
    public HttpURLConnection aBv;
    public int erZ;
    public String esW;
    public URL url;

    public u(URL url, int i) {
        this.url = url;
        this.erZ = i;
        this.aBv = (HttpURLConnection) this.url.openConnection();
        if (1 == this.erZ) {
            this.aBv.setInstanceFollowRedirects(false);
        }
    }

    public final int getResponseCode() {
        int responseCode;
        while (true) {
            if (1 == this.erZ && this.aBE == null) {
                this.aBE = this.aBv.getRequestProperties();
            }
            responseCode = this.aBv.getResponseCode();
            if (1 != this.erZ || HardCoderJNI.SCENE_QUIT_CHATTING != responseCode) {
                break;
            }
            String headerField = this.aBv.getHeaderField("Location");
            if (headerField == null) {
                break;
            }
            this.url = new URL(this.url, headerField);
            this.aBv = (HttpURLConnection) this.url.openConnection();
            this.aBv.setInstanceFollowRedirects(false);
            if (this.aBE != null) {
                for (String str : this.aBE.keySet()) {
                    if (!(str.equals("Host") || str.equals("X-Online-Host"))) {
                        List list = (List) this.aBE.get(str);
                        for (int i = 0; i < list.size(); i++) {
                            this.aBv.setRequestProperty(str, (String) list.get(i));
                        }
                    }
                }
            }
            this.aBv.setRequestProperty("Host", this.url.getHost());
            this.aBv.setRequestProperty("X-Online-Host", this.url.getHost());
        }
        return responseCode;
    }

    public final void setRequestMethod(String str) {
        this.aBv.setRequestMethod(str);
    }

    public final void connect() {
        if (1 == this.erZ && this.aBE == null) {
            this.aBE = this.aBv.getRequestProperties();
        }
        this.aBv.connect();
    }

    public final Map<String, List<String>> getHeaderFields() {
        if (1 == this.erZ && this.aBE == null) {
            this.aBE = this.aBv.getRequestProperties();
        }
        return this.aBv.getHeaderFields();
    }

    public final String getHeaderField(String str) {
        if (1 == this.erZ && this.aBE == null) {
            this.aBE = this.aBv.getRequestProperties();
        }
        return this.aBv.getHeaderField(str);
    }

    public final InputStream getInputStream() {
        if (1 == this.erZ) {
            if (this.aBE == null) {
                this.aBE = this.aBv.getRequestProperties();
            }
            getResponseCode();
        }
        return this.aBv.getInputStream();
    }

    public final OutputStream getOutputStream() {
        if (1 == this.erZ) {
            if (this.aBE == null) {
                this.aBE = this.aBv.getRequestProperties();
            }
            getResponseCode();
        }
        return this.aBv.getOutputStream();
    }

    public final void UI() {
        this.aBv.setDoInput(true);
    }

    public final void UJ() {
        this.aBv.setDoOutput(true);
    }

    public final void setRequestProperty(String str, String str2) {
        this.aBv.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.aBv.setUseCaches(z);
    }

    public final void setConnectTimeout(int i) {
        this.aBv.setConnectTimeout(i);
    }

    public final void setReadTimeout(int i) {
        this.aBv.setReadTimeout(i);
    }

    public final void oz(String str) {
        this.aBv.setRequestProperty("Referer", str);
    }

    public final String toString() {
        return this.aBv.toString();
    }
}
