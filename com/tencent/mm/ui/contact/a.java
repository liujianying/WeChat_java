package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.m;
import com.tencent.mm.bt.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.y;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a extends f<String, com.tencent.mm.storage.f> implements b {
    public static final ColorStateList kBs = com.tencent.mm.bp.a.ac(ad.getContext(), R.e.mm_list_textcolor_one);
    public static final ColorStateList kBt = com.tencent.mm.bp.a.ac(ad.getContext(), R.e.hint_text_color);
    private String eIQ = "";
    private com.tencent.mm.ui.applet.b eKg = null;
    protected List<String> gRN = null;
    protected g hkN;
    protected MMSlideDelView$c hkO;
    protected d hkQ = MMSlideDelView.getItemStatusCallBack();
    private boolean hoW = false;
    OnClickListener iZP = new 1(this);
    protected MMSlideDelView.f lCE;
    StringBuilder sb = new StringBuilder(32);
    private String[] tDY = null;
    private int type;
    public HashMap<String, com.tencent.mm.storage.f> ugE = new HashMap();
    protected String ugF = null;
    protected String ugG = null;
    private List<Object> ugH;
    private List<String> ugI;
    private int ugJ = 0;
    protected int[] ugK;
    String[] ugL;
    protected com.tencent.mm.ui.contact.AddressUI.a ugM;
    private Set<Integer> ugN = new HashSet();
    private int ugO = 0;
    private boolean ugP = true;
    a ugQ;
    private boolean ugR = false;
    boolean ugS = false;
    private String ugT;
    LinkedList<View> ugU = new LinkedList();
    boolean ugV;
    HashMap<View, ViewStub> ugW = new HashMap();
    private SparseArray<String> ugX = new SparseArray();
    private SparseArray<Integer> ugY = new SparseArray();
    private HashSet<String> ugZ = new HashSet();

    public final /* synthetic */ com.tencent.mm.bt.a.a coc() {
        return new com.tencent.mm.storage.f();
    }

    /* renamed from: dq */
    public final void q(String str, int i) {
        if (i == 5) {
            this.ugZ.add(str);
        }
        super.q(str, i);
    }

    public final void pause() {
        this.ugZ.clear();
        super.pause();
    }

    public void notifyDataSetChanged() {
        this.ugT = q.GF();
        if (this.ugK == null) {
            cxW();
        }
        if (getCount() == 0) {
            super.notifyDataSetChanged();
            return;
        }
        this.ugO = coV();
        x.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[]{Integer.valueOf(this.ugO)});
        super.notifyDataSetChanged();
    }

    public a(Context context, String str, String str2, int i) {
        super(context);
        this.context = context;
        this.ugF = str;
        this.ugG = str2;
        this.type = i;
        this.ugR = true;
        this.ugH = new LinkedList();
        this.ugI = new LinkedList();
        this.ugT = q.GF();
        this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    }

    public final void l(Fragment fragment) {
        if (fragment instanceof com.tencent.mm.ui.contact.AddressUI.a) {
            this.ugM = (com.tencent.mm.ui.contact.AddressUI.a) fragment;
        }
    }

    public final void detach() {
        if (this.eKg != null) {
            this.eKg.detach();
            this.eKg = null;
        }
    }

    public final void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.lCE = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView$c mMSlideDelView$c) {
        this.hkO = mMSlideDelView$c;
    }

    public final void dQ(List<String> list) {
        if (this.type != 2) {
            list.add(q.GF());
        }
        au.HU();
        bl Hg = c.FZ().Hg("@t.qq.com");
        if (Hg != null) {
            list.add(Hg.name);
        }
        if (this.type == 3 || this.type == 5 || this.type == 4 || this.type == 1 || this.type == 0) {
            for (String add : s.Hp()) {
                list.add(add);
            }
        }
        list.add("blogapp");
        this.gRN = list;
    }

    public final int getPositionForSection(int i) {
        if (this.ugK != null && i >= 0 && i < this.ugK.length) {
            i = this.ugK[i];
        }
        return this.ugO + i;
    }

    private boolean cxU() {
        return this.ugF.equals("@micromsg.qq.com") || this.ugF.equals("@all.contact.without.chatroom");
    }

    protected Cursor cxV() {
        long currentTimeMillis = System.currentTimeMillis();
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        au.HU();
        Cursor a = c.FR().a(this.ugF, this.ugG, this.gRN, linkedList, cxU(), this.ugR);
        x.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        return a;
    }

    protected final void cxW() {
        int count = getCount();
        if (count != 0) {
            int i;
            int i2;
            this.ugO = coV();
            if (this.tDY != null) {
                this.ugK = s.a(this.ugF, this.ugG, this.gRN, this.tDY);
                this.ugL = s.a(this.ugF, this.ugG, this.tDY, this.gRN);
            } else if (cnU()) {
                long currentTimeMillis = System.currentTimeMillis();
                HashSet hashSet = new HashSet();
                this.ugK = new int[30];
                this.ugL = new String[30];
                i = this.ugO;
                int i3 = 0;
                while (i < count) {
                    com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) Dy(i);
                    if (fVar != null) {
                        String b = b(fVar, i);
                        if (hashSet.add(b)) {
                            this.ugK[i3] = i - this.ugO;
                            this.ugL[i3] = b;
                            i2 = i3 + 1;
                        }
                        i2 = i3;
                    } else {
                        x.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
                        i2 = i3;
                    }
                    i++;
                    i3 = i2;
                }
                x.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - currentTimeMillis) + "favourCount : " + this.ugO);
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.ugK = s.b(this.ugF, this.ugG, this.gRN, this.eIQ);
                this.ugL = s.a(this.ugF, this.ugG, this.eIQ, this.gRN);
                x.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - currentTimeMillis2));
            }
            this.ugN.clear();
            for (int i4 : this.ugK) {
                this.ugN.add(Integer.valueOf(i4 - 1));
            }
        }
    }

    public final void cxX() {
        this.hkQ.aYm();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2 = -1;
        if (!this.ugV) {
            for (int i3 = 0; i3 < 8; i3++) {
                this.ugU.add(y.gq(this.context).inflate(R.i.address_new_item_myview, null));
            }
            this.ugV = true;
        }
        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) Dy(i);
        if (view == null) {
            View view2;
            if (this.ugU.size() > 0) {
                View view3 = (View) this.ugU.getFirst();
                this.ugU.removeFirst();
                view2 = view3;
            } else {
                view2 = View.inflate(this.context, R.i.address_new_item_myview, null);
            }
            bVar = new b();
            bVar.kuR = (TextView) view2.findViewById(R.h.contactitem_catalog);
            bVar.kuS = (TextView) view2.findViewById(R.h.contactitem_signature);
            bVar.kBx = (AddressView) view2.findViewById(R.h.myview);
            bVar.uhb = (TextView) view2.findViewById(R.h.contactitem_account_delete);
            bVar.uhc = view2.findViewById(R.h.contactitem_selector);
            bVar.uhd = (TextView) view2.findViewById(R.h.openim_contact_desc);
            LayoutParams layoutParams = bVar.uhc.getLayoutParams();
            layoutParams.height = (int) (((float) com.tencent.mm.bp.a.ae(this.context, R.f.ContactListHeight)) * com.tencent.mm.bp.a.fh(this.context));
            bVar.uhc.setLayoutParams(layoutParams);
            if (this.ugM != null) {
                this.ugM.hLH.a(bVar.kBx);
            }
            view2.setTag(bVar);
            view = view2;
        } else {
            bVar = (b) view.getTag();
        }
        if (fVar != null) {
            CharSequence b;
            au.HU();
            ab Yg = c.FR().Yg(fVar.field_username);
            x.d("MicroMsg.AddressAdapter", "user:%s, remark:%s", new Object[]{Yg.field_username, Yg.field_conRemark});
            com.tencent.mm.storage.f fVar2 = (com.tencent.mm.storage.f) Dy(i - 1);
            com.tencent.mm.storage.f fVar3 = (com.tencent.mm.storage.f) Dy(i + 1);
            int a = fVar2 == null ? -1 : a(fVar2, i - 1);
            int a2 = a(fVar, i);
            if (fVar3 != null) {
                i2 = a(fVar3, i + 1);
            }
            if (this.ugP) {
                if (i == 0) {
                    b = b(fVar, i);
                    if (!ai.oW(b)) {
                        bVar.kuR.setVisibility(0);
                        bVar.kuR.setText(b);
                        if (!this.ugP || a2 == i2) {
                            bVar.uhc.setBackgroundResource(R.g.list_item_normal);
                        }
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.kBx, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.kBx.setMaskBitmap(null);
                        } else if (com.tencent.mm.model.am.a.dBt != null) {
                            String gY = com.tencent.mm.model.am.a.dBt.gY(fVar.field_verifyFlag);
                            if (gY != null) {
                                bVar.kBx.setMaskBitmap(m.kU(gY));
                            } else {
                                bVar.kBx.setMaskBitmap(null);
                            }
                        } else {
                            bVar.kBx.setMaskBitmap(null);
                        }
                        bVar.kBx.updateTextColors();
                        b = fVar.sNQ;
                        if (b == null) {
                            try {
                                if (ab.XR(fVar.field_username)) {
                                    b = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).d(ad.getContext(), fVar.BL(), com.tencent.mm.bp.a.ad(this.context, R.f.NormalTextSize));
                                } else {
                                    Context context = this.context;
                                    b = fVar.BL();
                                    String str = fVar.field_username;
                                    if (b == null || b.length() <= 0) {
                                        Object obj = str;
                                    }
                                    str = "";
                                    if (str.length() > 0 && !str.equals(b)) {
                                        this.sb.append(b);
                                        this.sb.append("(");
                                        this.sb.append(str);
                                        this.sb.append(")");
                                        b = this.sb.toString();
                                        this.sb.delete(0, this.sb.length());
                                    }
                                    b = j.a(context, b, com.tencent.mm.bp.a.ad(this.context, R.f.NormalTextSize));
                                }
                            } catch (Exception e) {
                                b = null;
                            }
                            if (b == null) {
                                b = "";
                            }
                            bVar.kBx.setName(b);
                        } else {
                            bVar.kBx.setName(b);
                        }
                        bVar.kBx.setDescription(ai.oV(fVar.field_remarkDesc));
                        a(fVar, bVar);
                    }
                } else if (i > 0 && a2 != a) {
                    b = b(fVar, i);
                    if (!ai.oW(b)) {
                        bVar.kuR.setVisibility(0);
                        bVar.kuR.setText(b);
                        bVar.uhc.setBackgroundResource(R.g.list_item_normal);
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.kBx, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.kBx.setMaskBitmap(null);
                        } else if (com.tencent.mm.model.am.a.dBt != null) {
                            String gY2 = com.tencent.mm.model.am.a.dBt.gY(fVar.field_verifyFlag);
                            if (gY2 != null) {
                                bVar.kBx.setMaskBitmap(m.kU(gY2));
                            } else {
                                bVar.kBx.setMaskBitmap(null);
                            }
                        } else {
                            bVar.kBx.setMaskBitmap(null);
                        }
                        bVar.kBx.updateTextColors();
                        b = fVar.sNQ;
                        if (b == null) {
                            bVar.kBx.setName(b);
                        } else {
                            try {
                                if (ab.XR(fVar.field_username)) {
                                    b = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).d(ad.getContext(), fVar.BL(), com.tencent.mm.bp.a.ad(this.context, R.f.NormalTextSize));
                                } else {
                                    Context context2 = this.context;
                                    b = fVar.BL();
                                    String str2 = fVar.field_username;
                                    if (b == null || b.length() <= 0) {
                                        Object obj2 = str2;
                                    }
                                    str2 = "";
                                    if (str2.length() > 0 && !str2.equals(b)) {
                                        this.sb.append(b);
                                        this.sb.append("(");
                                        this.sb.append(str2);
                                        this.sb.append(")");
                                        b = this.sb.toString();
                                        this.sb.delete(0, this.sb.length());
                                    }
                                    b = j.a(context2, b, com.tencent.mm.bp.a.ad(this.context, R.f.NormalTextSize));
                                }
                            } catch (Exception e2) {
                                b = null;
                            }
                            if (b == null) {
                                b = "";
                            }
                            bVar.kBx.setName(b);
                        }
                        bVar.kBx.setDescription(ai.oV(fVar.field_remarkDesc));
                        a(fVar, bVar);
                    }
                }
            }
            bVar.kuR.setVisibility(8);
            bVar.uhc.setBackgroundResource(R.g.list_item_normal);
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.kBx, fVar.field_username);
            if (fVar.field_verifyFlag != 0) {
                bVar.kBx.setMaskBitmap(null);
            } else if (com.tencent.mm.model.am.a.dBt != null) {
                String gY22 = com.tencent.mm.model.am.a.dBt.gY(fVar.field_verifyFlag);
                if (gY22 != null) {
                    bVar.kBx.setMaskBitmap(m.kU(gY22));
                } else {
                    bVar.kBx.setMaskBitmap(null);
                }
            } else {
                bVar.kBx.setMaskBitmap(null);
            }
            bVar.kBx.updateTextColors();
            b = fVar.sNQ;
            if (b == null) {
                try {
                    if (ab.XR(fVar.field_username)) {
                        b = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).d(ad.getContext(), fVar.BL(), com.tencent.mm.bp.a.ad(this.context, R.f.NormalTextSize));
                    } else {
                        Context context22 = this.context;
                        b = fVar.BL();
                        String str22 = fVar.field_username;
                        if (b == null || b.length() <= 0) {
                            Object obj22 = str22;
                        }
                        str22 = "";
                        if (str22.length() > 0 && !str22.equals(b)) {
                            this.sb.append(b);
                            this.sb.append("(");
                            this.sb.append(str22);
                            this.sb.append(")");
                            b = this.sb.toString();
                            this.sb.delete(0, this.sb.length());
                        }
                        b = j.a(context22, b, com.tencent.mm.bp.a.ad(this.context, R.f.NormalTextSize));
                    }
                } catch (Exception e22) {
                    b = null;
                }
                if (b == null) {
                    b = "";
                }
                bVar.kBx.setName(b);
            } else {
                bVar.kBx.setName(b);
            }
            bVar.kBx.setDescription(ai.oV(fVar.field_remarkDesc));
            a(fVar, bVar);
        }
        bVar.kBx.updatePositionFlag();
        bVar.kBx.setContentDescription(bVar.kBx.getNickName() == null ? "" : bVar.kBx.getNickName().toString());
        return view;
    }

    protected void a(com.tencent.mm.storage.f fVar, b bVar) {
        try {
            bVar.uhd.setText(null);
            bVar.uhd.setVisibility(8);
            if (ab.XR(fVar.field_username)) {
                CharSequence aE = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).aE(fVar.field_openImAppid, fVar.field_descWordingId);
                if (aE != null && aE.length() > 0) {
                    bVar.uhd.setVisibility(0);
                    bVar.uhd.setText(aE);
                }
            }
        } catch (Throwable th) {
        }
    }

    protected int a(com.tencent.mm.storage.f fVar, int i) {
        if (i < this.ugO) {
            return 32;
        }
        if (fVar != null) {
            return fVar.field_showHead;
        }
        x.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[]{Integer.valueOf(i)});
        return -1;
    }

    protected String b(com.tencent.mm.storage.f fVar, int i) {
        if (i < this.ugO) {
            return getString(R.l.address_favour_contact_catalog_name);
        }
        if (fVar.field_showHead == 31) {
            return "";
        }
        if (fVar.field_showHead == 123) {
            return "#";
        }
        if (fVar.field_showHead == 33) {
            return getString(R.l.address_application_account_catalog_name);
        }
        if (fVar.field_showHead == 43) {
            return getString(R.l.room_head_name);
        }
        if (fVar.field_showHead == 32) {
            return getString(R.l.address_favour_contact_catalog_name);
        }
        String str = (String) this.ugX.get(fVar.field_showHead);
        if (str != null) {
            return str;
        }
        str = String.valueOf((char) fVar.field_showHead);
        this.ugX.put(fVar.field_showHead, str);
        return str;
    }

    public int getCount() {
        return super.getCount();
    }

    private String getString(int i) {
        String str = (String) this.ugX.get(i);
        if (str != null) {
            return str;
        }
        str = this.context.getString(i);
        this.ugX.put(i, str);
        return str;
    }

    public final com.tencent.mm.bt.a.d<String> coW() {
        return (com.tencent.mm.bt.a.d) cxV();
    }

    public final ArrayList<com.tencent.mm.storage.f> ae(ArrayList<String> arrayList) {
        long currentTimeMillis = System.currentTimeMillis();
        List arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            arrayList2.add((String) arrayList.get(i2));
            i = i2 + 1;
        }
        ArrayList<com.tencent.mm.storage.f> arrayList3 = new ArrayList(arrayList2.size());
        au.HU();
        Cursor dg = c.FR().dg(arrayList2);
        while (dg.moveToNext()) {
            com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
            fVar.d(dg);
            arrayList3.add(fVar);
        }
        dg.close();
        x.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList3;
    }

    public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> hashSet, SparseArray<String>[] sparseArrayArr) {
        SparseArray<String>[] sparseArrayArr2 = new SparseArray[sparseArrayArr.length];
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        long currentTimeMillis = System.currentTimeMillis();
        au.HU();
        Cursor b = c.FR().b(this.ugF, this.ugG, this.gRN, linkedList, cxU(), this.ugR);
        int i;
        if (b instanceof e) {
            com.tencent.mm.bt.a.d[] dVarArr = ((e) b).ter;
            int length = dVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                dVarArr[i2].Dz(TbsReaderView$ReaderCallback.GET_BAR_ANIMATING);
                sparseArrayArr2[i2] = new SparseArray();
                i = 0;
                while (dVarArr[i2].moveToNext()) {
                    sparseArrayArr2[i2].put(i, dVarArr[i2].getString(0));
                    i++;
                }
            }
            this.ugO = dVarArr[0].getCount();
        } else {
            sparseArrayArr2[0] = new SparseArray();
            i = 0;
            while (b.moveToNext()) {
                sparseArrayArr2[0].put(i, b.getString(0));
                i++;
            }
        }
        b.close();
        x.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - currentTimeMillis));
        return sparseArrayArr2;
    }

    public final void cxY() {
        super.q(null, 1);
    }

    public void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        au.HU();
        if (mVar != c.FR()) {
            return;
        }
        if (s.hd((String) obj) || this.ugZ.contains((String) obj)) {
            x.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
            return;
        }
        super.q((String) obj, 2);
        if (this.ugS && this.ugM != null) {
            this.ugM.uhx = true;
            x.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
        }
    }
}
