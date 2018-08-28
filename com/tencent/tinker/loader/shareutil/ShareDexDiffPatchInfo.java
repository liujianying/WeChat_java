package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo {
    public final String dia;
    public final String path;
    public final String vuA;
    public final String vuB;
    public final String vuC;
    public final String vuD;
    public final String vuE;
    public final String vuF;
    public final boolean vuG;
    public final String vuz;

    public ShareDexDiffPatchInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.vuz = str;
        this.path = str2;
        this.vuA = str3;
        this.vuB = str4;
        this.vuE = str5;
        this.vuC = str6;
        this.vuD = str7;
        this.vuF = str8;
        if (str8.equals("jar")) {
            this.vuG = true;
            if (SharePatchFileUtil.acY(str)) {
                this.dia = str + ".jar";
            } else {
                this.dia = str;
            }
        } else if (str8.equals("raw")) {
            this.vuG = false;
            this.dia = str;
        } else {
            throw new TinkerRuntimeException("can't recognize dex mode:" + str8);
        }
    }

    public static void m(String str, ArrayList<ShareDexDiffPatchInfo> arrayList) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split("\n")) {
                if (str2 != null && str2.length() > 0) {
                    String[] split = str2.split(",", 8);
                    if (split != null && split.length >= 8) {
                        arrayList.add(new ShareDexDiffPatchInfo(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim(), split[7].trim()));
                    }
                }
            }
        }
    }

    public static boolean c(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (shareDexDiffPatchInfo == null) {
            return false;
        }
        String str = shareDexDiffPatchInfo.vuz;
        String str2 = ShareTinkerInternals.cHe() ? shareDexDiffPatchInfo.vuB : shareDexDiffPatchInfo.vuA;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.vuz);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.vuA);
        stringBuffer.append(",");
        stringBuffer.append(this.vuB);
        stringBuffer.append(",");
        stringBuffer.append(this.vuC);
        stringBuffer.append(",");
        stringBuffer.append(this.vuD);
        stringBuffer.append(",");
        stringBuffer.append(this.vuE);
        stringBuffer.append(",");
        stringBuffer.append(this.vuF);
        return stringBuffer.toString();
    }
}
