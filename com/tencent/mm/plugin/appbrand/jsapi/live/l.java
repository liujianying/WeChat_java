package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class l implements ITXLivePlayListener {
    boolean dni = false;
    boolean fRE = false;
    TXCloudVideoView fRV;
    private TXLivePlayConfig fRW;
    TXLivePlayer fRX;
    ITXLivePlayListener fRY;
    String fRZ = "";
    int fSa = 0;
    boolean fSb = false;
    private String fSc = "vertical";
    private String fSd = "fillCrop";
    private String fSe = "speaker";
    private float fSf = 1.0f;
    private float fSg = 3.0f;
    boolean fSh = true;
    private boolean fSi = false;
    boolean mAutoPlay = false;
    private Context mContext;
    private int mMode = 1;
    private boolean mMute = false;

    public l(Context context) {
        this.mContext = context;
        this.fRW = new TXLivePlayConfig();
        this.fRX = new TXLivePlayer(this.mContext);
        this.fRX.setConfig(this.fRW);
        this.fRX.setPlayListener(this);
        this.fRX.enableHardwareDecode(true);
    }

    public final j tC(String str) {
        boolean z = true;
        if (str == null) {
            return new j(-1, "invalid params");
        }
        x.i("TXLivePlayerJSAdapter", "operateLivePlayer: " + str);
        if (!this.dni) {
            return new j(-3, "uninited livePlayer");
        }
        if (str.equalsIgnoreCase("play")) {
            this.fRX.startPlay(this.fRZ, this.fSa);
        } else if (str.equalsIgnoreCase("stop")) {
            this.fRX.stopPlay(true);
        } else if (str.equalsIgnoreCase("pause")) {
            this.fRX.pause();
        } else if (str.equalsIgnoreCase("resume")) {
            this.fRX.resume();
        } else if (!str.equalsIgnoreCase("mute")) {
            return new j(-4, "invalid operate command");
        } else {
            if (this.mMute) {
                z = false;
            }
            this.mMute = z;
            this.fRX.setMute(this.mMute);
        }
        return new j();
    }

    public final void onPlayEvent(int i, Bundle bundle) {
        if (i == 2006 || i == -2301) {
            tC("stop");
        }
        if (this.fRE && this.fRY != null) {
            this.fRY.onPlayEvent(i, bundle);
        }
    }

    public final void onNetStatus(Bundle bundle) {
        if (this.fRY != null) {
            this.fRY.onNetStatus(bundle);
        }
    }

    final int v(Bundle bundle) {
        this.mMode = bundle.getInt("mode", this.mMode);
        if (this.mMode != 1) {
            return 5;
        }
        if (this.fRZ == null || this.fRZ == null) {
            return 0;
        }
        if ((this.fRZ.startsWith("http://") || this.fRZ.startsWith("https://")) && this.fRZ.contains(".flv")) {
            return 1;
        }
        return 0;
    }

    final void w(Bundle bundle) {
        this.mMute = bundle.getBoolean("muted", this.mMute);
        this.fRX.setMute(this.mMute);
        this.fSc = bundle.getString("orientation", this.fSc);
        if (this.fSc.equalsIgnoreCase("horizontal")) {
            this.fRX.setRenderRotation(270);
        } else if (this.fSc.equalsIgnoreCase("vertical")) {
            this.fRX.setRenderRotation(0);
        }
        this.fSd = bundle.getString("objectFit", this.fSd);
        if (this.fSd.equalsIgnoreCase("fillCrop")) {
            this.fRX.setRenderMode(0);
        } else if (this.fSd.equalsIgnoreCase("contain")) {
            this.fRX.setRenderMode(1);
        }
        this.fSe = bundle.getString("soundMode", this.fSe);
        if (this.fSe.equalsIgnoreCase("speaker")) {
            this.fRX.setAudioRoute(0);
        } else if (this.fSe.equalsIgnoreCase("ear")) {
            this.fRX.setAudioRoute(1);
        }
        this.fSf = bundle.getFloat("minCache", this.fSf);
        this.fSg = bundle.getFloat("maxCache", this.fSg);
        this.fRW.setAutoAdjustCacheTime(true);
        this.fRW.setCacheTime(this.fSf);
        this.fRW.setMinAutoAdjustCacheTime(this.fSf);
        this.fRW.setMaxAutoAdjustCacheTime(this.fSg);
        this.fRX.setConfig(this.fRW);
        this.fRE = bundle.getBoolean("needEvent", this.fRE);
        this.fSi = bundle.getBoolean("debug", this.fSi);
        this.fRV.showLog(this.fSi);
    }

    static void d(String str, Bundle bundle) {
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("playUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("objectFit") || str2.equalsIgnoreCase("soundMode")) {
                str = str + "\n" + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("playType")) {
                str = str + "\n" + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase("minCache") || str2.equalsIgnoreCase("maxCache")) {
                str = str + "\n" + str2 + " = " + bundle.getFloat(str2);
            } else if (str2.equalsIgnoreCase("hide") || str2.equalsIgnoreCase("autoplay") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("debug")) {
                str = str + "\n" + str2 + " = " + bundle.getBoolean(str2);
            }
        }
        x.i("TXLivePlayerJSAdapter", str);
    }
}
