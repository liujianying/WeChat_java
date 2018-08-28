package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.bw.a$f;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.bw.a.e;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.ui.ao;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends BaseAdapter implements a {
    private final Context context;
    private final SharedPreferences duR;
    private final LinkedList<String> tCU = new LinkedList();
    private final HashMap<String, Preference> tCV = new HashMap();
    private final HashSet<String> tCW = new HashSet();
    private final LinkedList<String> tCX = new LinkedList();
    private final HashMap<String, Integer> tCY = new HashMap();
    private final HashMap<String, String> tCZ = new HashMap();
    private int[] tDa = new int[0];
    boolean tDb = false;
    private boolean tDc = false;
    final c vzB;
    OnPreferenceChangeListener vzC;

    public b(Context context, SharedPreferences sharedPreferences) {
        this.vzB = new c(context);
        this.context = context;
        this.duR = sharedPreferences;
    }

    private static String b(Preference preference) {
        return preference.getClass().getName() + "L" + preference.getLayoutResource() + "W" + preference.getWidgetLayoutResource();
    }

    private static boolean Ez(int i) {
        return i == g.mm_preference || i == g.mm_preference_summary_below || i == g.mm_preference_summary_checkbox;
    }

    private static void a(Preference preference, SharedPreferences sharedPreferences) {
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.isPersistent()) {
                checkBoxPreference.qpJ = sharedPreferences.getBoolean(preference.getKey(), ((CheckBoxPreference) preference).isChecked());
            }
        }
    }

    public final void a(Preference preference) {
        a(preference, -1);
        if (!this.tDb) {
            notifyDataSetChanged();
        }
    }

    private void a(Preference preference, int i) {
        Object key = (preference.getKey() == null || preference.getKey().length() <= 0) ? "_anonymous_pref@" + preference.hashCode() : preference.getKey();
        this.tCV.put(key, preference);
        LinkedList linkedList = this.tCU;
        if (i == -1) {
            i = this.tCU.size();
        }
        linkedList.add(i, key);
        if (!(this.tCY.containsKey(b(preference)) || this.tDc)) {
            this.tCY.put(b(preference), Integer.valueOf(this.tCY.size()));
        }
        if (preference.getDependency() != null) {
            this.tCZ.put(preference.getDependency() + "|" + preference.getKey(), preference.getKey());
        }
    }

    private void csn() {
        Collection hashSet = new HashSet();
        for (int i = 0; i < this.tCX.size(); i++) {
            this.tCV.get(this.tCX.get(i));
            if (i != 0) {
                this.tCV.get(this.tCX.get(i - 1));
            }
        }
        this.tCX.removeAll(hashSet);
    }

    public final void notifyDataSetChanged() {
        int i = 0;
        this.tCX.clear();
        Iterator it = this.tCU.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.tCW.contains(str)) {
                if (this.tCV.get(str) == null) {
                    ao.v("not found pref by key " + str, new Object[0]);
                } else {
                    this.tCX.add(str);
                }
            }
        }
        if (!this.tCX.isEmpty() && Ez(((Preference) this.tCV.get(this.tCX.get(0))).getLayoutResource())) {
            a(new PreferenceSmallCategory(this.context), 0);
        }
        csn();
        this.tDa = new int[this.tCX.size()];
        if (this.tDa.length > 0) {
            Preference preference;
            int[] iArr;
            if (this.tDa.length == 1) {
                preference = (Preference) this.tCV.get(this.tCX.get(0));
                if (!Ez(((Preference) this.tCV.get(this.tCX.get(0))).getLayoutResource())) {
                    this.tDa[0] = 4;
                } else if (preference instanceof CheckBoxPreference) {
                    iArr = this.tDa;
                    iArr[0] = iArr[0] | 8;
                } else {
                    this.tDa[0] = 3;
                }
                a((Preference) this.tCV.get(this.tCX.get(0)), this.duR);
                super.notifyDataSetChanged();
                return;
            }
            while (i < this.tCX.size()) {
                a((Preference) this.tCV.get(this.tCX.get(i)), this.duR);
                preference = (Preference) this.tCV.get(this.tCX.get(i));
                int layoutResource = preference.getLayoutResource();
                int layoutResource2;
                if (Ez(layoutResource)) {
                    if (preference instanceof CheckBoxPreference) {
                        iArr = this.tDa;
                        iArr[i] = iArr[i] | 8;
                    } else if (i == 0) {
                        iArr = this.tDa;
                        iArr[i] = iArr[i] | 1;
                    } else {
                        if (i == this.tCX.size() - 1) {
                            iArr = this.tDa;
                            iArr[i] = iArr[i] | 2;
                        }
                        layoutResource2 = ((Preference) this.tCV.get(this.tCX.get(i - 1))).getLayoutResource();
                        if (layoutResource2 != g.mm_preference || layoutResource2 == g.mm_preference_summary_below || layoutResource2 == g.mm_preference_summary_checkbox) {
                            iArr = this.tDa;
                            iArr[i] = iArr[i] | 1;
                        }
                    }
                } else if (layoutResource != g.mm_preference_info) {
                    iArr = this.tDa;
                    iArr[i] = iArr[i] | 4;
                    if (i != 0) {
                        layoutResource2 = ((Preference) this.tCV.get(this.tCX.get(i - 1))).getLayoutResource();
                        if (Ez(layoutResource2) || layoutResource2 == g.mm_preference_info) {
                            iArr = this.tDa;
                            layoutResource = i - 1;
                            iArr[layoutResource] = iArr[layoutResource] | 2;
                        }
                    }
                } else if (i == 0) {
                    iArr = this.tDa;
                    iArr[i] = iArr[i] | 4;
                } else {
                    iArr = this.tDa;
                    iArr[i] = iArr[i] | 16;
                    layoutResource2 = ((Preference) this.tCV.get(this.tCX.get(i - 1))).getLayoutResource();
                    if (layoutResource2 == g.mm_preference || layoutResource2 == g.mm_preference_summary_below || layoutResource2 == g.mm_preference_summary_checkbox) {
                        iArr = this.tDa;
                        layoutResource = i - 1;
                        iArr[layoutResource] = iArr[layoutResource] | 2;
                    }
                }
                i++;
            }
            super.notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.tCX.size();
    }

    public final Object getItem(int i) {
        return this.tCV.get(this.tCX.get(i));
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getViewTypeCount() {
        if (!this.tDc) {
            this.tDc = true;
        }
        return Math.max(1, this.tCY.size());
    }

    public final int getItemViewType(int i) {
        if (i > this.tCX.size()) {
            return -1;
        }
        Integer num = (Integer) this.tCY.get(b((Preference) this.tCV.get(this.tCX.get(i))));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (i <= this.tCX.size()) {
            Preference preference = (Preference) this.tCV.get(this.tCX.get(i));
            if (preference instanceof CheckBoxPreference) {
                preference.setOnPreferenceChangeListener(this.vzC);
            }
            if (!this.tCY.containsKey(b(preference))) {
                view = null;
            }
            view = preference.getView(view, viewGroup);
            int i2 = this.tDa[i];
            View findViewById = view.findViewById(a$f.content);
            if (findViewById == null) {
                ao.s("find content view error", new Object[0]);
            } else {
                View findViewById2 = view.findViewById(16908312);
                if ((i2 & 4) == 0) {
                    int i3 = 0;
                    int paddingLeft = findViewById.getPaddingLeft();
                    int paddingRight = findViewById.getPaddingRight();
                    int paddingTop = findViewById.getPaddingTop();
                    int paddingBottom = findViewById.getPaddingBottom();
                    int i4 = e.settings_line;
                    int paddingLeft2 = view.getPaddingLeft();
                    int paddingRight2 = view.getPaddingRight();
                    int paddingTop2 = view.getPaddingTop();
                    int paddingBottom2 = view.getPaddingBottom();
                    if ((i2 & 8) != 0) {
                        if (i == this.tCX.size() - 1 || (i == this.tCX.size() - 2 && (getItem(this.tCX.size() - 1) instanceof PreferenceCategory))) {
                            i4 = e.mm_trans;
                        } else if ((i2 & 2) != 0) {
                            i4 = e.mm_trans;
                        } else {
                            i4 = e.list_item_normal;
                        }
                        i2 = c.white;
                        i3 = i4;
                    } else if ((i2 & 16) != 0 || (i2 & 2) == 0) {
                        i3 = e.list_item_normal;
                        i2 = i4;
                    } else {
                        i2 = i4;
                    }
                    findViewById.setBackgroundResource(i3);
                    findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    if (findViewById2 != null) {
                        findViewById2.setBackgroundResource(i3);
                    }
                    view.setBackgroundResource(i2);
                    view.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                }
            }
        }
        return view;
    }
}
