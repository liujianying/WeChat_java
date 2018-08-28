package com.tencent.matrix.mrs.core;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.d.b;
import com.tencent.matrix.mrs.core.MrsLogic.PhoneInfo;
import com.tencent.mrs.a.c;
import com.tencent.mrs.util.MatrixReportBroadcast;
import com.tencent.mrs.util.MatrixStrategyNotifyBroadcast;
import java.io.File;
import org.json.JSONObject;

public class MatrixReport {
    private static final String TAG = "Matrix.MatrixReport";
    private static MrsCallback mrsCallback;
    private static volatile MatrixReport sInstance;
    private final long clientVersion;
    private final Context context;
    private final boolean isDebug;
    private final boolean isReportProcess;
    private final String processName;
    private final String revision;
    private long uin;

    public static class Builder {
        private Long clientVersion;
        private final Context context;
        private Boolean isDebug;
        private Boolean isReportProcess;
        private String processName;
        private String revision;

        public Builder(Context context) {
            if (context == null) {
                throw new RuntimeException("matrix report init, context is null");
            }
            this.context = context;
        }

        public Builder clientVersion(long j) {
            this.clientVersion = Long.valueOf(j);
            return this;
        }

        public Builder revision(String str) {
            this.revision = str;
            return this;
        }

        public Builder isDebug(boolean z) {
            this.isDebug = Boolean.valueOf(z);
            return this;
        }

        public Builder isReportProcess(boolean z) {
            this.isReportProcess = Boolean.valueOf(z);
            return this;
        }

        public Builder processName(String str) {
            this.processName = str;
            return this;
        }

        public MatrixReport build() {
            if (this.processName == null) {
                throw new RuntimeException("matrix report init, processName is null");
            } else if (this.clientVersion == null) {
                throw new RuntimeException("matrix report init, clientVersion is null");
            } else if (this.revision == null) {
                throw new RuntimeException("matrix report init, revision is null");
            } else {
                if (this.isDebug == null) {
                    this.isDebug = Boolean.valueOf(false);
                }
                if (this.isReportProcess == null) {
                    this.isReportProcess = Boolean.valueOf(false);
                }
                return new MatrixReport(this.context, this.processName, this.clientVersion.longValue(), this.revision, this.isDebug.booleanValue(), this.isReportProcess.booleanValue());
            }
        }
    }

    private MatrixReport(Context context, String str, long j, String str2, boolean z, boolean z2) {
        this.uin = 0;
        this.clientVersion = j;
        this.revision = str2;
        this.isDebug = z;
        this.context = context;
        this.processName = str;
        this.isReportProcess = z2;
        if (z2) {
            try {
                MrsLogic.init(j, str2, z);
                return;
            } catch (Throwable th) {
                b.printErrStackTrace(TAG, th, "call oncreate err", new Object[0]);
                MrsLogic.init(j, str2, z);
                return;
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("strategyNotify");
        context.registerReceiver(new MatrixStrategyNotifyBroadcast(), intentFilter, "com.tencent.mm.matrix.strategynotify", null);
    }

    public static void setMrsCallback(MrsCallback mrsCallback) {
        mrsCallback = mrsCallback;
        MrsLogic.setCallBack(mrsCallback);
    }

    public static boolean isInstalled() {
        return sInstance != null;
    }

    public static MatrixReport init(MatrixReport matrixReport) {
        if (matrixReport == null) {
            throw new RuntimeException("Matrix report init, matrixReport should not be null.");
        }
        synchronized (MatrixReport.class) {
            if (sInstance == null) {
                sInstance = matrixReport;
            } else {
                b.e(TAG, "Matrix report instance is already set. this invoking will be ignored", new Object[0]);
            }
        }
        return sInstance;
    }

    public static MatrixReport with() {
        if (sInstance != null) {
            return sInstance;
        }
        throw new RuntimeException("you must init Matrix report sdk first");
    }

    public static MrsCallback getMrsCallback() {
        return mrsCallback;
    }

    public void onDestroy() {
        if (this.isReportProcess) {
            MrsLogic.onDestroy();
        }
    }

    public void onCrash() {
        if (this.isReportProcess) {
            MrsLogic.onCrash();
        }
    }

    public void onForeground(boolean z) {
        if (this.isReportProcess) {
            MrsLogic.onForeground(z);
        }
    }

    public void report(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            try {
                b.e(TAG, "Matrix report, tag %s or data %s is null, just return", str, jSONObject);
            } catch (Throwable th) {
                b.e(TAG, "Matrix report occur error:" + th, new Object[0]);
            }
        } else if (this.isReportProcess) {
            with().reportLocal(str, jSONObject.toString());
        } else {
            Intent intent = new Intent(this.context, MatrixReportBroadcast.class);
            intent.putExtra("tag", str);
            intent.putExtra("value", jSONObject.toString());
            b.i(TAG, "Matrix report with broadcast tag:%s, data:%s", str, jSONObject.toString());
            this.context.sendBroadcast(intent);
        }
    }

    public void report(com.tencent.matrix.c.b bVar, File file) {
        c.a(bVar, file, true);
    }

    public void report(com.tencent.matrix.c.b bVar, File file, boolean z) {
        if (!(bVar == null || file == null)) {
            try {
                if (file.exists()) {
                    c.a(bVar, file, z);
                    return;
                }
            } catch (Throwable th) {
                b.e(TAG, "Matrix report occur error:" + th, new Object[0]);
                return;
            }
        }
        b.e(TAG, "Matrix report, tag %s or file %s is null, just return", bVar, file);
    }

    public void reportLocal(String str, String str2) {
        if (str == null || str2 == null) {
            b.e(TAG, "Matrix reportLocal, tag %s or data %s is null, just return", str, str2);
        } else if (this.isReportProcess) {
            b.i(TAG, "Matrix reportLocal tag:%s, data:%s", str, str2.toString());
            MrsLogic.collectData(str, str2.getBytes());
        } else {
            b.e(TAG, "Matrix reportLocal, only report process can report directly, current:%s", this.processName);
        }
    }

    public void setUin(long j) {
        this.uin = j;
        if (this.isReportProcess) {
            MrsLogic.setUin(j);
        }
    }

    public PhoneInfo getPhoneInfo() {
        return MrsLogic.getPhoneInfo();
    }

    public void onReportResp(int i, int i2, byte[] bArr) {
        MrsLogic.onReportResp(i, i2, bArr);
    }

    public void onStrategyResp(int i, int i2, byte[] bArr) {
        MrsLogic.onStrategyResp(i, i2, bArr);
    }

    public long getClientVersion() {
        return this.clientVersion;
    }

    public String getRevision() {
        return this.revision;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public long getUin() {
        return this.uin;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean isReportProcess() {
        return this.isReportProcess;
    }

    public String getProcessName() {
        return this.processName;
    }
}
