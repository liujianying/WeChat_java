package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements e {
    private boolean bKE = true;
    Context mContext;
    private int njc = -1;
    protected Animation ntA;
    boolean ntB = false;
    int[] ntC = new int[]{j.sns_ad_abtest_001, j.sns_ad_abtest_002, j.sns_ad_abtest_003, j.sns_ad_abtest_004};
    private int[] ntD = new int[]{i.album_test_donotlook, i.album_test_unlike, i.album_test_open, i.album_test_close};
    private int[] ntE = this.ntC;
    private int[] ntF;
    private int[] ntG;
    Map<Long, b> ntH = new HashMap();
    private Map<Long, b> ntI = new HashMap();
    private HashSet<Long> ntJ = new HashSet();
    h ntK = null;
    private HashMap<Long, Boolean> ntL = new HashMap();
    public final int ntv = 14;
    private com.tencent.mm.plugin.sns.ui.b.b ntw;
    private FrameLayout ntx;
    AbsoluteLayout nty = null;
    protected Animation ntz;

    public final void a(int i, String str, long j, String str2, bsu bsu, boolean z, bf bfVar) {
        if (z && this.bKE && this.ntK != null && bfVar != null) {
            this.ntJ.add(Long.valueOf(j));
            this.ntI.put(Long.valueOf(j), new b(j, this.ntK.ntX, this.ntK.ntY, bfVar.bEC()));
        }
    }

    public final void a(int i, String str, long j, String str2, bsu bsu, boolean z) {
        if (z && this.bKE) {
            if (this.ntJ.contains(Long.valueOf(j))) {
                boolean z2 = false;
                if (this.ntL.containsKey(Long.valueOf(j))) {
                    z2 = ((Boolean) this.ntL.get(Long.valueOf(j))).booleanValue();
                }
                if (z2) {
                    b bVar = (b) this.ntI.get(Long.valueOf(j));
                    if (bVar != null) {
                        bVar.xP();
                    }
                }
            }
            this.ntI.remove(Long.valueOf(j));
            this.ntJ.remove(Long.valueOf(j));
        }
    }

    public final void a(b bVar) {
        this.ntH.remove(Long.valueOf(bVar.egG));
        bVar.xP();
    }

    public b(Context context, com.tencent.mm.plugin.sns.ui.b.b bVar, FrameLayout frameLayout) {
        g byg = af.byg();
        h hVar = new h();
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100007");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            if (ckq != null) {
                x.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + fJ.field_expId + " " + fJ.field_layerId + " " + fJ.field_startTime + " " + fJ.field_endTime);
                hVar.d(fJ.field_layerId, fJ.field_expId, ckq);
            }
        } else {
            x.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            hVar = null;
        }
        byg.nuM = hVar;
        this.ntK = af.byg().bzh();
        if (this.ntK != null) {
            this.ntF = this.ntK.nuO;
            if (!this.ntK.bzi()) {
                this.bKE = false;
            }
        }
        this.mContext = context;
        this.ntw = bVar;
        this.ntx = frameLayout;
        this.ntz = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.ntz = AnimationUtils.loadAnimation(context, a.dropdown_down);
        this.ntA = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.ntA = AnimationUtils.loadAnimation(context, a.dropdown_up);
    }

    public final int cA(View view) {
        if (this.ntB) {
            return 0;
        }
        if (this.nty != null) {
            if (this.nty.getTag() instanceof a) {
                View view2 = ((a) this.nty.getTag()).nid;
                this.ntB = true;
                view2.startAnimation(this.ntA);
                this.ntA.setAnimationListener(new 5(this, view2));
            } else {
                bzf();
            }
            return 0;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            return 0;
        } else {
            if (!this.bKE || this.ntK == null) {
                return 2;
            }
            int i;
            int i2;
            boolean z;
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            long j = bVar.nkI;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.nkH.oho;
            if (!this.ntL.containsKey(Long.valueOf(j))) {
                if (this.ntK != null) {
                    if (bVar2 != null) {
                        i = 0;
                        while (true) {
                            i2 = i;
                            if (i2 >= this.ntK.nuB.size()) {
                                this.ntL.put(Long.valueOf(j), Boolean.valueOf(true));
                                z = true;
                                break;
                            } else if (bi.oW(a((a) this.ntK.nuB.get(i2), bVar2.nzb))) {
                                this.ntL.put(Long.valueOf(j), Boolean.valueOf(false));
                                z = false;
                                break;
                            } else {
                                i = i2 + 1;
                            }
                        }
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
            } else {
                z = ((Boolean) this.ntL.get(Long.valueOf(j))).booleanValue();
            }
            if (!z) {
                return 2;
            }
            int i3;
            String str = bVar.bKW;
            this.ntH.put(Long.valueOf(bVar.nkI), new b(bVar.nkI, bVar.nkH.bEC(), this.ntK.ntX, this.ntK.ntY, this.mContext.getString(j.sns_ad_tip)));
            if (this.ntJ.contains(Long.valueOf(bVar.nkI))) {
                this.ntJ.remove(Long.valueOf(bVar.nkI));
            }
            this.nty = new AbsoluteLayout(this.mContext);
            this.nty.setId(f.address);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.ntx.addView(this.nty);
            View inflate = y.gq(this.mContext).inflate(g.adabtest_unlike_tip, null);
            r12 = new TextView[3];
            ImageView[] imageViewArr = new ImageView[]{(TextView) inflate.findViewById(f.ad_unlike_btn_one), (TextView) inflate.findViewById(f.ad_unlike_btn_two), (TextView) inflate.findViewById(f.ad_unlike_btn_three)};
            imageViewArr[0] = (ImageView) inflate.findViewById(f.ad_unlike_btn_right_one);
            imageViewArr[1] = (ImageView) inflate.findViewById(f.ad_unlike_btn_right_two);
            imageViewArr[2] = (ImageView) inflate.findViewById(f.ad_unlike_btn_right_three);
            i2 = 0;
            if (!u.eP(bVar.nkI)) {
                for (int i4 : this.ntF) {
                    if (i4 == 3) {
                        i2++;
                    }
                }
            }
            int i42 = 0;
            for (int i32 : this.ntF) {
                if (i32 == 0) {
                    i42++;
                }
            }
            if (i42 + i2 > 0) {
                i = (this.ntF.length - i42) - i2;
                if (i == 0) {
                    return 2;
                }
                this.ntG = new int[i];
            } else {
                this.ntG = new int[this.ntF.length];
            }
            i = 0;
            i42 = 0;
            while (i < this.ntF.length) {
                if (this.ntF[i] != 0 && (i2 <= 0 || this.ntF[i] != 3)) {
                    this.ntG[i42] = this.ntF[i];
                    i42++;
                }
                i++;
            }
            if (u.eO(bVar.nkI)) {
                for (i = 0; i < this.ntG.length; i++) {
                    if (this.ntG[i] == 3) {
                        this.ntG[i] = 4;
                        break;
                    }
                }
            }
            i2 = 0;
            int fromDPToPix = ((com.tencent.mm.bp.a.fromDPToPix(this.mContext, 12) * 2) + (com.tencent.mm.bp.a.fromDPToPix(this.mContext, 8) * 2)) + com.tencent.mm.bp.a.fromDPToPix(this.mContext, 12);
            i = 0;
            while (true) {
                int i5 = i;
                if (i5 >= this.ntG.length) {
                    break;
                }
                int i6;
                i42 = this.ntG[i5];
                i32 = this.ntG[i5] - 1;
                r12[i5].setText(this.ntE[i32]);
                TextView textView = r12[i5];
                Paint paint = new Paint();
                String charSequence = textView.getText().toString();
                paint.setTextSize(textView.getTextSize());
                i = ((int) paint.measureText(charSequence, 0, charSequence.length())) + fromDPToPix;
                if (i > i2) {
                    i6 = i;
                } else {
                    i6 = i2;
                }
                r12[i5].setCompoundDrawablePadding(com.tencent.mm.bp.a.fromDPToPix(this.mContext, 8));
                r12[i5].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.ntD[i32]), null, null, null);
                if (i32 == 1) {
                    imageViewArr[i5].setVisibility(0);
                } else {
                    imageViewArr[i5].setVisibility(8);
                }
                r12[i5].setTag(bVar);
                r12[i5].setOnClickListener(new 1(this, i42, bVar, inflate, view));
                i = i5 + 1;
                i2 = i6;
            }
            for (i = 0; i < this.ntG.length; i++) {
                r12[i].setMaxWidth(i2);
            }
            for (i = this.ntG.length; i < 3; i++) {
                r12[i].setVisibility(8);
            }
            Rect rect = new Rect();
            i = com.tencent.mm.pluginsdk.e.eK(this.mContext);
            int[] bED = bVar.nkH.bED();
            x.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + bED[0] + "  " + bED[1] + " height: " + i);
            i2 += com.tencent.mm.bp.a.fromDPToPix(this.mContext, 12);
            i32 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 17.0f);
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 2.0f);
            this.njc = com.tencent.mm.pluginsdk.e.eL(this.mContext);
            ViewGroup.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(i2, -2, (bED[0] - i2) - b, ((bED[1] - this.njc) - i) + i32);
            this.nty.setTag(new a(this, str, inflate, bVar.nkI, bVar.nkH.oho));
            this.nty.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.ntB = true;
            new ag().post(new 2(this, view, inflate));
            return 1;
        }
    }

    final void a(View view, AbsoluteLayout absoluteLayout, com.tencent.mm.plugin.sns.data.b bVar) {
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.removeAllViews();
        if (this.ntK != null && bVar.nkH != null && bVar.nkH.oho != null) {
            int i;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.nkH.oho;
            int i2 = 0;
            Paint paint = new Paint(1);
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 12.0f);
            int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 10.0f);
            int b3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 150.0f);
            List<TextView> linkedList = new LinkedList();
            float b4 = (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 17.0f)) * com.tencent.mm.bp.a.fe(this.mContext)) + ((float) (b2 * 2));
            int i3 = (int) b4;
            int i4 = 0;
            while (true) {
                i = i4;
                if (i >= this.ntK.nuB.size()) {
                    break;
                }
                a aVar = (a) this.ntK.nuB.get(i);
                final View textView = new TextView(this.mContext);
                textView.setPadding(b, b2, b, b2);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bp.a.fe(this.mContext));
                textView.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_abtest_unlike_text_color));
                Object a = a(aVar, bVar2.nzb);
                textView.setText(a);
                paint.setTextSize(textView.getTextSize());
                viewGroup.addView(textView);
                i2 = Math.max(i2, ((int) paint.measureText(a)) + (b * 2));
                textView.setTag(Integer.valueOf(i));
                linkedList.add(textView);
                final com.tencent.mm.plugin.sns.data.b bVar3 = bVar;
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b bVar = (b) b.this.ntH.get(Long.valueOf(bVar3.nkI));
                        int i = ((a) b.this.ntK.nuB.get(intValue)).ntq;
                        if (bVar != null) {
                            bVar.MM("3:" + i + ":" + textView.getText());
                        }
                        if (((a) b.this.ntK.nuB.get(intValue)).ntu == 1) {
                            Intent intent = new Intent();
                            intent.setClass(b.this.mContext, SnsCommentUI.class);
                            intent.putExtra("sns_comment_type", 2);
                            intent.putExtra("sns_id", bVar3.nkI);
                            intent.putExtra("sns_uxinfo", bVar.ntU);
                            intent.putExtra("action_st_time", bVar.ntV);
                            intent.putExtra("sns_actionresult", bVar.ntT.toString());
                            ((MMActivity) b.this.mContext).startActivity(intent);
                            b.this.ntH.remove(Long.valueOf(bVar3.nkI));
                            b.this.bzf();
                            return;
                        }
                        b.this.a(bVar);
                        b.this.bzf();
                    }
                });
                i4 = i + 1;
            }
            x.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i2 + " " + i3);
            if (i2 < b3) {
                i2 = b3;
            }
            for (TextView textView2 : linkedList) {
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                layoutParams.width = i2;
                layoutParams.height = (int) b4;
                textView2.setLayoutParams(layoutParams);
            }
            Rect rect = new Rect();
            int eK = com.tencent.mm.pluginsdk.e.eK(this.mContext);
            int[] bED = bVar.nkH.bED();
            i = (bED[0] - i2) - com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 2.0f);
            i4 = ((bED[1] - this.njc) - eK) + i3;
            bf bfVar = bVar.nkH;
            absoluteLayout.updateViewLayout(view, new AbsoluteLayout.LayoutParams(-2, -2, i, i4 - (bfVar.ohk != null ? bfVar.ohk.getHeight() : 0)));
        }
    }

    private static String a(a aVar, Map<String, String> map) {
        if (aVar == null) {
            return "";
        }
        String str;
        if (w.chM()) {
            str = aVar.ntr;
        } else if (w.chN()) {
            str = aVar.nts;
        } else {
            str = aVar.ntt;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return stringBuffer.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt == '$') {
                if (stringBuffer2.length() == 0) {
                    stringBuffer2.append(charAt);
                } else if (stringBuffer2.charAt(stringBuffer2.length() - 1) == '$') {
                    stringBuffer.append('$');
                    stringBuffer2 = new StringBuffer();
                } else {
                    String str2 = (String) map.get(stringBuffer2.substring(1));
                    if (str2 == null) {
                        return "";
                    }
                    stringBuffer.append(str2);
                }
            } else if (stringBuffer2.length() == 0) {
                stringBuffer.append(charAt);
            } else {
                stringBuffer2.append(charAt);
            }
            i = i2 + 1;
        }
    }

    public final boolean bzf() {
        boolean z = false;
        if (this.nty != null) {
            if (this.nty.getTag() instanceof a) {
                b bVar = (b) this.ntH.get(Long.valueOf(((a) this.nty.getTag()).nkI));
                if (bVar != null) {
                    boolean z2 = (bVar.ntT == null || bVar.ntT.length() == 0) ? false : true;
                    if (z2) {
                        if (!(bVar.ntT == null || bVar.ntT.length() == 0 || !bVar.ntT.toString().startsWith("1:0"))) {
                            z = true;
                        }
                        if (z) {
                            bVar.MM("2:0:");
                        }
                        a(bVar);
                    } else {
                        bVar.MM("2:0:");
                        a(bVar);
                    }
                }
            }
            this.ntx.removeView(this.nty);
            this.nty = null;
            return true;
        }
        this.ntB = false;
        return false;
    }
}
