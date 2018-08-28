package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a extends BaseAdapter {
    OnClickListener iZP;
    protected String lCT = "";
    boolean lCX = false;
    ArrayList<com.tencent.mm.plugin.nearlife.b.a> lCY = new ArrayList();
    HashSet<String> lCZ = new HashSet();
    ArrayList<LatLongData> lDa = null;
    private Map<LatLongData, bhy> lDb;
    private Map<LatLongData, Integer> lDc;
    Map<String, LatLongData> lDd;
    LatLongData lDe;
    boolean lDf = true;
    int lDg = 0;
    Context mContext;
    String mKey = "";

    public a(Context context, OnClickListener onClickListener, String str, boolean z) {
        this.mContext = context;
        this.iZP = onClickListener;
        this.mKey = str;
        this.lCX = z;
        this.lDa = new ArrayList();
        this.lDb = new HashMap();
        this.lDc = new HashMap();
        this.lDd = new HashMap();
    }

    public final void biY() {
        this.lCY.clear();
        this.lCZ.clear();
        this.lDc.clear();
        this.lDb.clear();
        this.lDd.clear();
        this.lDg = 0;
        notifyDataSetChanged();
    }

    public final void a(com.tencent.mm.plugin.nearlife.b.a aVar, int i) {
        if (!this.lCZ.contains(aVar.lCG) && i <= this.lCY.size()) {
            this.lCY.add(i, aVar);
            this.lCZ.add(aVar.lCG);
            this.lDd.put(aVar.lCG, this.lDe);
        }
    }

    public final void a(LatLongData latLongData, List<com.tencent.mm.plugin.nearlife.b.a> list) {
        x.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[]{this.mKey, Integer.valueOf(list.size())});
        for (com.tencent.mm.plugin.nearlife.b.a aVar : list) {
            if (!this.lCZ.contains(aVar.lCG)) {
                this.lCY.add(aVar);
                this.lCZ.add(aVar.lCG);
                this.lDd.put(aVar.lCG, latLongData);
            }
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.lCY.size();
    }

    /* renamed from: tU */
    public final com.tencent.mm.plugin.nearlife.b.a getItem(int i) {
        if (i < 0 || i >= this.lCY.size()) {
            return new com.tencent.mm.plugin.nearlife.b.a("", new aqq());
        }
        return (com.tencent.mm.plugin.nearlife.b.a) this.lCY.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public static String bC(List<bhz> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuffer.toString();
            }
            bhz bhz = (bhz) list.get(i2);
            if (!(bhz == null || bhz.siM == null || bhz.siM.equals("") || bhz.siM.toLowerCase().equals("null"))) {
                stringBuffer.append(bhz.siM);
                if (i2 < list.size() - 1) {
                    stringBuffer.append("·");
                }
            }
            i = i2 + 1;
        }
    }

    public final void II(String str) {
        if (str != null) {
            this.lCT = str;
        }
    }

    public final String biZ() {
        return this.lCT;
    }

    public final void G(ArrayList<LatLongData> arrayList) {
        if (arrayList != null) {
            this.lDa = arrayList;
        }
    }

    public final bhy a(LatLongData latLongData) {
        if (this.lDb.containsKey(latLongData)) {
            return (bhy) this.lDb.get(latLongData);
        }
        return null;
    }

    public final int b(LatLongData latLongData) {
        if (this.lDc.containsKey(latLongData)) {
            return ((Integer) this.lDc.get(latLongData)).intValue();
        }
        return 1;
    }

    public final boolean bja() {
        Iterator it = this.lDa.iterator();
        while (it.hasNext()) {
            if (b((LatLongData) it.next()) > 0) {
                return true;
            }
        }
        if (this.lDf) {
            return b(this.lDe) > 0;
        } else {
            return false;
        }
    }

    public final void a(LatLongData latLongData, int i, bhy bhy) {
        int i2 = 0;
        String str = "MicroMsg.BaseLifeAdapter";
        String str2 = "set flag & buf, lat:%f long:%f flag:%d len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Float.valueOf(latLongData.bSx);
        objArr[1] = Float.valueOf(latLongData.dVI);
        objArr[2] = Integer.valueOf(i);
        if (bhy != null) {
            i2 = bhy.siI;
        }
        objArr[3] = Integer.valueOf(i2);
        x.d(str, str2, objArr);
        if (this.lDa.contains(latLongData) || (this.lDe != null && this.lDe.equals(latLongData))) {
            this.lDc.put(latLongData, Integer.valueOf(i));
            this.lDb.put(latLongData, bhy);
        }
    }

    public final LatLongData IJ(String str) {
        if (this.lDd.containsKey(str)) {
            return (LatLongData) this.lDd.get(str);
        }
        return null;
    }

    public final int IK(String str) {
        Iterator it = this.lCY.iterator();
        int i = -1;
        while (it.hasNext()) {
            i++;
            if (((com.tencent.mm.plugin.nearlife.b.a) it.next()).lCG.equals(str)) {
                break;
            }
        }
        return i;
    }
}
