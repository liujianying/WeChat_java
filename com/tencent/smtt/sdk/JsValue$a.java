package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory;

class JsValue$a implements JsValueFactory {
    private JsValue$a() {
    }

    public String getJsValueClassName() {
        return JsValue.class.getName();
    }

    public IX5JsValue unwrap(Object obj) {
        return (obj == null || !(obj instanceof JsValue)) ? null : JsValue.a((JsValue) obj);
    }

    public Object wrap(IX5JsValue iX5JsValue) {
        if (iX5JsValue != null) {
            JsContext current = JsContext.current();
            if (current != null) {
                return new JsValue(current, iX5JsValue);
            }
        }
        return null;
    }
}
