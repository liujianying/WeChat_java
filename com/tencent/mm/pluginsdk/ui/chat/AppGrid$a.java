package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.List;
import java.util.Map;

class AppGrid$a extends BaseAdapter {
    List<f> eul;
    final /* synthetic */ AppGrid qKa;
    private int qKb;
    private int qKc;
    private Map<String, f> qKd = null;

    public AppGrid$a(AppGrid appGrid, Context context, List<f> list, Map<String, f> map) {
        this.qKa = appGrid;
        this.eul = list;
        this.qKd = map;
        this.qKb = b.b(context, 56.0f);
        this.qKc = b.b(context, 53.3f);
    }

    public final int getCount() {
        if (AppGrid.a(this.qKa) == AppGrid.e(this.qKa) - 1) {
            return AppGrid.f(this.qKa) - (AppGrid.a(this.qKa) * AppGrid.b(this.qKa));
        }
        return AppGrid.b(this.qKa);
    }

    /* renamed from: xV */
    public final f getItem(int i) {
        if ((i < AppGrid.g(this.qKa) && AppGrid.a(this.qKa) == 0) || (AppGrid.a(this.qKa) * AppGrid.b(this.qKa)) + i < AppGrid.g(this.qKa) || (i - AppGrid.g(this.qKa)) + (AppGrid.a(this.qKa) * AppGrid.b(this.qKa)) >= this.eul.size()) {
            return null;
        }
        x.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[]{Integer.valueOf((i - AppGrid.g(this.qKa)) + (AppGrid.a(this.qKa) * AppGrid.b(this.qKa)))});
        return (f) this.eul.get((i - AppGrid.g(this.qKa)) + (AppGrid.a(this.qKa) * AppGrid.b(this.qKa)));
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(AppGrid.h(this.qKa), R.i.app_grid_item, null);
            aVar.gwj = (ImageView) view.findViewById(R.h.app_grid_item_icon);
            aVar.mVQ = view.findViewById(R.h.app_grid_item_icon_mask);
            aVar.gwk = (TextView) view.findViewById(R.h.app_grid_item_name);
            aVar.qKe = (TextView) view.findViewById(R.h.app_grid_item_new_icon);
            aVar.qKf = view.findViewById(R.h.app_grid_item_red_icon);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        x.v("MicroMsg.AppGrid", "pos:" + i + " page:" + AppGrid.a(this.qKa));
        aVar.gwk.setVisibility(0);
        aVar.qKf.setVisibility(8);
        aVar.qKe.setVisibility(8);
        aVar.mVQ.setVisibility(0);
        LayoutParams layoutParams = aVar.gwj.getLayoutParams();
        layoutParams.width = this.qKb;
        layoutParams.height = this.qKb;
        aVar.gwj.setLayoutParams(layoutParams);
        int a = (AppGrid.a(this.qKa) * AppGrid.b(this.qKa)) + i;
        int Cf = AppGrid.c(this.qKa).Cf(a);
        if (a < AppGrid.g(this.qKa)) {
            switch (Cf) {
                case 0:    //相册
                    aVar.gwj.setImageResource(R.k.panel_icon_pic);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_new_pic));
                    break;
                case 1:   //拍照
                    if (!af.eyg) {
                        aVar.gwj.setImageResource(R.k.panel_icon_camera);
                        aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_mmsight));
                        break;
                    }
                    aVar.gwj.setImageResource(R.k.panel_icon_sights);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_sight));
                    break;
                case 2:   //视频通话
                    aVar.gwj.setImageResource(R.k.app_panel_voice_icon);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_voip));
                    try {
                        au.HU();
                        if (!((Boolean) c.DT().get(54, Boolean.valueOf(false))).booleanValue()) {
                            aVar.qKe.setVisibility(8);
                            break;
                        }
                        aVar.qKe.setVisibility(0);
                        break;
                    } catch (Exception e) {
                        break;
                    }
                case 3:   //语音通话
                    aVar.gwj.setImageResource(R.k.panel_icon_multitalk);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_voipaudio));
                    try {
                        au.HU();
                        if (!((Boolean) c.DT().get(81, Boolean.valueOf(false))).booleanValue()) {
                            aVar.qKe.setVisibility(8);
                            break;
                        }
                        aVar.qKe.setVisibility(0);
                        break;
                    } catch (Exception e2) {
                        break;
                    }
                case 4:
                    aVar.gwj.setImageResource(R.k.panel_icon_voipvoice);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_voipaudio));
                    try {
                        au.HU();
                        if (!((Boolean) c.DT().get(62, Boolean.valueOf(false))).booleanValue()) {
                            aVar.qKe.setVisibility(8);
                            break;
                        }
                        aVar.qKe.setVisibility(0);
                        break;
                    } catch (Exception e3) {
                        break;
                    }
                case 5:   //实时对讲
                    aVar.gwj.setImageResource(R.k.panel_icon_wxtalk);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_talkroom));
                    try {
                        au.HU();
                        if (!((Boolean) c.DT().get(67, Boolean.valueOf(false))).booleanValue()) {
                            aVar.qKe.setVisibility(8);
                            break;
                        }
                        aVar.qKe.setVisibility(0);
                        break;
                    } catch (Exception e4) {
                        break;
                    }
                case 6:  //位置
                    aVar.gwj.setImageResource(R.k.panel_icon_location);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_location));
                    try {
                        au.HU();
                        if (!((Boolean) c.DT().get(290817, Boolean.valueOf(false))).booleanValue()) {
                            aVar.qKf.setVisibility(8);
                            break;
                        }
                        aVar.qKf.setVisibility(0);
                        break;
                    } catch (Exception e5) {
                        break;
                    }
                case 7:
                    a(aVar, f.qzG);
                    break;
                case 8:
                    a(aVar, f.qzE);
                    break;
                case 9:
                    a(aVar, f.qzH);
                    break;
                case 10:   //语音输入
                    aVar.gwj.setImageResource(R.k.panel_icon_voiceinput);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.hardcode_plugin_voiceinput_nick));
                    try {
                        au.HU();
                        if (!((Boolean) c.DT().get(73, Boolean.valueOf(false))).booleanValue()) {
                            aVar.qKe.setVisibility(8);
                            break;
                        }
                        aVar.qKe.setVisibility(0);
                        break;
                    } catch (Exception e6) {
                        break;
                    }
                case 11:   //名片
                    aVar.gwj.setImageResource(R.k.panel_icon_friendcard);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_card));
                    break;
                case 12:   //我的收藏
                    aVar.gwj.setImageResource(R.k.panel_icon_fav);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_favorite));
                    break;
                case 13:   //表情
                    aVar.gwj.setImageResource(R.k.app_panel_emoticon_icon);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.emoji_store_title));
                    try {
                        au.HU();
                        boolean booleanValue = ((Boolean) c.DT().get(208899, Boolean.valueOf(false))).booleanValue();
                        au.HU();
                        boolean booleanValue2 = ((Boolean) c.DT().get(208913, Boolean.valueOf(false))).booleanValue();
                        if (!booleanValue && !booleanValue2) {
                            aVar.qKe.setVisibility(8);
                            break;
                        }
                        aVar.qKe.setVisibility(0);
                        if (!booleanValue2) {
                            aVar.qKe.setText(R.l.app_new);
                            break;
                        }
                        aVar.qKe.setText(R.l.app_free);
                        break;
                    } catch (Exception e7) {
                        break;
                    }
                    break;
                case 14:  //服务
                    aVar.gwj.setImageResource(R.k.panel_icon_service);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_service));
                    try {
                        au.HU();
                        if (!((Boolean) c.DT().get(327744, Boolean.valueOf(true))).booleanValue()) {
                            aVar.qKf.setVisibility(8);
                            break;
                        }
                        aVar.qKf.setVisibility(0);
                        break;
                    } catch (Exception e8) {
                        break;
                    }
                case 15:   //企业应用
                    aVar.gwj.setImageResource(R.k.panel_icon_enterprise);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_enterprise_brand));
                    try {
                        aVar.qKf.setVisibility(8);
                        break;
                    } catch (Exception e9) {
                        break;
                    }
                case 16:   //文件
                    aVar.gwj.setImageResource(R.k.panel_icon_file_explorer);
                    aVar.gwk.setText(AppGrid.h(this.qKa).getString(R.l.app_field_file));
                    break;
            }
        }
        layoutParams.width = this.qKc;
        layoutParams.height = this.qKc;
        aVar.gwj.setLayoutParams(layoutParams);
        f xV = getItem(i);
        if (xV != null) {
            au.HU();
            if (c.isSDCardAvailable()) {
                Bitmap b;
                if (xV.field_status == 5) {
                    b = g.b(xV.field_appId, 3, a.getDensity(AppGrid.h(this.qKa)));
                } else if (xV.cbJ()) {
                    b = g.b(xV.field_appId, 4, a.getDensity(AppGrid.h(this.qKa)));
                } else {
                    b = g.b(xV.field_appId, 1, a.getDensity(AppGrid.h(this.qKa)));
                }
                if (b != null) {
                    aVar.gwj.setBackgroundDrawable(new BitmapDrawable(b));
                } else if (f.qzE.equals(xV.field_appId)) {
                    aVar.gwj.setImageResource(R.g.panel_icon_transfer);
                } else if (f.qzG.equals(xV.field_appId)) {
                    aVar.gwj.setImageResource(R.g.panel_icon_luckymoney);
                } else if (f.qzF.equals(xV.field_appId)) {
                    aVar.gwj.setImageResource(R.g.panel_icon_card);
                } else if (f.qzH.equals(xV.field_appId)) {
                    aVar.gwj.setImageResource(R.k.panel_icon_aa);
                } else {
                    aVar.gwj.setBackgroundResource(R.g.app_panel_icon_unknowed);
                }
            } else {
                aVar.gwj.setBackgroundResource(R.g.sharemore_nosdcard_icon);
            }
            aVar.gwk.setText(g.b(AppGrid.h(this.qKa), xV, null));
            if ((xV.cbJ() && xV.cbK()) || xV.cbL()) {
                if (AppGrid.i(this.qKa) == null) {
                    AppGrid.a(this.qKa, AppGrid.h(this.qKa).getSharedPreferences(ad.chY(), 0));
                }
                if (AppGrid.i(this.qKa).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + xV.field_appId, true)) {
                    aVar.qKe.setVisibility(0);
                }
            }
        }
        f xV2 = getItem(i);
        if (xV2 != null && g.j(xV2)) {
            aVar.qKe.setVisibility(0);
        }
        return view;
    }

    private void a(a aVar, String str) {
        if (this.qKd == null) {
            x.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
            return;
        }
        f fVar = (f) this.qKd.get(str);
        if (fVar == null) {
            x.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
            return;
        }
        au.HU();
        if (c.isSDCardAvailable()) {
            Bitmap b;
            if (fVar.cbJ()) {
                b = g.b(fVar.field_appId, 4, a.getDensity(AppGrid.h(this.qKa)));
            } else {
                b = null;
            }
            if (b != null) {
                aVar.gwj.setBackgroundDrawable(new BitmapDrawable(b));
            } else if (f.qzE.equals(fVar.field_appId)) {
                aVar.gwj.setImageResource(R.g.panel_icon_transfer);
            } else if (f.qzG.equals(fVar.field_appId)) {
                aVar.gwj.setImageResource(R.g.panel_icon_luckymoney);
            } else if (f.qzF.equals(fVar.field_appId)) {
                aVar.gwj.setImageResource(R.g.panel_icon_card);
            } else if (f.qzH.equals(fVar.field_appId)) {
                aVar.gwj.setImageResource(R.k.panel_icon_aa);
            } else {
                aVar.gwj.setImageResource(R.g.app_panel_icon_unknowed);
            }
        } else {
            aVar.gwj.setImageResource(R.g.sharemore_nosdcard_icon);
        }
        aVar.gwk.setText(g.b(AppGrid.h(this.qKa), fVar, null));
        if (fVar.cbJ() && fVar.cbK()) {
            if (AppGrid.i(this.qKa) == null) {
                AppGrid.a(this.qKa, AppGrid.h(this.qKa).getSharedPreferences(ad.chY(), 0));
            }
            if (AppGrid.i(this.qKa).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                aVar.qKe.setVisibility(0);
            }
        }
        int intValue;
        if (f.qzE.equals(fVar.field_appId)) {
            au.HU();
            intValue = ((Integer) c.DT().get(aa.a.sTs, Integer.valueOf(0))).intValue();
            if (intValue > 1) {
                au.HU();
                if (!bi.F(((String) c.DT().get(aa.a.sVt, "")).split(";")).contains(String.valueOf(intValue))) {
                    aVar.qKe.setVisibility(0);
                }
            }
        } else if (f.qzG.equals(fVar.field_appId)) {
            au.HU();
            intValue = ((Integer) c.DT().get(aa.a.sTs, Integer.valueOf(0))).intValue();
            if (intValue > 1) {
                au.HU();
                if (!bi.F(((String) c.DT().get(aa.a.sVu, "")).split(";")).contains(String.valueOf(intValue))) {
                    aVar.qKe.setVisibility(0);
                }
            }
        }
    }
}
