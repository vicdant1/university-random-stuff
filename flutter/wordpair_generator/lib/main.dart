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
        title: 'Form App',
        home: Scaffold(
          appBar: AppBar(
            actions: [
              IconButton(onPressed: () => {}, icon: Icon(Icons.more_vert, color: Colors.white))
            ],
            title: Text('Application', style: TextStyle(color: Colors.white),),
            leading: BackButton(color: Colors.white,),
            backgroundColor: Colors.blueGrey,
          ),
          body: Container(
            padding: EdgeInsets.symmetric(horizontal: 10, vertical: 20),
            child: ListView(children: [
              Text('Personal info')
            ],),
          ),
        ));
  }
}
