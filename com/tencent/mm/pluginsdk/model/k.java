package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import junit.framework.Assert;

public abstract class k<Params, Progress, Result> {
    private boolean bTv = false;
    ag handler = new ag(Looper.getMainLooper());

    public abstract ag bxH();

    public abstract Result bxI();

    public final boolean o(Params... paramsArr) {
        if (this.bTv) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.bTv = true;
        p(paramsArr);
        ag bxH = bxH();
        if (bxH == null) {
            return false;
        }
        bxH.post(new 1(this, paramsArr));
        return true;
    }

    public void p(Params... paramsArr) {
    }

    public void onPostExecute(Result result) {
    }
}
