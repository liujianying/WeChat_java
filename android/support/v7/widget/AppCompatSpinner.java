package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.x;
import android.support.v4.view.z;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.d;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner extends Spinner implements x {
    private static final boolean MO;
    private static final boolean MP;
    private static final int[] MQ = new int[]{16843505};
    private android.support.v7.widget.ListPopupWindow.b Hx;
    private Context Jn;
    private SpinnerAdapter MR;
    private boolean MS;
    private b MT;
    private int MU;
    private h Mb;
    private f Mc;
    private final Rect bJ;

    private static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter MX;
        private ListAdapter MY;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.MX = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.MY = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && AppCompatSpinner.MO && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public final int getCount() {
            return this.MX == null ? 0 : this.MX.getCount();
        }

        public final Object getItem(int i) {
            return this.MX == null ? null : this.MX.getItem(i);
        }

        public final long getItemId(int i) {
            return this.MX == null ? -1 : this.MX.getItemId(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.MX == null ? null : this.MX.getDropDownView(i, view, viewGroup);
        }

        public final boolean hasStableIds() {
            return this.MX != null && this.MX.hasStableIds();
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.MX != null) {
                this.MX.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.MX != null) {
                this.MX.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.MY;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.MY;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class b extends ListPopupWindow {
        private ListAdapter Do;
        CharSequence MZ;
        private final Rect Na = new Rect();

        static /* synthetic */ boolean a(b bVar, View view) {
            return z.ak(view) && view.getGlobalVisibleRect(bVar.Na);
        }

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.PW = AppCompatSpinner.this;
            setModal(true);
            this.PV = 0;
            this.PY = new OnItemClickListener(AppCompatSpinner.this) {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppCompatSpinner.this.setSelection(i);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i, b.this.Do.getItemId(i));
                    }
                    b.this.dismiss();
                }
            };
        }

        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.Do = listAdapter;
        }

        final void eK() {
            int i;
            int i2;
            Drawable background = this.PK.getBackground();
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.bJ);
                i = at.bv(AppCompatSpinner.this) ? AppCompatSpinner.this.bJ.right : -AppCompatSpinner.this.bJ.left;
            } else {
                Rect b = AppCompatSpinner.this.bJ;
                AppCompatSpinner.this.bJ.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.MU == -2) {
                int a = AppCompatSpinner.this.a((SpinnerAdapter) this.Do, this.PK.getBackground());
                i2 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.bJ.left) - AppCompatSpinner.this.bJ.right;
                if (a <= i2) {
                    i2 = a;
                }
                setContentWidth(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.MU == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(AppCompatSpinner.this.MU);
            }
            if (at.bv(AppCompatSpinner.this)) {
                i2 = ((width - paddingRight) - this.MU) + i;
            } else {
                i2 = i + paddingLeft;
            }
            this.PN = i2;
        }

        public final void show() {
            boolean isShowing = this.PK.isShowing();
            eK();
            fo();
            super.b();
            this.PL.setChoiceMode(1);
            int selectedItemPosition = AppCompatSpinner.this.getSelectedItemPosition();
            a aVar = this.PL;
            if (this.PK.isShowing() && aVar != null) {
                aVar.Qh = false;
                aVar.setSelection(selectedItemPosition);
                if (VERSION.SDK_INT >= 11 && aVar.getChoiceMode() != 0) {
                    aVar.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener() {
                        public final void onGlobalLayout() {
                            if (b.a(b.this, AppCompatSpinner.this)) {
                                b.this.eK();
                                super.b();
                                return;
                            }
                            b.this.dismiss();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    setOnDismissListener(new OnDismissListener() {
                        public final void onDismiss() {
                            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        MO = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        MP = z;
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i, -1);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        Context dVar;
        AppCompatSpinner appCompatSpinner;
        CharSequence[] textArray;
        Throwable th;
        TypedArray typedArray;
        super(context, attributeSet, i);
        this.bJ = new Rect();
        ap a = ap.a(context, attributeSet, k.Spinner, i);
        this.Mb = h.eJ();
        this.Mc = new f(this, this.Mb);
        int resourceId = a.getResourceId(k.Spinner_popupTheme, 0);
        if (resourceId != 0) {
            dVar = new d(context, resourceId);
            appCompatSpinner = this;
        } else if (MO) {
            dVar = null;
            appCompatSpinner = this;
        } else {
            dVar = context;
            appCompatSpinner = this;
        }
        appCompatSpinner.Jn = dVar;
        if (this.Jn != null) {
            if (VERSION.SDK_INT >= 11) {
                TypedArray obtainStyledAttributes;
                try {
                    obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, MQ, i, 0);
                    try {
                        if (obtainStyledAttributes.hasValue(0)) {
                            i2 = obtainStyledAttributes.getInt(0, 0);
                        }
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                    } catch (Exception e) {
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            final b bVar = new b(this.Jn, attributeSet, i);
                            ap a2 = ap.a(this.Jn, attributeSet, k.Spinner, i);
                            this.MU = a2.getLayoutDimension(k.Spinner_android_dropDownWidth, -2);
                            bVar.setBackgroundDrawable(a2.getDrawable(k.Spinner_android_popupBackground));
                            bVar.MZ = a.Ww.getString(k.Spinner_android_prompt);
                            a2.Ww.recycle();
                            this.MT = bVar;
                            this.Hx = new android.support.v7.widget.ListPopupWindow.b(this) {
                                public final ListPopupWindow dB() {
                                    return bVar;
                                }

                                public final boolean dC() {
                                    if (!AppCompatSpinner.this.MT.PK.isShowing()) {
                                        AppCompatSpinner.this.MT.show();
                                    }
                                    return true;
                                }
                            };
                        }
                        textArray = a.Ww.getTextArray(k.Spinner_android_entries);
                        if (textArray != null) {
                            SpinnerAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                            arrayAdapter.setDropDownViewResource(h.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a.Ww.recycle();
                        this.MS = true;
                        if (this.MR != null) {
                            setAdapter(this.MR);
                            this.MR = null;
                        }
                        this.Mc.b(attributeSet, i);
                    } catch (Throwable th2) {
                        th = th2;
                        typedArray = obtainStyledAttributes;
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    obtainStyledAttributes = null;
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    if (i2 == 1) {
                        final b bVar2 = new b(this.Jn, attributeSet, i);
                        ap a22 = ap.a(this.Jn, attributeSet, k.Spinner, i);
                        this.MU = a22.getLayoutDimension(k.Spinner_android_dropDownWidth, -2);
                        bVar2.setBackgroundDrawable(a22.getDrawable(k.Spinner_android_popupBackground));
                        bVar2.MZ = a.Ww.getString(k.Spinner_android_prompt);
                        a22.Ww.recycle();
                        this.MT = bVar2;
                        this.Hx = /* anonymous class already generated */;
                    }
                    textArray = a.Ww.getTextArray(k.Spinner_android_entries);
                    if (textArray != null) {
                        SpinnerAdapter arrayAdapter2 = new ArrayAdapter(context, 17367048, textArray);
                        arrayAdapter2.setDropDownViewResource(h.support_simple_spinner_dropdown_item);
                        setAdapter(arrayAdapter2);
                    }
                    a.Ww.recycle();
                    this.MS = true;
                    if (this.MR != null) {
                        setAdapter(this.MR);
                        this.MR = null;
                    }
                    this.Mc.b(attributeSet, i);
                } catch (Throwable th3) {
                    th = th3;
                    typedArray = null;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            }
            i2 = 1;
            if (i2 == 1) {
                final b bVar22 = new b(this.Jn, attributeSet, i);
                ap a222 = ap.a(this.Jn, attributeSet, k.Spinner, i);
                this.MU = a222.getLayoutDimension(k.Spinner_android_dropDownWidth, -2);
                bVar22.setBackgroundDrawable(a222.getDrawable(k.Spinner_android_popupBackground));
                bVar22.MZ = a.Ww.getString(k.Spinner_android_prompt);
                a222.Ww.recycle();
                this.MT = bVar22;
                this.Hx = /* anonymous class already generated */;
            }
        }
        textArray = a.Ww.getTextArray(k.Spinner_android_entries);
        if (textArray != null) {
            SpinnerAdapter arrayAdapter22 = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter22.setDropDownViewResource(h.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter22);
        }
        a.Ww.recycle();
        this.MS = true;
        if (this.MR != null) {
            setAdapter(this.MR);
            this.MR = null;
        }
        this.Mc.b(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.MT != null) {
            return this.Jn;
        }
        if (MO) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.MT != null) {
            this.MT.setBackgroundDrawable(drawable);
        } else if (MP) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v4.content.a.f(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.MT != null) {
            return this.MT.PK.getBackground();
        }
        if (MP) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.MT != null) {
            this.MT.setVerticalOffset(i);
        } else if (MP) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.MT != null) {
            ListPopupWindow listPopupWindow = this.MT;
            if (listPopupWindow.PQ) {
                return listPopupWindow.PO;
            }
            return 0;
        } else if (MP) {
            return super.getDropDownVerticalOffset();
        } else {
            return 0;
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.MT != null) {
            this.MT.PN = i;
        } else if (MP) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.MT != null) {
            return this.MT.PN;
        }
        if (MP) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.MT != null) {
            this.MU = i;
        } else if (MP) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.MT != null) {
            return this.MU;
        }
        if (MP) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.MS) {
            super.setAdapter(spinnerAdapter);
            if (this.MT != null) {
                this.MT.setAdapter(new a(spinnerAdapter, (this.Jn == null ? getContext() : this.Jn).getTheme()));
                return;
            }
            return;
        }
        this.MR = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.MT != null && this.MT.PK.isShowing()) {
            this.MT.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hx == null || !this.Hx.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.MT != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.MT == null) {
            return super.performClick();
        }
        if (!this.MT.PK.isShowing()) {
            this.MT.show();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.MT != null) {
            this.MT.MZ = charSequence;
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.MT != null ? this.MT.MZ : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Mc != null) {
            this.Mc.aT(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Mc != null) {
            this.Mc.b(null);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.Mc != null) {
            this.Mc.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.Mc != null ? this.Mc.getSupportBackgroundTintList() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.Mc != null) {
            this.Mc.setSupportBackgroundTintMode(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.Mc != null ? this.Mc.getSupportBackgroundTintMode() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Mc != null) {
            this.Mc.eG();
        }
    }

    private int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        max = 0;
        View view = null;
        int i = 0;
        while (max2 < min) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view = null;
            } else {
                itemViewType = max;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.bJ);
        return (this.bJ.left + this.bJ.right) + i;
    }
}
