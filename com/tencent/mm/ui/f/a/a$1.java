package com.tencent.mm.ui.f.a;

import android.os.Bundle;
import com.tencent.mm.ui.f.a.a.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

class a$1 implements Runnable {
    final /* synthetic */ String ute;
    final /* synthetic */ Bundle utf;
    final /* synthetic */ String utg;
    final /* synthetic */ a uth;
    final /* synthetic */ Object uti = null;
    final /* synthetic */ a utj;

    public a$1(a aVar, String str, Bundle bundle, String str2, a aVar2) {
        this.utj = aVar;
        this.ute = str;
        this.utf = bundle;
        this.utg = str2;
        this.uth = aVar2;
    }

    public final void run() {
        try {
            this.uth.pF(this.utj.utd.a(this.ute, this.utf, this.utg));
        } catch (FileNotFoundException e) {
            this.uth.a(e);
        } catch (MalformedURLException e2) {
            this.uth.a(e2);
        } catch (IOException e3) {
            this.uth.b(e3);
        }
    }
}
