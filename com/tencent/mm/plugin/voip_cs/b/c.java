package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.protocal.c.bzm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static int oWr = 0;
    public static int oWs = 1;
    public static int oWt = 2;
    public int bjS;
    public int channelStrategy;
    public String deviceModel;
    public long kpp;
    public long kqM;
    public String kqV;
    public String kqW;
    public int networkType;
    public int oOB;
    public int oOC;
    public int oOD;
    public int oOj;
    public int oOw;
    public int oPR;
    public int oWA;
    public int oWB;
    public int oWC;
    public int oWD;
    public int oWE;
    public int oWF;
    public long oWG;
    public String oWH;
    public int oWI;
    public int oWJ;
    public int oWK;
    public int oWL;
    public int oWM;
    public int oWN;
    public int oWO;
    public int oWP;
    public int oWQ;
    public int oWR;
    public int oWS;
    public long oWT;
    public int oWU;
    public long oWV;
    public long oWW;
    public long oWX;
    public int oWY;
    public int oWZ;
    public int oWu;
    public int oWv;
    public int oWw;
    public int oWx;
    public int oWy;
    public int oWz;
    public int oXa;
    public int oXb;
    public String oXc;
    public String oXd;
    public String oXe;
    public int oXf;
    public int oXg;
    public int oXh;
    public int oXi;
    public int oXj;
    public int oXk;
    public int ovW;
    public int videoFps;

    public c() {
        this.bjS = 0;
        this.oWu = 0;
        this.oWv = 0;
        this.oWw = 0;
        this.videoFps = 0;
        this.oWx = 0;
        this.oWy = 0;
        this.oWz = 0;
        this.oWA = 0;
        this.oWB = 0;
        this.oWC = 0;
        this.networkType = 0;
        this.oWD = 0;
        this.oWF = 0;
        this.oOw = 0;
        this.oWG = 0;
        this.kpp = 0;
        this.oWH = "";
        this.oOj = 0;
        this.oWJ = 0;
        this.oWK = 0;
        this.oWL = 0;
        this.oWM = 0;
        this.oOC = 0;
        this.oOB = 0;
        this.oWN = 0;
        this.oWO = 1;
        this.oWP = 0;
        this.oWQ = 0;
        this.oWR = 0;
        this.oWS = 0;
        this.oWT = 0;
        this.oWV = 0;
        this.oWW = 0;
        this.oWX = 0;
        this.kqM = 0;
        this.channelStrategy = 1;
        this.oPR = 0;
        this.oOD = 0;
        this.oXa = -1;
        this.oXb = 0;
        this.oXc = "";
        this.deviceModel = "";
        this.oXd = "";
        this.oXe = "";
        this.oXf = 0;
        this.oXg = 0;
        this.oXh = 0;
        this.oXi = 0;
        this.oXj = 0;
        this.oXk = 0;
        this.ovW = m.zj();
        this.kqW = "";
        this.kqV = "";
        this.oXc = Build.MANUFACTURER;
        if (this.oXc.contains(",")) {
            this.oXc = this.oXc.replace(',', ' ');
        }
        this.deviceModel = Build.MODEL;
        if (this.deviceModel.contains(",")) {
            this.deviceModel = this.deviceModel.replace(',', ' ');
        }
        this.oXd = VERSION.SDK;
        if (this.oXd.contains(",")) {
            this.oXd = this.oXd.replace(',', ' ');
        }
        this.oXe = VERSION.RELEASE;
        if (this.oXe.contains(",")) {
            this.oXe = this.oXe.replace(',', ' ');
        }
    }

    public final void za(int i) {
        this.oOB = Math.abs(i);
    }

    public final void bMy() {
        x.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
        if (this.oXj == 0 && this.oXi != 0) {
            this.oXj = (int) (System.currentTimeMillis() / 1000);
            this.kqM = (long) (this.oXj - this.oXi);
        }
    }

    public final bzm bMz() {
        bzm bzm = new bzm();
        bzm.hcE = 2;
        bzm.svH = this.kqV;
        x.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[]{bzm.svH});
        String[] split = this.kqV.split(",");
        if (split != null && split.length > 0) {
            try {
                this.videoFps = bi.getInt(split[8], 0);
                this.oWx = bi.getInt(split[10], 0);
            } catch (Exception e) {
                x.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
            }
        }
        return bzm;
    }

    public static int bMA() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ad.getContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null) {
                    return oWr;
                }
                if (networkInfo.getState() == State.CONNECTED) {
                    return oWs;
                }
                return oWt;
            }
        } catch (Exception e) {
            x.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
        }
        return oWr;
    }

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 0;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 13) {
                return 4;
            }
            if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                return 2;
            }
            return 3;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipCSReportHelper", e, "", new Object[0]);
            return 0;
        }
    }
}
