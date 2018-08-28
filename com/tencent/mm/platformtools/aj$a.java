package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import java.lang.reflect.Method;

public class aj$a {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int M(android.content.Context r8, java.lang.String r9) {
        /*
        r2 = 0;
        r0 = 0;
        r1 = 0;
        r1 = r8.createPackageContext(r9, r1);	 Catch:{ NameNotFoundException -> 0x000a }
    L_0x0007:
        if (r1 != 0) goto L_0x0018;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = move-exception;
        r3 = "MicroMsg.YYBMarketVerify";
        r4 = "";
        r5 = new java.lang.Object[r0];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r1, r4, r5);
        r1 = r2;
        goto L_0x0007;
    L_0x0018:
        r3 = r1.getAssets();
        r4 = new android.content.res.Resources;
        r5 = r8.getResources();
        r5 = r5.getDisplayMetrics();
        r4.<init>(r3, r5, r2);
        r2 = a(r1, r3);	 Catch:{ IOException -> 0x009a }
        if (r2 != 0) goto L_0x0035;
    L_0x002f:
        if (r2 == 0) goto L_0x0009;
    L_0x0031:
        r2.close();
        goto L_0x0009;
    L_0x0035:
        r1 = r2.getEventType();	 Catch:{ XmlPullParserException -> 0x0044 }
    L_0x0039:
        r3 = 1;
        if (r1 == r3) goto L_0x00c4;
    L_0x003c:
        switch(r1) {
            case 2: goto L_0x0053;
            default: goto L_0x003f;
        };
    L_0x003f:
        r1 = r2.nextToken();	 Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x00ae }
        goto L_0x0039;
    L_0x0044:
        r1 = move-exception;
        r3 = "MicroMsg.YYBMarketVerify";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ IOException -> 0x009a }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r1, r5, r6);	 Catch:{ IOException -> 0x009a }
        r1 = r0;
        goto L_0x0039;
    L_0x0053:
        r3 = r2.getName();	 Catch:{ IOException -> 0x009a }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ IOException -> 0x009a }
        if (r5 != 0) goto L_0x003f;
    L_0x005d:
        r5 = "manifest";
        r3 = r3.equals(r5);	 Catch:{ IOException -> 0x009a }
        if (r3 == 0) goto L_0x003f;
    L_0x0066:
        r1 = "versionCode";
        r3 = "http://schemas.android.com/apk/res/android";
        r1 = r2.getAttributeValue(r3, r1);	 Catch:{ IOException -> 0x009a }
        r1 = a(r1, r4);	 Catch:{ IOException -> 0x009a }
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ IOException -> 0x009a }
        if (r3 == 0) goto L_0x0080;
    L_0x007a:
        if (r2 == 0) goto L_0x0009;
    L_0x007c:
        r2.close();
        goto L_0x0009;
    L_0x0080:
        r3 = 0;
        r0 = com.tencent.mm.platformtools.ai.getInt(r1, r3);	 Catch:{ IOException -> 0x009a }
        if (r2 == 0) goto L_0x0009;
    L_0x0087:
        r2.close();
        goto L_0x0009;
    L_0x008c:
        r3 = move-exception;
        r5 = "MicroMsg.YYBMarketVerify";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ IOException -> 0x009a }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r3, r6, r7);	 Catch:{ IOException -> 0x009a }
        goto L_0x0039;
    L_0x009a:
        r1 = move-exception;
        r3 = "MicroMsg.YYBMarketVerify";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00bd }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r1, r4, r5);	 Catch:{ all -> 0x00bd }
        if (r2 == 0) goto L_0x0009;
    L_0x00a9:
        r2.close();
        goto L_0x0009;
    L_0x00ae:
        r3 = move-exception;
        r5 = "MicroMsg.YYBMarketVerify";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ IOException -> 0x009a }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r3, r6, r7);	 Catch:{ IOException -> 0x009a }
        goto L_0x0039;
    L_0x00bd:
        r0 = move-exception;
        if (r2 == 0) goto L_0x00c3;
    L_0x00c0:
        r2.close();
    L_0x00c3:
        throw r0;
    L_0x00c4:
        if (r2 == 0) goto L_0x0009;
    L_0x00c6:
        r2.close();
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.aj$a.M(android.content.Context, java.lang.String):int");
    }

    private static XmlResourceParser a(Context context, AssetManager assetManager) {
        int i = 1;
        try {
            String str = (String) Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(context, new Object[0]);
            Method method = AssetManager.class.getMethod("getCookieName", new Class[]{Integer.TYPE});
            if (str == null && context.getPackageName().equals("android")) {
                str = "/system/framework/framework-res.apk";
            }
            while (i < 20) {
                if (str != null) {
                    if (str.equals(method.invoke(assetManager, new Object[]{Integer.valueOf(i)}))) {
                        return assetManager.openXmlResourceParser(i, "AndroidManifest.xml");
                    }
                }
                i++;
            }
        } catch (Exception e) {
        }
        return assetManager.openXmlResourceParser("AndroidManifest.xml");
    }

    private static String a(String str, Resources resources) {
        if (str == null || !str.startsWith("@")) {
            return str;
        }
        try {
            return resources.getString(Integer.parseInt(str.substring(1)));
        } catch (NumberFormatException e) {
            return str;
        } catch (NotFoundException e2) {
            return str;
        }
    }
}
