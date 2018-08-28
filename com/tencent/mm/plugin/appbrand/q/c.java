package com.tencent.mm.plugin.appbrand.q;

import android.webkit.URLUtil;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public final class c {
    public static String convertStreamToString(InputStream inputStream) {
        Closeable inputStreamReader = new InputStreamReader(inputStream);
        String str = new char[GLIcon.LEFT];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            try {
                int read = inputStreamReader.read(str);
                if (-1 == read) {
                    break;
                }
                stringWriter.write(str, 0, read);
            } catch (Exception e) {
                stringWriter = "MicroMsg.AppBrandIOUtil";
                x.e(stringWriter, "convertStreamToString: read, %s", new Object[]{e.getMessage()});
                str = "";
                return str;
            } finally {
                bi.d(inputStreamReader);
                bi.d(inputStream);
            }
        }
        return stringWriter.toString();
    }

    public static String vM(String str) {
        InputStream inputStream = null;
        try {
            inputStream = ad.getContext().getAssets().open(str);
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[]{str, bi.i(e)});
        }
        if (inputStream == null) {
            return "";
        }
        return convertStreamToString(inputStream);
    }

    public static byte[] p(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[GLIcon.LEFT];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, GLIcon.LEFT);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandIOUtil", "readPkgCertificate: " + e);
                byte[] bArr2 = new byte[0];
                try {
                    inputStream.close();
                    return bArr2;
                } catch (Exception e2) {
                    x.e("MicroMsg.AppBrandIOUtil", "close: " + e2);
                    return bArr2;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception e22) {
                    x.e("MicroMsg.AppBrandIOUtil", "close: " + e22);
                }
                throw th;
            }
        }
        byteArrayOutputStream.flush();
        try {
            inputStream.close();
        } catch (Exception e222) {
            x.e("MicroMsg.AppBrandIOUtil", "close: " + e222);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean vN(String str) {
        return !bi.oW(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public static byte[] k(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return new byte[0];
        }
        if (!byteBuffer.isDirect()) {
            return byteBuffer.array();
        }
        int position = byteBuffer.position();
        byteBuffer.position(0);
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return bArr;
    }
}
