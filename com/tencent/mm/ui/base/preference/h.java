package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class h extends BaseAdapter implements f {
    private final Context context;
    private final SharedPreferences duR;
    private a tBK;
    private final j tCT;
    private final LinkedList<String> tCU = new LinkedList();
    private final HashMap<String, Preference> tCV = new HashMap();
    private final HashSet<String> tCW = new HashSet();
    private final LinkedList<String> tCX = new LinkedList();
    private final HashMap<String, Integer> tCY = new HashMap();
    private final HashMap<String, String> tCZ = new HashMap();
    private int[] tDa = new int[0];
    private boolean tDb = false;
    private boolean tDc = false;

    public h(Context context, SharedPreferences sharedPreferences) {
        this.tCT = new j(context);
        this.context = context;
        this.duR = sharedPreferences;
    }

    private static String d(Preference preference) {
        return preference.getClass().getName() + "L" + preference.getLayoutResource() + "W" + preference.tDx;
    }

    private static String e(Preference preference) {
        if (preference.mKey == null || preference.mKey.length() <= 0) {
            return "_anonymous_pref@" + preference.hashCode();
        }
        return preference.mKey;
    }

    public final int indexOf(String str) {
        return this.tCU.indexOf(str);
    }

    public final int aab(String str) {
        if (this.tCX == null) {
            return -1;
        }
        return this.tCX.indexOf(str);
    }

    public final void a(Preference preference) {
        a(preference, -1);
    }

    public final void b(Preference preference) {
        b(preference, -1);
    }

    public final void a(Preference preference, int i) {
        b(preference, i);
        if (!this.tDb) {
            notifyDataSetChanged();
        }
    }

    private void b(Preference preference, int i) {
        String e = e(preference);
        this.tCV.put(e, preference);
        LinkedList linkedList = this.tCU;
        if (i == -1) {
            i = this.tCU.size();
        }
        linkedList.add(i, e);
        if (!(this.tCY.containsKey(d(preference)) || this.tDc)) {
            this.tCY.put(d(preference), Integer.valueOf(this.tCY.size()));
        }
        if (preference.tDs != null) {
            this.tCZ.put(preference.tDs + "|" + preference.mKey, preference.mKey);
        }
    }

    public final Preference ZZ(String str) {
        return (Preference) this.tCV.get(str);
    }

    public final void bw(String str, boolean z) {
        if (z) {
            if (!this.tCW.contains(str)) {
                this.tCW.add(str);
            } else {
                return;
            }
        } else if (!this.tCW.remove(str)) {
            return;
        }
        notifyDataSetChanged();
    }

    public final boolean c(Preference preference) {
        if (preference == null) {
            return false;
        }
        String e = e(preference);
        this.tCU.remove(e);
        this.tCV.remove(e);
        this.tCW.remove(preference.mKey);
        notifyDataSetChanged();
        return true;
    }

    public final boolean aaa(String str) {
        return c(ZZ(str));
    }

    public final void removeAll() {
        this.tCX.clear();
        this.tCV.clear();
        this.tCU.clear();
        this.tCW.clear();
        notifyDataSetChanged();
    }

    public final void addPreferencesFromResource(int i) {
        InflateException inflateException;
        this.tDb = true;
        j jVar = this.tCT;
        Object xml = jVar.mContext.getResources().getXml(i);
        try {
            synchronized (jVar.Fn) {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                jVar.Fn[0] = jVar.mContext;
                try {
                    int next = xml.next();
                    while (next != 2 && next != 1) {
                        next = xml.next();
                    }
                    if (next != 2) {
                        throw new InflateException(xml.getPositionDescription() + ": No start tag found!");
                    }
                    jVar.a(xml.getName(), asAttributeSet);
                    jVar.a(xml, this, asAttributeSet);
                } catch (InflateException e) {
                    throw e;
                } catch (Throwable e2) {
                    inflateException = new InflateException(e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (Throwable e22) {
                    inflateException = new InflateException(xml.getPositionDescription() + ": " + e22.getMessage());
                    inflateException.initCause(e22);
                    throw inflateException;
                }
            }
            this.tDb = false;
            notifyDataSetChanged();
        } finally {
            xml.close();
        }
    }

    public final void b(a aVar) {
        this.tBK = aVar;
        notifyDataSetChanged();
    }

    private void csn() {
        Collection hashSet = new HashSet();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.tCX.size()) {
                Preference preference = (Preference) this.tCV.get(this.tCX.get(i2));
                if ((preference instanceof PreferenceCategory) && bi.oW(preference.mKey) && i2 != 0) {
                    Preference preference2 = (Preference) this.tCV.get(this.tCX.get(i2 - 1));
                    if (preference2 instanceof PreferenceCategory) {
                        if (bi.oW(preference2.mKey) && (preference2.getTitle() == null || preference2.getTitle().toString().trim().length() <= 0)) {
                            hashSet.add(e(preference2));
                        } else if (bi.oW(preference.mKey) && (preference.getTitle() == null || preference.getTitle().toString().trim().length() <= 0)) {
                            hashSet.add(e(preference));
                        }
                    }
                }
                i = i2 + 1;
            } else {
                this.tCX.removeAll(hashSet);
                return;
            }
        }
    }

    private static boolean Ez(int i) {
        return i == com.tencent.mm.w.a.h.mm_preference || i == com.tencent.mm.w.a.h.mm_preference_summary_below || i == com.tencent.mm.w.a.h.mm_preference_summary_checkbox;
    }

    public void notifyDataSetChanged() {
        int i = 0;
        this.tCX.clear();
        Iterator it = this.tCU.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.tCW.contains(str)) {
                if (this.tCV.get(str) == null) {
                    x.e("MicroMsg.MMPreferenceAdapter", "not found pref by key " + str);
                } else {
                    this.tCX.add(str);
                }
            }
        }
        if (!this.tCX.isEmpty() && Ez(((Preference) this.tCV.get(this.tCX.get(0))).getLayoutResource())) {
            b(new PreferenceSmallCategory(this.context), 0);
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
                        if (layoutResource2 != com.tencent.mm.w.a.h.mm_preference || layoutResource2 == com.tencent.mm.w.a.h.mm_preference_summary_below || layoutResource2 == com.tencent.mm.w.a.h.mm_preference_summary_checkbox) {
                            iArr = this.tDa;
                            iArr[i] = iArr[i] | 1;
                        }
                    }
                } else if (layoutResource != com.tencent.mm.w.a.h.mm_preference_info) {
                    iArr = this.tDa;
                    iArr[i] = iArr[i] | 4;
                    if (i != 0) {
                        layoutResource2 = ((Preference) this.tCV.get(this.tCX.get(i - 1))).getLayoutResource();
                        if (Ez(layoutResource2) || layoutResource2 == com.tencent.mm.w.a.h.mm_preference_info) {
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
                    if (layoutResource2 == com.tencent.mm.w.a.h.mm_preference || layoutResource2 == com.tencent.mm.w.a.h.mm_preference_summary_below || layoutResource2 == com.tencent.mm.w.a.h.mm_preference_summary_checkbox) {
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

    private static void a(Preference preference, SharedPreferences sharedPreferences) {
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.tDr) {
                checkBoxPreference.qpJ = sharedPreferences.getBoolean(preference.mKey, ((CheckBoxPreference) preference).isChecked());
            }
        }
        if (preference instanceof DialogPreference) {
            DialogPreference dialogPreference = (DialogPreference) preference;
            if (dialogPreference.tDr) {
                dialogPreference.setValue(sharedPreferences.getString(preference.mKey, null));
            }
        }
        if (preference instanceof EditPreference) {
            EditPreference editPreference = (EditPreference) preference;
            if (editPreference.tDr) {
                editPreference.value = sharedPreferences.getString(preference.mKey, null);
                editPreference.setSummary(editPreference.value);
            }
        }
    }

    public int getCount() {
        return this.tCX.size();
    }

    public Object getItem(int i) {
        return this.tCV.get(this.tCX.get(i));
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        if (!this.tDc) {
            this.tDc = true;
        }
        return Math.max(1, this.tCY.size());
    }

    public int getItemViewType(int i) {
        if (i > this.tCX.size()) {
            return -1;
        }
        Integer num = (Integer) this.tCY.get(d((Preference) this.tCV.get(this.tCX.get(i))));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i <= this.tCX.size()) {
            Preference preference = (Preference) this.tCV.get(this.tCX.get(i));
            if (preference instanceof CheckBoxPreference) {
                preference.a(this.tBK);
            }
            if (!this.tCY.containsKey(d(preference))) {
                view = null;
            }
            view = preference.getView(view, viewGroup);
            int i2 = this.tDa[i];
            View findViewById = view.findViewById(g.content);
            if (findViewById == null) {
                x.d("MicroMsg.MMPreferenceAdapter", "find content view error");
            } else {
                View findViewById2 = view.findViewById(16908312);
                if ((i2 & 4) == 0) {
                    int i3 = 0;
                    int paddingLeft = findViewById.getPaddingLeft();
                    int paddingRight = findViewById.getPaddingRight();
                    int paddingTop = findViewById.getPaddingTop();
                    int paddingBottom = findViewById.getPaddingBottom();
                    int i4 = f.settings_line;
                    int paddingLeft2 = view.getPaddingLeft();
                    int paddingRight2 = view.getPaddingRight();
                    int paddingTop2 = view.getPaddingTop();
                    int paddingBottom2 = view.getPaddingBottom();
                    if ((i2 & 8) != 0) {
                        if (i == this.tCX.size() - 1 || (i == this.tCX.size() - 2 && (getItem(this.tCX.size() - 1) instanceof PreferenceCategory))) {
                            i4 = f.mm_trans;
                        } else if ((i2 & 2) != 0) {
                            i4 = f.mm_trans;
                        } else {
                            i4 = f.list_item_normal;
                        }
                        i2 = d.white;
                        i3 = i4;
                    } else if ((i2 & 16) != 0 || (i2 & 2) == 0) {
                        i3 = f.list_item_normal;
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
