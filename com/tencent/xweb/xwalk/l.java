package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.xweb.xwalk.a.e;
import java.util.HashMap;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater$XWalkBackgroundUpdateListener;

public class l implements XWalkInitListener, XWalkUpdater$XWalkBackgroundUpdateListener {
    static l vFh;
    protected Context mContext;
    XWalkInitializer vFi;
    XWalkUpdater vFj;

    public static void a(Context context, HashMap<String, String> hashMap) {
        if (vFh == null) {
            vFh = new l(context);
        }
        vFh.p(hashMap);
    }

    public static boolean isBusy() {
        if (vFh == null) {
            return false;
        }
        return e.cJx();
    }

    public l(Context context) {
        this.mContext = context;
        this.vFi = new XWalkInitializer(this, context);
        this.vFj = new XWalkUpdater(this, context);
    }

    public final boolean p(HashMap<String, String> hashMap) {
        new e(this.vFj, hashMap).execute(new String[0]);
        return false;
    }

    public void onXWalkInitStarted() {
    }

    public void onXWalkInitCancelled() {
    }

    public void onXWalkInitFailed() {
    }

    public void onXWalkInitCompleted() {
    }

    public void onXWalkUpdateStarted() {
        e.cJy();
    }

    public void onXWalkUpdateProgress(int i) {
    }

    public void onXWalkUpdateCancelled() {
        e.cJz();
    }

    public void onXWalkUpdateFailed(int i) {
        e.Iy(i);
    }

    public void onXWalkUpdateCompleted() {
        e.cJA();
    }
}
