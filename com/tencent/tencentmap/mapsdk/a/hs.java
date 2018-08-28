package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseBooleanArray;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.b;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

public class hs {
    public HashMap<Integer, GLIcon> a;
    public HashMap<Integer, GLIcon> b;
    private gy c;
    private hq d;
    private CopyOnWriteArrayList<Integer> e = new CopyOnWriteArrayList();
    private SparseBooleanArray f = new SparseBooleanArray();
    private ArrayList<Integer> g = new ArrayList();

    hs(gy gyVar, b bVar, hq hqVar) {
        this.c = gyVar;
        this.d = hqVar;
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public void a(GeoPoint geoPoint, GLIcon gLIcon, boolean z, int i, boolean z2, boolean z3, int i2) {
        float rotateAngle = z3 ? 360.0f - gLIcon.getRotateAngle() : gLIcon.getRotateAngle();
        if (this.a.containsKey(Integer.valueOf(gLIcon.mDisplayId))) {
            if (gLIcon.isDirty()) {
                this.d.a(gLIcon.mDisplayId, gLIcon.getIconName(), gLIcon.mPositionX, gLIcon.mPositionY, gLIcon.getAnchroX(), gLIcon.getAnchorY(), gLIcon.getScaleX(), gLIcon.getScaleY(), gLIcon.getAlpha(), rotateAngle, z, gLIcon.isFixPos(), gLIcon.isFastLoad(), gLIcon.isAvoidAnno(), i2);
                if (gLIcon.isIconChanged()) {
                    com.tencent.map.lib.util.b.a(gLIcon.getIconName(), gLIcon.getTextureBm(0));
                    com.tencent.map.lib.util.b.b(gLIcon.getLastName());
                    gLIcon.setIconChanged(false);
                }
            }
            this.b.put(Integer.valueOf(gLIcon.mDisplayId), gLIcon);
            return;
        }
        gLIcon.mDisplayId = this.d.a(gLIcon.getIconName(), gLIcon.mPositionX, gLIcon.mPositionY, gLIcon.getAnchroX(), gLIcon.getAnchorY(), gLIcon.getScaleX(), gLIcon.getScaleY(), gLIcon.getAlpha(), rotateAngle, z, gLIcon.isFixPos(), gLIcon.isFastLoad(), gLIcon.isAvoidAnno(), i2);
        com.tencent.map.lib.util.b.a(gLIcon.getIconName(), gLIcon.getTextureBm(0));
        gLIcon.setIconChanged(false);
        gLIcon.setDirty(false);
        this.b.put(Integer.valueOf(gLIcon.mDisplayId), gLIcon);
    }

    public void a() {
        e();
        f();
    }

    private void e() {
        List arrayList = new ArrayList();
        for (Entry entry : this.a.entrySet()) {
            Object key = entry.getKey();
            GLIcon gLIcon = (GLIcon) entry.getValue();
            if (!this.b.containsKey(key)) {
                arrayList.add(Integer.valueOf(((Integer) key).intValue()));
                com.tencent.map.lib.util.b.b(gLIcon.getIconName());
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = ((Integer) arrayList.get(i)).intValue();
            }
            this.d.a(iArr, size);
        }
    }

    private void f() {
        this.a.clear();
        this.a.putAll(this.b);
        this.b.clear();
    }

    public static Bitmap a(String str) {
        return com.tencent.map.lib.util.b.a(str);
    }

    public gy b() {
        return this.c;
    }

    private int b(iq iqVar) {
        if (!(!(this.c instanceof hv) || iqVar == null || iqVar.l())) {
            Context l = ((hv) this.c).l();
            iqVar.a(SystemUtil.getDensity(l) * iqVar.n());
        }
        int a = this.c.f().a(iqVar);
        iqVar.b(a);
        if (!this.e.contains(Integer.valueOf(a))) {
            this.e.add(Integer.valueOf(a));
            this.f.append(a, iqVar.l());
        }
        return a;
    }

    public void a(int i) {
        this.c.f().a(i, this.f.get(i));
        this.f.delete(i);
        this.e.remove(Integer.valueOf(i));
    }

    public void a(iq iqVar) {
        if (!this.e.contains(Integer.valueOf(iqVar.r()))) {
            iqVar.a(b(iqVar));
            this.d.c(iqVar);
        }
        if (!this.g.contains(Integer.valueOf(iqVar.r()))) {
            this.g.add(Integer.valueOf(iqVar.r()));
        }
        this.d.b(iqVar);
        this.d.d(iqVar);
        if (iqVar.s()) {
            this.d.h(iqVar);
        } else {
            this.d.g(iqVar);
        }
        this.d.f(iqVar);
        if (!StringUtil.isEmpty(iqVar.u())) {
            this.d.e(iqVar);
        }
        this.d.i(iqVar);
    }

    protected void c() {
        if (this.e != null && this.e.size() > 0) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (!this.g.contains(Integer.valueOf(intValue))) {
                    a(intValue);
                }
            }
            this.g.clear();
        }
    }

    public float d() {
        return this.c.a().l();
    }
}
