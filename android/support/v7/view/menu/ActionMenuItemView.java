package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements android.support.v7.view.menu.m.a, android.support.v7.widget.ActionMenuView.a, OnClickListener, OnLongClickListener {
    private boolean HA;
    private int HB;
    private int HC;
    private int HD;
    private android.support.v7.view.menu.f.b Hw;
    private android.support.v7.widget.ListPopupWindow.b Hx;
    private b Hy;
    private boolean Hz;
    private h bl;
    private Drawable hh;
    private CharSequence sn;

    public static abstract class b {
        public abstract ListPopupWindow dB();
    }

    private class a extends android.support.v7.widget.ListPopupWindow.b {
        public a() {
            super(ActionMenuItemView.this);
        }

        public final ListPopupWindow dB() {
            if (ActionMenuItemView.this.Hy != null) {
                return ActionMenuItemView.this.Hy.dB();
            }
            return null;
        }

        protected final boolean dC() {
            if (ActionMenuItemView.this.Hw == null || !ActionMenuItemView.this.Hw.f(ActionMenuItemView.this.bl)) {
                return false;
            }
            ListPopupWindow dB = dB();
            if (dB == null || !dB.PK.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.Hz = resources.getBoolean(android.support.v7.a.a.b.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActionMenuItemView, i, 0);
        this.HB = obtainStyledAttributes.getDimensionPixelSize(k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.HD = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.HC = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.Hz = getContext().getResources().getBoolean(android.support.v7.a.a.b.abc_config_allowActionMenuItemTextWithIcon);
        dy();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.HC = i;
        super.setPadding(i, i2, i3, i4);
    }

    public h getItemData() {
        return this.bl;
    }

    public final void a(h hVar) {
        this.bl = hVar;
        setIcon(hVar.getIcon());
        setTitle(hVar.a((android.support.v7.view.menu.m.a) this));
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.Hx == null) {
            this.Hx = new a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bl.hasSubMenu() && this.Hx != null && this.Hx.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.Hw != null) {
            this.Hw.f(this.bl);
        }
    }

    public void setItemInvoker(android.support.v7.view.menu.f.b bVar) {
        this.Hw = bVar;
    }

    public void setPopupCallback(b bVar) {
        this.Hy = bVar;
    }

    public final boolean M() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.HA != z) {
            this.HA = z;
            if (this.bl != null) {
                this.bl.bq.dM();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dy() {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        r0 = r5.sn;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = r5.hh;
        if (r3 == 0) goto L_0x0023;
    L_0x000f:
        r3 = r5.bl;
        r3 = r3.IF;
        r3 = r3 & 4;
        r4 = 4;
        if (r3 != r4) goto L_0x002f;
    L_0x0018:
        r3 = r1;
    L_0x0019:
        if (r3 == 0) goto L_0x0024;
    L_0x001b:
        r3 = r5.Hz;
        if (r3 != 0) goto L_0x0023;
    L_0x001f:
        r3 = r5.HA;
        if (r3 == 0) goto L_0x0024;
    L_0x0023:
        r2 = r1;
    L_0x0024:
        r0 = r0 & r2;
        if (r0 == 0) goto L_0x0031;
    L_0x0027:
        r0 = r5.sn;
    L_0x0029:
        r5.setText(r0);
        return;
    L_0x002d:
        r0 = r2;
        goto L_0x000b;
    L_0x002f:
        r3 = r2;
        goto L_0x0019;
    L_0x0031:
        r0 = 0;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.ActionMenuItemView.dy():void");
    }

    public void setIcon(Drawable drawable) {
        this.hh = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.HD) {
                f = ((float) this.HD) / ((float) intrinsicWidth);
                intrinsicWidth = this.HD;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.HD) {
                f = ((float) this.HD) / ((float) intrinsicHeight);
                intrinsicHeight = this.HD;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        dy();
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.sn = charSequence;
        setContentDescription(this.sn);
        dy();
    }

    public final boolean dz() {
        return hasText() && this.bl.getIcon() == null;
    }

    public final boolean dA() {
        return hasText();
    }

    public boolean onLongClick(View view) {
        if (hasText()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (z.I(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.bl.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean hasText = hasText();
        if (hasText && this.HC >= 0) {
            super.setPadding(this.HC, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.HB) : this.HB;
        if (mode != 1073741824 && this.HB > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!hasText && this.hh != null) {
            super.setPadding((getMeasuredWidth() - this.hh.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
