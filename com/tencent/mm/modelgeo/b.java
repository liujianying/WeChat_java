package com.tencent.mm.modelgeo;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b implements e {
    public static String TAG = "MicroMsg.LocationAddr";
    private static b dRU;
    private c dRV = null;
    private LinkedList<c> dRW = new LinkedList();
    private HashMap<String, LinkedList<WeakReference<a>>> dRX = new HashMap();
    private at dRY = new at(1, "addr_worker");
    private boolean dRZ = true;

    public interface a {
        void b(Addr addr);
    }

    private class b implements com.tencent.mm.sdk.platformtools.at.a {
        private Addr dSa = null;

        public final boolean Kr() {
            if (b.this.dRV == null) {
                return false;
            }
            if (this.dSa == null || this.dSa.dRH == null || this.dSa.dRH.equals("")) {
                this.dSa = b.b(b.this.dRV.lat, b.this.dRV.lng, b.this.dRZ);
            }
            return true;
        }

        public final boolean Ks() {
            b.this.dRZ = true;
            b.this.a(this.dSa);
            return true;
        }
    }

    class c {
        double lat;
        double lng;
        Object tag = "";

        public c(double d, double d2, Object obj) {
            this.lat = d;
            this.lng = d2;
            this.tag = obj;
        }

        public final String toString() {
            StringBuilder append = new StringBuilder().append((int) (this.lat * 1000000.0d)).append((int) (this.lng * 1000000.0d));
            String obj = this.tag == null ? "" : ((this.tag instanceof Integer) || (this.tag instanceof Long) || (this.tag instanceof Double) || (this.tag instanceof Float) || (this.tag instanceof String)) ? this.tag : this.tag.toString();
            return append.append(obj).toString();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return ((c) obj).toString().equals(toString());
        }
    }

    private b() {
    }

    public static b Oz() {
        if (dRU == null) {
            dRU = new b();
        }
        return dRU;
    }

    public final boolean a(a aVar) {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (String str : this.dRX.keySet()) {
            linkedList = (LinkedList) this.dRX.get(str);
            b(linkedList, aVar);
            this.dRX.put(str, linkedList);
            if (linkedList == null || linkedList.size() == 0) {
                linkedList3.add(str);
            }
        }
        Iterator it = linkedList3.iterator();
        while (it.hasNext()) {
            this.dRX.remove((String) it.next());
        }
        Iterator it2 = this.dRW.iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            linkedList = (LinkedList) this.dRX.get(cVar.toString());
            if (linkedList == null || linkedList.size() == 0) {
                linkedList2.add(cVar);
                this.dRX.remove(cVar.toString());
            }
        }
        it = linkedList2.iterator();
        while (it.hasNext()) {
            this.dRW.remove((c) it.next());
        }
        x.i(TAG, "remove taskLists %d listeners size %d", new Object[]{Integer.valueOf(this.dRW.size()), Integer.valueOf(this.dRX.size())});
        return true;
    }

    private static boolean a(LinkedList<WeakReference<a>> linkedList, a aVar) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(LinkedList<WeakReference<a>> linkedList, a aVar) {
        if (linkedList == null) {
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                linkedList.remove(weakReference);
                return true;
            }
        }
        return false;
    }

    public final boolean a(double d, double d2, a aVar, Object obj) {
        c cVar;
        if (obj != null) {
            Iterator it = this.dRW.iterator();
            while (it.hasNext()) {
                cVar = (c) it.next();
                if (cVar != null && cVar.tag != null && cVar.tag.equals(obj)) {
                    this.dRW.remove(cVar);
                    break;
                }
            }
        }
        cVar = new c(d, d2, obj);
        LinkedList linkedList = (LinkedList) this.dRX.get(cVar.toString());
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        if (!a(linkedList, aVar)) {
            linkedList.add(new WeakReference(aVar));
        }
        this.dRX.put(cVar.toString(), linkedList);
        Iterator it2 = this.dRW.iterator();
        while (it2.hasNext()) {
            if (((c) it2.next()).equals(cVar)) {
                OA();
                return false;
            }
        }
        if (this.dRV != null && cVar.equals(this.dRV)) {
            return false;
        }
        this.dRW.add(cVar);
        x.i(TAG, "push task size %d listeners %d", new Object[]{Integer.valueOf(this.dRW.size()), Integer.valueOf(this.dRX.size())});
        while (this.dRW.size() > 30) {
            x.i(TAG, "force remove task");
            cVar = (c) this.dRW.removeFirst();
            if (cVar != null) {
                this.dRX.remove(cVar.toString());
            }
        }
        OA();
        return true;
    }

    public final boolean a(double d, double d2, a aVar) {
        return a(d, d2, aVar, null);
    }

    private void OA() {
        if (this.dRV == null && this.dRW != null && this.dRW.size() > 0) {
            this.dRV = (c) this.dRW.removeFirst();
            if (bi.fU(ad.getContext())) {
                this.dRY.c(new b());
                return;
            }
            g.DF().a(655, this);
            g.DF().a(new d(this.dRV.lat, this.dRV.lng), 0);
        }
    }

    private void a(Addr addr) {
        if (this.dRV != null) {
            if (addr == null) {
                addr = new Addr();
            }
            addr.tag = this.dRV.tag == null ? new Object() : this.dRV.tag;
            addr.dRS = (float) this.dRV.lat;
            addr.dRT = (float) this.dRV.lng;
            if (!bi.oW(addr.dRJ)) {
                String string = ad.getContext().getResources().getString(h.filter_city_name);
                x.d(TAG, "city %s", new Object[]{string});
                if (!bi.fU(ad.getContext()) && !bi.oW(string) && addr.dRJ.endsWith(string)) {
                    addr.dRK = addr.dRJ;
                    addr.dRJ = addr.dRJ.substring(0, addr.dRJ.length() - string.length());
                } else if (bi.fU(ad.getContext()) || bi.oW(string) || addr.dRH.indexOf(string) < 0) {
                    addr.dRK = addr.dRJ;
                } else {
                    addr.dRK = addr.dRJ + string;
                }
            }
            LinkedList linkedList = (LinkedList) this.dRX.get(this.dRV.toString());
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((a) weakReference.get()).b(addr);
                    }
                }
            }
            this.dRX.remove(this.dRV.toString());
            x.d(TAG, "postexecute2 listeners %d", new Object[]{Integer.valueOf(this.dRX.size())});
            this.dRV = null;
            OA();
            if (this.dRV == null && this.dRW.size() > 0) {
                g.DF().b(655, this);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.modelgeo.Addr b(double r14, double r16, boolean r18) {
        /*
        r4 = com.tencent.mm.sdk.platformtools.w.chP();
        r5 = new com.tencent.mm.modelgeo.Addr;
        r5.<init>();
        if (r18 == 0) goto L_0x00ab;
    L_0x000b:
        r0 = "https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false";
        r1 = 3;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Double.valueOf(r14);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Double.valueOf(r16);
        r1[r2] = r3;
        r2 = 2;
        r1[r2] = r4;
        r0 = java.lang.String.format(r0, r1);
    L_0x0026:
        r1 = TAG;
        r2 = new java.lang.StringBuilder;
        r3 = "url ";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r3 = com.tencent.mm.network.b.a(r0, r1);	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3.setConnectTimeout(r0);	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r0 = "GET";
        r3.setRequestMethod(r0);	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r0 = TAG;	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r6 = "conn ";
        r1.<init>(r6);	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r6 = r3.getResponseCode();	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r1 = r1.append(r6);	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r1 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r0 = r3.getInputStream();	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x0265, Exception -> 0x0229 }
        r0 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r2 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r2.<init>();	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
    L_0x0079:
        r6 = r0.readLine();	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        if (r6 == 0) goto L_0x00cb;
    L_0x007f:
        r2.append(r6);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        goto L_0x0079;
    L_0x0083:
        r0 = move-exception;
    L_0x0084:
        r2 = TAG;	 Catch:{ all -> 0x0154 }
        r4 = "error e";
        com.tencent.mm.sdk.platformtools.x.d(r2, r4);	 Catch:{ all -> 0x0154 }
        r2 = TAG;	 Catch:{ all -> 0x0154 }
        r4 = "exception:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0154 }
        r7 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x0154 }
        r6[r7] = r0;	 Catch:{ all -> 0x0154 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r4, r6);	 Catch:{ all -> 0x0154 }
        if (r3 == 0) goto L_0x00a5;
    L_0x00a0:
        r0 = r3.aBv;
        r0.disconnect();
    L_0x00a5:
        if (r1 == 0) goto L_0x00aa;
    L_0x00a7:
        r1.close();	 Catch:{ IOException -> 0x024e }
    L_0x00aa:
        return r5;
    L_0x00ab:
        r0 = "https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false";
        r1 = 3;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Double.valueOf(r14);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Double.valueOf(r16);
        r1[r2] = r3;
        r2 = 2;
        r3 = "zh_CN";
        r1[r2] = r3;
        r0 = java.lang.String.format(r0, r1);
        goto L_0x0026;
    L_0x00cb:
        r0 = TAG;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r7 = "sb ";
        r6.<init>(r7);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r7 = r2.toString();	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = r6.toString();	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r6);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r0 = new org.json.JSONObject;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r2 = "results";
        r0 = r0.getJSONArray(r2);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r2 = 0;
        r2 = r0.getJSONObject(r2);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = "formatted_address";
        r6 = r2.getString(r6);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r5.dRH = r6;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = 0;
        r0 = r0.getJSONObject(r6);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = "address_components";
        r6 = r0.getJSONArray(r6);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r0 = 0;
    L_0x010f:
        r7 = r6.length();	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        if (r0 >= r7) goto L_0x018d;
    L_0x0115:
        r7 = r6.getJSONObject(r0);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r8 = "long_name";
        r8 = r7.getString(r8);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        r9 = "types";
        r7 = r7.getJSONArray(r9);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        r9 = 0;
        r7 = r7.getString(r9);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        r9 = "administrative_area_level_1";
        r9 = r7.equals(r9);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        if (r9 == 0) goto L_0x013a;
    L_0x0135:
        r5.dRI = r8;	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
    L_0x0137:
        r0 = r0 + 1;
        goto L_0x010f;
    L_0x013a:
        r9 = "locality";
        r9 = r7.equals(r9);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        if (r9 == 0) goto L_0x0148;
    L_0x0143:
        r5.dRJ = r8;	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        goto L_0x0137;
    L_0x0146:
        r7 = move-exception;
        goto L_0x0137;
    L_0x0148:
        r9 = "sublocality";
        r9 = r7.equals(r9);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        if (r9 == 0) goto L_0x015d;
    L_0x0151:
        r5.dRL = r8;	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        goto L_0x0137;
    L_0x0154:
        r0 = move-exception;
        if (r3 == 0) goto L_0x015c;
    L_0x0157:
        r1 = r3.aBv;
        r1.disconnect();
    L_0x015c:
        throw r0;
    L_0x015d:
        r9 = "neighborhood";
        r9 = r7.equals(r9);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        if (r9 == 0) goto L_0x0169;
    L_0x0166:
        r5.dRM = r8;	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        goto L_0x0137;
    L_0x0169:
        r9 = "route";
        r9 = r7.equals(r9);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        if (r9 == 0) goto L_0x0175;
    L_0x0172:
        r5.dRN = r8;	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        goto L_0x0137;
    L_0x0175:
        r9 = "street_number";
        r9 = r7.equals(r9);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        if (r9 == 0) goto L_0x0181;
    L_0x017e:
        r5.dRO = r8;	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        goto L_0x0137;
    L_0x0181:
        r9 = "country";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        if (r7 == 0) goto L_0x0137;
    L_0x018a:
        r5.country = r8;	 Catch:{ Exception -> 0x0146, IOException -> 0x0083 }
        goto L_0x0137;
    L_0x018d:
        r0 = "utf-8";
        r7 = r5.dRH;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r7 = java.net.URLEncoder.encode(r7, r0);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = r6.toString();	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = java.net.URLEncoder.encode(r6, r0);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r8 = "geometry";
        r8 = r2.getJSONObject(r8);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r8 = r8.toString();	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r8 = java.net.URLEncoder.encode(r8, r0);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r9 = "place_id";
        r9 = r2.getString(r9);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r9 = java.net.URLEncoder.encode(r9, r0);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r10 = "types";
        r2 = r2.getJSONArray(r10);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r2 = java.net.URLEncoder.encode(r2, r0);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r10 = "[%f,%f]";
        r11 = 2;
        r11 = new java.lang.Object[r11];	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r12 = 0;
        r13 = java.lang.Double.valueOf(r14);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r11[r12] = r13;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r12 = 1;
        r13 = java.lang.Double.valueOf(r16);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r11[r12] = r13;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r10 = java.lang.String.format(r10, r11);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r0 = java.net.URLEncoder.encode(r10, r0);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r10 = TAG;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r11 = "google report, formattedaddr: %s, componentaddr: %s, geometry: %s, placeId: %s, types: %s, location: %s, curLanguage: %s";
        r12 = 7;
        r12 = new java.lang.Object[r12];	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r13 = 0;
        r12[r13] = r7;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r13 = 1;
        r12[r13] = r6;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r13 = 2;
        r12[r13] = r8;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r13 = 3;
        r12[r13] = r9;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r13 = 4;
        r12[r13] = r2;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r13 = 5;
        r12[r13] = r0;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r13 = 6;
        r12[r13] = r4;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        com.tencent.mm.sdk.platformtools.x.d(r10, r11, r12);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r10 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r11 = 12886; // 0x3256 float:1.8057E-41 double:6.3665E-320;
        r12 = 7;
        r12 = new java.lang.Object[r12];	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r13 = 0;
        r12[r13] = r6;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = 1;
        r12[r6] = r7;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = 2;
        r12[r6] = r8;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = 3;
        r12[r6] = r9;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r6 = 4;
        r12[r6] = r2;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r2 = 5;
        r12[r2] = r0;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r0 = 6;
        r12[r0] = r4;	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r10.h(r11, r12);	 Catch:{ IOException -> 0x0083, Exception -> 0x0263 }
        r0 = r3.aBv;
        r0.disconnect();
        goto L_0x00a5;
    L_0x0229:
        r0 = move-exception;
        r1 = r2;
    L_0x022b:
        r2 = TAG;	 Catch:{ all -> 0x0154 }
        r4 = "error Exception";
        com.tencent.mm.sdk.platformtools.x.d(r2, r4);	 Catch:{ all -> 0x0154 }
        r2 = TAG;	 Catch:{ all -> 0x0154 }
        r4 = "exception:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0154 }
        r7 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x0154 }
        r6[r7] = r0;	 Catch:{ all -> 0x0154 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r4, r6);	 Catch:{ all -> 0x0154 }
        if (r3 == 0) goto L_0x00a5;
    L_0x0247:
        r0 = r3.aBv;
        r0.disconnect();
        goto L_0x00a5;
    L_0x024e:
        r0 = move-exception;
        r1 = TAG;
        r2 = "exception:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x00aa;
    L_0x0263:
        r0 = move-exception;
        goto L_0x022b;
    L_0x0265:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelgeo.b.b(double, double, boolean):com.tencent.mm.modelgeo.Addr");
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 655) {
            Addr OE = ((d) lVar).OE();
            if (OE == null || OE.dRH == null || OE.dRH.equals("")) {
                this.dRY.c(new b());
            } else {
                a(OE);
            }
        }
    }
}
