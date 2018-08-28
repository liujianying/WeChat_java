package com.tencent.mm.plugin.shake.ui;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.design.a$i;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.c;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelbase.BaseResp.ErrCode;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.r;

class ShakeItemListUI$a extends r<d> {
    b eKg = new b(new a() {
        public final Bitmap pv(String str) {
            return c.a(str, false, -1);
        }
    });
    private b.b eKh = null;
    final /* synthetic */ ShakeItemListUI mZA;
    private int showType = 0;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        d dVar = (d) obj;
        if (dVar == null) {
            dVar = new d();
        }
        if (cursor != null) {
            dVar.d(cursor);
        }
        return dVar;
    }

    public ShakeItemListUI$a(ShakeItemListUI shakeItemListUI, ShakeItemListUI shakeItemListUI2) {
        this.mZA = shakeItemListUI;
        super(shakeItemListUI2, new d());
        WS();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.eKh == null) {
            this.eKh = new 2(this);
        }
        if (this.eKg != null) {
            this.eKg.a(i, this.eKh);
        }
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.context, R.i.shake_friend_item, null);
            aVar.eKk = (ImageView) view.findViewById(R.h.nearby_friend_avatar_iv);
            aVar.eIz = (TextView) view.findViewById(R.h.nearby_friend_name);
            aVar.eKl = (TextView) view.findViewById(R.h.nearby_friend_is_friend);
            aVar.mZF = (ImageView) view.findViewById(R.h.nearby_friend_sex);
            aVar.lCl = (TextView) view.findViewById(R.h.nearby_friend_distance);
            aVar.lCm = (TextView) view.findViewById(R.h.nearby_friend_sign);
            aVar.lCn = (ImageView) view.findViewById(R.h.nearby_friend_vuserinfo);
            aVar.mZG = (TextView) view.findViewById(R.h.shake_tran_img_listitem_title);
            aVar.mZE = view.findViewById(R.h.right_span);
            aVar.mZH = (LinearLayout) view.findViewById(R.h.shake_item_desc);
            aVar.mZI = (TextView) view.findViewById(R.h.shake_item_simple_desc);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        d dVar = (d) getItem(i);
        if (dVar != null) {
            aVar.clear();
            if (4 == dVar.field_type || (k.vY(dVar.field_type) && 6 != dVar.field_type)) {
                if (4 != dVar.field_type) {
                    aVar.eKk.setScaleType(ScaleType.CENTER_CROP);
                }
                e.a(aVar.eKk, dVar.field_sns_bgurl, R.k.app_attach_file_icon_webpage, false);
            } else if (11 == dVar.field_type) {
                ShakeItemListUI.g(this.mZA).a(dVar.getProvince(), aVar.eKk);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eKk, dVar.field_username);
            }
            aVar.eKk.setVisibility(0);
            if (7 != dVar.field_type && 10 != dVar.field_type && 12 != dVar.field_type && 13 != dVar.field_type && (8 != dVar.field_type || !bi.oW(dVar.field_nickname) || !bi.oW(dVar.field_username))) {
                aVar.mZI.setVisibility(8);
                aVar.mZH.setVisibility(0);
                if (8 == dVar.field_type && bi.oW(dVar.field_nickname)) {
                    dVar.field_nickname = dVar.field_distance;
                    dVar.field_distance = dVar.field_username;
                }
                aVar.eIz.setText(j.a(this.context, bi.oV(dVar.field_nickname), aVar.eIz.getTextSize()));
                aVar.eIz.setVisibility(0);
                int paddingBottom = view.getPaddingBottom();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingLeft = view.getPaddingLeft();
                if (dVar.field_insertBatch == 2) {
                    view.setBackgroundDrawable(com.tencent.mm.bp.a.f(this.context, R.g.comm_item_highlight_selector));
                } else {
                    view.setBackgroundDrawable(com.tencent.mm.bp.a.f(this.context, R.g.comm_list_item_selector));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                switch (dVar.field_type) {
                    case 1:
                    case 2:
                    case 3:
                        aVar.mZG.setText(dVar.field_nickname);
                        aVar.mZG.setVisibility(0);
                        break;
                    default:
                        aVar.mZE.setVisibility(0);
                        aVar.lCl.setText(dVar.field_distance);
                        aVar.lCl.setVisibility(0);
                        if (dVar.field_signature == null || dVar.field_signature.trim().equals("")) {
                            aVar.lCm.setVisibility(8);
                        } else {
                            aVar.lCm.setVisibility(0);
                            aVar.lCm.setText(j.a(this.context, dVar.field_signature, aVar.eIz.getTextSize()));
                        }
                        if (dVar.field_sex == 1) {
                            aVar.mZF.setVisibility(0);
                            aVar.mZF.setImageDrawable(com.tencent.mm.bp.a.f(this.context, R.k.ic_sex_male));
                            aVar.mZF.setContentDescription(this.context.getString(R.l.male_Imgbtn));
                        } else if (dVar.field_sex == 2) {
                            aVar.mZF.setVisibility(0);
                            aVar.mZF.setImageDrawable(com.tencent.mm.bp.a.f(this.context, R.k.ic_sex_female));
                            aVar.mZF.setContentDescription(this.context.getString(R.l.female_Imgbtn));
                        } else {
                            aVar.mZF.setVisibility(8);
                        }
                        au.HU();
                        ab Yg = com.tencent.mm.model.c.FR().Yg(dVar.field_username);
                        if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                            aVar.eKl.setVisibility(8);
                        } else {
                            aVar.eKl.setVisibility(0);
                            if (ab.Dk(dVar.field_reserved1)) {
                                aVar.eKl.setText(this.context.getString(R.l.nearby_friend_followed));
                            } else {
                                aVar.eKl.setText(this.context.getString(R.l.nearby_friend_is_contact));
                            }
                        }
                        if (6 == dVar.field_type) {
                            aVar.lCl.setText(this.context.getString(R.l.shake_history_biz_type_name));
                            aVar.eKl.setVisibility(8);
                        }
                        if (dVar.field_reserved1 == 0) {
                            aVar.lCn.setVisibility(8);
                            break;
                        }
                        aVar.lCn.setVisibility(0);
                        aVar.lCn.setImageBitmap(BackwardSupportUtil.b.e(am.a.dBt.gX(dVar.field_reserved1), 2.0f));
                        aVar.mZF.setVisibility(8);
                        break;
                        break;
                }
            }
            if (8 == dVar.field_type) {
                aVar.mZI.setText(dVar.field_distance);
            } else {
                aVar.mZI.setText(dVar.field_nickname);
            }
            aVar.mZI.setVisibility(0);
            aVar.mZH.setVisibility(8);
        } else {
            aVar.clear();
        }
        return view;
    }

    protected final void WS() {
        aYc();
        WT();
    }

    public final void WT() {
        if (au.HX()) {
            switch (this.showType) {
                case -12:
                    e buC = m.buC();
                    int intExtra = this.mZA.getIntent().getIntExtra("_ibeacon_new_insert_size", 2);
                    setCursor(buC.rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", new String[]{"11", String.valueOf(intExtra)}));
                    break;
                case ErrCode.ERR_BAN /*-6*/:
                    setCursor(m.buC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[]{"8", "2"}));
                    break;
                case ErrCode.ERR_UNSUPPORT /*-5*/:
                    setCursor(m.buC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[]{"4", "2"}));
                    break;
                case -1:
                    setCursor(m.buC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", new String[]{"0", "2"}));
                    break;
                case 0:
                    setCursor(m.buC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[]{"0"}));
                    break;
                case 4:
                    setCursor(m.buC().bur());
                    break;
                case 5:
                    setCursor(m.buC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", new String[]{"7", "6", "8", "9", "10", "12"}));
                    break;
                case 11:
                    setCursor(m.buC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[]{"11"}));
                    break;
                case a$i.AppCompatTheme_buttonStyle /*100*/:
                    setCursor(m.buC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]));
                    break;
            }
            super.notifyDataSetChanged();
        }
    }

    protected final void wa(int i) {
        this.showType = i;
        WS();
    }
}
