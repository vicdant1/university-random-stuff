import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    double blockHeight = (MediaQuery.of(context).size.height - 24) / 6;
    double blockWidth = MediaQuery.of(context).size.width / 4;

    return MaterialApp(
      title: 'Grid App',
      
      home: Scaffold(
        body: GridView.count(crossAxisCount: 4,
        childAspectRatio: blockWidth / blockHeight,
        children: [
          Container(color: Colors.red, ),
          Container(color: Colors.red,),
          Container(color: Colors.red,),
          Container(color: Colors.green,),
          Container(color: Colors.red,),
          Container(color: Colors.red,),
          Container(color: Colors.indigo,),
          Container(color: Colors.yellow,),
          Container(color: Colors.red,),
          Container(color: Colors.green,),
          Container(color: Colors.yellow,),
          Container(color: Colors.yellow,),
          Container(color: Colors.indigo,),
          Container(color: Colors.yellow,),
          Container(color: Colors.yellow,),
          Container(color: Colors.yellow,),
          Container(color: Colors.green,),
          Container(color: Colors.green,),
          Container(color: Colors.red,),
          Container(color: Colors.yellow,),
          Container(color: Colors.green,),
          Container(color: Colors.green,),
          Container(color: Colors.green,),
          Container(color: Colors.indigo,)
        ],
        ),
      )
    );
  }
}
