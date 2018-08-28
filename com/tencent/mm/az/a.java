package com.tencent.mm.az;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.d;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;

public final class a {
    public static ArrayList<String> nv(String str) {
        ArrayList<String> arrayList = new ArrayList();
        ba[] dd = d.SG().dd(str, 10);
        if (dd != null) {
            for (ba baVar : dd) {
                arrayList.add(baVar.field_sayhicontent);
            }
        }
        x.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> nw(String str) {
        ArrayList<String> arrayList = new ArrayList();
        bo[] df = d.SH().df(str, 10);
        if (df != null) {
            for (bo boVar : df) {
                arrayList.add(boVar.field_sayhicontent);
            }
        }
        x.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> nx(String str) {
        ArrayList<String> arrayList = new ArrayList();
        au.HU();
        Cursor GN = c.FT().GN(str);
        if (!(GN == null || GN.getCount() == 0)) {
            if (GN.moveToFirst()) {
                int i = 0;
                while (!GN.isAfterLast()) {
                    bd bdVar = new bd();
                    bdVar.d(GN);
                    GN.moveToNext();
                    if (bdVar.isText()) {
                        arrayList.add(bdVar.field_content);
                    } else {
                        arrayList.add("");
                    }
                    i++;
                    if (i == 10) {
                        break;
                    }
                }
            }
            GN.close();
        }
        return arrayList;
    }

    public static ArrayList<String> v(int i, String str) {
        ArrayList<String> arrayList = new ArrayList();
        at[] dc = d.SE().dc(str, 10);
        if (dc != null) {
            for (at atVar : dc) {
                if (atVar.field_type == 1) {
                    arrayList.add(bi.oV(d.YY(atVar.field_msgContent).content));
                }
            }
        }
        x.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[]{Integer.valueOf(i)});
        return arrayList;
    }

    public static ArrayList<bd> d(long[] jArr) {
        ArrayList<bd> arrayList = new ArrayList();
        if (jArr != null) {
            for (long dW : jArr) {
                au.HU();
                arrayList.add(c.FT().dW(dW));
            }
        }
        return arrayList;
    }
}
