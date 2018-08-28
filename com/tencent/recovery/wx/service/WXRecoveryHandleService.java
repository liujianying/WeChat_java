package com.tencent.recovery.wx.service;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryHandleResult;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.RecoveryTinkerManager;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import org.json.JSONObject;

public class WXRecoveryHandleService extends RecoveryHandleService {
    private PowerManager pJg;

    public void onCreate() {
        super.onCreate();
        RecoveryLog.i("Recovery.WXRecoveryHandleService", "onCreate", new Object[0]);
        this.pJg = (PowerManager) getSystemService("power");
    }

    public void onDestroy() {
        RecoveryLog.i("Recovery.WXRecoveryHandleService", "onDestroy", new Object[0]);
        super.onDestroy();
    }

    protected final void a(RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, boolean z) {
        arrayList.add(a(recoveryData, String.format("%s[%b]", new Object[]{"KeyTotalCount", Boolean.valueOf(z)})));
        arrayList.add(a(recoveryData, String.format("%s[%b]", new Object[]{"KeyAlreadyRunning", Boolean.valueOf(z)})));
    }

    protected final RecoveryHandleResult a(Context context, RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, boolean z) {
        Throwable th;
        FileOutputStream fileOutputStream;
        RecoveryHandleResult recoveryHandleResult = new RecoveryHandleResult();
        arrayList.add(a(recoveryData, String.format("%s[%b]", new Object[]{"KeyTotalCount", Boolean.valueOf(z)})));
        RecoveryHandleItem a = a(recoveryData, "");
        if (NetUtil.isConnected(this)) {
            RecoveryLog.i("Recovery.WXRecoveryHandleService", "recoveryConfigUrl %s", recoveryData.vhv);
            String a2 = a(r0, a);
            if (a2 != null) {
                JSONObject jSONObject;
                RecoveryLog.i("Recovery.WXRecoveryHandleService", "recoveryConfigStr is %s", a2);
                try {
                    jSONObject = new JSONObject(a2);
                } catch (Exception e) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("abTestBaseNumber", -1);
                    int optInt2 = jSONObject.optInt("abTestReminder", -1);
                    String optString = jSONObject.optString("patchPackageUrl", "");
                    String optString2 = jSONObject.optString("patchPackageMd5", "");
                    if (Util.hl(this) % optInt == optInt2) {
                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "patchPackageUrl=%s", optString);
                        byte[] a3 = a(optString, optString2, a);
                        if (a3 != null) {
                            String str = context.getCacheDir() + "/recovery.patch";
                            File file = new File(str);
                            if (file.exists()) {
                                file.delete();
                            }
                            FileOutputStream fileOutputStream2;
                            try {
                                fileOutputStream2 = new FileOutputStream(file);
                                try {
                                    fileOutputStream2.write(a3);
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e2) {
                                    }
                                } catch (Exception e3) {
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    if (file.exists()) {
                                        a.aAL = "KeyCheckPatchMd5FailCount";
                                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                                    } else {
                                        int bI = RecoveryTinkerManager.bI(context, str);
                                        if (bI != 0) {
                                            a.aAL = "KeyPatchStartFailCount[" + bI + "]";
                                            RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(bI));
                                        } else {
                                            a.aAL = "KeyPatchStartSuccessCount";
                                            RecoveryLog.i("Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                                        }
                                        recoveryHandleResult.bGZ = true;
                                    }
                                    arrayList.add(a);
                                    return recoveryHandleResult;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e6) {
                                fileOutputStream2 = null;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e42) {
                                    }
                                }
                                if (file.exists()) {
                                    int bI2 = RecoveryTinkerManager.bI(context, str);
                                    if (bI2 != 0) {
                                        a.aAL = "KeyPatchStartFailCount[" + bI2 + "]";
                                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(bI2));
                                    } else {
                                        a.aAL = "KeyPatchStartSuccessCount";
                                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                                    }
                                    recoveryHandleResult.bGZ = true;
                                } else {
                                    a.aAL = "KeyCheckPatchMd5FailCount";
                                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                                }
                                arrayList.add(a);
                                return recoveryHandleResult;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e52) {
                                    }
                                }
                                throw th;
                            }
                            if (file.exists()) {
                                int bI22 = RecoveryTinkerManager.bI(context, str);
                                if (bI22 != 0) {
                                    a.aAL = "KeyPatchStartFailCount[" + bI22 + "]";
                                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(bI22));
                                } else {
                                    a.aAL = "KeyPatchStartSuccessCount";
                                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                                }
                                recoveryHandleResult.bGZ = true;
                            } else {
                                a.aAL = "KeyCheckPatchMd5FailCount";
                                RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                            }
                        } else {
                            RecoveryLog.i("Recovery.WXRecoveryHandleService", "get patch data fail", new Object[0]);
                        }
                    } else {
                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "no need recovery", new Object[0]);
                        a.aAL = "KeyPatchNoNeedCount";
                    }
                } else {
                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "parse config fail", new Object[0]);
                    a.aAL = "KeyConfigParseFailCount";
                }
            } else {
                RecoveryLog.i("Recovery.WXRecoveryHandleService", "recoveryConfigStr is null", new Object[0]);
                if (Util.oW(a.aAL)) {
                    a.aAL = "RecoveryConfigStrIsNull";
                }
            }
        } else {
            RecoveryLog.i("Recovery.WXRecoveryHandleService", "no network", new Object[0]);
            if (!z) {
                recoveryHandleResult.vhy = true;
            }
            a.aAL = String.format("%s[%b]", new Object[]{"KeyNoNetWork", Boolean.valueOf(z)});
        }
        arrayList.add(a);
        return recoveryHandleResult;
    }

    private RecoveryHandleItem a(RecoveryData recoveryData, String str) {
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.fMk = recoveryData.fMk;
        recoveryHandleItem.clientVersion = recoveryData.clientVersion;
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.aAL = str;
        recoveryHandleItem.processName = recoveryData.processName;
        String ho = NetUtil.ho(this);
        boolean isScreenOn = this.pJg.isScreenOn();
        boolean acl = acl("dldir1.qq.com");
        recoveryHandleItem.vhx = ho + "|" + isScreenOn + "|" + acl + "|" + acl("www.qq.com");
        return recoveryHandleItem;
    }

    private static java.lang.String a(java.lang.String r9, com.tencent.recovery.model.RecoveryHandleItem r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.recovery.wx.service.WXRecoveryHandleService.a(java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):java.lang.String, dom blocks: [B:46:0x00ba, B:50:0x00c7]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:89)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r8 = 0;
        r1 = 0;
        r0 = "file://";
        r0 = r9.startsWith(r0);
        if (r0 == 0) goto L_0x0076;
    L_0x000b:
        r0 = "file://";
        r2 = "";
        r0 = r9.replace(r0, r2);
        r2 = new java.io.File;
        r2.<init>(r0);
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x005f, all -> 0x006b }
        r0.<init>(r2);	 Catch:{ Exception -> 0x005f, all -> 0x006b }
        r5 = com.tencent.recovery.wx.util.FileUtil.g(r0);	 Catch:{ Exception -> 0x0191, all -> 0x018c }
        r0.close();	 Catch:{ IOException -> 0x0161 }
    L_0x0026:
        if (r5 == 0) goto L_0x015e;
    L_0x0028:
        r0 = com.tencent.recovery.wx.util.EncryptUtil.u(r5);	 Catch:{ Exception -> 0x0135 }
        r2 = "Recovery.WXRecoveryHandleService";	 Catch:{ Exception -> 0x0135 }
        r3 = "config data md5=%s";	 Catch:{ Exception -> 0x0135 }
        r4 = 1;	 Catch:{ Exception -> 0x0135 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0135 }
        r6 = 0;	 Catch:{ Exception -> 0x0135 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x0135 }
        com.tencent.recovery.log.RecoveryLog.i(r2, r3, r4);	 Catch:{ Exception -> 0x0135 }
        r2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0oMW80k4h7zmBbHGhzQzs5Jv1uy5j0JVUG//dWHeu0q6PF/xCU97h/e6h2Q9SXLu0M4TTd89QMXbab9MMUXrxqIqVjzm92A4WyNbAElAwhE9AGO16ryYn+tNzDfmwyjVz6dwLzZbNjjH7akYZRopJYqo17kKn+xrnqM+GRKMOJQIDAQAB";	 Catch:{ Exception -> 0x0135 }
        r2 = com.tencent.recovery.wx.util.EncryptUtil.h(r5, r2);	 Catch:{ Exception -> 0x0135 }
        if (r2 != 0) goto L_0x011b;	 Catch:{ Exception -> 0x0135 }
    L_0x0044:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0135 }
        r3 = "KeyConfigDecryptFail[";	 Catch:{ Exception -> 0x0135 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0135 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0135 }
        r2 = "]";	 Catch:{ Exception -> 0x0135 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x0135 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0135 }
        r10.aAL = r0;	 Catch:{ Exception -> 0x0135 }
        r0 = r1;
    L_0x005e:
        return r0;
    L_0x005f:
        r0 = move-exception;
        r0 = r1;
    L_0x0061:
        if (r0 == 0) goto L_0x0074;
    L_0x0063:
        r0.close();	 Catch:{ IOException -> 0x0068 }
        r5 = r1;
        goto L_0x0026;
    L_0x0068:
        r0 = move-exception;
        r5 = r1;
        goto L_0x0026;
    L_0x006b:
        r0 = move-exception;
        r2 = r0;
        r3 = r1;
    L_0x006e:
        if (r3 == 0) goto L_0x0073;
    L_0x0070:
        r3.close();	 Catch:{ IOException -> 0x0164 }
    L_0x0073:
        throw r2;
    L_0x0074:
        r5 = r1;
        goto L_0x0026;
    L_0x0076:
        r0 = com.tencent.recovery.wx.util.WXUtil.acm(r9);
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x017a, all -> 0x016e }
        r2.<init>(r0);	 Catch:{ Exception -> 0x017a, all -> 0x016e }
        r0 = r2.openConnection();	 Catch:{ Exception -> 0x017a, all -> 0x016e }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x017a, all -> 0x016e }
        r2 = "GET";	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r0.connect();	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        if (r2 == r3) goto L_0x00b4;	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
    L_0x00a0:
        r2 = com.tencent.recovery.wx.util.WXUtil.Hk(r2);	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r10.aAL = r2;	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        r3 = r1;
        r5 = r1;
    L_0x00a8:
        if (r3 == 0) goto L_0x00ad;
    L_0x00aa:
        r3.close();	 Catch:{ IOException -> 0x0167 }
    L_0x00ad:
        if (r0 == 0) goto L_0x0026;
    L_0x00af:
        r0.disconnect();
        goto L_0x0026;
    L_0x00b4:
        r3 = r0.getInputStream();	 Catch:{ Exception -> 0x0181, all -> 0x0173 }
        if (r3 != 0) goto L_0x00c1;
    L_0x00ba:
        r2 = "KeyConfigHttpInputStreamIsNull";	 Catch:{ Exception -> 0x0187, all -> 0x010d }
        r10.aAL = r2;	 Catch:{ Exception -> 0x0187, all -> 0x010d }
        r5 = r1;	 Catch:{ Exception -> 0x0187, all -> 0x010d }
        goto L_0x00a8;	 Catch:{ Exception -> 0x0187, all -> 0x010d }
    L_0x00c1:
        r5 = g(r3);	 Catch:{ Exception -> 0x0187, all -> 0x010d }
        if (r5 != 0) goto L_0x0104;
    L_0x00c7:
        r2 = "KeyConfigHttpInputStreamReadDataIsNull";	 Catch:{ Exception -> 0x00cd, all -> 0x010d }
        r10.aAL = r2;	 Catch:{ Exception -> 0x00cd, all -> 0x010d }
        goto L_0x00a8;
    L_0x00cd:
        r2 = move-exception;
        r4 = r0;
    L_0x00cf:
        r0 = "Recovery.WXRecoveryHandleService";	 Catch:{ all -> 0x0177 }
        r6 = "getConfigData";	 Catch:{ all -> 0x0177 }
        r7 = 0;	 Catch:{ all -> 0x0177 }
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0177 }
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r0, r2, r6, r7);	 Catch:{ all -> 0x0177 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0177 }
        r6 = "Config HttpInputStream Exception: [";	 Catch:{ all -> 0x0177 }
        r0.<init>(r6);	 Catch:{ all -> 0x0177 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0177 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0177 }
        r2 = "]";	 Catch:{ all -> 0x0177 }
        r0 = r0.append(r2);	 Catch:{ all -> 0x0177 }
        r0 = r0.toString();	 Catch:{ all -> 0x0177 }
        r10.aAL = r0;	 Catch:{ all -> 0x0177 }
        if (r3 == 0) goto L_0x00fd;
    L_0x00fa:
        r3.close();	 Catch:{ IOException -> 0x016a }
    L_0x00fd:
        if (r4 == 0) goto L_0x0026;
    L_0x00ff:
        r4.disconnect();
        goto L_0x0026;
    L_0x0104:
        r2 = r5.length;	 Catch:{ Exception -> 0x00cd, all -> 0x010d }
        if (r2 != 0) goto L_0x00a8;	 Catch:{ Exception -> 0x00cd, all -> 0x010d }
    L_0x0107:
        r2 = "KeyConfigHttpInputStreamReadDataLengthZero";	 Catch:{ Exception -> 0x00cd, all -> 0x010d }
        r10.aAL = r2;	 Catch:{ Exception -> 0x00cd, all -> 0x010d }
        goto L_0x00a8;
    L_0x010d:
        r1 = move-exception;
        r2 = r1;
        r4 = r0;
    L_0x0110:
        if (r3 == 0) goto L_0x0115;
    L_0x0112:
        r3.close();	 Catch:{ IOException -> 0x016c }
    L_0x0115:
        if (r4 == 0) goto L_0x011a;
    L_0x0117:
        r4.disconnect();
    L_0x011a:
        throw r2;
    L_0x011b:
        r0 = "Recovery.WXRecoveryHandleService";	 Catch:{ Exception -> 0x0135 }
        r3 = "config data decrypt md5=%s";	 Catch:{ Exception -> 0x0135 }
        r4 = 1;	 Catch:{ Exception -> 0x0135 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0135 }
        r5 = 0;	 Catch:{ Exception -> 0x0135 }
        r6 = com.tencent.recovery.wx.util.EncryptUtil.u(r2);	 Catch:{ Exception -> 0x0135 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0135 }
        com.tencent.recovery.log.RecoveryLog.i(r0, r3, r4);	 Catch:{ Exception -> 0x0135 }
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0135 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0135 }
        goto L_0x005e;
    L_0x0135:
        r0 = move-exception;
        r2 = "Recovery.WXRecoveryHandleService";
        r3 = "getConfigData";
        r4 = new java.lang.Object[r8];
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r2, r0, r3, r4);
        r2 = new java.lang.StringBuilder;
        r3 = "Config Decrypt Exception: [";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r2 = "]";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r10.aAL = r0;
    L_0x015e:
        r0 = r1;
        goto L_0x005e;
    L_0x0161:
        r0 = move-exception;
        goto L_0x0026;
    L_0x0164:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0167:
        r2 = move-exception;
        goto L_0x00ad;
    L_0x016a:
        r0 = move-exception;
        goto L_0x00fd;
    L_0x016c:
        r0 = move-exception;
        goto L_0x0115;
    L_0x016e:
        r0 = move-exception;
        r2 = r0;
        r3 = r1;
        r4 = r1;
        goto L_0x0110;
    L_0x0173:
        r2 = move-exception;
        r3 = r1;
        r4 = r0;
        goto L_0x0110;
    L_0x0177:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0110;
    L_0x017a:
        r0 = move-exception;
        r2 = r0;
        r3 = r1;
        r4 = r1;
        r5 = r1;
        goto L_0x00cf;
    L_0x0181:
        r2 = move-exception;
        r3 = r1;
        r4 = r0;
        r5 = r1;
        goto L_0x00cf;
    L_0x0187:
        r2 = move-exception;
        r4 = r0;
        r5 = r1;
        goto L_0x00cf;
    L_0x018c:
        r1 = move-exception;
        r2 = r1;
        r3 = r0;
        goto L_0x006e;
    L_0x0191:
        r2 = move-exception;
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryHandleService.a(java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):java.lang.String");
    }

    private static byte[] a(java.lang.String r7, java.lang.String r8, com.tencent.recovery.model.RecoveryHandleItem r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.recovery.wx.service.WXRecoveryHandleService.a(java.lang.String, java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):byte[], dom blocks: [B:39:0x007f, B:43:0x008c]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:89)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r1 = 0;
        r0 = "file://";
        r0 = r7.startsWith(r0);
        if (r0 == 0) goto L_0x003b;
    L_0x000a:
        r0 = "file://";
        r2 = "";
        r0 = r7.replace(r0, r2);
        r3 = new java.io.File;
        r3.<init>(r0);
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0026, all -> 0x0032 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0026, all -> 0x0032 }
        r0 = g(r2);	 Catch:{ Exception -> 0x0122, all -> 0x011e }
        r2.close();	 Catch:{ IOException -> 0x00f4 }
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = move-exception;
        r0 = r1;
    L_0x0028:
        if (r0 == 0) goto L_0x0039;
    L_0x002a:
        r0.close();	 Catch:{ IOException -> 0x002f }
        r0 = r1;
        goto L_0x0025;
    L_0x002f:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0025;
    L_0x0032:
        r0 = move-exception;
    L_0x0033:
        if (r1 == 0) goto L_0x0038;
    L_0x0035:
        r1.close();	 Catch:{ IOException -> 0x00f7 }
    L_0x0038:
        throw r0;
    L_0x0039:
        r0 = r1;
        goto L_0x0025;
    L_0x003b:
        r0 = com.tencent.recovery.wx.util.WXUtil.acm(r7);
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x010d, all -> 0x0101 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x010d, all -> 0x0101 }
        r0 = r2.openConnection();	 Catch:{ Exception -> 0x010d, all -> 0x0101 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x010d, all -> 0x0101 }
        r2 = "GET";	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r0.connect();	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        if (r2 == r3) goto L_0x0079;	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
    L_0x0065:
        r2 = com.tencent.recovery.wx.util.WXUtil.Hl(r2);	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r9.aAL = r2;	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        r4 = r1;
        r2 = r1;
    L_0x006d:
        if (r4 == 0) goto L_0x0072;
    L_0x006f:
        r4.close();	 Catch:{ IOException -> 0x00fa }
    L_0x0072:
        if (r0 == 0) goto L_0x0126;
    L_0x0074:
        r0.disconnect();
        r0 = r2;
        goto L_0x0025;
    L_0x0079:
        r4 = r0.getInputStream();	 Catch:{ Exception -> 0x0113, all -> 0x0106 }
        if (r4 != 0) goto L_0x0086;
    L_0x007f:
        r2 = "KeyPatchHttpInputStreamIsNull";	 Catch:{ Exception -> 0x0119, all -> 0x00d4 }
        r9.aAL = r2;	 Catch:{ Exception -> 0x0119, all -> 0x00d4 }
        r2 = r1;	 Catch:{ Exception -> 0x0119, all -> 0x00d4 }
        goto L_0x006d;	 Catch:{ Exception -> 0x0119, all -> 0x00d4 }
    L_0x0086:
        r2 = com.tencent.recovery.wx.util.FileUtil.g(r4);	 Catch:{ Exception -> 0x0119, all -> 0x00d4 }
        if (r2 != 0) goto L_0x00cb;
    L_0x008c:
        r1 = "KeyPatchHttpInputStreamReadDataIsNull";	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
        r9.aAL = r1;	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
        goto L_0x006d;
    L_0x0092:
        r1 = move-exception;
        r3 = r1;
        r5 = r0;
    L_0x0095:
        r0 = "Recovery.WXRecoveryHandleService";	 Catch:{ all -> 0x010a }
        r1 = "getPatchDataFromHttp";	 Catch:{ all -> 0x010a }
        r6 = 0;	 Catch:{ all -> 0x010a }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x010a }
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r0, r3, r1, r6);	 Catch:{ all -> 0x010a }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010a }
        r1 = "Patch HttpInputStream Exception: [";	 Catch:{ all -> 0x010a }
        r0.<init>(r1);	 Catch:{ all -> 0x010a }
        r1 = r3.getMessage();	 Catch:{ all -> 0x010a }
        r0 = r0.append(r1);	 Catch:{ all -> 0x010a }
        r1 = "]";	 Catch:{ all -> 0x010a }
        r0 = r0.append(r1);	 Catch:{ all -> 0x010a }
        r0 = r0.toString();	 Catch:{ all -> 0x010a }
        r9.aAL = r0;	 Catch:{ all -> 0x010a }
        if (r4 == 0) goto L_0x00c3;
    L_0x00c0:
        r4.close();	 Catch:{ IOException -> 0x00fd }
    L_0x00c3:
        if (r5 == 0) goto L_0x0126;
    L_0x00c5:
        r5.disconnect();
        r0 = r2;
        goto L_0x0025;
    L_0x00cb:
        r3 = r2.length;	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
        if (r3 != 0) goto L_0x00e2;	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
    L_0x00ce:
        r1 = "KeyPatchHttpInputStreamReadDataLengthZero";	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
        r9.aAL = r1;	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
        goto L_0x006d;
    L_0x00d4:
        r1 = move-exception;
        r2 = r1;
        r5 = r0;
    L_0x00d7:
        if (r4 == 0) goto L_0x00dc;
    L_0x00d9:
        r4.close();	 Catch:{ IOException -> 0x00ff }
    L_0x00dc:
        if (r5 == 0) goto L_0x00e1;
    L_0x00de:
        r5.disconnect();
    L_0x00e1:
        throw r2;
    L_0x00e2:
        r3 = com.tencent.recovery.wx.util.EncryptUtil.u(r2);	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
        r3 = r3.equals(r8);	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
        if (r3 != 0) goto L_0x006d;	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
    L_0x00ec:
        r3 = "KeyPatchCheckMd5Fail";	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
        r9.aAL = r3;	 Catch:{ Exception -> 0x0092, all -> 0x00d4 }
        r2 = r1;
        goto L_0x006d;
    L_0x00f4:
        r1 = move-exception;
        goto L_0x0025;
    L_0x00f7:
        r1 = move-exception;
        goto L_0x0038;
    L_0x00fa:
        r1 = move-exception;
        goto L_0x0072;
    L_0x00fd:
        r0 = move-exception;
        goto L_0x00c3;
    L_0x00ff:
        r0 = move-exception;
        goto L_0x00dc;
    L_0x0101:
        r0 = move-exception;
        r2 = r0;
        r4 = r1;
        r5 = r1;
        goto L_0x00d7;
    L_0x0106:
        r2 = move-exception;
        r4 = r1;
        r5 = r0;
        goto L_0x00d7;
    L_0x010a:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00d7;
    L_0x010d:
        r0 = move-exception;
        r3 = r0;
        r4 = r1;
        r5 = r1;
        r2 = r1;
        goto L_0x0095;
    L_0x0113:
        r3 = move-exception;
        r4 = r1;
        r5 = r0;
        r2 = r1;
        goto L_0x0095;
    L_0x0119:
        r3 = move-exception;
        r5 = r0;
        r2 = r1;
        goto L_0x0095;
    L_0x011e:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0033;
    L_0x0122:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0028;
    L_0x0126:
        r0 = r2;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryHandleService.a(java.lang.String, java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):byte[]");
    }

    private static byte[] g(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static boolean acl(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName == null || byName.getHostAddress() == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
