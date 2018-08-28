package com.tencent.magicbrush.handler.a;

import java.nio.FloatBuffer;
import java.util.List;

final class k {
    static final k bor;
    float bos;
    float bot;
    float bou;
    float bov;
    float bow;
    float box;
    boolean boy;
    float height;
    float width;

    k() {
    }

    static {
        k kVar = new k();
        bor = kVar;
        kVar.height = 0.0f;
        kVar.width = 0.0f;
        kVar.bot = 0.0f;
        kVar.bos = 0.0f;
        kVar.box = 0.0f;
        kVar.bow = 0.0f;
        kVar.bov = 0.0f;
        kVar.bou = 0.0f;
    }

    public final void v(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    public final void d(float f, float f2, float f3, float f4) {
        this.bou = f;
        this.bov = f2;
        this.bow = f3;
        this.box = f4;
    }

    static void a(FloatBuffer floatBuffer, List<k> list) {
        if (list != null && !list.isEmpty()) {
            for (k kVar : list) {
                if (kVar != null) {
                    floatBuffer.put(kVar.bos).put(kVar.bot).put(kVar.width).put(kVar.height).put(kVar.bou).put(kVar.bov).put(kVar.bow).put(kVar.box).put(kVar.boy ? 1.0f : 0.0f);
                }
            }
        }
    }

    public final String toString() {
        return "glyph(" + this.bos + ", " + this.bot + ", [" + this.width + ", " + this.height + "], [" + this.bou + ", " + this.bov + ", " + this.bow + ", " + this.box + ", " + this.boy + "])";
    }
}
