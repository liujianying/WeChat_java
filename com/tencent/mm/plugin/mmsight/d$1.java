package com.tencent.mm.plugin.mmsight;

import java.io.File;

class d$1 implements Runnable {
    final /* synthetic */ int ldZ;
    final /* synthetic */ String lea;

    d$1(int i, String str) {
        this.ldZ = i;
        this.lea = str;
    }

    public final void run() {
        for (int bB = d.bB(); bB < this.ldZ; bB++) {
            File file = new File(String.format("%s/tempvideo%s.mp4", new Object[]{this.lea, Integer.valueOf(bB)}));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(file.getAbsolutePath() + ".remux");
            if (file2.exists()) {
                file2.delete();
            }
            file2 = new File(file.getAbsoluteFile() + ".thumb");
            if (file2.exists()) {
                file2.delete();
            }
        }
        d.access$002(Math.max(this.ldZ, 0));
    }
}
