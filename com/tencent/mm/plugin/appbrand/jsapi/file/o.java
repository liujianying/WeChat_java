package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;

public final class o extends a {
    private static final int CTRL_INDEX = 278;
    private static final String NAME = "getFileInfo";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String str;
        String str2 = lVar.mAppId;
        String optString = jSONObject.optString("filePath", "");
        if ("sha1".equalsIgnoreCase(jSONObject.optString("digestAlgorithm", "md5"))) {
            str = "sha1";
        } else {
            str = "md5";
        }
        if (bi.oW(optString)) {
            lVar.E(i, f("fail:invalid data", null));
        } else {
            e.post(new 1(this, str2, optString, lVar, i, str), "AppBrandJsApiGetFileInfo");
        }
    }

    static String B(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            try {
                InputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    String bigInteger;
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            instance.update(bArr, 0, read);
                        } else {
                            bigInteger = new BigInteger(1, instance.digest()).toString(16);
                            try {
                                fileInputStream.close();
                                return bigInteger;
                            } catch (IOException e) {
                                x.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", new Object[]{e});
                                return bigInteger;
                            }
                        }
                    } catch (IOException e2) {
                        bigInteger = "";
                        try {
                            fileInputStream.close();
                            return bigInteger;
                        } catch (IOException e3) {
                            x.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", new Object[]{e3});
                            return bigInteger;
                        }
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e32) {
                            x.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", new Object[]{e32});
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException e4) {
                x.e("MicroMsg.JsApiGetFileInfo", "Exception while getting FileInputStream", new Object[]{e4});
                return "";
            }
        } catch (NoSuchAlgorithmException e5) {
            x.e("MicroMsg.JsApiGetFileInfo", "Exception while getting Digest", new Object[]{e5});
            return "";
        }
    }
}
