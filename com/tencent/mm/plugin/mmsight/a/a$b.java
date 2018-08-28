package com.tencent.mm.plugin.mmsight.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class a$b {
    public boolean dJO;
    public int dal;
    public int lkA;
    public int lkB;
    public int lkC;
    public boolean lkD;
    public int lkE;
    public int lkF;
    public int lkz;
    public int scene;
    public int textColor;

    public a$b(int i) {
        if (i == 1) {
            this.scene = 2;
        } else if (i == 2) {
            this.scene = 4;
        } else if (i == WXMediaMessage.TITLE_LENGTH_LIMIT) {
            this.scene = 3;
        } else if (i == 4) {
            this.scene = 8;
        }
    }

    public final String toString() {
        return "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.dJO + ", rawDuration=" + this.lkz + ", cropDuration=" + this.lkA + ", emojiItemCount=" + this.lkB + ", textItemCount=" + this.lkC + ", isCrop=" + this.lkD + ", undoCount=" + this.dal + ", doodleCount=" + this.lkE + ", penColors=" + this.lkF + ", textColor=" + this.textColor + '}';
    }
}
