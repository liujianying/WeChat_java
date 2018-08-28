package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.f;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t.a;
import com.tencent.mm.pointers.PInt;

class PluginBigBallOfMud$12 implements a {
    final /* synthetic */ PluginBigBallOfMud heA;

    PluginBigBallOfMud$12(PluginBigBallOfMud pluginBigBallOfMud) {
        this.heA = pluginBigBallOfMud;
    }

    public final boolean a(String str, String str2, PInt pInt) {
        if (!s.hf(str)) {
            return false;
        }
        if (f.eZ(str)) {
            if (e.lc(str2)) {
                pInt.value = 5;
            } else {
                pInt.value = 4;
            }
        } else if (f.kL(str)) {
            pInt.value = 3;
        } else if (f.kM(str)) {
            pInt.value = 0;
        } else if (f.kI(str)) {
            pInt.value = 6;
        } else {
            pInt.value = 7;
        }
        return true;
    }
}
