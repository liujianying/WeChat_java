package com.tencent.xweb.xwalk.a;

import android.os.AsyncTask;
import java.util.Timer;
import org.xwalk.core.XWalkInitializer;

public final class f extends AsyncTask<a, b, c> {
    private Timer bno = null;
    b vFI = null;
    a vFJ = null;
    int vFK = 0;
    long vFL = 0;

    static /* synthetic */ void a(a aVar, b bVar, int i) {
        f fVar = new f();
        fVar.vFI = bVar;
        fVar.vFJ = aVar;
        fVar.vFK = i;
        fVar.vFL = System.currentTimeMillis();
        fVar.execute(new a[]{fVar.vFJ});
    }

    static /* synthetic */ void d(f fVar) {
        if (fVar.bno != null) {
            fVar.bno.cancel();
            fVar.bno = null;
        }
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Object obj2 = null;
        c cVar = (c) obj;
        if (cVar == null) {
            cVar = new c();
            cVar.vFP = -10004;
            XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para onPostExecute");
        }
        if (cVar.vFP == 0) {
            XWalkInitializer.addXWalkInitializeLog("task succeed! ");
            this.vFI.a(cVar);
            return;
        }
        XWalkInitializer.addXWalkInitializeLog("task failed! retcode = " + cVar.vFP + " mRetrytimes = " + this.vFK);
        if (!(this.vFK >= 2 || cVar.vFP == -10001 || cVar.vFP == -10004)) {
            obj2 = 1;
        }
        if (obj2 != null) {
            this.vFK++;
            XWalkInitializer.addXWalkInitializeLog("task retry!  mRetrytimes = " + this.vFK);
            this.bno = new Timer();
            this.bno.schedule(new 1(this), 3000 * ((long) this.vFK));
            return;
        }
        this.vFI.b(cVar);
    }

