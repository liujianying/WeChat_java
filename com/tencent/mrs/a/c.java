package com.tencent.mrs.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.d.b;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ae;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class c {

    /* renamed from: com.tencent.mrs.a.c$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ byte[] etO;

        AnonymousClass2(byte[] bArr) {
            this.etO = bArr;
        }

        public final void run() {
            HttpURLConnection a;
            InputStream inputStream;
            Throwable th;
            long VF = bi.VF();
            try {
                a = c.a(Base64.encode(this.etO, 0), 1, 111, null, null);
                try {
                    inputStream = a.getInputStream();
                    try {
                        Object convertStreamToString = bi.convertStreamToString(inputStream);
                        if (a.getResponseCode() != HardCoderJNI.sHCDBDELAY_WRITE) {
                            MatrixReport.with().onReportResp(-1, -1, null);
                            b.e("Matrix.ReportMrsUpload", "POST returned: %d , responseString string: %s, use: %d", Integer.valueOf(a.getResponseCode()), convertStreamToString, Long.valueOf(bi.VF() - VF));
                        } else if (TextUtils.isEmpty(convertStreamToString)) {
                            b.i("Matrix.ReportMrsUpload", "report mrs error, responseString string is null, use: %d", Long.valueOf(bi.VF() - VF));
                            MatrixReport.with().onReportResp(-1, -1, null);
                        } else {
                            byte[] decode = Base64.decode(convertStreamToString, 0);
                            ae aeVar = new ae();
                            aeVar.aG(decode);
                            if (aeVar.qZB != 0) {
                                MatrixReport.with().onReportResp(-1, -1, null);
                                b.i("Matrix.ReportMrsUpload", "report mrs error, responseString string: %s, returnValue: %d, use: %d", convertStreamToString, Integer.valueOf(aeVar.qZB), Long.valueOf(bi.VF() - VF));
                            } else {
                                b.i("Matrix.ReportMrsUpload", "report mrs success, responseString string: %s, GeneralStrategyVer: %d, use: %d", convertStreamToString, Integer.valueOf(aeVar.qZC), Long.valueOf(bi.VF() - VF));
                                MatrixReport.with().onReportResp(0, 0, decode);
                            }
                        }
                        c.b(a, inputStream);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    c.b(a, inputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                a = null;
                c.b(a, inputStream);
                throw th;
            }
            try {
                b.printErrStackTrace("Matrix.ReportMrsUpload", th, "matrix report http error", new Object[0]);
                c.b(a, inputStream);
            } catch (Throwable th5) {
                th = th5;
                c.b(a, inputStream);
                throw th;
            }
        }
    }

    public static void a(com.tencent.matrix.c.b bVar, File file, boolean z) {
        if (file == null || !file.exists()) {
            b.e("Matrix.ReportMrsUpload", "report mrs file error, path: %s is null or not exist", file);
            return;
        }
        final long length = file.length();
        if (length <= 0) {
            b.e("Matrix.ReportMrsUpload", "report mrs file error len file:%s len:%d", file.getPath(), Long.valueOf(length));
            return;
        }
        final File file2 = file;
        final com.tencent.matrix.c.b bVar2 = bVar;
        final boolean z2 = z;
        e.b(new Runnable() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r14 = this;
                r4 = com.tencent.mm.sdk.platformtools.bi.VF();
                r0 = "Matrix.ReportMrsUpload";
                r1 = "report mrs file file:%s len:%d";
                r2 = 2;
                r2 = new java.lang.Object[r2];
                r3 = 0;
                r6 = r1;
                r6 = r6.getPath();
                r2[r3] = r6;
                r3 = 1;
                r6 = r2;
                r6 = java.lang.Long.valueOf(r6);
                r2[r3] = r6;
                com.tencent.matrix.d.b.i(r0, r1, r2);
                r0 = 0;
                r2 = r2;
                r6 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
                r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                if (r1 > 0) goto L_0x0077;
            L_0x002c:
                r0 = r1;
                r0 = r0.getAbsolutePath();
                r1 = 0;
                r2 = -1;
                r1 = com.tencent.mm.a.e.f(r0, r1, r2);
                r0 = r4;
                r0 = r0.tag;
                r2 = 0;
                r3 = 1;
                r0 = com.tencent.mrs.a.c.a(r0, r1, r2, r3, r4);
            L_0x0042:
                r1 = "Matrix.ReportMrsUpload";
                r2 = "report mrs file success end, result: %b, path: %s, use: %d";
                r3 = 3;
                r3 = new java.lang.Object[r3];
                r6 = 0;
                r7 = java.lang.Boolean.valueOf(r0);
                r3[r6] = r7;
                r6 = 1;
                r7 = r1;
                r7 = r7.getPath();
                r3[r6] = r7;
                r6 = 2;
                r8 = com.tencent.mm.sdk.platformtools.bi.VF();
                r4 = r8 - r4;
                r4 = java.lang.Long.valueOf(r4);
                r3[r6] = r4;
                com.tencent.matrix.d.b.w(r1, r2, r3);
                if (r0 == 0) goto L_0x0076;
            L_0x006d:
                r0 = r5;
                if (r0 == 0) goto L_0x0076;
            L_0x0071:
                r0 = r1;
                r0.delete();
            L_0x0076:
                return;
            L_0x0077:
                r2 = r2;
                r2 = (double) r2;
                r6 = 4677269688000970752; // 0x40e9000000000000 float:0.0 double:51200.0;
                r2 = r2 / r6;
                r2 = java.lang.Math.ceil(r2);
                r3 = (int) r2;
                r1 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
                r6 = new byte[r1];
                r2 = 0;
                r7 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x016f, all -> 0x0160 }
                r1 = r1;	 Catch:{ Throwable -> 0x016f, all -> 0x0160 }
                r7.<init>(r1);	 Catch:{ Throwable -> 0x016f, all -> 0x0160 }
                r2 = 0;
            L_0x0090:
                if (r2 >= r3) goto L_0x00b9;
            L_0x0092:
                r0 = 0;
                r1 = 0;
                r8 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
                r8 = r7.read(r6, r1, r8);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                if (r8 >= 0) goto L_0x00bf;
            L_0x009d:
                r1 = "Matrix.ReportMrsUpload";
                r2 = "report mrs file fail:%s read:%d";
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r6 = 0;
                r9 = r1;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r9 = r9.getPath();	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r3[r6] = r9;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r6 = 1;
                r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r3[r6] = r8;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                com.tencent.matrix.d.b.i(r1, r2, r3);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
            L_0x00b9:
                r7.close();	 Catch:{ IOException -> 0x00bd }
                goto L_0x0042;
            L_0x00bd:
                r1 = move-exception;
                goto L_0x0042;
            L_0x00bf:
                r1 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
                if (r8 >= r1) goto L_0x0175;
            L_0x00c4:
                r1 = "Matrix.ReportMrsUpload";
                r9 = "report mrs file read %d smaller than max len %d";
                r10 = 2;
                r10 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r11 = 0;
                r12 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r10[r11] = r12;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r11 = 1;
                r12 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
                r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r10[r11] = r12;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                com.tencent.matrix.d.b.i(r1, r9, r10);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r1 = new byte[r8];	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r9 = 0;
                r10 = 0;
                java.lang.System.arraycopy(r6, r9, r1, r10, r8);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
            L_0x00e8:
                r9 = 0;
                r8 = r0;
            L_0x00ea:
                r0 = 2;
                if (r9 >= r0) goto L_0x011c;
            L_0x00ed:
                r0 = r4;	 Catch:{ Throwable -> 0x0171, all -> 0x016a }
                r0 = r0.tag;	 Catch:{ Throwable -> 0x0171, all -> 0x016a }
                r0 = com.tencent.mrs.a.c.a(r0, r1, r2, r3, r4);	 Catch:{ Throwable -> 0x0171, all -> 0x016a }
                if (r0 != 0) goto L_0x011d;
            L_0x00f7:
                r8 = "Matrix.ReportMrsUpload";
                r10 = "report mrs file error, sequence: %d, total:%d, retry: %d";
                r11 = 3;
                r11 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r12 = 0;
                r13 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r11[r12] = r13;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r12 = 1;
                r13 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r11[r12] = r13;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r12 = 2;
                r13 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r11[r12] = r13;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                com.tencent.matrix.d.b.e(r8, r10, r11);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r9 = r9 + 1;
                r8 = r0;
                goto L_0x00ea;
            L_0x011c:
                r0 = r8;
            L_0x011d:
                if (r0 != 0) goto L_0x015c;
            L_0x011f:
                r1 = "Matrix.ReportMrsUpload";
                r6 = "report mrs file error, path: %s, sequence: %d, total:%d";
                r8 = 3;
                r8 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r9 = 0;
                r10 = r1;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r10 = r10.getPath();	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r8[r9] = r10;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r9 = 1;
                r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r8[r9] = r2;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r2 = 2;
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                r8[r2] = r3;	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                com.tencent.matrix.d.b.e(r1, r6, r8);	 Catch:{ Throwable -> 0x0144, all -> 0x016a }
                goto L_0x00b9;
            L_0x0144:
                r1 = move-exception;
                r2 = r7;
            L_0x0146:
                r3 = "Matrix.ReportMrsUpload";
                r6 = "matrix report read file error";
                r7 = 0;
                r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x016c }
                com.tencent.matrix.d.b.printErrStackTrace(r3, r1, r6, r7);	 Catch:{ all -> 0x016c }
                if (r2 == 0) goto L_0x0042;
            L_0x0154:
                r2.close();	 Catch:{ IOException -> 0x0159 }
                goto L_0x0042;
            L_0x0159:
                r1 = move-exception;
                goto L_0x0042;
            L_0x015c:
                r2 = r2 + 1;
                goto L_0x0090;
            L_0x0160:
                r0 = move-exception;
                r7 = r2;
            L_0x0162:
                if (r7 == 0) goto L_0x0167;
            L_0x0164:
                r7.close();	 Catch:{ IOException -> 0x0168 }
            L_0x0167:
                throw r0;
            L_0x0168:
                r1 = move-exception;
                goto L_0x0167;
            L_0x016a:
                r0 = move-exception;
                goto L_0x0162;
            L_0x016c:
                r0 = move-exception;
                r7 = r2;
                goto L_0x0162;
            L_0x016f:
                r1 = move-exception;
                goto L_0x0146;
            L_0x0171:
                r1 = move-exception;
                r2 = r7;
                r0 = r8;
                goto L_0x0146;
            L_0x0175:
                r1 = r6;
                goto L_0x00e8;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mrs.a.c.1.run():void");
            }
        }, "ReportMrsUploadFile", 10);
    }

    private static boolean a(String str, byte[] bArr, int i, int i2, long j) {
        HttpURLConnection httpURLConnection = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpURLConnection = a(bArr, 19860829, -1, new StringBuffer().append(j).append('.').append(i).append('.').append(i2).toString(), str);
            if (httpURLConnection.getResponseCode() != HardCoderJNI.sHCDBDELAY_WRITE) {
                b(httpURLConnection, null);
                b.i("Matrix.ReportMrsUpload", "report file with data length: %d, sequence: %d, total: %d, nowMilliSecond: %d, use: %dms", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return false;
            }
            b(httpURLConnection, null);
            b.i("Matrix.ReportMrsUpload", "report file with data length: %d, sequence: %d, total: %d, nowMilliSecond: %d, use: %dms", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return true;
        } catch (Throwable th) {
            b(httpURLConnection, null);
            b.i("Matrix.ReportMrsUpload", "report file with data length: %d, sequence: %d, total: %d, nowMilliSecond: %d, use: %dms", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    static HttpURLConnection a(byte[] bArr, int i, int i2, String str, String str2) {
        String toLowerCase = g.u(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.qVN), Integer.valueOf(bArr.length)}).getBytes()).toLowerCase();
        byte[] r = q.r(bArr);
        PByteArray pByteArray = new PByteArray();
        com.tencent.mm.a.c.a(pByteArray, r, toLowerCase.getBytes());
        String GF = (ad.cic() && com.tencent.mm.kernel.g.Eg().Dx()) ? com.tencent.mm.model.q.GF() : null;
        StringBuilder append = new StringBuilder(512).append("http://support.weixin.qq.com/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.qVN)).append("&devicetype=").append("android-" + VERSION.SDK_INT).append("&filelength=").append(r1).append("&sum=").append(toLowerCase).append("&reporttype=").append(i);
        if (i2 > 0) {
            append.append("&NewReportType=").append(i2);
        }
        if (str != null) {
            append.append("&reportvalue=").append(str);
        }
        if (!(GF == null || GF.length() == 0)) {
            append.append("&username=").append(GF);
        }
        if (str2 != null) {
            append.append("&rtxname=").append(str2);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(append.toString()).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setRequestProperty("content-type", "binary/octet-stream");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(pByteArray.value);
        outputStream.flush();
        outputStream.close();
        return httpURLConnection;
    }

    static void b(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                b.printErrStackTrace("Matrix.ReportMrsUpload", e, "close error", new Object[0]);
            }
        }
    }
}
