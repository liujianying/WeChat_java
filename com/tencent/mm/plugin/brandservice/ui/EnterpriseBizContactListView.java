package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.e;
import com.tencent.mm.ac.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView extends BaseSortView {
    private ListView eVT;
    private String hph;
    private boolean hpn;
    private int hpo = -1;
    private b hpp;
    private a hpq;
    private int hpr = 0;
    private int hps = 0;

    private class d implements Comparator<com.tencent.mm.ui.base.sortview.d> {
        private d() {
        }

        /* synthetic */ d(EnterpriseBizContactListView enterpriseBizContactListView, byte b) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            com.tencent.mm.ui.base.sortview.d dVar = (com.tencent.mm.ui.base.sortview.d) obj;
            com.tencent.mm.ui.base.sortview.d dVar2 = (com.tencent.mm.ui.base.sortview.d) obj2;
            String str = dVar.tDT;
            String str2 = dVar2.tDT;
            int compareToIgnoreCase = (str == null || str2 == null) ? 0 : str.compareToIgnoreCase(str2);
            if (compareToIgnoreCase != 0) {
                if (str.equalsIgnoreCase("#")) {
                    compareToIgnoreCase = 1;
                }
                return str2.equalsIgnoreCase("#") ? -1 : compareToIgnoreCase;
            } else {
                ix ixVar = (ix) dVar.data;
                ix ixVar2 = (ix) dVar2.data;
                if (!(str == null || str2 == null || (!str.equalsIgnoreCase("!2") && !str.equalsIgnoreCase("!1")))) {
                    int AY = ixVar.guS.AY();
                    int AY2 = ixVar2.guS.AY();
                    Object obj3 = ((AY < 97 || AY > TbsListener$ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR) && (AY < 65 || AY > 90)) ? 1 : null;
                    Object obj4 = ((AY2 < 97 || AY2 > TbsListener$ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR) && (AY2 < 65 || AY2 > 90)) ? 1 : null;
                    if (obj3 != null && obj4 == null) {
                        return 1;
                    }
                    if (obj3 == null && obj4 != null) {
                        return -1;
                    }
                }
                int compareToIgnoreCase2 = (ixVar.guS == null || ixVar.guS.wQ() == null || ixVar.guS.wQ().length() <= 0 || ixVar2.guS == null || ixVar2.guS.wQ() == null || ixVar2.guS.wQ().length() <= 0) ? 0 : ixVar.guS.wQ().compareToIgnoreCase(ixVar2.guS.wQ());
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase2 = (ixVar.guS == null || ixVar.guS.field_nickname == null || ixVar.guS.field_nickname.length() <= 0 || ixVar2.guS == null || ixVar2.guS.field_nickname == null || ixVar2.guS.field_nickname.length() <= 0) ? 0 : ixVar.guS.field_nickname.compareToIgnoreCase(ixVar2.guS.field_nickname);
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase = (ixVar.guS == null || ixVar.guS.field_username == null || ixVar.guS.field_username.length() <= 0 || ixVar2.guS == null || ixVar2.guS.field_username == null || ixVar2.guS.field_username.length() <= 0) ? 0 : ixVar.guS.field_username.compareToIgnoreCase(ixVar2.guS.field_username);
                return compareToIgnoreCase == 0 ? 0 : compareToIgnoreCase;
            }
        }
    }

    static /* synthetic */ void a(TextView textView, Context context, String str, int i) {
        if (textView != null && !bi.oW(str)) {
            try {
                textView.setText(new SpannableString(j.a(context, str, i)));
            } catch (Exception e) {
                textView.setText("");
            }
        }
    }

    static /* synthetic */ void a(EnterpriseBizContactListView enterpriseBizContactListView, com.tencent.mm.ac.d dVar, int i) {
        b kn = z.Nh().kn(enterpriseBizContactListView.hph);
        long j = kn != null ? kn.field_wwCorpId : 0;
        long j2 = kn != null ? kn.field_wwUserVid : 0;
        long Md = dVar.Md();
        h.mEJ.h(14507, new Object[]{Long.valueOf(j), Long.valueOf(Md), Long.valueOf(j2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i)});
        x.d("MicroMsg.BrandService.EnterpriseBizContactListView", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[]{Long.valueOf(j), Long.valueOf(Md), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i)});
    }

    public EnterpriseBizContactListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setFatherBizName(String str) {
        this.hph = str;
    }

    public void setExcludeBizChat(boolean z) {
        this.hpn = z;
    }

    public final void refresh() {
        dx(getSortEntityList());
        super.refresh();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.hpr = (int) motionEvent.getRawX();
            this.hps = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void auX() {
        setOnItemClickListener(new 1(this));
        if (getMode() == 0) {
            setOnItemLongClickListener(new 2(this));
        }
    }

    public int getContactCount() {
        return this.hpo;
    }

    private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList() {
        List<com.tencent.mm.ui.base.sortview.d> arrayList = new ArrayList();
        z.MY();
        Cursor C = e.C(this.hph, this.hpn);
        while (C.moveToNext()) {
            ix ixVar = new ix();
            if (C != null) {
                ab abVar = new ab();
                abVar.d(C);
                com.tencent.mm.ac.d dVar = new com.tencent.mm.ac.d();
                dVar.d(C);
                ixVar.userName = abVar.field_username;
                ixVar.guS = abVar;
                ixVar.lUs = dVar;
            }
            if (ixVar.guS != null) {
                com.tencent.mm.ui.base.sortview.d dVar2 = new com.tencent.mm.ui.base.sortview.d();
                dVar2.data = ixVar;
                if (ixVar.lUs.Ma()) {
                    dVar2.tDT = "!1";
                } else if (ixVar.guS.BG()) {
                    dVar2.tDT = "!2";
                } else {
                    int AY = ixVar.guS.AY();
                    if (AY >= 97 && AY <= TbsListener$ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR) {
                        AY -= 32;
                    }
                    if (AY < 65 || AY > 90) {
                        dVar2.tDT = "#";
                    } else {
                        dVar2.tDT = ((char) AY);
                    }
                }
                arrayList.add(dVar2);
            }
        }
        C.close();
        this.hpo = arrayList.size();
        Collections.sort(arrayList, new d(this, (byte) 0));
        return arrayList;
    }

    public static void release() {
        z.Ni().MS();
    }

    public final boolean a(String str, com.tencent.mm.ui.base.sortview.d dVar) {
        if (!(bi.oW(str) || dVar == null)) {
            ix ixVar = (ix) dVar.data;
            if (ixVar == null) {
                return false;
            }
            String BL = ixVar.guS.BL();
            String wP = ixVar.guS.wP();
            String wQ = ixVar.guS.wQ();
            String toUpperCase = str.toUpperCase();
            if (!(bi.oW(BL) || BL.toUpperCase().indexOf(toUpperCase) == -1) || (!(bi.oW(wP) || wP.toUpperCase().indexOf(toUpperCase) == -1) || (!bi.oW(wQ) && wQ.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), com.tencent.mm.plugin.brandservice.b.e.enterprise_biz_list_view_sort, this);
    }

    public VerticalScrollBar getScrollBar() {
        return (VerticalScrollBar) findViewById(com.tencent.mm.plugin.brandservice.b.d.sidrbar);
    }

    public ListView getListView() {
        this.eVT = (ListView) findViewById(com.tencent.mm.plugin.brandservice.b.d.listview);
        return this.eVT;
    }

    public View getNoResultView() {
        TextView textView = (TextView) findViewById(com.tencent.mm.plugin.brandservice.b.d.no_result);
        textView.setText(com.tencent.mm.plugin.brandservice.b.h.enterprise_no_sub_biz);
        return textView;
    }

    public a getItemViewCreator() {
        return new 3(this);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hpp != null) {
            this.hpp.auW();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnTouchListener(b bVar) {
        this.hpp = bVar;
    }
}
