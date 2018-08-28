package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.a.a$a;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.ui.f.a.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class g$2 implements a$a {
    final /* synthetic */ g eOc;

    g$2(g gVar) {
        this.eOc = gVar;
    }

    public final void pF(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
            g.a(this.eOc, 1, "response is null or nil");
        } else if (!str.contains("access_token") || str.length() <= 12) {
            try {
                e.aaX(str);
            } catch (Throwable e) {
                x.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + e.getMessage());
                x.printErrStackTrace("MicroMsg.RefreshTokenRunner", e, "", new Object[0]);
            } catch (d e2) {
                String str2 = "errCode = " + e2.mErrorCode + ", errType = " + e2.utw + ", errMsg = " + e2.getMessage();
                x.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, " + str2);
                x.printErrStackTrace("MicroMsg.RefreshTokenRunner", e2, "", new Object[0]);
                g.a(this.eOc, 3, str2);
                return;
            }
            g.a(this.eOc, 2, "parseJson error");
        } else {
            try {
                JSONObject aaX = e.aaX(str);
                if (aaX.has("access_token")) {
                    Bundle bundle = new Bundle();
                    Iterator keys = aaX.keys();
                    while (keys.hasNext()) {
                        String str3 = (String) keys.next();
                        JSONArray optJSONArray = aaX.optJSONArray(str3);
                        Double valueOf = Double.valueOf(aaX.optDouble(str3));
                        String optString = aaX.optString(str3);
                        if (optJSONArray == null || optJSONArray.length() > 0) {
                            int i;
                            if (optJSONArray != null) {
                                if (!Double.isNaN(optJSONArray.optDouble(0))) {
                                    double[] dArr = new double[optJSONArray.length()];
                                    for (i = 0; i < optJSONArray.length(); i++) {
                                        dArr[i] = optJSONArray.optDouble(i);
                                    }
                                    bundle.putDoubleArray(str3, dArr);
                                }
                            }
                            if (optJSONArray != null && optJSONArray.optString(0) != null) {
                                String[] strArr = new String[optJSONArray.length()];
                                for (i = 0; i < optJSONArray.length(); i++) {
                                    strArr[i] = optJSONArray.optString(i);
                                }
                                bundle.putStringArray(str3, strArr);
                            } else if (!valueOf.isNaN()) {
                                bundle.putDouble(str3, valueOf.doubleValue());
                            } else if (optString != null) {
                                bundle.putString(str3, optString);
                            } else {
                                System.err.println("unable to transform json to bundle " + str3);
                            }
                        } else {
                            bundle.putStringArray(str3, new String[0]);
                        }
                    }
                    g gVar = this.eOc;
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.setData(bundle);
                    gVar.handler.sendMessage(obtain);
                    return;
                }
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.RefreshTokenRunner", e3, "", new Object[0]);
            }
            g.a(this.eOc, 2, "decodeUrl fail");
        }
    }

    public final void b(IOException iOException) {
        x.e("MicroMsg.RefreshTokenRunner", "onIOException");
        g.a(this.eOc, 2, iOException.getMessage());
    }

    public final void a(FileNotFoundException fileNotFoundException) {
        x.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
        g.a(this.eOc, 2, fileNotFoundException.getMessage());
    }

    public final void a(MalformedURLException malformedURLException) {
        x.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
        g.a(this.eOc, 2, malformedURLException.getMessage());
    }
}
