package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h extends a {
    public h(MMActivity mMActivity) {
        super(mMActivity);
    }

    protected final void azg() {
        super.azg();
    }

    public final boolean azq() {
        ArrayList xv = b.xv(this.htQ.awr());
        if ((!this.hCv.hvg || this.hCv.hop == 4) && !TextUtils.isEmpty(this.htQ.aws())) {
            return true;
        }
        if (this.hCv.hvg && xv != null && xv.size() > 0) {
            return true;
        }
        if (TextUtils.isEmpty(this.htQ.aws()) || !azr()) {
            return false;
        }
        return true;
    }

    public final boolean azr() {
        return this.hCv.hop == 3;
    }

    public final boolean azs() {
        return false;
    }

    public final boolean azu() {
        return this.hHc;
    }

    public final boolean azx() {
        return false;
    }

    public final boolean azy() {
        return this.hHc && super.azy();
    }

    public final boolean azC() {
        return false;
    }

    public final boolean azD() {
        return false;
    }

    public final boolean azv() {
        return false;
    }

    public final boolean azE() {
        if (super.azE() || azF()) {
            return true;
        }
        if (this.htQ.avS() && this.hHc) {
            return true;
        }
        return false;
    }

    public final boolean azF() {
        return !this.hHc && this.htQ.awm().rod == 1;
    }
}
