package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.sdk.platformtools.x;
import java.io.Writer;

class GameGLSurfaceView$m extends Writer {
    private StringBuilder mBuilder = new StringBuilder();

    GameGLSurfaceView$m() {
    }

    public final void close() {
        bU();
    }

    public final void flush() {
        bU();
    }

    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                bU();
            } else {
                this.mBuilder.append(c);
            }
        }
    }

    private void bU() {
        if (this.mBuilder.length() > 0) {
            x.v("GLSurfaceView", this.mBuilder.toString());
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }
}
