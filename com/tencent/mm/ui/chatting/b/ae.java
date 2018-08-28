package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.Settings.Secure;
import android.support.design.a$i;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.b;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.x;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.tools.a.1;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;
import com.tencent.mm.ui.widget.a.c;
import java.util.ArrayList;

@a(cwo = x.class)
public class ae extends a implements i.a, x {
    private c lbj;

    public final boolean a(MenuItem menuItem, bd bdVar) {
        switch (menuItem.getItemId()) {
            case a$i.AppCompatTheme_spinnerStyle /*110*/:
                r.a(bdVar, this.bAG.tTq.getContext(), this.bAG);
                return true;
            default:
                return false;
        }
    }

    public final boolean f(int i, int i2, Intent intent) {
        int i3 = 1;
        this.bAG.dismissDialog();
        if (i2 != -1) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgComponent", "[dealWithRequestCode] resultCode:%d", new Object[]{Integer.valueOf(i2)});
            return false;
        }
        Intent intent2;
        String talkerUserName;
        switch (i) {
            case 200:
                if (intent == null) {
                    return true;
                }
                boolean z;
                intent2 = new Intent();
                intent2.setClassName(this.bAG.tTq.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                String str = "CropImage_Has_Raw_Img_Btn";
                talkerUserName = this.bAG.getTalkerUserName();
                if (talkerUserName == null || !(ab.XO(talkerUserName) || ab.XQ(talkerUserName))) {
                    z = true;
                } else {
                    z = false;
                }
                intent2.putExtra(str, z);
                intent2.putExtra("from_source", 3);
                e eVar = this.bAG.tTq;
                au.HU();
                str = com.tencent.mm.model.c.Gb();
                if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
                    new 1(intent, eVar, str, intent2).execute(new Integer[]{Integer.valueOf(0)});
                    return true;
                }
                str = com.tencent.mm.ui.tools.a.e(eVar.getContext(), intent, str);
                if (bi.oW(str)) {
                    return true;
                }
                intent2.putExtra("CropImage_ImgPath", str);
                eVar.startActivityForResult(intent2, b.CTRL_INDEX);
                return true;
            case 201:
                Context applicationContext = this.bAG.tTq.getContext().getApplicationContext();
                au.HU();
                talkerUserName = l.d(applicationContext, intent, com.tencent.mm.model.c.Gb());
                if (talkerUserName == null) {
                    return true;
                }
                intent2 = new Intent();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(talkerUserName);
                intent2.putExtra("query_source_type", 3);
                intent2.putExtra("preview_image", true);
                intent2.putExtra("isTakePhoto", true);
                intent2.putExtra("GalleryUI_FromUser", this.bAG.cwp());
                intent2.putExtra("GalleryUI_ToUser", this.bAG.getTalkerUserName());
                intent2.putExtra("is_long_click", true);
                intent2.putStringArrayListExtra("preview_image_list", arrayList);
                intent2.addFlags(67108864);
                d.a(this.bAG.tTq, "gallery", ".ui.GalleryEntryUI", intent2, 217);
                return true;
            case b.CTRL_INDEX /*203*/:
                m mVar = (m) this.bAG.O(m.class);
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                if (stringExtra != null) {
                    boolean a = q.a(stringExtra, this.bAG.getTalkerUserName(), intent.getBooleanExtra("CropImage_Compress_Img", true));
                    intent.getIntExtra("from_source", 0);
                    int intExtra = intent.getIntExtra("CropImage_rotateCount", 0);
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + intent.getIntExtra("from_source", 0));
                    if (!a) {
                        i3 = 0;
                    }
                    t(i3, intExtra, stringExtra);
                    mVar.cvb().clearFocus();
                    break;
                }
                mVar.cvb().clearFocus();
                return true;
            case 217:
                Intent intent3;
                if (intent == null) {
                    ArrayList lP = n.OW().lP(this.bAG.getTalkerUserName());
                    if (lP.size() > 0) {
                        intent = new Intent();
                        intent.putStringArrayListExtra("CropImage_OutputPath_List", lP);
                        lP = new ArrayList();
                        lP.add(Integer.valueOf(-1));
                        intent.putIntegerArrayListExtra("GalleryUI_ImgIdList", lP);
                        h.mEJ.a(594, 4, 1, true);
                        intent3 = intent;
                        if (intent3 == null) {
                            talkerUserName = intent3.getStringExtra("GalleryUI_ToUser");
                            String talkerUserName2 = bi.oW(talkerUserName) ? this.bAG.getTalkerUserName() : talkerUserName;
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[]{talkerUserName, this.bAG.getTalkerUserName()});
                            m mVar2 = (m) this.bAG.O(m.class);
                            mVar2.cvb().clearFocus();
                            mVar2.cvb().setBottomPanelVisibility(8);
                            DrawedCallBackLinearLayout drawedCallBackLinearLayout = (DrawedCallBackLinearLayout) this.bAG.findViewById(R.h.chatting_bg_ll);
                            if (drawedCallBackLinearLayout != null) {
                                drawedCallBackLinearLayout.setListener(new 1(this, intent3, talkerUserName2, mVar2, i));
                                break;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                        return true;
                    }
                }
                intent3 = intent;
                if (intent3 == null) {
                    talkerUserName = intent3.getStringExtra("GalleryUI_ToUser");
                    String talkerUserName22 = bi.oW(talkerUserName) ? this.bAG.getTalkerUserName() : talkerUserName;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", new Object[]{talkerUserName, this.bAG.getTalkerUserName()});
                    m mVar22 = (m) this.bAG.O(m.class);
                    mVar22.cvb().clearFocus();
                    mVar22.cvb().setBottomPanelVisibility(8);
                    DrawedCallBackLinearLayout drawedCallBackLinearLayout2 = (DrawedCallBackLinearLayout) this.bAG.findViewById(R.h.chatting_bg_ll);
                    if (drawedCallBackLinearLayout2 != null) {
                        drawedCallBackLinearLayout2.setListener(new 1(this, intent3, talkerUserName22, mVar22, i));
                        break;
                    }
                }
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                return true;
                break;
        }
        return false;
    }

    public final void a(SightCaptureResult sightCaptureResult) {
        String str = sightCaptureResult.lek;
        if (!bi.oW(str)) {
            try {
                boolean z = sightCaptureResult.led;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", new Object[]{str});
                au.DF().a(new com.tencent.mm.ak.l(z ? 2 : 1, q.GF(), this.bAG.getTalkerUserName(), str, 0, null, 0, "", "", true, R.g.chat_img_template), 0);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void t(int i, int i2, String str) {
        if (str == null || str.equals("") || !com.tencent.mm.a.e.cn(str)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
        } else if (!i.X(this.bAG.oLT)) {
            au.DF().a(new com.tencent.mm.ak.l(4, this.bAG.cwp(), this.bAG.getTalkerUserName(), str, i, null, i2, "", "", true, R.g.chat_img_template), 0);
            this.bAG.lT(true);
        }
    }

    public final boolean aS(bd bdVar) {
        if (!bdVar.ckA()) {
            return false;
        }
        au.HU();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (!this.bAG.getTalkerUserName().equals("medianote")) {
                au.HU();
                com.tencent.mm.model.c.FQ().b(new com.tencent.mm.aq.e(bdVar.field_talker, bdVar.field_msgSvrId));
            }
            ak.aI(bdVar);
            this.bAG.lT(true);
            return true;
        }
        s.gH(this.bAG.tTq.getContext());
        return true;
    }

    public final void a(ContextMenu contextMenu, int i, bd bdVar) {
        contextMenu.add(i, 100, 0, this.bAG.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_img));
        com.tencent.mm.ak.e eVar = null;
        if (bdVar.field_msgId > 0) {
            eVar = o.Pf().br(bdVar.field_msgId);
        }
        if ((eVar == null || eVar.dTK <= 0) && bdVar.field_msgSvrId > 0) {
            eVar = o.Pf().bq(bdVar.field_msgSvrId);
        }
        if (bdVar.field_isSend == 1 || (eVar != null && bdVar.field_isSend == 0 && eVar.offset >= eVar.dHI && eVar.dHI != 0)) {
            contextMenu.add(i, a$i.AppCompatTheme_spinnerStyle, 0, this.bAG.tTq.getMMResources().getString(R.l.retransmit));
        }
        String o = eVar == null ? "" : o.Pf().o(eVar.dTL, "", "");
        if (eVar != null && com.tencent.mm.a.e.cn(o)) {
            contextMenu.add(i, 112, 0, this.bAG.tTq.getMMResources().getString(R.l.chatting_copy));
        }
    }

    public final void b(long j, int i, int i2) {
        ((g) this.bAG.O(g.class)).i(j, i, i2);
    }

    public final void h(long j, boolean z) {
        ((g) this.bAG.O(g.class)).u(j, z);
    }

    public final void A(String str, int i, String str2) {
        if ((this.lbj == null || !this.lbj.isShowing()) && !bi.oW(str2) && com.tencent.mm.sdk.platformtools.o.Wd(str2)) {
            Bitmap e = com.tencent.mm.sdk.platformtools.c.e(str2, com.tencent.mm.plugin.appbrand.jsapi.p.h.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.p.h.CTRL_INDEX, false);
            if (e == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
                return;
            }
            m mVar = (m) this.bAG.O(m.class);
            View imageView = new ImageView(this.bAG.tTq.getContext());
            int dimensionPixelSize = this.bAG.tTq.getMMResources().getDimensionPixelSize(R.f.LargePadding);
            imageView.setImageBitmap(e);
            imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            String string = Secure.getString(this.bAG.tTq.getContentResolver(), "default_input_method");
            boolean z = com.tencent.mm.sdk.platformtools.o.bv(com.tencent.mm.a.e.e(str2, 0, com.tencent.mm.a.e.cm(str2))) && (string.contains("com.sohu.inputmethod.sogou") || string.contains("com.tencent.qqpinyin"));
            this.lbj = com.tencent.mm.ui.base.h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.chatting_send_img_confirm), imageView, this.bAG.tTq.getMMResources().getString(R.l.app_ok), this.bAG.tTq.getMMResources().getString(R.l.app_cancel), new 3(this, z, mVar, str2), null);
            mVar.cvb().postDelayed(new 4(this, mVar, str.substring(0, i)), 10);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        f(i, i2, intent);
    }

    public final void cpH() {
        o.Pd().dUX = this;
    }

    public final void cpK() {
        o.Pd().dUX = null;
    }
}
