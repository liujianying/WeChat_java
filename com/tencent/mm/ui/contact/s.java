package com.tencent.mm.ui.contact;

import java.util.HashSet;

public final class s {
    public static final int ukE = s(256, 16, 1, 2, 4);
    public static final int ukF = s(16, 1, 2, 4, 64, 16384);
    public static final int ukG = s(16, 1, 2, 4, 64, 4096);
    public static final int ukH = s(ukE, 64, 16384, 4096);
    public static final int ukI = s(16, 2, 16384, 4);
    public static final int ukJ = s(ukE, 16384, 64, 4096);
    public static final int ukK = s(ukE, 16384, 64, 131072, 8192);
    public static final int ukL = s(16, 32, 1, 4, 2, 64);
    public static final int ukM = s(ukF, 131072);

    public static HashSet<String> cyz() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("weixin");
        return hashSet;
    }

    public static void h(HashSet<String> hashSet) {
        hashSet.remove("filehelper");
    }

    public static HashSet<String> cyA() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("officialaccounts");
        hashSet.add("newsapp");
        for (Object add : com.tencent.mm.model.s.dAV) {
            hashSet.add(add);
        }
        hashSet.add("weibo");
        hashSet.add("qqmail");
        hashSet.add("fmessage");
        hashSet.add("tmessage");
        hashSet.add("floatbottle");
        hashSet.add("lbsapp");
        hashSet.add("shakeapp");
        hashSet.add("medianote");
        hashSet.add("qqfriend");
        hashSet.add("readerapp");
        hashSet.add("newsapp");
        hashSet.add("blogapp");
        hashSet.add("facebookapp");
        hashSet.add("masssendapp");
        hashSet.add("meishiapp");
        hashSet.add("feedsapp");
        hashSet.add("voipapp");
        hashSet.add("filehelper");
        hashSet.add("officialaccounts");
        hashSet.add("helper_entry");
        hashSet.add("pc_share");
        hashSet.add("cardpackage");
        hashSet.add("voicevoipapp");
        hashSet.add("voiceinputapp");
        hashSet.add("linkedinplugin");
        hashSet.add("appbrandcustomerservicemsg");
        return hashSet;
    }

    public static boolean fb(int i, int i2) {
        return (i & i2) > 0;
    }

    public static int fc(int i, int i2) {
        return (i2 ^ -1) & i;
    }

    public static int s(int... iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] | i2;
        }
        return i2;
    }
}
