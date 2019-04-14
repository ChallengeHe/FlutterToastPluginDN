import 'dart:async';

import 'package:flutter/services.dart';

class FlutterToastPluginDn {
  static const MethodChannel _channel =
      const MethodChannel('flutter_toast_plugin_dn');

  static Future<Null> showToast(String msg,
      {String duration, int textColor, double textSize}) async {
    _channel.invokeMethod('showToast', {
      'msg': msg,
      'duration': duration,
      'textColor': textColor,
      'textSize': textSize,
    });
    return null;
  }
}
