package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.b;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

class FreeWifiManufacturerLoadingUI$5 implements Runnable {
    final /* synthetic */ String jjh;
    final /* synthetic */ FreeWifiManufacturerLoadingUI jnE;
    private int jnG = 0;
    private final int jnH = 5;

    FreeWifiManufacturerLoadingUI$5(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, String str) {
        this.jnE = freeWifiManufacturerLoadingUI;
        this.jjh = str;
    }

    public final void run() {
        Context context = ad.getContext();
        if (context == null) {
            FreeWifiManufacturerLoadingUI.a(this.jnE, 1151, "Wechat hasn't started completely. Wait 5 seconds and retry.");
            return;
        }
        if (!(m.aOh() && m.BS("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(this.jjh))) {
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "It starts to connect portal ssid " + this.jjh);
            FreeWifiManufacturerLoadingUI.a(this.jnE, this.jnE.getString(R.l.free_wifi_manufacturer_loading_switching_ssid));
            int aNP = new b(this.jjh, context).aNP();
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "connectRet=" + aNP);
            if (aNP != 0) {
                FreeWifiManufacturerLoadingUI.a(this.jnE, aNP, "An attempt to switch to special portal ap failed. connectRet=" + aNP);
                return;
            }
        }
        aPH();
    }

    private void aPG() {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "_httpRequestForPortalUrl retry.");
        this.jnG++;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            x.e("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "sleep exception. " + e.getMessage());
        }
        aPH();
    }

    private void aPH() {
        Exception e;
        Throwable th;
        String aNX = h.b.aNY().aNX();
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http request url : " + aNX);
        FreeWifiManufacturerLoadingUI.a(this.jnE, this.jnE.getString(R.l.free_wifi_manufacturer_loading_getting_portal_url));
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(aNX).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(Downloads.MIN_RETYR_AFTER);
                    httpURLConnection2.setReadTimeout(Downloads.MIN_RETYR_AFTER);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                    httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                    int responseCode = httpURLConnection2.getResponseCode();
                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http resp code = " + responseCode);
                    if (200 == responseCode) {
                        if (m.BS("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(this.jjh)) {
                            String r = FreeWifiManufacturerLoadingUI.r(httpURLConnection2.getInputStream());
                            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body first line content=" + r);
                            if (r.indexOf("wxwifiecho") == -1) {
                                FreeWifiManufacturerLoadingUI.b(this.jnE, aNX);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            }
                            FreeWifiManufacturerLoadingUI.a(this.jnE, 0, "");
                            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "already connected.");
                            FreeWifiManufacturerLoadingUI.a(this.jnE, 0, "");
                            FreeWifiManufacturerLoadingUI.a(this.jnE, this.jnE.getString(R.l.free_wifi_manufacturer_loading_already_connected));
                            FreeWifiManufacturerLoadingUI.e(this.jnE);
                            FreeWifiManufacturerLoadingUI.f(this.jnE);
                        } else {
                            FreeWifiManufacturerLoadingUI.a(this.jnE, 1150, "Target ssid is not connected.");
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    } else if (TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY == responseCode) {
                        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "desc=http response 302 location = %s", new Object[]{httpURLConnection2.getHeaderField("Location")});
                        aNX = httpURLConnection2.getHeaderField("Location");
                        if (m.isEmpty(aNX)) {
                            FreeWifiManufacturerLoadingUI.a(this.jnE, 1146, "AP cannot response portal url properly.");
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                                return;
                            }
                            return;
                        }
                        FreeWifiManufacturerLoadingUI.b(this.jnE, aNX);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    } else {
                        FreeWifiManufacturerLoadingUI.a(this.jnE, 1149, "Ap response code is neither 200 nor 302.");
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection is null. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.jnG), Integer.valueOf(5)});
            if (this.jnG < 5) {
                aPG();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    return;
                }
                return;
            }
            FreeWifiManufacturerLoadingUI.a(this.jnE, 1148, "An attempt to connect to ap failed.");
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Exception e3) {
            e = e3;
            try {
                Writer stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ping encounter exception. " + stringWriter.toString());
                if (e instanceof UnknownHostException) {
                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection throws exception. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.jnG), Integer.valueOf(5)});
                    if (this.jnG < 5) {
                        aPG();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                }
                FreeWifiManufacturerLoadingUI.a(this.jnE, 1153, "An attempt to connect to ap failed.");
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }
}
