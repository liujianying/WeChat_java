package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class a {
    private static final String dFS;
    private static ConcurrentMap<String, Boolean> fRv = new ConcurrentHashMap();
    private static Map<String, List<a>> fRw = new HashMap();

    static /* synthetic */ void C(String str, String str2, String str3) {
        Throwable e;
        File file = new File(str3);
        if (file.exists()) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download already exists: %s", new Object[]{str});
            if (br(str2, str3)) {
                bq(str, str3);
                return;
            } else {
                x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download already exists, but md5 not valid. deleted:%b", new Object[]{Boolean.valueOf(file.delete())});
            }
        }
        if (fRv.containsKey(str)) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download ing: %s", new Object[]{str});
            return;
        }
        fRv.put(str, Boolean.valueOf(true));
        Closeable fileOutputStream;
        Closeable bufferedInputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 16384);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    bi.d(fileOutputStream);
                    bi.d(bufferedInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        file.delete();
                        x.printErrStackTrace("MicroMsg.AppBrandLiveFileDownloadHelper", e, "download image url %s ", new Object[]{str});
                        bi.d(fileOutputStream);
                        bi.d(bufferedInputStream);
                        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
                        fRv.remove(str);
                        if (br(str2, str3)) {
                            x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
                            bq(str, null);
                        }
                        bq(str, str3);
                        return;
                    } catch (Throwable th) {
                        e = th;
                        bi.d(fileOutputStream);
                        bi.d(bufferedInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
                file.delete();
                x.printErrStackTrace("MicroMsg.AppBrandLiveFileDownloadHelper", e, "download image url %s ", new Object[]{str});
                bi.d(fileOutputStream);
                bi.d(bufferedInputStream);
                x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
                fRv.remove(str);
                if (br(str2, str3)) {
                    x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
                    bq(str, null);
                }
                bq(str, str3);
                return;
            } catch (Throwable th2) {
                e = th2;
                bufferedInputStream = null;
                bi.d(fileOutputStream);
                bi.d(bufferedInputStream);
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            bufferedInputStream = null;
            file.delete();
            x.printErrStackTrace("MicroMsg.AppBrandLiveFileDownloadHelper", e, "download image url %s ", new Object[]{str});
            bi.d(fileOutputStream);
            bi.d(bufferedInputStream);
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
            fRv.remove(str);
            if (br(str2, str3)) {
                x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
                bq(str, null);
            }
            bq(str, str3);
            return;
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            bufferedInputStream = null;
            bi.d(fileOutputStream);
            bi.d(bufferedInputStream);
            throw e;
        }
        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
        fRv.remove(str);
        if (br(str2, str3)) {
            bq(str, str3);
            return;
        }
        x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
        bq(str, null);
    }

    static /* synthetic */ void bs(String str, String str2) {
        int i = 0;
        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "doCallback url:%s localPath:%s", new Object[]{str, str2});
        List list = (List) fRw.get(str);
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "doCallback callbacks nil");
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ((a) list.get(i2)).tA(str2);
                i = i2 + 1;
            } else {
                fRw.remove(str);
                return;
            }
        }
    }

    static {
        String str = e.bnE;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        dFS = str;
        h.Ey(str);
    }

    public static void a(String str, String str2, a aVar) {
        if (!bi.oW(str)) {
            String str3 = null;
            if (!bi.oW(str)) {
                str3 = g.u(str.getBytes());
            }
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "downloadToLocal url:%s localPath:%s", new Object[]{str, String.format("%s%s", new Object[]{dFS, str3})});
            ah.A(new 1(str, aVar));
            com.tencent.mm.sdk.f.e.post(new 2(str, str2, str3), "AppBrandSimpleImageLoaderDownloadThread");
        }
    }

    private static void bq(String str, String str2) {
        ah.A(new 3(str, str2));
    }

    private static boolean br(String str, String str2) {
        if (bi.oW(str)) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "isMd5Valid target nil, no check");
            return true;
        }
        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "isMd5Valid file:%s target:%s", new Object[]{g.cu(str2), str});
        return str.equals(g.cu(str2));
    }
}
