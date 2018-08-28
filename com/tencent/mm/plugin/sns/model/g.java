package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.al.b;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.y;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g implements f {
    private static int nnq = 0;
    private Map<Integer, WeakReference<Object>> dUu = new HashMap();
    public boolean nmG = true;
    private long nmT = 0;
    private long nmU = 0;
    aa<String, n> nmV;
    private al<String, WeakReference<Bitmap>> nmW;
    private Map<String, LinkedList<WeakReference<c>>> nmX = new HashMap();
    private ConcurrentHashMap<Integer, String> nmY = new ConcurrentHashMap();
    private LinkedList<b> nmZ = new LinkedList();
    private boolean nna = false;
    private HashSet<c> nnb = new HashSet();
    public HashMap<String, Integer> nnc = new HashMap();
    private int nnd = 4;
    public y nne;
    public long nnf = 0;
    public long nng = 0;
    private int nnh = 0;
    private int nni = 0;
    private HashMap<Long, Integer> nnj = new HashMap();
    private HashMap<Integer, Boolean> nnk = new HashMap();
    private HashMap<Integer, Boolean> nnl = new HashMap();
    private int nnm = 0;
    private int nnn = 0;
    private HashMap<Long, Integer> nno = new HashMap();
    protected Set<String> nnp = new HashSet();

    /* renamed from: com.tencent.mm.plugin.sns.model.g$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int nns = 0;
        final /* synthetic */ String nnt;
        final /* synthetic */ n nnu;

        AnonymousClass2(String str, n nVar) {
            this.nnt = str;
            this.nnu = nVar;
        }

        public final void run() {
            g.this.a(this.nns + "-" + this.nnt, this.nnu);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.g$9 */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ ate nmM;

        AnonymousClass9(ate ate) {
            this.nmM = ate;
        }

        public final void run() {
            g.a(g.this, 1, this.nmM);
        }
    }

    public enum a {
        ;

        static {
            nnA = 1;
            nnB = 2;
            nnC = new int[]{nnA, nnB};
        }
    }

    static /* synthetic */ int bxE() {
        int i = nnq;
        nnq = i + 1;
        return i;
    }

    static /* synthetic */ int bxG() {
        int i = nnq;
        nnq = i - 1;
        return i;
    }

    public final void start() {
        this.nmG = true;
        bxD();
        b byj = af.byj();
        byj.nmG = true;
        byj.OI();
    }

    public final void pause() {
        this.nmG = false;
        b byj = af.byj();
        byj.nmG = false;
        LinkedList linkedList = new LinkedList();
        Iterator it = byj.dav.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.sns.data.f fVar = (com.tencent.mm.plugin.sns.data.f) it.next();
            if (fVar.requestType != 6) {
                byj.nmJ.remove(fVar.aAL);
                linkedList.add(fVar);
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            byj.dav.remove((com.tencent.mm.plugin.sns.data.f) it2.next());
        }
    }

    public g() {
        int i;
        x.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[]{Integer.valueOf(((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass())});
        if (((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass() > GLIcon.TOP) {
            i = 10485760;
        } else {
            i = 5242880;
        }
        this.nmV = new 1(this, i);
        this.nmW = new al(this.nnd, new 3(this));
    }

    public final void bxC() {
        if (this.nmV != null) {
            this.dUu.clear();
            this.nmW.nrg.clear();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("mMemoryCache \n");
            stringBuffer.append("putCount:" + this.nmV.putCount() + ";");
            stringBuffer.append("missCount:" + this.nmV.missCount() + ";");
            stringBuffer.append("hitCount:" + this.nmV.hitCount() + ";");
            stringBuffer.append("createCount:" + this.nmV.createCount() + ";");
            stringBuffer.append("evictionCount:" + this.nmV.evictionCount() + ";");
            x.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
            this.nmV.trimToSize(-1);
        }
        this.nmW.byK();
        System.gc();
    }

    public final Bitmap a(ate ate, View view, int i, av avVar, boolean z) {
        return a(ate, view, i, true, avVar, z);
    }

    private boolean G(View view, int i) {
        if (view.hashCode() == i) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (childCount >= 0) {
                }
            } while (!G(viewGroup.getChildAt(childCount), i));
            return true;
        }
        return false;
    }

    public final void H(Activity activity) {
        c cVar;
        x.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.dUu.size());
        List<Integer> linkedList = new LinkedList();
        Iterator it = this.nnb.iterator();
        while (it.hasNext()) {
            cVar = (c) it.next();
            if (G(activity.getWindow().getDecorView(), cVar.code)) {
                linkedList.add(Integer.valueOf(cVar.code));
            }
        }
        for (Integer intValue : linkedList) {
            int intValue2 = intValue.intValue();
            this.dUu.remove(Integer.valueOf(intValue2));
            Iterator it2 = this.nnb.iterator();
            while (it2.hasNext()) {
                cVar = (c) it2.next();
                if (cVar.code == intValue2) {
                    this.nnb.remove(cVar);
                    break;
                }
            }
        }
        linkedList.clear();
        it = this.nnb.iterator();
        while (it.hasNext()) {
            cVar = (c) it.next();
            if (cVar.nnE == activity.hashCode()) {
                linkedList.add(Integer.valueOf(cVar.code));
            }
        }
        for (Integer intValue3 : linkedList) {
            int intValue4 = intValue3.intValue();
            this.dUu.remove(Integer.valueOf(intValue4));
            Iterator it3 = this.nnb.iterator();
            while (it3.hasNext()) {
                cVar = (c) it3.next();
                if (cVar.code == intValue4) {
                    this.nnb.remove(cVar);
                    break;
                }
            }
        }
        this.nmW.byK();
        x.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.dUu.size());
    }

    public final void cx(View view) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        } else if (view instanceof QImageView) {
            ((QImageView) view).setImageBitmap(null);
        }
    }

    public final Bitmap b(ate ate) {
        if (ate == null || ate.ksA == null || ate.ksA.equals("")) {
            return null;
        }
        String aE = i.aE(1, ate.ksA);
        String str = ate.ksA;
        n LY = LY(aE);
        if (i.b(LY)) {
            return LY.Fw();
        }
        str = an.s(af.getAccSnsPath(), ate.ksA);
        str = str + i.e(ate);
        if (!FileOp.cn(str)) {
            return null;
        }
        if (ate.ksA.startsWith("pre_temp_extend_pic")) {
            LY = n.m(s.NC(str));
        } else {
            LY = i.LJ(str);
        }
        if (!i.b(LY)) {
            return null;
        }
        a(aE, LY);
        return LY.Fw();
    }

    public final String a(ate ate) {
        String s = an.s(af.getAccSnsPath(), ate.ksA);
        return s + i.e(ate);
    }

    public final void b(ate ate, View view, int i, av avVar) {
        b(ate, view, -1, i, avVar);
    }

    public final void a(ate ate, View view, int i, int i2, av avVar) {
        a(ate, view, -1, i, i2, avVar);
    }

    public final n LY(String str) {
        n nVar = (n) this.nmV.get(str);
        if (nVar != null && !nVar.isRecycled()) {
            return nVar;
        }
        this.nmV.remove(str);
        return null;
    }

    public final void b(ate ate, View view, int i, int i2, av avVar) {
        a(ate, view, i, i2, a.nnA, avVar);
    }

    public final void a(ate ate, View view, int i, int i2, int i3, av avVar) {
        if (ate != null && ate.ksA != null && !ate.ksA.equals("")) {
            view.setDrawingCacheEnabled(false);
            String aE = i.aE(0, ate.ksA);
            a((Object) view, aE, i, i2, i3);
            String str = ate.ksA;
            n LY = LY(aE);
            if (i.b(LY)) {
                a((Object) view, aE, LY);
                return;
            }
            if (i == -1) {
                cy(view);
            }
            if (!this.nnp.contains(aE)) {
                a(0, ate, avVar);
            }
        }
    }

    private static void a(Object obj, String str, n nVar) {
        long j = 0;
        if (obj != null) {
            if (nVar != null) {
                x.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[]{obj, str, nVar.FA()});
            }
            Drawable drawable;
            if (obj instanceof QFadeImageView) {
                long j2;
                QFadeImageView qFadeImageView = (QFadeImageView) obj;
                drawable = qFadeImageView.getDrawable();
                if (!bi.oW(qFadeImageView.getImageKey()) && qFadeImageView.getImageKey().equals(str)) {
                    j = qFadeImageView.getStartTimeMillis();
                }
                if (drawable == null || !(drawable instanceof ai)) {
                    j2 = j;
                } else {
                    j2 = ((ai) drawable).jEK;
                }
                ai aiVar = new ai(str, nVar, j2);
                qFadeImageView.jEK = aiVar.jEK;
                qFadeImageView.aAL = str;
                qFadeImageView.setImageDrawable(aiVar);
                aiVar.invalidateSelf();
            } else if (obj instanceof QDisFadeImageView) {
                QDisFadeImageView qDisFadeImageView = (QDisFadeImageView) obj;
                com.tencent.mm.memory.a.a aVar = new com.tencent.mm.memory.a.a(str, nVar);
                qDisFadeImageView.setImageDrawable(aVar);
                aVar.invalidateSelf();
            } else if (obj instanceof ImageView) {
                ImageView imageView = (ImageView) obj;
                drawable = imageView.getDrawable();
                if (drawable == null || !(drawable instanceof ai)) {
                    drawable = new ai(str, nVar, 0);
                } else {
                    drawable = new ai(str, nVar, ((ai) drawable).jEK);
                }
                imageView.setImageDrawable(drawable);
                drawable.invalidateSelf();
            } else if (obj instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                x.i("MicroMsg.LazyerImageLoader2", "update sight thumb " + str);
                if (obj instanceof SightPlayImageView) {
                    SightPlayImageView sightPlayImageView = (SightPlayImageView) obj;
                    drawable = sightPlayImageView.getDrawable();
                    if (drawable == null || !(drawable instanceof ai)) {
                        drawable = new ai(str, nVar, 0);
                    } else {
                        drawable = new ai(str, nVar, ((ai) drawable).jEK);
                    }
                    sightPlayImageView.setImageDrawable(drawable);
                    drawable.invalidateSelf();
                }
            }
        }
    }

    public static String r(ate ate) {
        if (ate == null || ate.ksA == null || ate.ksA.equals("")) {
            return null;
        }
        String str = an.s(af.getAccSnsPath(), ate.ksA) + i.e(ate);
        if (FileOp.cn(str)) {
            return str;
        }
        return ate.rVE;
    }

    public static String s(ate ate) {
        if (ate == null || ate.ksA == null || ate.ksA.equals("")) {
            return null;
        }
        String str = an.s(af.getAccSnsPath(), ate.ksA) + i.d(ate);
        if (FileOp.cn(str)) {
            return str;
        }
        return ate.jPK;
    }

    public final void a(ate ate, View view, int i, av avVar) {
        c(ate, view, -1, i, avVar);
    }

    public final boolean a(com.tencent.mm.plugin.sns.storage.n nVar, ate ate, com.tencent.mm.plugin.sight.decode.a.a aVar, int i, int i2, av avVar, boolean z) {
        return a(nVar, ate, aVar, i, i2, avVar, z, false);
    }

    public final boolean a(com.tencent.mm.plugin.sns.storage.n nVar, final ate ate, com.tencent.mm.plugin.sight.decode.a.a aVar, int i, int i2, final av avVar, boolean z, boolean z2) {
        if (ate == null || ate.ksA == null || ate.ksA.equals("")) {
            return false;
        }
        String aE = i.aE(1, ate.ksA);
        a((Object) aVar, aE, -1, i);
        String s = an.s(af.getAccSnsPath(), ate.ksA);
        String e = i.e(ate);
        if (!FileOp.cn(s + e)) {
            e eVar = new e(ate);
            eVar.nkQ = 1;
            eVar.kJG = ate.ksA;
            af.byj().a(ate, ate.hcE == 6 ? 5 : 1, eVar, avVar);
        }
        String str = "";
        if (z) {
            if (!u(ate)) {
                str = an.s(af.getAccSnsPath(), ate.ksA);
                String j = i.j(ate);
                if (FileOp.cn(str + j)) {
                    str = str + j;
                } else if (FileOp.cn(str + i.p(ate)) && ate.ksA != null && ate.ksA.startsWith("Locall_path")) {
                    str = str + i.p(ate);
                } else if (this.nmG) {
                    x.i("MicroMsg.LazyerImageLoader2", "push sight loader " + ate.ksA + " url: " + ate.jPK);
                    if (!z) {
                        x.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
                    } else if (b(nVar, null) == 5) {
                        af.aRu().postDelayed(new Runnable() {
                            public final void run() {
                                af.byj().a(ate, 4, null, avVar);
                            }
                        }, 0);
                    }
                }
            }
            str = "";
        }
        x.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[]{aE, str, Boolean.valueOf(z)});
        if (bi.oW(str) || u(ate)) {
            x.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[]{str});
            aVar.aO(null, !this.nmG);
            str = ate.ksA;
            n LY = LY(aE);
            x.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[]{Boolean.valueOf(i.b(LY))});
            if (i.b(LY)) {
                a((Object) aVar, aE, LY);
                return true;
            }
            if ((aVar instanceof ImageView) || (aVar instanceof QFadeImageView)) {
                cy((View) aVar);
            } else if (aVar instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                aVar.aO(null, !this.nmG);
                aVar.setPosition(0);
                aVar.setThumbBmp(null);
            }
            if (this.nnp.contains(aE)) {
                return false;
            }
            a(1, ate, avVar);
            return false;
        }
        if (!str.equals(aVar.getVideoPath())) {
            aVar.setThumbBmp(z2 ? BitmapFactory.decodeFile(s + e) : null);
        }
        aVar.aO(str, !this.nmG);
        aVar.setPosition(i2);
        return true;
    }

    public final void c(ate ate, View view, int i, av avVar) {
        if (ate != null && ate.ksA != null && !ate.ksA.equals("")) {
            String aE = i.aE(4, ate.ksA);
            a((Object) view, aE, -1, i);
            String str = ate.ksA;
            n LY = LY(aE);
            boolean b = i.b(LY);
            x.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + b);
            if (b) {
                a((Object) view, aE, LY);
                return;
            }
            cy(view);
            if (!this.nnp.contains(aE)) {
                a(4, ate, avVar);
            }
        }
    }

    public final boolean c(ate ate, View view, int i, int i2, av avVar) {
        return a(ate, view, i, i2, avVar, 1);
    }

    public final boolean a(ate ate, View view, int i, int i2, av avVar, int i3) {
        if (ate == null || ate.ksA == null || ate.ksA.equals("")) {
            return false;
        }
        String aE = i.aE(i3, ate.ksA);
        a((Object) view, aE, i, i2);
        String str = ate.ksA;
        n LY = LY(aE);
        boolean b = i.b(LY);
        x.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + b + aE);
        if (b) {
            a((Object) view, aE, LY);
            return true;
        }
        if (i == -1) {
            cy(view);
        }
        if (this.nnp.contains(aE)) {
            return true;
        }
        a(i3, ate, avVar);
        return false;
    }

    private static void cy(View view) {
        if (view instanceof QImageView) {
            ((QImageView) view).setScaleType(com.tencent.mm.ui.widget.QImageView.a.uHM);
            ((QImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_detail_list2);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_detail_list2);
        }
    }

    public final void a(Object obj, String str, int i, int i2) {
        a(obj, str, true, i, i2, -1, -1, a.nnA);
    }

    private void a(Object obj, String str, int i, int i2, int i3) {
        a(obj, str, true, i, i2, -1, -1, i3);
    }

    private void a(Object obj, String str, boolean z, int i, int i2, int i3, int i4, int i5) {
        if (obj != null) {
            int hashCode = obj.hashCode();
            this.nnb.remove(new c(null, hashCode, 0, false));
            c cVar = new c(str, hashCode, i2, z);
            this.nnb.add(cVar);
            LinkedList linkedList = (LinkedList) this.nmX.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.nmX.put(str, linkedList);
            }
            linkedList.add(new WeakReference(cVar));
            String str2 = (String) ((View) obj).getTag(2130706432);
            if (str2 != null) {
                LinkedList linkedList2 = (LinkedList) this.nmX.get(str2);
                if (linkedList2 != null) {
                    int i6;
                    int i7 = 0;
                    while (true) {
                        i6 = i7;
                        if (i6 >= linkedList2.size()) {
                            i6 = -1;
                            break;
                        }
                        c cVar2 = (c) ((WeakReference) linkedList2.get(i6)).get();
                        if (cVar2 != null && cVar2.code == hashCode) {
                            break;
                        }
                        i7 = i6 + 1;
                    }
                    if (i6 != -1) {
                        x.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[]{str2});
                        linkedList2.remove(i6);
                    }
                }
            }
            ((View) obj).setTag(2130706432, str);
            this.dUu.put(Integer.valueOf(hashCode), new WeakReference(obj));
            if (i != -1) {
                if (obj instanceof QFadeImageView) {
                    ((QFadeImageView) obj).setImageResource(i);
                } else if (obj instanceof ImageView) {
                    ((ImageView) obj).setImageDrawable(com.tencent.mm.bp.a.f(((ImageView) obj).getContext(), i));
                } else {
                    ((com.tencent.mm.plugin.sight.decode.a.a) obj).aO(null, !this.nmG);
                }
            }
            if (i5 == a.nnB && ((obj instanceof ImageView) || (obj instanceof QFadeImageView))) {
                k.bD((View) obj);
            } else if (str != null && str.startsWith("3")) {
                if ((obj instanceof ImageView) || (obj instanceof QFadeImageView)) {
                    k.k((View) obj, i3, i4);
                    x.d("MicroMsg.LazyerImageLoader2", "try to setlayerType " + i3 + " " + i4);
                }
            }
        }
    }

    public final boolean cz(View view) {
        int hashCode = view.hashCode();
        Iterator it = this.nnb.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (hashCode == cVar.code) {
                this.nnb.remove(cVar);
                break;
            }
        }
        this.dUu.remove(Integer.valueOf(hashCode));
        return true;
    }

    private boolean bxD() {
        if (this.nna) {
            x.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
            return false;
        }
        af.aRu().postDelayed(new 5(this), 0);
        return true;
    }

    private boolean a(final int i, final ate ate, final av avVar) {
        if (!this.nmG) {
            return false;
        }
        af.byb().post(new Runnable() {
            public final void run() {
                if (!g.a(g.this, i, ate)) {
                    e eVar = new e(ate);
                    eVar.nkQ = i;
                    eVar.kJG = ate.ksA;
                    af.byj().a(ate, ate.hcE == 6 ? 5 : 1, eVar, avVar);
                }
            }
        });
        return true;
    }

    public static boolean t(ate ate) {
        String s = an.s(af.getAccSnsPath(), ate.ksA);
        if (FileOp.cn(s + i.j(ate))) {
            return true;
        }
        if (FileOp.cn(s + i.p(ate)) && !bi.oW(ate.ksA) && ate.ksA.startsWith("Locall_path")) {
            return true;
        }
        return false;
    }

    public final int k(com.tencent.mm.plugin.sns.storage.n nVar) {
        return a(nVar, null);
    }

    public final int a(com.tencent.mm.plugin.sns.storage.n nVar, int[] iArr) {
        int i;
        int i2 = 5;
        if (iArr != null || bi.bI(this.nnf) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            c.NM();
            if (c.a(pInt, pInt2, pInt3)) {
                this.nnh = 5;
            } else {
                this.nnh = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
                iArr[2] = pInt3.value;
            }
            this.nni = pInt.value;
            this.nnf = bi.VG();
        }
        if (this.nni == 0 || nVar == null) {
            return this.nnh;
        }
        if (this.nnj.containsKey(Long.valueOf(nVar.field_snsId))) {
            return ((Integer) this.nnj.get(Long.valueOf(nVar.field_snsId))).intValue();
        }
        bpg bpg = new bpg();
        try {
            boy boy = (boy) new boy().aG(nVar.field_attrBuf);
            if (boy.smY == null) {
                return this.nnh;
            }
            bpg.aG(boy.smY.siK.lR);
            if (bpg.snn == null || bpg.snn.info == null) {
                return this.nnh;
            }
            String str = bpg.snn.info;
            int hashCode = str.hashCode();
            if (this.nni == 1) {
                if (!this.nnl.containsKey(Integer.valueOf(hashCode))) {
                    this.nnl.put(Integer.valueOf(hashCode), Boolean.valueOf(bZ(str, this.nni)));
                }
                i = ((Boolean) this.nnl.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
            } else {
                if (!this.nnk.containsKey(Integer.valueOf(hashCode))) {
                    this.nnk.put(Integer.valueOf(hashCode), Boolean.valueOf(bZ(str, this.nni)));
                }
                if (!((Boolean) this.nnk.get(Integer.valueOf(hashCode))).booleanValue()) {
                    i2 = 10;
                }
                i = i2;
            }
            x.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[]{Long.valueOf(nVar.field_snsId), Integer.valueOf(i)});
            this.nnj.put(Long.valueOf(nVar.field_snsId), Integer.valueOf(i));
            return i;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
            return this.nnh;
        }
    }

    public final int l(com.tencent.mm.plugin.sns.storage.n nVar) {
        return b(nVar, null);
    }

    public final int b(com.tencent.mm.plugin.sns.storage.n nVar, int[] iArr) {
        int i;
        int i2 = 5;
        if (iArr != null || bi.bI(this.nng) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            c.NM();
            if (c.a(pInt, pInt2)) {
                this.nnm = 5;
            } else {
                this.nnm = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
            }
            this.nnn = pInt.value;
            this.nng = bi.VG();
        }
        if (this.nnn == 0 || nVar == null) {
            return this.nnm;
        }
        if (this.nno.containsKey(Long.valueOf(nVar.field_snsId))) {
            return ((Integer) this.nno.get(Long.valueOf(nVar.field_snsId))).intValue();
        }
        bpg bpg = new bpg();
        try {
            boy boy = (boy) new boy().aG(nVar.field_attrBuf);
            if (boy.smY == null) {
                return this.nnm;
            }
            bpg.aG(boy.smY.siK.lR);
            if (bpg.snn == null || bpg.snn.info == null) {
                return this.nnh;
            }
            String str = bpg.snn.info;
            int hashCode = str.hashCode();
            if (this.nnn == 1) {
                if (!this.nnl.containsKey(Integer.valueOf(hashCode))) {
                    this.nnl.put(Integer.valueOf(hashCode), Boolean.valueOf(bZ(str, this.nnn)));
                }
                i = ((Boolean) this.nnl.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
            } else {
                if (!this.nnk.containsKey(Integer.valueOf(hashCode))) {
                    this.nnk.put(Integer.valueOf(hashCode), Boolean.valueOf(bZ(str, this.nnn)));
                }
                if (!((Boolean) this.nnk.get(Integer.valueOf(hashCode))).booleanValue()) {
                    i2 = 10;
                }
                i = i2;
            }
            x.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[]{Long.valueOf(nVar.field_snsId), Integer.valueOf(i)});
            this.nno.put(Long.valueOf(nVar.field_snsId), Integer.valueOf(i));
            return i;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
            return this.nnm;
        }
    }

    private static boolean bZ(String str, int i) {
        Map z = bl.z(str, "SightDownloadControl");
        if (z == null || z.isEmpty()) {
            return true;
        }
        return i == 1 ? bi.getInt((String) z.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1 : bi.getInt((String) z.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1;
    }

    public final boolean u(ate ate) {
        if (!this.nnc.containsKey(ate.ksA)) {
            return false;
        }
        if (((Integer) this.nnc.get(ate.ksA)).intValue() == 1) {
            return true;
        }
        return false;
    }

    public final boolean v(ate ate) {
        if (this.nnc.containsKey(ate.ksA)) {
            return ((Integer) this.nnc.get(ate.ksA)).intValue() == 2;
        } else {
            return false;
        }
    }

    public final boolean w(ate ate) {
        if (this.nnc.containsKey(ate.ksA)) {
            return ((Integer) this.nnc.get(ate.ksA)).intValue() == 3;
        } else {
            return false;
        }
    }

    public final boolean x(ate ate) {
        if (this.nnc.containsKey(ate.ksA)) {
            return ((Integer) this.nnc.get(ate.ksA)).intValue() == 4;
        } else {
            return false;
        }
    }

    public final void y(ate ate) {
        this.nnc.put(ate.ksA, Integer.valueOf(1));
    }

    public final void z(ate ate) {
        this.nnc.put(ate.ksA, Integer.valueOf(2));
    }

    public final void A(ate ate) {
        this.nnc.put(ate.ksA, Integer.valueOf(3));
    }

    public final boolean ex(String str, String str2) {
        if (this.nnc.containsKey(str) && 3 == ((Integer) this.nnc.get(str)).intValue()) {
            this.nnc.remove(str);
        }
        String aE = i.aE(1, str);
        LinkedList linkedList = (LinkedList) this.nmX.get(aE);
        if (linkedList == null) {
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c cVar = (c) ((WeakReference) it.next()).get();
            if (cVar != null && cVar.nnF && aE != null && aE.equals(cVar.id)) {
                WeakReference weakReference = (WeakReference) this.dUu.get(Integer.valueOf(cVar.code));
                if (weakReference != null) {
                    Object obj = weakReference.get();
                    if (obj != null && (obj instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        x.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[]{str, str2});
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) obj;
                        if (aVar.getTagObject() instanceof ak) {
                            ak akVar = (ak) aVar.getTagObject();
                            if (akVar == null) {
                                aVar.aO(str2, !this.nmG);
                            } else if (FileOp.cn(str2)) {
                                aVar.aO(str2, !this.nmG);
                                aVar.setPosition(akVar.position);
                                akVar.nRD.setVisibility(8);
                                akVar.nEI.setVisibility(8);
                                akVar.nEJ.setVisibility(8);
                                if (this.nnc.containsKey(str) && 4 == ((Integer) this.nnc.get(str)).intValue()) {
                                    this.nnc.remove(str);
                                }
                            } else {
                                this.nnc.put(str, Integer.valueOf(4));
                                akVar.nRD.setVisibility(8);
                                akVar.nEI.setImageResource(com.tencent.mm.plugin.sns.i.e.sight_chat_error);
                                akVar.nEI.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public final boolean a(String str, n nVar, int i) {
        a(i + "-" + str, nVar);
        return true;
    }

    private boolean a(String str, n nVar) {
        if (!(nVar == null || str == null)) {
            this.nmV.put(str, nVar);
        }
        return true;
    }

    public final void LZ(String str) {
        b(str, null);
    }

    public final n Ma(String str) {
        if (this.nmV == null) {
            return null;
        }
        return (n) this.nmV.get("0-" + str);
    }

    public static Bitmap a(String str, String str2, String str3, boolean z, av avVar) {
        if (!z && bi.oW(str)) {
            return null;
        }
        ate a = com.tencent.mm.modelsns.e.a(str3, 2, str2, str2, 1, 1, "");
        i.aE(2, str3);
        Bitmap LI;
        if (str3.equals("")) {
            LI = i.LI(str);
            if (i.q(LI)) {
                return LI;
            }
            return null;
        } else if (i.q(null)) {
            return null;
        } else {
            LI = i.LI(an.s(af.getAccSnsPath(), str3) + i.l(a));
            if (!i.q(LI)) {
                LI = i.LI(str);
            }
            if (LI == null && z && !bi.oW(str2)) {
                af.byj().a(a, 3, null, avVar);
            }
            if (i.q(LI)) {
                return LI;
            }
            return null;
        }
    }

    public final boolean B(ate ate) {
        if (ate == null || ate.ksA == null || ate.ksA.equals("")) {
            return false;
        }
        if (FileOp.cn(an.s(af.getAccSnsPath(), ate.ksA) + i.f(ate)) || FileOp.cn(an.s(af.getAccSnsPath(), ate.ksA) + i.e(ate))) {
            return true;
        }
        return i.b((n) this.nmV.get(i.aE(1, ate.ksA)));
    }

    public static boolean a(ate ate, av avVar, boolean z) {
        if (ate == null || ate.ksA == null || ate.ksA.equals("")) {
            return false;
        }
        String str;
        if (ate.ksA.startsWith("Locall_path")) {
            str = an.s(af.getAccSnsPath(), ate.ksA) + i.m(ate);
        } else {
            str = an.s(af.getAccSnsPath(), ate.ksA) + i.d(ate);
        }
        if (FileOp.cn(str)) {
            return true;
        }
        af.byj().a(ate, z ? 8 : 2, null, avVar);
        return false;
    }

    public static String C(ate ate) {
        if (ate == null) {
            return null;
        }
        if (ate.ksA.startsWith("pre_temp_sns_pic")) {
            return af.getAccSnsTmpPath() + ate.ksA;
        }
        if (ate.ksA.startsWith("Locall_path")) {
            return an.s(af.getAccSnsPath(), ate.ksA) + i.m(ate);
        }
        if (ate.ksA.startsWith("pre_temp_extend_pic")) {
            return ate.ksA.substring(19);
        }
        return an.s(af.getAccSnsPath(), ate.ksA) + i.d(ate);
    }

    public final Bitmap a(ate ate, View view, int i, boolean z, av avVar, boolean z2) {
        if (ate == null || ate.ksA == null || ate.ksA.equals("")) {
            return null;
        }
        String aE = i.aE(3, ate.ksA);
        String C = C(ate);
        int i2 = -1;
        int i3 = -1;
        try {
            Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(C);
            i2 = VZ.outWidth;
            i3 = VZ.outHeight;
        } catch (Exception e) {
        }
        a((Object) view, aE, false, -1, i, i2, i3, a.nnA);
        b byj = af.byj();
        String str = ate.ksA;
        Object obj = (byj.nmI.containsKey(i.aF(2, str)) || byj.nmI.containsKey(i.aF(8, str))) ? 1 : null;
        if (obj != null) {
            return null;
        }
        al alVar = this.nmW;
        b bVar = (b) alVar.nrg.get(aE);
        if (bVar == null) {
            obj = null;
        } else {
            ((b) alVar.nrg.get(aE)).byL();
            obj = bVar.obj;
        }
        WeakReference weakReference = (WeakReference) obj;
        x.i("MicroMsg.LazyerImageLoader2", "getFromWeakReference " + aE + "  " + (weakReference == null));
        Bitmap bitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (i.q(bitmap)) {
            return bitmap;
        }
        Bitmap NC;
        if (ate.ksA.startsWith("pre_temp_extend_pic")) {
            NC = s.NC(C);
        } else {
            NC = i.LI(C);
        }
        al alVar2 = this.nmW;
        WeakReference weakReference2 = new WeakReference(NC);
        if (((b) alVar2.nrg.get(aE)) == null) {
            alVar2.nrg.put(aE, new b(alVar2, weakReference2));
            alVar2.byK();
        } else {
            ((b) alVar2.nrg.get(aE)).byL();
            ((b) alVar2.nrg.get(aE)).obj = weakReference2;
        }
        if (i.q(NC)) {
            return NC;
        }
        if (z) {
            af.byj().a(ate, z2 ? 8 : 2, null, avVar);
        }
        return null;
    }

    public final n a(ate ate, ImageView imageView, int i, av avVar) {
        if (ate == null || ate.ksA == null || ate.ksA.equals("")) {
            return null;
        }
        imageView.setDrawingCacheEnabled(false);
        String aE = i.aE(0, ate.ksA);
        a((Object) imageView, aE, -1, i);
        String str = ate.ksA;
        n LY = LY(aE);
        if (i.b(LY)) {
            return LY;
        }
        a(0, ate, avVar);
        return null;
    }

    public final void a(View view, int i, int i2, int i3) {
        a((Object) view, null, true, -1, i3, -1, -1, a.nnA);
        if (i != -1) {
            view.setBackgroundResource(i);
        }
        if (i2 != -1) {
            if (view instanceof QFadeImageView) {
                ((QFadeImageView) view).setImageResource(i2);
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(com.tencent.mm.bp.a.f(view.getContext(), i2));
            }
        } else if (view instanceof QFadeImageView) {
            ((QFadeImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_detail_list2);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_detail_list2);
        }
    }

    public final void a(List<ate> list, View view, int i, int i2, a aVar) {
        a((List) list, view, i, i2, (av) aVar, false);
    }

    public final void a(List<ate> list, View view, int i, int i2, a aVar, boolean z) {
        if (list != null && list.size() != 0) {
            String aE;
            n LY;
            if (list.size() != 1) {
                aE = i.aE(0, i.cf(list));
                a((Object) view, aE, true, -1, i, -1, -1, i2);
                LY = LY(aE);
                boolean b = i.b(LY);
                x.v("MicroMsg.LazyerImageLoader2", "set Sns GridList " + b);
                if (b) {
                    a((Object) view, aE, LY);
                    return;
                }
                cy(view);
                if (!this.nnp.contains(aE)) {
                    WeakReference weakReference = new WeakReference(view);
                    af.byb().post(new 4(this, list, aVar));
                }
            } else if (z) {
                ate ate = (ate) list.get(0);
                int i3 = a.nnB;
                if (ate != null && ate.ksA != null && !ate.ksA.equals("")) {
                    view.setDrawingCacheEnabled(false);
                    aE = i.aE(5, ate.ksA);
                    a((Object) view, aE, -1, i, i3);
                    String str = ate.ksA;
                    LY = LY(aE);
                    if (i.b(LY)) {
                        a((Object) view, aE, LY);
                        return;
                    }
                    cy(view);
                    if (!this.nnp.contains(aE)) {
                        a(5, ate, (av) aVar);
                    }
                }
            } else {
                b((ate) list.get(0), view, i, aVar);
            }
        }
    }

    protected final void b(String str, n nVar) {
        if (!i.b(nVar)) {
            n nVar2 = (n) this.nmV.get(str);
            if (nVar2 == null || nVar2.isRecycled()) {
                this.nmV.remove(str);
                nVar2 = null;
            }
            nVar = nVar2;
        }
        if (i.b(nVar)) {
            if (!(this.nmV == null || nVar == null || str == null)) {
                this.nmV.put(str, nVar);
            }
            LinkedList linkedList = (LinkedList) this.nmX.get(str);
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) ((WeakReference) it.next()).get();
                    if (cVar != null && cVar.nnF && str != null && str.equals(cVar.id)) {
                        WeakReference weakReference = (WeakReference) this.dUu.get(Integer.valueOf(cVar.code));
                        if (weakReference != null) {
                            Object obj = weakReference.get();
                            if (obj != null) {
                                if (obj instanceof QFadeImageView) {
                                    QFadeImageView qFadeImageView = (QFadeImageView) obj;
                                    if (this.nne != null && (qFadeImageView instanceof TagImageView)) {
                                        int position = ((TagImageView) qFadeImageView).getPosition();
                                        if (!(position == -1 || this.nne.xj(position))) {
                                        }
                                    }
                                }
                                if (!i.b(nVar) || obj == null) {
                                    String str2 = "MicroMsg.LazyerImageLoader2";
                                    String str3 = "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(nVar == null);
                                    objArr[1] = Boolean.valueOf(obj == null);
                                    objArr[2] = Boolean.valueOf(i.b(nVar));
                                    x.d(str2, str3, objArr);
                                } else {
                                    a(obj, str, nVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void bwU() {
        bxC();
        this.nnf = 0;
        this.nng = 0;
        this.nmZ.clear();
        this.nna = false;
    }
}
