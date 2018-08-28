package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.e.f;
import android.support.v7.a.a.e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class h {
    private static final Mode Mo = Mode.SRC_IN;
    private static h Mp;
    private static final b Mq = new b();
    private static final int[] Mr = new int[]{e.abc_textfield_search_default_mtrl_alpha, e.abc_textfield_default_mtrl_alpha, e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] Ms = new int[]{e.abc_ic_ab_back_mtrl_am_alpha, e.abc_ic_go_search_api_mtrl_alpha, e.abc_ic_search_api_mtrl_alpha, e.abc_ic_commit_search_api_mtrl_alpha, e.abc_ic_clear_mtrl_alpha, e.abc_ic_menu_share_mtrl_alpha, e.abc_ic_menu_copy_mtrl_am_alpha, e.abc_ic_menu_cut_mtrl_alpha, e.abc_ic_menu_selectall_mtrl_alpha, e.abc_ic_menu_paste_mtrl_am_alpha, e.abc_ic_menu_moreoverflow_mtrl_alpha, e.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] Mt = new int[]{e.abc_textfield_activated_mtrl_alpha, e.abc_textfield_search_activated_mtrl_alpha, e.abc_cab_background_top_mtrl_alpha, e.abc_text_cursor_material};
    private static final int[] Mu = new int[]{e.abc_popup_background_mtrl_mult, e.abc_cab_background_internal_bg, e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] Mv = new int[]{e.abc_edit_text_material, e.abc_tab_indicator_material, e.abc_textfield_search_material, e.abc_spinner_mtrl_am_alpha, e.abc_spinner_textfield_background_material, e.abc_ratingbar_full_material, e.abc_switch_track_mtrl_alpha, e.abc_switch_thumb_material, e.abc_btn_default_mtrl_shape, e.abc_btn_borderless_material};
    private static final int[] Mw = new int[]{e.abc_btn_check_material, e.abc_btn_radio_material};
    private final Object MA = new Object();
    private final WeakHashMap<Context, android.support.v4.e.e<WeakReference<ConstantState>>> MB = new WeakHashMap(0);
    private TypedValue MC;
    private WeakHashMap<Context, SparseArray<ColorStateList>> Mx;
    private android.support.v4.e.a<String, c> My;
    private SparseArray<String> Mz;

    private interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    private static class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.a.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    private static class b extends f<Integer, PorterDuffColorFilter> {
        static int b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    private static class d implements c {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.a.a.f.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static h eJ() {
        if (Mp == null) {
            h hVar = new h();
            Mp = hVar;
            int i = VERSION.SDK_INT;
            if (i < 23) {
                hVar.a("vector", new d());
                if (i >= 11) {
                    hVar.a("animated-vector", new a());
                }
            }
        }
        return Mp;
    }

    public final Drawable a(Context context, int i, boolean z) {
        Drawable i2 = i(context, i);
        if (i2 == null) {
            if (this.MC == null) {
                this.MC = new TypedValue();
            }
            TypedValue typedValue = this.MC;
            context.getResources().getValue(i, typedValue, true);
            long a = a(typedValue);
            i2 = a(context, a);
            if (i2 == null) {
                if (i == e.abc_cab_background_top_material) {
                    i2 = new LayerDrawable(new Drawable[]{a(context, e.abc_cab_background_internal_bg, false), a(context, e.abc_cab_background_top_mtrl_alpha, false)});
                }
                if (i2 != null) {
                    i2.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a, i2);
                }
            }
        }
        if (i2 == null) {
            i2 = android.support.v4.content.a.f(context, i);
        }
        if (i2 != null) {
            i2 = a(context, i, z, i2);
        }
        if (i2 != null) {
            w.m(i2);
        }
        return i2;
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    final Drawable a(Context context, int i, boolean z, Drawable drawable) {
        Mode mode = null;
        ColorStateList j = j(context, i);
        LayerDrawable layerDrawable;
        if (j != null) {
            if (w.n(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = android.support.v4.b.a.a.g(drawable);
            android.support.v4.b.a.a.a(drawable, j);
            if (i == e.abc_switch_thumb_material) {
                mode = Mode.MULTIPLY;
            }
            if (mode == null) {
                return drawable;
            }
            android.support.v4.b.a.a.a(drawable, mode);
            return drawable;
        } else if (i == e.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), al.m(context, android.support.v7.a.a.a.colorControlNormal), Mo);
            a(layerDrawable.findDrawableByLayerId(16908303), al.m(context, android.support.v7.a.a.a.colorControlNormal), Mo);
            a(layerDrawable.findDrawableByLayerId(16908301), al.m(context, android.support.v7.a.a.a.colorControlActivated), Mo);
            return drawable;
        } else if (i == e.abc_ratingbar_indicator_material || i == e.abc_ratingbar_small_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), al.o(context, android.support.v7.a.a.a.colorControlNormal), Mo);
            a(layerDrawable.findDrawableByLayerId(16908303), al.m(context, android.support.v7.a.a.a.colorControlActivated), Mo);
            a(layerDrawable.findDrawableByLayerId(16908301), al.m(context, android.support.v7.a.a.a.colorControlActivated), Mo);
            return drawable;
        } else if (a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    final Drawable i(Context context, int i) {
        if (this.My == null || this.My.isEmpty()) {
            return null;
        }
        String str;
        if (this.Mz != null) {
            str = (String) this.Mz.get(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.My.get(str) == null)) {
                return null;
            }
        }
        this.Mz = new SparseArray();
        if (this.MC == null) {
            this.MC = new TypedValue();
        }
        TypedValue typedValue = this.MC;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a = a(typedValue);
        Drawable a2 = a(context, a);
        if (a2 != null) {
            return a2;
        }
        Drawable drawable;
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                int next;
                XmlPullParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                str = xml.getName();
                this.Mz.append(i, str);
                c cVar = (c) this.My.get(str);
                if (cVar != null) {
                    a2 = cVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a2 != null) {
                    a2.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a, a2);
                }
                drawable = a2;
                if (drawable == null) {
                    return drawable;
                }
                this.Mz.append(i, "appcompat_skip_skip");
                return drawable;
            } catch (Exception e) {
            }
        }
        drawable = a2;
        if (drawable == null) {
            return drawable;
        }
        this.Mz.append(i, "appcompat_skip_skip");
        return drawable;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(android.content.Context r7, long r8) {
        /*
        r6 = this;
        r2 = 0;
        r3 = r6.MA;
        monitor-enter(r3);
        r0 = r6.MB;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r7);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.e.e) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.get(r8);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0049;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r7.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r1 = r0.tC;	 Catch:{ all -> 0x002b }
        r4 = r0.fi;	 Catch:{ all -> 0x002b }
        r1 = android.support.v4.e.b.a(r1, r4, r8);	 Catch:{ all -> 0x002b }
        if (r1 < 0) goto L_0x0049;
    L_0x0038:
        r4 = r0.tD;	 Catch:{ all -> 0x002b }
        r4 = r4[r1];	 Catch:{ all -> 0x002b }
        r5 = android.support.v4.e.e.tA;	 Catch:{ all -> 0x002b }
        if (r4 == r5) goto L_0x0049;
    L_0x0040:
        r4 = r0.tD;	 Catch:{ all -> 0x002b }
        r5 = android.support.v4.e.e.tA;	 Catch:{ all -> 0x002b }
        r4[r1] = r5;	 Catch:{ all -> 0x002b }
        r1 = 1;
        r0.tB = r1;	 Catch:{ all -> 0x002b }
    L_0x0049:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.h.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.MA) {
            android.support.v4.e.e eVar = (android.support.v4.e.e) this.MB.get(context);
            if (eVar == null) {
                eVar = new android.support.v4.e.e();
                this.MB.put(context, eVar);
            }
            eVar.put(j, new WeakReference(constantState));
        }
        return true;
    }

    static boolean a(Context context, int i, Drawable drawable) {
        int i2;
        int i3;
        boolean z;
        Mode mode = Mo;
        if (b(Mr, i)) {
            i2 = android.support.v7.a.a.a.colorControlNormal;
            i3 = -1;
            z = true;
        } else if (b(Mt, i)) {
            i2 = android.support.v7.a.a.a.colorControlActivated;
            i3 = -1;
            z = true;
        } else if (b(Mu, i)) {
            i2 = 16842801;
            mode = Mode.MULTIPLY;
            i3 = -1;
            z = true;
        } else if (i == e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (w.n(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(a(al.m(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void a(String str, c cVar) {
        if (this.My == null) {
            this.My = new android.support.v4.e.a();
        }
        this.My.put(str, cVar);
    }

    private static boolean b(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final ColorStateList j(Context context, int i) {
        SparseArray sparseArray;
        ColorStateList colorStateList;
        if (this.Mx != null) {
            sparseArray = (SparseArray) this.Mx.get(context);
            colorStateList = sparseArray != null ? (ColorStateList) sparseArray.get(i) : null;
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList colorStateList2;
        int[][] iArr;
        int[] iArr2;
        if (i == e.abc_edit_text_material) {
            iArr = new int[3][];
            iArr2 = new int[]{al.gc, al.o(context, android.support.v7.a.a.a.colorControlNormal), al.Wp};
            iArr2[1] = al.m(context, android.support.v7.a.a.a.colorControlNormal);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.m(context, android.support.v7.a.a.a.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.abc_switch_track_mtrl_alpha) {
            iArr = new int[3][];
            iArr2 = new int[]{al.gc, al.a(context, 16842800, 0.1f), al.bh};
            iArr2[1] = al.a(context, android.support.v7.a.a.a.colorControlActivated, 0.3f);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.a(context, 16842800, 0.3f);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.abc_switch_thumb_material) {
            iArr = new int[3][];
            iArr2 = new int[3];
            colorStateList2 = al.n(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
            if (colorStateList2 == null || !colorStateList2.isStateful()) {
                iArr[0] = al.gc;
                iArr2[0] = al.o(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
                iArr[1] = al.bh;
                iArr2[1] = al.m(context, android.support.v7.a.a.a.colorControlActivated);
                iArr[2] = al.EMPTY_STATE_SET;
                iArr2[2] = al.m(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
            } else {
                iArr[0] = al.gc;
                iArr2[0] = colorStateList2.getColorForState(iArr[0], 0);
                iArr[1] = al.bh;
                iArr2[1] = al.m(context, android.support.v7.a.a.a.colorControlActivated);
                iArr[2] = al.EMPTY_STATE_SET;
                iArr2[2] = colorStateList2.getDefaultColor();
            }
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.abc_btn_default_mtrl_shape) {
            colorStateList2 = k(context, al.m(context, android.support.v7.a.a.a.colorButtonNormal));
        } else if (i == e.abc_btn_borderless_material) {
            colorStateList2 = k(context, 0);
        } else if (i == e.abc_btn_colored_material) {
            colorStateList2 = k(context, al.m(context, android.support.v7.a.a.a.colorAccent));
        } else if (i == e.abc_spinner_mtrl_am_alpha || i == e.abc_spinner_textfield_background_material) {
            iArr = new int[3][];
            iArr2 = new int[]{al.gc, al.o(context, android.support.v7.a.a.a.colorControlNormal), al.Wp};
            iArr2[1] = al.m(context, android.support.v7.a.a.a.colorControlNormal);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.m(context, android.support.v7.a.a.a.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (b(Ms, i)) {
            colorStateList2 = al.n(context, android.support.v7.a.a.a.colorControlNormal);
        } else if (b(Mv, i)) {
            int m = al.m(context, android.support.v7.a.a.a.colorControlNormal);
            int m2 = al.m(context, android.support.v7.a.a.a.colorControlActivated);
            r2 = new int[7][];
            int[] iArr3 = new int[]{al.gc, al.o(context, android.support.v7.a.a.a.colorControlNormal), al.FOCUSED_STATE_SET, m2, al.Wo, m2, al.PRESSED_STATE_SET};
            iArr3[3] = m2;
            r2[4] = al.bh;
            iArr3[4] = m2;
            r2[5] = al.SELECTED_STATE_SET;
            iArr3[5] = m2;
            r2[6] = al.EMPTY_STATE_SET;
            iArr3[6] = m;
            colorStateList2 = new ColorStateList(r2, iArr3);
        } else if (b(Mw, i)) {
            iArr = new int[3][];
            iArr2 = new int[]{al.gc, al.o(context, android.support.v7.a.a.a.colorControlNormal), al.bh};
            iArr2[1] = al.m(context, android.support.v7.a.a.a.colorControlActivated);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.m(context, android.support.v7.a.a.a.colorControlNormal);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.abc_seekbar_thumb_material) {
            iArr = new int[2][];
            iArr2 = new int[]{al.gc, al.o(context, android.support.v7.a.a.a.colorControlActivated)};
            iArr[1] = al.EMPTY_STATE_SET;
            iArr2[1] = al.m(context, android.support.v7.a.a.a.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else {
            colorStateList2 = colorStateList;
        }
        if (colorStateList2 != null) {
            if (this.Mx == null) {
                this.Mx = new WeakHashMap();
            }
            sparseArray = (SparseArray) this.Mx.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.Mx.put(context, sparseArray);
            }
            sparseArray.append(i, colorStateList2);
        }
        return colorStateList2;
    }

    private static ColorStateList k(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int m = al.m(context, android.support.v7.a.a.a.colorControlHighlight);
        r0[0] = al.gc;
        r1[0] = al.o(context, android.support.v7.a.a.a.colorButtonNormal);
        r0[1] = al.PRESSED_STATE_SET;
        r1[1] = android.support.v4.b.b.n(m, i);
        r0[2] = al.FOCUSED_STATE_SET;
        r1[2] = android.support.v4.b.b.n(m, i);
        r0[3] = al.EMPTY_STATE_SET;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    public static void a(Drawable drawable, an anVar, int[] iArr) {
        ColorFilter colorFilter = null;
        if (!w.n(drawable) || drawable.mutate() == drawable) {
            if (anVar.Wu || anVar.Wt) {
                ColorStateList colorStateList = anVar.Wu ? anVar.Ws : null;
                Mode mode = anVar.Wt ? anVar.kJ : Mo;
                if (!(colorStateList == null || mode == null)) {
                    colorFilter = a(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(colorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public static PorterDuffColorFilter a(int i, Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = (PorterDuffColorFilter) Mq.get(Integer.valueOf(b.b(i, mode)));
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        Mq.put(Integer.valueOf(b.b(i, mode)), porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (w.n(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = Mo;
        }
        drawable.setColorFilter(a(i, mode));
    }
}
