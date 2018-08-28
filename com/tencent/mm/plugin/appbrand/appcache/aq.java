package com.tencent.mm.plugin.appbrand.appcache;

import android.support.v4.e.a;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.base.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class aq {
    private static volatile aq fid = null;
    private final Map<String, Map<a, Boolean>> fie = new a();
    public final ah fif = new ah();

    public static aq acn() {
        if (((c) g.l(c.class)).aaN() == null) {
            fid = null;
            return null;
        }
        if (fid == null) {
            synchronized (aq.class) {
                if (fid == null) {
                    fid = new aq();
                }
            }
        }
        return fid;
    }

    public static void shutdown() {
        aq aqVar;
        synchronized (aq.class) {
            aqVar = fid;
            fid = null;
        }
        if (aqVar != null) {
            aqVar.fif.fhg.shutdown();
        }
    }

    public static boolean a(String str, a aVar) {
        return a("@LibraryAppId", (int) XWalkEnvironment.LOCAL_TEST_VERSION, str, aVar);
    }

    public static boolean a(String str, int i, a aVar) {
        return b("@LibraryAppId", 0, i, str, aVar);
    }

    static void b(String str, a aVar) {
        if (!bi.oW(str) && aVar != null) {
            aq acn = acn();
            if (acn != null) {
                synchronized (aq.class) {
                    Map map = (Map) acn.fie.get(str);
                    if (map == null) {
                        map = new HashMap();
                        acn().fie.put(str, map);
                    }
                    map.put(aVar, Boolean.valueOf(true));
                }
            }
        }
    }

    static Map<a, Boolean> qV(String str) {
        if (!bi.oW(str)) {
            aq acn = acn();
            if (acn != null) {
                Map<a, Boolean> map;
                synchronized (aq.class) {
                    map = (Map) acn.fie.remove(str);
                }
                return map;
            }
        }
        return null;
    }

    private static Map<a, Boolean> qW(String str) {
        if (!bi.oW(str)) {
            aq acn = acn();
            if (acn != null) {
                Map<a, Boolean> map;
                synchronized (aq.class) {
                    map = (Map) acn.fie.get(str);
                }
                return map;
            }
        }
        return null;
    }

    static void aS(String str, String str2) {
        a(str, str2, b.a.a.fiv, null);
    }

    static void a(String str, WxaPkgLoadProgress wxaPkgLoadProgress) {
        x.i("MicroMsg.AppBrandWxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", new Object[]{str, wxaPkgLoadProgress});
        Map qW = qW(str);
        if (qW != null) {
            for (a aVar : qW.keySet()) {
                if (aVar != null) {
                    aVar.a(wxaPkgLoadProgress);
                }
            }
            return;
        }
        x.d("MicroMsg.AppBrandWxaPkgUpdater", "callback progress, null callback urlKey = %s", new Object[]{str});
    }

    static boolean a(com.tencent.mm.plugin.appbrand.appcache.base.a aVar, a aVar2) {
        if (acn() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            return false;
        } else if (aVar == null) {
            return false;
        } else {
            b(aVar.qBy, aVar2);
            int b = acn().fif.b(aVar);
            if (b == 0 || b == 2) {
                return true;
            }
            a(aVar.qBy, aVar.appId, b.a.a.fiv, null);
            return false;
        }
    }

    public static boolean a(String str, int i, int i2, int i3, String str2, a aVar) {
        com.tencent.mm.plugin.appbrand.appcache.base.a aVar2 = null;
        if (acn() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            return false;
        }
        com.tencent.mm.plugin.appbrand.appcache.base.a aiVar;
        if (!bi.oW(str) && !bi.oW(str2)) {
            switch (i) {
                case 0:
                    aiVar = new ai(str, i, i2, str2);
                    break;
                case 1:
                case 2:
                case XWalkEnvironment.LOCAL_TEST_VERSION /*999*/:
                    aiVar = new ad(str, str2, i);
                    break;
                case 10000:
                case 10001:
                case 10002:
                case 10100:
                case 10101:
                case 10102:
                    aiVar = new ar(str2, str, i2, i);
                    break;
                default:
                    aiVar = null;
                    break;
            }
        }
        aiVar = null;
        if (aiVar != null) {
            boolean z = "@LibraryAppId".equals(str) ? false : i == 0;
            aiVar.fin = z;
            if (i3 > 2097152) {
                aiVar.setReadTimeout(aiVar.getReadTimeout() * 2);
                aiVar.setConnectTimeout(aiVar.getConnectTimeout() * 2);
            }
            aVar2 = aiVar;
        }
        if (aVar2 != null) {
            return a(aVar2, aVar);
        }
        x.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        return false;
    }

    public static boolean b(String str, int i, int i2, String str2, a aVar) {
        return a(str, i, i2, 0, str2, aVar);
    }

    public static boolean a(String str, int i, String str2, a aVar) {
        return b(str, i, 1, str2, aVar);
    }

    static void a(String str, String str2, b.a.a aVar, b bVar) {
        Map qV = qV(str);
        if (qV != null) {
            for (a aVar2 : qV.keySet()) {
                if (aVar2 != null) {
                    aVar2.a(str2, aVar, bVar);
                }
            }
            return;
        }
        x.d("MicroMsg.AppBrandWxaPkgUpdater", "callback, null callback appId = %s", new Object[]{str2});
    }

    static void a(String str, String str2, b.a.a aVar) {
        if (acn() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadFail, get instance null !!!");
        } else {
            a(str, str2, aVar, null);
        }
    }

    static void a(String str, String str2, String str3, int i, int i2, s.a aVar) {
        boolean ho = d.a.ho(i2);
        if (acn() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, get instance null !!!");
        } else if (bi.oW(str3)) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
            a(str, str2, b.a.a.fiq, null);
            aVar.abw();
        } else if (!new File(str3).exists()) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg file not exists");
            a(str, str2, b.a.a.fiq, null);
            aVar.abw();
        } else if (((c) g.l(c.class)).aaN() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
            aS(str, str2);
        } else {
            al a = ((c) g.l(c.class)).aaN().a(str2, !ho ? i : 1, i2, new String[0]);
            if (a == null) {
                x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2)});
                a(str, str2, b.a.a.fip, null);
                return;
            }
            boolean z;
            aVar.abx();
            File file = new File(str3);
            String str4 = a.field_versionMd5;
            if (!ho) {
                if (!bi.oV(str4).equals(com.tencent.mm.a.g.m(file))) {
                    x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, record.md5(%s) != file.md5(%s)", new Object[]{str4, com.tencent.mm.a.g.m(file)});
                    z = false;
                    aVar.ct(z);
                    if (z) {
                        e.deleteFile(str3);
                        a(str, str2, b.a.a.fis, null);
                    }
                    x.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(((c) g.l(c.class)).aaN().d(str2, i2, r1, str3)), str2, Integer.valueOf(i2), Integer.valueOf(r1), str3});
                    a(str, str2, b.a.a.fio, new b(str2, str3, i, i2));
                    return;
                }
            }
            ag agVar = new ag(file);
            if (!agVar.fgX) {
                agVar.close();
                x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg invalid");
                file.delete();
                z = false;
            } else if (agVar.abW()) {
                agVar.close();
                z = true;
            } else {
                agVar.close();
                x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg readInfo failed");
                file.delete();
                z = false;
            }
            aVar.ct(z);
            if (z) {
                x.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(((c) g.l(c.class)).aaN().d(str2, i2, r1, str3)), str2, Integer.valueOf(i2), Integer.valueOf(r1), str3});
                a(str, str2, b.a.a.fio, new b(str2, str3, i, i2));
                return;
            }
            e.deleteFile(str3);
            a(str, str2, b.a.a.fis, null);
        }
    }
}
