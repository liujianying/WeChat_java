package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader extends LinearLayout {
    boolean bNu = false;
    String cXR;
    Context context;
    private Dialog jJX;
    c nWh;
    private a nWi;
    private b nWj;
    private boolean nWk = false;
    private Map<Integer, View> nWl = new HashMap();
    private String nWm = "";
    Bitmap nWn = null;
    private int type;
    String userName;

    class c {
        ImageView eBM;
        TextView haS;
        TextView nLj;
        ImageView nWt;
        ImageView nWu;
        LinearLayout nWv;
        LinearLayout nWw;

        c() {
        }
    }

    public void setHeadBgListener(b bVar) {
        this.nWj = bVar;
    }

    public SnsHeader(Context context) {
        super(context);
        init(context);
    }

    public SnsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void setType(int i) {
        this.type = i;
        if (i == 1 && this.nWh.nLj != null) {
            this.nWh.nLj.setVisibility(8);
        }
    }

    private void init(Context context) {
        this.context = context;
        View inflate = y.gq(context).inflate(g.sns_header_item2, this, true);
        this.nWh = new c();
        this.nWh.haS = (TextView) inflate.findViewById(f.nickname_tv);
        this.nWh.eBM = (ImageView) inflate.findViewById(f.avatar_iv);
        this.nWh.nLj = (TextView) inflate.findViewById(f.sign_tv);
        this.nWh.nWt = (ImageView) inflate.findViewById(f.sns_back_ll);
        this.nWh.nWu = (ImageView) inflate.findViewById(f.sns_back_mask);
        this.nWh.nWv = (LinearLayout) inflate.findViewById(f.setting_bg);
        this.nWh.nWw = (LinearLayout) inflate.findViewById(f.sns_error_list);
        this.nWh.nWt.setContentDescription(context.getString(j.sns_background_desc));
        this.nWh.nWt.setOnClickListener(new 1(this, context));
        this.nWh.eBM.setOnClickListener(new 2(this, context));
    }

    public void setAvatarOnClickListener(OnClickListener onClickListener) {
        if (this.nWh != null && this.nWh.eBM != null) {
            this.nWh.eBM.setOnClickListener(onClickListener);
        }
    }

    public final void bDn() {
        String str;
        Bitmap a;
        String str2 = this.userName;
        if (this.type == 1) {
            str2 = this.cXR;
        }
        String accSnsPath = af.getAccSnsPath();
        x.d("MicroMsg.SnsHeader", "MagicAsyncTask " + str2);
        l Np = af.bys().Np(str2);
        String str3 = Np.field_bgId;
        x.d("MicroMsg.SnsHeader", "showName " + str2 + " get bgId : " + str3 + "  olderBgId：　" + Np.field_older_bgId);
        String LC = i.LC(str3);
        String str4 = str2 + "bg_";
        String str5 = str2 + "tbg_";
        String s = an.s(accSnsPath, str2);
        FileOp.mL(s);
        if ((Np.field_local_flag & 1) > 0) {
            x.d("MicroMsg.SnsHeader", "bg is change");
            af.bys().No(str2);
            if (FileOp.cn(an.s(accSnsPath, str2) + str4)) {
                FileOp.deleteFile(an.s(accSnsPath, str2) + str5);
                FileOp.i(an.s(accSnsPath, str2), str4, str5);
            }
            Np.field_local_flag &= -2;
            af.bys().c(Np);
        }
        if (FileOp.cn(an.s(af.getAccSnsPath(), str3) + LC) && !FileOp.cn(an.s(accSnsPath, str2) + str4)) {
            FileOp.y(an.s(accSnsPath, str3) + LC, an.s(accSnsPath, str2) + str4);
            x.d("MicroMsg.SnsHeader", "nwer id Name update");
        }
        accSnsPath = Np.field_bgUrl;
        if (str3 != null) {
            af.byl();
            str = s + str4;
            this.context.hashCode();
            a = com.tencent.mm.plugin.sns.model.g.a(str, accSnsPath, str3, true, av.tbu);
            x.d("MicroMsg.SnsHeader", "set a new bg");
            if (a == null) {
                FileOp.deleteFile(s + str4);
            }
        } else {
            a = null;
        }
        if (a == null && str3 != null) {
            af.byl();
            str = s + str5;
            this.context.hashCode();
            a = com.tencent.mm.plugin.sns.model.g.a(str, accSnsPath, str3, false, av.tbu);
        }
        if (this.nWh.nWt != null) {
            this.nWh.nWt.setImageBitmap(a);
            if (a != null) {
                this.nWh.nWt.setBackgroundDrawable(null);
            } else {
                try {
                    if (this.nWn == null || this.nWn.isRecycled()) {
                        x.i("MicroMsg.SnsHeader", "decode bitmap by self");
                        this.nWn = com.tencent.mm.sdk.platformtools.c.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
                    }
                    this.nWh.nWt.setBackgroundDrawable(new BitmapDrawable(this.nWn));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsHeader", e, "", new Object[0]);
                }
            }
        }
        this.nWh.nWv.setVisibility(8);
        if (a == null && (this.type == 1 || this.cXR.equals(str2))) {
            this.nWh.nWv.setVisibility(0);
        }
        this.nWk = Np.bAT();
        if (this.nWj != null) {
            this.nWj.K(a);
            if (a != null) {
                int fromDPToPix = a.fromDPToPix(this.context, 65);
                if (fromDPToPix > a.getHeight()) {
                    fromDPToPix = a.getHeight();
                }
                3 3 = new 3(this, com.tencent.mm.an.c.s(Bitmap.createBitmap(a, 0, 0, a.getWidth(), fromDPToPix))[0]);
                Drawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(3);
                this.nWh.nWu.setBackground(paintDrawable);
            }
        }
    }

    public void setBackClickListener(a aVar) {
        this.nWi = aVar;
    }

    public final boolean bDo() {
        if (this.nWh.nWw == null) {
            return false;
        }
        int i;
        List byH = aj.byH();
        List linkedList = new LinkedList();
        for (i = 0; i < byH.size(); i++) {
            n nVar = (n) byH.get(i);
            try {
                if (((atf) new atf().aG(nVar.field_postBuf)).rWs) {
                }
            } catch (Exception e) {
            }
            linkedList.add(nVar);
        }
        String str = "";
        i = 0;
        while (i < linkedList.size()) {
            String str2;
            try {
                if (((atf) new atf().aG(((n) linkedList.get(i)).field_postBuf)).rWs) {
                    str2 = str;
                    i++;
                    str = str2;
                }
            } catch (Exception e2) {
            }
            str2 = str + ((n) linkedList.get(i)).bBe() + " ";
            i++;
            str = str2;
        }
        x.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[]{Integer.valueOf(linkedList.size()), str, this.nWm});
        if (!str.equals(this.nWm)) {
            this.nWm = str;
            this.nWh.nWw.removeAllViews();
            this.nWh.nWw.setVisibility(linkedList.size() > 0 ? 0 : 8);
            Collections.sort(linkedList, new d(this));
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                LinearLayout linearLayout;
                View linearLayout2;
                int i3 = ((n) linkedList.get(i2)).nJc;
                i = linkedList.size();
                if (!this.nWl.containsKey(Integer.valueOf(i3)) || this.nWl.get(Integer.valueOf(i3)) == null) {
                    linearLayout2 = (LinearLayout) y.gq(this.context).inflate(g.header_error_list, null);
                    linearLayout2.getChildAt(0).setOnClickListener(new 4(this, i, i2));
                    this.nWl.put(Integer.valueOf(i3), linearLayout2);
                } else {
                    linearLayout2 = (View) this.nWl.get(Integer.valueOf(i3));
                }
                linearLayout2 = (LinearLayout) linearLayout2;
                linearLayout2.getChildAt(0).setTag(((n) linkedList.get(i2)).bBe());
                TextView textView = (TextView) linearLayout2.findViewById(f.sns_notify_tips2);
                if (((n) linkedList.get(i2)).field_type == 15) {
                    textView.setText(j.sns_post_sight_error);
                } else {
                    textView.setTag(Integer.valueOf(j.sns_post_error));
                }
                this.nWh.nWw.addView(linearLayout2);
            }
            if (linkedList.size() > 0) {
                return true;
            }
            return false;
        } else if (linkedList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
