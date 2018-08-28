package com.tencent.tencentmap.mapsdk.a;

import android.opengl.GLU;
import android.opengl.Matrix;
import com.tencent.map.lib.gl.model.c;
import com.tencent.map.lib.gl.model.d;

public class je {
    private static final String[] a = new String[]{"北", "东北", "东", "东南", "南", "西南", "西", "西北"};

    public static boolean a(float f, float f2, float[] fArr, float[] fArr2, int[] iArr) {
        d a = a(fArr);
        float[] fArr3 = new float[16];
        Matrix.setIdentityM(fArr3, 0);
        float[] a2 = a(f, f2, 0.0f, fArr3, fArr2, iArr);
        float[] a3 = a(f, f2, 1.0f, fArr3, fArr2, iArr);
        for (int i = 0; i < 3; i++) {
            a2[i] = a2[i] / a2[3];
            a3[i] = a3[i] / a3[3];
        }
        d dVar = new d(a3[0] - a2[0], a3[1] - a2[1], a3[2] - a2[2]);
        float[] a4 = a(a.a(), new float[]{fArr[0], fArr[1], fArr[2]}, dVar.a(), new float[]{a2[0], a2[1], a2[2]});
        if (a4 == null) {
            return false;
        }
        return a(a4, fArr);
    }

    public static float[] a(float f, float f2, float f3, float[] fArr, float[] fArr2, int[] iArr) {
        float[] fArr3 = new float[4];
        if (GLU.gluUnProject(f, ((float) iArr[3]) - f2, f3, fArr, 0, fArr2, 0, iArr, 0, fArr3, 0) == 1) {
            return fArr3;
        }
        throw new RuntimeException("unProject fail");
    }

    private static d a(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        r9 = new float[3];
        r10 = new float[3];
        float[] fArr2 = new float[]{f4 - f, f5 - f2, f6 - f3};
        fArr2[0] = f7 - f;
        fArr2[1] = f8 - f2;
        fArr2[2] = f9 - f3;
        r9[0] = (r10[1] * fArr2[2]) - (r10[2] * fArr2[1]);
        r9[1] = (r10[2] * fArr2[0]) - (r10[0] * fArr2[2]);
        r9[2] = (r10[0] * fArr2[1]) - (r10[1] * fArr2[0]);
        return new d(r9[0], r9[1], r9[2]);
    }

    private static boolean a(float[] fArr, float[] fArr2) {
        return new c(fArr2).a(fArr);
    }

    public static float[] a(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        float[] fArr5 = new float[3];
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr2[0];
        float f5 = fArr2[1];
        float f6 = fArr2[2];
        float f7 = fArr3[0];
        float f8 = fArr3[1];
        float f9 = fArr3[2];
        float f10 = fArr4[0];
        float f11 = fArr4[1];
        float f12 = fArr4[2];
        float f13 = ((f7 * f) + (f8 * f2)) + (f9 * f3);
        if (f13 == 0.0f) {
            return null;
        }
        f = (((f * (f4 - f10)) + (f2 * (f5 - f11))) + ((f6 - f12) * f3)) / f13;
        fArr5[0] = (f7 * f) + f10;
        fArr5[1] = (f8 * f) + f11;
        fArr5[2] = (f * f9) + f12;
        return fArr5;
    }
}
