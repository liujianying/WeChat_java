package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.ag;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result> {
    private boolean bTv = false;
    ag handler = af.aRu();

    public abstract ag bxH();

    public abstract Result bxI();

    public final boolean o(Params... paramsArr) {
        if (this.bTv) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.bTv = true;
        ag bxH = bxH();
        if (bxH == null) {
            return false;
        }
        bxH.post(new 1(this, paramsArr));
        return true;
    }

    public void onPostExecute(Result result) {
    }
}
