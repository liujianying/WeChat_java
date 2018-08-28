package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ShareResPatchInfo {
    public String vvI = null;
    public String vvJ = null;
    public ArrayList<String> vvK = new ArrayList();
    public ArrayList<String> vvL = new ArrayList();
    public ArrayList<String> vvM = new ArrayList();
    public HashMap<String, File> vvN = new HashMap();
    public ArrayList<String> vvO = new ArrayList();
    public HashMap<String, LargeModeInfo> vvP = new HashMap();
    public HashSet<Pattern> vvQ = new HashSet();

    public static class LargeModeInfo {
        public String bKg = null;
        public File file = null;
        public long vvR;
    }

    public static void a(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null && str.length() != 0) {
            String[] split = str.split("\n");
            int i = 0;
            while (i < split.length) {
                String str2 = split[i];
                if (str2 != null && str2.length() > 0) {
                    int i2;
                    if (str2.startsWith("resources_out.zip")) {
                        String[] split2 = str2.split(",", 3);
                        shareResPatchInfo.vvI = split2[1];
                        shareResPatchInfo.vvJ = split2[2];
                    } else if (str2.startsWith("pattern:")) {
                        i2 = i;
                        for (int parseInt = Integer.parseInt(str2.split(":", 2)[1]); parseInt > 0; parseInt--) {
                            HashSet hashSet = shareResPatchInfo.vvQ;
                            String str3 = split[i2 + 1];
                            if (str3.contains(".")) {
                                str3 = str3.replaceAll("\\.", "\\\\.");
                            }
                            if (str3.contains("?")) {
                                str3 = str3.replaceAll("\\?", "\\.");
                            }
                            if (str3.contains("*")) {
                                str3 = str3.replace("*", ".*");
                            }
                            hashSet.add(Pattern.compile(str3));
                            i2++;
                        }
                        i = i2;
                    } else if (str2.startsWith("add:")) {
                        for (i2 = Integer.parseInt(str2.split(":", 2)[1]); i2 > 0; i2--) {
                            shareResPatchInfo.vvK.add(split[i + 1]);
                            i++;
                        }
                    } else if (str2.startsWith("modify:")) {
                        for (i2 = Integer.parseInt(str2.split(":", 2)[1]); i2 > 0; i2--) {
                            shareResPatchInfo.vvM.add(split[i + 1]);
                            i++;
                        }
                    } else if (str2.startsWith("large modify:")) {
                        for (i2 = Integer.parseInt(str2.split(":", 2)[1]); i2 > 0; i2--) {
                            String[] split3 = split[i + 1].split(",", 3);
                            Object obj = split3[0];
                            LargeModeInfo largeModeInfo = new LargeModeInfo();
                            largeModeInfo.bKg = split3[1];
                            largeModeInfo.vvR = Long.parseLong(split3[2]);
                            shareResPatchInfo.vvO.add(obj);
                            shareResPatchInfo.vvP.put(obj, largeModeInfo);
                            i++;
                        }
                    } else if (str2.startsWith("delete:")) {
                        for (i2 = Integer.parseInt(str2.split(":", 2)[1]); i2 > 0; i2--) {
                            shareResPatchInfo.vvL.add(split[i + 1]);
                            i++;
                        }
                    } else if (str2.startsWith("store:")) {
                        for (i2 = Integer.parseInt(str2.split(":", 2)[1]); i2 > 0; i2--) {
                            shareResPatchInfo.vvN.put(split[i + 1], null);
                            i++;
                        }
                    }
                }
                i++;
            }
        }
    }

    public static boolean a(HashSet<Pattern> hashSet, String str) {
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                if (((Pattern) it.next()).matcher(str).matches()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(ShareResPatchInfo shareResPatchInfo) {
        if (shareResPatchInfo == null) {
            return false;
        }
        String str = shareResPatchInfo.vvJ;
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static void b(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null && str.length() != 0) {
            String str2 = str.split("\n")[0];
            if (str2 == null || str2.length() <= 0) {
                throw new TinkerRuntimeException("res meta Corrupted:" + str);
            }
            String[] split = str2.split(",", 3);
            shareResPatchInfo.vvI = split[1];
            shareResPatchInfo.vvJ = split[2];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("resArscMd5:" + this.vvJ + "\n");
        stringBuffer.append("arscBaseCrc:" + this.vvI + "\n");
        Iterator it = this.vvQ.iterator();
        while (it.hasNext()) {
            stringBuffer.append("pattern:" + ((Pattern) it.next()) + "\n");
        }
        it = this.vvK.iterator();
        while (it.hasNext()) {
            stringBuffer.append("addedSet:" + ((String) it.next()) + "\n");
        }
        it = this.vvM.iterator();
        while (it.hasNext()) {
            stringBuffer.append("modifiedSet:" + ((String) it.next()) + "\n");
        }
        it = this.vvO.iterator();
        while (it.hasNext()) {
            stringBuffer.append("largeModifiedSet:" + ((String) it.next()) + "\n");
        }
        it = this.vvL.iterator();
        while (it.hasNext()) {
            stringBuffer.append("deletedSet:" + ((String) it.next()) + "\n");
        }
        for (String str : this.vvN.keySet()) {
            stringBuffer.append("storeSet:" + str + "\n");
        }
        return stringBuffer.toString();
    }
}
