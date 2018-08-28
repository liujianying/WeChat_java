package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class t$5 extends bd<Object> {
    final /* synthetic */ int bAM;
    final /* synthetic */ String dhF;
    final /* synthetic */ boolean esA;
    final /* synthetic */ t esu;
    final /* synthetic */ int esz;

    t$5(t tVar, int i, int i2, String str, boolean z) {
        this.esu = tVar;
        this.bAM = i;
        this.esz = i2;
        this.dhF = str;
        this.esA = z;
        super(1000, null, (byte) 0);
    }

    protected final Object run() {
        if (this.bAM == 3) {
            Date date = new Date();
            date.setTime(bi.VF() - (86400000 * ((long) this.esz)));
            MMLogic.uploadFile(e.duP + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt", this.dhF, "");
        } else if (this.bAM == 2) {
            x.chR();
            MMLogic.uploadLog(new int[]{this.esz}, this.esA, this.dhF, "");
        } else {
            x.chR();
        }
        return null;
    }
}
