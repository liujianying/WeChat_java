package com.tencent.mm.pluginsdk;

import com.tencent.mm.opensdk.constants.ConstantsAPI$AppSupportContentFlag;
import java.util.HashMap;

public final class b$a {
    public static final HashMap<String, Long> qxX;

    public static Long Sy(String str) {
        if (str == null) {
            return null;
        }
        return (Long) qxX.get(str.toLowerCase());
    }

    static {
        HashMap hashMap = new HashMap();
        qxX = hashMap;
        hashMap.put("doc", Long.valueOf(64));
        qxX.put("docx", Long.valueOf(128));
        qxX.put("ppt", Long.valueOf(256));
        qxX.put("pptx", Long.valueOf(512));
        qxX.put("xls", Long.valueOf(ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLS));
        qxX.put("xlsx", Long.valueOf(ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLSX));
        qxX.put("pdf", Long.valueOf(ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_PDF));
        qxX.put("1", Long.valueOf(1));
        qxX.put("3", Long.valueOf(2));
        qxX.put("48", Long.valueOf(4));
        qxX.put("43", Long.valueOf(8));
        qxX.put("mp3", Long.valueOf(16));
        qxX.put("wav", Long.valueOf(16));
        qxX.put("wma", Long.valueOf(16));
        qxX.put("avi", Long.valueOf(8));
        qxX.put("rmvb", Long.valueOf(8));
        qxX.put("rm", Long.valueOf(8));
        qxX.put("mpg", Long.valueOf(8));
        qxX.put("mpeg", Long.valueOf(8));
        qxX.put("wmv", Long.valueOf(8));
        qxX.put("mp4", Long.valueOf(8));
        qxX.put("mkv", Long.valueOf(8));
    }
}
