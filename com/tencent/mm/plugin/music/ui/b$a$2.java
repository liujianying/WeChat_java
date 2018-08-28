package com.tencent.mm.plugin.music.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import com.tencent.mm.plugin.music.ui.b.a;

class b$a$2 extends ShaderFactory {
    final /* synthetic */ a lAR;
    final /* synthetic */ int lAS;

    b$a$2(a aVar, int i) {
        this.lAR = aVar;
        this.lAS = i;
    }

    public final Shader resize(int i, int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{this.lAS, 0}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
    }
}
