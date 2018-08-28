package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class h$a extends BaseAdapter {
    final /* synthetic */ h kFD;
    ArrayList<h$b> kFF = new ArrayList();

    public h$a(h hVar, ArrayList<h$b> arrayList) {
        this.kFD = hVar;
        this.kFF.addAll(arrayList);
    }

    public final int getCount() {
        return this.kFF.size();
    }

    public final Object getItem(int i) {
        return this.kFF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return ((h$b) this.kFF.get(i)).kFH.kFI;
    }

    public final h$b FR(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.kFF.size()) {
                return null;
            }
            if (((h$b) this.kFF.get(i2)).username.equals(str)) {
                return (h$b) this.kFF.get(i2);
            }
            i = i2 + 1;
        }
    }

    public final boolean FS(String str) {
        for (int i = 0; i < this.kFF.size(); i++) {
            if (((h$b) this.kFF.get(i)).username.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final ArrayList<String> aZC() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.kFF.iterator();
        while (it.hasNext()) {
            arrayList.add(((h$b) it.next()).username);
        }
        return arrayList;
    }
}
