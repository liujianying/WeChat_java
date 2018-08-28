package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.storage.emotion.EmojiInfo;
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
    EmojiInfo gZe;

    public i$a(String str, ey eyVar, LinkedList<u> linkedList, int i, boolean z, u uVar) {
        this.filePath = str;
        this.gVX = eyVar;
        this.gVY = linkedList;
        this.bMT = i;
        this.gVZ = false;
        this.gWb = z;
        this.gVU = uVar;
    }

    public i$a(String str, ey eyVar, LinkedList<u> linkedList, int i, String str2) {
        this.filePath = str;
        this.gVX = eyVar;
        this.gVY = linkedList;
        this.bMT = i;
        this.gVZ = false;
        this.gWa = str2;
        this.gWb = false;
        this.gVU = null;
    }

    public i$a(String str, ey eyVar, LinkedList<u> linkedList, EmojiInfo emojiInfo) {
        this.filePath = str;
        this.gVX = eyVar;
        this.gVY = linkedList;
        this.bMT = 5;
        this.gVZ = false;
        this.gWb = false;
        this.gVU = null;
        this.gZe = emojiInfo;
    }
}
