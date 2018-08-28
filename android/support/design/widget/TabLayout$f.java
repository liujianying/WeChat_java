package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.a.f;
import android.support.v4.view.z;
import android.support.v4.widget.r;
import android.support.v7.app.ActionBar.a;
import android.support.v7.widget.h;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class TabLayout$f extends LinearLayout implements OnLongClickListener {
    final /* synthetic */ TabLayout hJ;
    private View hZ;
    private TabLayout$d ig;
    private TextView ih;
    private ImageView ii;
    private TextView ij;
    private ImageView ik;
    private int il = 2;

    static /* synthetic */ void a(TabLayout$f tabLayout$f) {
        tabLayout$f.b(null);
        tabLayout$f.setSelected(false);
    }

    public TabLayout$f(TabLayout tabLayout, Context context) {
        this.hJ = tabLayout;
        super(context);
        if (TabLayout.a(tabLayout) != 0) {
            setBackgroundDrawable(h.eJ().a(context, TabLayout.a(tabLayout), false));
        }
        z.c(this, TabLayout.b(tabLayout), TabLayout.c(tabLayout), TabLayout.d(tabLayout), TabLayout.e(tabLayout));
        setGravity(17);
        setOrientation(1);
        setClickable(true);
    }

    public final boolean performClick() {
        boolean performClick = super.performClick();
        if (this.ig == null) {
            return performClick;
        }
        this.ig.select();
        return true;
    }

    public final void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
            if (this.ih != null) {
                this.ih.setSelected(z);
            }
            if (this.ii != null) {
                this.ii.setSelected(z);
            }
        }
    }

    @TargetApi(14)
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(a.class.getName());
    }

    @TargetApi(14)
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(a.class.getName());
    }

    public final void onMeasure(int i, int i2) {
        int i3 = 1;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int f = TabLayout.f(this.hJ);
        if (f > 0 && (mode == 0 || size > f)) {
            i = MeasureSpec.makeMeasureSpec(TabLayout.g(this.hJ), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.ih != null) {
            getResources();
            float h = TabLayout.h(this.hJ);
            size = this.il;
            if (this.ii != null && this.ii.getVisibility() == 0) {
                size = 1;
            } else if (this.ih != null && this.ih.getLineCount() > 1) {
                h = TabLayout.i(this.hJ);
            }
            float textSize = this.ih.getTextSize();
            int lineCount = this.ih.getLineCount();
            int b = r.b(this.ih);
            if (h != textSize || (b >= 0 && size != b)) {
                if (TabLayout.j(this.hJ) == 1 && h > textSize && lineCount == 1) {
                    Layout layout = this.ih.getLayout();
                    if (layout == null || layout.getLineWidth(0) * (h / layout.getPaint().getTextSize()) > ((float) layout.getWidth())) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    this.ih.setTextSize(0, h);
                    this.ih.setMaxLines(size);
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    private void b(TabLayout$d tabLayout$d) {
        if (tabLayout$d != this.ig) {
            this.ig = tabLayout$d;
            update();
        }
    }

    final void update() {
        TabLayout$d tabLayout$d = this.ig;
        View view = tabLayout$d != null ? tabLayout$d.hZ : null;
        if (view != null) {
            TabLayout$f parent = view.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(view);
                }
                addView(view);
            }
            this.hZ = view;
            if (this.ih != null) {
                this.ih.setVisibility(8);
            }
            if (this.ii != null) {
                this.ii.setVisibility(8);
                this.ii.setImageDrawable(null);
            }
            this.ij = (TextView) view.findViewById(16908308);
            if (this.ij != null) {
                this.il = r.b(this.ij);
            }
            this.ik = (ImageView) view.findViewById(16908294);
        } else {
            if (this.hZ != null) {
                removeView(this.hZ);
                this.hZ = null;
            }
            this.ij = null;
            this.ik = null;
        }
        if (this.hZ == null) {
            if (this.ii == null) {
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(f.design_layout_tab_icon, this, false);
                addView(imageView, 0);
                this.ii = imageView;
            }
            if (this.ih == null) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(f.design_layout_tab_text, this, false);
                addView(textView);
                this.ih = textView;
                this.il = r.b(this.ih);
            }
            this.ih.setTextAppearance(getContext(), TabLayout.k(this.hJ));
            if (TabLayout.l(this.hJ) != null) {
                this.ih.setTextColor(TabLayout.l(this.hJ));
            }
            a(this.ih, this.ii);
        } else if (this.ij != null || this.ik != null) {
            a(this.ij, this.ik);
        }
    }

    private void a(TextView textView, ImageView imageView) {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z;
        Drawable drawable = this.ig != null ? this.ig.hh : null;
        if (this.ig != null) {
            charSequence = this.ig.mText;
        } else {
            charSequence = null;
        }
        if (this.ig != null) {
            charSequence2 = this.ig.hY;
        } else {
            charSequence2 = null;
        }
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
            imageView.setContentDescription(charSequence2);
        }
        if (TextUtils.isEmpty(charSequence)) {
            z = false;
        } else {
            z = true;
        }
        if (textView != null) {
            if (z) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView.setText(null);
            }
            textView.setContentDescription(charSequence2);
        }
        if (imageView != null) {
            int a;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
            if (z && imageView.getVisibility() == 0) {
                a = TabLayout.a(this.hJ, 8);
            } else {
                a = 0;
            }
            if (a != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = a;
                imageView.requestLayout();
            }
        }
        if (z || TextUtils.isEmpty(charSequence2)) {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    public final boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.ig.hY, 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }
}
