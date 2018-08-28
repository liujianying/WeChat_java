package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.ey;
import java.util.LinkedList;

public class i$a {
    int bMT;
    String filePath;
    u gVU;
    ey gVX;
    LinkedList<u> gVY;
    boolean gVZ = true;
    String gWa;
    boolean gWb;

    public i$a(String str, ey eyVar, LinkedList<u> linkedList, int i, boolean z, boolean z2, u uVar) {
        this.filePath = str;
        this.gVX = eyVar;
        this.gVY = linkedList;
        this.bMT = i;
        this.gVZ = z;
        this.gWb = z2;
        this.gVU = uVar;
    }

    public i$a(String str, ey eyVar, LinkedList<u> linkedList, int i, boolean z, String str2, boolean z2) {
        this.filePath = str;
        this.gVX = eyVar;
        this.gVY = linkedList;
        this.bMT = i;
        this.gVZ = z;
        this.gWa = str2;
        this.gWb = z2;
        this.gVU = null;
    }
}
