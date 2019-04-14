import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_toast_plugin_dn/flutter_toast_plugin_dn.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: RaisedButton(
            onPressed: () {
              FlutterToastPluginDn.showToast(
                'toast plugin',
                duration: 'long',
                textColor: 0xffff0000,
                textSize: 20.0,
              );
            },
            child: Text('showToast'),
          ),
        ),
      ),
    );
  }
}
