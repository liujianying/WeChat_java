package com.tencent.mm.plugin.scanner.a;

import android.graphics.Point;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l {
    public static int mFQ = 0;
    public static int mFR = 1;
    public static int mFS = 2;
    public static l mFT = new l();
    private long mFU = 0;
    public boolean mFV = false;
    public int mFW = 0;
    private long mFX = 0;
    private Point mFY = null;
    private String mFZ;
    private String mGa;
    private String mGb;
    private int mGc;
    private int mGd;
    private String mGe;
    public StringBuilder mGf = new StringBuilder();
    private int mGg;
    private boolean mGh = false;
    public boolean mGi;
    public int mxT = -1;
    private int retryCount = 0;

    public final void es(long j) {
        x.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[]{Long.valueOf(j)});
        this.mFU += j;
    }

    public final void bsc() {
        x.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
        this.mFV = true;
    }

    public final void bsd() {
        x.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[]{Integer.valueOf(this.mFW)});
        this.mFW++;
    }

    public final void vy(int i) {
        x.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[]{Integer.valueOf(i)});
        this.mxT = i;
    }

    public final void dn(int i, int i2) {
        x.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.mFY = new Point(i, i2);
    }

    public final void bse() {
        x.i("MicroMsg.QBarEngineReporter", "addRetryTime, current retry count: %s", new Object[]{Integer.valueOf(this.retryCount)});
        this.retryCount++;
    }

    public final void et(long j) {
        x.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[]{Long.valueOf(j)});
        this.mFX = j;
    }

    public final void a(String str, String str2, String str3, int i, int i2, String str4) {
        x.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), str4});
        this.mFZ = str;
        this.mGa = str2;
        this.mGb = str3;
        this.mGc = i;
        this.mGd = i2;
        this.mGe = str4;
    }

    public final void vz(int i) {
        if (this.mGg != 2) {
            this.mGg = i;
        }
    }

    public final void aXS() {
        int i = 0;
        if (this.mGh) {
            x.i("MicroMsg.QBarEngineReporter", "doReport, already report");
            return;
        }
        int i2;
        String str = "MicroMsg.QBarEngineReporter";
        String str2 = "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d";
        Object[] objArr = new Object[16];
        objArr[0] = Integer.valueOf(this.mFW);
        objArr[1] = Long.valueOf(this.mFU);
        objArr[2] = Long.valueOf(this.mFX);
        objArr[3] = Integer.valueOf(this.mxT);
        objArr[4] = this.mFY;
        objArr[5] = Integer.valueOf(this.retryCount);
        objArr[6] = Boolean.valueOf(this.mFV);
        objArr[7] = this.mFZ;
        objArr[8] = this.mGa;
        objArr[9] = this.mGb;
        objArr[10] = Integer.valueOf(this.mGc);
        objArr[11] = Integer.valueOf(this.mGd);
        objArr[12] = this.mGe;
        if (bi.oW(this.mGa)) {
            i2 = 0;
        } else {
            i2 = this.mGa.length();
        }
        objArr[13] = Integer.valueOf(i2);
        objArr[14] = this.mGf.toString();
        objArr[15] = Integer.valueOf(this.mGg);
        x.i(str, str2, objArr);
        String str3 = "";
        if (this.mFY != null) {
            str3 = this.mFY.x + "x" + this.mFY.y;
        }
        h hVar = h.mEJ;
        objArr = new Object[17];
        objArr[0] = Integer.valueOf(this.mFW);
        objArr[1] = Long.valueOf(this.mFU);
        objArr[2] = Long.valueOf(this.mFX);
        objArr[3] = Integer.valueOf(this.mxT);
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(this.retryCount);
        if (this.mFV) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = this.mFZ;
        objArr[8] = "";
        objArr[9] = this.mGb;
        objArr[10] = Integer.valueOf(this.mGc);
        objArr[11] = Integer.valueOf(this.mGd);
        objArr[12] = this.mGe;
        if (bi.oW(this.mGa)) {
            i2 = 0;
        } else {
            i2 = this.mGa.length();
        }
        objArr[13] = Integer.valueOf(i2);
        objArr[14] = this.mGf.toString();
        objArr[15] = Integer.valueOf(this.mGg);
        if (this.mGi) {
            i = 1;
        }
        objArr[16] = Integer.valueOf(i);
        hVar.h(13233, objArr);
        this.mGh = true;
    }

    public final void reset() {
        this.mFU = 0;
        this.mFV = false;
        this.mFW = 0;
        this.mxT = -1;
        this.mFY = null;
        this.retryCount = 0;
        this.mFZ = "";
        this.mGa = "";
        this.mGb = "";
        this.mGc = 0;
        this.mGd = 0;
        this.mGe = "";
        this.mFX = 0;
        this.mGh = false;
        this.mGf.delete(0, this.mGf.length());
        this.mGg = 0;
        this.mGi = false;
        x.i("MicroMsg.QBarEngineReporter", "reset");
    }
}
