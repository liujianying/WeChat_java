package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class a implements g {
    protected MMActivity gKS;
    protected com.tencent.mm.plugin.card.ui.e.a hCv;
    boolean hHc = false;
    private boolean hHd = false;
    private boolean hHe = false;
    private boolean hHf = false;
    private boolean hHg = false;
    private boolean hHh = false;
    private boolean hHi = false;
    private boolean hHj = false;
    private boolean hHk = false;
    private boolean hHl = false;
    protected b htQ;

    public a(MMActivity mMActivity) {
        this.gKS = mMActivity;
    }

    public final void a(b bVar, com.tencent.mm.plugin.card.ui.e.a aVar) {
        this.htQ = bVar;
        this.hCv = aVar;
        azg();
    }

    public final void release() {
        this.htQ = null;
        this.hCv = null;
        this.gKS = null;
    }

    public final String aza() {
        String str = "";
        if (!TextUtils.isEmpty(this.htQ.awm().roe)) {
            return this.htQ.awm().roe;
        }
        if (this.htQ.awn().rne == 0) {
            return getString(g.card_no_stock);
        }
        if (this.htQ.awn().rnf != 0) {
            return str;
        }
        if (TextUtils.isEmpty(this.htQ.awm().rnL)) {
            return getString(g.card_accept_over_limite);
        }
        return this.htQ.awm().rnL;
    }

    private String getString(int i) {
        return this.gKS.getString(i);
    }

    public final boolean azb() {
        if (this.htQ.awn().status == 0 || this.htQ.awn().status == 1 || this.htQ.awn().status == 2) {
            return true;
        }
        return false;
    }

    public final boolean azc() {
        return this.hCv.hop == 3 || ((this.hCv.hop == 6 && this.htQ.awn().rnb == 0) || this.hCv.hop == 4 || this.hCv.hop == 5 || this.hCv.hop == 15);
    }

    private boolean azd() {
        return !TextUtils.isEmpty(this.htQ.awn().code);
    }

    protected final boolean aze() {
        return !this.htQ.isAcceptable() && (l.nZ(this.hCv.hop) || l.oa(this.hCv.hop) || this.hCv.hop == 23);
    }

    protected final boolean azf() {
        return !this.htQ.awj() && this.hCv.hop == 6;
    }

    protected void azg() {
        x.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
        if (l.nZ(this.hCv.hop) || l.oa(this.hCv.hop)) {
            if (this.htQ.isAcceptable()) {
                this.hHd = true;
                this.hHe = true;
                this.hHj = true;
                this.hHh = true;
                this.hHi = true;
            } else if (this.htQ.isAcceptable()) {
                this.hHd = false;
                this.hHe = false;
                this.hHh = false;
            } else {
                this.hHd = true;
                this.hHe = false;
                if (this.htQ.awh()) {
                    this.hHk = true;
                    this.hHh = true;
                    this.hHg = true;
                } else {
                    this.hHh = false;
                }
                this.hHi = true;
            }
        } else if (this.hCv.hop == 6) {
            if (this.htQ.awj()) {
                this.hHd = true;
                this.hHe = true;
                this.hHh = false;
            } else if (this.htQ.awi()) {
                this.hHk = true;
                this.hHh = true;
                this.hHf = true;
                this.hHg = true;
            } else {
                this.hHd = false;
                this.hHe = false;
                this.hHh = false;
                this.hHf = true;
            }
        } else if (l.ob(this.hCv.hop)) {
            this.hHd = false;
            this.hHe = false;
            this.hHf = true;
            if (this.htQ.awi()) {
                this.hHk = true;
                this.hHh = true;
                this.hHg = true;
            } else {
                this.hHl = true;
            }
        } else if (this.hCv.hop == 23) {
            if (this.htQ.isAcceptable()) {
                this.hHd = true;
                this.hHe = true;
                this.hHh = false;
                this.hHi = true;
            } else {
                this.hHd = true;
                this.hHe = false;
                this.hHh = false;
                this.hHi = true;
            }
            if (!(TextUtils.isEmpty(this.hCv.hBD) || this.hCv.hBD.equals(q.GF()) || this.htQ.awl())) {
                x.i("MicroMsg.CardBaseShowLogic", " detail page");
                this.hHd = false;
                this.hHe = false;
                this.hHf = true;
                if (this.htQ.awi()) {
                    this.hHk = true;
                    this.hHh = true;
                    this.hHg = true;
                }
            }
        }
        if (this.htQ.awh()) {
            this.hHd = false;
            this.hHe = false;
            x.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        } else {
            x.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
        }
        if (this.hHc) {
            this.hHd = false;
            this.hHe = false;
            x.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
        } else if (this.hHd) {
            this.hHc = false;
            x.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
        } else {
            this.hHc = true;
            x.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
        }
        x.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.hHc);
    }

    public final boolean ayF() {
        return this.hHc;
    }

    public boolean azh() {
        return this.hHd;
    }

    public final boolean azi() {
        return this.hHe;
    }

    public final boolean azj() {
        return this.hHf;
    }

    public final boolean azk() {
        return this.hHg;
    }

    public final boolean azl() {
        return this.hHh;
    }

    public final boolean azm() {
        return this.hHj;
    }

    public final boolean azn() {
        return this.hHk;
    }

    public final boolean azo() {
        return this.hHl;
    }

    public boolean azp() {
        return true;
    }

    public boolean azq() {
        return false;
    }

    public boolean azr() {
        return false;
    }

    public boolean azs() {
        return (this.hCv.hop == 6 && (!this.htQ.awi() || this.htQ.awj())) || this.hCv.hop == 5 || (this.hCv.hop == 23 && this.htQ.awl());
    }

    public boolean azt() {
        return false;
    }

    public boolean azu() {
        return true;
    }

    public boolean azv() {
        return (azd() && azb() && azc()) || this.hHc;
    }

    public boolean azw() {
        return false;
    }

    public boolean azx() {
        return !this.htQ.awi();
    }

    public boolean azy() {
        return (this.htQ.awm().rnY == null || this.htQ.awm().rnY.rvz == null || this.htQ.awm().rnY.rvz.size() <= 0 || TextUtils.isEmpty((CharSequence) this.htQ.awm().rnY.rvz.get(0))) ? false : true;
    }

    public boolean azz() {
        if (this.htQ.awn().rnd == null || this.htQ.awn().rnd.size() <= 0 || ((!azb() || !azc()) && !this.hHc)) {
            return false;
        }
        return true;
    }

    public boolean azA() {
        return false;
    }

    public final boolean azB() {
        return (this.htQ.awn().rnh == null || TextUtils.isEmpty(this.htQ.awn().rnh.title)) ? false : true;
    }

    public boolean azC() {
        return (this.htQ.awn().rnk == null || TextUtils.isEmpty(this.htQ.awn().rnk.title)) ? false : true;
    }

    public boolean azD() {
        return this.htQ.awm().rnU != null;
    }

    public boolean azE() {
        if (TextUtils.isEmpty(this.htQ.awm().rnR)) {
            return false;
        }
        return true;
    }

    public boolean azF() {
        return false;
    }

    public boolean azG() {
        return false;
    }

    public final void azH() {
        int i;
        int i2 = 1;
        String str = "MicroMsg.CardBaseShowLogic";
        String str2 = "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ";
        Object[] objArr = new Object[12];
        if (azd()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = aza();
        objArr[2] = Integer.valueOf(this.hHc ? 1 : 0);
        objArr[3] = Integer.valueOf(azh() ? 1 : 0);
        objArr[4] = Integer.valueOf(this.hHe ? 1 : 0);
        objArr[5] = Integer.valueOf(this.hHf ? 1 : 0);
        objArr[6] = Integer.valueOf(this.hHg ? 1 : 0);
        objArr[7] = Integer.valueOf(this.hHh ? 1 : 0);
        objArr[8] = Integer.valueOf(this.hHi ? 1 : 0);
        objArr[9] = Integer.valueOf(this.hHj ? 1 : 0);
        objArr[10] = Integer.valueOf(this.hHk ? 1 : 0);
        if (!this.hHl) {
            i2 = 0;
        }
        objArr[11] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
    }
}
