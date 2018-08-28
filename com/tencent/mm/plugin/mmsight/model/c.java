package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class c extends OrientationEventListener {
    public int lfl = -1;
    public int lfm = -1;
    private long lfn = 0;
    private long lfo = 0;
    public a lfp;
    public int orientation = -1;

    public interface a {
        void sO(int i);
    }

    public c(Context context) {
        super(context, 2);
    }

    public final void onOrientationChanged(int i) {
        if (!j.lgw) {
            return;
        }
        if (bi.bI(this.lfo) < 2000) {
            x.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
        } else if (Math.abs(this.lfl - i) >= 30 || bi.bI(this.lfn) >= 300) {
            this.lfl = i;
            this.lfn = bi.VG();
            if (i <= 60 || i >= TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE) {
                if (i <= 30 || i >= TbsListener$ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE) {
                    this.orientation = 0;
                }
            } else if (i < 30 || i > 150) {
                if (i < TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR || i > 240) {
                    if (i >= 210 && i <= TbsListener$ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE && i >= 240 && i <= TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE) {
                        this.orientation = 270;
                    }
                } else if (i >= 150 && i <= 210) {
                    this.orientation = 180;
                }
            } else if (i >= 60 && i <= TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) {
                this.orientation = 90;
            }
            if (this.lfp != null) {
                this.lfp.sO(this.orientation);
            }
        }
    }

    public final void enable() {
        x.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", new Object[]{Boolean.valueOf(j.lgw)});
        if (j.lgw) {
            super.enable();
            this.lfo = bi.VG();
        }
    }

    public final int getOrientation() {
        if (j.lgw) {
            return this.orientation;
        }
        return 0;
    }

    public final boolean bdK() {
        if (!j.lgw) {
            return false;
        }
        x.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", new Object[]{Long.valueOf(bi.bI(this.lfo)), Integer.valueOf(this.orientation)});
        if (bi.bI(this.lfo) < 2000 || this.orientation < 0) {
            return false;
        }
        if (this.orientation == 90 || this.orientation == 270) {
            return true;
        }
        return false;
    }
}
