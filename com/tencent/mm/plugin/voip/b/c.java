package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public int mState;
    public Map<Integer, Map<Integer, Integer>> oSW;

    public c(int i) {
        this.mState = i;
    }

    @SuppressLint({"UseSparseArrays"})
    public final void Y(int i, int i2, int i3) {
        Map map;
        if (this.oSW == null) {
            this.oSW = new HashMap();
        }
        if (this.oSW.containsKey(Integer.valueOf(i))) {
            map = (Map) this.oSW.get(Integer.valueOf(i));
        } else {
            map = new HashMap();
            this.oSW.put(Integer.valueOf(i), map);
        }
        map.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final boolean yX(int i) {
        if (this.oSW == null || !this.oSW.containsKey(Integer.valueOf(this.mState))) {
            x.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[]{b.yR(this.mState)});
            return false;
        } else if (((Map) this.oSW.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(i))) {
            return true;
        } else {
            x.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[]{b.yR(this.mState), b.yR(i)});
            return false;
        }
    }
}
