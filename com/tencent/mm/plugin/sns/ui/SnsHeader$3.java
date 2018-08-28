package com.tencent.mm.plugin.sns.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

class SnsHeader$3 extends ShaderFactory {
    final /* synthetic */ SnsHeader nWo;
    final /* synthetic */ int nWr;

    SnsHeader$3(SnsHeader snsHeader, int i) {
        this.nWo = snsHeader;
        this.nWr = i;
    }

    public final Shader resize(int i, int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{this.nWr, 0}, new float[]{0.0f, 1.0f}, TileMode.CLAMP);
    }
}
