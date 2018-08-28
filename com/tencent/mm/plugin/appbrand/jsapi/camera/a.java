package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a {
    boolean fNV;
    boolean fNW;
    HashMap<Integer, AppBrandCameraView> fNX;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.fNV = true;
        this.fNW = true;
        this.fNX = new HashMap();
    }

    public final boolean h(Integer num) {
        if (!this.fNX.containsKey(num)) {
            return false;
        }
        ((AppBrandCameraView) this.fNX.remove(num)).release();
        return true;
    }

    public final boolean aiC() {
        if (!this.fNV) {
            x.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
        }
        return this.fNV;
    }
}
