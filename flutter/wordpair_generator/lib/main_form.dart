import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Form App',
        home: Scaffold(
          appBar: AppBar(
            actions: [
              IconButton(
                  onPressed: () => {},
                  icon: Icon(Icons.more_vert, color: Colors.white))
            ],
            title: Text(
              'Application',
              style: TextStyle(color: Colors.white),
            ),
            leading: BackButton(
              color: Colors.white,
            ),
            backgroundColor: Colors.blueGrey,
          ),
          body: Container(
            padding: EdgeInsets.symmetric(horizontal: 10, vertical: 20),
            child: ListView(
              children: [
                Text(
                  'Personal info',
                  style: TextStyle(fontWeight: FontWeight.w500, fontSize: 22),
                ),
                TextFormField(
                  decoration: InputDecoration(hintText: 'First name'),
                ),
                Container(
                  child: TextFormField(
                    decoration: InputDecoration(hintText: 'Last name'),
                  ),
                  padding: EdgeInsets.only(top: 20),
                ),
                Container(
                  margin: EdgeInsets.only(top: 30),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Expanded(
                        child: TextFormField(
                          decoration: InputDecoration(
                              hintText: 'Birthday', helperText: 'MM/DD/YYYY'),
                        ),
                        flex: 3,
                      ),
                      Expanded(
                          child: Padding(
                            padding: EdgeInsets.only(left: 15),
                            child: TextFormField(
                              decoration: InputDecoration(
                                  hintText: 'Social Security',
                                  helperText: '### - ## - ####'),
                            ),
                          ),
                          flex: 2)
                    ],
                  ),
                ),
                Container(
                  child: Text(
                    'Personal info',
                    style: TextStyle(fontWeight: FontWeight.w500, fontSize: 22),
                  ),
                  margin: EdgeInsets.only(top: 30),
                ),
                TextFormField(
                  decoration: InputDecoration(hintText: 'Address'),
                ),
                Container(
                  margin: EdgeInsets.only(top: 20),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Expanded(
                        child: TextFormField(
                          decoration: InputDecoration(
                              hintText: 'City'),
                        ),
                        flex: 3,
                      ),
                      Expanded(
                          child: Padding(
                            padding: EdgeInsets.only(left: 15),
                            child: TextFormField(
                              decoration: InputDecoration(
                                  hintText: 'State', suffixIcon: Icon(Icons.arrow_drop_down)),
                            ),
                          ),
                          flex: 2),
                    ],
                  ),
                ),
                Container(
                  margin: EdgeInsets.only(top: 20),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Expanded(
                        child: TextFormField(
                          decoration: InputDecoration(
                              hintText: 'ZIP Code'),
                        ),
                        flex: 3,
                      ),
                      Expanded(
                          child: Padding(
                            padding: EdgeInsets.only(left: 15),
                            child: TextFormField(
                              decoration: InputDecoration(
                                  hintText: 'Country', suffixIcon: Icon(Icons.arrow_drop_down)),
                            ),
                          ),
                          flex: 2),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ));
  }
}
