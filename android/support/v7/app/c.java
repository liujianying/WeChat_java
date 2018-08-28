package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.z;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.f;
import android.support.v7.app.b.AnonymousClass2;
import android.support.v7.app.b.AnonymousClass3;
import android.support.v7.app.b.AnonymousClass4;
import android.support.v7.app.b.AnonymousClass5;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public final class c extends j implements DialogInterface {
    private b Eb = new b(getContext(), this, getWindow());

    public static class a {
        public final android.support.v7.app.b.a Ec;
        public int np;

        public a(Context context) {
            this(context, c.h(context, 0));
        }

        private a(Context context, int i) {
            this.Ec = new android.support.v7.app.b.a(new ContextThemeWrapper(context, c.h(context, i)));
            this.np = i;
        }
    }

    public c(Context context, int i) {
        super(context, h(context, i));
    }

    static int h(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.Eb.setTitle(charSequence);
    }

    protected final void onCreate(Bundle bundle) {
        int indexOfChild;
        super.onCreate(bundle);
        b bVar = this.Eb;
        int i = (bVar.Dr == 0 || bVar.Dw != 1) ? bVar.Dq : bVar.Dr;
        bVar.CR.setContentView(i);
        View findViewById = bVar.CS.findViewById(f.parentPanel);
        View findViewById2 = findViewById.findViewById(f.topPanel);
        View findViewById3 = findViewById.findViewById(f.contentPanel);
        View findViewById4 = findViewById.findViewById(f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.customPanel);
        View inflate = bVar.mView != null ? bVar.mView : bVar.CV != 0 ? LayoutInflater.from(bVar.mContext).inflate(bVar.CV, viewGroup, false) : null;
        Object obj = inflate != null ? 1 : null;
        if (obj == null || !b.aH(inflate)) {
            bVar.CS.setFlags(131072, 131072);
        }
        if (obj != null) {
            FrameLayout frameLayout = (FrameLayout) bVar.CS.findViewById(f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (bVar.Da) {
                frameLayout.setPadding(bVar.CW, bVar.CX, bVar.CY, bVar.CZ);
            }
            if (bVar.CU != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById5 = viewGroup.findViewById(f.topPanel);
        inflate = viewGroup.findViewById(f.contentPanel);
        View findViewById6 = viewGroup.findViewById(f.buttonPanel);
        ViewGroup b = b.b(findViewById5, findViewById2);
        ViewGroup b2 = b.b(inflate, findViewById3);
        ViewGroup b3 = b.b(findViewById6, findViewById4);
        bVar.Dk = (NestedScrollView) bVar.CS.findViewById(f.scrollView);
        bVar.Dk.setFocusable(false);
        bVar.Dk.setNestedScrollingEnabled(false);
        bVar.gH = (TextView) b2.findViewById(16908299);
        if (bVar.gH != null) {
            if (bVar.CT != null) {
                bVar.gH.setText(bVar.CT);
            } else {
                bVar.gH.setVisibility(8);
                bVar.Dk.removeView(bVar.gH);
                if (bVar.CU != null) {
                    ViewGroup viewGroup2 = (ViewGroup) bVar.Dk.getParent();
                    indexOfChild = viewGroup2.indexOfChild(bVar.Dk);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(bVar.CU, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    b2.setVisibility(8);
                }
            }
        }
        indexOfChild = 0;
        bVar.Db = (Button) b3.findViewById(16908313);
        bVar.Db.setOnClickListener(bVar.Dx);
        if (TextUtils.isEmpty(bVar.Dc)) {
            bVar.Db.setVisibility(8);
        } else {
            bVar.Db.setText(bVar.Dc);
            bVar.Db.setVisibility(0);
            indexOfChild = 1;
        }
        bVar.De = (Button) b3.findViewById(16908314);
        bVar.De.setOnClickListener(bVar.Dx);
        if (TextUtils.isEmpty(bVar.Df)) {
            bVar.De.setVisibility(8);
        } else {
            bVar.De.setText(bVar.Df);
            bVar.De.setVisibility(0);
            indexOfChild |= 2;
        }
        bVar.Dh = (Button) b3.findViewById(16908315);
        bVar.Dh.setOnClickListener(bVar.Dx);
        if (TextUtils.isEmpty(bVar.Di)) {
            bVar.Dh.setVisibility(8);
        } else {
            bVar.Dh.setText(bVar.Di);
            bVar.Dh.setVisibility(0);
            indexOfChild |= 4;
        }
        if ((indexOfChild != 0 ? 1 : null) == null) {
            b3.setVisibility(8);
        }
        if (bVar.Dn != null) {
            b.addView(bVar.Dn, 0, new LayoutParams(-1, -2));
            bVar.CS.findViewById(f.title_template).setVisibility(8);
        } else {
            bVar.ii = (ImageView) bVar.CS.findViewById(16908294);
            if ((!TextUtils.isEmpty(bVar.sn) ? 1 : null) != null) {
                bVar.Dm = (TextView) bVar.CS.findViewById(f.alertTitle);
                bVar.Dm.setText(bVar.sn);
                if (bVar.Dl != 0) {
                    bVar.ii.setImageResource(bVar.Dl);
                } else if (bVar.hh != null) {
                    bVar.ii.setImageDrawable(bVar.hh);
                } else {
                    bVar.Dm.setPadding(bVar.ii.getPaddingLeft(), bVar.ii.getPaddingTop(), bVar.ii.getPaddingRight(), bVar.ii.getPaddingBottom());
                    bVar.ii.setVisibility(8);
                }
            } else {
                bVar.CS.findViewById(f.title_template).setVisibility(8);
                bVar.ii.setVisibility(8);
                b.setVisibility(8);
            }
        }
        Object obj2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? null : 1;
        obj = (b == null || b.getVisibility() == 8) ? null : 1;
        Object obj3 = (b3 == null || b3.getVisibility() == 8) ? null : 1;
        if (obj3 == null && b2 != null) {
            findViewById = b2.findViewById(f.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (!(obj == null || bVar.Dk == null)) {
            bVar.Dk.setClipToPadding(true);
        }
        if (obj2 == null) {
            inflate = bVar.CU != null ? bVar.CU : bVar.Dk;
            if (inflate != null) {
                int i2 = (obj != null ? 1 : 0) | (obj3 != null ? 2 : 0);
                findViewById5 = bVar.CS.findViewById(f.scrollIndicatorUp);
                findViewById = bVar.CS.findViewById(f.scrollIndicatorDown);
                if (VERSION.SDK_INT >= 23) {
                    z.l(inflate, i2);
                    if (findViewById5 != null) {
                        b2.removeView(findViewById5);
                    }
                    if (findViewById != null) {
                        b2.removeView(findViewById);
                    }
                } else {
                    if (findViewById5 != null && (i2 & 1) == 0) {
                        b2.removeView(findViewById5);
                        findViewById5 = null;
                    }
                    if (findViewById != null && (i2 & 2) == 0) {
                        b2.removeView(findViewById);
                        findViewById = null;
                    }
                    if (!(findViewById5 == null && findViewById == null)) {
                        if (bVar.CT != null) {
                            bVar.Dk.setOnScrollChangeListener(new AnonymousClass2(findViewById5, findViewById));
                            bVar.Dk.post(new AnonymousClass3(findViewById5, findViewById));
                        } else if (bVar.CU != null) {
                            bVar.CU.setOnScrollListener(new AnonymousClass4(findViewById5, findViewById));
                            bVar.CU.post(new AnonymousClass5(findViewById5, findViewById));
                        } else {
                            if (findViewById5 != null) {
                                b2.removeView(findViewById5);
                            }
                            if (findViewById != null) {
                                b2.removeView(findViewById);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = bVar.CU;
        if (listView != null && bVar.Do != null) {
            listView.setAdapter(bVar.Do);
            int i3 = bVar.Dp;
            if (i3 >= 0) {
                listView.setItemChecked(i3, true);
                listView.setSelection(i3);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        b bVar = this.Eb;
        boolean z = bVar.Dk != null && bVar.Dk.executeKeyEvent(keyEvent);
        if (z) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        b bVar = this.Eb;
        boolean z = bVar.Dk != null && bVar.Dk.executeKeyEvent(keyEvent);
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
