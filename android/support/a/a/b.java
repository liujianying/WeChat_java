package android.support.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
public final class b extends e implements Animatable {
    private a jw;
    private ArgbEvaluator jx;
    private final Callback jy;
    private Context mContext;

    private static class a extends ConstantState {
        int jA;
        f jB;
        ArrayList<Animator> jC;
        android.support.v4.e.a<Animator, String> jD;

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public final int getChangingConfigurations() {
            return this.jA;
        }
    }

    private static class b extends ConstantState {
        private final ConstantState jE;

        public b(ConstantState constantState) {
            this.jE = constantState;
        }

        public final Drawable newDrawable() {
            Drawable bVar = new b();
            bVar.jJ = this.jE.newDrawable();
            bVar.jJ.setCallback(bVar.jy);
            return bVar;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable bVar = new b();
            bVar.jJ = this.jE.newDrawable(resources);
            bVar.jJ.setCallback(bVar.jy);
            return bVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            Drawable bVar = new b();
            bVar.jJ = this.jE.newDrawable(resources, theme);
            bVar.jJ.setCallback(bVar.jy);
            return bVar;
        }

        public final boolean canApplyTheme() {
            return this.jE.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.jE.getChangingConfigurations();
        }
    }

    private b() {
        this(null, (byte) 0);
    }

    private b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b) {
        this.jx = null;
        this.jy = new Callback() {
            public final void invalidateDrawable(Drawable drawable) {
                b.this.invalidateSelf();
            }

            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                b.this.scheduleSelf(runnable, j);
            }

            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                b.this.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        this.jw = new a();
    }

    public final Drawable mutate() {
        if (this.jJ != null) {
            this.jJ.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    public final ConstantState getConstantState() {
        if (this.jJ != null) {
            return new b(this.jJ.getConstantState());
        }
        return null;
    }

    public final int getChangingConfigurations() {
        if (this.jJ != null) {
            return this.jJ.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.jw.jA;
    }

    public final void draw(Canvas canvas) {
        if (this.jJ != null) {
            this.jJ.draw(canvas);
            return;
        }
        this.jw.jB.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.jJ != null) {
            this.jJ.setBounds(rect);
        } else {
            this.jw.jB.setBounds(rect);
        }
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.jJ != null) {
            return this.jJ.setState(iArr);
        }
        return this.jw.jB.setState(iArr);
    }

    protected final boolean onLevelChange(int i) {
        if (this.jJ != null) {
            return this.jJ.setLevel(i);
        }
        return this.jw.jB.setLevel(i);
    }

    public final int getAlpha() {
        if (this.jJ != null) {
            return android.support.v4.b.a.a.d(this.jJ);
        }
        return this.jw.jB.getAlpha();
    }

    public final void setAlpha(int i) {
        if (this.jJ != null) {
            this.jJ.setAlpha(i);
        } else {
            this.jw.jB.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.jJ != null) {
            this.jJ.setColorFilter(colorFilter);
        } else {
            this.jw.jB.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i) {
        if (this.jJ != null) {
            android.support.v4.b.a.a.a(this.jJ, i);
        } else {
            this.jw.jB.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.jJ != null) {
            android.support.v4.b.a.a.a(this.jJ, colorStateList);
        } else {
            this.jw.jB.setTintList(colorStateList);
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.jJ != null) {
            android.support.v4.b.a.a.a(this.jJ, mode);
        } else {
            this.jw.jB.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.jJ != null) {
            return this.jJ.setVisible(z, z2);
        }
        this.jw.jB.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.jJ != null) {
            return this.jJ.isStateful();
        }
        return this.jw.jB.isStateful();
    }

    public final int getOpacity() {
        if (this.jJ != null) {
            return this.jJ.getOpacity();
        }
        return this.jw.jB.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.jJ != null) {
            return this.jJ.getIntrinsicWidth();
        }
        return this.jw.jB.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.jJ != null) {
            return this.jJ.getIntrinsicHeight();
        }
        return this.jw.jB.getIntrinsicHeight();
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.jJ != null) {
            android.support.v4.b.a.a.a(this.jJ, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray obtainAttributes;
                if ("animated-vector".equals(name)) {
                    int[] iArr = a.ju;
                    obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f a = f.a(resources, resourceId, theme);
                        a.jP = false;
                        a.setCallback(this.jy);
                        if (this.jw.jB != null) {
                            this.jw.jB.setCallback(null);
                        }
                        this.jw.jB = a;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, a.jv);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.mContext != null) {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(this.mContext, resourceId2);
                            loadAnimator.setTarget(this.jw.jB.jL.kH.kG.get(string));
                            if (VERSION.SDK_INT < 21) {
                                b(loadAnimator);
                            }
                            if (this.jw.jC == null) {
                                this.jw.jC = new ArrayList();
                                this.jw.jD = new android.support.v4.e.a();
                            }
                            this.jw.jC.add(loadAnimator);
                            this.jw.jD.put(loadAnimator, string);
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public final void applyTheme(Theme theme) {
        if (this.jJ != null) {
            android.support.v4.b.a.a.a(this.jJ, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.jJ != null) {
            return android.support.v4.b.a.a.e(this.jJ);
        }
        return false;
    }

    private void b(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= childAnimations.size()) {
                        break;
                    }
                    b((Animator) childAnimations.get(i2));
                    i = i2 + 1;
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.jx == null) {
                    this.jx = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.jx);
            }
        }
    }

    public final boolean isRunning() {
        if (this.jJ != null) {
            return ((AnimatedVectorDrawable) this.jJ).isRunning();
        }
        ArrayList arrayList = this.jw.jC;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean isStarted() {
        ArrayList arrayList = this.jw.jC;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        if (this.jJ != null) {
            ((AnimatedVectorDrawable) this.jJ).start();
        } else if (!isStarted()) {
            ArrayList arrayList = this.jw.jC;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.jJ != null) {
            ((AnimatedVectorDrawable) this.jJ).stop();
            return;
        }
        ArrayList arrayList = this.jw.jC;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
