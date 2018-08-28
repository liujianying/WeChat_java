package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.b.b;
import com.tencent.mm.plugin.ext.c.e.a;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c {
    private static com.tencent.mm.sdk.b.c eOh = new 1();
    private static HashSet<String> iKL = new HashSet();
    private static HashSet<String> iKM = new HashSet();
    private static ArrayList<a> iKN = new ArrayList();
    private static HashMap<String, a> iKO = new HashMap();

    private static String aJc() {
        String str;
        if (ExtControlProviderOpenApi.iJy) {
            str = h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "extqbar";
        } else {
            str = ad.getContext().getFilesDir().getParent() + File.separator + "extqbar";
        }
        File file = new File(str);
        if (!file.exists()) {
            x.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
            file.mkdirs();
        }
        return str + File.separator + "ext_qbar_config.csv";
    }

    private static void aJd() {
        if (e.cn(aJc())) {
            try {
                String ct = e.ct(aJc());
                x.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
                x.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", new Object[]{ct});
                if (bi.oW(ct)) {
                    x.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
                }
                BufferedReader bufferedReader = new BufferedReader(new StringReader(ct));
                long VG = bi.VG();
                while (true) {
                    try {
                        ct = bufferedReader.readLine();
                        if (ct == null) {
                            break;
                        }
                        x.d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
                        String[] split = ct.split(",");
                        if (split.length < 3) {
                            x.w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", new Object[]{ct});
                        } else {
                            int i;
                            a aVar = new a();
                            aVar.url = split[2].toUpperCase();
                            if ("white".equalsIgnoreCase(split[0])) {
                                aVar.iKC = b.iKI;
                                if ("prefix".equalsIgnoreCase(split[1])) {
                                    aVar.iKB = b.a.iKD;
                                    i = 1;
                                } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                    aVar.iKB = b.a.iKE;
                                    i = 1;
                                } else if ("domain".equalsIgnoreCase(split[1])) {
                                    aVar.iKB = b.a.iKF;
                                    i = 1;
                                } else {
                                    x.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", new Object[]{split[1]});
                                    i = 0;
                                }
                            } else if ("black".equalsIgnoreCase(split[0])) {
                                aVar.iKC = b.iKH;
                                if ("prefix".equalsIgnoreCase(split[1])) {
                                    aVar.iKB = b.a.iKD;
                                    i = 1;
                                } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                    aVar.iKB = b.a.iKE;
                                    i = 1;
                                } else if ("domain".equalsIgnoreCase(split[1])) {
                                    aVar.iKB = b.a.iKF;
                                    i = 1;
                                } else {
                                    x.w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", new Object[]{split[1]});
                                    i = 0;
                                }
                            } else {
                                x.w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", new Object[]{split[0]});
                                i = 0;
                            }
                            if (i != 0) {
                                iKN.add(aVar);
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ExtQbarDataManager", e, "hy: exception when parse config!", new Object[0]);
                    }
                }
                x.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", new Object[]{Long.valueOf(bi.bI(VG))});
                return;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.ExtQbarDataManager", e2, "hy: read config file failed!", new Object[0]);
                return;
            }
        }
        x.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
        g.DF().a(new m(46), 0);
    }

    public static void aJe() {
        aJd();
        com.tencent.mm.sdk.b.a.sFg.b(eOh);
    }

    public static void aJf() {
        com.tencent.mm.sdk.b.a.sFg.c(eOh);
    }

    public static void AJ(String str) {
        iKL.add(str);
    }

    public static void AK(String str) {
        iKM.add(str);
    }

    public static void a(String str, a aVar) {
        iKO.put(str, aVar);
    }

    public static a AL(String str) {
        return (a) iKO.get(str);
    }

    public static void clearCache() {
        iKO.clear();
    }

    public static boolean AM(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
            return false;
        } else if (!iKL.contains(str)) {
            return false;
        } else {
            x.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[]{str});
            return true;
        }
    }

    public static boolean AN(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
            return false;
        } else if (!iKM.contains(str)) {
            return false;
        } else {
            x.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[]{str});
            return true;
        }
    }

    public static b AO(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
            return b.iKJ;
        }
        Iterator it = iKN.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.iKB != b.a.iKD) {
                try {
                    String host = new URL(str).getHost();
                    x.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", new Object[]{host});
                    if (bi.G(new String[0])) {
                        x.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
                    } else if (aVar.iKB == b.a.iKF) {
                        if (aVar.url.equals(host)) {
                            x.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[]{aVar.iKB});
                            return aVar.iKC;
                        }
                    } else if (aVar.iKB == b.a.iKE) {
                        String[] split = aVar.url.split("\\.");
                        String[] split2 = host.split("\\.");
                        if (split.length > 0 && split2.length > 0 && split.length <= split2.length) {
                            int length = split.length - 1;
                            int length2 = split2.length - 1;
                            int i = 1;
                            while (length >= 0 && length2 >= 0) {
                                if (!split[length].equals(split2[length2])) {
                                    i = 0;
                                }
                                length--;
                                length2--;
                            }
                            if (i != 0) {
                                x.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", new Object[]{str, aVar.url});
                                return aVar.iKC;
                            }
                        }
                    } else {
                        x.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ExtQbarDataManager", e, "hy: error in url convert: %s", new Object[]{str});
                }
            } else if (str.startsWith(aVar.url)) {
                x.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[]{aVar.url});
                return aVar.iKC;
            }
        }
        return b.iKJ;
    }
}
