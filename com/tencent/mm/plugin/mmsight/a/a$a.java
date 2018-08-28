package com.tencent.mm.plugin.mmsight.a;

public class a$a {
    int scene;
    int source = 2;

    public a$a(int i) {
        if (i == 1) {
            this.scene = 1;
        } else if (i == 2) {
            this.scene = 2;
        } else if (i == 512) {
            this.source = 1;
            this.scene = 2;
        } else if (i == 4) {
            this.scene = 4;
        }
    }

    public final String toString() {
        return "VideoEditCountData{scene=" + this.scene + ", source=" + this.source + '}';
    }
}
