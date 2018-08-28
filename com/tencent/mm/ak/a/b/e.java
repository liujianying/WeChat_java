package com.tencent.mm.ak.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.ak.a.c.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e implements k {
    public final boolean ap(String str, String str2) {
        if (bi.oW(str2)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
            return false;
        } else if (bi.oW(str)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            String cu = g.cu(str2);
            if (bi.oW(cu) || !cu.equals(str)) {
                x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[]{cu, str});
                return false;
            }
            x.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
            return true;
        }
    }

    public final boolean j(String str, byte[] bArr) {
        if (bi.oW(str)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        }
        String t = ac.t(bArr);
        if (bi.oW(t) || !t.equals(str)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[]{t, str});
            return false;
        }
        x.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        return true;
    }

    public final boolean b(String str, InputStream inputStream) {
        if (inputStream == null) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
            return false;
        } else if (bi.oW(str)) {
            x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            try {
                String t = ac.t(a(inputStream, true));
                if (bi.oW(t) || !t.equals(str)) {
                    x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[]{t, str});
                    return false;
                }
                x.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
                return true;
            } catch (Exception e) {
                x.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + e.toString());
                return false;
            }
        }
    }

    public static byte[] m(InputStream inputStream) {
        return a(inputStream, false);
    }

    public static byte[] a(InputStream inputStream, boolean z) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (!z) {
            inputStream.close();
        }
        return bArr;
    }
}
