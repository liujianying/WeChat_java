package com.tencent.mm.plugin.account.ui;

import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.mm.plugin.account.model.VoiceActionService;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceActionActivity extends SearchActionVerificationClientActivity {
    public final Class<? extends SearchActionVerificationClientService> rU() {
        x.d("MicroMsg.VoiceActionActivity", "getServiceClass");
        return VoiceActionService.class;
    }
}
