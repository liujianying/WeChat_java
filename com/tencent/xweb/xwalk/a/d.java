package com.tencent.xweb.xwalk.a;

import android.content.Context;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer$XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public final class d implements XWalkInitializer$XWalkInitListener, XWalkBackgroundUpdateListener {
    public static boolean vFD = true;
    private static boolean vFE = false;
    private static d vFF;
    Context mContext;
    XWalkInitializer vFi;
    XWalkUpdater vFj;

    private d(Context context) {
        this.mContext = context;
        this.vFi = new XWalkInitializer(this, context);
        this.vFj = new XWalkUpdater(this, context);
    }

    public final void onXWalkInitStarted() {
    }

    public final void onXWalkInitCancelled() {
    }

    public final void onXWalkInitFailed() {
    }

    public final void onXWalkInitCompleted() {
    }

    public final void onXWalkUpdateStarted() {
        e.cJy();
    }

    public final void onXWalkUpdateProgress(int i) {
    }

    public final void onXWalkUpdateCancelled() {
        e.cJz();
    }

    public final void onXWalkUpdateFailed(int i) {
        e.Iy(i);
    }

    public final void onXWalkUpdateCompleted() {
        e.cJA();
    }

    public static boolean isXWalkReady() {
        if (!vFE || vFF == null) {
            return false;
        }
        return vFF.vFi.isXWalkReady();
    }

    public static boolean ip(Context context) {
        if (vFE) {
            return vFE;
        }
        vFE = true;
        vFF = new d(context);
        XWalkEnvironment.init(context);
        if (!XWalkEnvironment.isDownloadMode()) {
            return false;
        }
        d dVar = vFF;
        if (!vFD) {
            HashMap hashMap = new HashMap();
            hashMap.put("UpdaterCheckType", "0");
            new e(dVar.vFj, hashMap).execute(new String[0]);
        }
        if (!dVar.vFi.tryInitSync()) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog("initSync Sucsess");
        return true;
    }
}
