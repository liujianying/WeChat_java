package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.xweb.util.e;
import java.io.File;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class XWalkLibraryLoader {
    private static final String DEFAULT_DOWNLOAD_FILE_NAME = "xwalk_download.tmp";
    private static final int DOWNLOAD_TYPE_CDN = 2;
    private static final int DOWNLOAD_TYPE_HTTP = 1;
    private static final String DOWNLOAD_WITHOUT_NOTIFICATION = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
    private static final String TAG = "XWalkLib";
    private static AsyncTask<Void, Integer, Integer> sActiveTask;

    public interface DownloadListener {
        void onDownloadCancelled();

        void onDownloadCompleted(UpdateConfig updateConfig);

        void onDownloadFailed(int i, int i2);

        void onDownloadStarted();

        void onDownloadUpdated(int i);
    }

    private static class HttpDownloadTask extends AsyncTask<Void, Integer, Integer> {
        private static final int DOWNLOAD_FAILED = -1;
        private static final int DOWNLOAD_SUCCESS = 0;
        private static final int UPDATE_INTERVAL_MS = 500;
        private static final String XWALK_DOWNLOAD_DIR = "xwalk_download";
        private Context mContext;
        private UpdateConfig mDownloadConfig;
        private File mDownloadedFile;
        private long mFileTotalSize = 0;
        private boolean mIsDownloadResume = false;
        private DownloadListener mListener;
        private int mNetWorkType = 0;
        private long mProgressUpdateTime;
        private long mStartTimestamp = 0;

        HttpDownloadTask(DownloadListener downloadListener, Context context, UpdateConfig updateConfig) {
            this.mListener = downloadListener;
            this.mContext = context;
            this.mDownloadConfig = updateConfig;
        }

        protected void onPreExecute() {
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask started, config:" + this.mDownloadConfig.getLogSelf());
            XWalkLibraryLoader.sActiveTask = this;
            this.mDownloadedFile = new File(this.mDownloadConfig.getDownloadPath());
            this.mListener.onDownloadStarted();
            this.mStartTimestamp = System.currentTimeMillis();
            this.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext());
            if (this.mDownloadConfig.isPatchUpdate) {
                e.cJb();
            } else {
                e.cIV();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected java.lang.Integer doInBackground(java.lang.Void... r19) {
            /*
            r18 = this;
            r0 = r18;
            r2 = r0.mDownloadConfig;
            if (r2 != 0) goto L_0x000c;
        L_0x0006:
            r2 = -1;
            r2 = java.lang.Integer.valueOf(r2);
        L_0x000b:
            return r2;
        L_0x000c:
            r5 = 0;
            r4 = 0;
            r3 = 0;
            r8 = 0;
            r7 = new java.net.URL;	 Catch:{ Exception -> 0x0223, all -> 0x01f8 }
            r0 = r18;
            r2 = r0.mDownloadConfig;	 Catch:{ Exception -> 0x0223, all -> 0x01f8 }
            r2 = r2.downUrl;	 Catch:{ Exception -> 0x0223, all -> 0x01f8 }
            r7.<init>(r2);	 Catch:{ Exception -> 0x0223, all -> 0x01f8 }
            r2 = r7.openConnection();	 Catch:{ Exception -> 0x0223, all -> 0x01f8 }
            r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x0223, all -> 0x01f8 }
            r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
            r2.setConnectTimeout(r3);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
            r2.setReadTimeout(r3);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r2.connect();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r3 == r6) goto L_0x0074;
        L_0x0037:
            r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = 206; // 0xce float:2.89E-43 double:1.02E-321;
            if (r3 == r6) goto L_0x0074;
        L_0x003f:
            r3 = "XWalkLib";
            r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = "Server returned HTTP ";
            r6.<init>(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = r2.getResponseCode();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.append(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = " ";
            r6 = r6.append(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = r2.getResponseMessage();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.append(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.toString();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            org.xwalk.core.Log.e(r3, r6);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = -1;
            r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            if (r2 == 0) goto L_0x0072;
        L_0x006f:
            r2.disconnect();
        L_0x0072:
            r2 = r3;
            goto L_0x000b;
        L_0x0074:
            r6 = r2.getContentLength();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r0 = r18;
            r3 = r0.mDownloadedFile;	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = r3.exists();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            if (r3 == 0) goto L_0x0231;
        L_0x0082:
            r0 = r18;
            r3 = r0.mDownloadedFile;	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r8 = r3.length();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r10 = (long) r6;	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
            if (r3 != 0) goto L_0x00a5;
        L_0x008f:
            r3 = "XWalkLib";
            r6 = "royle:same size in server success";
            org.xwalk.core.Log.i(r3, r6);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = 0;
            r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            if (r2 == 0) goto L_0x00a2;
        L_0x009f:
            r2.disconnect();
        L_0x00a2:
            r2 = r3;
            goto L_0x000b;
        L_0x00a5:
            r10 = 0;
            r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
            if (r3 <= 0) goto L_0x00b9;
        L_0x00ab:
            r3 = 1;
            r0 = r18;
            r0.mIsDownloadResume = r3;	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = "XWalkLib";
            r6 = "royle:http download IsDownloadResume";
            org.xwalk.core.Log.i(r3, r6);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
        L_0x00b9:
            r2.disconnect();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = r7.openConnection();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r0 = r3;
            r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r2 = r0;
            r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
            r2.setConnectTimeout(r3);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
            r2.setReadTimeout(r3);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = "Range";
            r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = "bytes=";
            r6.<init>(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.append(r8);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = "-";
            r6 = r6.append(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.toString();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r2.setRequestProperty(r3, r6);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = "XWalkLib";
            r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = "royle:download range begin:";
            r6.<init>(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.append(r8);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.toString();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            org.xwalk.core.Log.i(r3, r6);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r2.connect();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r3 == r6) goto L_0x014a;
        L_0x010c:
            r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = 206; // 0xce float:2.89E-43 double:1.02E-321;
            if (r3 == r6) goto L_0x014a;
        L_0x0114:
            r3 = "XWalkLib";
            r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = "Server returned HTTP ";
            r6.<init>(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = r2.getResponseCode();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.append(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = " ";
            r6 = r6.append(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = r2.getResponseMessage();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.append(r7);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r6 = r6.toString();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            org.xwalk.core.Log.e(r3, r6);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r3 = -1;
            r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            if (r2 == 0) goto L_0x0147;
        L_0x0144:
            r2.disconnect();
        L_0x0147:
            r2 = r3;
            goto L_0x000b;
        L_0x014a:
            r6 = r2.getContentLength();	 Catch:{ Exception -> 0x0226, all -> 0x020e }
            r7 = r6;
            r10 = r8;
            r3 = r2;
        L_0x0151:
            r6 = r3.getInputStream();	 Catch:{ Exception -> 0x0223, all -> 0x0213 }
            r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x022a }
            r0 = r18;
            r2 = r0.mDownloadedFile;	 Catch:{ Exception -> 0x022a }
            r8 = 1;
            r5.<init>(r2, r8);	 Catch:{ Exception -> 0x022a }
            r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            r2 = new byte[r2];	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r8 = 0;
        L_0x0165:
            r4 = r6.read(r2);	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r12 = -1;
            if (r4 == r12) goto L_0x01d5;
        L_0x016c:
            r12 = r18.isCancelled();	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            if (r12 == 0) goto L_0x0186;
        L_0x0172:
            r2 = -1;
            r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r5.close();	 Catch:{ IOException -> 0x022e }
            if (r6 == 0) goto L_0x017f;
        L_0x017c:
            r6.close();	 Catch:{ IOException -> 0x022e }
        L_0x017f:
            if (r3 == 0) goto L_0x000b;
        L_0x0181:
            r3.disconnect();
            goto L_0x000b;
        L_0x0186:
            r12 = (long) r4;
            r8 = r8 + r12;
            r12 = 0;
            r5.write(r2, r12, r4);	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r12 = android.os.SystemClock.uptimeMillis();	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r0 = r18;
            r14 = r0.mProgressUpdateTime;	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r14 = r12 - r14;
            r16 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
            r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
            if (r4 <= 0) goto L_0x0165;
        L_0x019c:
            r0 = r18;
            r0.mProgressUpdateTime = r12;	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r4 = 2;
            r4 = new java.lang.Integer[r4];	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r12 = 0;
            r14 = r8 + r10;
            r13 = (int) r14;	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r4[r12] = r13;	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r12 = 1;
            r14 = (long) r7;	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r14 = r14 + r10;
            r13 = (int) r14;	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r4[r12] = r13;	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r0 = r18;
            r0.publishProgress(r4);	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            goto L_0x0165;
        L_0x01bd:
            r2 = move-exception;
            r4 = r5;
        L_0x01bf:
            r2 = -1;
            r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0218 }
            if (r4 == 0) goto L_0x01c9;
        L_0x01c6:
            r4.close();	 Catch:{ IOException -> 0x0221 }
        L_0x01c9:
            if (r6 == 0) goto L_0x01ce;
        L_0x01cb:
            r6.close();	 Catch:{ IOException -> 0x0221 }
        L_0x01ce:
            if (r3 == 0) goto L_0x000b;
        L_0x01d0:
            r3.disconnect();
            goto L_0x000b;
        L_0x01d5:
            r5.flush();	 Catch:{ Exception -> 0x01bd, all -> 0x021c }
            r5.close();	 Catch:{ IOException -> 0x022c }
            if (r6 == 0) goto L_0x01e0;
        L_0x01dd:
            r6.close();	 Catch:{ IOException -> 0x022c }
        L_0x01e0:
            if (r3 == 0) goto L_0x01e5;
        L_0x01e2:
            r3.disconnect();
        L_0x01e5:
            r0 = r18;
            r2 = r0.mDownloadedFile;
            r2 = r2.length();
            r0 = r18;
            r0.mFileTotalSize = r2;
            r2 = 0;
            r2 = java.lang.Integer.valueOf(r2);
            goto L_0x000b;
        L_0x01f8:
            r2 = move-exception;
            r7 = r2;
            r8 = r3;
            r6 = r5;
        L_0x01fc:
            if (r4 == 0) goto L_0x0201;
        L_0x01fe:
            r4.close();	 Catch:{ IOException -> 0x020c }
        L_0x0201:
            if (r6 == 0) goto L_0x0206;
        L_0x0203:
            r6.close();	 Catch:{ IOException -> 0x020c }
        L_0x0206:
            if (r8 == 0) goto L_0x020b;
        L_0x0208:
            r8.disconnect();
        L_0x020b:
            throw r7;
        L_0x020c:
            r2 = move-exception;
            goto L_0x0206;
        L_0x020e:
            r3 = move-exception;
            r7 = r3;
            r8 = r2;
            r6 = r5;
            goto L_0x01fc;
        L_0x0213:
            r2 = move-exception;
            r7 = r2;
            r8 = r3;
            r6 = r5;
            goto L_0x01fc;
        L_0x0218:
            r2 = move-exception;
            r7 = r2;
            r8 = r3;
            goto L_0x01fc;
        L_0x021c:
            r2 = move-exception;
            r7 = r2;
            r8 = r3;
            r4 = r5;
            goto L_0x01fc;
        L_0x0221:
            r4 = move-exception;
            goto L_0x01ce;
        L_0x0223:
            r2 = move-exception;
            r6 = r5;
            goto L_0x01bf;
        L_0x0226:
            r3 = move-exception;
            r3 = r2;
            r6 = r5;
            goto L_0x01bf;
        L_0x022a:
            r2 = move-exception;
            goto L_0x01bf;
        L_0x022c:
            r2 = move-exception;
            goto L_0x01e0;
        L_0x022e:
            r4 = move-exception;
            goto L_0x017f;
        L_0x0231:
            r7 = r6;
            r10 = r8;
            r3 = r2;
            goto L_0x0151;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        protected void onProgressUpdate(Integer... numArr) {
            int i = 0;
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask updated: " + numArr[0] + "/" + numArr[1]);
            if (numArr[1].intValue() > 0) {
                i = (int) ((((double) numArr[0].intValue()) * 100.0d) / ((double) numArr[1].intValue()));
            }
            this.mListener.onDownloadUpdated(i);
        }

        protected void onCancelled(Integer num) {
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask cancelled");
            XWalkLibraryLoader.sActiveTask = null;
            this.mListener.onDownloadCancelled();
        }

        protected void onPostExecute(Integer num) {
            int i;
            int i2 = 1;
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask finished, " + num);
            XWalkLibraryLoader.sActiveTask = null;
            if (num.intValue() == 0) {
                this.mListener.onDownloadCompleted(this.mDownloadConfig);
                if (this.mDownloadConfig.isPatchUpdate) {
                    e.he(System.currentTimeMillis() - this.mStartTimestamp);
                } else {
                    e.hc(System.currentTimeMillis() - this.mStartTimestamp);
                }
            } else {
                this.mListener.onDownloadFailed(-1, 0);
                if (this.mDownloadConfig.isPatchUpdate) {
                    e.cJc();
                } else {
                    e.cIW();
                }
            }
            if (this.mDownloadConfig.isPatchUpdate) {
                i = 2;
            } else {
                i = 1;
            }
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            int i3 = this.mDownloadConfig.apkVer;
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTimestamp;
            if (!this.mIsDownloadResume) {
                i2 = 0;
            }
            e.bh(15124, i + "," + availableVersion + "," + i3 + ",21," + num + "," + this.mNetWorkType + ",0," + currentTimeMillis + "," + this.mFileTotalSize + ",1," + i2);
        }
    }

    public static boolean isInitializing() {
        return false;
    }

    public static boolean isDownloading() {
        return sActiveTask != null && (sActiveTask instanceof HttpDownloadTask);
    }

    public static boolean isSharedLibrary() {
        return XWalkCoreWrapper.getInstance().isSharedMode();
    }

    public static boolean isLibraryReady() {
        return XWalkCoreWrapper.getInstance() != null;
    }

    public static int getLibraryStatus() {
        return XWalkCoreWrapper.getCoreStatus();
    }

    public static void prepareToInit(Context context) {
        XWalkEnvironment.init(context);
        XWalkCoreWrapper.handlePreInit(context.getClass().getName());
    }

    public static void finishInit(Context context) {
        XWalkCoreWrapper.handlePostInit(context.getClass().getName());
    }

    public static void startHttpDownload(DownloadListener downloadListener, Context context, UpdateConfig updateConfig) {
        WXFileDownloaderTask wXFileDownloaderTask = new WXFileDownloaderTask(downloadListener, context, updateConfig);
        if (updateConfig.bUseCdn && wXFileDownloaderTask.isValid()) {
            Log.i(TAG, "use wx file downloader");
            wXFileDownloaderTask.execute(new Void[0]);
            return;
        }
        Log.i(TAG, "use default file downloader");
        new HttpDownloadTask(downloadListener, context, updateConfig).execute(new Void[0]);
    }

    public static boolean cancelHttpDownload() {
        if (sActiveTask != null && (sActiveTask instanceof HttpDownloadTask) && sActiveTask.cancel(true)) {
            return true;
        }
        return false;
    }
}
