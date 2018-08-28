package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.f;
import com.tencent.mm.bp.a;
import com.tencent.mm.ui.base.MaskLayout;

public final class b extends RelativeLayout {
    private TextView contentView = null;
    private Context context;
    private View eLM = null;
    private View ern = null;

    /* renamed from: com.tencent.mm.ui.contact.b$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] uhH = new int[a.values().length];

        static {
            try {
                uhH[a.uhI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                uhH[a.uhJ.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                uhH[a.uhK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public b(Context context, a aVar) {
        super(context);
        this.context = context;
        View.inflate(getContext(), R.i.address_entrance_header_view, this);
        this.ern = findViewById(R.h.container);
        this.eLM = this.ern.findViewById(R.h.addressui_contact_entrance);
        LayoutParams layoutParams = this.eLM.getLayoutParams();
        layoutParams.height = (int) (((float) a.ae(this.context, R.f.ContactListHeight)) * a.fh(this.context));
        this.eLM.setLayoutParams(layoutParams);
        this.contentView = (TextView) this.eLM.findViewById(R.h.addressui_content);
        this.ern.setOnClickListener(new 1(this, aVar));
        this.eLM.setOnTouchListener(new 2(this));
        ImageView imageView = (ImageView) ((MaskLayout) this.eLM.findViewById(R.h.addressui_contact_entrance_avatar_iv)).getContentView();
        switch (AnonymousClass3.uhH[aVar.ordinal()]) {
            case 1:
                this.contentView.setText(R.l.address_chatroom_contact_nick);
                f.a(getContext(), imageView, R.k.default_chatroom);
                return;
            case 2:
                this.contentView.setText(R.l.address_contact_label_nick);
                f.a(getContext(), imageView, R.k.default_contactlabel);
                return;
            case 3:
                this.eLM.setBackgroundResource(R.g.comm_list_item_selector);
                this.contentView.setText(R.l.address_contact_ipcall_nick);
                f.a(getContext(), imageView, R.k.default_ipcall);
                return;
            default:
                return;
        }
    }

    public final void setVisible(boolean z) {
        this.ern.setVisibility(z ? 0 : 8);
    }
}
