package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ao implements a {
    private static n iXl = null;
    private static ao iXm = null;
    public int bOS;
    public int duration;
    public String path;

    public static ao aLW() {
        if (iXm == null) {
            iXm = new ao();
        }
        return iXm;
    }

    public final void aLX() {
        if (iXl == null) {
            iXl = new n();
        }
        iXl.a(this);
        iXl.iWG = true;
        n nVar = iXl;
        if (n.hlW == null) {
            n.hlW = new SensorController(ad.getContext());
        }
        if (nVar.hma == null) {
            nVar.hma = new az(ad.getContext());
        }
    }

    public static n aLY() {
        return iXl;
    }

    public final void aW(String str, int i) {
        x.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 1);
        if (bi.aG(str, "").equals(this.path)) {
            bundle.putBoolean("result", false);
        } else {
            bundle.putBoolean("result", true);
        }
        bundle.putInt("position", i);
        kq kqVar = new kq();
        kqVar.bVa.bUU = bundle;
        kqVar.bVa.type = 4;
        com.tencent.mm.sdk.b.a.sFg.m(kqVar);
    }

    public final void onFinish() {
        iXl.stopPlay();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 2);
        kq kqVar = new kq();
        kqVar.bVa.bUU = bundle;
        kqVar.bVa.type = 4;
        com.tencent.mm.sdk.b.a.sFg.m(kqVar);
    }

    public final void onPause() {
        iXl.aLs();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 3);
        kq kqVar = new kq();
        kqVar.bVa.bUU = bundle;
        kqVar.bVa.type = 4;
        com.tencent.mm.sdk.b.a.sFg.m(kqVar);
    }
}
