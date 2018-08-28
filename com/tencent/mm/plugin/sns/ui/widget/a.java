package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class a extends Animation {
    private final float bwC;
    private final float bwD;
    private Context context;
    private final float omK;
    private final float omL;
    private final float omM;
    private final boolean omN;
    private Camera omO;
    private float scale = 1.0f;

    public a(Context context, float f, float f2, float f3, float f4, boolean z) {
        this.context = context;
        this.omK = f;
        this.omL = f2;
        this.bwC = f3;
        this.bwD = f4;
        this.omM = 150.0f;
        this.omN = z;
        this.scale = context.getResources().getDisplayMetrics().density;
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.omO = new Camera();
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        float f2 = this.omK + ((this.omL - this.omK) * f);
        float f3 = this.bwC;
        float f4 = this.bwD;
        Camera camera = this.omO;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.omN) {
            camera.translate(0.0f, 0.0f, this.omM * f);
        } else {
            camera.translate(0.0f, 0.0f, this.omM * (1.0f - f));
        }
        camera.rotateY(f2);
        camera.getMatrix(matrix);
        camera.restore();
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        matrix.getValues(fArr);
        fArr[6] = fArr[6] / this.scale;
        matrix.setValues(fArr);
        matrix.preTranslate(-f3, -f4);
        matrix.postTranslate(f3, f4);
    }
}
