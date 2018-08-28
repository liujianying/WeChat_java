package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.a.i;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig implements Parcelable {
    public static final Creator<AppBrandGlobalSystemConfig> CREATOR = new 1();
    private static volatile AppBrandGlobalSystemConfig fpC;
    private static final AppBrandGlobalSystemConfig fpD;
    public int fpE = Integer.MAX_VALUE;
    public int fpF;
    public int fpG;
    public int fpH;
    public int fpI;
    public String fpJ;
    public HttpSetting fpK;
    public int[] fpL;
    public int fpM;
    public int fpN;
    public int fpO;
    public int fpP;
    public int fpQ;
    public int fpR;
    public int fpS;
    public int fpT;
    public int fpU;
    public String[] fpV;
    public double fpW;
    public int fpX;
    public WeAppSyncVersionSetting fpY;
    public PackageManager fpZ;

    public static final class HttpSetting implements Parcelable {
        public static final Creator<HttpSetting> CREATOR = new 1();
        public ArrayList<String> fqc;
        public ArrayList<String> fqd;
        public int fqe;
        public int fqf;
        public int fqg;
        public int fqh;
        public String fqi;
        public int mode;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mode);
            parcel.writeStringList(this.fqc);
            parcel.writeStringList(this.fqd);
            parcel.writeInt(this.fqe);
            parcel.writeInt(this.fqf);
            parcel.writeInt(this.fqg);
            parcel.writeInt(this.fqh);
            parcel.writeString(this.fqi);
        }

        HttpSetting(Parcel parcel) {
            this.mode = parcel.readInt();
            this.fqc = parcel.createStringArrayList();
            this.fqd = parcel.createStringArrayList();
            this.fqe = parcel.readInt();
            this.fqf = parcel.readInt();
            this.fqg = parcel.readInt();
            this.fqh = parcel.readInt();
            this.fqi = parcel.readString();
        }
    }

    static {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
        fpD = appBrandGlobalSystemConfig;
        appBrandGlobalSystemConfig.fpF = 5;
        fpD.fpG = 300;
        fpD.fpH = 10;
        fpD.fpI = 1048576;
        fpD.fpL = a.fqa;
        fpD.fpM = 10;
        fpD.fpN = 11;
        fpD.fpO = 1800;
        fpD.fpP = 307200;
        fpD.fpQ = 25;
        fpD.fpR = 10485760;
        fpD.fpS = 314572800;
        fpD.fpT = 1;
        fpD.fpU = 50;
        fpD.fpV = a.fqb;
        fpD.fpW = 0.0d;
        fpD.fpX = 60;
        fpD.fpY = new WeAppSyncVersionSetting();
        fpD.fpZ = new PackageManager();
    }

    static synchronized void adW() {
        synchronized (AppBrandGlobalSystemConfig.class) {
            fpC = null;
        }
    }

    static String adX() {
        File file = new File(e.duO.replace("/data/user/0", "/data/data"), "wxaapp/res/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "AppService.conf").getAbsolutePath();
    }

    private static synchronized AppBrandGlobalSystemConfig adY() {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = null;
        int i = 0;
        synchronized (AppBrandGlobalSystemConfig.class) {
            if (fpC == null) {
                String ct;
                try {
                    ct = com.tencent.mm.a.e.ct(adX());
                } catch (FileNotFoundException e) {
                    b ccr = c.ccr();
                    c.ccr();
                    s Tn = a.ccH().Tn(i.ex(38, 1));
                    if (Tn != null) {
                        i = bi.getInt(Tn.field_fileVersion, 0);
                    }
                    ccr.e(38, 1, i, false);
                    ct = null;
                } catch (IOException e2) {
                    x.e("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", new Object[]{e2});
                    ct = null;
                }
                if (!bi.oW(ct)) {
                    fpC = rK(ct);
                }
            }
            appBrandGlobalSystemConfig = fpC;
        }
        return appBrandGlobalSystemConfig;
    }

    public static AppBrandGlobalSystemConfig adZ() {
        AppBrandGlobalSystemConfig adY = adY();
        return adY == null ? fpD : adY;
    }

    private static AppBrandGlobalSystemConfig rK(String str) {
        x.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[]{str});
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
            JSONObject optJSONObject = jSONObject.optJSONObject("HTTPSetting");
            if (optJSONObject != null) {
                appBrandGlobalSystemConfig.fpK = new HttpSetting();
                String optString = optJSONObject.optString("HTTPHeaderMode", "");
                if (optString.equals("BlackList")) {
                    appBrandGlobalSystemConfig.fpK.mode = 1;
                } else if (optString.equals("WhiteList")) {
                    appBrandGlobalSystemConfig.fpK.mode = 2;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("HeaderBlackList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.fpK.fqc = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.fpK.fqc.add(optJSONArray.getString(i));
                    }
                }
                optJSONArray = optJSONObject.optJSONArray("HeaderWhiteList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.fpK.fqd = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.fpK.fqd.add(optJSONArray.getString(i));
                    }
                }
                appBrandGlobalSystemConfig.fpK.fqe = optJSONObject.optInt("WebsocketMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.fpK.fqf = optJSONObject.optInt("UploadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.fpK.fqg = optJSONObject.optInt("DownloadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.fpK.fqh = optJSONObject.optInt("RequestMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.fpK.fqi = optJSONObject.optString("HTTPHeaderReferer");
            }
            appBrandGlobalSystemConfig.fpY = new WeAppSyncVersionSetting();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("SyncVersionSetting");
            if (optJSONObject2 != null) {
                appBrandGlobalSystemConfig.fpY.fqn = optJSONObject2.optLong("PullVersionInterval", appBrandGlobalSystemConfig.fpY.fqn);
                appBrandGlobalSystemConfig.fpY.fqo = optJSONObject2.optLong("PullVersionWxaUsageLastInterval", appBrandGlobalSystemConfig.fpY.fqo);
                appBrandGlobalSystemConfig.fpY.fqp = optJSONObject2.optInt("PullVersionMaxCount", appBrandGlobalSystemConfig.fpY.fqp);
                appBrandGlobalSystemConfig.fpY.fqq = optJSONObject2.optInt("PullVersionMaxCountPerRequest", appBrandGlobalSystemConfig.fpY.fqq);
            }
            appBrandGlobalSystemConfig.fpZ = new PackageManager();
            optJSONObject2 = jSONObject.optJSONObject("PackageManager");
            if (optJSONObject2 != null) {
                appBrandGlobalSystemConfig.fpZ.fqj = optJSONObject2.optLong("CheckInterval", appBrandGlobalSystemConfig.fpZ.fqj);
                appBrandGlobalSystemConfig.fpZ.fqk = optJSONObject2.optLong("WithoutContactClearSeconds", appBrandGlobalSystemConfig.fpZ.fqk);
                appBrandGlobalSystemConfig.fpZ.fql = optJSONObject2.optLong("ClientStorageMinMB", appBrandGlobalSystemConfig.fpZ.fql);
                appBrandGlobalSystemConfig.fpZ.fqm = optJSONObject2.optInt("WholeClientStoragePercent", appBrandGlobalSystemConfig.fpZ.fqm);
            }
            appBrandGlobalSystemConfig.fpJ = jSONObject.optString("CDNBaseURL");
            appBrandGlobalSystemConfig.fpF = jSONObject.optInt("AppMaxRunningCount", 5);
            appBrandGlobalSystemConfig.fpG = jSONObject.optInt("TempFileSizeLimitTotal", 300);
            appBrandGlobalSystemConfig.fpH = jSONObject.optInt("DownloadFileSizeLimit", 10);
            appBrandGlobalSystemConfig.fpI = jSONObject.optInt("MaxLocalStorageItemSize", 1048576);
            appBrandGlobalSystemConfig.fpR = jSONObject.optInt("NativeBufferSizeLimitByte", 10485760);
            appBrandGlobalSystemConfig.fpS = jSONObject.optInt("NativeBufferQueueLimitByte", 314572800);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("SyncLaunchSceneList");
            if (optJSONArray2 != null) {
                appBrandGlobalSystemConfig.fpL = new int[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.fpL[i] = optJSONArray2.optInt(i, 0);
                }
            }
            if (appBrandGlobalSystemConfig.fpL == null) {
                appBrandGlobalSystemConfig.fpL = a.fqa;
            }
            appBrandGlobalSystemConfig.fpM = jSONObject.optInt("StarNumberLimitation", 10);
            appBrandGlobalSystemConfig.fpN = jSONObject.optInt("TaskBarItemCountLimitation", 11);
            appBrandGlobalSystemConfig.fpO = jSONObject.optInt("WidgetImageFlowLimitDuration", 1800);
            appBrandGlobalSystemConfig.fpP = jSONObject.optInt("WidgetImageFlowLimitMaxSize", 307200);
            appBrandGlobalSystemConfig.fpQ = jSONObject.optInt("WidgetDrawMinInterval", 25);
            appBrandGlobalSystemConfig.fpT = jSONObject.optInt("GameMaxRunningCount", 1);
            appBrandGlobalSystemConfig.fpU = jSONObject.optInt("GameDownloadFileSizeLimit", 50);
            optJSONArray2 = jSONObject.optJSONArray("SubContextImgDomain");
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                appBrandGlobalSystemConfig.fpV = a.fqb;
            } else {
                appBrandGlobalSystemConfig.fpV = new String[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.fpV[i] = optJSONArray2.optString(i, null);
                }
            }
            appBrandGlobalSystemConfig.fpW = jSONObject.optDouble("GamePerfCollectSamplePercentage", 0.0d);
            appBrandGlobalSystemConfig.fpX = jSONObject.optInt("GamePerfCollectInterval", 60);
            return appBrandGlobalSystemConfig;
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[]{bi.i(e)});
            return null;
        }
    }

    private AppBrandGlobalSystemConfig() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fpE);
        parcel.writeInt(this.fpF);
        parcel.writeInt(this.fpG);
        parcel.writeInt(this.fpH);
        parcel.writeInt(this.fpI);
        parcel.writeString(this.fpJ);
        parcel.writeParcelable(this.fpK, i);
        parcel.writeIntArray(this.fpL);
        parcel.writeInt(this.fpM);
        parcel.writeInt(this.fpN);
        parcel.writeInt(this.fpO);
        parcel.writeInt(this.fpP);
        parcel.writeInt(this.fpQ);
        parcel.writeInt(this.fpR);
        parcel.writeInt(this.fpS);
        parcel.writeInt(this.fpT);
        parcel.writeInt(this.fpU);
        parcel.writeStringArray(this.fpV);
        parcel.writeDouble(this.fpW);
        parcel.writeInt(this.fpX);
        parcel.writeParcelable(this.fpY, i);
        parcel.writeParcelable(this.fpZ, i);
    }

    protected AppBrandGlobalSystemConfig(Parcel parcel) {
        this.fpE = parcel.readInt();
        this.fpF = parcel.readInt();
        this.fpG = parcel.readInt();
        this.fpH = parcel.readInt();
        this.fpI = parcel.readInt();
        this.fpJ = parcel.readString();
        this.fpK = (HttpSetting) parcel.readParcelable(HttpSetting.class.getClassLoader());
        this.fpL = parcel.createIntArray();
        this.fpM = parcel.readInt();
        this.fpN = parcel.readInt();
        this.fpO = parcel.readInt();
        this.fpP = parcel.readInt();
        this.fpQ = parcel.readInt();
        this.fpR = parcel.readInt();
        this.fpS = parcel.readInt();
        this.fpT = parcel.readInt();
        this.fpU = parcel.readInt();
        this.fpV = parcel.createStringArray();
        this.fpW = parcel.readDouble();
        this.fpX = parcel.readInt();
        this.fpY = (WeAppSyncVersionSetting) parcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader());
        this.fpZ = (PackageManager) parcel.readParcelable(PackageManager.class.getClassLoader());
    }
}
