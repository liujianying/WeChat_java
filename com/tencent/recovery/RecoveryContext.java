package com.tencent.recovery;

import com.tencent.recovery.model.RecoveryStatusItem;
import java.util.ArrayList;

public final class RecoveryContext {
    public ArrayList<RecoveryStatusItem> vhg = new ArrayList();

    public final String toString() {
        return this.vhg.toString();
    }
}
