package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.api.f;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class g implements q {
    private static int[] qIw = new int[]{R.h.title_image_0, R.h.title_image_1, R.h.title_image_2, R.h.title_image_3, R.h.title_image_4, R.h.title_image_5, R.h.title_image_6, R.h.title_image_7, R.h.title_image_8};

    static /* synthetic */ String df(View view) {
        EditText editText = (EditText) view.findViewById(R.h.confirm_dialog_text_et);
        return editText == null ? null : editText.getText().toString();
    }

    static /* synthetic */ int dg(View view) {
        EditText editText = (EditText) view.findViewById(R.h.confirm_dialog_text_et);
        return editText instanceof PasterEditText ? ((PasterEditText) editText).getPasterLen() : 0;
    }

    private static void a(Context context, a aVar, Object obj) {
        if (obj != null) {
            List F;
            if (obj instanceof String) {
                F = bi.F(((String) obj).split(","));
            } else if (obj instanceof List) {
                F = (List) obj;
            } else {
                F = null;
            }
            if (!bi.cX(F)) {
                if (F.size() == 1) {
                    String str = (String) F.get(0);
                    int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(context, (int) (20.0f * com.tencent.mm.bp.a.fe(context)));
                    aVar.R(((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.emoji.b.a.class)).a(context.getString(R.l.retransmit_to_conv_comfirm).toString(), (float) fromDPToPix));
                    String gT = ((b) com.tencent.mm.kernel.g.l(b.class)).gT(str);
                    int fromDPToPix2 = com.tencent.mm.bp.a.fromDPToPix(context, (int) (14.0f * com.tencent.mm.bp.a.fe(context)));
                    if (s.fq(str)) {
                        CharSequence a = ((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.emoji.b.a.class)).a((gT + context.getString(R.l.select_contact_num, new Object[]{Integer.valueOf(((com.tencent.mm.plugin.chatroom.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.chatroom.b.a.class)).gK(str))})).toString(), (float) fromDPToPix2);
                        View inflate = y.gq(context).inflate(R.i.dialog_chatroom_avater_detail, null);
                        GridView gridView = (GridView) inflate.findViewById(R.h.chatroom_avatar_detail);
                        List arrayList = new ArrayList();
                        List gI = ((com.tencent.mm.plugin.chatroom.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.chatroom.b.a.class)).gI(str);
                        aVar.a(str, a, Boolean.valueOf(true), new 1(inflate, arrayList, str, gI), new 7());
                        gridView.setAdapter(new l(context, gI, arrayList));
                        gridView.setSelector(new ColorDrawable(context.getResources().getColor(R.e.transparent)));
                        if (gI != null) {
                            if (gI.size() > 16) {
                                gridView.setLayoutParams(new LayoutParams(-1, com.tencent.mm.bp.a.ad(context, R.f.DialogTitleDetailMaxHeight)));
                                gridView.setPadding(com.tencent.mm.bp.a.ad(context, R.f.DialogEdgePadding), 0, com.tencent.mm.bp.a.ad(context, R.f.DialogEdgePadding), 0);
                            } else {
                                gridView.setPadding(0, 0, 0, com.tencent.mm.bp.a.ad(context, R.f.DialogAvatarLinePadding));
                            }
                        }
                        aVar.uJP.uJg = inflate;
                        return;
                    }
                    aVar.a(str, ((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.emoji.b.a.class)).a(gT.toString(), (float) fromDPToPix2), Boolean.valueOf(false), null, new 11());
                    return;
                }
                aVar.uJP.uJf = d(context, F);
                aVar.abt(context.getString(R.l.multi_retransmit_comfirm));
            }
        }
    }

    private static View d(Context context, List<String> list) {
        View inflate = View.inflate(context, R.i.confirm_dialog_title_multi_image, null);
        if (list != null) {
            int i = 0;
            for (String str : list) {
                if (i <= 8 && inflate != null) {
                    ImageView imageView = (ImageView) inflate.findViewById(qIw[i]);
                    if (str != null) {
                        imageView.setVisibility(0);
                        com.tencent.mm.ui.e.a.a.a(imageView, str);
                        i++;
                    }
                }
                i = i;
            }
        }
        return inflate;
    }

    private static void a(Context context, final c cVar, String str, String str2, final q.a aVar, final q.a aVar2) {
        CharSequence str3;
        CharSequence str22;
        if (bi.oW(str3) || str3.length() == 0) {
            str3 = context.getResources().getString(R.l.confirm_dialog_share);
        }
        if (bi.oW(str22) || str22.length() == 0) {
            str22 = context.getResources().getString(R.l.app_cancel);
        }
        cVar.a(str3, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                cVar.dismiss();
                if (aVar != null) {
                    q.a aVar = aVar;
                    String cAJ = cVar.cAJ();
                    c cVar = cVar;
                    aVar.a(true, cAJ, cVar.im instanceof PasterEditText ? ((PasterEditText) cVar.im).getPasterLen() : 0);
                }
            }
        });
        cVar.b(str22, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                cVar.dismiss();
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
            }
        });
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, String str2, String str3, boolean z, String str4, q.a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(sVar.tml, R.i.confirm_dialog_item1, null);
        a aVar2 = new a(sVar.tml);
        aVar2.mF(false);
        aVar2.mG(false);
        a(aVar2, sVar.tml, str);
        m(inflate, z);
        a(sVar, aVar2, aVar, inflate, str4);
        TextView textView = (TextView) inflate.findViewById(R.h.confirm_dialog_message_tv);
        textView.setText(j.a(sVar.tml, str3, textView.getTextSize()));
        inflate.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
        int b = BackwardSupportUtil.b.b(sVar.tml, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.h.confirm_dialog_thumb_iv);
        if (cdnImageView != null) {
            cdnImageView.ag(str2, b, b);
        }
        aVar2.dR(inflate);
        c anj = aVar2.anj();
        anj.show();
        return anj;
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, String str2, boolean z, String str3, q.a aVar) {
        return a(sVar, str, str2, z, str3, aVar, sVar.tml.getResources().getString(R.l.app_url));
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, String str2, boolean z, String str3, q.a aVar, String str4) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        a aVar2 = new a(sVar.tml);
        String string = sVar.tml.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(sVar.tml, aVar2, bi.F(string.split(",")));
        }
        aVar2.mE(true);
        aVar2.S(str).mF(false).mG(false);
        if (z) {
            aVar2.abw(sVar.tml.getString(R.l.confirm_dialog_edittext_hint));
        }
        c anj = aVar2.anj();
        a(sVar.tml, anj, str3, null, aVar, aVar);
        anj.show();
        return anj;
    }

    public static c b(com.tencent.mm.ui.s sVar, String str, String str2, String str3, String str4, String str5, q.a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(sVar.tml, R.i.confirm_dialog_item1, null);
        a aVar2 = new a(sVar.tml);
        aVar2.mF(false);
        aVar2.mG(false);
        a(aVar2, sVar.tml, str);
        if (inflate != null) {
            EditText editText = (EditText) inflate.findViewById(R.h.confirm_dialog_text_et);
            if (editText != null) {
                editText.setVisibility(0);
            }
            editText.setText(str4);
        }
        a(sVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(R.h.confirm_dialog_message_tv);
        textView.setText(j.a(sVar.tml, str3, textView.getTextSize()));
        inflate.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
        int b = BackwardSupportUtil.b.b(sVar.tml, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.h.confirm_dialog_thumb_iv);
        if (cdnImageView != null) {
            cdnImageView.ag(str2, b, b);
        }
        aVar2.dR(inflate);
        c anj = aVar2.anj();
        anj.show();
        return anj;
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, String str2, q.a aVar) {
        return a(sVar, str, str2, false, "", aVar);
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, boolean z, q.a aVar) {
        return a(sVar, str, z, "", aVar);
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, boolean z, String str2, q.a aVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
            return null;
        }
        a aVar2 = new a(sVar.tml);
        String string = sVar.tml.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(sVar.tml, aVar2, bi.F(string.split(",")));
        }
        aVar2.mE(true);
        aVar2.S(str).mF(false).mG(false);
        if (z) {
            aVar2.abw(sVar.tml.getString(R.l.confirm_dialog_edittext_hint));
        }
        c anj = aVar2.anj();
        a(sVar.tml, anj, str2, null, aVar, aVar);
        anj.show();
        return anj;
    }

    public static c b(com.tencent.mm.ui.s sVar, String str, boolean z, q.a aVar) {
        return b(sVar, str, z, "", aVar);
    }

    public static c b(com.tencent.mm.ui.s sVar, String str, boolean z, String str2, q.a aVar) {
        if (str == null || !e.cn(str)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
            return null;
        }
        a aVar2 = new a(sVar.tml);
        String string = sVar.tml.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(sVar.tml, aVar2, bi.F(string.split(",")));
        }
        aVar2.mE(true);
        aVar2.mF(false).mG(false);
        if (z) {
            aVar2.abw(sVar.tml.getString(R.l.confirm_dialog_edittext_hint));
        }
        if (!bi.oW(str)) {
            Bitmap Wb = com.tencent.mm.sdk.platformtools.c.Wb(str);
            if (Wb != null) {
                aVar2.a(Wb, true, 3);
                a(aVar2, Wb);
                aVar2.mE(false);
            }
        }
        c anj = aVar2.anj();
        a(sVar.tml, anj, str2, null, aVar, aVar);
        anj.show();
        return anj;
    }

    public static c a(com.tencent.mm.ui.s sVar, byte[] bArr, boolean z, q.a aVar) {
        return a(sVar, bArr, z, "", aVar);
    }

    public static c a(com.tencent.mm.ui.s sVar, byte[] bArr, boolean z, String str, q.a aVar) {
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
            return null;
        }
        a aVar2 = new a(sVar.tml);
        String string = sVar.tml.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(sVar.tml, aVar2, bi.F(string.split(",")));
        }
        aVar2.mE(true);
        aVar2.mF(false).mG(false);
        if (z) {
            aVar2.abw(sVar.tml.getString(R.l.confirm_dialog_edittext_hint));
        }
        if (bArr != null && bArr.length > 0) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (decodeByteArray != null) {
                aVar2.a(decodeByteArray, true, 3);
                a(aVar2, decodeByteArray);
                aVar2.mE(false);
            }
        }
        c anj = aVar2.anj();
        a(sVar.tml, anj, str, null, aVar, aVar);
        anj.show();
        return anj;
    }

    public static c b(com.tencent.mm.ui.s sVar, String str, String str2, String str3, q.a aVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem4 fail, title message both are empty");
            return null;
        }
        View Y = Y(sVar.tml, R.i.confirm_dialog_item4);
        a aVar2 = new a(sVar.tml);
        aVar2.mF(false);
        aVar2.mG(false);
        if (Y != null) {
            EditText editText = (EditText) Y.findViewById(R.h.confirm_dialog_text_et);
            if (editText != null) {
                editText.setVisibility(0);
                editText.setHint(bi.oV(str2));
            }
        }
        a(sVar, aVar2, aVar, Y, str3);
        if (!bi.oW(null)) {
            a(aVar2, sVar.tml, null);
        }
        ((TextView) Y.findViewById(R.h.confirm_dialog_title_tv)).setVisibility(8);
        TextView textView = (TextView) Y.findViewById(R.h.confirm_dialog_message_tv);
        textView.setText(j.a(sVar.tml, str, textView.getTextSize()));
        ((TextView) Y.findViewById(R.h.confirm_dialog_content_desc_tv)).setVisibility(8);
        int b = BackwardSupportUtil.b.b(sVar.tml, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) Y.findViewById(R.h.confirm_dialog_thumb_iv);
        if (cdnImageView != null) {
            if (!bi.oW(null)) {
                com.tencent.mm.pluginsdk.ui.a.b.a(cdnImageView, null);
            } else if (bi.oW(null)) {
                cdnImageView.setVisibility(8);
            } else {
                cdnImageView.ag(null, b, b);
            }
        }
        aVar2.dR(Y);
        c anj = aVar2.anj();
        anj.show();
        return anj;
    }

    public static c a(com.tencent.mm.ui.s sVar, int i, String str, boolean z, q.a aVar) {
        return a(sVar, i, str, z, "", aVar);
    }

    public static c a(com.tencent.mm.ui.s sVar, int i, String str, boolean z, String str2, q.a aVar) {
        a aVar2 = new a(sVar.tml);
        String string = sVar.tml.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(sVar.tml, aVar2, bi.F(string.split(",")));
        }
        aVar2.mE(true);
        if (i == R.k.app_attach_file_icon_file) {
            string = sVar.tml.getResources().getString(R.l.app_file);
        } else if (i == R.k.app_attach_file_icon_music) {
            string = sVar.tml.getResources().getString(R.l.app_music);
        } else if (i == R.k.app_attach_file_icon_video) {
            string = sVar.tml.getResources().getString(R.l.app_video);
        } else {
            string = sVar.tml.getResources().getString(R.l.app_app);
        }
        aVar2.S(str).mF(false).mG(false);
        if (z) {
            aVar2.abw(sVar.tml.getString(R.l.confirm_dialog_edittext_hint));
        }
        c anj = aVar2.anj();
        a(sVar.tml, anj, str2, null, aVar, aVar);
        anj.show();
        return anj;
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, boolean z, int i, q.a aVar) {
        return a(sVar, str, z, i, "", aVar);
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, boolean z, int i, String str2, q.a aVar) {
        Object F;
        a aVar2 = new a(sVar.tml);
        String string = sVar.tml.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            F = bi.F(string.split(","));
        } else {
            F = null;
        }
        a(sVar.tml, aVar2, F);
        aVar2.mE(true);
        switch (i) {
            case 1:
                string = sVar.tml.getResources().getString(R.l.app_video);
                break;
            case 2:
                string = sVar.tml.getResources().getString(R.l.app_music);
                break;
            default:
                string = sVar.tml.getResources().getString(R.l.app_app);
                break;
        }
        aVar2.S(new StringBuffer(string).append(str).toString()).mF(false).mG(false);
        if (z) {
            aVar2.abw(sVar.tml.getString(R.l.confirm_dialog_edittext_hint));
        }
        c anj = aVar2.anj();
        a(sVar.tml, anj, str2, null, aVar, aVar);
        anj.show();
        return anj;
    }

    public static c a(com.tencent.mm.ui.s sVar, Bitmap bitmap, String str, String str2, String str3, q.a aVar) {
        View Y = Y(sVar.tml, R.i.confirm_dialog_item4);
        a aVar2 = new a(sVar.tml);
        aVar2.mF(false);
        aVar2.mG(false);
        m(Y, true);
        a(sVar, aVar2, aVar, Y, sVar.tml.getResources().getString(R.l.confirm_dialog_share));
        TextView textView = (TextView) Y.findViewById(R.h.confirm_dialog_title_tv);
        textView.setText(j.a(sVar.tml, str, textView.getTextSize()));
        textView = (TextView) Y.findViewById(R.h.confirm_dialog_message_tv);
        textView.setText(j.a(sVar.tml, str2, textView.getTextSize()));
        textView = (TextView) Y.findViewById(R.h.confirm_dialog_content_desc_tv);
        if (str3 == null || str3.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
            textView.setVisibility(0);
        }
        ImageView imageView = (ImageView) Y.findViewById(R.h.confirm_dialog_thumb_iv);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                x.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap);
                a(aVar2, bitmap);
            }
        }
        aVar2.dR(Y);
        c anj = aVar2.anj();
        anj.show();
        return anj;
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, String str2, String str3, q.a aVar, q.a aVar2) {
        a aVar3 = new a(sVar.tml);
        aVar3.a(com.tencent.mm.compatible.g.a.decodeResource(sVar.tml.getResources(), R.k.dialog_successful_icon), false, 3);
        aVar3.mF(false);
        aVar3.mG(false);
        aVar3.uJP.uIA = str;
        aVar3.Gs(17);
        c anj = aVar3.anj();
        a(sVar.tml, anj, str3, str2, aVar2, aVar);
        anj.Gp(sVar.tml.getResources().getColor(R.e.green_text_color));
        anj.show();
        return anj;
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, Bitmap bitmap, String str2, String str3, int i, q.a aVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
            return null;
        }
        View Y = Y(sVar.tml, R.i.confirm_dialog_item6);
        a aVar2 = new a(sVar.tml);
        aVar2.mF(false);
        aVar2.mG(false);
        m(Y, false);
        a(sVar, aVar2, aVar, Y, sVar.tml.getResources().getString(i));
        TextView textView = (TextView) Y.findViewById(R.h.confirm_dialog_title_tv);
        textView.setText(j.a(sVar.tml, str, textView.getTextSize()));
        textView = (TextView) Y.findViewById(R.h.confirm_dialog_message_tv);
        textView.setText(j.a(sVar.tml, str2, textView.getTextSize()));
        if (str3.length() == 0) {
            Y.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
        } else {
            ((TextView) Y.findViewById(R.h.confirm_dialog_content_desc_tv)).setText(str3);
        }
        ImageView imageView = (ImageView) Y.findViewById(R.h.confirm_dialog_thumb_iv);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setVisibility(4);
            } else {
                imageView.setImageBitmap(bitmap);
                a(aVar2, bitmap);
            }
        }
        aVar2.dR(Y);
        c anj = aVar2.anj();
        anj.show();
        return anj;
    }

    public static o a(com.tencent.mm.ui.s sVar, Bitmap bitmap, String str, final q.a aVar) {
        final View Y = Y(sVar.tml, R.i.confirm_dialog_item7);
        final o de = de(Y);
        a(Y, aVar, de);
        if (bi.oW(str)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem7 fail, message is empty");
            return null;
        }
        TextView textView = (TextView) Y.findViewById(R.h.confirm_dialog_message_tv);
        textView.setText(j.a(sVar.tml, str, textView.getTextSize()));
        Button button = (Button) Y.findViewById(R.h.confirm_dialog_btn1);
        ImageView imageView = (ImageView) Y.findViewById(R.h.confirm_dialog_thumb_iv);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(bitmap);
                de.setOnDismissListener(new 8(bitmap));
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, g.df(Y), g.dg(Y));
                }
                de.dismiss();
                de.setFocusable(false);
                de.setTouchable(false);
            }
        });
        a(sVar, de);
        return de;
    }

    public static o a(com.tencent.mm.ui.s sVar, String str, String str2, String str3, String str4, String str5, final q.a aVar) {
        final View Y = Y(sVar.tml, R.i.confirm_dialog_item8);
        final o de = de(Y);
        a(Y, aVar, de);
        if (bi.oW(str2)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        a(Y, R.h.confirm_dialog_title_tv, str2, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) Y.findViewById(R.h.confirm_dialog_message_tv);
        noMeasuredTextView.setShouldEllipsize(true);
        noMeasuredTextView.setTextSize(0, sVar.tml.getResources().getDimension(R.f.BigTextSize) * com.tencent.mm.bp.a.fe(sVar.tml));
        noMeasuredTextView.setTextColor(com.tencent.mm.bp.a.ac(sVar.tml, R.e.normal_text_color));
        if (bi.oW(str)) {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.emoji.b.a.class)).a(sVar.tml, str3, noMeasuredTextView.getTextSize()));
        } else {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.emoji.b.a.class)).a(sVar.tml, ((b) com.tencent.mm.kernel.g.l(b.class)).gT(str), noMeasuredTextView.getTextSize()));
        }
        a(Y, R.h.confirm_dialog_count_tv, str4, true, 8);
        Button button = (Button) Y.findViewById(R.h.confirm_dialog_btn1);
        if (!bi.oW(str5)) {
            button.setText(str5);
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, g.df(Y), g.dg(Y));
                }
                de.dismiss();
                de.setFocusable(false);
                de.setTouchable(false);
            }
        });
        if (!bi.oW(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) Y.findViewById(R.h.confirm_dialog_thumb_iv), str);
        }
        a(sVar, de);
        return de;
    }

    public static o a(com.tencent.mm.ui.s sVar, long j, String str, String str2, String str3, q.a aVar) {
        View Y = Y(sVar.tml, R.i.confirm_dialog_item8);
        o de = de(Y);
        a(Y, aVar, de);
        if (bi.oW(str)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        CharSequence charSequence;
        String str4;
        String str5;
        a(Y, R.h.confirm_dialog_title_tv, str, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) Y.findViewById(R.h.confirm_dialog_message_tv);
        noMeasuredTextView.setShouldEllipsize(true);
        noMeasuredTextView.setTextSize(0, sVar.tml.getResources().getDimension(R.f.BigTextSize) * com.tencent.mm.bp.a.fe(sVar.tml));
        noMeasuredTextView.setTextColor(com.tencent.mm.bp.a.ac(sVar.tml, R.e.normal_text_color));
        com.tencent.mm.ac.a.c ak = ((f) com.tencent.mm.kernel.g.l(f.class)).ak(j);
        if (ak == null || !ak.isGroup()) {
            com.tencent.mm.ac.a.j cz = ((com.tencent.mm.api.g) com.tencent.mm.kernel.g.l(com.tencent.mm.api.g.class)).cz(ak.field_bizChatServId);
            if (cz != null) {
                charSequence = cz.field_userName;
                str4 = cz.field_headImageUrl;
                str5 = cz.field_brandUserName;
            } else {
                x.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
                return null;
            }
        }
        charSequence = ak.field_chatName;
        str4 = ak.field_headImageUrl;
        str5 = ak.field_brandUserName;
        if (charSequence == null) {
            charSequence = str2;
        }
        if (bi.oW(charSequence)) {
            noMeasuredTextView.setText(j.a(sVar.tml, str2, noMeasuredTextView.getTextSize()));
        } else {
            noMeasuredTextView.setText(j.a(sVar.tml, charSequence, noMeasuredTextView.getTextSize()));
        }
        a(Y, R.h.confirm_dialog_count_tv, null, true, 8);
        Button button = (Button) Y.findViewById(R.h.confirm_dialog_btn1);
        if (!bi.oW(str3)) {
            button.setText(str3);
        }
        button.setOnClickListener(new 16(aVar, Y, de));
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXB = com.tencent.mm.api.a.cy(str5);
        aVar2.dXy = true;
        aVar2.dXV = true;
        aVar2.dXN = R.k.default_avatar;
        com.tencent.mm.ak.a.a.c Pt = aVar2.Pt();
        if (!bi.oW(str4)) {
            com.tencent.mm.ak.o.Pj().a(str4, (ImageView) Y.findViewById(R.h.confirm_dialog_thumb_iv), Pt);
        }
        a(sVar, de);
        return de;
    }

    public static void a(com.tencent.mm.ui.s sVar, String str, String str2, String str3, q.a aVar) {
        a g = new a(sVar.tml).bZ(str).TH(str2).g(Boolean.valueOf(false));
        g.qIG = str3;
        g.a(aVar).eIW.show();
    }

    public static c a(com.tencent.mm.ui.s sVar, String str, View view, String str2, q.b bVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        a aVar = new a(sVar.tml);
        aVar.mF(false);
        aVar.mG(false);
        a(aVar, sVar.tml, str);
        if (bi.oW(str2) || str2.length() == 0) {
            str2 = sVar.tml.getResources().getString(R.l.confirm_dialog_share);
        }
        aVar.abx(str2).a(new 3(bVar));
        aVar.Gu(R.l.app_cancel).b(new 4(bVar));
        aVar.dR(view);
        c anj = aVar.anj();
        anj.Go(sVar.tml.getResources().getColor(R.e.wechat_green));
        anj.show();
        return anj;
    }

    private static View Y(Context context, int i) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
    }

    private static o de(View view) {
        return new o(view, -1, -1);
    }

    private static void a(com.tencent.mm.ui.s sVar, a aVar, q.a aVar2, View view, String str) {
        if (bi.oW(str) || str.length() == 0) {
            str = sVar.tml.getResources().getString(R.l.confirm_dialog_share);
        }
        aVar.abx(str).a(new 17(aVar2, view));
        aVar.Gu(R.l.app_cancel).b(new 2(aVar2));
    }

    private static void a(a aVar, Context context, String str) {
        aVar.abt(str);
        aVar.uJP.qDI = context.getResources().getColor(R.e.normal_text_color);
        aVar.uJP.uJh = 2;
    }

    private static void a(View view, q.a aVar, o oVar) {
        ((Button) view.findViewById(R.h.confirm_dialog_btn1)).setOnClickListener(new 5(aVar, view, oVar));
        Button button = (Button) view.findViewById(R.h.confirm_dialog_btn2);
        if (button != null) {
            button.setOnClickListener(new 6(aVar, oVar));
        }
    }

    private static void m(View view, boolean z) {
        if (view != null) {
            EditText editText = (EditText) view.findViewById(R.h.confirm_dialog_text_et);
            if (editText != null) {
                editText.setVisibility(z ? 0 : 8);
            }
        }
    }

    private static void a(View view, int i, String str, boolean z, int i2) {
        TextView textView = (TextView) view.findViewById(i);
        Assert.assertTrue(textView != null);
        if (z && bi.oW(str)) {
            textView.setVisibility(i2);
        } else {
            textView.setText(str);
        }
    }

    private static void a(com.tencent.mm.ui.s sVar, o oVar) {
        try {
            if (!sVar.tml.isFinishing()) {
                oVar.setInputMethodMode(1);
                oVar.setSoftInputMode(16);
                oVar.setFocusable(true);
                oVar.setTouchable(true);
                oVar.showAtLocation(sVar.tml.getWindow().getDecorView(), 17, 0, 0);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.MMConfirmDialog", e, "", new Object[0]);
        }
    }

    private static void a(a aVar, Bitmap bitmap) {
        aVar.a(new 9(bitmap));
    }
}
