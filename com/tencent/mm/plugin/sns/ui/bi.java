package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class bi {
    ListView kww;
    SnsCommentFooter nLN;
    public int nUa = -1;
    int nVx = -1;
    int ohP = -1;
    int ohQ = -1;
    public int ohR = 0;
    boolean ohS = false;
    int ohT;
    protected long ohU;
    Runnable ohV = new 1(this);
    Runnable ohW = new 2(this);
    Runnable ohX = new 3(this);
    int position = -1;

    public bi(ListView listView, SnsCommentFooter snsCommentFooter) {
        this.kww = listView;
        this.nLN = snsCommentFooter;
    }

    public final void bEE() {
        this.ohS = true;
        new ag().postDelayed(this.ohV, 30);
        this.ohT = 10;
        x.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.nLN.getTop());
        this.ohU = com.tencent.mm.sdk.platformtools.bi.VG();
    }

    public final void bEF() {
        this.ohS = true;
        this.ohT = 20;
        new ag().postDelayed(this.ohW, 100);
    }

    public final void bEG() {
        if (this.ohS) {
            this.ohS = false;
            new ag().postDelayed(this.ohX, 30);
            this.ohT = 10;
        }
    }
}