    protected final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }

    protected final void onPreExecute() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.xweb.xwalk.a.f.c a(com.tencent.xweb.xwalk.a.f.a... r15) {
        /*
        r14 = this;
        if (r15 != 0) goto L_0x0004;
    L_0x0002:
        r2 = 0;
    L_0x0003:
        return r2;
    L_0x0004:
        r2 = r15.length;
        r3 = 1;
        if (r2 == r3) goto L_0x000a;
    L_0x0008:
        r2 = 0;
        goto L_0x0003;
    L_0x000a:
        r2 = 0;
        r9 = r15[r2];
        if (r9 != 0) goto L_0x0011;
    L_0x000f:
        r2 = 0;
        goto L_0x0003;
    L_0x0011:
        r4 = new com.tencent.xweb.xwalk.a.f$c;
        r4.<init>();
        r2 = r9.mUrl;
        r4.mUrl = r2;
        r2 = r9.mFilePath;
        r4.mFilePath = r2;
        r2 = 0;
        r4.vFP = r2;
        r2 = "";
        r4.fGO = r2;
        r2 = r14.vFK;
        r4.mRetryTimes = r2;
        r2 = 0;
        r4.vFQ = r2;
        r2 = 0;
        r4.mTotalSize = r2;
        r2 = 0;
        r4.vFR = r2;
        r2 = org.xwalk.core.XWalkEnvironment.getApplicationContext();
        r2 = org.xwalk.core.NetworkUtil.getCurrentNetWorkStatus(r2);
        r4.mNetWorkType = r2;
        r2 = r9.mUrl;
        if (r2 == 0) goto L_0x005b;
    L_0x0043:
        r2 = r9.mFilePath;
        if (r2 == 0) goto L_0x005b;
    L_0x0047:
        r2 = r9.mUrl;
        r2 = r2.length();
        if (r2 == 0) goto L_0x005b;
    L_0x004f:
        r2 = r9.mFilePath;
        r2 = r2.length();
        if (r2 == 0) goto L_0x005b;
    L_0x0057:
        r2 = r14.vFI;
        if (r2 != 0) goto L_0x0067;
    L_0x005b:
        r2 = "XWebHttpTask invalid params para";
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10001; // 0xffffffffffffd8ef float:NaN double:NaN;
        r4.vFP = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x0067:
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x01fa }
        r3 = r9.mUrl;	 Catch:{ Exception -> 0x01fa }
        r2.<init>(r3);	 Catch:{ Exception -> 0x01fa }
        r2 = r2.openConnection();	 Catch:{ Exception -> 0x01fa }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x01fa }
        r3 = "GET";
        r2.setRequestMethod(r3);	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r3 = r9.vFN;	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        if (r3 == 0) goto L_0x009f;
    L_0x0081:
        r3 = r2 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        if (r3 == 0) goto L_0x009f;
    L_0x0085:
        r3 = com.tencent.xweb.xwalk.a.f.d.cJB();	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        if (r3 == 0) goto L_0x009f;
    L_0x008b:
        r5 = r3.getSocketFactory();	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r0 = r2;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r3 = r0;
        r3.setSSLSocketFactory(r5);	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r0 = r2;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r3 = r0;
        r5 = com.tencent.xweb.xwalk.a.f.d.vFT;	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r3.setHostnameVerifier(r5);	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
    L_0x009f:
        r3 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        r2.setConnectTimeout(r3);	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r3 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        r2.setReadTimeout(r3);	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 != r5) goto L_0x016f;
    L_0x00b1:
        r6 = r2.getInputStream();	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r3 = r2.getContentLength();	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r5 = r9.mFilePath;	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r8.<init>(r5);	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r10 = r8.exists();	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        if (r10 == 0) goto L_0x00c9;
    L_0x00c6:
        r8.delete();	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
    L_0x00c9:
        r8 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r8.<init>(r5);	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        r5 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r10 = 0;
        r7 = new com.tencent.xweb.xwalk.a.f$b;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r7.<init>();	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r9 = r9.mUrl;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r7.mUrl = r9;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r12 = (long) r3;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r7.mTotalSize = r12;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
    L_0x00e0:
        r9 = r6.read(r5);	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r12 = -1;
        if (r9 == r12) goto L_0x0163;
    L_0x00e7:
        r12 = r14.isCancelled();	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        if (r12 == 0) goto L_0x011f;
    L_0x00ed:
        r6.close();	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r8.close();	 Catch:{ IOException -> 0x0100 }
        if (r6 == 0) goto L_0x00f8;
    L_0x00f5:
        r6.close();	 Catch:{ IOException -> 0x0100 }
    L_0x00f8:
        if (r2 == 0) goto L_0x00fd;
    L_0x00fa:
        r2.disconnect();
    L_0x00fd:
        r2 = 0;
        goto L_0x0003;
    L_0x0100:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r5 = "task close failed  excetion =  ";
        r3.<init>(r5);
        r2 = r2.toString();
        r2 = r3.append(r2);
        r2 = r2.toString();
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r4.vFP = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x011f:
        r12 = (long) r9;
        r10 = r10 + r12;
        r12 = 0;
        r8.write(r5, r12, r9);	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r7.vFO = r10;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        if (r3 <= 0) goto L_0x00e0;
    L_0x0129:
        r9 = 1;
        r9 = new com.tencent.xweb.xwalk.a.f.b[r9];	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r12 = 0;
        r9[r12] = r7;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r14.publishProgress(r9);	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        goto L_0x00e0;
    L_0x0133:
        r3 = move-exception;
        r5 = r2;
        r7 = r8;
    L_0x0136:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c2 }
        r8 = "task failed excetion =  ";
        r2.<init>(r8);	 Catch:{ all -> 0x01c2 }
        r3 = r3.toString();	 Catch:{ all -> 0x01c2 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x01c2 }
        r2 = r2.toString();	 Catch:{ all -> 0x01c2 }
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);	 Catch:{ all -> 0x01c2 }
        r2 = -10002; // 0xffffffffffffd8ee float:NaN double:NaN;
        r4.vFP = r2;	 Catch:{ all -> 0x01c2 }
        if (r7 == 0) goto L_0x0156;
    L_0x0153:
        r7.close();	 Catch:{ IOException -> 0x01a3 }
    L_0x0156:
        if (r6 == 0) goto L_0x015b;
    L_0x0158:
        r6.close();	 Catch:{ IOException -> 0x01a3 }
    L_0x015b:
        if (r5 == 0) goto L_0x0160;
    L_0x015d:
        r5.disconnect();
    L_0x0160:
        r2 = r4;
        goto L_0x0003;
    L_0x0163:
        r4.mTotalSize = r10;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r12 = r14.vFL;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r10 = r10 - r12;
        r4.vFQ = r10;	 Catch:{ Exception -> 0x0133, all -> 0x01f6 }
        r7 = r8;
    L_0x016f:
        r2.disconnect();	 Catch:{ Exception -> 0x01fe, all -> 0x01f3 }
        if (r7 == 0) goto L_0x0177;
    L_0x0174:
        r7.close();	 Catch:{ IOException -> 0x0184 }
    L_0x0177:
        if (r6 == 0) goto L_0x017c;
    L_0x0179:
        r6.close();	 Catch:{ IOException -> 0x0184 }
    L_0x017c:
        if (r2 == 0) goto L_0x0181;
    L_0x017e:
        r2.disconnect();
    L_0x0181:
        r2 = r4;
        goto L_0x0003;
    L_0x0184:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r5 = "task close failed  excetion =  ";
        r3.<init>(r5);
        r2 = r2.toString();
        r2 = r3.append(r2);
        r2 = r2.toString();
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r4.vFP = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x01a3:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r5 = "task close failed  excetion =  ";
        r3.<init>(r5);
        r2 = r2.toString();
        r2 = r3.append(r2);
        r2 = r2.toString();
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r4.vFP = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x01c2:
        r2 = move-exception;
        r3 = r2;
    L_0x01c4:
        if (r7 == 0) goto L_0x01c9;
    L_0x01c6:
        r7.close();	 Catch:{ IOException -> 0x01d4 }
    L_0x01c9:
        if (r6 == 0) goto L_0x01ce;
    L_0x01cb:
        r6.close();	 Catch:{ IOException -> 0x01d4 }
    L_0x01ce:
        if (r5 == 0) goto L_0x01d3;
    L_0x01d0:
        r5.disconnect();
    L_0x01d3:
        throw r3;
    L_0x01d4:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r5 = "task close failed  excetion =  ";
        r3.<init>(r5);
        r2 = r2.toString();
        r2 = r3.append(r2);
        r2 = r2.toString();
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r4.vFP = r2;
        r2 = r4;
        goto L_0x0003;
    L_0x01f3:
        r3 = move-exception;
        r5 = r2;
        goto L_0x01c4;
    L_0x01f6:
        r3 = move-exception;
        r5 = r2;
        r7 = r8;
        goto L_0x01c4;
    L_0x01fa:
        r2 = move-exception;
        r3 = r2;
        goto L_0x0136;
    L_0x01fe:
        r3 = move-exception;
        r5 = r2;
        goto L_0x0136;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.a.f.a(com.tencent.xweb.xwalk.a.f$a[]):com.tencent.xweb.xwalk.a.f$c");
    }
}
