package android.support.v4.view.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

final class f implements Interpolator {
    private final float[] yc;
    private final float[] yd;

    public f(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.yc = new float[i];
        this.yd = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, null);
            this.yc[i2] = fArr[0];
            this.yd[i2] = fArr[1];
        }
    }

    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i;
        int i2 = 0;
        int length = this.yc.length - 1;
        while (true) {
            i = i2;
            if (length - i <= 1) {
                break;
            }
            i2 = (i + length) / 2;
            if (f < this.yc[i2]) {
            }
        }
        float f2 = this.yc[length] - this.yc[i];
        if (f2 == 0.0f) {
            return this.yd[i];
        }
        float f3 = (f - this.yc[i]) / f2;
        f2 = this.yd[i];
        return (f3 * (this.yd[length] - f2)) + f2;
    }
}
