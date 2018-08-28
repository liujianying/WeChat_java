package com.tencent.mm.storage;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public final class RegionCodeDecoder {
    private static RegionCodeDecoder tcn = null;
    public static final String tco = (e.duM + "MicroMsg/regioncode/");
    public String tcp = "";
    private String tcq = "";

    private static class DecoderJni {
        public static native void buildFromFile(String str);

        public static native Region[] getCities(String str, String str2, String str3);

        public static native Region[] getCountries(String str);

        public static native String getLocName(String str);

        public static native Region[] getProvinces(String str, String str2);

        public static native void release();

        private DecoderJni() {
        }
    }

    public static class Region {
        private String code;
        private String countryCode;
        private boolean hasChildren = false;
        private boolean isCity = false;
        private boolean isCountry = false;
        private boolean isProvince = false;
        private String name;
        private Region parent = null;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public boolean hasChildren() {
            return this.hasChildren;
        }

        public void setHasChildren(boolean z) {
            this.hasChildren = z;
        }

        public void setParent(Region region) {
            this.parent = region;
        }

        public Region getParent() {
            return this.parent;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public boolean isCountry() {
            return this.isCountry;
        }

        public void setCountry(boolean z) {
            this.isCountry = z;
        }

        public boolean isProvince() {
            return this.isProvince;
        }

        public void setProvince(boolean z) {
            this.isProvince = z;
        }

        public boolean isCity() {
            return this.isCity;
        }

        public void setCity(boolean z) {
            this.isCity = z;
        }
    }

    public static RegionCodeDecoder cmS() {
        if (tcn == null) {
            tcn = new RegionCodeDecoder();
        }
        RegionCodeDecoder regionCodeDecoder = tcn;
        if (!w.chP().equals(regionCodeDecoder.tcp)) {
            regionCodeDecoder.ckJ();
        }
        return tcn;
    }

    public final void ckJ() {
        File file = new File(tco);
        if (!file.exists()) {
            file.mkdir();
            P(file);
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            P(file);
        }
        this.tcp = w.chP();
        String cmT = cmT();
        if (bi.oW(cmT)) {
            x.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.tcp);
            return;
        }
        String str = tco + cmT;
        File file2 = new File(str);
        cmT = N(file2);
        if (bi.oW(cmT) ? false : cmT.equals(O(file2))) {
            cmT = str;
        } else {
            File file3;
            if (j.C(ad.getContext(), "regioncode/" + file2.getName(), str)) {
                cmT = str;
            } else {
                file3 = new File(file2.getParentFile(), "mmregioncode_en.txt");
                cmT = file3.getAbsolutePath();
                if (!j.C(ad.getContext(), "regioncode/mmregioncode_en.txt", file3.getAbsolutePath())) {
                    cmT = null;
                }
            }
            file3 = new File(cmT);
            h(file3, file3.getParentFile());
            x.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", file2.getName(), file3.getName());
        }
        if (bi.oW(cmT)) {
            x.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.tcp);
        } else if (bi.oW(this.tcq) || !this.tcq.equals(str) || !str.equals(cmT)) {
            x.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new File(cmT).getName(), this.tcp);
            this.tcq = cmT;
            DecoderJni.buildFromFile(this.tcq);
        }
    }

    private static String N(File file) {
        Throwable th;
        String str = null;
        File file2 = new File(file.getAbsolutePath() + ".hash");
        if (file2.exists()) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                try {
                    str = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = str;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th5) {
                    }
                }
                throw th;
            }
        }
        return str;
    }

    public static void h(File file, File file2) {
        Throwable th;
        x.i("MicroMsg.RegionCodeDecoder", "Generating hash file for: %s", file.getName());
        File file3 = new File(file2, file.getName() + ".hash");
        String O = O(file);
        if (!bi.oW(O)) {
            if (!file3.exists()) {
                file3.getParentFile().mkdirs();
            }
            PrintWriter printWriter;
            try {
                printWriter = new PrintWriter(file3);
                try {
                    printWriter.print(O);
                    try {
                        printWriter.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        x.printErrStackTrace("MicroMsg.RegionCodeDecoder", th, "Failed to save hash file of %s", file.getName());
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th4) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th6) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                printWriter = null;
                if (printWriter != null) {
                    try {
                        printWriter.close();
                    } catch (Throwable th62) {
                    }
                }
                throw th;
            }
        }
    }

    private static String O(File file) {
        String m = g.m(file);
        if (!bi.oW(m)) {
            return ac.ce(m + "#" + file.lastModified() + "#" + q.zy());
        }
        x.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", file.getName());
        return null;
    }

    private synchronized void P(File file) {
        synchronized (this) {
            String[] strArr = null;
            if (file.exists()) {
                strArr = file.list();
            }
            if (!file.exists() || strArr == null || strArr.length == 0) {
                try {
                    for (String str : ad.getContext().getAssets().list("regioncode")) {
                        x.i("MicroMsg.RegionCodeDecoder", "from:%s,  to:%s", "regioncode/" + str, file.getPath() + "/" + str);
                        String str2 = file.getPath() + "/" + str;
                        j.C(ad.getContext(), "regioncode/" + str, str2);
                        h(new File(str2), file);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RegionCodeDecoder", e, "", new Object[0]);
                }
            }
        }
        return;
    }

    public final String cmT() {
        String str = "mmregioncode_" + (this.tcp.equalsIgnoreCase("zh_HK") ? "zh_TW" : this.tcp) + ".txt";
        String str2 = "mmregioncode_en.txt";
        File file = new File(tco);
        if (file.exists()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                return null;
            }
            Object obj = null;
            for (String str3 : list) {
                if (str3.equals(str)) {
                    return str3;
                }
                if (obj == null && str3.equals(str2)) {
                    obj = 1;
                }
            }
            return obj != null ? str2 : null;
        } else {
            file.mkdir();
            return null;
        }
    }

    public static final String aq(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!bi.oW(str)) {
            stringBuffer.append(str);
            if (!bi.oW(str2)) {
                stringBuffer.append('_');
                stringBuffer.append(str2);
                if (!bi.oW(str3)) {
                    stringBuffer.append('_');
                    stringBuffer.append(str3);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String Zg(String str) {
        if (bi.oW(str) || !w.Wk(str)) {
            x.e("MicroMsg.RegionCodeDecoder", "unsupported language:" + str);
            return null;
        }
        if (str.equalsIgnoreCase("zh_HK")) {
            str = "zh_TW";
        }
        return tco + "mmregioncode_" + str + ".txt";
    }

    public static final boolean Zh(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return str.equalsIgnoreCase("cn");
    }

    public static String getLocName(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return DecoderJni.getLocName(str);
    }

    public static String Zi(String str) {
        String locName = getLocName(str);
        return bi.oW(locName) ? bi.oV(str) : locName;
    }

    public static String ga(String str, String str2) {
        String str3 = null;
        if (!(bi.oW(str) || bi.oW(str2))) {
            str3 = getLocName(aq(str, str2, null));
        }
        return bi.oW(str3) ? bi.oV(str2) : str3;
    }

    public static String ar(String str, String str2, String str3) {
        String locName = (bi.oW(str) || bi.oW(str2) || bi.oW(str3)) ? null : getLocName(aq(str, str2, str3));
        return bi.oW(locName) ? bi.oV(str3) : locName;
    }

    public final Region[] cmU() {
        if (bi.oW(this.tcq)) {
            return null;
        }
        return DecoderJni.getCountries(this.tcq);
    }

    public final Region[] Zj(String str) {
        if (bi.oW(this.tcq) || bi.oW(str)) {
            return null;
        }
        return DecoderJni.getProvinces(this.tcq, str);
    }

    public final Region[] gb(String str, String str2) {
        if (bi.oW(this.tcq) || bi.oW(str) || bi.oW(str2)) {
            return null;
        }
        return DecoderJni.getCities(this.tcq, str, str2);
    }
}
