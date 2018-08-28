package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ui.applet.SecurityImage.1;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;

public class SecurityImage$a {
    public static SecurityImage a(Context context, int i, int i2, byte[] bArr, String str, String str2, final OnClickListener onClickListener, OnCancelListener onCancelListener, OnDismissListener onDismissListener, b bVar) {
        final SecurityImage securityImage = (SecurityImage) View.inflate(context, h.security_image, null);
        securityImage.setNetworkModel(bVar);
        securityImage.trQ = (ProgressBar) securityImage.findViewById(g.refresh_mini_pb);
        securityImage.trR = (ImageView) securityImage.findViewById(g.authcode_iv);
        securityImage.trS = (Button) securityImage.findViewById(g.authcode_change_btn);
        securityImage.trT = (EditText) securityImage.findViewById(g.authcode_et);
        securityImage.trS.setOnClickListener(new 1(securityImage));
        securityImage.a(i2, bArr, str, str2);
        a aVar = new a(context);
        aVar.Gq(i);
        aVar.Gt(k.app_continue).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                onClickListener.onClick(dialogInterface, i);
            }
        });
        aVar.e(onCancelListener);
        aVar.dR(securityImage);
        aVar.mF(true);
        SecurityImage.a(securityImage, aVar.anj());
        SecurityImage.c(securityImage).setOnDismissListener(onDismissListener);
        SecurityImage.c(securityImage).show();
        return securityImage;
    }
}
