package com.example.native_view;


import io.flutter.plugin.common.PluginRegistry.Registrar;

public class TextViewPlugin {
    public static void registerWith(Registrar registrar) {
        registrar
                .platformViewRegistry()
                .registerViewFactory(
                        "com.example.native_view/textview", new TextViewFactory(registrar.messenger()));
    }
}