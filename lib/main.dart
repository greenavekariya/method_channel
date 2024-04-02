import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  static const platform = MethodChannel('toast');

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text('MethodChannel Toast'),
        ),
        body: Center(
          child: ElevatedButton(
            onPressed: () {
              showToast('Hello Welcome Back Home!');
            },
            child: Text('Show Toast'),
          ),
        ),
      ),
    );
  }

  void showToast(String message) async {
    try {
      await platform.invokeMethod('showToast', {'message': message});
    } on PlatformException catch (e) {
      print("Failed to show toast: '${e.message}'.");
    }
  }
}
