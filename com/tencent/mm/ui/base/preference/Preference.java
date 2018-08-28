package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.y;
import com.tencent.mm.w.a.c;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;
import java.util.List;

public class Preference implements Comparable<Preference> {
    public int Hu;
    public int hIZ;
    public Drawable hh;
    private CharSequence lXS;
    public final Context mContext;
    private Bundle mExtras;
    public String mKey;
    private CharSequence sn;
    private a tDj;
    public b tDk;
    private int tDl;
    private int tDm;
    private int tDn;
    private String tDo;
    boolean tDp;
    private boolean tDq;
    public boolean tDr;
    String tDs;
    private Object tDt;
    private boolean tDu;
    private boolean tDv;
    private int tDw;
    int tDx;
    private boolean tDy;
    private List<Preference> tDz;
    private int[] vA;
    private boolean yr;

    public interface a {
        boolean a(Preference preference, Object obj);
    }

    public /* synthetic */ int compareTo(Object obj) {
        Preference preference = (Preference) obj;
        if (this.tDl != Integer.MAX_VALUE || (this.tDl == Integer.MAX_VALUE && preference.tDl != Integer.MAX_VALUE)) {
            return this.tDl - preference.tDl;
        }
        if (this.sn == null) {
            return 1;
        }
        if (preference.sn == null) {
            return -1;
        }
        CharSequence charSequence = this.sn;
        CharSequence charSequence2 = preference.sn;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i = length < length2 ? length : length2;
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            i2 = Character.toLowerCase(charSequence.charAt(i3)) - Character.toLowerCase(charSequence2.charAt(i2));
            if (i2 != 0) {
                return i2;
            }
            i2 = i5;
            i3 = i4;
        }
        return length - length2;
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.vA = new int[]{c.title, c.summary};
        this.tDl = Integer.MAX_VALUE;
        this.yr = true;
        this.tDp = true;
        this.tDr = true;
        this.tDu = true;
        this.hIZ = -1;
        this.tDv = true;
        this.tDw = h.mm_preference;
        this.tDy = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.Preference, i, 0);
        for (int indexCount = obtainStyledAttributes.getIndexCount(); indexCount >= 0; indexCount--) {
            int index = obtainStyledAttributes.getIndex(indexCount);
            if (index == m.Preference_icon) {
                this.Hu = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == m.Preference_key) {
                this.mKey = obtainStyledAttributes.getString(index);
            } else if (index == m.Preference_title) {
                this.tDm = obtainStyledAttributes.getResourceId(index, 0);
                this.sn = obtainStyledAttributes.getString(index);
                if (this.tDm != 0) {
                    this.sn = context.getString(this.tDm);
                }
            } else if (index == m.Preference_summary) {
                this.lXS = obtainStyledAttributes.getString(index);
                this.tDn = obtainStyledAttributes.getResourceId(index, 0);
                if (this.tDn != 0) {
                    this.lXS = context.getString(this.tDn);
                }
            } else if (index == m.Preference_order) {
                this.tDl = obtainStyledAttributes.getInt(index, this.tDl);
            } else if (index == m.Preference_fragment) {
                this.tDo = obtainStyledAttributes.getString(index);
            } else if (index == m.Preference_layout) {
                this.tDw = obtainStyledAttributes.getResourceId(index, this.tDw);
            } else if (index == m.Preference_widgetLayout) {
                this.tDx = obtainStyledAttributes.getResourceId(index, this.tDx);
            } else if (index == m.Preference_enabled) {
                this.yr = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == m.Preference_selectable) {
                this.tDp = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == m.Preference_persistent) {
                this.tDr = obtainStyledAttributes.getBoolean(index, this.tDr);
            } else if (index == m.Preference_dependency) {
                this.tDs = obtainStyledAttributes.getString(index);
            } else if (index == m.Preference_defaultValue) {
                this.tDt = null;
            } else if (index == m.Preference_shouldDisableView) {
                this.tDv = obtainStyledAttributes.getBoolean(index, this.tDv);
            }
        }
        obtainStyledAttributes.recycle();
        if (!getClass().getName().startsWith("android.preference")) {
            this.tDy = true;
        }
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842894);
    }

    public Preference(Context context) {
        this(context, null);
    }

    public final Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    public final void setLayoutResource(int i) {
        if (i != this.tDw) {
            this.tDy = true;
        }
        this.tDw = i;
    }

    public int getLayoutResource() {
        return this.tDw;
    }

    public final void setWidgetLayoutResource(int i) {
        if (i != this.tDx) {
            this.tDy = true;
        }
        this.tDx = i;
    }

    public View getView(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = onCreateView(viewGroup);
        }
        onBindView(view);
        return view;
    }

    public View onCreateView(ViewGroup viewGroup) {
        LayoutInflater gq = y.gq(this.mContext);
        View inflate = gq.inflate(this.tDw, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (this.tDx != 0) {
                gq.inflate(this.tDx, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return inflate;
    }

    public void onBindView(View view) {
        int i = 0;
        View findViewById = view.findViewById(g.content);
        if (findViewById != null) {
            findViewById.setMinimumHeight((int) (((float) view.getResources().getDimensionPixelSize(e.SmallListHeight)) * com.tencent.mm.bp.a.fh(this.mContext)));
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setText(getTitle());
        }
        textView = (TextView) view.findViewById(16908304);
        if (textView != null) {
            if (!TextUtils.isEmpty(getSummary())) {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setText(getSummary());
                if (this.hIZ != -1) {
                    textView.setTextColor(this.hIZ);
                }
            } else if (textView.getVisibility() != 8) {
                textView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) view.findViewById(16908294);
        if (imageView != null) {
            if (!(this.Hu == 0 && this.hh == null)) {
                if (this.hh == null) {
                    this.hh = this.mContext.getResources().getDrawable(this.Hu);
                }
                if (this.hh != null) {
                    imageView.setImageDrawable(this.hh);
                }
            }
            if (this.hh == null) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
        if (this.tDv) {
            n(view, isEnabled());
        }
    }

    private void n(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                n(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.sn != null) || (charSequence != null && !charSequence.equals(this.sn))) {
            this.tDm = 0;
            this.sn = charSequence;
            notifyChanged();
        }
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
        this.tDm = i;
    }

    public CharSequence getTitle() {
        return this.sn;
    }

    public CharSequence getSummary() {
        return this.lXS;
    }

    public void setSummary(CharSequence charSequence) {
        if ((charSequence == null && this.lXS != null) || (charSequence != null && !charSequence.equals(this.lXS))) {
            this.lXS = charSequence;
            notifyChanged();
        }
    }

    public void setSummary(int i) {
        setSummary(this.mContext.getString(i));
    }

    public final void setEnabled(boolean z) {
        if (this.yr != z) {
            this.yr = z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public final boolean isEnabled() {
        return this.yr && this.tDu;
    }

    public final void setSelectable(boolean z) {
        if (this.tDp != z) {
            this.tDp = z;
            notifyChanged();
        }
    }

    public final void setKey(String str) {
        this.mKey = str;
        if (this.tDq) {
            if (!(!TextUtils.isEmpty(this.mKey))) {
                if (this.mKey == null) {
                    throw new IllegalStateException("Preference does not have a key assigned.");
                }
                this.tDq = true;
            }
        }
    }

    public final boolean callChangeListener(Object obj) {
        return this.tDj == null ? true : this.tDj.a(this, obj);
    }

    public void a(a aVar) {
        this.tDj = aVar;
    }

    public void notifyChanged() {
    }

    private void notifyDependencyChange(boolean z) {
        List list = this.tDz;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Preference preference = (Preference) list.get(i);
                if (preference.tDu == z) {
                    boolean z2;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    preference.tDu = z2;
                    preference.notifyDependencyChange(preference.shouldDisableDependents());
                    preference.notifyChanged();
                }
            }
        }
    }

    private boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        title = getSummary();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
