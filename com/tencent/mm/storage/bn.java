package com.tencent.mm.storage;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;

public final class bn extends j {
    private x tct = null;

    public bn(x xVar) {
        this.tct = xVar;
    }

    public final void cmW() {
        int i;
        String str = (String) this.tct.get(77825, null);
        x.i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml " + str);
        if (!bi.oW(str)) {
            super.Xp(str);
        }
        if (bi.oW(str)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            str = aa.duN + "deviceconfig.cfg";
            if (e.cn(str)) {
                byte[] f = e.f(str, 0, -1);
                if (bi.bC(f)) {
                    i = -2;
                } else {
                    String str2 = new String(f, Charset.defaultCharset());
                    if (bi.oW(str2)) {
                        i = -3;
                    } else {
                        x.i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", str2);
                        Zm(str2);
                        i = 0;
                    }
                }
            } else {
                i = -1;
            }
        } else {
            x.i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
            i = 0;
        }
        x.i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", Integer.valueOf(i));
    }

    public final String cmX() {
        String str = (String) this.tct.get(77825, null);
        x.d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
        return str;
    }

    public final int Zm(String str) {
        x.d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", str);
        this.tct.set(77825, str);
        Zo(str);
        super.Xp(str);
        return 0;
    }

    public static String cmY() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object obj = Build.FINGERPRINT;
        if (obj != null) {
            obj = obj.replace("/", ":");
        }
        linkedHashMap.put("fingerprint", obj);
        linkedHashMap.put("manufacturer", Build.MANUFACTURER);
        linkedHashMap.put("device", Build.DEVICE);
        linkedHashMap.put("model", Build.MODEL);
        linkedHashMap.put("product", Build.PRODUCT);
        linkedHashMap.put("board", Build.BOARD);
        linkedHashMap.put("release", VERSION.RELEASE);
        linkedHashMap.put("codename", VERSION.CODENAME);
        linkedHashMap.put("incremental", VERSION.INCREMENTAL);
        linkedHashMap.put("display", Build.DISPLAY);
        String a = bi.a(linkedHashMap);
        x.d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  " + a);
        return a;
    }

    public static String cmZ() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<deviceinfo>");
        stringBuffer.append("<MANUFACTURER name=\"");
        stringBuffer.append(Build.MANUFACTURER);
        stringBuffer.append("\">");
        stringBuffer.append("<MODEL name=\"");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_RELEASE name=\"");
        stringBuffer.append(VERSION.RELEASE);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_INCREMENTAL name=\"");
        stringBuffer.append(VERSION.INCREMENTAL);
        stringBuffer.append("\">");
        stringBuffer.append("<DISPLAY name=\"");
        stringBuffer.append(Build.DISPLAY);
        stringBuffer.append("\">");
        stringBuffer.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        x.d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static boolean Zn(String str) {
        if (bi.oW(str)) {
            return false;
        }
        try {
            if (bl.z(str, "deviceinfoconfig") == null || !g.Eg().Dx()) {
                return false;
            }
            g.Ek();
            g.Ei().DU().Zm(str);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e));
            return false;
        }
    }

    private static boolean Zo(String str) {
        Throwable e;
        Throwable e2;
        boolean z;
        File file = new File(aa.duN);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileWriter fileWriter = null;
        FileWriter fileWriter2;
        try {
            x.i("MicroMsg.ServerConfigInfoStorage", "writeConfigToLocalFile, path: %s, info:%s", aa.duN + "deviceconfig.cfg", str);
            fileWriter2 = new FileWriter(aa.duN + "deviceconfig.cfg");
            try {
                fileWriter2.write(str);
                try {
                    fileWriter2.close();
                    try {
                        fileWriter2.close();
                        return true;
                    } catch (Throwable e3) {
                        x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e3));
                        return true;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    z = true;
                    try {
                        x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e2));
                        if (fileWriter2 != null) {
                            return z;
                        }
                        try {
                            fileWriter2.close();
                            return z;
                        } catch (Throwable e22) {
                            x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e22));
                            return z;
                        }
                    } catch (Throwable th) {
                        e3 = th;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Throwable e222) {
                                x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e222));
                            }
                        }
                        throw e3;
                    }
                }
            } catch (Exception e5) {
                e222 = e5;
                z = false;
                x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e222));
                if (fileWriter2 != null) {
                    return z;
                }
                try {
                    fileWriter2.close();
                    return z;
                } catch (Throwable e2222) {
                    x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e2222));
                    return z;
                }
            }
        } catch (Exception e6) {
            e2222 = e6;
            fileWriter2 = null;
            z = false;
            x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e2222));
            if (fileWriter2 != null) {
                return z;
            }
            try {
                fileWriter2.close();
                return z;
            } catch (Throwable e22222) {
                x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e22222));
                return z;
            }
        } catch (Throwable th2) {
            e3 = th2;
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Throwable e222222) {
                    x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bi.i(e222222));
                }
            }
            throw e3;
        }
    }
}
