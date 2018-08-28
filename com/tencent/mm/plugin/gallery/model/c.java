package com.tencent.mm.plugin.gallery.model;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.gallery.stub.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class c {
    private static int bkq = 0;
    public static boolean jAA = false;
    public static boolean jAB = false;
    public static boolean jAC = false;
    private static c jAy = null;
    public static boolean jAz = false;
    private HashSet<GalleryItem$MediaItem> jAD = new HashSet();
    private ArrayList<Bundle> jAE = new ArrayList();
    private HashMap<Integer, Boolean> jAF = new HashMap();
    private l jAt;
    private a jAu;
    private e jAv;
    private ArrayList<GalleryItem$MediaItem> jAw = null;
    private LinkedHashSet<GalleryItem$MediaItem> jAx = new LinkedHashSet();

    public static GalleryItem$MediaItem CS(String str) {
        GalleryItem$MediaItem a = GalleryItem$MediaItem.a(0, 0, str, "", "");
        if (aRd().jAw != null) {
            int indexOf = aRd().jAw.indexOf(a);
            if (indexOf >= 0) {
                return (GalleryItem$MediaItem) aRd().jAw.get(indexOf);
            }
        }
        return null;
    }

    private c() {
        if (this.jAu == null) {
            this.jAu = new a();
        }
        if (this.jAt == null) {
            this.jAt = new l();
        }
        if (this.jAv == null) {
            this.jAv = new e();
        }
    }

    private static c aRd() {
        if (jAy == null) {
            jAy = new c();
        }
        return jAy;
    }

    public static a aRe() {
        return aRd().jAu;
    }

    public static l aRf() {
        return aRd().jAt;
    }

    public static e aRg() {
        return aRd().jAv;
    }

    public static void initialize() {
        synchronized (c.class) {
            bkq++;
        }
    }

    public static void release(boolean z) {
        synchronized (c.class) {
            if (bkq > 0) {
                bkq--;
            }
            if (z && bkq == 0) {
                aRd().jAt = null;
                if (aRd().jAu != null) {
                    b bVar = aRd().jAu.jAe;
                    if (bVar.jAp != null) {
                        bVar.jAp.a(new b$4(bVar));
                        bVar.jAp = null;
                    }
                    if (bVar.jAq != null) {
                        d dVar = bVar.jAq;
                        dVar.aRo();
                        dVar.aRp();
                        dVar.aRr();
                        bVar.jAq = null;
                    }
                    aRd().jAu = null;
                }
                e eVar = aRd().jAv;
                if (eVar.jAK != null) {
                    eVar.jAK.quit();
                    eVar.jAK = null;
                }
                eVar.jAN = null;
                if (eVar.jAL != null) {
                    eVar.jAL.quit();
                    eVar.jAL = null;
                }
                eVar.jAO = null;
                if (eVar.jAM != null) {
                    eVar.jAM.quit();
                    eVar.jAM = null;
                }
                eVar.jAP = null;
                aRd().jAv = null;
                jAy = null;
            }
        }
    }

    public static ArrayList<GalleryItem$MediaItem> aRh() {
        return aRd().jAw;
    }

    public static HashSet<GalleryItem$MediaItem> aRi() {
        return aRd().jAD;
    }

    public static ArrayList<Bundle> aRj() {
        return aRd().jAE;
    }

    public static LinkedHashSet<GalleryItem$MediaItem> aRk() {
        return aRd().jAx;
    }

    public static void v(ArrayList<GalleryItem$MediaItem> arrayList) {
        aRd().jAw = arrayList;
    }

    public static void qn(int i) {
        aRd().jAF.put(Integer.valueOf(i), Boolean.valueOf(true));
    }

    public static void aRl() {
        aRd().jAF.clear();
    }

    public static int aRm() {
        return aRd().jAF.size();
    }

    public static void a(a aVar, int i, boolean z, boolean z2) {
        x.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (aVar == null) {
            x.e("MicroMsg.GalleryCore", "invoker is null");
            return;
        }
        int i2;
        int size;
        if (aRd().jAt.aRI() == 3) {
            i2 = 1;
        } else if (aRd().jAt.aRI() == 4) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (aRd().jAD != null) {
            size = aRd().jAD.size();
        } else {
            size = 0;
        }
        x.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(size)});
        if (size > 0) {
            aVar.al(13858, i2 + "," + i + "," + size + ",0");
        }
        x.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[]{Boolean.valueOf(aVar.fi(true))});
        Iterator it = aRd().jAE.iterator();
        while (it.hasNext()) {
            Bundle bundle = (Bundle) it.next();
            String string = bundle.getString("after_photo_edit");
            if (!(r4 && z2)) {
                x.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", new Object[]{string});
                FileOp.deleteFile(string);
                r.a(string, ad.getContext());
            }
            int i3 = bundle.getInt("report_info_emotion_count");
            int i4 = bundle.getInt("report_info_text_count");
            int i5 = bundle.getInt("report_info_mosaic_count");
            int i6 = bundle.getInt("report_info_doodle_count");
            boolean z3 = bundle.getBoolean("report_info_iscrop");
            int i7 = bundle.getInt("report_info_undo_count");
            boolean z4 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.GalleryCore";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i4);
            objArr[2] = Integer.valueOf(i5);
            objArr[3] = Integer.valueOf(i6);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            objArr[5] = Integer.valueOf(i7);
            objArr[6] = Integer.valueOf(z4 ? 1 : 0);
            x.i(str, str2, objArr);
            if (size > 0) {
                try {
                    aVar.al(13857, i2 + "," + z + "," + i3 + "," + i4 + "," + i5 + "," + i6 + "," + (z3 ? 1 : 0) + "," + i7 + ",2" + (z4 ? 1 : 0));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
                }
            }
        }
    }

    public static void a(a aVar, String str, int[] iArr, boolean z, boolean z2) {
        int i = 2;
        switch (aRd().jAt.aRI()) {
            case 3:
                i = 1;
                break;
            case 4:
                if (!bi.oW(str) && str.equals(ad.getContext().getString(R.l.favorite))) {
                    i = 6;
                    break;
                }
            case 7:
            case 8:
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        x.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[]{Integer.valueOf(r4)});
        if (aVar == null) {
            x.e("MicroMsg.GalleryCore", "invoker is null");
            return;
        }
        try {
            aVar.al(14205, i + "," + i + "," + iArr[0] + "," + iArr[1] + "," + iArr[2] + "," + iArr[3] + "," + z + "," + z2 + "," + jAz + "," + jAA + "," + jAB + "," + jAC);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
        }
        jAz = false;
        jAA = false;
        jAB = false;
        jAC = false;
    }
}
