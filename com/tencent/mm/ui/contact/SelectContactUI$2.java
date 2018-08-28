package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class SelectContactUI$2 implements OnClickListener {
    final /* synthetic */ SelectContactUI ulL;
    final /* synthetic */ String ulN;

    SelectContactUI$2(SelectContactUI selectContactUI, String str) {
        this.ulL = selectContactUI;
        this.ulN = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SelectContactUI", "return the result,and create new label");
        Intent intent = new Intent();
        intent.putExtra("Select_Contact", this.ulN);
        intent.putExtra("Select_Conv_User", this.ulN);
        intent.putExtra("Select_Contact", this.ulN);
        intent.putExtra("Select_Contacts_To_Create_New_Label", this.ulN);
        this.ulL.setResult(-1, intent);
        this.ulL.finish();
    }
}
