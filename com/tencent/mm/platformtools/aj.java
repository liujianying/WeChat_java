package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aj {
    public static boolean a(Context context, ArrayList<c> arrayList, boolean z) {
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!TextUtils.isEmpty(cVar.byT)) {
                String str;
                String replace;
                String str2 = cVar.byT;
                List<String> arrayList2 = new ArrayList();
                String packageResourcePath = context.getPackageResourcePath();
                int i;
                if (VERSION.SDK_INT >= 21) {
                    String[] split = packageResourcePath.split("/");
                    str = "";
                    if (split != null) {
                        CharSequence charSequence;
                        for (i = 0; i < split.length; i++) {
                            if (split[i].contains(context.getPackageName())) {
                                charSequence = split[i];
                                break;
                            }
                        }
                        Object charSequence2 = str;
                        if (!TextUtils.isEmpty(charSequence2)) {
                            str = packageResourcePath.replace(charSequence2, str2 + "-1");
                            if (new File(str).exists()) {
                                arrayList2.add(str);
                            }
                            replace = packageResourcePath.replace(charSequence2, str2 + "-2");
                            if (new File(replace).exists()) {
                                arrayList2.add(replace);
                            }
                        }
                    }
                } else {
                    String[] split2 = packageResourcePath.split("/");
                    if (split2 != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (i = 0; i < split2.length; i++) {
                            if (i != split2.length - 1) {
                                stringBuilder.append(split2[i]);
                                stringBuilder.append("/");
                            }
                        }
                        replace = stringBuilder.toString();
                        str = replace + str2 + "-1.apk";
                        if (new File(str).exists()) {
                            arrayList2.add(str);
                        }
                        replace = replace + str2 + "-2.apk";
                        if (new File(replace).exists()) {
                            arrayList2.add(replace);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    for (String replace2 : arrayList2) {
                        File file = new File(replace2);
                        if (file.exists()) {
                            try {
                                Object obj;
                                replace2 = "";
                                long currentTimeMillis = System.currentTimeMillis();
                                if (z) {
                                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(cVar.byT, 64);
                                    if (packageInfo.signatures.length > 0) {
                                        replace2 = ac.ce(packageInfo.signatures[packageInfo.signatures.length - 1].toCharsString());
                                    }
                                    obj = replace2;
                                } else {
                                    str = b.t(file.getAbsoluteFile());
                                }
                                String str3 = "MicroMsg.YYBMarketVerify";
                                String str4 = "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms";
                                Object[] objArr = new Object[6];
                                objArr[0] = Boolean.valueOf(z);
                                objArr[1] = cVar.byT;
                                objArr[2] = cVar.eys;
                                objArr[3] = obj;
                                boolean z2 = !TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(cVar.eys);
                                objArr[4] = Boolean.valueOf(z2);
                                objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                x.i(str3, str4, objArr);
                                if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(cVar.eys)) {
                                    int i2;
                                    currentTimeMillis = System.currentTimeMillis();
                                    if (z) {
                                        i2 = context.getPackageManager().getPackageInfo(cVar.byT, 0).versionCode;
                                    } else {
                                        i2 = a.M(context, cVar.byT);
                                    }
                                    str3 = "MicroMsg.YYBMarketVerify";
                                    str4 = "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms";
                                    objArr = new Object[6];
                                    objArr[0] = Boolean.valueOf(z);
                                    objArr[1] = cVar.byT;
                                    objArr[2] = Integer.valueOf(cVar.eyr);
                                    objArr[3] = Integer.valueOf(i2);
                                    objArr[4] = Boolean.valueOf(i2 <= cVar.eyr);
                                    objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                    x.i(str3, str4, objArr);
                                    if (i2 <= cVar.eyr) {
                                        return true;
                                    }
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.YYBMarketVerify", e, "", new Object[0]);
                            }
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return false;
    }
}
