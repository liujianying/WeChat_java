package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.model.g.2;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class i extends h<String, Integer, Boolean> {
    private String aAL = "";
    private n dvu = null;
    private String kJG;
    private int nnK;
    private String nnL;
    private List<ate> nnM;

    public final /* synthetic */ Object bxI() {
        String LA = com.tencent.mm.plugin.sns.data.i.LA(this.kJG);
        String s = an.s(this.nnL, this.kJG);
        if (!FileOp.cn(s + LA)) {
            a(this.kJG, LA, this.nnM);
        }
        this.dvu = com.tencent.mm.plugin.sns.data.i.LJ(s + LA);
        af.aRu().post(new 2(af.byl(), this.kJG, this.dvu));
        x.i("MicroMsg.MutiImageLoader", "deocde done bm " + this.dvu + " requestid " + this.kJG + " " + s + LA);
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
        af.byl().nnp.remove(this.aAL);
        af.byl().b(this.aAL, this.dvu);
    }

    public i(String str, String str2, List<ate> list) {
        af.byl().nnp.add(str);
        this.kJG = str2;
        this.nnL = af.getAccSnsPath();
        this.nnK = af.byw();
        this.nnM = list;
        this.aAL = str;
    }

    public final ag bxH() {
        return af.aRs();
    }

    private boolean a(String str, String str2, List<ate> list) {
        String str3;
        x.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + str + " " + str2);
        List linkedList = new LinkedList();
        int i = 0;
        for (ate ate : list) {
            String f = com.tencent.mm.plugin.sns.data.i.f(ate);
            String e = com.tencent.mm.plugin.sns.data.i.e(ate);
            String s = an.s(this.nnL, ate.ksA);
            if (!FileOp.cn(s + f)) {
                if (!FileOp.cn(s + e)) {
                    String l = com.tencent.mm.plugin.sns.data.i.l(ate);
                    if (FileOp.cn(s + l)) {
                        str3 = l;
                    } else {
                        str3 = com.tencent.mm.plugin.sns.data.i.m(ate);
                    }
                    s.a(s, str3, e, (float) af.byx());
                }
                s.b(s, e, f, (float) af.byw());
            }
            n LJ = com.tencent.mm.plugin.sns.data.i.LJ(s + f);
            if (LJ == null) {
                FileOp.deleteFile(s + f);
                x.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! " + f);
                return false;
            }
            linkedList.add(LJ);
            x.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + LJ + " " + s + f);
            int i2 = i + 1;
            if (i2 < 4) {
                i = i2;
            }
        }
        try {
            str3 = an.s(this.nnL, str);
            FileOp.mL(str3);
            c.a(com.tencent.mm.plugin.sns.data.i.i(linkedList, this.nnK), 100, CompressFormat.JPEG, str3 + str2, false);
            return true;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MutiImageLoader", e2, "makeMutilMedia failed: " + str2, new Object[0]);
            return false;
        }
    }
}
