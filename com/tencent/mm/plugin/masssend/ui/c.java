package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c extends r<a> {
    private static short laI = (short) 1;
    private static short laJ = (short) 2;
    private static short laK = (short) 3;
    private static short laL = (short) 4;
    private MMActivity bGc;
    private LayoutInflater eMa;
    int edl;
    int hFO;
    private short[] laM;
    private List<String> laN;
    String laO = "";
    e laP;

    public c(Context context) {
        super(context, new a());
        this.bGc = (MMActivity) context;
        this.laN = new LinkedList();
        this.hFO = 10;
        this.edl = this.hFO;
        this.eMa = y.gq(context);
    }

    protected final void WS() {
        WT();
    }

    public final boolean ayQ() {
        return this.hFO >= this.edl;
    }

    public final void WT() {
        int i;
        Cursor b = h.bco().dCZ.b("SELECT count(*) FROM massendinfo", null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        } else {
            i = 0;
        }
        b.close();
        this.edl = i;
        b bco = h.bco();
        int i2 = this.hFO;
        String str = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + i2 + " offset (SELECT count(*) FROM massendinfo ) -" + i2;
        x.v("MicroMsg.MasSendInfoStorage", "getCursor sql:" + str);
        setCursor(bco.dCZ.b(str, null, 0));
        i = getCount();
        if (i > 0) {
            this.laM = new short[i];
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        a aVar;
        CharSequence charSequence;
        int i2;
        a aVar2 = (a) getItem(i);
        if (i != 0) {
            long j = ((a) getItem(i - 1)).createTime;
            aVar2 = (a) getItem(i);
            long j2 = aVar2.createTime;
            obj = j2 - j < 60000 ? 1 : null;
            Object obj2 = (j2 - j) / 180000 < 1 ? 1 : null;
            if (obj == null && obj2 == null) {
                this.laM[i] = (short) 1;
                aVar = aVar2;
            } else {
                this.laM[i] = (short) 2;
                aVar = aVar2;
            }
        } else {
            this.laM[i] = (short) 1;
            aVar = aVar2;
        }
        obj = (this.laM[i] != (short) 1 || aVar.createTime <= 1000) ? null : 1;
        f fVar;
        switch (aVar.msgType) {
            case 1:
                fVar = new f();
                if (view == null || ((f) view.getTag()).laY != laI) {
                    view = this.eMa.inflate(R.i.mass_send_item_text, null);
                    fVar.laR = (TextView) view.findViewById(R.h.mass_send_item_contact_count);
                    fVar.laS = (TextView) view.findViewById(R.h.mass_send_item_text_contact);
                    fVar.laT = (TextView) view.findViewById(R.h.mass_send_item_text_content);
                    fVar.laV = (TextView) view.findViewById(R.h.mass_send_item_compose);
                    fVar.jWm = (TextView) view.findViewById(R.h.mass_send_itme_time_tv);
                    fVar.laX = view.findViewById(R.h.mass_send_item_contact_area);
                    fVar.laY = laI;
                    view.setTag(fVar);
                    break;
                }
            case 3:
                fVar = new f();
                if (view == null || ((f) view.getTag()).laY != laJ) {
                    view = this.eMa.inflate(R.i.mass_send_item_img, null);
                    fVar.laR = (TextView) view.findViewById(R.h.mass_send_item_contact_count);
                    fVar.laS = (TextView) view.findViewById(R.h.mass_send_item_text_contact);
                    fVar.iYZ = (ImageView) view.findViewById(R.h.mass_send_item_thumb);
                    fVar.laV = (TextView) view.findViewById(R.h.mass_send_item_compose);
                    fVar.jWm = (TextView) view.findViewById(R.h.mass_send_itme_time_tv);
                    fVar.laX = view.findViewById(R.h.mass_send_item_contact_area);
                    fVar.laY = laJ;
                    view.setTag(fVar);
                    break;
                }
            case 34:
                fVar = new f();
                if (view == null || ((f) view.getTag()).laY != laL) {
                    view = this.eMa.inflate(R.i.mass_send_item_voice, null);
                    fVar.laR = (TextView) view.findViewById(R.h.mass_send_item_contact_count);
                    fVar.laS = (TextView) view.findViewById(R.h.mass_send_item_text_contact);
                    fVar.laU = (TextView) view.findViewById(R.h.mass_send_item_length);
                    fVar.laT = (TextView) view.findViewById(R.h.mass_send_item_voice_content);
                    fVar.laW = (AnimImageView) view.findViewById(R.h.mass_send_item_voice_anim);
                    fVar.laV = (TextView) view.findViewById(R.h.mass_send_item_compose);
                    fVar.jWm = (TextView) view.findViewById(R.h.mass_send_itme_time_tv);
                    fVar.laX = view.findViewById(R.h.mass_send_item_contact_area);
                    fVar.laY = laL;
                    view.setTag(fVar);
                    break;
                }
            case f$k.AppCompatTheme_dialogPreferredPadding /*43*/:
                fVar = new f();
                if (view == null || ((f) view.getTag()).laY != laK) {
                    view = this.eMa.inflate(R.i.mass_send_item_video, null);
                    fVar.laR = (TextView) view.findViewById(R.h.mass_send_item_contact_count);
                    fVar.laS = (TextView) view.findViewById(R.h.mass_send_item_text_contact);
                    fVar.iYZ = (ImageView) view.findViewById(R.h.mass_send_item_thumb);
                    fVar.laU = (TextView) view.findViewById(R.h.mass_send_item_video_length);
                    fVar.laV = (TextView) view.findViewById(R.h.mass_send_item_compose);
                    fVar.jWm = (TextView) view.findViewById(R.h.mass_send_itme_time_tv);
                    fVar.laX = view.findViewById(R.h.mass_send_item_contact_area);
                    fVar.laY = laK;
                    view.setTag(fVar);
                    break;
                }
        }
        f fVar2 = (f) view.getTag();
        if (obj != null) {
            fVar2.jWm.setVisibility(0);
            fVar2.jWm.setText(com.tencent.mm.pluginsdk.f.h.c(this.bGc, aVar.createTime, false));
        } else {
            fVar2.jWm.setVisibility(8);
        }
        switch (aVar.msgType) {
            case 1:
                fVar2 = (f) view.getTag();
                fVar2.laT.setText(aVar.bch());
                j.g(fVar2.laT, 1);
                break;
            case 3:
                fVar2 = (f) view.getTag();
                au.HU();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    h.bco();
                    Bitmap Gh = b.Gh(aVar.bch());
                    if (Gh != null) {
                        fVar2.iYZ.setImageBitmap(Gh);
                    } else {
                        h.bco();
                        fVar2.iYZ.setImageBitmap(b.d(aVar.bci(), com.tencent.mm.bp.a.getDensity(fVar2.iYZ.getContext())));
                    }
                } else {
                    fVar2.iYZ.setImageDrawable(com.tencent.mm.bp.a.f(this.bGc, R.g.nosdcard_chatting_bg));
                }
                fVar2.iYZ.setOnClickListener(new a(this, aVar.bch(), aVar.lao));
                break;
            case 34:
                fVar2 = (f) view.getTag();
                float bD = q.bD((long) aVar.lal);
                if (aVar.bcg().equals(this.laO)) {
                    fVar2.laW.setVisibility(0);
                    fVar2.laW.cre();
                    fVar2.laT.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    fVar2.laW.setVisibility(8);
                    fVar2.laW.bqN();
                    fVar2.laT.setCompoundDrawablesWithIntrinsicBounds(null, null, this.bGc.getResources().getDrawable(R.k.chatto_voice_playing), null);
                }
                fVar2.laU.setText(this.bGc.getString(R.l.fmt_time_length, new Object[]{Integer.valueOf((int) bD)}));
                fVar2.laT.setWidth(com.tencent.mm.bp.a.fromDPToPix(fVar2.laT.getContext(), nr((int) bD)));
                fVar2.laW.setWidth(com.tencent.mm.bp.a.fromDPToPix(fVar2.laT.getContext(), nr((int) bD)));
                fVar2.laT.setOnClickListener(new d(this, aVar.bcg()));
                break;
            case f$k.AppCompatTheme_dialogPreferredPadding /*43*/:
                f fVar3 = (f) view.getTag();
                o.Ta();
                Bitmap a = com.tencent.mm.ak.o.Pf().a(s.nL(aVar.bch()), com.tencent.mm.bp.a.getDensity(fVar3.iYZ.getContext()), this.bGc);
                if (a == null) {
                    au.HU();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        fVar3.iYZ.setImageDrawable(com.tencent.mm.bp.a.f(this.bGc, R.e.grey_color_01));
                    } else {
                        fVar3.iYZ.setImageDrawable(com.tencent.mm.bp.a.f(this.bGc, R.k.video_no_sd_icon));
                    }
                } else {
                    fVar3.iYZ.setImageBitmap(a);
                }
                fVar3.iYZ.setOnClickListener(new c(this, aVar.bch(), aVar.videoSource, aVar.bxj, aVar.lal));
                if (aVar.videoSource != 2) {
                    fVar3.laU.setVisibility(0);
                    fVar3.laU.setText(bi.iR(aVar.lal));
                    break;
                }
                fVar3.laU.setVisibility(8);
                break;
        }
        fVar2 = (f) view.getTag();
        fVar2.laR.setText(this.bGc.getResources().getQuantityString(R.j.mass_send_contact_count, aVar.lak, new Object[]{Integer.valueOf(aVar.lak)}));
        if (this.laN.contains(aVar.bcg())) {
            fVar2.laS.setSingleLine(false);
            fVar2.laS.setEllipsize(null);
        } else {
            fVar2.laS.setSingleLine(true);
            fVar2.laS.setEllipsize(TruncateAt.END);
        }
        TextView textView = fVar2.laS;
        MMActivity mMActivity = this.bGc;
        ArrayList arrayList = new ArrayList();
        if (aVar.bcj() == null || aVar.bcj().equals("")) {
            charSequence = "";
        } else {
            List F;
            String[] split = aVar.bcj().split(";");
            if (split == null || split.length <= 0) {
                Object F2 = arrayList;
            } else {
                F2 = bi.F(split);
            }
            if (F2 == null) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < F2.size()) {
                        String gT = com.tencent.mm.model.r.gT((String) F2.get(i3));
                        if (i3 == F2.size() - 1) {
                            stringBuilder.append(gT);
                        } else {
                            stringBuilder.append(gT + ", ");
                        }
                        i2 = i3 + 1;
                    } else {
                        charSequence = stringBuilder.toString();
                    }
                }
            }
        }
        textView.setText(j.a(mMActivity, charSequence, fVar2.laS.getTextSize()));
        i2 = (int) fVar2.laS.getTextSize();
        String charSequence2 = fVar2.laS.getText().toString();
        com.tencent.mm.bp.a.fromDPToPix(this.bGc, 255);
        Paint paint = new Paint();
        paint.setTextSize((float) i2);
        paint.measureText(charSequence2);
        fVar2.laV.setOnClickListener(new b(this, aVar.bcg()));
        return view;
    }

    public final void Gl(String str) {
        this.laO = str;
        notifyDataSetChanged();
    }

    private static int nr(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return 204;
    }
}
