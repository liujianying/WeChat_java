package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.g.c.bd;
import com.tencent.mm.sdk.e.c.a;

public final class c extends bd {
    public static a dhO = bd.wI();

    protected final a AX() {
        return dhO;
    }

    public final boolean aLa() {
        if (this.field_dataType == 4) {
            return true;
        }
        return false;
    }

    public final boolean isFinished() {
        return this.field_status == 3;
    }

    public final float getProgress() {
        return Math.max(0.0f, Math.min(99.0f, ((float) this.field_offset) / ((float) this.field_totalLen)) * 100.0f);
    }
}
