package com.tencent.mm.y;

import com.tencent.mm.ac.j;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.y.g.a;
import java.util.LinkedList;
import java.util.Map;

public class e extends d {
    public LinkedList<j> dwk = null;

    public final d FD() {
        return new e();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        switch (aVar.showType) {
            case 1:
                this.dwk = j.s(aVar.dwm);
                return;
            default:
                return;
        }
    }
}
